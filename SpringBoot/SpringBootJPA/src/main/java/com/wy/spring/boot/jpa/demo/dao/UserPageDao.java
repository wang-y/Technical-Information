package com.wy.spring.boot.jpa.demo.dao;

import com.wy.spring.boot.jpa.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by lenovo on 2016/5/5.
 */
public interface UserPageDao extends PagingAndSortingRepository<User,Long> {
    @Query("select u from User u where u.loginName=:loginName")
    Page<User> abcdef(@Param("loginName") String loginName, Pageable pageRequest);
}
