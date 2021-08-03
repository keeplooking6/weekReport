package edu.zc.reportservice.entity.excelTest;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author: keeplooking
 * @since: 2021/08/01 - 18:14
 */

@Data
@ToString
public class Excel {
    @ExcelProperty("学生编号")
    private Integer sno;
    @ExcelProperty("学生姓名")
    private String name;
}
