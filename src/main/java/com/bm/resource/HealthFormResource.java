package com.bm.resource;

import com.bm.model.ResultModel;
import com.bm.service.HealthFormService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResultModel getAllHealthForms( @ApiParam(required = true,name = "userId",value = "用户ID")Long userId){
        return new ResultModel(0,"success",new LinkedHashMap()).put("healthFormList",healthFormService.findAll(userId));
    }

    @RequestMapping("/listByStatus")
    @ResponseBody
    @ApiOperation(value = "根据状态查询体检单列表",httpMethod = "GET")
    public ResultModel getHealthFormsByStatus(@ApiParam(required = false,name = "userId",value = "用户ID")@RequestParam(required = false) Long userId,
                                              @ApiParam(required = true,name = "status",value = "状态（init未处理 processing处理中 complete已处理）")String status){
        return new ResultModel(0,"success",new LinkedHashMap()).put("healthFormList",healthFormService.findByStatus(userId,status));
    }
}
