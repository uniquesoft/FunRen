﻿/*
 * 卡片管理表 <-- > 卡领取 Revised history Copyright(c) 2010 FR Co.,Ltd
 */

package com.fr.station.common.entity.card;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fr.station.common.bean.system.StandardBean;

/**
 * TODO - High level description about type's responsibility.
 * 
 * @trace TODO
 * @author wangshuqing
 */
@Entity
@Table(name = "FK_T_CARDINOUT")
public class FkTCardInOutEntity implements StandardBean {

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

	@OneToMany(mappedBy = "cardInOutEntity")
	private Set<CardStorageDetailEntity> cardStorDetEntity;

	/**
	 * 日期
	 */
	@Column(name = "`WORKDATE`")
	private Date workdate;

	@Column(name = "`INOUTNO`")
	private String inOutNo;

	@Column(name = "STYPE")
	private String receiptType;

	@Column(name = "SSTATUS")
	private String receiptStatus;

	@Column(name = "OUTNO")
	private String supplier;

	@Column(name = "OUTDATE")
	private Date leftStorageDate;

	@Column(name = "INNO")
	private String receiver;

	@Column(name = "INDATE")
	private Date putInStorageDate;

	@Column(name = "CARDSUM")
	private Integer cardAcount;

	@Column(name = "CARDGG")
	private String cardType;

	@Column(name = "NOTE")
	private String note;

	@Column(name = "STATIONNO")
	private String stationNo;

	@Column(name = "USERID")
	private String operatorId;

	@Column(name = "BZ")
	private String bz;

	@Column(name = "ACCNO")
	private String classNo;

	@Column(name = "ACCDATE")
	private String classDate;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInOutNo() {
		return this.inOutNo;
	}

	public void setInOutNo(String inOutNo) {
		this.inOutNo = inOutNo;
	}

	public String getReceiptType() {
		return this.receiptType;
	}

	public void setReceiptType(String receiptType) {
		this.receiptType = receiptType;
	}

	public String getReceiptStatus() {
		return this.receiptStatus;
	}

	public void setReceiptStatus(String receiptStatus) {
		this.receiptStatus = receiptStatus;
	}

