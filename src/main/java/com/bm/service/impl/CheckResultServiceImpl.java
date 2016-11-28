package com.bm.service.impl;

import com.bm.dao.CheckResultDao;
import com.bm.entity.CheckResult;
import com.bm.service.CheckResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */
@Service("checkResultService")
public class CheckResultServiceImpl implements CheckResultService {

    @Autowired
    private CheckResultDao checkResultDao;

    @Override
    public List<CheckResult> getCheckResultList(Long hearthFormId) {
        return checkResultDao.getCheckResultList(hearthFormId);
    }

    @Override
    public void batchSaveCheckResult(List<CheckResult> checkResultList) {

    }

    @Override
    public void saveCheckResult(CheckResult checkResult) {

    }
}
