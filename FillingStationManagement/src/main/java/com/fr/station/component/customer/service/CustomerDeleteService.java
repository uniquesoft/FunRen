package com.fr.station.component.customer.service;

import java.util.List;

import com.fr.station.common.bean.customer.CustomerDeleteBean;

public interface CustomerDeleteService {

	/**
	 * get the customer records in order to display in the displayCustomerDeleteList.jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CustomerDeleteBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<CustomerDeleteBean> findCustomerRecordsByCriteria(CustomerDeleteBean customerDeleteBean);

	/**
	 * get customer records and all son card records in order to display in the displayAllCardList.jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CustomerDeleteBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public CustomerDeleteBean findAllCardRecordsByCriteria(CustomerDeleteBean customerDeleteBean);

	/**
	 * get the personal card records in order to display in the displayCardDeleteList.jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CustomerDeleteBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<CustomerDeleteBean> findCardRecordsByCriteria(CustomerDeleteBean customerDeleteBean);

	/**
	 * get the driver card records in order to display in the displayDriverDeleteList.jsp and
	 * displayCustomDeleteList.jsp.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CustomerDeleteBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<CustomerDeleteBean> findDriverRecordsByCriteria(CustomerDeleteBean customerDeleteBean);

	/**
	 * update multiCustomer status info to DB
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param customerChargeBean include the input of user in dialog
	 * 
	 * @return return void
	 */
	public void updateMultiCustomer(CustomerDeleteBean customerDeleteBean);

	/**
	 * update personal card status info to DB
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param customerChargeBean include the input of user in dialog
	 * 
	 * @return return void
	 */
	public void updatePersonalCard(CustomerDeleteBean customerDeleteBean);

	/**
	 * update personal card status info to DB
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param customerChargeBean include the input of user in dialog
	 * 
	 * @return return void
	 */
	public void updateDriverCard(CustomerDeleteBean customerDeleteBean);

	/**
	 * judge blackCard record card lost time satisfy 48 hours
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param customerChargeBean include the input of user in dialog
	 * 
	 * @return return true or false
	 */
	public boolean judgeBlackCardTime(CustomerDeleteBean customerDeleteBean);

	/**
	 * judge all blackCard record card lost time satisfy 48 hours
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param customerChargeBean include the input of user in dialog
	 * 
	 * @return return true or false
	 */
	public boolean judgeAllBlackCardTime(CustomerDeleteBean customerDeleteBean);
}
