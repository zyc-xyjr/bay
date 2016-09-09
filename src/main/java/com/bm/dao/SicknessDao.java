package com.bm.dao;

import com.bm.entity.Sickness;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2016/9/9.
 */
public interface SicknessDao extends CrudRepository<Sickness,Long> {
}
