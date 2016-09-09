package cn.wglgg.spring.cloud.web;

import cn.wglgg.spring.cloud.domain.User;
import cn.wglgg.spring.cloud.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by gang on 9/9/16.
 */
@RestController
@RequestMapping("/v1/api/user")
@Api("user相关api")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("添加用户")
    @ApiImplicitParams({
                    @ApiImplicitParam(paramType="query",name="userName",dataType="String",required=true,value="用户的姓名",defaultValue="zhaojigang"),
                    @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户的密码",defaultValue="wangna"),
                    @ApiImplicitParam(paramType="query",name="sex",dataType="Integer",required=false,value="性别",defaultValue="1"),
                    @ApiImplicitParam(paramType="query",name="email",dataType="String",required=false,value="邮箱"),
                    @ApiImplicitParam(paramType="query",name="status",dataType="Integer",required=false,value="状态",defaultValue = "1")
                })
    @PostMapping("/")
    public String postUser(@ModelAttribute User user){
        userService.saveUser(user);
        return "success";
    }

    @GetMapping("/")
    @ApiOperation("获取全部用户信息")
    public Iterable<User> getUserList(){
        return userService.findAll();
    }

    @ApiOperation("根据用户名查询用户")
    @GetMapping("/{userName}")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "userName", dataType = "String", required = true, value = "用户的姓名")
    })
    public User findByUserName(@PathVariable(value = "userName") String userName){
        return userService.findByUserName(userName);
    }
    @ApiOperation("删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "id", dataType = "Long", required = true, value = "用户的姓名")
    })
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id){
        userService.deleteUser(id);
        return "success";
    }


    @ApiOperation("更新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name="userName",dataType="String",required=true,value="用户的姓名"),
            @ApiImplicitParam(paramType="header",name="id",dataType="Long",required=true,value="用户ID"),
            @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户的密码"),
            @ApiImplicitParam(paramType="query",name="sex",dataType="Integer",required=false,value="性别"),
            @ApiImplicitParam(paramType="query",name="email",dataType="String",required=false,value="邮箱"),
            @ApiImplicitParam(paramType="query",name="status",dataType="Integer",required=false,value="状态")
    })
    @PutMapping("/{id}")
    public String updateUser(@ModelAttribute User user){
        userService.updateUser(user);
        return "success";
    }


}
