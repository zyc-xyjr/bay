package com.bm.resource;

import com.bm.entity.SessionEntity;
import com.bm.entity.User;
import com.bm.model.ResultModel;
import com.bm.service.SMSService;
import com.bm.service.SessionService;
import com.bm.service.UserService;
import com.bm.utils.CodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/18.
 */
@Controller
@RequestMapping("/user")
@Api(value = "user",description = "用户模块")
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private SMSService smsService;

    @Autowired
    private SessionService sessionService;

    /**
     * 用户注册
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    @ApiOperation(value = "用户注册",httpMethod = "POST")
    public ResultModel register(
            @ApiParam(required = true,name = "userName",value = "用户名（手机号）") String mobile,
            @ApiParam(required = true,name = "password",value = "密码") String password
            ){
        try{
            User user = userService.getUserByUserName(mobile);
            if(user==null){
                user = new User();
                user.setUserName(mobile);
                user.setPassword(password);
                userService.register(user);
                return new ResultModel(0,"success","");
            }else {
                return new ResultModel(1,"用户名已存在","");
            }
        }catch (Exception e){
            return new ResultModel(1,"系统错误","");
        }
    }

    /**
     * 验证码发送成功
     * @param request
     * @param mobile
     * @return
     */
    @RequestMapping("/send/validCode")
    @ResponseBody
    @ApiOperation(value = "发送验证码",httpMethod = "GET")
    public ResultModel sendValidCode(HttpServletRequest request,
                                     @ApiParam(required = true,name = "mobile",value = "手机号") String mobile){
        try{

            String code = CodeUtil.getRandomStr(4);
            SessionEntity entiry = this.sessionService.getSessionEntity(mobile,0);
            if (entiry==null){
                entiry = new SessionEntity(mobile,code,0,1,new Date());
            }else {
                entiry.setStartTime(new Date());
                entiry.setContext(code);
            }
            sessionService.saveSessionEntiry(entiry);
            smsService.sendAuthCode(mobile, code);
            return new ResultModel(0,"success",code);
        }catch (Exception e){
            return new ResultModel(1,"系统错误","");
        }
    }

    /**
     * 检查 验证码
     * @param request
     * @param mobile
     * @return
     */
    @RequestMapping("/check/validCode")
    @ResponseBody
    @ApiOperation(value = "检查验证码",httpMethod = "POST")
    public ResultModel checkValidCode(HttpServletRequest request,
                                      @ApiParam(required = true,name = "mobile",value = "手机号")String mobile,
                                      @ApiParam(required = true,name = "code",value = "验证码")String code){
        try{
            SessionEntity sessionEntity = this.sessionService.getSessionEntity(mobile,0);
            if (sessionEntity==null||!code.equals(sessionEntity.getContext())){
                return new ResultModel(1,"验证码不正确","");
            }else {
                sessionEntity.setStatus(0);
                this.sessionService.saveSessionEntiry(sessionEntity);
                return new ResultModel(0,"success","");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResultModel(1,"系统错误","");
        }
    }

    /**
     * 用户登录
     * @param request
     * @param mobile
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    @ApiOperation(value = "用户登录",httpMethod = "POST")
    public ResultModel login(HttpServletRequest request,
                                      @ApiParam(required = true,name = "mobile",value = "手机号")String mobile,
                                      @ApiParam(required = true,name = "password",value = "密码")String password){
        try{
            User user = userService.getLoginUser(mobile,password);
            if(user==null){
                return new ResultModel(1,"用户名和密码不匹配","");
            }else {
                SessionEntity sessionEntity = new SessionEntity(mobile,user.getId()+"",1,1,new Date());
                sessionService.saveSessionEntiry(sessionEntity);
                return new ResultModel(0,"success",user);
            }
        }catch (Exception e){
            return new ResultModel(1,"系统错误","");
        }
    }


}
