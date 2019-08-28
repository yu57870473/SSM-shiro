package com.ym.controller;

import com.ym.pojo.Menu;
import com.ym.pojo.Users;
import com.ym.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
public class MenuController {
    @Resource
    private MenuService menuService;

    @RequestMapping(value = {"/","index"})
    public String index(HttpSession session){
        Subject subject= SecurityUtils.getSubject();
        Users users = (Users) subject.getPrincipal();
        session.setAttribute("user",users);
        return "index";
    }
    @RequestMapping(value = {"show"})
    @ResponseBody
    public List<Menu> show(){
        return menuService.show();
    }
}
