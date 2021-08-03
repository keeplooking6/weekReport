package edu.zc.reportservice;

import com.alibaba.excel.EasyExcel;
import edu.zc.reportservice.entity.excelTest.Excel;
import edu.zc.reportservice.entity.excelTest.ExcelListener;
import edu.zc.reportservice.entity.excelTest.ReadData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: keeplooking
 * @since: 2021/08/01 - 18:20
 */
public class TestEasyExcel {
    public static void main(String[] args) {
//        write();
        read();
    }

    private static void read() {
        String filename = "C:\\Users\\keeplooking\\Desktop\\2.xlsx";
        EasyExcel.read(filename, ReadData.class,new ExcelListener()).sheet().doRead();
    }

    public static void write(){
        String filename = "C:\\Users\\keeplooking\\Desktop\\2.xlsx";
        EasyExcel.write(filename, Excel.class).sheet("学生列表").doWrite(getData());
    }

    private static List<Excel> getData() {
        List<Excel> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            Excel excel = new Excel();
            excel.setSno(i);
            excel.setName("张q三"+i);
            list.add(excel);
        }
        return list;
    }

}
