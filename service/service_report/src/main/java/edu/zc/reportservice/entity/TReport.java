package edu.zc.reportservice.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 王晓玲
 * @since 2021-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TReport对象", description="")
public class TReport implements Serializable {

    //显示指定serialVersionUID的值，防止不同的jdk编译java类时serialVersionUID产生不同的值，造成的反序列化时InvalidClassException的异常
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String achievement;

    private String problem;

    private String plan;

    @TableField(fill = FieldFill.INSERT)
    private Date createtime;

    private Integer createman;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    private Integer deleted;


}
