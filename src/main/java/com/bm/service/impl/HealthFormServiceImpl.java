package com.bm.service.impl;

import com.bm.dao.HealthFormDao;
import com.bm.entity.HealthForm;
import com.bm.service.HealthFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
