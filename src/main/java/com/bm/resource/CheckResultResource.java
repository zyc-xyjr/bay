package com.bm.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bm.entity.CheckEntryItem;
import com.bm.entity.CheckResult;
import com.bm.entity.CheckResultList;
import com.bm.entity.HealthForm;
import com.bm.model.ResultModel;
import com.bm.service.CheckEntryItemService;
import com.bm.service.CheckResultService;
import com.bm.service.HealthFormService;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */
@Controller
@RequestMapping("/result")
@Api(value = "result",description = "体检单各项检查结果模块")
public class CheckResultResource {

    @Autowired
    private CheckResultService checkResultService;

    @Autowired
    private CheckEntryItemService checkEntryItemService;

    @Autowired
    private HealthFormService healthFormService;

    @RequestMapping("/list")
    @ResponseBody
    @ApiOperation(value = "各项检查结果列表",httpMethod = "GET")
    public ResultModel getCheckResultList( @ApiParam(required = true,name = "healthFormId",value = "体检单ID")Long healthFormId){
        return new ResultModel(0,"success",new LinkedHashMap()).put("resultList",checkResultService.getCheckResultList(healthFormId));
    }


    @RequestMapping("/check")
    @ResponseBody
    @ApiOperation(value = "检查项诊断",httpMethod = "POST")
    public ResultModel doCheckResult( @ApiParam(required = true,name = "healthFormId",value = "体检单ID")Long healthFormId,
                                           @ApiParam(required = true,name = "entryId",value = "检查项ID")Long entryId,
                                           @ApiParam(required = true,name = "checkValue",value = "实际检查值")Float checkValue){

        HealthForm healthForm = healthFormService.getById(healthFormId);
        healthForm.setStatus("processing");
        healthFormService.saveHelthForm(healthForm);
        List<CheckEntryItem> checkEntryItemList = checkEntryItemService.entryItemsByEntryId(entryId);
        if (checkEntryItemList!=null&&checkEntryItemList.size()>0){
            for (CheckEntryItem checkEntryItem : checkEntryItemList){
                if (checkValue<checkEntryItem.getBigValue()&&checkValue>checkEntryItem.getSmallValue()){

                    CheckResult checkResult = checkResultService.getCheckResult(healthFormId,entryId);
                    if (checkResult==null){
                        checkResult.setEntryId(entryId);
                        checkResult.setHealthFormId(healthFormId);
                    }
                    checkResult.setCheckValue(checkValue);
                    checkResult.setItemId(checkEntryItem.getId());
                 /*   checkResult.setClinicDepartment(checkEntryItem.getClinicDepartment());
                    checkResult.setLifeGuidance(checkEntryItem.getLifeGuidance());
                    checkResult.setMedicalAdvice(checkEntryItem.getMedicalAdvice());
                    checkResult.setAnalysis(checkEntryItem.getAnalysis());*/
                    checkResultService.saveCheckResult(checkResult);
                    return new ResultModel(0,"success",new LinkedHashMap()).put("checkResult",checkResult);
            }
            }
        }
        return new ResultModel(0,"success",new LinkedHashMap());
    }

    @RequestMapping("/checkAll")
    @ResponseBody
    @ApiOperation(value = "检查项诊断",httpMethod = "POST")
    public ResultModel doAllCheckResult( @ApiParam(required = true,name = "healthFormId",value = "体检单ID")Long healthFormId,
                                           @ApiParam(required = true,name = "checkResultStrs",value = "检查项和检查结果数组字符串")String checkResultStrs){

        checkResultStrs="[\n  {\n    \"entryId\" : \"17\",\n    \"checkValue\" : \"85.7\"\n  }\n]";
        List jsonList = (List) JSON.parse(checkResultStrs);
        List<CheckResult> checkResults = new ArrayList<>(jsonList.size());
        if (jsonList!=null&&jsonList.size()>0){
            for (Object obj : jsonList) {
                checkResults.add(JSONObject.parseObject(obj.toString(), CheckResult.class));
            }
        }

        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        StringBuffer s3 = new StringBuffer();
        StringBuffer s4 = new StringBuffer();

        for (CheckResult checkResult:checkResults){
            checkResult.setHealthFormId(healthFormId);
            CheckResult result = checkResultService.getCheckResult(healthFormId,checkResult.getEntryId());
            if (result!=null){
                checkResult.setId(result.getId());
            }
            checkResultService.saveCheckResult(checkResult);
            List<CheckEntryItem> checkEntryItemList = checkEntryItemService.entryItemsByEntryId(checkResult.getEntryId());
            if (checkEntryItemList!=null&&checkEntryItemList.size()>0){
                for (CheckEntryItem checkEntryItem : checkEntryItemList){
                    if (checkResult.getCheckValue()<checkEntryItem.getBigValue()&&checkResult.getCheckValue()>checkEntryItem.getSmallValue()){
                      /*  checkResult.setItemId(checkEntryItem.getId());
                        checkResultService.saveCheckResult(checkResult);*/
                        s1.append(checkEntryItem.getClinicDepartment());
                        s2.append(checkEntryItem.getLifeGuidance());
                        s3.append(checkEntryItem.getMedicalAdvice());
                        s4.append(checkEntryItem.getAnalysis());
                    }
                }
            }
        }
        HealthForm healthForm = healthFormService.getById(healthFormId);
        healthForm.setStatus("processing");

        healthForm.setClinicDepartment(s1.toString());
        healthForm.setLifeGuidance(s2.toString());
        healthForm.setMedicalAdvice(s3.toString());
        healthForm.setAnalysis(s4.toString());
        healthFormService.saveHelthForm(healthForm);
        return new ResultModel(0,"success",new LinkedHashMap()).put("healthForm",healthForm);
    }


    @RequestMapping("/query")
    @ResponseBody
    @ApiOperation(value = "查询诊断结果",httpMethod = "GET")
    public ResultModel getCheckResults( @ApiParam(required = true,name = "healthFormId",value = "体检单ID")Long healthFormId){

        return new ResultModel(0,"success",new LinkedHashMap()).
                put("resultList",checkResultService.getCheckResultList(healthFormId)).
                put("healthForm",healthFormService.getById(healthFormId));

    }
}
