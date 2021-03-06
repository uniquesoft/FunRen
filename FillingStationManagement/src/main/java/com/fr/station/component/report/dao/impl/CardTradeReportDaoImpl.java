package com.fr.station.component.report.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.QueryException;
import org.springframework.stereotype.Repository;

import com.fr.station.common.bean.report.CardTradeReportBean;
import com.fr.station.common.consts.SqlConsts;
import com.fr.station.common.data.ApplicationContext;
import com.fr.station.common.entity.card.FkTCreditEntity;
import com.fr.station.common.utility.DateUtil;
import com.fr.station.common.utility.ErrorLogUtil;
import com.fr.station.common.utility.StringUtil;
import com.fr.station.component.report.dao.CardTradeReportDAO;
import com.fr.station.component.system.dao.AbstractBaseDAO;

/**
 * The action for dashboard. It handles the user request from the web sites. Mainly responsible to handle user login
 * 
 * @author hjq
 */
@Repository
public class CardTradeReportDaoImpl extends AbstractBaseDAO<FkTCreditEntity> implements CardTradeReportDAO {

	// ------- Constants (static final) ----------------------------------------
	private static Logger log = Logger.getLogger(CardTradeReportDaoImpl.class);

	private static final String CARD_GUEST_NAME = "card.guestname";

	private static final String CREDIT_GUEST_NAME = "credit.guestname";

	private static final String CARD_GUEST_NO = "card.guestno";

	private static final String CREDIT_GUEST_NO = "credit.guestno";

	private static final String CARDPRE_GUEST_NO = "cardpre.guestno";

	private static final String CARD_CARD_NO = "card.cardno";

	private static final String CREDIT_CARD_NO = "credit.cardno";

	private static final String CARDPRE_CARD_NO = "cardpre.cardno";

	private static final String TRADE_DATE = "credit.workdate";

	private static final String CARDPRE_TRADE_DATE = "cardpre.create_date";

	private static final String CARD_TYPE = "card.cardtype";

	private static final String PAY_TYPE = "credit.zffs";

	private static final String TRADE_TYPE = "credit.inctype";

	private static final String INC_TYPE = "credit.inctype";

	private static final String STATION_NO = "credit.stationNo";

	private static final String CARDPRE_STATION_NO = "cardpre.stationNo";

	private final String selectCommonSql = "select count(*) from FK_T_CARD card, ";

	private final String selectCardTradeRecordsSql = "select CONVERT(varchar(19), credit.workdate, 21) workdate, credit.incno, credit.guestname, credit.cardno, card.cardstatus, credit.cardbeg, credit.cardinc, credit.cardbal, credit.inctype, credit.userid, card.cardtype, credit.transfertype from FK_T_CARD card, FK_T_CREDIT credit WHERE ";

	private final String selectAllCountCardTradeRecordsSql = this.selectCommonSql + " FK_T_CREDIT credit WHERE ";

	private final String selectGuestCreditRecordsSql = "select CONVERT(varchar(19), credit.workdate, 21) workdate, credit.incno, credit.guestname, card.cardno, card.cardstatus, credit.pre, credit.amn, credit.bal, credit.inctype, credit.userid,credit.zffs from FK_T_CARD card, FK_TT_GUESTCREDIT credit WHERE card.cardFlag = 'Y' and ";

	private final String selectAllCountGuestCreditRecordsSql = this.selectCommonSql + " FK_TT_GUESTCREDIT credit WHERE ";

	private final String selectCardPreRecordsSql = "select CONVERT(varchar(19), cardpre.create_date, 21) workdate, cardpre.guestno, cardpre.cardno, cardpre.pre, cardpre.billsNo, cardpre.userid, cardpre.billsType from FK_T_CARD card, FK_TT_CARDPRE cardpre WHERE ";

	private final String selectAllCountCardPreRecordsSql = this.selectCommonSql + "  FK_TT_CARDPRE cardpre WHERE ";

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	// ------- Constructors ----------------------------------------------------
	public CardTradeReportDaoImpl() {
		super();
	}

	// ------- Instance Methods (public) ---------------------------------------

