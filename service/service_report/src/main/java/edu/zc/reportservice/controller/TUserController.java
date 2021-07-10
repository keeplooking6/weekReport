package edu.zc.reportservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.zc.commonutils.Response;
import edu.zc.reportservice.entity.TReport;
import edu.zc.reportservice.entity.TUser;
import edu.zc.reportservice.entity.Vo.TUserQuery;
import edu.zc.reportservice.service.TUserService;
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
 * 前端控制器
 * </p>
 *
 * @author 王晓玲
 * @since 2021-07-07
 */

@Api(tags = "登录和用户信息·")
@RestController
@RequestMapping("/reportservice")
@CrossOrigin
public class TUserController {
    @Autowired
    private TUserService tUserService;

    //login
    @ApiOperation(value = "登录")
    @PostMapping("login")
    public Response login() {
        return Response.ok().data("token", "admin");
    }
//    @ApiOperation(value = "登录")
//    @PostMapping("login")
//    public Response login(@ApiParam(name="name",value="用户名")@RequestBody String username,
//                          @ApiParam(name="password",value="密码")@RequestBody String password){
//        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("username",username);
//        queryWrapper.eq("password",password);
//        TUser tUser = tUserService.getOne(queryWrapper);
//        if(tUser != null){
//            return Response.ok().data("token","admin");
//        }
//        return Response.error();
//    }

    //info
    @ApiOperation(value = "获取用户信息")
    @GetMapping("info")
    public Response info() {
        return Response.ok()
                .data("roles", "admin")
                .data("name", "admin")
//                .data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif")
                .data("avatar", "https://pic-img-21.oss-cn-hangzhou.aliyuncs.com/img/avatar.jpg")
                .data("introduction", "This is admin!");
    }

    //logout
    @ApiOperation(value = "退出")
    @PostMapping("logout")
    public Response logout() {
        return Response.ok()
                .data("token", "admin")
                .data("roles", "admin");
    }

    //查找用户
    @ApiOperation(value = "查找用户")
    @PostMapping("/select/{current}/{limit}")
    public Response select(@ApiParam(name = "current", value = "当前页",required = true) @PathVariable long current,
                           @ApiParam(name = "limit", value = "每页记录数",required = true) @PathVariable long limit,
                           @ApiParam(name = "tUserQuery", value = "用户对象") @RequestBody TUserQuery tUserQuery) {

        Page<TUser> pageUser = new Page<>(current, limit);
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        Integer id = tUserQuery.getId();
        String uname = tUserQuery.getUname();
        String gender = tUserQuery.getGender();
        Integer roleid = tUserQuery.getRoleid();
        String pwd = tUserQuery.getUpass();

        if (id != null) {
            wrapper.like("id", id);
        }
        if (uname != null) {
            wrapper.like("uname", uname);
        }
        if (pwd != null) {
            wrapper.like("upass", pwd);
        }
        if (gender != null) {
            wrapper.like("gender", gender);
        }
        if (roleid != null) {
            wrapper.like("roleid", roleid);
        }

        tUserService.page(pageUser, wrapper);
        long total = pageUser.getTotal();
        List<TUser> records = pageUser.getRecords();

        return Response.ok().data("total", total).data("list", records);
    }

    //添加用户
    @ApiOperation(value = "注册用户")
    @PostMapping("/add")
    public Response add(@RequestBody TUser u) {
        System.out.println(u);
        boolean save = tUserService.save(u);
        if (save) {
            return Response.ok();
        }
        return Response.error();
    }

    //删除用户
    @ApiOperation(value = "注销用户")
    @DeleteMapping("/delete/{id}")
    public Response delete(@ApiParam(name = "用户id", value = "id") @PathVariable Integer id) {
        boolean save = tUserService.removeById(id);
        if (save) {
            return Response.ok();
        }
        return Response.error();
    }
    //修改用户信息
    @PostMapping("/update")
    @ApiOperation(value="根据id更新用户")
    public Response updateById(@ApiParam(name="用户对象",value="tUser",required = true)@RequestBody TUser tUser){
        boolean update = tUserService.updateById(tUser);
        if(update){
            return Response.ok();
        }
        return Response.error();
    }

    @GetMapping("/select/{id}")
    @ApiOperation(value = "根据id查询用户")
    public Response selectById(@ApiParam(value = "id",required = true)@PathVariable Integer id){
        TUser tUser = tUserService.getById(id);
        if(tUser != null){
            return Response.ok().data("tUser",tUser);
        }else{
            return Response.error();
        }
    }
}

