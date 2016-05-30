package com.wy.spring.boot.jpa.demo.dao;

import com.wy.spring.boot.jpa.demo.model.User;

/**
 * Created by lenovo on 2016/5/5.
 */
public interface UserNoJPADao {
    void save(User user);
}
