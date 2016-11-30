package com.bm.resource;

import com.bm.entity.CheckEntryItem;
import com.bm.entity.CheckResult;
import com.bm.model.ResultModel;
import com.bm.service.CheckEntryItemService;
import com.bm.service.CheckResultService;
import com.sun.tools.jdi.LinkedHashMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/list")
    @ResponseBody
    @ApiOperation(value = "各项检查结果列表",httpMethod = "GET")
    public ResultModel getCheckResultList( @ApiParam(required = true,name = "healthFormId",value = "体检单ID")Long healthFormId){
        return new ResultModel(0,"success",new LinkedHashMap()).put("resultList",checkResultService.getCheckResultList(healthFormId));
    }


    @RequestMapping("/check")
    @ResponseBody
    @ApiOperation(value = "检查项诊断",httpMethod = "POST")
    public ResultModel getCheckResultList( @ApiParam(required = true,name = "healthFormId",value = "体检单ID")Long healthFormId,
                                           @ApiParam(required = true,name = "entryId",value = "检查项ID")Long entryId,
                                           @ApiParam(required = true,name = "checkValue",value = "实际检查值")Float checkValue){

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
                    checkResultService.saveCheckResult(checkResult);
                    return new ResultModel(0,"success",new LinkedHashMap()).put("checkResultItem",checkEntryItem);
            }
            }
        }
        return new ResultModel(0,"success",new LinkedHashMap());
    }
}
