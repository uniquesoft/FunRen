<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/";
%>
<html>
<!-- js -->
<script type="text/javascript" src="<%=basePath%>js/common/print.js"></script>
<head>
<title>单位卡无主卡卡售卡打印</title>

<style   media=print>
.Noprint{display:none;}
.PageNext{page-break-after:   always;}
</style>

</head>
<body id="printAnonymousCard_body">
	<div id ="noPrintArea" class= "NOPRINT ">
	<hr color="red">
	<span><b>售卡凭证</b></span>  
	<span style="margin-left:650px;">
	<input type="button" value="打印" id="print" onclick="javascript:window.print();">
	</span>
	<hr color="red">
	</div>
	<div style="text-align:center">
	<b>中国石油加油卡单位卡售卡凭证</b>
	</div>
	<table style="font-size: 15px;width:100%">
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">业务流水号</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="businessNum"><%Date businessNum= new Date(); 
			SimpleDateFormat formatterNum = new SimpleDateFormat("yyyyMMddHHmmss");
			out.println(formatterNum.format(businessNum)); 
			%></span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">站点名称</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="stationName">${stationName}
			</span>
		</td>
	</tr>
	<tr>
		<td colspan="6">
			<hr color="black">
		</td>
	</tr>
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">卡号</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="cardNo"><%= request.getParameter("cardNo")%>
			</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">卡片类型</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="cardType">多用户</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">卡押金</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="deposit"><%= request.getParameter("deposit")%>
			</span>
		</td>
	</tr>
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">单位名称</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="guestName"><%= java.net.URLDecoder.decode(request.getParameter("guestName"),"utf-8")%>
			</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">证件类型</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="guestType"><%= java.net.URLDecoder.decode(request.getParameter("guestType"),"utf-8")%>
			</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">单位证件号</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="guestNum"><%= request.getParameter("guestNum")%>
			</span>
		</td>
	</tr>
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">开户银行</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="bankType"><%= java.net.URLDecoder.decode(request.getParameter("bankType"),"utf-8")%>
			</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">银行帐号</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="bankAcc"><%= request.getParameter("bankAcc")%>
			</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">单位电话</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="guestTel"><%= request.getParameter("guestTel")%>
			</span>
		</td>
	</tr>
	<tr>
		<td colspan="6">
			<hr color="black">
		</td>
	</tr>
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">业务发生时间</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="time"><%Date currentTime = new Date(); 
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			out.println(formatter.format(currentTime)); 
			%></span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">操作员编号</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="operatorNo">${operatorNo}
			 </span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">客户签字</td>
	</tr>
	</table>
</body>
</html>