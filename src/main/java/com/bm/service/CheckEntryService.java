package com.bm.service;

import com.bm.entity.CheckEntry;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Administrator on 2016/9/8.
 */
public interface CheckEntryService {

    void saveCheckEntry(CheckEntry checkEntry);

    List<CheckEntry> findAllCheckEntry();

    List<CheckEntry> findEntriesByParentId(long parentId);

    void removeCheckEntry(long id);

    Page<CheckEntry> pageAllCheckEntry(int pageNo, int pageSize);

    void batchDelCheckEntry(List<Long> ids);
}
