package com.fr.station.component.report.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.fr.station.common.bean.system.OperateLogBean;
import com.fr.station.common.utility.DateJsonValueProcessor;
import com.fr.station.common.utility.DateUtil;
import com.fr.station.common.utility.ErrorLogUtil;
import com.fr.station.component.report.service.RefuelRecordsService;
import com.fr.station.component.system.action.AbstractAction;

/**
 * The action for dataCenter operatelog display info.
 * 
 * 
 * @author _wsq
 */
@Namespace("/refuelRecords")
@ParentPackage("custom-default")
public class RefuelRecordsAction extends AbstractAction {
	
	// ------- Constants (static final) ----------------------------------------
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(RefuelRecordsAction.class);
	
	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	private List<OperateLogBean> operateLogBeanList = new ArrayList<OperateLogBean>();
	
    @Autowired
    protected RefuelRecordsService reportRefuelRecordsService;
	
	private OperateLogBean operateLogBean;
    
    private String jsonData;
    
	// ------- Constructors ----------------------------------------------------
    
	public RefuelRecordsAction() {
		super();
	}
    
	// ------- Instance Methods (public) ---------------------------------------
	
    @Action(value = "dataCenInit", results = {
            @Result(name = "success", location = "/view/card/report/displayRefuelRecords.jsp"),
            @Result(name = "error", location = "/view/login.jsp") })
        public String dataCenInit() {
    	JSONObject jsonObject = null;
		try {
//			jsonObject = JSONObject.fromObject(DataCollections.dicMenuTree.get(
//			        currfunc).get(0));
//			System.out.println(DataCollections.dicMenuTree.get(currfunc).get(0));
		} catch (Exception e) {
			log.info(ErrorLogUtil.printInfo(e));
		}
//    	tree = jsonObject;
        return SUCCESS;
        }

	/**
	 * 
	 * receive the request from http and handle the request to dispatch different ways based on the parameters
	 * 
	 * @param 
	 * @return dashboard jsp
	 * @throws com.fr.station.card.ICCard.exception.ICCardException 
	 */
	@Action(value="showOperatelog", results={
				@Result(name="success",  type = "json"),
	           })
	public String showOperatelog() {
		log.info("Starting to load operatelog infomation from DB");
		Map<String,Object> map=new HashMap<String,Object>();
		boolean flag = false;
		try {
			operateLogBeanList = this.reportRefuelRecordsService.findGasRecordsByCriteria(this.getOperateLogBean(), 1);
			if(!operateLogBeanList.isEmpty()){
				JsonConfig config = new JsonConfig();
				config.registerJsonValueProcessor(Timestamp.class, new DateJsonValueProcessor(
			            DateUtil.DATE_PATTERN_2));
				map.put("total", operateLogBeanList.size());
				map.put("rows", operateLogBeanList);
				this.jsonData = JSONObject.fromObject(map).toString();
			}else{
				map.clear();
			}
			flag = true;
		}catch (net.sf.json.JSONException e) {
			log.info("Convert to Json object occured error, please references the detail log\n " + "["
					+  e + "]\n" + ErrorLogUtil.printInfo(e));
		}catch (Exception e) {
			log.info("Loading operatelog data from DB occured error, please references the detail log\n " + "[" 
					+  e + "]\n" + ErrorLogUtil.printInfo(e));
			return ERROR;
		}
		if(flag){
			log.info("Successfully load operatelog data from DB");
			return SUCCESS;
		}
		return ERROR;
	}
	
	public List<OperateLogBean> getOperateLogBeanList() {
		return operateLogBeanList;
	}

	public void setOperateLogBeanList(List<OperateLogBean> operateLogBeanList) {
		this.operateLogBeanList = operateLogBeanList;
	}

	public OperateLogBean getOperateLogBean() {
		return operateLogBean;
	}

	public void setOperateLogBean(OperateLogBean operateLogBean) {
		this.operateLogBean = operateLogBean;
	}

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------
	
}