package com.bm.service.impl;

import com.bm.dao.UserDao;
import com.bm.entity.User;
import com.bm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        try{
            return this.userDao.getUserByUserName(userName).get(0);
        }catch (NullPointerException e){
            return null;
        }
    }

    @Override
    public User getUserByUnique(String unique) {
        return null;
    }

    @Override
    public User getLoginUser(String userName, String password) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }
}
