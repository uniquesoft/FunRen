package com.fr.station.component.card.service;

import java.util.List;

import com.fr.station.common.bean.card.UpdateCardInfoBean;
import com.fr.station.component.card.dao.CardInfoDAO;

/*
 * 定义cardMaintainService接口，用于实现卡片维护界面的查询等操作
 * 
 * @author:yy
 */
public interface CardInfoService {

	public void setCardInfoDAO(CardInfoDAO reportCardInfoDaoImpl);

	/**
	 * 得到卡片明细信息
	 */
	public UpdateCardInfoBean getCardInfo(UpdateCardInfoBean updateCardInfoBean) throws Exception;

	/**
	 * 得到司机卡片明细信息
	 */
	public UpdateCardInfoBean getDriverCardInfo(UpdateCardInfoBean updateCardInfoBean) throws Exception;

	/**
	 * 更改卡片信息
	 */
	public void saveCardInfo(UpdateCardInfoBean updateCardInfoBean);

	/**
	 * 获得每条副卡记录显示在jsp页面上
	 */
	public List<UpdateCardInfoBean> findViceCardsRecordsByCriteria(UpdateCardInfoBean updateCardInfoBean) throws Exception;

	/**
	 * 得到卡片明细信息
	 */
	public List<UpdateCardInfoBean> getCardDetail(UpdateCardInfoBean updateCardInfoBean) throws Exception;
}
