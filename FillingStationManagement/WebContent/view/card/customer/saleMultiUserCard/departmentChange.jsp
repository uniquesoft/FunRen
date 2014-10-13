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
<title>增加部门</title>
</head>
<body id="depChange_body">
<p style="color: #2874ff; font-size: 14px; text-align: right">
当前站点:<span>${stationName}</span>
当前班次 :<span>${classNo}</span>
</p>
<hr class="subLineColor">
<form id="depChange_form" method="post" action="changeDriverDepNo">
<table style="font-size: 9px; font-family: Arial; table-layout: fixed;">
	<tr>
		<td style="height: 40px; width: 85px; text-align: center;">卡号<span style="color:red;">*</span></td>
		<td style="width:150px">
			<input name="registerCustomerBean.cardNo" id="cardNo" value="${registerCustomerBean.cardNo}" readonly="readonly">
		</td>
		<td style="height: 40px; width: 85px">所属部门</td>
		<td width="150px">
			<select name="registerCustomerBean.deptNo" id="deptNo" style="width: 135px">
				<s:set var="depKey" value="registerCustomerBean.deptNo">
				</s:set>
				<option value="${depKey}">${registerCustomerBean.depNoToName[depKey]}</option>
				<c:forEach var="deptNo" items="${registerCustomerBean.depNoToName}">
					<option value="${deptNo.key}">
						${deptNo.value}
					</option>
				</c:forEach>
			</select>
		</td>
	</tr>
</table>
</form>
<hr class="subLineColor">
</body>
</html>