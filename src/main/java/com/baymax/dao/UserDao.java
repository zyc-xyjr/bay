package com.baymax.dao;

import com.baymax.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2016/9/6.
 */
public interface UserDao extends CrudRepository<User,Long> {


}
