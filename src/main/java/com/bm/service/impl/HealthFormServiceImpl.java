package com.bm.service.impl;

import com.bm.dao.HealthFormDao;
import com.bm.entity.HealthForm;
import com.bm.service.HealthFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/10/15.
 */
@Service("healthFormService")
public class HealthFormServiceImpl implements HealthFormService {

    @Autowired
    private HealthFormDao healthFormDao;

    @Override
    public void saveHelthForm(HealthForm healthForm) {
        healthFormDao.save(healthForm);
    }

    @Override
    public List<HealthForm> findAll(Long userId) {
        return healthFormDao.findAll(userId);
    }

    @Override
    public List<HealthForm> findByStatus(Long userId, String status) {
        if (userId!=0l){
            return healthFormDao.findByStatus(userId,status);
        }else {
            return healthFormDao.findByStatus(status);
        }
    }

    @Override
    public HealthForm getById(Long id) {
        return healthFormDao.findOne(id);
    }

    @Override
    public List<HealthForm> findByStatus(String status) {
        return healthFormDao.findByStatus(status);
    }
}