	@SuppressWarnings("unchecked")
	@Override
	public List<CardTradeReportBean> getCardTradeRecordsByCriteria(CardTradeReportBean cardTradeBean) {
		List<CardTradeReportBean> resultList = null;
		try {
			// retrieve search value from client request.
			StringBuilder builder = this.validateInputCriteria(cardTradeBean);

			// retrieve current query by input sql.
			Query query = this.createSpecifiedQuery(builder, this.selectCardTradeRecordsSql);

			// get total records by specified sql.
			int totalSize = this.getTotalCount(builder, this.selectAllCountCardTradeRecordsSql);

			// this is for pagination.
			this.setPaginationNumber(cardTradeBean, query);

			// get result list.
			List<Object[]> result = query.list();

			resultList = this.convertDataToBean(result, totalSize);
		} catch (QueryException e) {
			log.info("Sql is not correct, please check it again, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("Get DB data occured error, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		}
		return resultList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CardTradeReportBean> getGuestCreditRecordsByCriteria(CardTradeReportBean cardTradeBean) {
		List<CardTradeReportBean> resultList = null;
		try {
			// retrieve search value from client request.
			StringBuilder builder = this.validate(cardTradeBean);

			// retrieve current query by input sql.
			Query query = this.createSpecifiedQuery(builder, this.selectGuestCreditRecordsSql);

			// get total records by specified sql.
			int totalSize = this.getTotalCount(builder, this.selectAllCountGuestCreditRecordsSql);

			// this is for pagination.
			this.setPaginationNumber(cardTradeBean, query);

			// get result list.
			List<Object[]> result = query.list();

			resultList = this.convertDataToBeanForGuestPayment(result, totalSize);

		} catch (QueryException e) {
			log.info("Sql is not correct, please check it again, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("Get DB data occured error, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		}
		return resultList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CardTradeReportBean> getCardPredistributionRecordsByCriteria(CardTradeReportBean cardTradeBean) {
		List<CardTradeReportBean> resultList = null;
		try {
			// retrieve search value from client request.
			StringBuilder builder = this.cardpreValidate(cardTradeBean);

			// retrieve current query by input sql.
			Query query = this.createSpecifiedQuery(builder, this.selectCardPreRecordsSql);

			// get total records by specified sql.
			int totalSize = this.getTotalCount(builder, this.selectAllCountCardPreRecordsSql);

			// this is for pagination.
			this.setPaginationNumber(cardTradeBean, query);

			// get result list.
			List<Object[]> result = query.list();

			resultList = this.convertDataToBeanForCardPre(result, totalSize);

		} catch (QueryException e) {
			log.info("Sql is not correct, please check it again, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("Get DB data occured error, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		}
		return resultList;

	}

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------

	private StringBuilder validateInputCriteria(CardTradeReportBean cardTradeBean) {
		StringBuilder builder = new StringBuilder();
		builder.append(STATION_NO).append(SqlConsts.EQUAL)
				.append(Integer.valueOf(ApplicationContext.getInstance().getStationNum()));
		builder.append(SqlConsts.ADD).append(CARD_CARD_NO).append(SqlConsts.EQUAL).append(CREDIT_CARD_NO);
		if (StringUtil.isNotEmpty(cardTradeBean.getGuestName())) {
			builder.append(SqlConsts.ADD).append(CARD_GUEST_NAME).append(SqlConsts.EQUAL).append(CREDIT_GUEST_NAME);
			builder.append(SqlConsts.ADD).append(CREDIT_GUEST_NAME).append(SqlConsts.EQUAL).append(SqlConsts.SINGLE_QUOTES)
					.append(cardTradeBean.getGuestName()).append(SqlConsts.SINGLE_QUOTES);
		}
		if (StringUtil.isNotEmpty(cardTradeBean.getCardNo())) {
			builder.append(SqlConsts.ADD).append(CARD_CARD_NO).append(SqlConsts.EQUAL).append(SqlConsts.SINGLE_QUOTES)
					.append(cardTradeBean.getCardNo()).append(SqlConsts.SINGLE_QUOTES);
		}
		if (cardTradeBean.getGuestNo() != null) {
			builder.append(SqlConsts.ADD).append(CARD_GUEST_NO).append(SqlConsts.EQUAL).append(cardTradeBean.getGuestNo());
		}
		if (cardTradeBean.getStartDate() != null && cardTradeBean.getEndDate() != null) {
			String startDate = DateUtil.formatDate(cardTradeBean.getStartDate(), DateUtil.DATE_PATTERN_8);
			String endDate = DateUtil.formatDate(cardTradeBean.getEndDate(), DateUtil.DATE_PATTERN_8);
			builder.append(SqlConsts.ADD).append(TRADE_DATE).append(SqlConsts.BETWEEN).append(SqlConsts.SINGLE_QUOTES)
					.append(startDate).append(SqlConsts.SINGLE_QUOTES).append(SqlConsts.ADD).append(SqlConsts.SINGLE_QUOTES)
					.append(endDate).append(SqlConsts.SINGLE_QUOTES);
		} else if (cardTradeBean.getStartDate() != null && cardTradeBean.getEndDate() == null) {
			String startDate = DateUtil.formatDate(cardTradeBean.getStartDate(), DateUtil.DATE_PATTERN_17);
			builder.append(SqlConsts.ADD).append(TRADE_DATE).append(SqlConsts.GE).append(SqlConsts.SINGLE_QUOTES)
					.append(startDate).append(SqlConsts.SINGLE_QUOTES);
		} else if (cardTradeBean.getStartDate() == null && cardTradeBean.getEndDate() != null) {
			String endDate = DateUtil.formatDate(cardTradeBean.getEndDate(), DateUtil.DATE_PATTERN_17);
			endDate = DateUtil.addDays(endDate, 1);
			builder.append(SqlConsts.ADD).append(TRADE_DATE).append(SqlConsts.LT).append(SqlConsts.SINGLE_QUOTES)
					.append(endDate).append(SqlConsts.SINGLE_QUOTES);
		}
		if (StringUtil.isNotEmpty(cardTradeBean.getCardType())) {
			builder.append(SqlConsts.ADD).append(CARD_TYPE).append(SqlConsts.EQUAL).append(SqlConsts.SINGLE_QUOTES)
					.append(cardTradeBean.getCardType()).append(SqlConsts.SINGLE_QUOTES);
		}
		if (StringUtil.isNotEmpty(cardTradeBean.getPayType())) {
			builder.append(SqlConsts.ADD).append(PAY_TYPE).append(SqlConsts.EQUAL).append(SqlConsts.SINGLE_QUOTES)
					.append(cardTradeBean.getPayType()).append(SqlConsts.SINGLE_QUOTES);
		}
		if (StringUtil.isNotEmpty(cardTradeBean.getTradeType())) {
			builder.append(SqlConsts.ADD).append(TRADE_TYPE).append(SqlConsts.EQUAL).append(SqlConsts.SINGLE_QUOTES)
					.append(cardTradeBean.getTradeType()).append(SqlConsts.SINGLE_QUOTES);
		}
		return builder;
	}

	private StringBuilder validate(CardTradeReportBean cardTradeBean) {
		StringBuilder builder = new StringBuilder();
		builder.append(STATION_NO).append(SqlConsts.EQUAL)
				.append(Integer.valueOf(ApplicationContext.getInstance().getStationNum()));
		builder.append(SqlConsts.ADD).append(CREDIT_GUEST_NO).append(SqlConsts.EQUAL).append(CARD_GUEST_NO);

		if (StringUtil.isNotEmpty(cardTradeBean.getGuestName())) {
			builder.append(SqlConsts.ADD).append(CARD_GUEST_NAME).append(SqlConsts.EQUAL).append(CREDIT_GUEST_NAME);
			builder.append(SqlConsts.ADD).append(CREDIT_GUEST_NAME).append(SqlConsts.EQUAL).append(SqlConsts.SINGLE_QUOTES)
					.append(cardTradeBean.getGuestName()).append(SqlConsts.SINGLE_QUOTES);
		}
		if (StringUtil.isNotEmpty(cardTradeBean.getCardNo())) {
			builder.append(SqlConsts.ADD).append(CARD_CARD_NO).append(SqlConsts.EQUAL).append(SqlConsts.SINGLE_QUOTES)
					.append(cardTradeBean.getCardNo()).append(SqlConsts.SINGLE_QUOTES);
		}
		if (cardTradeBean.getGuestNo() != null) {
			builder.append(SqlConsts.ADD).append(CREDIT_GUEST_NO).append(SqlConsts.EQUAL).append(cardTradeBean.getGuestNo());
		}
		if (cardTradeBean.getStartDate() != null && cardTradeBean.getEndDate() != null) {
			String startDate = DateUtil.formatDate(cardTradeBean.getStartDate(), DateUtil.DATE_PATTERN_17);
			String endDate = DateUtil.formatDate(cardTradeBean.getEndDate(), DateUtil.DATE_PATTERN_17);
			builder.append(SqlConsts.ADD).append(TRADE_DATE).append(SqlConsts.BETWEEN).append(SqlConsts.SINGLE_QUOTES)
					.append(startDate).append(SqlConsts.SINGLE_QUOTES).append(SqlConsts.ADD).append(SqlConsts.SINGLE_QUOTES)
					.append(endDate).append(SqlConsts.SINGLE_QUOTES);
		} else if (cardTradeBean.getStartDate() != null && cardTradeBean.getEndDate() == null) {
			String startDate = DateUtil.formatDate(cardTradeBean.getStartDate(), DateUtil.DATE_PATTERN_17);
			builder.append(SqlConsts.ADD).append(TRADE_DATE).append(SqlConsts.GT).append(SqlConsts.SINGLE_QUOTES)
					.append(startDate).append(SqlConsts.SINGLE_QUOTES);
		} else if (cardTradeBean.getStartDate() == null && cardTradeBean.getEndDate() != null) {
			String endDate = DateUtil.formatDate(cardTradeBean.getEndDate(), DateUtil.DATE_PATTERN_17);
			endDate = DateUtil.addDays(endDate, 1);
			builder.append(SqlConsts.ADD).append(TRADE_DATE).append(SqlConsts.LT).append(SqlConsts.SINGLE_QUOTES)
					.append(endDate).append(SqlConsts.SINGLE_QUOTES);
		}

		if (StringUtil.isNotEmpty(cardTradeBean.getPayType())) {
			builder.append(SqlConsts.ADD).append(PAY_TYPE).append(SqlConsts.EQUAL).append(SqlConsts.SINGLE_QUOTES)
					.append(cardTradeBean.getPayType()).append(SqlConsts.SINGLE_QUOTES);
		}
		if (StringUtil.isNotEmpty(cardTradeBean.getTradeType())) {
			builder.append(SqlConsts.ADD).append(TRADE_TYPE).append(SqlConsts.EQUAL).append(SqlConsts.SINGLE_QUOTES)
					.append(cardTradeBean.getTradeType()).append(SqlConsts.SINGLE_QUOTES);
		}
		return builder;
	}

	private StringBuilder cardpreValidate(CardTradeReportBean cardTradeBean) {
		StringBuilder builder = new StringBuilder();
		builder.append(CARDPRE_STATION_NO).append(SqlConsts.EQUAL)
				.append(Integer.valueOf(ApplicationContext.getInstance().getStationNum()));
		builder.append(SqlConsts.ADD).append(CARD_CARD_NO).append(SqlConsts.EQUAL).append(CARDPRE_CARD_NO);
		if (StringUtil.isNotEmpty(cardTradeBean.getGuestName())) {
			builder.append(SqlConsts.ADD).append(CARD_GUEST_NAME).append(SqlConsts.EQUAL).append(SqlConsts.SINGLE_QUOTES)
					.append(cardTradeBean.getGuestName()).append(SqlConsts.SINGLE_QUOTES);
		}
		if (StringUtil.isNotEmpty(cardTradeBean.getCardNo())) {

			builder.append(SqlConsts.ADD).append(CARDPRE_CARD_NO).append(SqlConsts.EQUAL).append(SqlConsts.SINGLE_QUOTES)
					.append(cardTradeBean.getCardNo()).append(SqlConsts.SINGLE_QUOTES);
		}
		if (cardTradeBean.getGuestNo() != null) {
			builder.append(SqlConsts.ADD).append(CARDPRE_GUEST_NO).append(SqlConsts.EQUAL).append(CARD_GUEST_NO);
			builder.append(SqlConsts.ADD).append(CARDPRE_GUEST_NO).append(SqlConsts.EQUAL).append(cardTradeBean.getGuestNo());
		}
		if (cardTradeBean.getStartDate() != null && cardTradeBean.getEndDate() != null) {
			String startDate = DateUtil.formatDate(cardTradeBean.getStartDate(), DateUtil.DATE_PATTERN_8);
			String endDate = DateUtil.formatDate(cardTradeBean.getEndDate(), DateUtil.DATE_PATTERN_8);
			builder.append(SqlConsts.ADD).append(CARDPRE_TRADE_DATE).append(SqlConsts.BETWEEN).append(SqlConsts.SINGLE_QUOTES)
					.append(startDate).append(SqlConsts.SINGLE_QUOTES).append(SqlConsts.ADD).append(SqlConsts.SINGLE_QUOTES)
					.append(endDate).append(SqlConsts.SINGLE_QUOTES);
		} else if (cardTradeBean.getStartDate() != null && cardTradeBean.getEndDate() == null) {
			String startDate = DateUtil.formatDate(cardTradeBean.getStartDate(), DateUtil.DATE_PATTERN_17);
			builder.append(SqlConsts.ADD).append(CARDPRE_TRADE_DATE).append(SqlConsts.GT).append(SqlConsts.SINGLE_QUOTES)
					.append(startDate).append(SqlConsts.SINGLE_QUOTES);
		} else if (cardTradeBean.getStartDate() == null && cardTradeBean.getEndDate() != null) {
			String endDate = DateUtil.formatDate(cardTradeBean.getEndDate(), DateUtil.DATE_PATTERN_17);
			endDate = DateUtil.addDays(endDate, 1);
			builder.append(SqlConsts.ADD).append(CARDPRE_TRADE_DATE).append(SqlConsts.LT).append(SqlConsts.SINGLE_QUOTES)
					.append(endDate).append(SqlConsts.SINGLE_QUOTES);
		}
		/*
		 * String startDate = DateUtil.formatDate(cardTradeBean.getStartDate(), DateUtil.DATE_PATTERN_8); if
		 * (cardTradeBean.getStartDate() != null) {
		 * builder.append(SqlConsts.ADD).append(CARDPRE_TRADE_DATE).append(" >= '").append(startDate).append("'"); }
		 * String endDate = DateUtil.formatDate(cardTradeBean.getEndDate(), DateUtil.DATE_PATTERN_8); if
		 * (cardTradeBean.getEndDate() != null) {
		 * builder.append(SqlConsts.ADD).append(CARDPRE_TRADE_DATE).append(" <= '").append(endDate).append("'"); }
		 */
		return builder;
	}

	private List<CardTradeReportBean> convertDataToBean(List<Object[]> dataResult, int totalAccount) {
		List<CardTradeReportBean> cardTradeBeanList = new ArrayList<CardTradeReportBean>();
		CardTradeReportBean cardTradeBean = null;
		for (Object[] dataRow : dataResult) {
			cardTradeBean = new CardTradeReportBean();
			cardTradeBean.setTradeDate(DateUtil.formatDateYYYY_MM_DD((String) (dataRow[0])));
			cardTradeBean.setIncNo(String.valueOf(dataRow[1]));
			cardTradeBean.setGuestName(String.valueOf(dataRow[2]));
			cardTradeBean.setCardNo(String.valueOf(dataRow[3]));
			cardTradeBean.setCardStatus(String.valueOf(dataRow[4]));
			cardTradeBean.setMoneyBefore(BigDecimal.valueOf(Double.valueOf(String.valueOf(dataRow[5]))));
			cardTradeBean.setTradeMoney(BigDecimal.valueOf(Double.valueOf(String.valueOf(dataRow[6]))));
			cardTradeBean.setMoneyAfter(BigDecimal.valueOf(Double.valueOf(String.valueOf(dataRow[7]))));
			cardTradeBean.setTradeType(String.valueOf(dataRow[8]));
			if (dataRow[9] != null) {
				cardTradeBean.setUserId((String.valueOf(dataRow[9])));
			} else {
				cardTradeBean.setUserId(" ");
			}
			cardTradeBean.setCardType(String.valueOf(dataRow[10]));
			cardTradeBean.setReceiptType(String.valueOf(dataRow[11]));
			cardTradeBean.setTotalData(totalAccount);
			cardTradeBeanList.add(cardTradeBean);
		}
		return cardTradeBeanList;
	}

	private List<CardTradeReportBean> convertDataToBeanForGuestPayment(List<Object[]> dataResult, int totalAccount) {
		List<CardTradeReportBean> cardTradeBeanList = new ArrayList<CardTradeReportBean>();
		CardTradeReportBean cardTradeBean = null;
		for (Object[] dataRow : dataResult) {
			cardTradeBean = new CardTradeReportBean();
			cardTradeBean.setTradeDate(DateUtil.formatDateYYYY_MM_DD((String) (dataRow[0])));
			cardTradeBean.setIncNo(String.valueOf(dataRow[1]));
			cardTradeBean.setGuestName(String.valueOf(dataRow[2]));
			cardTradeBean.setCardNo(String.valueOf(dataRow[3]));
			cardTradeBean.setCardStatus(String.valueOf(dataRow[4]));
			cardTradeBean.setMoneyBefore(BigDecimal.valueOf(Double.valueOf(String.valueOf(dataRow[5]))));
			cardTradeBean.setTradeMoney(BigDecimal.valueOf(Double.valueOf(String.valueOf(dataRow[6]))));
			cardTradeBean.setMoneyAfter(BigDecimal.valueOf(Double.valueOf(String.valueOf(dataRow[7]))));
			cardTradeBean.setTradeType(String.valueOf(dataRow[8]));
			if (dataRow[9] != null) {
				cardTradeBean.setUserId((String.valueOf(dataRow[9])));
			} else {
				cardTradeBean.setUserId(" ");
			}
			cardTradeBean.setPayType(String.valueOf(dataRow[10]));
			cardTradeBean.setTotalData(totalAccount);
			cardTradeBeanList.add(cardTradeBean);
		}
		return cardTradeBeanList;
	}

	private List<CardTradeReportBean> convertDataToBeanForCardPre(List<Object[]> dataResult, int totalAccount) {
		List<CardTradeReportBean> cardTradeBeanList = new ArrayList<CardTradeReportBean>();
		CardTradeReportBean cardTradeBean = null;
		for (Object[] dataRow : dataResult) {
			cardTradeBean = new CardTradeReportBean();
			cardTradeBean.setTradeDate(DateUtil.formatDateYYYY_MM_DD((String) (dataRow[0])));
			cardTradeBean.setGuestNo(Integer.valueOf(String.valueOf(dataRow[1])));
			cardTradeBean.setCardNo(String.valueOf(dataRow[2]));
			cardTradeBean.setPreAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(dataRow[3]))));
			cardTradeBean.setReceiptNo(String.valueOf(dataRow[4]));
			if (dataRow[5] != null) {
				cardTradeBean.setUserId((String.valueOf(dataRow[5])));
			} else {
				cardTradeBean.setUserId(" ");
			}
			cardTradeBean.setReceiptType(String.valueOf(dataRow[6]));
			cardTradeBean.setTotalData(totalAccount);
			cardTradeBeanList.add(cardTradeBean);
		}
		return cardTradeBeanList;
	}

	private void setPaginationNumber(CardTradeReportBean cardTradeBean, Query query) {
		query.setFirstResult(cardTradeBean.getStartNumber());
		query.setMaxResults(cardTradeBean.getTotalNumber());
	}

	private int getTotalCount(StringBuilder builder, String sql) throws Exception {
		List<?> dataResultList = this.findBySql(new StringBuilder().append(sql).append(builder).toString());
		if (dataResultList.size() > 0) {
			return (int) dataResultList.toArray()[0];
		}
		return 0;
	}

	private Query createSpecifiedQuery(StringBuilder builder, String sql) throws Exception {
		return this.getQueryByCriteria(new StringBuilder().append(sql).append(builder).toString());
	}

	// ------- Static Methods --------------------------------------------------

	// ------- Optional Inner Class ------------------------------------------

}
