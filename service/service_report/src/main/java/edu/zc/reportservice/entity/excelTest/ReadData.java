package edu.zc.reportservice.entity.excelTest;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author: keeplooking
 * @since: 2021/08/03 - 14:33
 */

@Data
@ToString
public class ReadData {
    @ExcelProperty(value = "学生号",index = 0)
    private Integer sno;
    @ExcelProperty(value = "学生名",index = 1)
    private String name;
}
