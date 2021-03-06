<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*"%>

	<%@include file="../../common/common.jsp" %>
	
	<html>
	<head>
	<title>富仁高科加油站管理系统</title>
	<base href="<%=basePath%>" />	
	<script type="text/javascript" src="<%=basePath%>js/card/report/refuelRecords.js"></script>
</head>
<body>
	<TABLE style="font-size: 9px; font-family: Arial; table-layout: fixed; width: 100%; height: 79%"">
		<tr>
			<td width="86%" valign="top"
				style="border-left: #7BAED5 solid 0px; padding-left: 2px">
				<div class="pageFontStyle">油气交易记录一览</div>
				<hr class="lineColor">
				<table style="font-size: 12px;width: 100%; height: 50px; font-weight: bold;">
					<tr>
						<td height="3px" width="70px">枪号:</td>
						<td height="30px" width="50px">
							<input name="operateLogBean.oilGunNum" style="width:140px" id="operlogGunNum"></input>
						</td>
						<td height="30px" width="70px">卡号:</td>
						<td height="30px" width="50px">
							<input name="operateLogBean.cardNum" style="width:140px" id="operlogCardNum"></input>
						</td>
						<td height="30px" width="70px">POS_TTC:</td>
						<td height="30px" width="50px">
							<input name="operateLogBean.posTTC" style="width:140px" id="operlogPosTTC"></input>
						</td>
						<td height="30px" width="70px">网点号:</td>
						<td height="30px" width="50px">
							<input name="operateLogBean.stationNum" style="width:140px" id="operlogStationNum"></input>
						</td>
					</tr>
					<tr>
						<td height="3px" width="70px">交易类型:</td>
						<td>
							<select name="operateLogBean.tradeType" id="operlogTradeType" style="width:140px">
								<option selected>   </option>
								<c:forEach var="vTradeType" items="${operTradeType}">
									<option value="${vTradeType.key}">
										${vTradeType.value}
									</option>
								</c:forEach>
							</select>
						</td>
						<td height="30px" width="70px">油气类型:</td>
						<td>
							<select name="operateLogBean.gasType" id="operlogGasType" style="width:140px">
								<option selected>   </option>
								<c:forEach var="vGasType" items="${oilType}">
									<option value="${vGasType.key}">
										${vGasType.value}
									</option>
								</c:forEach>
							</select>
						</td>
						<td height="30px" width="70px">支付类型:</td>
						<td>
							<select name="operateLogBean.payType" id="operlogPayType" style="width:140px">
								<option selected>   </option>
								<c:forEach var="vOperPayType" items="${operPayType}">
									<option value="${vOperPayType.key}">
										${vOperPayType.value}
									</option>
								</c:forEach>
							</select>
						</td>
						<td height="30px" width="70px">单位名称:</td>
						<td height="30px" width="50px">
							<input name="operateLogBean.companyName" style="width:140px" id="operlogCompanyName" ></input>
						</td>
					</tr>
					<tr>
						<td height="30px" width="70px">开始时间:</td>
						<td height="30px" width="180px">
							<input name="operateLogBean.startDate" class="easyui-datetimebox" id="datepicker1" editable="false" showSeconds="false" style="width: 140px;"/>
						</td>
						<td height="30px" width="70px">结束时间:</td>
						<td height="30px" width="180px">
							<input name="operateLogBean.endDate" class="easyui-datetimebox" id="datepicker2" editable="false" showSeconds="false" style="width: 140px;"/>
						</td>
						<td><input type='button' value='&nbsp;检&nbsp;索&nbsp;' id="operlog_search"></td>
						<td><input type='button' value='&nbsp;导&nbsp;出&nbsp;' id="operlog_report"></td>
					</tr>
				</table>
				<hr class="lineColor">
				<table id="dg" title="加油记录一览" style="width: auto;height: auto;"></table>
			</td>
		</tr>

	</TABLE>
</body>
</html>