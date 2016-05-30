package com.wy.spring.boot.jpa.demo.service;

import com.wy.spring.boot.jpa.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Iterator;
import java.util.List;

/**
 * Created by lenovo on 2016/5/4.
 */
public interface UserService {

    public Page<User> findAll(Pageable pageable);

    public Page<User> findAbAll(Pageable pageable);

    public void save(User user);
}
