package com.baymax.dao;

import com.baymax.entity.CheckEntry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Administrator on 2016/9/8.
 */
public interface CheckEntryDao extends CrudRepository<CheckEntry,Long> {
    /**
     * HQL查询
     * @param parentId
     * @return
     */
    @Query(value = "select en from CheckEntry en where en.parentId=?1")
    List<CheckEntry> findAllByParentId(Long parentId);

    /**
     * 原生SQL查询
     * @param parentId
     * @return
     */
    @Query(value = "select en from tb_check_entry en where en.parent_id=?1",nativeQuery = true)
    List<CheckEntry> sqlFindAllByParentId(Long parentId);
}
