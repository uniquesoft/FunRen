package com.fr.station.component.card.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.fr.station.common.bean.card.CardStorageDetailBean;
import com.fr.station.common.utility.ErrorLogUtil;
import com.fr.station.component.card.service.CardStorageDetailService;
import com.fr.station.component.system.action.AbstractAction;

@Namespace("/cardStorageDetail")
@ParentPackage("custom-default")
public class CardStorageDetailAction extends AbstractAction {

	// ------- Constants (static final) ----------------------------------------
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(CardStorageDetailAction.class);

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	@Autowired
	protected CardStorageDetailService cardStorageDetailService;

	protected CardStorageDetailBean cardStorageDetailBean;

	private String jsonData;

	// ------- Constructors ----------------------------------------------------
	public CardStorageDetailAction() {
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
	@Action(value = "saveCardDetailOrder", results = { @Result(name = "success", type = "json"), })
	public String saveCardDetailOrder() {
		log.info("Starting to save card order detail infomation into DB");
		boolean flag = true;
		try {
			this.cardStorageDetailService.addCardOrderDetail(this.cardStorageDetailBean);
		} catch (Exception e) {
			log.info("Loading card order detail  from DB occured error, please references the detail log\n " + "[" + e + "]\n"
					+ ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if (flag) {
			log.info("Successfully save card order data into DB");
			return SUCCESS;
		}
		return ERROR;
	}

	public CardStorageDetailBean getCardStorageDetailBean() {
		return this.cardStorageDetailBean;
	}

	public void setCardStorageDetailBean(CardStorageDetailBean cardStorageDetailBean) {
		this.cardStorageDetailBean = cardStorageDetailBean;
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
