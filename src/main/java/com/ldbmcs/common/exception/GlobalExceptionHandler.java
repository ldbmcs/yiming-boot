package com.ldbmcs.common.exception;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.ldbmcs.common.base.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.List;
import java.util.Set;

/**
 * 异常处理器
 *
 * @author ldbmcs
 * @date 2019-05-17
 */
@Slf4j
@ControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiResult handleException(Exception e) {
        log.error("系统错误：{}", e.getMessage());
        e.printStackTrace();
        return new ApiResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), "系统异常，请稍后重试。");
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ApiResult handleParamsInvalidException(BusinessException e) {
        log.error("系统错误：{}", e.getMessage());
        e.printStackTrace();
        return new ApiResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    /**
     * 统一处理请求参数校验(实体对象传参)
     *
     * @param e BindException
     * @return ApiResult
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ApiResult validExceptionHandler(BindException e) {
        StringBuilder message = new StringBuilder();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            message.append(error.getField()).append(error.getDefaultMessage()).append(StringPool.COMMA);
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return new ApiResult(HttpStatus.BAD_REQUEST.value(), message.toString());

    }

    /**
     * 统一处理请求参数校验(普通传参)
     *
     * @param e ConstraintViolationException
     * @return ApiResult
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ApiResult handleConstraintViolationException(ConstraintViolationException e) {
        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            Path path = violation.getPropertyPath();
            String[] pathArr = StringUtils.splitByWholeSeparatorPreserveAllTokens(path.toString(), StringPool.DOT);
            message.append(pathArr[1]).append(violation.getMessage()).append(StringPool.COMMA);
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return new ApiResult(HttpStatus.BAD_REQUEST.value(), message.toString());
    }
}
