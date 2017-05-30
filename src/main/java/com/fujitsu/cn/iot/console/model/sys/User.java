package com.fujitsu.cn.iot.console.model.sys;


import com.fujitsu.cn.iot.console.common.base.BaseEntity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by mark on 2017/3/28.
 */
@Entity
@Table(name="sys_user")
public class User{

    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;

    @Column(name="user_name", length=45, nullable = false)
    private String username;

    @Column(name="user_code", length=45, nullable = false)
    private String usercode;

    @Column(name="password", length=100, nullable = false)
    private String password;

    @Column(name = "sex")
    private int sex;

    @Column(name = "birthday")
    @Temporal(value=TemporalType.DATE)
    private Date birthday;

    @Column(name="email", length=45)
    private String email;

    @Column(name="phone", length=45)
    private String phone;

    @Column(name="department_key", length=20, nullable = false)
    private String departmentkey;

    @Column(name = "status")
    private int status;

    @Column(name = "last_logintime")
    @Temporal(value=TemporalType.TIMESTAMP)
    private Calendar lastlogintime;

    @Column(name="add_usr", length = 45)
    public String addUsr="";

    @Column(name="addt_tm")
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar addTm=Calendar.getInstance();

    @Column(name="upd_usr", length = 45)
    public String updUsr="";

    @Column(name="upd_tm")
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar updTm=Calendar.getInstance() ;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartmentkey() {
        return departmentkey;
    }

    public void setDepartmentkey(String departmentkey) {
        this.departmentkey = departmentkey;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Calendar getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Calendar lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getAddUsr() {
        return addUsr;
    }

    public void setAddUsr(String addUsr) {
        this.addUsr = addUsr;
    }

    public Calendar getAddTm() {
        return addTm;
    }

    public void setAddTm(Calendar addTm) {
        this.addTm = addTm;
    }

    public String getUpdUsr() {
        return updUsr;
    }

    public void setUpdUsr(String updUsr) {
        this.updUsr = updUsr;
    }

    public Calendar getUpdTm() {
        return updTm;
    }

    public void setUpdTm(Calendar updTm) {
        this.updTm = updTm;
    }
}
