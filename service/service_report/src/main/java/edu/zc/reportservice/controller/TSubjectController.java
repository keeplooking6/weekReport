package edu.zc.reportservice.controller;


import edu.zc.commonutils.Response;
import edu.zc.reportservice.service.TSubjectService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author 王晓玲
 * @since 2021-08-03
 */

@Api(tags = "其他项目测试")
@RestController
@RequestMapping("/reportservice/t-subject")
@CrossOrigin
public class TSubjectController {
    @Autowired
    private TSubjectService subjectService;

    @PostMapping("/addSubject")
    public Response addSubject(MultipartFile file){
        subjectService.saveSubject(file,subjectService);
        return Response.ok().message("添加课程分类成功了哦");
    }
}

