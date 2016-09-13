package com.bm.dao;

import com.bm.entity.Pathogen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator on 2016/9/12.
 */
public interface PathogenDao extends PagingAndSortingRepository<Pathogen,Long> {


}
