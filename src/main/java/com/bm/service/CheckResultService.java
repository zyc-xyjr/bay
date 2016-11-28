package com.bm.service;

import com.bm.entity.CheckResult;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */
public interface CheckResultService {

    List<CheckResult> getCheckResultList(Long hearthFormId);

    void batchSaveCheckResult(List<CheckResult> checkResultList);

    void saveCheckResult(CheckResult checkResult);
}
