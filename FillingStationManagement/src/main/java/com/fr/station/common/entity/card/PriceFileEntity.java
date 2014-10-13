﻿/*
 * 调价文件信息
 * Revised history
 * Copyright(c) 2010 FR Co.,Ltd
 */


package com.fr.station.common.entity.card;


import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fr.station.common.bean.system.StandardBean;


/**
 * 调价文件
 * 
 * @version 1.0
 * @authorguyj
 */
 @Entity
 @Table(name = "PRICE_FILE")
public class PriceFileEntity implements StandardBean {


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
     * 品名
     */
     @Column(name = "`TYPE`")
    private String type;

    /**
     * 下发时间
     */
     @Column(name = "`DEV_TIME`")
    private Date devTime;

    /**
     * 生效时间
     */
     @Column(name = "`EFF_TIME`")
    private Date effTime;

    /**
     * 批文号
     */
     @Column(name = "`APP_NUM`")
    private String appNum;

    /**
     * 标识
     */
     @Column(name = "`MARK`")
    private String mark;

    /**
     * 备注
     */
     @Column(name = "`FLAG`")
    private String flag;

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
     * 品名的取得
     *
     * @return String 品名
     */
    public String getType() {
        return type;
    }


    /**
     * 下发时间的取得
     *
     * @return Date 下发时间
     */
    public Date getDevTime() {
        return devTime;
    }


    /**
     * 生效时间的取得
     *
     * @return Date 生效时间
     */
    public Date getEffTime() {
        return effTime;
    }


    /**
     * 批文号的取得
     *
     * @return String 批文号
     */
    public String getAppNum() {
        return appNum;
    }


    /**
     * 标识的取得
     *
     * @return String 标识
     */
    public String getMark() {
        return mark;
    }


    /**
     * 备注的取得
     *
     * @return String 备注
     */
    public String getFlag() {
        return flag;
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
     * 品名的设定
     *
     * @param newString 品名
     */
    public void setType(String newType) {
        this.type = newType;
    }


    /**
     * 下发时间的设定
     *
     * @param newDate 下发时间
     */
    public void setDevTime(Date newDevTime) {
        this.devTime = newDevTime;
    }


    /**
     * 生效时间的设定
     *
     * @param newDate 生效时间
     */
    public void setEffTime(Date newEffTime) {
        this.effTime = newEffTime;
    }


    /**
     * 批文号的设定
     *
     * @param newString 批文号
     */
    public void setAppNum(String newAppNum) {
        this.appNum = newAppNum;
    }


    /**
     * 标识的设定
     *
     * @param newString 标识
     */
    public void setMark(String newMark) {
        this.mark = newMark;
    }


    /**
     * 备注的设定
     *
     * @param newString 备注
     */
    public void setFlag(String newFlag) {
        this.flag = newFlag;
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
