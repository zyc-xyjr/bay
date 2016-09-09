package com.bm.dao;

import com.bm.entity.CheckEntryItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 */
public interface CheckEntryItemDao extends CrudRepository<CheckEntryItem,Long> {

    /**
     * 根据指标id获取指标检查值区间列表
     * @param entryId
     * @return
     */
/*    @Query(value = "select * from CheckEntryItem where entryId=?1")
    List<CheckEntryItem> getItemListByEntryId(long entryId);*/
}
