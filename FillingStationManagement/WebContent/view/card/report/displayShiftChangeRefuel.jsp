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
<script type="text/javascript" src="<%=basePath%>js/card/report/shiftChangeRefuel.js"></script>
</head>
<body>
	<TABLE style="font-size: 9px; font-family: Arial; table-layout: fixed; width: 100%; height: 79%">
		<tr>
			<td width="86%" valign="top"
				style="border-left: #7BAED5 solid 0px; padding-left: 2px">
				<div class="pageFontStyle">交接班一览</div>
				<hr class="lineColor">
				<table style="font-size: 12px;width: 100%; height: 50px; font-weight: bold;">
					<tr>
						<td height="3px" style="width:70px">交接班序号:
						<td height="30px" style="width:200px">
							<input name="shiftChangeBean.shiftChageNum" style="width:140px" id="shiftChageNum"></input>
						</td>
						<td height="30px" style="width:70px" >班组号:</td>
						<td height="30px" width="80px" style="width:200px">
							<input name="shiftChangeBean.classNum" style="width:140px" id="classNum"></input>
						</td>
						<td height="30px" width="70px">交接班日期:</td>
						<td height="30px" width="80px" style="width:200px">
							<input name="shiftChangeBean.shiftDate" id="datepicker1" class="easyui-datebox" style="width:140px" >
						<td><input type='button' value='&nbsp;检&nbsp;索' id="shiftChange_search">
						<input type='button' value='&nbsp;导&nbsp;出' id="shiftChange_report"></td>
					</tr>
				</table>
				<hr class="lineColor">
				<table id="dg" title="交接班报表一览" style="width: auto;height: auto;">
				</table>
			</td>
		</tr>
	</TABLE>
</body>
</html>