package com.bm.dao;

import com.bm.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Administrator on 2016/9/6.
 */
public interface UserDao extends PagingAndSortingRepository<User,Long> {

    @Query(value = "select u from User u where u.userName=?1")
    List<User> getUserByUserName(String userName);

    @Query(value = "select u from User u where u.userName=?1 and u.password=?2")
    User getLoginUser(String userName , String password);
}
