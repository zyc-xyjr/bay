package com.bm.dao;

import com.bm.entity.AppPushMessage;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator on 2016/12/15.
 */
public interface PushMessageDao extends PagingAndSortingRepository<AppPushMessage,Long> {
}
