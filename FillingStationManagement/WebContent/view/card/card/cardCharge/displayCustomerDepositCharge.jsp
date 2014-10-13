<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@include file="../../../common/common.jsp" %>
<!-- css -->
<!-- js -->
<script type="text/javascript" src="<%=basePath%>js/card/card/cardCharge/customerDepositCharge.js"></script>
<html>
<head>
<title>客户缴费</title>
</head>
<body>
	<span class="pageFontStyle">主卡信息</span>
	<hr class="lineColor">
	<TABLE style="width:100%;">
	<TR>
	<TD>
		<s:form id="customAccount_form" method="post" action="showCustomAccountInfo">
		<table style="font-size: 12px; width: 100%; height: 40px; font-weight:bold;">
			<tr>
				<td style="height: 30px; width: 90px; text-align: left;">主卡号</td>
				<td style="height: 30px; width: 150px; text-align: left;">
					<input name="customerChargeBean.mainCardNo" id="mainCardNo" style="width:150px" value= "${customerChargeBean.cardNo}" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="20">
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">客户编号</td>
				<td style="height: 30px; width: 150px">
					<input name="customerChargeBean.guestNo" id="guestNo" value= "${customerChargeBean.guestNo}" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="6">
				</td>
				<td style="height: 30px; width: 90px">
					<input type="button" id="readCard" value="读卡" style="width: 60px;">
				</td>
				<td style="height: 30px; width: 150px">
					<input type="button" id="search" value="查询" style="width: 60px;">
				</td>
			</tr>
		</table>
		<span class="pageFontStyle">账户信息</span>
		<hr class="lineColor">
		<table style="font-size: 12px; width: 100%; height: 40px; font-weight:bold;">
			<tr>
				<td style="height: 30px; width: 90px; text-align: left;">卡号</td>
				<td style="height: 30px; width: 150px; text-align: left;">
					<span id="cardNo" style="width: 150px;">${customerChargeBean.cardNo}</span>
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">持卡人</td>
				<td style="height: 30px; width: 150px">
					<span id="guestName" style="width: 150px;">${customerChargeBean.guestName}</span>
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">卡状态</td>
				<td style="height: 30px; width: 150px">
					<span id="cardStatus" style="width: 150px;">${cardStatus[customerChargeBean.cardStatus]}</span>
				</td>
			</tr>
			<tr>
				<td style="height: 30px; width: 90px; text-align: left;">卡片类型</td>
				<td style="height: 30px; width: 150px; text-align: left;">
					<span id="cardType" style="width: 150px;">${cardType[customerChargeBean.cardType]}</span>
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">是否主卡</td>
				<td style="height: 30px; width: 150px">
					<span id="mainCardFlag" style="width: 150px;">${customerChargeBean.mainCardFlag}</span>
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">证件类型</td>
				<td style="height: 30px; width: 150px">
					<span id="guestType" style="width: 150px;">${guestType[customerChargeBean.guestType]}</span>
				</td>
			</tr>
			<tr>
				<td style="height: 30px; width: 90px; text-align: left;">证件号码</td>
				<td style="height: 30px; width: 150px; text-align: left;">
					<span id="guestNum" style="width: 150px;">${customerChargeBean.guestNum}</span>
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">卡内余额</td>
				<td style="height: 30px; width: 150px">
					<span id="cardAccount" style="width: 150px;">${customerChargeBean.cardAccount}</span>
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">卡备用金</td>
				<td style="height: 30px; width: 150px">
					<span id="cardPre" style="width: 150px;">${customerChargeBean.cardPre}</span>
				</td>
				<td style="height: 30px; width: 150px; display: none">
					<input name="customerChargeBean.id" id="guestAccId" value="${customerChargeBean.id}">
				</td>
			</tr>
			<tr>
				<td style="height: 30px; width: 90px; text-align: left;">客户编号</td>
				<td style="height: 30px; width: 150px; text-align: left;">
					<span id="companyGuestNo" style="width: 150px;">${customerChargeBean.guestNo}</span>
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">单位名称</td>
				<td style="height: 30px; width: 150px">
					<span id="companyName" style="width: 150px;">${customerChargeBean.companyName}</span>
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">客户状态</td>
				<td style="height: 30px; width: 150px">
					<span id="guestStatus" style="width: 150px;">${guestStatus[customerChargeBean.guestStatus]}</span>
				</td>
			</tr>
			<tr>
				<td style="height: 30px; width: 90px; text-align: left;">单位类型</td>
				<td style="height: 30px; width: 150px; text-align: left;">
					<span id="companyType" style="width: 150px;">${corpType[customerChargeBean.companyType]}</span>
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">单位账户</td>
				<td style="height: 30px; width: 150px">
					<span id="spareAccount" style="width: 150px;">${customerChargeBean.spareAccount}</span>
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">缴费总和</td>
				<td style="height: 30px; width: 150px">
					<span id="rechargeAmount" style="width: 150px;">${customerChargeBean.rechargeAmount}</span>
				</td>
			</tr>
		</table>
		<span class="pageFontStyle">缴费信息</span>
		<hr class="lineColor">
		<table style="font-size: 12px; width: 100%; height: 40px; font-weight:bold;">
			<tr>
				<td style="height: 30px; width: 90px; text-align: left;">充值额</td>
				<td style="height: 30px; width: 150px; text-align: left;">
					<input name="customerChargeBean.chargeAmount" id="chargeAmount" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="8" style="width:150px">
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">支付方式</td>
				<td style="height: 30px; width: 150px">
					<select name="customerChargeBean.payType" id="payType" style="width:150px;">
						<c:forEach var="payType" items="${payType}">
							<option value="${payType.key}">${payType.value}</option>
						</c:forEach>
					</select>
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">交易类型</td>
				<td style="height: 30px; width: 150px">
					<select name="customerChargeBean.tradeType" id="tradeType" style="width:150px;">
						<c:forEach var="chargeTradeType" items="${chargeTradeType}">
							<option value="${chargeTradeType.key}">${chargeTradeType.value}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td style="height: 30px; width: 90px; text-align: left; display:none;" id="serialNumLabel">交易流水号</td>
				<td style="height: 30px; width: 150px" colspan="4">
					<input name="customerChargeBean.bankSerialNum" id="bankSerialNum" style="width:150px; display:none;" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="20">
				</td>
			</tr>
		</table>
		</s:form>
		<div style="width: 100%; height: 40px; text-align:center;">
			<input type="button" id="depositCharge" value="单位账户充值">
			<input type="button" id="reset" value="重置" style="width: 60px;">
		</div>
	</TD>
	</TR>
	</TABLE>
	<div id="printCardDialog" class="easyui-window" closed="true" modal="true" title="标题" style="width: 850px; height: 450px;">
		<iframe scrolling="auto" id='printCardIFrame' frameborder="0" src="" style="width: 100%; height: 100%;"></iframe>
	</div>
</body>
</html>