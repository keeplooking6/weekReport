package edu.zc.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: keeplooking
 * @Date: 2021/06/16 - 13:29
 */

@Data
public class Response {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    public Response(){};

    public static Response ok(){
        Response r = new Response();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    public static Response error(){
        Response r = new Response();
        r.setSuccess(false);
        r.setCode(ResultCode.FAILURE);
        r.setMessage("失败");
        return r;
    }

    public Response success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public Response message(String message){
        this.setMessage(message);
        return this;
    }

    public Response code(Integer code){
        this.setCode(code);
        return this;
    }

    public Response data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public Response data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

}
