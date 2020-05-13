package com.ldbmcs.common.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 统一API响应分页结果封装
 *
 * @author ldbmcs
 * @date 2020/5/13
 */
@Data
public class PageResult<T> {

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
    private List<T> data;

    /**
     * 总数量
     */
    private long count;

    public PageResult() {
    }

    public PageResult(List<T> rows) {
        this.data = rows;
        this.count = rows.size();
        this.code = 200;
        this.msg = "";
    }

    public PageResult(List<T> rows, long total) {
        this.count = total;
        this.data = rows;
        this.code = 200;
        this.msg = "";
    }
}