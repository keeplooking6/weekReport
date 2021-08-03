package edu.zc.reportservice.service.impl;

import com.alibaba.excel.EasyExcel;
import edu.zc.reportservice.entity.TSubject;
import edu.zc.reportservice.entity.excel.TExcelSubject;
import edu.zc.reportservice.listener.SubjectExcelListener;
import edu.zc.reportservice.mapper.TSubjectMapper;
import edu.zc.reportservice.service.TSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.zc.servicebase.exceptionHandler.DiyExceptionHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author 王晓玲
 * @since 2021-08-03
 */
@Service
public class TSubjectServiceImpl extends ServiceImpl<TSubjectMapper, TSubject> implements TSubjectService {

    @Override
    public void saveSubject(MultipartFile file,TSubjectService tSubjectService) {
        try {
            //获取文件的输入流
            InputStream in = file.getInputStream();
            //指定用哪个class读
            EasyExcel.read(in, TExcelSubject.class,new SubjectExcelListener(tSubjectService)).sheet().doRead();

        } catch (IOException e) {
            e.printStackTrace();
            throw new DiyExceptionHandler(20001,"添加课程分类失败");
        }
    }
}
