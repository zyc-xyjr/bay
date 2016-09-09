package com.baymax.service.impl;

import com.baymax.dao.CheckEntryDao;
import com.baymax.entity.CheckEntry;
import com.baymax.service.CheckEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/9/8.
 */
@Service("checkEntryService")
@Transactional
public class CheckEntryImpl implements CheckEntryService {

    @Autowired
    private CheckEntryDao checkEntryDao;

    @Override
    public void saveCheckEntry(CheckEntry checkEntry) {
        checkEntryDao.save(checkEntry);
    }
}
