package com.ym.controller;

import com.ym.pojo.Users;
import com.ym.service.UsersService;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class LogController {
    @Resource
    private UsersService usersServiceImpl;

    @RequestMapping("toregister")
    public String toregister(){
        return "register";
    }

    @RequestMapping("register")
    public String register(Users users, MultipartFile file, HttpServletRequest req, RedirectAttributes redirectAttributes) throws IOException {
        String suffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName= UUID.randomUUID().toString()+suffix;
        if(suffix.equalsIgnoreCase(".png")){
            String path=req.getServletContext().getRealPath("image");
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File(path,fileName));
            users.setPhotoname(fileName);
            int i = usersServiceImpl.insUsers(users);
            if(i>0){
                redirectAttributes.addFlashAttribute("result","注册成功!");
                return "redirect:login.jsp";
            }else{
                redirectAttributes.addFlashAttribute("result","注册失败!");
                return "redirect:register.jsp";
            }
        }else{
            redirectAttributes.addFlashAttribute("result","头像文件格式不正确!");
            return "redirect:register.jsp";
        }

    }
    @RequestMapping("login")
    public String login(HttpSession session , HttpServletRequest req){
        String className=(String) req.getAttribute("shiroLoginFailure");
        if(session.getAttribute("user")!=null){
            return "forward:/index";
        }else if(UnknownAccountException.class.getName().equals(className)) {
            req.setAttribute("msg","用户名或密码有误");
            return "login";
        }else if(IncorrectCredentialsException.class.getName().equals(className)) {
            req.setAttribute("msg","用户名或密码有误");
            return "login";
        }else {
            req.removeAttribute("msg");
            return "login";
        }

    }

}
