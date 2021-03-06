package com.fr.station.component.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.QueryException;
import org.springframework.stereotype.Repository;

import com.fr.station.common.bean.customer.RegisterCustomerBean;
import com.fr.station.common.data.ApplicationContext;
import com.fr.station.common.entity.card.CardEntity;
import com.fr.station.common.utility.ErrorLogUtil;
import com.fr.station.component.customer.dao.RegisterCustomerDAO;
import com.fr.station.component.system.dao.AbstractBaseDAO;

/**
 * this DaoImpl is for find registerCustomer records from DB to display in displayRegisterCustomer.jsp by implements
 * getRegisterCustomerRecordsByCriteria() method
 * 
 * @author WR
 */
@Repository
public class RegisterCustomerDaoImpl extends AbstractBaseDAO<CardEntity> implements RegisterCustomerDAO {

	// ------- Constants (static final) ----------------------------------------
	private static Logger log = Logger.getLogger(RegisterCustomerDaoImpl.class);

	/**
	 * 查询已售卡一览SQL
	 */
	private final String registerCustomerSql = " SELECT card.guestName, card.guestNo, card.cardNo, card.cardStatus, card.guestType, "
			+ " card.guestNum, card.guestTel, CONVERT(varchar(100), card.create_date, 23), card.stationNo, card.cardType FROM FK_T_CARD card WHERE ";

	/**
	 * 统计已售卡一览SQL
	 */
	private final String countRegisterCustomerSql = " SELECT count(*) FROM FK_T_CARD card WHERE ";

	private final String updateSysParameterAttriValueSql = "UPDATE stationParameter SET attriValue = attriValue + '1'  WHERE attriName = ? ";

	private final String selectShiftChangeNumSql = "SELECT co.create_date, ci.MaxNo, co.id FROM (SELECT MAX (class_no) AS MaxNo FROM [dbo].[CLASS_INFO]) ci INNER JOIN CLASS_INFO co ON co.class_no = ci.MaxNo";

	/**
	 * stationParameter表选择客户编号SQL
	 */
	private final String selectGuestNumSql = "SELECT attriValue FROM stationParameter WHERE attriName = 'guestNo' ";

	/**
	 * stationParameter表选择业务流水号SQL
	 */
	private final String selectSeriaNumSql = "SELECT attriValue FROM stationParameter WHERE attriName = 'seriaNum' ";

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	// ------- Constructors ----------------------------------------------------

	public RegisterCustomerDaoImpl() {
		super();
	}

	// ------- Instance Methods (public) ---------------------------------------

