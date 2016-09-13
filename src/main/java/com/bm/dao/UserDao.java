package com.bm.dao;

import com.bm.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator on 2016/9/6.
 */
public interface UserDao extends PagingAndSortingRepository<User,Long> {


}