	public String getSupplier() {
		return this.supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Date getLeftStorageDate() {
		return this.leftStorageDate;
	}

	public void setLeftStorageDate(Date leftStorageDate) {
		this.leftStorageDate = leftStorageDate;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public Date getPutInStorageDate() {
		return this.putInStorageDate;
	}

	public void setPutInStorageDate(Date putInStorageDate) {
		this.putInStorageDate = putInStorageDate;
	}

	public Integer getCardAcount() {
		return this.cardAcount;
	}

	public String getClassNo() {
		return this.classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public String getClassDate() {
		return this.classDate;
	}

	public void setClassDate(String classDate) {
		this.classDate = classDate;
	}

	public void setCardAcount(Integer cardAcount) {
		this.cardAcount = cardAcount;
	}

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStationNo() {
		return this.stationNo;
	}

	public Set<CardStorageDetailEntity> getCardStorDetEntity() {
		return this.cardStorDetEntity;
	}

	public void setCardStorDetEntity(Set<CardStorageDetailEntity> cardStorDetEntity) {
		this.cardStorDetEntity = cardStorDetEntity;
	}

	public void setStationNo(String stationNo) {
		this.stationNo = stationNo;
	}

	public String getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public void setWorkdate(Date workdate) {
		this.workdate = workdate;
	}

	public Date getWorkdate() {
		return this.workdate;
	}

	@Override
	public String toString() {
		return "FkTCardInOutEntity [id=" + this.id + ", workdate=" + this.workdate + ", inOutNo=" + this.inOutNo
				+ ", receiptType=" + this.receiptType + ", receiptStatus=" + this.receiptStatus + ", supplier=" + this.supplier
				+ ", leftStorageDate=" + this.leftStorageDate + ", receiver=" + this.receiver + ", putInStorageDate="
				+ this.putInStorageDate + ", cardAcount=" + this.cardAcount + ", cardType=" + this.cardType + ", note="
				+ this.note + ", stationNo=" + this.stationNo + ", operatorId=" + this.operatorId + ", bz=" + this.bz + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.bz == null) ? 0 : this.bz.hashCode());
		result = prime * result + ((this.cardAcount == null) ? 0 : this.cardAcount.hashCode());
		result = prime * result + ((this.cardStorDetEntity == null) ? 0 : this.cardStorDetEntity.hashCode());
		result = prime * result + ((this.cardType == null) ? 0 : this.cardType.hashCode());
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result + ((this.inOutNo == null) ? 0 : this.inOutNo.hashCode());
		result = prime * result + ((this.leftStorageDate == null) ? 0 : this.leftStorageDate.hashCode());
		result = prime * result + ((this.note == null) ? 0 : this.note.hashCode());
		result = prime * result + ((this.operatorId == null) ? 0 : this.operatorId.hashCode());
		result = prime * result + ((this.putInStorageDate == null) ? 0 : this.putInStorageDate.hashCode());
		result = prime * result + ((this.receiptStatus == null) ? 0 : this.receiptStatus.hashCode());
		result = prime * result + ((this.receiptType == null) ? 0 : this.receiptType.hashCode());
		result = prime * result + ((this.receiver == null) ? 0 : this.receiver.hashCode());
		result = prime * result + ((this.stationNo == null) ? 0 : this.stationNo.hashCode());
		result = prime * result + ((this.supplier == null) ? 0 : this.supplier.hashCode());
		result = prime * result + ((this.workdate == null) ? 0 : this.workdate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		FkTCardInOutEntity other = (FkTCardInOutEntity) obj;
		if (this.bz == null) {
			if (other.bz != null) {
				return false;
			}
		} else if (!this.bz.equals(other.bz)) {
			return false;
		}
		if (this.cardAcount == null) {
			if (other.cardAcount != null) {
				return false;
			}
		} else if (!this.cardAcount.equals(other.cardAcount)) {
			return false;
		}
		if (this.cardStorDetEntity == null) {
			if (other.cardStorDetEntity != null) {
				return false;
			}
		} else if (!this.cardStorDetEntity.equals(other.cardStorDetEntity)) {
			return false;
		}
		if (this.cardType == null) {
			if (other.cardType != null) {
				return false;
			}
		} else if (!this.cardType.equals(other.cardType)) {
			return false;
		}
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		if (this.inOutNo == null) {
			if (other.inOutNo != null) {
				return false;
			}
		} else if (!this.inOutNo.equals(other.inOutNo)) {
			return false;
		}
		if (this.leftStorageDate == null) {
			if (other.leftStorageDate != null) {
				return false;
			}
		} else if (!this.leftStorageDate.equals(other.leftStorageDate)) {
			return false;
		}
		if (this.note == null) {
			if (other.note != null) {
				return false;
			}
		} else if (!this.note.equals(other.note)) {
			return false;
		}
		if (this.operatorId == null) {
			if (other.operatorId != null) {
				return false;
			}
		} else if (!this.operatorId.equals(other.operatorId)) {
			return false;
		}
		if (this.putInStorageDate == null) {
			if (other.putInStorageDate != null) {
				return false;
			}
		} else if (!this.putInStorageDate.equals(other.putInStorageDate)) {
			return false;
		}
		if (this.receiptStatus == null) {
			if (other.receiptStatus != null) {
				return false;
			}
		} else if (!this.receiptStatus.equals(other.receiptStatus)) {
			return false;
		}
		if (this.receiptType == null) {
			if (other.receiptType != null) {
				return false;
			}
		} else if (!this.receiptType.equals(other.receiptType)) {
			return false;
		}
		if (this.receiver == null) {
			if (other.receiver != null) {
				return false;
			}
		} else if (!this.receiver.equals(other.receiver)) {
			return false;
		}
		if (this.stationNo == null) {
			if (other.stationNo != null) {
				return false;
			}
		} else if (!this.stationNo.equals(other.stationNo)) {
			return false;
		}
		if (this.supplier == null) {
			if (other.supplier != null) {
				return false;
			}
		} else if (!this.supplier.equals(other.supplier)) {
			return false;
		}
		if (this.workdate == null) {
			if (other.workdate != null) {
				return false;
			}
		} else if (!this.workdate.equals(other.workdate)) {
			return false;
		}
		return true;
	}

}
