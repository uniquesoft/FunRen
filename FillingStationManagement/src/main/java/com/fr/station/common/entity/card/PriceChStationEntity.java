﻿/*
 * 调价网点
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
 * 调价网点
 * 
 * @version 1.0
 * @authorguyj
 */
 @Entity
 @Table(name = "PRICE_CH_STATION")
public class PriceChStationEntity implements StandardBean {


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
     * 调价单号
     */
     @Column(name = "`CHPRICE_NO`")
    private String chpriceNo;

    /**
     * 网点号
     */
     @Column(name = "`STATIONNO`")
    private Integer stationno;

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
     * 调价单号的取得
     *
     * @return String 调价单号
     */
    public String getChpriceNo() {
        return chpriceNo;
    }


    /**
     * 网点号的取得
     *
     * @return Integer 网点号
     */
    public Integer getStationno() {
        return stationno;
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
     * 调价单号的设定
     *
     * @param newString 调价单号
     */
    public void setChpriceNo(String newChpriceNo) {
        this.chpriceNo = newChpriceNo;
    }


    /**
     * 网点号的设定
     *
     * @param newInteger 网点号
     */
    public void setStationno(Integer newStationno) {
        this.stationno = newStationno;
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
