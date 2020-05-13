package com.ldbmcs.common.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

/**
 * Controller基类
 *
 * @author ldbmcs
 * @date 2019-05-09
 */
@Slf4j
public class BaseController {

    /**
     * 返回成功
     *
     * @return ApiResult<Object>
     */
    public ApiResult success() {
        ApiResult apiResult = new ApiResult<>();
        apiResult.setMsg(HttpStatus.OK.getReasonPhrase());
        apiResult.setCode(HttpStatus.OK.value());
        return apiResult;
    }

    /**
     * 返回成功
     *
     * @param object 返回data
     * @return ApiResult<Object>
     */
    public ApiResult success(Object object) {
        ApiResult apiResult = new ApiResult();
        apiResult.setMsg(HttpStatus.OK.getReasonPhrase());
        apiResult.setCode(HttpStatus.OK.value());
        apiResult.setData(object);
        return apiResult;
    }
}
