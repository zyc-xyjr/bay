package com.bm.resource;

import com.bm.entity.User;
import com.bm.model.ResultModel;
import com.bm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/9/18.
 */
@Controller
@RequestMapping("/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    @ResponseBody
    public ResultModel register(User user){
        try{
            User user1 = userService.getUserByUserName(user.getUserName());
            if(user1==null){
                userService.register(user);
                return new ResultModel(0,"成功","");
            }else {
                return new ResultModel(1,"失败","用户名已存在");
            }
        }catch (Exception e){
            return new ResultModel(1,"失败","系统错误");
        }
    }


}
