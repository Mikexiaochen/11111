package com.xc.controller;

import com.xc.pojo.Menu;
import com.xc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = {"/","/index"})
public class IndexController {
    @Autowired
    private MenuService ms;

    @RequestMapping(value = {"/","/index"})
    public String index(HttpSession session, Authentication authentication){
        //根据当前的用户获取指定的权限，放到session中
        //获取当前的用户名
        String adminname=authentication.getName();
        System.out.println("获取当前的用户名："+adminname);

        //根据用户名查询菜单列表
        List<Menu> menuList=ms.findMenuListByAdminName(adminname);
        session.setAttribute("menuList",menuList);

        //将用户名设置到session中，模板页面可以访问到用户
        session.setAttribute("admin_name",adminname);
        return "/index/index";
    }
}
