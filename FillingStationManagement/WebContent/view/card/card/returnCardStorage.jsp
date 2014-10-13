<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*" %>
<%@include file="../../common/common.jsp" %>
<script type="text/javascript" src="<%=basePath%>js/card/card/returnCardStorageView.js"></script>

<html>
<head>
	<title>富仁高科加油站管理系统</title>
	<base href="<%=basePath%>" />
	<link rel="shortcut icon" type="image/x-icon"
	href="<%=basePath%>images/favicon.ico" />
	<!-- common -->
	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/commonDialog.css" rel="stylesheet" type="text/css" />
</head>
<body id ="cardListApply-body">
	<div style="height:150px">
	<p style="color:#2874ff;font-size: 14px;text-align: right">当前站点:${stationNo} ${stationName} 当前班次 :${classNo}</p>
	<hr class="subLineColor">
	<form id= "cardListReturn-form" method="post" action="cardStorage/saveApplication">
			<table style="font-size: 20px;width:600px; height: 100px">
				<tr>
					<td style="height:3px; width:100px; text-align:center">卡片类型:</td>
					<td height="3px" width="150px">
						<select name="cardStorageBean.cardType" id="cardCategory" style="width:150px">
							<option selected></option>
							<s:set var="cardType" value="cardStorageBean.cardType">
							</s:set>
							<c:forEach var="cardType" items="${cardCategory}">
								<option value="${cardType.key}">
									${cardType.value}
								</option>
							</c:forEach>
						</select>
					</td>
					<td style="height:3px; width:100px;text-align:center">申请日期:</td>
					<td style="height:3px; width:150px">
						<input name="cardStorageBean.applyDate" id="datepicker3" class="easyui-datebox" style="width:150px" editable="false" showSeconds="false">	
					</td>
					
				</tr>
				<tr>
					<td style="height:3px; width:80px;text-align:center">领取方:</td>
					<td style="height:3px; width:150px">
						<!-- <input type="text" name="cardStorageBean.receiver" id="receiver"  value="${cardStorageBean.supplier}"  style="width:150px"> -->
						 <select name="cardStorageBean.receiver" id="receiver" style="width:150px;">
						 	<option selected></option>
							<c:set var="staNo" value="${stationNo}"></c:set>
							<c:forEach var="stationList" items="${stationList}">
								<c:if test="${stationList.key!=staNo}">
								<option value="${stationList.key}">
									${stationList.value}
								</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td style="height:3px; width:80px;text-align:center">供货方:</td>
					<td height="3px" style="width:150px">
						<input type="text" name="cardStorageBean.supplier" id="supplier"  value="${stationName}" readonly="readonly" style="width:150px"></input>
					</td>
				</tr>
				<tr>
					<td style="height:3px; width:100px;text-align:center">数量:</td>
					<td height="3px" style="width:150px">
						<input name="cardStorageBean.cardSum" id="cardAcount" style="width:150px" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"></input>
					</td>
					
					<td style="height:3px; width:80px;text-align:center">备注:</td>
					<td height="3px" style="width:150px">
						<input name="cardStorageBean.note" id="note" value="${cardStorageBean.note}" style="width:150px" maxLength="10"></input>
					</td>
				</tr>
				<tr style="display:none">
					<td style="height:3px; width:80px">
						<input type="hidden" name="cardStorageBean.receiptType" id="applyReceiptType" value="4">
					</td>
					<td height="3px" width="150px">
						<input type="hidden" name="cardStorageBean.stationNum" id="stationNum" value="${stationNo}">
					</td>
					<td height="3px" width="80px">
						<input type="hidden" name="cardStorageBean.receiptStatus" id="receiptStatus" value="1">
					</td>	
				</tr>
			</table>
		</form>
	<hr class="subLineColor">
</div>
</body>
</html>