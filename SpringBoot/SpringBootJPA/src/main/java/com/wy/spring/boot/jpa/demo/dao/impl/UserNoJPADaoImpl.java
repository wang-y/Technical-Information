package com.wy.spring.boot.jpa.demo.dao.impl;

import com.wy.spring.boot.jpa.demo.dao.UserNoJPADao;
import com.wy.spring.boot.jpa.demo.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2016/5/5.
 */
@Repository
public class UserNoJPADaoImpl extends HibernateDaoSupport implements UserNoJPADao {
    /**
     * 注入sessionFactory
     * @param sessionFactory
     */
    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public void save(User user) {
        this.getHibernateTemplate().save(user);
    }
}
