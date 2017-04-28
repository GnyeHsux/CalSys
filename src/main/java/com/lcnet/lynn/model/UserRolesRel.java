package com.lcnet.lynn.model;

import io.swagger.models.auth.In;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * Created by lynn on 2017/4/27.
 */
@Table("MAN_ROLES")
public class UserRolesRel {
    @Id
    @Column("id")
    private Integer id;

    @Column("user_id")
    private Integer userId;

    @Column("role_id")
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
