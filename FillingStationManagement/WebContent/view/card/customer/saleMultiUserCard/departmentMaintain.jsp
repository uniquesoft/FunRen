<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@include file="../../../common/common.jsp" %>

<html>
<head>
<!-- css -->
<!-- js -->
<script type="text/javascript" src="<%=basePath%>js/card/customer/saleMultiUserCard/departmentMaintain.js"></script>
<script type="text/javascript" src="<%=basePath%>js/card/customer/saleMultiUserCard/departmentAdd.js"></script>
<script type="text/javascript" src="<%=basePath%>js/card/customer/saleMultiUserCard/departmentEdit.js"></script>
<script type="text/javascript" src="<%=basePath%>js/card/customer/saleMultiUserCard/departmentDelete.js"></script>
<script type="text/javascript" src="<%=basePath%>js/common/validation.js"></script>
<title>部门维护</title>
</head>
<body id="depMaintain_body">
	<TABLE style="font-size: 9px; font-family: Arial; table-layout: fixed; width: 100%; height: 70%">
	<TR>
	<TD width="86%" valign="top" style="border-left: #7BAED5 solid 0px; padding-left: 2px">
	<span class="pageFontStyle">部门维护</span>
	<hr class="lineColor">
	<table>
	<tr>
		<td style="height: 40px; width: 120px; text-align: center;">主卡号</td>
		<td > 
			<input name="registerCustomerBean.cardNo" id="cardNo" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="20" style="width:150px;">
		</td>
		<td style="height: 40px; width: 120px; text-align: center;">客户编号</td>
		<td > 
			<input name="registerCustomerBean.guestNo" id="guestNo" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="6">
		</td>
		<td style="height: 40px; width: 120px; text-align: center;">单位名称</td>
		<td>
			<input name="registerCustomerBean.guestName" id="guestName" maxlength="10">
		</td>
		<td style="height: 40px; width: 120px; text-align: right;">
			<input type="button" id="searchDepartment" value="查询" style="width:60px;height:20px;">
		</td>
		<td style="height: 40px; width: 120px; text-align: right;">
			<input type="button" id="returnBack" value="返回" style="width:60px;height:20px;">
		</td>
	</tr>
	</table>
	<hr class="lineColorAboveTable">
	<table class="tableButton">
	<tr>
		<td>
			<input type="button" id="department_add" value="增加部门">
		</td>
		<td>
			<input type="button" id="department_edit" value="编辑部门">
		</td>
		<td>
			<input type="button" id="department_delete" value="删除部门">
		</td>
		<!--  
		<td style="height: 40px; width: 85px; text-align: center;">
			<input type="button" id="department_import" value="导入部门" onclick = "alert('部门导入');">
		</td>
		-->
	</tr>
	</table>
	<br>
	<table id="dg" title="部门信息一览" style="width:auto; height: auto;">
	</table>
	</TD>
	</TR>
	</TABLE>
	<div id="addDepDialog" class="easyui-window" closed="true" modal="true" style="width:600px;height:350px;"> 
    	<iframe scrolling="auto" id='addDepIFrame' frameborder="0"  src="" style="width:100%;height:100%;"></iframe> 
	</div>  
</body>
</html>