package com.fujitsu.cn.iot.console.common.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by mark on 2017/5/5.
 */
public class BaseEntity {

    @Column(name="add_usr", length = 45)
    private String addUsr;

    @Column(name="addt_tm")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar addTm;

    @Column(name="upd_usr", length = 45)
    private String updUsr;

    @Column(name="upd_tm")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar updTm ;

}