	/**
	 * @Inherited doc 获得开户售卡时的客户编号
	 */
	@Override
	public Integer getGuestNo() {
		Integer guestNo = 0;
		try {
			List<?> resultList = this.findBySql(this.selectGuestNumSql);
			if (resultList.size() > 0) {
				guestNo = (Integer) resultList.get(0);
			}
		} catch (Exception e) {
			log.info("Sql is not correct, please check it again, more detail please see the detail log\n" + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
		}
		return guestNo;
	}

	/**
	 * @Inherited doc 获得开户售卡时的业务流水号
	 */
	@Override
	public Integer getSeriaNum() {
		Integer seriaNum = 0;
		try {
			List<?> resultList = this.findBySql(this.selectSeriaNumSql);
			if (resultList.size() > 0) {
				seriaNum = (Integer) resultList.get(0);
			}
		} catch (Exception e) {
			log.info("Sql is not correct, please check it again, more detail please see the detail log\n" + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
		}
		return seriaNum;
	}

	/**
	 * @Inherited doc 使客户编号自增1
	 */
	@Override
	public void updateGuestNo() {
		Object[] args = { "guestNo" };
		// 执行SQL
		this.upateBySql(this.updateSysParameterAttriValueSql, args);
	}

	/**
	 * @Inherited doc 使业务流水号自增1
	 */
	@Override
	public void updateSeriaNum() {
		Object[] args = { "seriaNum" };
		// 执行SQL
		this.upateBySql(this.updateSysParameterAttriValueSql, args);
	}

	/**
	 * @Inherited doc 获得班结号
	 */
	@Override
	public Object[] getClassNum() {
		Object[] resultArray = null;
		try {
			// 执行SQL
			List<?> resultList = this.findBySql(this.selectShiftChangeNumSql);
			if (resultList.size() > 0) {
				resultArray = (Object[]) resultList.get(0);
			}
		} catch (Exception e) {
			log.info("Sql is not correct, please check it again, more detail please see the detail log\n" + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
		}
		return resultArray;

	}

	/**
	 * @Inherited doc 根据查询条件查询已售卡一览和其客户信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RegisterCustomerBean> getRegisterCustomerRecordsByCriteria(RegisterCustomerBean registerCustomerBean,
			int startPage, int number) {
		List<RegisterCustomerBean> resultList = null;
		int totalSize = 0;
		StringBuilder builderForPagination = new StringBuilder();
		StringBuilder builderForTotalResult = new StringBuilder();
		// 传送SQL语句
		builderForPagination.append(this.registerCustomerSql);
		// 传送SQL语句
		builderForTotalResult.append(this.countRegisterCustomerSql);
		try {
			StringBuilder builder = this.validateInputCriteria(registerCustomerBean);
			// 传送SQL查询条件
			builderForPagination.append(builder).append(" ORDER BY card.cardNo ");
			// 传送SQL查询条件
			builderForTotalResult.append(builder);
			// 执行SQL
			Query query = this.getQueryByCriteria(builderForPagination.toString());
			// 执行SQL
			Object[] resultAccount = this.findBySql(builderForTotalResult.toString()).toArray();
			if (resultAccount != null) {
				totalSize = (int) resultAccount[0];
			}
			// 设置dataGrid起始页
			query.setFirstResult(startPage);
			// 设置查询记录数
			query.setMaxResults(number);
			List<Object[]> result = query.list();
			// 把查询结果覆盖到bean
			resultList = this.convertDataToBean(result, totalSize);
		} catch (QueryException e) {
			log.info("Sql is not correct, please check it again, more detail please see the detail log\n" + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("Get DB data occured error, more detail please see the detail log\n" + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
		}
		return resultList;
	}

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------

	/**
	 * 已售卡一览查询条件
	 */
	private StringBuilder validateInputCriteria(RegisterCustomerBean registerCustomerBean) {
		StringBuilder builder = new StringBuilder();
		// 判断查询条件SQL是否加 AND 的标识
		boolean searchFlag = false;
		if (StringUtils.isNotEmpty(registerCustomerBean.getCardNo())) {
			searchFlag = this.indicateSearchFlag(builder, searchFlag);
			// 卡号
			builder.append(" card.cardNo = '").append(registerCustomerBean.getCardNo()).append("' ");
		}
		if (StringUtils.isNotEmpty(registerCustomerBean.getGuestName())) {
			searchFlag = this.indicateSearchFlag(builder, searchFlag);
			// 客户姓名
			builder.append(" card.guestName = '").append(registerCustomerBean.getGuestName()).append("' ");
		}
		if (StringUtils.isNotEmpty(registerCustomerBean.getCardExno())) {
			searchFlag = this.indicateSearchFlag(builder, searchFlag);
			// 卡印刷号
			builder.append(" card.cardExno = '").append(registerCustomerBean.getCardExno()).append("' ");
		}
		if (StringUtils.isNotEmpty(registerCustomerBean.getCardType())) {
			searchFlag = this.indicateSearchFlag(builder, searchFlag);
			// 卡片类型
			builder.append(" card.cardType = '").append(registerCustomerBean.getCardType()).append("' ");
		}
		if (StringUtils.isNotEmpty(registerCustomerBean.getGuestType())) {
			searchFlag = this.indicateSearchFlag(builder, searchFlag);
			// 证件类型
			builder.append(" card.guestType = '").append(registerCustomerBean.getGuestType()).append("' ");
		}
		if (StringUtils.isNotEmpty(registerCustomerBean.getGuestNum())) {
			searchFlag = this.indicateSearchFlag(builder, searchFlag);
			// 证件号码
			builder.append(" card.guestNum = '").append(registerCustomerBean.getGuestNum()).append("' ");
		}
		if (StringUtils.isNotEmpty(ApplicationContext.getInstance().getStationNum())) {
			searchFlag = this.indicateSearchFlag(builder, searchFlag);
			// 站点编号
			builder.append(" card.stationNo = '").append(ApplicationContext.getInstance().getStationNum()).append("' ");
		}
		return builder;
	}

	/**
	 * 判断SQL前是否加AND
	 */
	private boolean indicateSearchFlag(StringBuilder builder, boolean searchFlag) {
		if (searchFlag) {
			builder.append(" AND ");
		} else {
			searchFlag = true;
		}
		return searchFlag;
	}

	/**
	 * 把已售卡一览查询结果覆盖到RegisterCustomerBean
	 */
	private List<RegisterCustomerBean> convertDataToBean(List<Object[]> dataResult, int totalAccount) {
		List<RegisterCustomerBean> registerCustomerBeanList = new ArrayList<RegisterCustomerBean>();
		RegisterCustomerBean registerCustomerBean = null;
		for (Object[] dataRow : dataResult) {
			registerCustomerBean = new RegisterCustomerBean();
			// 客户姓名
			registerCustomerBean.setGuestName(String.valueOf(dataRow[0]));
			// 客户编号
			registerCustomerBean.setGuestNo(String.valueOf(dataRow[1]));
			// 卡号
			registerCustomerBean.setCardNo(String.valueOf(dataRow[2]));
			// 卡状态
			registerCustomerBean.setCardStatus(String.valueOf(dataRow[3]));
			// 证件类型
			registerCustomerBean.setGuestType(String.valueOf(dataRow[4]));
			// 证件号码
			registerCustomerBean.setGuestNum(String.valueOf(dataRow[5]));
			// 联系电话
			registerCustomerBean.setGuestTel(String.valueOf(dataRow[6]));
			// 创建日期
			registerCustomerBean.setCreate_date(String.valueOf(dataRow[7]));
			// 站点编号
			registerCustomerBean.setStationNo(String.valueOf(dataRow[8]));
			// 卡片类型
			registerCustomerBean.setCardType(String.valueOf(dataRow[9]));
			// 记录数
			registerCustomerBean.setTotalData(totalAccount);

			registerCustomerBeanList.add(registerCustomerBean);
		}
		return registerCustomerBeanList;
	}

}
