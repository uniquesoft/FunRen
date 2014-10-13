﻿/*
 * 班次信息表 Revised history Copyright(c) 2010 FR Co.,Ltd
 */

package com.fr.station.common.entity.report;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fr.station.common.bean.system.StandardBean;

/**
 * 班次表
 *
 * @version 1.0
 * @authorguyj
 */
@Entity
@Table(name = "CLASS_INFO")
public class ClassInfoEntity implements StandardBean {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@Id
	@Column(name = "`ID`")
	@GeneratedValue
	private Integer id;

	/**
	 * 名称
	 */
	@Column(name = "`class_name`")
	private String name;

	/**
	 * 班次号
	 */
	@Column(name = "`class_no`")
	private String classNo;

	/**
	 * 班结状态
	 */
	@Column(name = "`class_status`")
	private String classStatus;

	/**
	 * 创建时间
	 */
	@Column(name = "`CREATE_DATE`")
	private Timestamp createDate;

	/**
	 * 删除标志
	 */
	@Column(name = "`deleteFlag`")
	@org.hibernate.annotations.Type(type = "yes_no")
	private Boolean deleteFlag = false;

	/**
	 * 更新时间
	 */
	@Column(name = "`UPDATE_DATE`")
	private Timestamp updateDate;

	/**
	 * 操作员编号
	 */
	@Column(name = "`USERID`")
	private String userid;

	/**
	 * 网点编号
	 */
	@Column(name = "`stationNo`")
	private String stationNo;

	/**
	 * ID的取得
	 *
	 * @return Integer ID
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * 名称的取得
	 *
	 * @return String 名称
	 */
	public String getName() {
		return this.name;
	}

	public String getClassNo() {
		return this.classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	/**
	 * 创建时间的取得
	 *
	 * @return Timestamp 创建时间
	 */
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	/**
	 * 更新时间的取得
	 *
	 * @return Timestamp 更新时间
	 */
	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	/**
	 * 操作员编号的取得
	 *
	 * @return Integer 操作员编号
	 */
	public String getUserid() {
		return this.userid;
	}

	/**
	 * ID的设定
	 *
	 * @param newInteger ID
	 */
	public void setId(Integer newId) {
		this.id = newId;
	}

	public String getStationNo() {
		return this.stationNo;
	}

	public void setStationNo(String stationNo) {
		this.stationNo = stationNo;
	}

	public String getClassStatus() {
		return this.classStatus;
	}

	public void setClassStatus(String classStatus) {
		this.classStatus = classStatus;
	}

	/**
	 * 名称的设定
	 *
	 * @param newString 名称
	 */
	public void setName(String newName) {
		this.name = newName;
	}

	public Boolean getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
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
	public void setUserid(String newUserid) {
		this.userid = newUserid;
	}
}
