/*
 * 卡信息 <--- >发卡信息（Delphi） Revised history Copyright(c) 2010 FR Co.,Ltd
 */

package com.fr.station.common.entity.card;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fr.station.common.entity.base.BaseEntity;

/**
 * 卡信息
 *
 * @version 1.0
 * @authorguyj
 */
@Entity
@Table(name = "FK_T_CardTZ")
public class FKTCardTZEntity extends BaseEntity {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

//	@OneToOne
//	@JoinColumn(name = "cardId")
//	private FkTCardEntity cardEntity;

	/**
	 * 账户余额
	 */
	@Column(name = "`cardbal`")
	private BigDecimal cardbal;

	/**
	 * 充值金额
	 */
	@Column(name = "`cardinc`")
	private BigDecimal cardinc;

	/**
	 * 消费金额
	 */
	@Column(name = "`carddec`")
	private BigDecimal carddec;

	/**
	 * 预分配金额
	 */
	@Column(name = "`pre`")
	private BigDecimal pre;

	/**
	 * 积分
	 */
	@Column(name = "`SCORE`")
	private BigDecimal SCORE;

	/**
	 * 卡号
	 */
	@Column(name = "`cardNo`")
	private String cardNo;

	@Column(name = "`create_date`")
	private Date createDate;

	@Column(name = "`update_date`")
	private Date updateDate;

	@Column(name = "`userid`")
	private int userid;

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getCardbal() {
		return this.cardbal;
	}

	public void setCardbal(BigDecimal cardbal) {
		this.cardbal = cardbal;
	}

	public BigDecimal getCardinc() {
		return this.cardinc;
	}

	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public void setCardinc(BigDecimal cardinc) {
		this.cardinc = cardinc;
	}

	public BigDecimal getCarddec() {
		return this.carddec;
	}

	public void setCarddec(BigDecimal carddec) {
		this.carddec = carddec;
	}

	public BigDecimal getPre() {
		return this.pre;
	}

	public void setPre(BigDecimal pre) {
		this.pre = pre;
	}

	public BigDecimal getSCORE() {
		return this.SCORE;
	}

	public void setSCORE(BigDecimal sCORE) {
		this.SCORE = sCORE;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.SCORE == null) ? 0 : this.SCORE.hashCode());
		result = prime * result + ((this.cardbal == null) ? 0 : this.cardbal.hashCode());
		result = prime * result + ((this.carddec == null) ? 0 : this.carddec.hashCode());
		result = prime * result + ((this.cardinc == null) ? 0 : this.cardinc.hashCode());
		result = prime * result + ((this.createDate == null) ? 0 : this.createDate.hashCode());
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result + ((this.pre == null) ? 0 : this.pre.hashCode());
		result = prime * result + ((this.updateDate == null) ? 0 : this.updateDate.hashCode());
		result = prime * result + this.userid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		FKTCardTZEntity other = (FKTCardTZEntity) obj;
		if (this.SCORE == null) {
			if (other.SCORE != null) {
				return false;
			}
		} else if (!this.SCORE.equals(other.SCORE)) {
			return false;
		}
		if (this.cardbal == null) {
			if (other.cardbal != null) {
				return false;
			}
		} else if (!this.cardbal.equals(other.cardbal)) {
			return false;
		}
		if (this.carddec == null) {
			if (other.carddec != null) {
				return false;
			}
		} else if (!this.carddec.equals(other.carddec)) {
			return false;
		}
		if (this.cardinc == null) {
			if (other.cardinc != null) {
				return false;
			}
		} else if (!this.cardinc.equals(other.cardinc)) {
			return false;
		}
		if (this.createDate == null) {
			if (other.createDate != null) {
				return false;
			}
		} else if (!this.createDate.equals(other.createDate)) {
			return false;
		}
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		if (this.pre == null) {
			if (other.pre != null) {
				return false;
			}
		} else if (!this.pre.equals(other.pre)) {
			return false;
		}
		if (this.updateDate == null) {
			if (other.updateDate != null) {
				return false;
			}
		} else if (!this.updateDate.equals(other.updateDate)) {
			return false;
		}
		if (this.userid != other.userid) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "FKTCardTZEntity [id=" + this.id + ", cardbal=" + this.cardbal + ", cardinc=" + this.cardinc
				+ ", carddec=" + this.carddec + ", pre=" + this.pre + ", SCORE=" + this.SCORE + ", cardNo=" + this.cardNo + ", createDate="
				+ this.createDate + ", updateDate=" + this.updateDate + ", userid=" + this.userid + "]";
	}

}
