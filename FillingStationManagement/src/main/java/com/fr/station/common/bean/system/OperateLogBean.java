package com.fr.station.common.bean.system;

import java.math.BigDecimal;
import java.util.Date;


public class OperateLogBean implements StandardBean {

	private static final long serialVersionUID = 1L;

	public OperateLogBean() {
		super();
	}

	private Integer oilGunNum;
	private String cardNum;
	private Integer posTTC;
	private Integer tradeType;
	private Integer stationNum;
	private String gasType;
	private String payType;
	private String companyName;
	private Date startDate;
	private Date endDate;
	private String recordType;
	private String tradeTime;
	private String oilName;
	private BigDecimal price;
	// 数量
	private BigDecimal account;
	private BigDecimal totalAccount;
	// 交易金额
	private BigDecimal tradeAmount;
	private String cardTradeNum;
	private BigDecimal cardLeftMoney;
	private String tradeLocation;
	private Integer tradeNum;
	private String carNum;

	public Integer getOilGunNum() {
		return oilGunNum;
	}
	public void setOilGunNum(Integer oilGunNum) {
		this.oilGunNum = oilGunNum;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public Integer getPosTTC() {
		return posTTC;
	}
	public void setPosTTC(Integer posTTC) {
		this.posTTC = posTTC;
	}
	public Integer getTradeType() {
		return tradeType;
	}
	public void setTradeType(Integer tradeType) {
		this.tradeType = tradeType;
	}
	public Integer getStationNum() {
		return stationNum;
	}
	public void setStationNum(Integer stationNum) {
		this.stationNum = stationNum;
	}
	public String getGasType() {
		return gasType;
	}
	public void setGasType(String gasType) {
		this.gasType = gasType;
	}

	public BigDecimal getAccount() {
		return account;
	}
	public void setAccount(BigDecimal account) {
		this.account = account;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRecordType() {
		return recordType;
	}
	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}
	public String getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}
	public String getOilName() {
		return oilName;
	}
	public void setOilName(String oilName) {
		this.oilName = oilName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getTotalAccount() {
		return totalAccount;
	}
	public void setTotalAccount(BigDecimal totalAccount) {
		this.totalAccount = totalAccount;
	}
	public BigDecimal getTradeAmount() {
		return tradeAmount;
	}
	public void setTradeAmount(BigDecimal tradeAmount) {
		this.tradeAmount = tradeAmount;
	}
	public String getCardTradeNum() {
		return cardTradeNum;
	}
	public void setCardTradeNum(String cardTradeNum) {
		this.cardTradeNum = cardTradeNum;
	}
	public BigDecimal getCardLeftMoney() {
		return cardLeftMoney;
	}
	public void setCardLeftMoney(BigDecimal cardLeftMoney) {
		this.cardLeftMoney = cardLeftMoney;
	}
	public String getTradeLocation() {
		return tradeLocation;
	}
	public void setTradeLocation(String tradeLocation) {
		this.tradeLocation = tradeLocation;
	}
	public Integer getTradeNum() {
		return tradeNum;
	}
	public void setTradeNum(Integer tradeNum) {
		this.tradeNum = tradeNum;
	}
	@Override
	public String toString() {
		return "OperateLogBean [oilGunNum=" + oilGunNum + ", cardNum="
				+ cardNum + ", posTTC=" + posTTC + ", tradeType=" + tradeType
				+ ", stationNum=" + stationNum + ", gasType=" + gasType
				+ ", payType=" + payType + ", companyName=" + companyName
//				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", recordType=" + recordType + ", tradeTime=" + tradeTime
				+ ", oilName=" + oilName + ", price=" + price
				+ ", totalAccount=" + totalAccount + ", tradeAmount="
				+ tradeAmount + ", cardTradeNum=" + cardTradeNum
				+ ", cardLeftMoney=" + cardLeftMoney + ", tradeLocation="
				+ tradeLocation + ", tradeNum=" + tradeNum + "]";
	}
	
}
