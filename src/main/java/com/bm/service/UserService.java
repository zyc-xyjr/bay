package com.bm.service;

import com.bm.entity.User;

/**
 * Created by Administrator on 2016/9/6.
 * 用户相关业务逻辑
 */
public interface UserService {
    /**
     * 用户注册
     * @param user
     */
    void register(User user);

    /**
     * 通过用户名获取用户
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);

    /**
     * 通过唯一性条件获取用户：用户名 || 手机号 || 邮箱
     * @param unique
     * @return
     */
    User getUserByUnique(String unique);

    /**
     * 通过登录条件获取用户：用户名 && 密码
     * @param userName
     * @param password
     * @return
     */
    User getLoginUser(String userName,String password);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);


}
