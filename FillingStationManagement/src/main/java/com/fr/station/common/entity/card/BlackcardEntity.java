﻿/*
 * 黑卡 Revised history Copyright(c) 2010 FR Co.,Ltd
 */

package com.fr.station.common.entity.card;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fr.station.common.bean.system.StandardBean;

/**
 * 黑卡
 *
 * @version 1.0
 * @authorguyj
 */
@Entity
@Table(name = "BLACKCARD")
public class BlackcardEntity implements StandardBean {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 卡号
	 */
	@Id
	@Column(name = "`CARDID`")
	private String cardid;

	/**
	 * 网点号
	 */
	@Column(name = "`STATIONNO`")
	private Integer stationno;

	/**
	 * 日结号
	 */
	@Column(name = "`RJID`")
	private Integer rjid;

	/**
	 * 日结号
	 */
	@Column(name = "`RJRQ`")
	private Timestamp RJRQ;

	/**
	 * 创建时间
	 */
	@Column(name = "`CREATE_DATE`")
	private Timestamp createDate;

	/**
	 * 卡号的取得
	 *
	 * @return String 卡号
	 */
	public String getCardid() {
		return this.cardid;
	}

	/**
	 * 网点号的取得
	 *
	 * @return Integer 网点号
	 */
	public Integer getStationno() {
		return this.stationno;
	}

	/**
	 * 日结号的取得
	 *
	 * @return Integer 日结号
	 */
	public Integer getRjid() {
		return this.rjid;
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
	 * 卡号的设定
	 *
	 * @param newString 卡号
	 */
	public void setCardid(String newCardid) {
		this.cardid = newCardid;
	}

	/**
	 * 网点号的设定
	 *
	 * @param newInteger 网点号
	 */
	public void setStationno(Integer newStationno) {
		this.stationno = newStationno;
	}

	public Timestamp getRJRQ() {
		return this.RJRQ;
	}

	public void setRJRQ(Timestamp rJRQ) {
		this.RJRQ = rJRQ;
	}

	/**
	 * 日结号的设定
	 *
	 * @param newInteger 日结号
	 */
	public void setRjid(Integer newRjid) {
		this.rjid = newRjid;
	}

	/**
	 * 创建时间的设定
	 *
	 * @param newTimestamp 创建时间
	 */
	public void setCreateDate(Timestamp newCreateDate) {
		this.createDate = newCreateDate;
	}
}
