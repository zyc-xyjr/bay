package com.bm.service.impl;

import com.bm.dao.PushMessageDao;
import com.bm.dao.RelationDao;
import com.bm.entity.AppPushMessage;
import com.bm.entity.Relations;
import com.bm.model.ResultModel;
import com.bm.service.PushService;
import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.ListMessage;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 */
@Service("pushService")
public class PushServiceImpl implements PushService {

    //定义常量, appId、appKey、masterSecret 采用本文档 "第二步 获取访问凭证 "中获得的应用配置
    private static String appId = "V1HntleeBs9u1J8yyHvH66";
    private static String appKey = "fZcfe8oK6V7Xl6G5vQyWy1";
    private static String masterSecret = "dhRafIPB279QCTqqCmZ3v1";
    private static String url = "http://sdk.open.api.igexin.com/apiex.htm";

    @Autowired
    private PushMessageDao pushMessageDao;

    @Autowired
    private RelationDao relationDao;

    @Override
    public ResultModel pushMsg(String cid, Long templateId) {
        IGtPush push = new IGtPush(url, appKey, masterSecret);

        AppPushMessage msg = pushMessageDao.findOne(templateId);
        // 定义"点击链接打开通知模板"，并设置标题、内容、链接
        TransmissionTemplate template = new TransmissionTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        if(msg!=null){
            template.setTransmissionContent(msg.toString());
        }

        //返回结果
        IPushResult ret = null;
        if(StringUtils.isEmpty(cid)){

            // 定义"ListMessage"类型消息对象，设置消息内容模板、发送的目标App列表、是否支持离线发送、以及离线消息有效期(单位毫秒)
            ListMessage message = new ListMessage();
            message.setData(template);
            message.setOffline(true);
            message.setOfflineExpireTime(1000 * 600);
            //群推送目标列表
            List<Relations> ucRelationList = (List<Relations>) relationDao.findAll();
            if(ucRelationList!=null&&ucRelationList.size()>0){
                List<Target> targetList = new ArrayList<>();
                for (Relations uc:ucRelationList){
                    Target target = new Target();
                    target.setAppId(appId);
                    target.setClientId(uc.getCilentId());
                    targetList.add(target);
                }
                ret = push.pushMessageToList(push.getContentId(message),targetList);
            }else {
                return new ResultModel(1,"找不到推送目标",null);
            }
        }else{
            List appIdList = new ArrayList();
            appIdList.add(appId);
            SingleMessage message = new SingleMessage();
            /*message.setAppIdList(appIdList);*/
            message.setData(template);
            message.setOffline(true);
            message.setOfflineExpireTime(1000 * 600);
            Target target = new Target();
            target.setAppId(appId);
            target.setClientId(cid);
            ret = push.pushMessageToSingle(message,target);
        }
        if("ok".equals(ret.getResponse().get("result").toString())){
            return new ResultModel(0,ret.getResponse().toString(),null);
        }
        return new ResultModel(1,"系统错误",null);
    }
}
