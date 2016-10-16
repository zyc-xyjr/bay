package com.bm.dao;

import com.bm.entity.SessionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/10/15.
 */
public interface SessionDao extends PagingAndSortingRepository<SessionEntity,Long> {

    @Query(value = "select s from SessionEntity s where  s.status=1 and s.uuid=?1 and s.type=?2 and s.startTime>?3")
    List<SessionEntity> getSessionEntity(String uuid,int type, Date startTime);
}
