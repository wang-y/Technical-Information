package com.wy.spring.boot.jpa.demo.service;

import com.wy.spring.boot.jpa.demo.model.SysLogEntity;

/**
 * Created by lenovo on 2016/5/6.
 */
public interface SysLogService {
    SysLogEntity save(SysLogEntity sle);
}
