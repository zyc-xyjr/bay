package com.bm.resource;

import com.bm.dao.RelationDao;
import com.bm.entity.Relations;
import com.bm.model.ResultModel;
import com.bm.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.LinkedHashMap;
import java.util.List;


/**
 * Created by Administrator on 2016/12/15.
 */
@RestController
@RequestMapping("/push")
public class PushResource {

    @Autowired
    private RelationDao relationDao;
    @Autowired
    private PushService pushService;

    @RequestMapping({"/app/push/ucbind"})
    @ResponseBody
    public ResultModel bindUserCilentId(@RequestParam Long uid,
                                @RequestParam String cid){
        try {
            if(StringUtils.isEmpty(uid)||StringUtils.isEmpty(cid)){
                return new ResultModel(1,"非法字段格式为空",new LinkedHashMap());
            }
            List<Relations> ucRelationList = relationDao.getRelationList(uid);
            if(ucRelationList==null||ucRelationList.size()==0){
                Relations ucRelation = new Relations();
                ucRelation.setCilentId(cid);
                ucRelation.setUserId(uid);
                relationDao.save(ucRelation);
            }
            return new ResultModel(0,"success",new LinkedHashMap());
        }catch (Exception e){
            return new ResultModel(1,"error",new LinkedHashMap());
        }
    }

    @RequestMapping("/app/push/sendMsg")
    @ResponseBody
    public ResultModel pushMessage(@RequestParam String cid,
                           @RequestParam Long templateId){
        return pushService.pushMsg(cid,templateId);
    }

}
