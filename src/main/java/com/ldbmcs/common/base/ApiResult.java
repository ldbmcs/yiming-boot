package com.ldbmcs.common.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 统一API响应结果封装
 *
 * @author ldbmcs
 * @date 2020/5/13
 */
@Data
public class ApiResult<E> {

    /**
     * 状态码
     */
    @ApiModelProperty(value = "状态码", required = true, notes = "状态码", example = "000000")
    private Integer code;

    /**
     * 错误原因
     */
    @ApiModelProperty(value = "错误原因", required = true, notes = "错误原因", example = "登陆成功")
    private String msg;

    /**
     * 返回的数据
     */
    private E data;

    ApiResult() {
    }

    public ApiResult(String msg) {
        this.msg = msg;
    }

    public ApiResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}