package com.lcnet.lynn.model;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

/**
 * Created by xusha on 2017/4/27.
 */
@Table("cust_info")
public class CustInfo {

    @Column("cust_id")
    private Integer custId;

    @Column("cust_name")
    private String custName;

    @Column("sex")
    private String sex;

    @Column("id_card")
    private String idCard;

    @Column("marry_cd")
    private String marryCd;

    @Column("addr")
    private String addr;

    @Column("tel")
    private String tel;

    @Column("owner_id")
    private String ownnerId;

    @Column("loan_status")
    private String loanStatus;

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMarryCd() {
        return marryCd;
    }

    public void setMarryCd(String marryCd) {
        this.marryCd = marryCd;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getOwnnerId() {
        return ownnerId;
    }

    public void setOwnnerId(String ownnerId) {
        this.ownnerId = ownnerId;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }
}
