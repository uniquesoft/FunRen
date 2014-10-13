package com.fr.station.component.report.service;

import java.util.List;

import com.fr.station.common.bean.report.ShiftChangeBean;
import com.fr.station.common.entity.report.OilGunConsumeEntity;

/**
 * The interface for get Gas trading records .
 * 
 * @trace FR.ICCardManagement.OperatorLogEntity.Table
 * 
 * @author _wsq
 */
public interface ShiftChangeRefuelService {

	/**
	 * get each oil gun records in order to display in the jsp page.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */	
	public List<OilGunConsumeEntity> findAllShiftChangeRecords() throws Exception;

	/**
	 * get each oil gun records in order to display in the jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param shiftChangeBean shiftChangeBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */	
	public List<ShiftChangeBean> findShiftChangeRecordsByCriteria(ShiftChangeBean shiftChangeBean);
	
}
