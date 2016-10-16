package com.bm.service.impl;

import com.bm.dao.UserDao;
import com.bm.entity.User;
import com.bm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/9/18.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void register(User user) {
        userDao.save(user);
    }

    @Override
    public User getUserByUserName(String userName) {
        List<User> userList = this.userDao.getUserByUserName(userName);
        if (userList!=null&&userList.size()>0){
            return userList.get(0);
        }else {
            return null;
        }
    }

    @Override
    public User getUserByUnique(String unique) {
        return null;
    }

    @Override
    public User getLoginUser(String userName, String password) {
        return this.userDao.getLoginUser(userName, password);
    }

    @Override
    public void updateUser(User user) {

    }
}
