package edu.zc.reportservice.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author: keeplooking
 * @since: 2021/08/03 - 16:25
 */

@Data
@ToString
public class TExcelSubject {
    @ExcelProperty(value = "一级分类", index = 0)
    private String oneName;
    @ExcelProperty(value = "二级分类",index = 1)
    private String twoName;
}
