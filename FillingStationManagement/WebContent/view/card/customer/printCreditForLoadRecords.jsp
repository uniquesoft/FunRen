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
		<td colspan="6">
			<hr color="black">
		</td>
	</tr>
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">客户姓名</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="viceCardGuestName"><%= java.net.URLDecoder.decode(request.getParameter("viceCardGuestName"),"utf-8")%>
			</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">卡号</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="viceCardNo"><%= request.getParameter("viceCardNo")%>
			</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">客户编号</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="guestNo"><%= request.getParameter("guestNo")%>
			</span>
		</td>
	</tr>
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">业务类型</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="workType">圈存
			</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">支付方式</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="accountType">转账
			</span>
		</td>
	</tr>
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">交易金额</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="allocateAmount"><%= request.getParameter("gatherAmount")%>
			</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">卡内余额</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="viceCardBalance"><%= request.getParameter("moneyInCard")%>
			</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">备用账户余额</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="viceCardProvisionAccount"><%= request.getParameter("moneyInAccount")%>
			</span>
		</td>
	</tr>
	<tr>
		<td colspan="6">
			<hr color="black">
		</td>
	</tr>
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">客户签字</td>
		<td style="height: 50px; width: 100px; text-align: center;">
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">操作员编号</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="userId">${operatorNo}
			</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">交易时间</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="time"><%Date currentTime = new Date(); 
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			out.println(formatter.format(currentTime)); 
			%></span>
		</td>
	</tr>
	</table>
</body>
</html>