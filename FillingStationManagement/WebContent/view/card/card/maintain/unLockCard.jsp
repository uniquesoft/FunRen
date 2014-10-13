<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@include file="../../../common/common.jsp"%>

<script type="text/javascript" src="<%=basePath%>js/card/card/maintain/unLockCard.js"></script>
<script type="text/javascript" src="<%=basePath%>js/card/card/maintain/cardMaintain.js"></script>
</head>
<body>
	<s:form>
	<p style="color:#2874ff;font-size: 14px;text-align:right">当前站点:${stationNo} ${stationName} 当前班次 :${classNo}</p>
		<hr class="subLineColor">
		<td width="86%" valign="top" style="border-left: #7BAED5 solid 0px; padding-left: 2px">
			<table style="font-size: 12px; width: 100%; height: 50px; font-weight: bold;">
				<tr>
					<td height="3px" style="width: 70px">卡号:
					<td height="30px" style="width: 180px">
						<span style="width: 140px" id="cardNo">${cardMaintainBean.cardNo}</span>
					</td>
					<td height="30px" style="width: 70px">客户名称:</td>
					<td height="30px" width="80px" style="width: 180px">
					    <span style="width: 140px" id="guestName">${cardMaintainBean.guestName}</span>
					</td>
					<td height="30px" style="width: 70px">客户编号:</td>
					<td height="30px" width="80px" style="width: 180px">
					    <span style="width: 140px" id="guestNo">${cardMaintainBean.guestNo}</span>
					</td>
				</tr>
				<tr>
					<td height="30px" style="width: 70px">证件类型:</td>
					<td height="30px" width="80px" style="width: 180px">
						<input name="cardMaintainBean.guestType" value="${cardMaintainBean.guestType}" style="display: none;" id="guestType"></input>
						<s:set var="guestTypeKey" value="cardMaintainBean.guestType">
						</s:set>
						<span style="width: 140px">${guestType[guestTypeKey]}</span>
					</td>
					<td height="30px" style="width: 70px">证件号:</td>
					<td height="30px" width="80px" style="width: 180px">
					    <span style="width: 140px" id="guestNum">${cardMaintainBean.guestNum}</span>
					</td>
					<td height="30px" style="width: 70px">有效期:</td>
					<td height="30px" width="80px" style="width: 180px">
					    <span style="width: 140px" id="disEffectiveDate">${cardMaintainBean.disEffectiveDate}</span>
					</td>
				</tr>
				<tr>
					<td height="30px" style="width: 70px">卡类型:</td>
					<td height="30px" width="80px" style="width: 180px">
					    <input name="cardMaintainBean.cardType" value="${cardMaintainBean.cardType}" style="display: none;" id="cardType"></input>
					    <s:set var="cardTypeKey" value="cardMaintainBean.cardType">
						</s:set>
				   	    <span style="width: 140px">${cardType[cardTypeKey]}</span>
					</td>
					<td height="30px" style="width: 70px">卡状态:</td>
					<td height="30px" width="80px" style="width: 180px">
					    <input name="cardMaintainBean.cardStatus" value="${cardMaintainBean.cardStatus}" style="display: none;" id="cardStatus"></input>
					     <s:set var="cardStakey" value="cardMaintainBean.cardStatus">
						 </s:set>
						 <span style="width: 140px">${cardStatus[cardStakey]}</span>
					</td>
				</tr>
			</table>
			<hr class="subLineColor">
	</s:form>
</body>