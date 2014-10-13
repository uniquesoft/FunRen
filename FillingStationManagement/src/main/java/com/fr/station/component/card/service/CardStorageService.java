package com.fr.station.component.card.service;

import java.util.List;

import com.fr.station.common.bean.card.CardStorageBean;
import com.fr.station.common.entity.card.FkTCardInOutEntity;

/**
 * 该接口用于获得卡各种记录
 * 
 * @trace FR.ICCardManagement.OperatorLogEntity.Table
 * 
 * @author hjq
 */

public interface CardStorageService {

	public List<FkTCardInOutEntity> findAllShiftChangeRecords() throws Exception;

	/**
	 * 获得每条卡出入库记录显示在jsp页面上
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CardStorageBean CardStorageBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<CardStorageBean> findCardStorageRecordsByCriteria(CardStorageBean cardStorageBean);

	/**
	 * save cardlist application into DB
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CardStorageBean CardStorageBean include the search criteria.
	 * 
	 * @return success infomation
	 */
	public void addCardOrder(CardStorageBean cardStorageBean);

	/**
	 * get card order into DB
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CardStorageBean CardStorageBean include the search criteria.
	 * 
	 * @return card order to jsp
	 */

	public List<CardStorageBean> getCardByFormCondition(CardStorageBean cardStorageBean) throws Exception;

}
