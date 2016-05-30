package com.wy.spring.boot.jpa.demo.service.impl;

import com.wy.spring.boot.jpa.demo.dao.UserNoJPADao;
import com.wy.spring.boot.jpa.demo.dao.UserPageDao;
import com.wy.spring.boot.jpa.demo.dynamicdatasource.aop.annotation.TargetDataSource;
import com.wy.spring.boot.jpa.demo.model.User;
import com.wy.spring.boot.jpa.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lenovo on 2016/5/4.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserPageDao userPageDao;
    @Autowired
    private UserNoJPADao userNoJPADaoImpl;

    @Override
    @TargetDataSource("read")
    public Page<User> findAll(Pageable pageable) {
        try {
            Page<User> users = userPageDao.findAll(pageable);
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<User> findAbAll(Pageable pageable) {
        try {
            Page<User> users = userPageDao.abcdef("test",pageable);
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public void save(User user) {
        userNoJPADaoImpl.save(user);
    }
}
