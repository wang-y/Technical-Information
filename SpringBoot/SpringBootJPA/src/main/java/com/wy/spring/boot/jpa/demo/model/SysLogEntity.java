package com.wy.spring.boot.jpa.demo.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lenovo on 2016/5/6.
 */
@Entity
@Table(name="SysLog")
public class SysLogEntity implements Serializable {
    private Long id;
    private String ip;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
