package com.fr.station.component.system.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fr.station.common.data.ApplicationContext;
import com.fr.station.common.data.DataCollections;
import com.fr.station.common.entity.card.DictionaryEntity;
import com.fr.station.common.entity.report.OilManageEntity;
import com.fr.station.common.entity.system.StationEntity;
import com.fr.station.common.utility.ErrorLogUtil;
import com.fr.station.component.system.dao.EmployeeDAO;
import com.fr.station.component.system.service.InitializeCacheDataService;

/**
 * The service is mainly to used get station trade logs for each car. Mainly responsible to handle different scenario
 * search
 *
 * @author henry
 */
@SuppressWarnings("rawtypes")
@Service
public class InitializeCacheDataServiceImpl extends AbstractBaseService implements InitializeCacheDataService {

	// ------- Constants (static final) ----------------------------------------
	private static Logger log = Logger.getLogger(InitializeCacheDataServiceImpl.class);

	private final String findAllOilManageDataSql = "from OilManageEntity order by id";

	private final String findAllStationInfoDataSql = "from StationEntity order by stationNum";

	private final String findAllDictionaryDataSql = "from DictionaryEntity d where d.useStats = 1 order by id, type";

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	// ------- Constructors ----------------------------------------------------

	public InitializeCacheDataServiceImpl() {
		super();
	}

	// ------- Instance Methods (public) ---------------------------------------

	/**
	 * inherited java doc.
	 *
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void loadCacheData() {
		this.initializeOilData();
		this.initializeDictionaryData();
		this.initializeStationInfoData();
	}

	@Autowired
	public void setDataCenterDAOImpl(EmployeeDAO employeeDaoImpl) {
		super.setBaseDao(employeeDaoImpl);
	}

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------

	/**
	 * prepare the oil type data for first login which is used to in the dataCenter page for search criteria.
	 *
	 *
	 * @return return the list of oilManageEntity.
	 */
	@SuppressWarnings("unchecked")
	private List<OilManageEntity> initializeOilData() {
		List<OilManageEntity> oilMangeEntityList = null;
		log.info("initialize oil price management");
		try {
			oilMangeEntityList = this.findByHql(this.findAllOilManageDataSql);
		} catch (Exception e) {
			log.info("load oil manage entity occured error, more detial please see the detail log.\n"
					+ ErrorLogUtil.printInfo(e));
		}
		this.saveOilDataToCache(oilMangeEntityList);
		log.info("successfully load oil manage entity");
		return oilMangeEntityList;
	}

	@SuppressWarnings("unchecked")
	private List<StationEntity> initializeStationInfoData() {

		List<StationEntity> stationInfoEntityList = null;
		log.info("initialize station info");
		try {
			stationInfoEntityList = this.findByHql(this.findAllStationInfoDataSql);
		} catch (Exception e) {
			log.info("load station info entity occured error, more detial please see the detail log.\n"
					+ ErrorLogUtil.printInfo(e));
		}
		this.saveStationDataToCache(stationInfoEntityList);
		log.info("successfully load station info entity");
		return stationInfoEntityList;

	}

	/**
	 * prepare the dictionary data for first login which is used to in the dataCenter page for search criteria.
	 *
	 *
	 * @return return the list of oilManageEntity.
	 */
	@SuppressWarnings("unchecked")
	private void initializeDictionaryData() {
		List<DictionaryEntity> dictionaryList = null;
		log.info("initialize dictionary data begain");
		try {
			dictionaryList = this.findByHql(this.findAllDictionaryDataSql);
			this.saveDictionaryDataToCache(dictionaryList);
		} catch (Exception e) {
			log.info("load dictionary entity occured error, more detial please see the detail log.\n"
					+ ErrorLogUtil.printInfo(e));
		}
		log.info("successfully load dictionary data entity");
	}

	private void saveOilDataToCache(List<OilManageEntity> oilMangeEntityList) {
		for (OilManageEntity oilMangeEntity : oilMangeEntityList) {
			DataCollections.oilType.put(oilMangeEntity.getOilCode(), oilMangeEntity.getOilName());
		}
	}

	private void saveDictionaryDataToCache(List<DictionaryEntity> dictionaryList) {
		for (DictionaryEntity entity : dictionaryList) {
			switch (entity.getType()) {
				case 1:
					// 用户类型
					DataCollections.dicUseType.put(entity.getValue(), entity.getName());
					break;
				case 2:
					// 证件类型
					DataCollections.dicCredType.put(entity.getValue(), entity.getName());
					break;
				case 4:
					// 卡状态
					DataCollections.cardStatus.put(entity.getValue(), entity.getName());
					break;
				case 5:
					// shift status
					DataCollections.shiftStatus.put(entity.getValue(), entity.getName());
					break;
				case 6:
					// shift type
					DataCollections.shiftType.put(entity.getValue(), entity.getName());
					break;
				case 7:
					// education type
					DataCollections.educationType.put(entity.getValue(), entity.getName());
					break;
				case 8:
					// policatical status
					DataCollections.poliStatus.put(entity.getValue(), entity.getName());
					break;
				case 9:
					// 客户状态
					DataCollections.dicCustomStats.put(entity.getValue(), entity.getName());
					break;
				case 11:
					// 油气类型
					// DataCollections.oilType.put(entity.getValue(), entity.getName());
					break;
				case 12:
					// 支付方式
					DataCollections.dicPayType.put(entity.getValue(), entity.getName());
					break;
				case 13:
					// login status
					DataCollections.loginStatus.put(entity.getValue(), entity.getName());
					break;
				case 14:
					// login status
					DataCollections.cardCategory.put(entity.getValue(), entity.getName());
					break;
				case 16:
					// 交易类型
					DataCollections.tradeType.put(entity.getValue(), entity.getName());
					break;
				case 18:
					// 银行编号
					DataCollections.dicBank.put(entity.getValue(), entity.getName());
					break;
				case 19:
					// 画面menu
					DataCollections.dicMenu.put(entity.getValue(), entity.getName());
					break;
				case 20:
					// 单据类型
					DataCollections.receiptType.put(entity.getValue(), entity.getName());
					break;
				case 21:
					// 单据状态
					DataCollections.receiptStatus.put(entity.getValue(), entity.getName());
					break;
				case 22:
					// 开票类型
					DataCollections.billType.put(entity.getValue(), entity.getName());
					break;
				case 23:
					// 班结状态
					DataCollections.classStatus.put(entity.getValue(), entity.getName());
					break;
				case 24:
					// 卡充值交易类型
					DataCollections.chargeTradeType.put(entity.getValue(), entity.getName());
					break;
				case 26:
					// 单位类型
					DataCollections.companyType.put(entity.getValue(), entity.getName());
					break;
				case 28:
					// 账户分配了性
					DataCollections.allocateType.put(entity.getValue(), entity.getName());
					break;
			}
		}
	}

	private void saveStationDataToCache(List<StationEntity> stationInfoEntityList) {
		// upcompany station name
		for (StationEntity stationEntity : stationInfoEntityList) {
			String upStationName = stationEntity.getUpCompany();
			if (32 == stationEntity.getId()) {
				System.out.println("afsd");
			}
			if (upStationName != null) {
				ApplicationContext.getInstance().addLimitStationMap(stationEntity.getUpCompany(), stationEntity);
			}
		}

	}

}
