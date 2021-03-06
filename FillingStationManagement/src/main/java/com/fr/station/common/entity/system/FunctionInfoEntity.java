﻿/*
 * 功能表
 * Revised history
 * Copyright(c) 2010 FR Co.,Ltd
 */

package com.fr.station.common.entity.system;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fr.station.common.bean.system.StandardBean;

/**
 * 功能表
 * 
 * @version 1.0
 * _wsq
 */
@Entity
@Table(name = "Functionality")
public class FunctionInfoEntity implements StandardBean {

	private static final long serialVersionUID = 1L;

	/**
	 * 画面ID
	 */
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@OneToMany(mappedBy = "functionId")
	private Set<RoleFunctionInfoEntity> functionId;

	/**
	 * 画面名称
	 */
	@Column(name = "NAME")
	private String name;

	/**
	 * 上级阶级
	 */
	@Column(name = "UP_STEP")
	private int upStep;

	/**
	 * 当前阶级
	 */
	@Column(name = "STEP")
	private int step;

	/**
	 * 左侧树是否显示
	 */
	@Column(name = "LTREE")
	private int ltree;

	/**
	 * 画面说明
	 */
	@Column(name = "DETAIL")
	private String detail;
	
	@Column(name = "use_stats")
	private String useStatus;
	
	@Column(name = "icon")
	private String icon;

	/**
	 * url
	 */
	@Column(name = "URL")
	private String url;

	/**
	 * open
	 */
	@Column(name = "isOpen")
	private int open;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<RoleFunctionInfoEntity> getFunctionId() {
		return functionId;
	}

	public void setFunctionId(Set<RoleFunctionInfoEntity> functionId) {
		this.functionId = functionId;
	}

	public String getName() {
		return name;
	}

	public String getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(String useStatus) {
		this.useStatus = useStatus;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUpStep() {
		return upStep;
	}

	public void setUpStep(int upStep) {
		this.upStep = upStep;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getLtree() {
		return ltree;
	}

	public void setLtree(int ltree) {
		this.ltree = ltree;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getOpen() {
		return open;
	}

	public void setOpen(int open) {
		this.open = open;
	}

}
