package edu.zc.reportservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.zc.commonutils.Response;
import edu.zc.reportservice.entity.TReport;
import edu.zc.reportservice.entity.Vo.TReportQuery;
import edu.zc.reportservice.service.TReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 王晓玲
 * @since 2021-07-07
 */
@Api(tags = "周报管理模块")
@RestController
@RequestMapping("/reportservice/t-report")
@CrossOrigin
public class TReportController {
    @Autowired
    private TReportService tReportService;

    @PostMapping("/addReport")
    @ApiOperation(value = "添加周报")
    public Response addReport(@ApiParam(value = "周报对象",required = true)@RequestBody TReport treport){
        boolean add = tReportService.save(treport);
        if(add){
             return Response.ok();
        }else{
            return Response.error();
        }
    }

    @GetMapping("/selectById/{id}")
    @ApiOperation(value = "根据id查询周报")
    public Response selectById(@ApiParam(value = "id",required = true)@PathVariable Integer id){
        TReport tReport = tReportService.getById(id);
        if(tReport != null){
            return Response.ok().data("tReport",tReport);
        }else{
            return Response.error();
        }
    }

//    @PostMapping("/select/{name}")
//    @ApiOperation(value = "条件查询周报")
//    public Response select(@ApiParam(value = "周报名称")@PathVariable String name){
//        List<TReport> allUser = tReportService.getUser(name);
//        if(allUser != null){
//            return Response.ok().data("tReport",allUser);
//        }else{
//            return Response.error();
//        }
//    }
    @PostMapping("/update")
    @ApiOperation(value="根据id更新周报")
    public Response updateById(@ApiParam(name="周报对象",value="tReport",required = true)@RequestBody TReport tReport){
        boolean update = tReportService.updateById(tReport);
        if(update){
            return Response.ok();
        }
        return Response.error();
    }

    @DeleteMapping("/deleteById/{id}")
    @ApiOperation(value = "根据id删除周报")
    public Response deleteById(@ApiParam(value = "周报id",required = true)@PathVariable Integer id){
        boolean tReport = tReportService.removeById(id);
        System.out.println(tReport);
        if(tReport){
            return Response.ok();
        }else{
            return Response.error();
        }
    }

    @GetMapping("/paging/{current}/{limit}")
    @ApiOperation(value = "周报分页")
    public Response pagingDisplay(@ApiParam(name="current",value="当前页",required = true)@PathVariable long current,
                                    @ApiParam(name="limit",value="每页记录数",required = true)@PathVariable long limit){
        Page<TReport> reportPage = new Page<>(current,limit);
        tReportService.page(reportPage,null);
        //获取总记录个数
        long total = reportPage.getTotal();
        //获取所有记录数
        List<TReport> list = reportPage.getRecords();
        Map<String,Object> map = new HashMap<>();
        map.put("total",total);
        map.put("list",list);
        return Response.ok().data(map);
    }

    @PostMapping("/queryPaging/{current}/{limit}")
    @ApiOperation(value = "分页查询周报")
    public Response queryPaging(@ApiParam(name="current",value="当前页",required = true)@PathVariable long current,
                                @ApiParam(name="limit",value="每页记录数",required = true)@PathVariable long limit,
                                @ApiParam(name="treport",value="周报对象")@RequestBody TReportQuery tReportQuery){
        Page<TReport> reportPage = new Page<>(current,limit);
        QueryWrapper<TReport> queryWrapper = new QueryWrapper<>();

        String name = tReportQuery.getName();
        Integer id = tReportQuery.getId();
        String achievement = tReportQuery.getAchievement();
        String plan = tReportQuery.getPlan();
        String problem = tReportQuery.getProblem();
        String createman = tReportQuery.getCreateman();
        String createtime = tReportQuery.getCreatetime();

        if(name != null){
            //第一个参数要求为表中列名
            queryWrapper.like("name",name);
        }
        if(id != null){
            queryWrapper.like("id",id);
        }
        if(achievement != null){
            queryWrapper.like("achievement",achievement);
        }
        if(plan != null){
            queryWrapper.like("plan",plan);
        }
        if(problem != null){
            queryWrapper.like("problem",problem);
        }
        if(createman != null){
            queryWrapper.like("createman",createman);
        }
        if(createtime != null){
            queryWrapper.like("createtime",createtime);
        }

        tReportService.page(reportPage,queryWrapper);
        long total = reportPage.getTotal();
        List<TReport> records = reportPage.getRecords();

        Map<String,Object> map = new HashMap<>();
        map.put("list",records);
        map.put("total",total);
        return Response.ok().data(map);
    }

}

