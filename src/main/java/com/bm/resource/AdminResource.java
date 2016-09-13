package com.bm.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/9/8.
 */
@Controller
public class AdminResource {

    @RequestMapping("/admin")
    public String index(){
        return "home";
    }

    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    }

    @RequestMapping("/admin/ftl/{directory}/{ftl}")
    public String resultView(@PathVariable String directory,
                        @PathVariable String ftl){
        return directory+"/"+ftl;
    }
}
