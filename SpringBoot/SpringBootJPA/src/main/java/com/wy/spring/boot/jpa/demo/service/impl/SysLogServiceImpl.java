package com.wy.spring.boot.jpa.demo.service.impl;

import com.wy.spring.boot.jpa.demo.dao.SysLogDao;
import com.wy.spring.boot.jpa.demo.model.SysLogEntity;
import com.wy.spring.boot.jpa.demo.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2016/5/6.
 */
@Service
public class SysLogServiceImpl implements SysLogService{

    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public SysLogEntity save(SysLogEntity sle) {
        return sysLogDao.save(sle);
    }
}
