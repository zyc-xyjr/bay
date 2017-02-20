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
import com.gexin.rp.sdk.base.payload.APNPayload;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 */
@Service("pushService")
public class PushServiceImpl implements PushService {

    //定义常量, appId、appKey、masterSecret 采用本文档 "第二步 获取访问凭证 "中获得的应用配置
    private static String appId = "IsFSehlHjE80BUUGfPJk19";
    private static String appKey = "ST5SiK5ESv61Dj6houQ9H9";
    private static String masterSecret = "C5VNlljpS1AFnHxnV7pD57";
    private static String url = "http://sdk.open.api.igexin.com/apiex.htm";

    @Autowired
    private PushMessageDao pushMessageDao;

    @Autowired
    private RelationDao relationDao;

    @Override
    public ResultModel pushMsg(String cid, Long templateId) {
        IGtPush push = new IGtPush(url, appKey, masterSecret);

        AppPushMessage msg = pushMessageDao.findOne(templateId);
        if (ObjectUtils.isEmpty(msg)){
            return new ResultModel(1,"缺少信息模板",new LinkedHashMap());
        }
        // 定义"点击链接打开通知模板"，并设置标题、内容、链接
        TransmissionTemplate template = new TransmissionTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        if(msg!=null){

            template.setTransmissionType(2);
            template.setTransmissionContent(msg.toString());
        }
        APNPayload payload = new APNPayload();
        payload.setBadge(1);
        payload.setContentAvailable(1);
        payload.setSound("default");
        payload.setCategory("$由客户端定义");
        //简单模式APNPayload.SimpleMsg
        payload.setAlertMsg(new APNPayload.SimpleAlertMsg("hello"));
        //字典模式使用下者
        payload.setAlertMsg(getDictionaryAlertMsg());
        template.setAPNInfo(payload);
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

    private static APNPayload.DictionaryAlertMsg getDictionaryAlertMsg(){
        APNPayload.DictionaryAlertMsg alertMsg = new APNPayload.DictionaryAlertMsg();
        alertMsg.setBody("您有一条新体检单");
        alertMsg.setActionLocKey("ActionLockey");
        alertMsg.setLocKey("LocKey");
        alertMsg.addLocArg("loc-args");
        alertMsg.setLaunchImage("launch-image");
        // IOS8.2以上版本支持
        alertMsg.setTitle("您有一条新体检单");
        alertMsg.setTitleLocKey("TitleLocKey");
        alertMsg.addTitleLocArg("TitleLocArg");
        return alertMsg;
    }
}
