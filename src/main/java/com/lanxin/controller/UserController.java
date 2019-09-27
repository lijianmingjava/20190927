package com.lanxin.controller;

import com.lanxin.dao.UserDao;
import com.lanxin.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/login")
    public Result login(String username, String password) {

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            Result result = new Result();
            result.setCode("200");
            result.setMsg("登陆成功");
            return result;
        } catch (UnknownAccountException e1) {
            e1.printStackTrace();
            Result result = new Result();
            result.setCode("501");
            result.setMsg("账号错误");
            return result;
        } catch (IncorrectCredentialsException e2) {
            e2.printStackTrace();
            Result result = new Result();
            result.setCode("502");
            result.setMsg("密码错误");
            return result;
        }
    }

    @RequestMapping(value = "/logout")
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        Result result = new Result();
        result.setCode("200");
        result.setMsg("退出成功");
        return result;
    }

    @RequestMapping(value = "/unauth")
    public Result unauth() {
        Result result = new Result();
        result.setCode("555");
        result.setMsg("请确认是否登陆");
        return result;
    }

    @RequestMapping(value = "/select")
    @RequiresRoles(value = {"admin", "root"}, logical = Logical.OR)
    public Result select() {
        Result result = new Result();
        result.setCode("200");
        result.setMsg("查询成功");
        return result;
    }

    @RequestMapping(value = "/insert")
    @RequiresRoles(value = {"root"}, logical = Logical.OR)
    public Result insert() {
        Result result = new Result();
        result.setCode("200");
        result.setMsg("添加成功");
        return result;
    }


}
