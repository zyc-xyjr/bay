package com.bm.config;

/**
 * Created by Administrator on 2016/10/29.
 */

import com.bm.model.ResultModel;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ResourceException {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultModel exception(){
       return  new ResultModel(1,"系统异常错误！",null);
    }
}
