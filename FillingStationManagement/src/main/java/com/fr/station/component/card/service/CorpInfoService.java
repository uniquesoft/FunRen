package com.fr.station.component.card.service;

import com.fr.station.common.bean.card.UpdateCardInfoBean;
import com.fr.station.component.card.dao.CorpInfoDAO;

/*
 * 定义cardMaintainService接口，用于实现卡片维护界面的查询等操作
 * 
 * @author:yy
 */
public interface CorpInfoService {

	public void setCorpInfoDAO(CorpInfoDAO reportCorpInfoDaoImpl);

	/**
	 * 得到客户信息
	 */
	public UpdateCardInfoBean getCorpInfo(UpdateCardInfoBean updateCardInfoBean) throws Exception;

	/**
	 * 更改客户信息
	 */
	public void saveCorpInfo(UpdateCardInfoBean updateCardInfoBean);

}
