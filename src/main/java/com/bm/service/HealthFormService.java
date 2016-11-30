package com.bm.service;

import com.bm.entity.HealthForm;

import java.util.List;

/**
 * Created by Administrator on 2016/10/15.
 */
public interface HealthFormService {

    void saveHelthForm(HealthForm healthForm);

    List<HealthForm> findAll(Long userId);

    List<HealthForm> findByStatus(Long userId,String status);

    HealthForm getById(Long id);
}
