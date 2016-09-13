package com.bm.dao;

import com.bm.entity.Sickness;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator on 2016/9/9.
 */
public interface SicknessDao extends PagingAndSortingRepository<Sickness,Long> {
}
