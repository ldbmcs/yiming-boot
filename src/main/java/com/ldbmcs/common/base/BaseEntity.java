package com.ldbmcs.common.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.Instant;

/**
 * 基础实体类
 *
 * @author ldbmcs
 * @date 2020/5/13
 */
@Data
public class BaseEntity {

    @ApiModelProperty(value = "主键id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "新增时间")
    private Long createTime = Instant.now().getEpochSecond();

    @ApiModelProperty(value = "修改时间")
    private Long updateTime = 0L;

    @ApiModelProperty(value = "是否删除(1 正常  2删除)")
    private Integer deleteStatus = 1;

    @ApiModelProperty(value = "删除时间")
    private Long deleteTime = 0L;
}
