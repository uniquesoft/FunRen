<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>

<html>
<head>
<title>加油卡分配打印</title>
<script type="text/javascript">

</script>

<style   media=print>
.Noprint{display:none;}
.PageNext{page-break-after:   always;}
</style>

</head>
<body id="printAllocate_body">
	<div id ="noPrintArea" class= "NOPRINT ">
	<hr color="red">
	<span><b>加油卡分配汇总凭证</b></span>  
	<span style="margin-left:650px;">
	<input type="button" value="打印" id="print" onclick="javascript:window.print();">
	</span>
	<hr color="red">
	</div>
	<div style="text-align:center">
	<b>中国石油加油卡分配汇总凭证</b>
	</div>
	<table style="font-size: 13px;width:100%">
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">业务流水号</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="busnessNum"><%Date businessNum= new Date(); 
			SimpleDateFormat formatterNum = new SimpleDateFormat("yyyyMMddHHmmss");
			out.println(formatterNum.format(businessNum)); 
			%>
			</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">站点名称</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="stationName">${stationName}
			</span>
		</td>
	</tr>
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">单位编号</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="guestNo"><%= request.getParameter("guestNo")%>
			</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">单位名称</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="mainCardGuestName"><%= java.net.URLDecoder.decode(request.getParameter("mainCardGuestName"),"utf-8")%>
			</span>
		</td>
	</tr>
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">业务类型</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="workType">分配
			</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">账户类型</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="accountType">
				<c:set var="allocateTypeKey" value='<%=request.getParameter("allocateType") %>'></c:set>
				${allocateType[allocateTypeKey]}
			</span>
		</td>
	</tr>
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">交易数额</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="allocateAmount">-<%= request.getParameter("allocateAmount")%>
			</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">账户余额</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="mainCardProvisionAccount">
			<c:set var="allocateKey" value='<%=request.getParameter("allocateType") %>'></c:set>
				<c:if test="${allocateKey==0}">
				<%= request.getParameter("mainCardProvisionAccount")%>
				</c:if>
				<c:if test="${allocateKey==1}">
				<%= request.getParameter("mainCardPoint")%>
				</c:if>
			</span>
		</td>
	</tr>
	<tr>
		<td colspan="6">
			<hr color="black">
		</td>
	</tr>
	</table>
	<table style="font-size: 13px;width:100%">
		<tr>
			<td style="height: 50px; width: 100px; text-align: center;">卡号</td>
			<td style="height: 50px; width: 100px; text-align: center;">数额（元/点）</td>
			<td style="height: 50px; width: 100px; text-align: center;">余额（元/点）</td>
		</tr>
		<tr>
			<td style="height: 50px; width: 100px; text-align: center;"><%= request.getParameter("viceCardNo")%></td>
			<td style="height: 50px; width: 100px; text-align: center;"><%= request.getParameter("allocateAmount")%></td>
			<td style="height: 50px; width: 100px; text-align: center;">
			<c:set var="alloKey" value='<%=request.getParameter("allocateType") %>'></c:set>
				<c:if test="${alloKey=='0'}">
				<%= request.getParameter("viceCardProvisionAccount")%>
				</c:if>
				<c:if test="${alloKey==1}">
				<%= request.getParameter("viceCardPoint")%>
				</c:if>
			<!-- <%= request.getParameter("viceCardProvisionAccount")%>/<%= request.getParameter("viceCardPoint")%> -->
			</td>
		</tr>
	</table>
</body>
</html>