package com.ht.flowable.dao;

import com.ht.flowable.model.User;

/**
 * Created by hetao on 2018/9/5
 */
public interface IUserDao {

    User selectUser(long id);
}
