package com.bm.resource;

import com.bm.model.ResultModel;
import com.bm.service.HealthFormService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;

/**
 * Created by Administrator on 2016/11/23.
 */
@Controller
@RequestMapping("/healthForm")
@Api(value = "体检单模块",description = "体检单模块")
public class HealthFormResource {

    @Autowired
    private HealthFormService healthFormService;

    @RequestMapping("/list")
    @ResponseBody
    @ApiOperation(value = "体检单列表",httpMethod = "GET")
    public ResultModel getAllHealthForms(Long userId){
        return new ResultModel(0,"success",new LinkedHashMap()).put("healthFormList",healthFormService.findAll(userId));
    }

    @RequestMapping("/listByStatus")
    @ResponseBody
    @ApiOperation(value = "根据状态查询体检单列表",httpMethod = "GET")
    public ResultModel getHealthFormsByStatus(Long userId,String status){
        return new ResultModel(0,"success",new LinkedHashMap()).put("healthFormList",healthFormService.findByStatus(userId,status));
    }
}
