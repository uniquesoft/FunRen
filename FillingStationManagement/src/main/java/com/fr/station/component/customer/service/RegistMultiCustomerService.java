package com.fr.station.component.customer.service;

import java.util.List;

import com.fr.station.common.bean.customer.RegisterCustomerBean;

public interface RegistMultiCustomerService {

	/**
	 * get each driver records in order to display in the saleMultiUserCard.jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param registerCustomerBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<RegisterCustomerBean> findDriverRecordsByCriteria(RegisterCustomerBean registerCustomerBean);

	/**
	 * get each department records in order to display in the departmentMaintain.jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param registerCustomerBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<RegisterCustomerBean> findDepRecordsByCriteria(RegisterCustomerBean registerCustomerBean);

	/**
	 * save mainCard info to DB
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param registerCustomerBean include the input jsp page
	 * 
	 * @return return void
	 */
	public void addCustomer(RegisterCustomerBean registerCustomerBean);

	/**
	 * save sonCard(driver card) info to DB
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param registerCustomerBean include the input jsp page
	 * 
	 * @return return void
	 */
	public void addDriver(RegisterCustomerBean registerCustomerBean);

	/**
	 * save department info to DB
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param registerCustomerBean include the input jsp page
	 * 
	 * @return return void
	 */
	public void addDepartment(RegisterCustomerBean registerCustomerBean);

	/**
	 * update department info to DB
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param registerCustomerBean include the input jsp page
	 * 
	 * @return return void
	 */
	public void updateDepartment(RegisterCustomerBean registerCustomerBean);

	/**
	 * update driver depNo info to DB
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param registerCustomerBean include the input jsp page
	 * 
	 * @return return void
	 */
	public void updateDriverDepNo(RegisterCustomerBean registerCustomerBean);

	/**
	 * delete department info to DB
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param registerCustomerBean include the input jsp page
	 * 
	 * @return return void
	 */
	public void deleteDepartment(RegisterCustomerBean registerCustomerBean);

	/**
	 * get department info to edit department
	 */
	public List<RegisterCustomerBean> getDepByFormCondition(RegisterCustomerBean registerCustomerBean);

	/**
	 * get guestNo to add department
	 */
	public List<RegisterCustomerBean> getGuestNoByBean(RegisterCustomerBean registerCustomerBean);

	/**
	 * get guestNo and depNo to add driver
	 */
	public List<RegisterCustomerBean> getGuestNoAndDepNoByBean(RegisterCustomerBean registerCustomerBean);

	/**
	 * get depNo to change department
	 */
	public List<RegisterCustomerBean> getDepNoByCardNo(RegisterCustomerBean registerCustomerBean);
}
