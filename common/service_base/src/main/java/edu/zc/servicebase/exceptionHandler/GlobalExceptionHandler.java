package edu.zc.servicebase.exceptionHandler;

import edu.zc.commonutils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: keeplooking
 * @Date: 2021/06/21 - 21:13
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    //出现任何异常都能出现这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response error(Exception e){
        e.printStackTrace();
        return  Response.error().message("全局异常处理");
    }

    //特殊异常处理
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Response error(ArithmeticException e){
        e.printStackTrace();
        return Response.error().message("特殊异常处理");
    }

    //自定义异常
    @ExceptionHandler(DiyExceptionHandler.class)
    @ResponseBody
    public Response error(DiyExceptionHandler e){
        log.error(e.getMessage());
//        log.error(e.getMsg());
        e.printStackTrace();
        return Response.error().code(e.getCode()).message(e.getMsg());
    }
}
