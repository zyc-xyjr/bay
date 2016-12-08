package com.bm.resource;

import com.bm.model.ResultModel;
import com.bm.service.CheckResultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;

/**
 * Created by Administrator on 2016/11/28.
 */
@Controller
@RequestMapping("/result")
public class CheckResultResource {

    @Autowired
    private CheckResultService checkResultService;

    @RequestMapping("/list")
    @ResponseBody
    public ResultModel getCheckResultList(Long healthFormId){
        return new ResultModel(0,"success",new LinkedHashMap()).put("resultList",checkResultService.getCheckResultList(healthFormId));
    }

}
