package edu.zc.reportservice.service;

import edu.zc.reportservice.entity.TSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author 王晓玲
 * @since 2021-08-03
 */
public interface TSubjectService extends IService<TSubject> {

    public void saveSubject(MultipartFile file,TSubjectService tSubjectService);
}
