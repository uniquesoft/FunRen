﻿/*
 * 油气管理的信息
 * Revised history
 * Copyright(c) 2010 FR Co.,Ltd
 */


package com.fr.station.common.entity.card;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fr.station.common.bean.system.StandardBean;


/**
 * 油气管理表
 * 
 * @version 1.0
 * @authorguyj
 */
 @Entity
 @Table(name = "OIL_GAS_INFO")
public class OilGasInfoEntity implements StandardBean {


    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
     @Id
     @Column(name = "`ID`")
     @GeneratedValue
    private Integer id;

    /**
     * 编号
     */
     @Column(name = "`NO`")
    private String no;

    /**
     * 规格
     */
     @Column(name = "`TYPE`")
    private String type;

    /**
     * 供应商
     */
     @Column(name = "`COMPANY`")
    private String company;

    /**
     * 单价
     */
     @Column(name = "`PRICE`")
    private String price;

    /**
     * 密度
     */
     @Column(name = "`DENSITY`")
    private String density;

    /**
     * 创建时间
     */
     @Column(name = "`CREATE_DATE`")
    private Timestamp createDate;

    /**
     * 更新时间
     */
     @Column(name = "`UPDATE_DATE`")
    private Timestamp updateDate;

    /**
     * 操作员编号
     */
     @Column(name = "`USERID`")
    private Integer userid;



    /**
     * id的取得
     *
     * @return Integer id
     */
    public Integer getId() {
        return id;
    }


    /**
     * 编号的取得
     *
     * @return String 编号
     */
    public String getNo() {
        return no;
    }


    /**
     * 规格的取得
     *
     * @return String 规格
     */
    public String getType() {
        return type;
    }


    /**
     * 供应商的取得
     *
     * @return String 供应商
     */
    public String getCompany() {
        return company;
    }


    /**
     * 单价的取得
     *
     * @return String 单价
     */
    public String getPrice() {
        return price;
    }


    /**
     * 密度的取得
     *
     * @return String 密度
     */
    public String getDensity() {
        return density;
    }


    /**
     * 创建时间的取得
     *
     * @return Timestamp 创建时间
     */
    public Timestamp getCreateDate() {
        return createDate;
    }


    /**
     * 更新时间的取得
     *
     * @return Timestamp 更新时间
     */
    public Timestamp getUpdateDate() {
        return updateDate;
    }


    /**
     * 操作员编号的取得
     *
     * @return Integer 操作员编号
     */
    public Integer getUserid() {
        return userid;
    }


    /**
     * id的设定
     *
     * @param newInteger id
     */
    public void setId(Integer newId) {
        this.id = newId;
    }


    /**
     * 编号的设定
     *
     * @param newString 编号
     */
    public void setNo(String newNo) {
        this.no = newNo;
    }


    /**
     * 规格的设定
     *
     * @param newString 规格
     */
    public void setType(String newType) {
        this.type = newType;
    }


    /**
     * 供应商的设定
     *
     * @param newString 供应商
     */
    public void setCompany(String newCompany) {
        this.company = newCompany;
    }


    /**
     * 单价的设定
     *
     * @param newString 单价
     */
    public void setPrice(String newPrice) {
        this.price = newPrice;
    }


    /**
     * 密度的设定
     *
     * @param newString 密度
     */
    public void setDensity(String newDensity) {
        this.density = newDensity;
    }


    /**
     * 创建时间的设定
     *
     * @param newTimestamp 创建时间
     */
    public void setCreateDate(Timestamp newCreateDate) {
        this.createDate = newCreateDate;
    }


    /**
     * 更新时间的设定
     *
     * @param newTimestamp 更新时间
     */
    public void setUpdateDate(Timestamp newUpdateDate) {
        this.updateDate = newUpdateDate;
    }


    /**
     * 操作员编号的设定
     *
     * @param newInteger 操作员编号
     */
    public void setUserid(Integer newUserid) {
        this.userid = newUserid;
    }
}
