package com.fr.station.common.utility;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;

import com.fr.station.common.bean.report.EmployeeBean;
import com.fr.station.common.bean.system.CommonBean;
import com.fr.station.common.entity.system.EmployeeEntity;

/**
 * @author henry
 *
 */
public class CommonUtility {
	public static EmployeeEntity createModel(EmployeeBean userBean) {
		EmployeeEntity empployee = new EmployeeEntity();
		return empployee;
	}

	public static List<EmployeeBean> createUserBeanList(List<EmployeeEntity> employeeEntityList) {
		List<EmployeeBean> employeeBeanList = new ArrayList<EmployeeBean>();
		EmployeeBean employeeBean = null;
		for (EmployeeEntity user : employeeEntityList) {
			employeeBean = new EmployeeBean();
			employeeBeanList.add(employeeBean);
		}
		return employeeBeanList;

	}

	public static String convertArrayToCsv(String[] arr) {
		String csv = "";
		for (String value : arr) {
			csv += value + ",";
		}
		return csv;
	}

	public static String[] convertCsvToArr(String csv) {
		String[] values = csv.split(",");
		return values;
	}

	public static ProjectionList setReturnColumns(String column){
		return Projections.projectionList().add(Property.forName(column));
	}

	public static void countPaginationNumber(CommonBean commonBean){
		int pageNumber = commonBean.getPageNumber();
		int pageSize = commonBean.getPageSize();
		// 当前页
		int intPage = pageNumber == 0 ? 1 : pageNumber;
		// 每页显示条数
		int totalNumber = pageSize == 0 ? 20 : pageSize;
		// 每页的开始记录 第一页为1 第二页为number +1
		int startNumber = (intPage - 1) * totalNumber;

		commonBean.setTotalNumber(totalNumber);
		commonBean.setStartNumber(startNumber);
	}
}
