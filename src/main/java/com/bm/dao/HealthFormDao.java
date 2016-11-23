package com.bm.dao;

import com.bm.entity.HealthForm;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Administrator on 2016/10/15.
 */
public interface HealthFormDao extends PagingAndSortingRepository<HealthForm,Long> {

    @Query(value = "select u from HealthForm u where u.userId=?1")
    List<HealthForm> findAll(Long userId);

    @Query(value = "select u from HealthForm u where u.userId=?1 and u.status=?2")
    List<HealthForm> findByStatus(Long userId,String status);
}
