<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<title>富仁高科加油站管理系统</title>
<!-- css -->
<link rel="stylesheet" type="text/css" href="<%=basePath%>themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/system/sysStyle.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/system/home.css">
<!-- js -->
<script type="text/javascript" src="<%=basePath%>js/system/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/system/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/system/main.js"></script>

<!-- below is not sure is must use -->
<link rel="stylesheet" type="text/css" href="<%=basePath%>themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>demo/demo.css">
<script type="text/javascript" src="<%=basePath%>js/system/plugins/jquery.panel.js"></script>
<script type="text/javascript" src="<%=basePath%>js/system/plugins/jquery.linkbutton.js"></script>
<script type="text/javascript" src="<%=basePath%>js/system/plugins/jquery.parser.js"></script>
<script type="text/javascript" src="<%=basePath%>js/system/plugins/jquery.tabs.js"></script>

<script type="text/javascript">
	
</script>
</head>
<body class="easyui-layout">
	<div region="north" border="true" class="cs-north" style="height: 85%">
		<jsp:include page="common/head.jsp"></jsp:include>
	</div>
	<div region="west" border="true" split="true" class="cs-west">
		<div class="easyui-accordion" fit="true" border="false">
			<div title="客户管理" >
  				<a href="javascript:void(0)"  src="<%=basePath%>registCustomer/registerCustomerInit" class="cs-navi-tab">开户售卡</a><br>
  				<a href="javascript:void(0)"  src="<%=basePath%>customerCharge/customerDepositChargeInit" class="cs-navi-tab">客户缴费</a><br>
  				<a href="javascript:void(0)"  src="<%=basePath%>cardCharge/cardChargeInit" class="cs-navi-tab">卡交易</a><br>
  				<a href="javascript:void(0)"  src="<%=basePath%>view/card/customer/transferAccounts.jsp" class="cs-navi-tab">转账</a><br>
  				<a href="javascript:void(0)"  src="<%=basePath%>customerDelete/cardDeleteInit" class="cs-navi-tab">个人卡注销</a><br>
  				<a href="javascript:void(0)"  src="<%=basePath%>customerDelete/driverDeleteInit" class="cs-navi-tab">司机卡注销</a><br>
  				<a href="javascript:void(0)"  src="<%=basePath%>customerDelete/customDeleteInit" class="cs-navi-tab">单位注销</a><br>
			</div>
			<div title="卡片管理">
				<a href="javascript:void(0)"  src="<%=basePath%>cardStorage/cardStorageInit" class="cs-navi-tab">卡片一览</a><br>
			</div>
			<div title="加油卡维护">
				<a href="javascript:void(0)"  src="<%=basePath%>updateCardInfo/cardDetailInit" class="cs-navi-tab">卡片明细</a><br>
				<a href="javascript:void(0)"  src="<%=basePath%>cardMaintain/cardMaintainList" class="cs-navi-tab">卡片维护</a><br>	
				<a href="javascript:void(0)"  src="<%=basePath%>updateCardInfo/cardInfoInit" class="cs-navi-tab">个人卡维护</a><br>
				<a href="javascript:void(0)"  src="<%=basePath%>updateCardInfo/mainCardInfoInit" class="cs-navi-tab">单位卡维护</a><br>
			</div>
			<div title="结账">
				<a href="javascript:void(0)"  src="<%=basePath%>shiftChangeManage/shiftManageInit" class="cs-navi-tab">班结管理</a><br>
				<a href="javascript:void(0)"  src="<%=basePath%>" class="cs-navi-tab">日结账</a><br>
			</div>
			<div title="报表">
				<a href="javascript:void(0)"  src="<%=basePath%>view/card/report/displayDayExchangeList.jsp" class="cs-navi-tab">日结查询</a><br>
				<a href="javascript:void(0)"  src="<%=basePath%>view/card/report/displayShiftChangeList.jsp" class="cs-navi-tab">班结查询</a><br>
				<a href="javascript:void(0)"  src="<%=basePath%>view/card/report/displayCardPredistributionList.jsp" class="cs-navi-tab">预分配查询</a><br>
				<a href="javascript:void(0)"  src="<%=basePath%>view/card/report/displayCardTradeList.jsp" class="cs-navi-tab">卡交易查询</a><br>
				<a href="javascript:void(0)"  src="<%=basePath%>view/card/report/displayGuestCreditList.jsp" class="cs-navi-tab">缴费明细查询</a><br>
				<a href="javascript:void(0);" src="<%=basePath%>refuelRecords/dataCenInit" class="cs-navi-tab">加油记录查询</a><br>
				<a href="javascript:void(0);" src="<%=basePath%>view/card/chart/displayRefuelChart.jsp" class="cs-navi-tab">油气销售分析</a><br>
				<a href="javascript:void(0);" src="<%=basePath%>shiftChange/shiftChangeInit" class="cs-navi-tab">交接班查询</a><br>
			</div>
			<div title="员工管理">
				<a href="javascript:void(0)"  src="<%=basePath%>employee/employeeInit" class="cs-navi-tab">信息维护</a><br>
				<a href="javascript:void(0)"  src="<%=basePath%>" class="cs-navi-tab">角色分配</a><br>
			</div>
		</div>
	</div>
	<div id="tt" region="center" border="true" border="false">
		 <div id="tabs" class="easyui-tabs"  fit="true" border="false">
            <div title="Home">
				<div >
					<br>
					富仁高科欢迎您
				</div>
			</div>
			<!--  
		 	<div id="sysTab" title="系统管理" closable="true" class="sysTabClass" >
				
			</div>
			<div title="客户管理" closable="true" style="overflow:hidden">
				<iframe scrolling="yes" frameborder="0" src="" class="cs-navi-tab" style="width:100%;height:100%;">
				</iframe>
			</div>
			<div title="卡片管理" closable="true" style="overflow:hidden">
				<iframe scrolling="yes" frameborder="0" href="javascript:void(0)" src="" class="cs-navi-tab" style="width:100%;height:100%;">
				</iframe>
			</div>
			<div title="数据中心" closable="true" style="overflow:hidden">
				<iframe scrolling="yes" frameborder="0" href="javascript:void(0)" src="" class="cs-navi-tab" style="width:100%;height:100%;">
				</iframe>
			</div>
			<div title="报表管理" closable="true" style="overflow:hidden">
				<iframe scrolling="yes" frameborder="0" href="javascript:void(0)" src="" class="cs-navi-tab" style="width:100%;height:100%;">
				</iframe>
			</div>
			-->
        </div>
	</div>
	
	<!-- footer -->
	<div region="south" border="false" class="cs-south">Copyright © 2004 富仁高科. All rights reserved. </div>
	<div id="mm" class="easyui-menu cs-tab-menu">
		<div id="mm-tabupdate">刷新</div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseother">关闭其他</div>
		<div id="mm-tabcloseall">关闭全部</div>
	</div>
</body>
</html>