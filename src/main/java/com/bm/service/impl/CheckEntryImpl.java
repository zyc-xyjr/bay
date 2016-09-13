package com.bm.service.impl;

import com.bm.dao.CheckEntryDao;
import com.bm.entity.CheckEntry;
import com.bm.service.CheckEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<CheckEntry> findAllCheckEntry() {
        return (List<CheckEntry>) checkEntryDao.findAll();
    }

    @Override
    public List<CheckEntry> findEntriesByParentId(long parentId) {
        return (List<CheckEntry>) checkEntryDao.findAllByParentId(parentId);
    }

    @Override
    public void removeCheckEntry(long id) {
        checkEntryDao.delete(id);
    }

    @Override
    public Page<CheckEntry> pageAllCheckEntry(int pageNo, int pageSize) {
        PageRequest pageRequest = new PageRequest(pageNo-1,pageSize,null);
        Page<CheckEntry> checkEntryPage = this.checkEntryDao.findAll(pageRequest);
        return checkEntryPage;
    }

    @Override
    public void batchDelCheckEntry(List<Long> ids) {
        List<CheckEntry> checkEntries =(List<CheckEntry>) this.checkEntryDao.findAll(ids);
        this.checkEntryDao.delete(checkEntries);
    }
}
