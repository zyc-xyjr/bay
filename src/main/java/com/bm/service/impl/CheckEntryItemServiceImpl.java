package com.bm.service.impl;

import com.bm.dao.CheckEntryItemDao;
import com.bm.entity.CheckEntryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/10.
 */
@Service("checkEntryItemService")
public class CheckEntryItemServiceImpl implements CheckEntryItemService {
    @Autowired
    private CheckEntryItemDao checkEntryItemDao;

    @Override
    public void saveCheckEntryItem(CheckEntryItem checkEntryItem) {
        checkEntryItemDao.save(checkEntryItem);
    }

    @Override
    public List<CheckEntryItem> findAllCheckEntryItem() {
        return (List<CheckEntryItem>) checkEntryItemDao.findAll();
    }

    @Override
    public void removeCheckEntryItem(long id) {
        checkEntryItemDao.delete(id);
    }
}
