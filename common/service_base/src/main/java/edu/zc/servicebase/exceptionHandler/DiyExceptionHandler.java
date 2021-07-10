package edu.zc.servicebase.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: keeplooking
 * @Date: 2021/06/22 - 16:15
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiyExceptionHandler extends RuntimeException{
    private Integer code;
    private String msg;
}
