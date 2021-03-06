package com.fr.station.component.system.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.fr.station.common.bean.system.ClassChangeBean;
import com.fr.station.common.data.ApplicationContext;
import com.fr.station.common.utility.ErrorLogUtil;
import com.fr.station.component.system.constants.SystemConstants;
import com.fr.station.component.system.service.ShiftChangeManagerService;

/**
 * The action for dashboard. It handles the user request from the web page.
 *
 *
 * @author henry
 */
@Namespace("/shiftChangeManage")
@ParentPackage("custom-default")
public class ShiftChangeManageAction extends AbstractAction implements SessionAware{

	// ------- Constants (static final) ----------------------------------------

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(ShiftChangeManageAction.class);

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	@Autowired
	protected ShiftChangeManagerService shiftChangeManagerServiceImpl;

	private ClassChangeBean classChangeBean;

	private Map<String, Object> session;

	private String message;

	// ------- Constructors ----------------------------------------------------

	public ShiftChangeManageAction() {
		super();
	}

	// ------- Instance Methods (public) ---------------------------------------

	@Action(value = "shiftManageInit", results = {
			@Result(name = "success", location = "/view/card/system/shiftChangeManage/shiftChange.jsp"),
			@Result(name = "error", location = "/view/login.jsp") })
	public String shiftManageInit() {
		this.classChangeBean = this.shiftChangeManagerServiceImpl.retrieveClassInfo();
		return SUCCESS;
	}

	@Action(value = "shiftChangeManage", results = {
			@Result(name = "success",  type = "json"),
			 })
	public String shiftChangeManage() {
		Boolean flag = false;
		log.info("Staring to deal with current shift changing information");

		try {
			this.classChangeBean = this.shiftChangeManagerServiceImpl.dealWithShiftChange(this.classChangeBean);
			flag = true;
		} catch (Exception e) {
			log.info("Save current class information occured error, more detail please see the log log\n " + "["
					+  e + "]\n" + ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if(flag){
			log.info("Successfully deal with current shift changing information");
			this.message = "你好";
			return SUCCESS;
		}
		return ERROR;

	}

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------

	public ClassChangeBean getClassChangeBean() {
		return this.classChangeBean;
	}

	public void setClassChangeBean(ClassChangeBean classChangeBean) {
		this.classChangeBean = classChangeBean;
	}



	public String getMessage() {
		return this.message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Assign the value of session to session.
	 *
	 * @param session the session to set
	 *
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		// for class number to display in the page
		this.session.put(SystemConstants.CLASS_NUMBER, ApplicationContext.getInstance().getClassChangeBean().getClassNo());
	}


}
