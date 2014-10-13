package com.fr.station.component.report.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.fr.station.common.bean.report.DayExchangeBean;
import com.fr.station.common.utility.ErrorLogUtil;
import com.fr.station.component.report.service.DayExchangeService;
import com.fr.station.component.system.action.AbstractAction;

@Namespace("/dayExchange")
@ParentPackage("custom-default")
public class DayExchangeAction extends AbstractAction {

	// ------- Constants (static final) ----------------------------------------
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(DayExchangeAction.class);

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------
	@Autowired
	protected DayExchangeService dayExchangeService;

	protected DayExchangeBean dayExchangeBean;

	private String jsonData;

	// ------- Constructors ----------------------------------------------------

	public DayExchangeAction() {
		super();
	}

	// ------- Instance Methods (public) ---------------------------------------

	/**
	 * 
	 * receive the request from http and handle the request to dispatch different ways based on the parameters
	 * 
	 * @param
	 * @return displayCardList jsp
	 * @throws
	 */

	@Action(value = "showDayExchangeRecords", results = { @Result(name = "success", type = "json"), })
	public String showClassChangeRecords() {
		log.info("Starting to load show day exchange records infomation from DB");
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		List<DayExchangeBean> dayExchangeBeanList = null;
		try {
			dayExchangeBeanList = this.dayExchangeService.findDayExchangeRecordsByCriteria(this.dayExchangeBean);
			if (!dayExchangeBeanList.isEmpty()) {
				map.put(TOTAL, dayExchangeBeanList.get(0).getTotalData());
				map.put(ROWS, dayExchangeBeanList);
				this.jsonData = JSONObject.fromObject(map).toString();
				log.info("Successfully load show day exchange records data from DB");
			} else {
				log.info("Cannot find any day exchange records in DB.");
				map.clear();
			}
			flag = true;
		} catch (net.sf.json.JSONException e) {
			log.info("Convert to Json object occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("Loading show day exchange records data from DB occured error, please references the detail log\n " + "["
					+ e + "]\n" + ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {

			return SUCCESS;
		}
		return ERROR;
	}

	public DayExchangeBean getDayExchangeBean() {
		return this.dayExchangeBean;
	}

	public void setDayExchangeBean(DayExchangeBean dayExchangeBean) {
		this.dayExchangeBean = dayExchangeBean;
	}

	public String getJsonData() {
		return this.jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------

	// ------- Static Methods --------------------------------------------------

	// ------- Optional Inner Class ------------------------------------------

}
