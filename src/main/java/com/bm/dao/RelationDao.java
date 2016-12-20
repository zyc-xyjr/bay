package com.bm.dao;


import com.bm.entity.Relations;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.hateoas.core.Relation;

import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 */
public interface RelationDao extends PagingAndSortingRepository<Relations ,Long> {

    /**
     * @param userId
     * @return
     */
    @Query(value = "select it from Relations it where it.userId=?1")
    List<Relations> getRelationList(long userId);
}
