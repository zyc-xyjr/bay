package com.bm.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/9/8.
 */
@Controller
public class IndexResource {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
