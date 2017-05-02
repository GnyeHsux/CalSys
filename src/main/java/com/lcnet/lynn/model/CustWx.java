package com.lcnet.lynn.model;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * Created by lynn on 2017/4/27.
 */
@Table("cust_wx")
public class CustWx {
    @Id
    @Column("id")
    private Integer id;

    @Column("openId")
    private String openId;

    @Column("cust_id")
    private Integer csutId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getCsutId() {
        return csutId;
    }

    public void setCsutId(Integer csutId) {
        this.csutId = csutId;
    }
}
