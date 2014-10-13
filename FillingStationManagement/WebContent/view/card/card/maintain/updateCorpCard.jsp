<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*" %>
<html>
<head>
<%@include file="../../../common/common.jsp" %>
<script type="text/javascript" src="<%=basePath%>js/system/plugins/jquery.edatagrid.js"></script>
<script type="text/javascript" src="<%=basePath%>js/card/card/maintain/updateCorpCard.js"></script>
<script type="text/javascript" src="<%=basePath%>js/card/customer/stationLimit.js"></script>
</head>
<body>
	<table>
	<s:form id="guestInfoForm">
		<tr>
			<td style="height: 40px; width: 85px; text-align: center;">客户编号</td>
			<td>
				<input name="updateCardInfoBean.guestNo" style="width: 140px" readonly="readonly" maxlength="6" readonly="readonly" id="guestNo" value="${updateCardInfoBean.guestNo}">
			</td>
			<td style="height: 40px; width: 85px; text-align: center;">主卡号</td>
			<td>
				<input name="updateCardInfoBean.mainCardNo" style="width: 140px" readonly="readonly" id="mainCardNo" value="${updateCardInfoBean.mainCardNo}">
			</td>
        	<td style="height: 40px; width: 85px; text-align: center;">单位名称</td>
			<td>
				<input name="updateCardInfoBean.guestName" style="width: 140px" maxlength="40" disabled="disabled" id="guestName" value="${updateCardInfoBean.guestName}">
			</td>
		</tr>
		<tr>
			<td style="height: 40px; width: 85px; text-align: center;">单位类型</td>
			<td>
				<s:set var="guestTypekey" value="updateCardInfoBean.guestType">
				</s:set>
				<input value="${corpType[guestTypekey]}" id="guestType" disabled="disabled" name="updateCardInfoBean.guestType" style="width: 140px">
			</td>
			<td style="height: 40px; width: 85px; text-align: center;">联系人证件</td>
			<td>
				 <select name="updateCardInfoBean.contactType" style="width: 140px" id="contactType">
						<s:set var="guestTypeKey" value="updateCardInfoBean.contactType">
						</s:set>
						<option value="${guestTypeKey}">${guestType[guestTypeKey]}</option>
						<c:forEach var="guestType" items="${guestType}">
							<c:if test="${guestType.key!=guestTypeKey}">
							<option value="${guestType.key}">${guestType.value}</option>
							</c:if>
						</c:forEach>
				    </select>
			</td>
			<td style="height: 40px; width: 85px; text-align: center;">联系人证件号</td>
			<td>
				<input name="updateCardInfoBean.contactNum" id="contactNum" style="width:140px" maxlength="20" value="${updateCardInfoBean.contactNum}">
			</td>
		</tr>
		<tr>
			<td style="height: 40px; width: 85px; text-align: center;">联系人姓名</td>
			<td>
				<input name="updateCardInfoBean.contactName" style="width: 140px" maxlength="20" id="contactName" value="${updateCardInfoBean.contactName}">
			</td>
			<td style="height: 40px; width: 85px; text-align: center;">单位电话</td>
			<td>
				<input name="updateCardInfoBean.guestTel" style="width: 140px" maxlength="20" id="guestTel" value="${updateCardInfoBean.guestTel}">
			</td>
			<td style="height: 40px; width: 85px; text-align: center;">邮政编码</td>
			<td>
				<input name="updateCardInfoBean.zipCode" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="8" style="width: 140px" id="zipCode" value="${updateCardInfoBean.zipCode}">
			</td>
        </tr>
        <tr>
        	<td style="height: 40px; width: 85px; text-align: center;">电子邮箱</td>
			<td>
				<input name="updateCardInfoBean.email" style="width: 140px" id="email" maxlength="30" value="${updateCardInfoBean.email}">
			</td>
			<td style="height: 40px; width: 85px; text-align: center;">联系人生日</td>
			<td>
				<input name="updateCardInfoBean.contactBir" class="easyui-datebox" style="width: 140px" id="contactBir" value="${updateCardInfoBean.contactBir}">
			</td>
			<td style="height: 40px; width: 85px; text-align: center;">开户银行</td>
			<td>
				<select name="updateCardInfoBean.bankType" style="width: 140px" id="bankType">
					<s:set var="bankTypekey" value="updateCardInfoBean.bankType">
					</s:set>
					<option value="${bankTypekey}">${bankType[bankTypekey]}</option>
					<c:forEach var="bankType" items="${bankType}">
						<c:if test="${bankType.key!=bankTypekey}">
						<option value="${bankType.key}">${bankType.value}</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td style="height: 40px; width: 85px; text-align: center;">银行帐号</td>
			<td>
				<input name="updateCardInfoBean.bankAcc" style="width: 140px" id="bankAcc" maxlength="19" value="${updateCardInfoBean.bankAcc}">
			</td>

			<td style="height: 40px; width: 85px; text-align: center;">税务登记号</td>
			<td>
				<input name="updateCardInfoBean.taxNum" id="taxNum" style="width:140px" maxlength="50" value="${updateCardInfoBean.taxNum}">
			</td>
			<td style="height: 40px; width: 85px; text-align: center;">备注 </td>
			<td>
				<input name="updateCardInfoBean.remark" style="width: 140px" id="remark" maxlength="100" value="${updateCardInfoBean.remark}">
			</td>
		</tr>
		<tr>
			<td style="height: 40px; width: 85px; text-align: center;">企业地址</td>
			<td colspan="3">
				<input name="updateCardInfoBean.customerAddr" style="width: 250px" maxlength="40" id="custmoerAddr" value="${updateCardInfoBean.customerAddr}">
			</td>
			<td>
				<input name="updateCardInfoBean.guestStatus" style="display:none;" id="guestStatus" maxlength="100" value="${updateCardInfoBean.guestStatus}">
			</td>
        </tr>
    </s:form>
   </table>
</body>
</html>