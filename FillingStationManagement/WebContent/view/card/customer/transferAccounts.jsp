<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*" %>

<html>

<head>
<%@include file="../../common/common.jsp" %>
<script type="text/javascript" src="<%=basePath%>js/system/plugins/jquery.edatagrid.js"></script>
<script type="text/javascript" src="<%=basePath%>js/card/customer/transferAccounts.js"></script>
<script type="text/javascript" src="<%=basePath%>js/card/customer/allocateAccounts.js"></script>
<script type="text/javascript" src="<%=basePath%>js/card/customer/gatherAccounts.js"></script>
</head>
<body>
	
	<TABLE style="font-size: 9px; font-family: Arial; table-layout: fixed; width: 100%; height: 76%">
		<tr>
			<td width="86%" valign="top"
				style="border-left: #7BAED5 solid 0px; padding-left: 2px">

				<span class="pageFontStyle">卡片信息一览</span>
				<hr class="lineColor">
				<table style="font-size: 12px;width: 100%; height: 50px; font-weight: bold;">
					<tr>
						<td height="3px" width="60px">主卡号:
						<td height="30px" width="100px">
							<input type="text" name="transferAccountsBean.mainCardNo" id="mainCardNo" style="width:150px" maxLength="20" disabled="disabled">
						</td>
						<td height="30px" width="60px">客户编号:</td>
						<td height="30px" width="100px">
							<input type="text" name="transferAccountsBean.guestNo" id="guestNo" style="width:150px" maxLength="6" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
						</td>
						<td height="30px" width="100px"><input type='button' value='&nbsp;读&nbsp;卡' id="read_card"></td>
						<td height="30px" width="100px"><input type='button' value='&nbsp;查&nbsp;询' id="search_card" disabled="disabled"></td>
					</tr>
					<tr style="display:none">
						<td>
							<select  id="cardStatus" style="width:150px">
								<option selected>   </option>
								<c:forEach var="cardStatus" items="${cardStatus}">
									<option value="${cardStatus.key}">
										${cardStatus.value}
									</option>
								</c:forEach>
							</select>
						</td>
						<td>
							<select  id="guestStatus" style="width:150px">
								<option selected>   </option>
								<c:forEach var="guestStatus" items="${guestStatus}">
									<option value="${guestStatus.key}">
										${guestStatus.value}
									</option>
								</c:forEach>
							</select>
						</td>
					</tr>
				</table>
				<hr class="lineColor">
				<table class="tableButton">
					<tr>
						<td><input type='button' value='&nbsp;账户分配' id="account_allocate"></td>
						<td><input type='button' value='&nbsp;圈存圈提' id="account_gather"></td>
					</tr>
				</table>
				<br>
				<table id="viceCardTable" title="副卡信息" style="width: auto;height: auto;">
				</table>
				
			</td>
		</tr>

	</TABLE>

	<div id="allocateAccountDialog" class="easyui-window" closed="true" modal="true" title="标题" style="width:800px;height:400px;"> 
    	<iframe  id='allocateAccountIFrame' frameborder="0"  src="" style="width:100%;height:280px;"></iframe> 
	</div>
	
	<div id="gatherAccountDialog" class="easyui-window" closed="true" modal="true" title="标题" style="width:800px;height:450px;"> 
    	<iframe  id='gatherAccountIFrame' frameborder="0"  src="" style="width:100%;height:320px;"></iframe> 
	</div>
	
	<div id="printDialog" class="easyui-window" closed="true" modal="true" title="标题" style="width:800px;height:400px;"> 
    	<iframe  id='printIFrame' frameborder="0"  src="" style="width:100%;height:280px;"></iframe> 
	</div>
	
	<div id="printGatherDialog" class="easyui-window" closed="true" modal="true" title="标题" style="width:800px;height:400px;"> 
    	<iframe  id='printGatherIFrame' frameborder="0"  src="" style="width:100%;height:280px;"></iframe> 
	</div>
	
</body>
</html>