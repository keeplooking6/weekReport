package edu.zc.reportservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: keeplooking
 * @Date: 2021/07/07 - 20:49
 */
@SpringBootApplication
@ComponentScan(basePackages = {"edu.zc"})
@MapperScan("edu.zc.reportservice.mapper")
public class ReportApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReportApplication.class, args);
    }
}
