package com.fr.station.component.customer.dao;

import java.util.Date;
import java.util.List;

import com.fr.station.common.bean.customer.CustomerDeleteBean;

public interface CustomerDeleteDAO {

	/**
	 * get customer record in order to display in the displayCustomerDeleteList.jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CustomerDeleteBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<CustomerDeleteBean> getCustomerRecordsByCriteria(CustomerDeleteBean customerDeleteBean);

	/**
	 * get customer record and all son card record in order to display in the displayAllCardList.jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CustomerDeleteBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public CustomerDeleteBean getAllCardRecordsByCriteria(CustomerDeleteBean customerDeleteBean);

	/**
	 * get personal card record in order to display in the displayCardDeleteList.jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CustomerDeleteBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<CustomerDeleteBean> getCardRecordsByCriteria(CustomerDeleteBean customerDeleteBean);

	/**
	 * get driver card records in order to display in the displayDriverDeleteList.jsp and displayCustomDeleteList.jsp
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CustomerDeleteBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<CustomerDeleteBean> getDriverRecordsByCriteria(CustomerDeleteBean customerDeleteBean, int start, int number);

	/**
	 * update guest status to "deleted" when delete customer
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CustomerDeleteBean include the search criteria.
	 * 
	 * @return void
	 */
	public void updateGuestStatus(CustomerDeleteBean customerDeleteBean);

	/**
	 * update card status to "deleted" by guestNo when delete customer,driver card personal card
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CustomerDeleteBean include the search criteria.
	 * 
	 * @return void
	 */
	public void updateCardStatus(CustomerDeleteBean customerDeleteBean);

	/**
	 * update card status to "deleted" by cardNo when delete customer,driver card personal card
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CustomerDeleteBean include the search criteria.
	 * 
	 * @return void
	 */
	public void updateCardStatusByCardNo(CustomerDeleteBean customerDeleteBean);

	/**
	 * update guest account when delete customer
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CustomerDeleteBean include the search criteria.
	 * 
	 * @return void
	 */
	public void updateGuestAccount(CustomerDeleteBean customerDeleteBean);

	/**
	 * update card account when delete driver card
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CustomerDeleteBean include the search criteria.
	 * 
	 * @return void
	 */
	public void updateCardAccount(CustomerDeleteBean customerDeleteBean);

	/**
	 * get black card time when delete card not have card
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CustomerDeleteBean include the search criteria.
	 * 
	 * @return return black card time.
	 */
	public Date getBlackCardTime(CustomerDeleteBean customerDeleteBean);

	/**
	 * get all black card time when delete customer not have card
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CustomerDeleteBean include the search criteria.
	 * 
	 * @return return black card time list.
	 */
	public List<Date> getAllBlackCardTime(CustomerDeleteBean customerDeleteBean);
}
