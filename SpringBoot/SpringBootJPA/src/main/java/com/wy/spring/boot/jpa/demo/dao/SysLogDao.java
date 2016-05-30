package com.wy.spring.boot.jpa.demo.dao;

import com.wy.spring.boot.jpa.demo.model.SysLogEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lenovo on 2016/5/6.
 */
public interface SysLogDao extends CrudRepository<SysLogEntity,Long> {

}
