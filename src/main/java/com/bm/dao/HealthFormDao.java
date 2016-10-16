package com.bm.dao;

import com.bm.entity.HealthForm;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator on 2016/10/15.
 */
public interface HealthFormDao extends PagingAndSortingRepository<HealthForm,Long> {
}
