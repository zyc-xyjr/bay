package com.bm.service;

import com.bm.model.ResultModel;

/**
 * Created by Administrator on 2016/12/15.
 */
public interface PushService {

    ResultModel pushMsg(String cid,Long templateId);
}
