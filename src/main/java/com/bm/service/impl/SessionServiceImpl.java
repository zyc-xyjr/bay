package com.bm.service.impl;

import com.bm.dao.SessionDao;
import com.bm.entity.SessionEntity;
import com.bm.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/10/15.
 */
@Service("sessionService")
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionDao sessionDao;

    @Override
    public SessionEntity getSessionEntity(String uuid, int type) {

        long startTime = new Date().getTime() - 1000*60*20;
        List<SessionEntity> sessionEntities = this.sessionDao.getSessionEntity(uuid,type, new Date(startTime));
        if (sessionEntities!=null&&sessionEntities.size()>0){
            return sessionEntities.get(0);
        }
        return null;
    }

    @Override
    public void saveSessionEntiry(SessionEntity sessionEntity) {
        this.sessionDao.save(sessionEntity);
    }
}
