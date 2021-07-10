package edu.zc.reportservice.entity.Vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: keeplooking
 * @Date: 2021/07/09 - 14:16
 */

@Data
public class TReportQuery {
    @ApiModelProperty(value = "周报id")
    private Integer id;
    @ApiModelProperty(value = "周报名称")
    private String name;
    @ApiModelProperty(value = "成就")
    private String achievement;
    @ApiModelProperty(value = "目前问题")
    private String problem;
    @ApiModelProperty(value = "下周计划")
    private String plan;
    @ApiModelProperty(value = "创建周报的角色")
    private String createman;
    @ApiModelProperty(value = "创建周报的时间")
    private String createtime;
}
