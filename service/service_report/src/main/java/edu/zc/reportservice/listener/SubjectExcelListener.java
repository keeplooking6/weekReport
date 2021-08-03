package edu.zc.reportservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.zc.reportservice.entity.TSubject;
import edu.zc.reportservice.entity.excel.TExcelSubject;
import edu.zc.reportservice.service.TSubjectService;
import edu.zc.servicebase.exceptionHandler.DiyExceptionHandler;
import edu.zc.servicebase.exceptionHandler.GlobalExceptionHandler;

/**
 * @author: keeplooking
 * @since: 2021/08/03 - 17:05
 */
public class SubjectExcelListener extends AnalysisEventListener<TExcelSubject> {

    //此类不被spring托管，所以不能注入
    public TSubjectService tSubjectService;

    public SubjectExcelListener() {};

    public SubjectExcelListener(TSubjectService tSubjectService) {
        this.tSubjectService = tSubjectService;
    }

    @Override
    public void invoke(TExcelSubject tExcelSubject, AnalysisContext analysisContext) {
        if (tExcelSubject == null) {
            throw new DiyExceptionHandler(20001, "文件数据为空，添加失败");
        }
        //一行一行读取，每次读取都是有两个值，第一个值是一级分类，第二个值是二级分类
        TSubject existsOneSubject = this.existsOne(tSubjectService, tExcelSubject.getOneName());
        if (existsOneSubject == null) {//一级分类中相同名称，添加
            existsOneSubject = new TSubject();
            existsOneSubject.setTitle(tExcelSubject.getOneName());
            existsOneSubject.setParentId("0");
            tSubjectService.save(existsOneSubject);
        }

        TSubject existsTwoSubject = this.existsTwo(tSubjectService,tExcelSubject.getTwoName(),existsOneSubject.getId());
        if(existsTwoSubject == null){
            existsTwoSubject = new TSubject();
            existsTwoSubject.setParentId(existsOneSubject.getId());
            existsTwoSubject.setTitle(tExcelSubject.getTwoName());
            tSubjectService.save(existsTwoSubject);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    //判断一级分类相同，不再添加
    public TSubject existsOne(TSubjectService tSubjectService, String name) {
        QueryWrapper<TSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", "0");
        return tSubjectService.getOne(wrapper);
    }

    //判断二级分类相同，不再添加
    public TSubject existsTwo(TSubjectService tSubjectService, String name, String pid) {
        QueryWrapper<TSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", pid);
        return tSubjectService.getOne(wrapper);
    }
}
