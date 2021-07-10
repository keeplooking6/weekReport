package edu.zc.reportservice.entity.Vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: keeplooking
 * @Date: 2021/07/10 - 11:01
 */
@Data
public class TUserQuery {
    @ApiModelProperty(value="用户id")
    private Integer id;
    @ApiModelProperty(value="用户名")
    private String uname;
    @ApiModelProperty(value="用户密码")
    private String upass;
    @ApiModelProperty(value="用户roleid")
    private Integer roleid;
    @ApiModelProperty(value="用户性别")
    private String gender;

}
