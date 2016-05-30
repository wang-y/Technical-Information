package com.wy.spring.boot.jpa.demo.controller;


import com.wy.spring.boot.jpa.demo.aop.annotation.SysLog;
import com.wy.spring.boot.jpa.demo.model.User;
import com.wy.spring.boot.jpa.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lenovo on 2016/5/4.
 */
@EnableAutoConfiguration
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @RequestMapping(value = "/index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response,String loginName) throws Exception{
       return new  ModelAndView("index");
    }

    @RequestMapping(value = "/datasource2")
    @ResponseBody
    public Page<User> datasource2(HttpServletRequest request, HttpServletResponse response,String loginName) throws Exception{
        Pageable p=new PageRequest(0,10);
        Page<User> users=userServiceImpl.findAll(p);
        return users;
    }

    @RequestMapping(value = "/datasource1")
    @ResponseBody
    public Page<User> datasource1(HttpServletRequest request, HttpServletResponse response,String loginName) throws Exception{
        Pageable p=new PageRequest(0,10);
        Page<User> users=userServiceImpl.findAbAll(p);
        return users;
    }

    @RequestMapping(value = "/save")
    @SysLog("保存用户")
    public void save(HttpServletRequest request, HttpServletResponse response,User user) throws Exception{
        userServiceImpl.save(user);
    }
}
