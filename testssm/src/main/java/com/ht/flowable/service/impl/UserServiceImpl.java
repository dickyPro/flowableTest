package com.ht.flowable.service.impl;

import com.ht.flowable.dao.IUserDao;
import com.ht.flowable.model.User;
import com.ht.flowable.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by hetao on 2018/9/5
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

}
