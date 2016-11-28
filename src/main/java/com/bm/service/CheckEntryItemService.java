package com.bm.service;

import com.bm.entity.CheckEntry;
import com.bm.entity.CheckEntryItem;

import java.util.List;

/**
 * Created by Administrator on 2016/9/10.
 */
public interface CheckEntryItemService {

    void saveCheckEntryItem(CheckEntryItem checkEntryItem);

    List<CheckEntryItem> findAllCheckEntryItem();

    void removeCheckEntryItem(long id);

    List<CheckEntryItem> entryItemsByEntryId(long entryId);
}
