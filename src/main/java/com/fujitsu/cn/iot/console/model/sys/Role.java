package com.fujitsu.cn.iot.console.model.sys;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by mark on 2017/3/28.
 */
@Entity
@Table(name="sys_role")
public class Role {

    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;

    @Column(name="description", length = 100)
    private String description;

    @Column(name="role_code", length = 45, nullable = false)
    private String roleCode;

    @Column(name="role_name", length = 45, nullable = false)
    private String roleName;

    @Column(name="add_usr", length = 45)
    public String addUsr;

    @Column(name="addt_tm")
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar addTm;

    @Column(name="upd_usr", length = 45)
    public String updUsr;

    @Column(name="upd_tm")
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar updTm ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
