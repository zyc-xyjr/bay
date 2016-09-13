package com.bm.resource;

import com.bm.entity.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/9/13.
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserResource {

    @RequestMapping("/login")
    public String login(HttpServletRequest request, SysUser sysUser){
        HttpSession session = request.getSession();
        if(sysUser!=null&&"admin".equals(sysUser.getUsername())&&"password".equals(sysUser.getPassword())){
            session.setAttribute("sysUser",sysUser);
            return "redirect:/admin";
        }else {
            return "login";
        }
    }
}
