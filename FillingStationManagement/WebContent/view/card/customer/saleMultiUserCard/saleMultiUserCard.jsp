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
<script type="text/javascript" src="<%=basePath%>js/card/customer/saleMultiUserCard/saleMultiUserCard.js"></script>
<script type="text/javascript" src="<%=basePath%>js/card/customer/saleMultiUserCard/driverAdd.js"></script>
<title>单位卡售卡</title>
</head>
<body id="saleMultiUserCard_body">
	<TABLE style="font-size: 9px; font-family: Arial; table-layout: fixed; width: 100%; height: 70%">
	<TR>
	<TD width="86%" valign="top" style="border-left: #7BAED5 solid 0px; padding-left: 2px">
	<span class="pageFontStyle">单位卡售卡</span>
	<hr class="lineColor">
	<table>
		<tr>
		<td style="height: 40px; width: 85px; text-align: center;">主卡卡号</td>
		<td>
			<input name="registerCustomerBean.cardNo" onkeyup="value=value.replace(/[^\d]/g,'')" id="cardNo" maxlength="20" style="width:150px;">
		</td>
		<td style="height: 40px; width: 85px; text-align: center;">客户编号</td>
		<td>
			<input name="registerCustomerBean.guestNo" onkeyup="value=value.replace(/[^\d]/g,'')" id="guestNo" maxlength="6">
		</td>
		<td style="height: 40px; width: 85px; text-align: center;">单位名称</td>
		<td>
			<input name="registerCustomerBean.guestName" id="guestName" maxlength="10">
		</td>
		<td style="height: 40px; width: 85px; text-align: center;">
			<input type="button" id="readCard" value="读卡" style="width:60px;height:20px;">
		</td>
		<td style="height: 40px; width: 85px; text-align: center;">
			<input type="button" id="searchDriver" value="查询" style="width:60px;height:20px;">
		</td>
		<td style="height: 40px; width: 85px; text-align: center;">
			<input type="button" id="corpGuestAdd" value="新建单位客户" style="width:100px;height:20px;"
			onclick="window.location.href='<%=basePath%>registMultiCustomer/customerAdd';">
		</td>
		<td style="height: 40px; width: 85px; text-align: center;">
			<input type="button" id="returnRegistCustomer" value="返回开户售卡" style="width:100px;height:20px;"
			onclick="window.location.href='<%=basePath%>registCustomer/registerCustomerInit';">
		</td>
	</tr>
	</table>
	<hr class="lineColorAboveTable">
	<table class="tableButton">
	<tr>
		<td>
			<input type="button" id="driver_add" value="增加司机">
		</td>
		<!-- 
		<td>
			<input type="button" id="driver_edit" value="编辑司机" onclick="alert('编辑司机');">
		</td>
		<td style="height: 40px; width: 85px; text-align: center;">
			<input type="button" id="driver_import" value="导入司机" onclick="alert('导入司机');">
		</td>
		 -->
		<td>
			<input type="button" id="dep_maintain" value="部门维护"
			onclick="window.location.href='<%=basePath%>registMultiCustomer/depMaintain';">
		</td>
		<td style="display:none;">
			<select name="registerCustomerBean.cardStatus" id="cardStatus">
				<c:forEach var="cardSta" items="${cardStatus}">
					<option value="${cardSta.key}">
						${cardSta.value}
					</option>
				</c:forEach>
			</select>
		</td>
		<td style="display:none;">
			<select name="registerCustomerBean.cardType" id="cardType">
				<c:forEach var="cardType" items="${cardType}">
					<option value="${cardType.key}">
						${cardType.value}
					</option>
				</c:forEach>
			</select>
		</td>
		<td style="display:none;">
			<select name="registerCustomerBean.guestStatus" id="guestStatus">
				<c:forEach var="guestStatus" items="${guestStatus}">
					<option value="${guestStatus.key}">
						${guestStatus.value}
					</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	</table>
	<br>
	<table id="dg" title="司机信息一览" style="width:auto; height: auto;">
	</table>
	</TD>
	</TR>
	</TABLE>
	<div id="addDriverDialog" class="easyui-window" closed="true" modal="true" style="width:900px;height:500px;"> 
    	<iframe scrolling="auto" id='addDriverIFrame' frameborder="0"  src="" style="width:100%;height:100%;"></iframe> 
	</div>
	 <div id="printCardDialog" class="easyui-window" closed="true" modal="true" title="标题" style="width: 850px; height: 450px;">
		<iframe scrolling="auto" id='printCardIFrame' frameborder="0" src="" style="width: 100%; height: 100%;"></iframe>
	</div>
	<div id="changeDepDialog" class="easyui-window" closed="true" modal="true" title="标题" style="width: 600px; height: 300px;">
		<iframe scrolling="auto" id='changeDepIFrame' frameborder="0" src="" style="width: 100%; height: 100%;"></iframe>
	</div>
</body>
</html>