package com.bm.dao;

import com.bm.entity.CheckEntryItem;
import com.bm.entity.CheckResult;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */
public interface CheckResultDao extends PagingAndSortingRepository<CheckResult,Long> {

    /**
     * 根据体检单id获取各个指标检查值列表
     * @param healthFormId
     * @return
     */
    @Query(value = "select it from CheckResult it where it.healthFormId=?1")
    List<CheckResult> getCheckResultList(long healthFormId);

    /**
     * 根据体检单id获取各个指标检查值列表
     * @param healthFormId
     * @return
     */
    @Query(value = "select it from CheckResult it where it.healthFormId=?1 and it.entryId=?2")
    CheckResult getCheckResult(long healthFormId,Long entryId);
}
