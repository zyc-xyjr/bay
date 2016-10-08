package com.bm.dao;

import com.bm.entity.CheckEntryItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 */
public interface CheckEntryItemDao extends PagingAndSortingRepository<CheckEntryItem,Long> {

    /**
     * 根据指标id获取指标检查值区间列表
     * @param entryId
     * @return
     */
    @Query(value = "select it from CheckEntryItem it where it.entryId=?1")
    List<CheckEntryItem> getItemListByEntryId(long entryId);
}
