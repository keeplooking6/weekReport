package edu.zc.reportservice.entity.excelTest;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: keeplooking
 * @since: 2021/08/03 - 14:35
 */
public class ExcelListener extends AnalysisEventListener<ReadData> {

    List<ReadData> list = new ArrayList<>();

    //    一行一行的读取内容
    @Override
    public void invoke(ReadData user, AnalysisContext analysisContext) {
        System.out.println("---" + user);
//        list.add(user);
    }

//    读取表头的内容
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头信息："+headMap);
    }

    //
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
