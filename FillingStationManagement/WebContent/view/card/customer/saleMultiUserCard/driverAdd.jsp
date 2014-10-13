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
<script type="text/javascript" src="<%=basePath%>js/card/customer/stationLimit.js"></script>
<title>增加司机</title>
</head>
<body id="driverAdd_body">
	<div style="color: #2874ff; font-size: 14px; text-align: right; margin-top: -8px; margin-bottom: 10px">
	当前站点:<span>${stationName}</span>
	当前班次 :<span>${classNo}</span>
	</div>
	<form id="driverAdd_form" method="post" action="saveDriver">
		<div id="tt" class="easyui-tabs"style="width: 790px; height: 300px;">
			<div title="单位卡售卡" style="padding: 20px;">
			<table style="font-size: 12px;">
			<tr>
				<td style="height: 40px; width: 85px">卡号<span style="color:red;">*</span></td>
				<td style="width: 150px">
					<input name="registerCustomerBean.cardNo" maxlength="20" onkeyup="value=value.replace(/[^\d]/g,'')" id="cardNo" style="width:150px;">
				</td>
				<td style="height: 40px; width: 85px">卡片类型<span style="color:red;">*</span></td>
				<td style="width: 150px">  
					<input name="registerCustomerBean.cardType" value="多用户" readonly="readonly" id="cardType">
				</td>
				<td style="height: 40px; width: 85px">生效日期<span style="color:red;">*</span></td>
				<td style="width: 150px">
					<input name="registerCustomerBean.effectiveDate" class="easyui-datebox" editable="false" id="effectiveDate" style="width:135px">
				</td>
			</tr>
			<tr>
				<td style="height: 40px; width: 85px">卡内金额<span style="color:red;">*</span></td>
				<td style="width: 150px">
					<input name="registerCustomerBean.cardAmount" maxlength="8" onkeyup="value=value.replace(/[^\d]/g,'')" id="cardAmount" style="width:150px;">
				</td>
				<td style="height: 40px; width: 85px">押金<span style="color:red;">*</span></td>
				<td style="width: 150px">
					<input name="registerCustomerBean.deposit" maxlength="8" onkeyup="value=value.replace(/[^\d]/g,'')"  id="deposit">
				</td>
				<td style="height: 40px; width: 85px">失效日期<span style="color:red;">*</span></td>
				<td style="width: 150px">
					<input name="registerCustomerBean.disEffectiveDate" class="easyui-datebox" editable="false" id="disEffectiveDate" style="width:135px">
				</td>
			</tr>
			<tr>
        		<td style="height: 40px; width: 85px">印刷号<span style="color:red;">*</span></td>
				<td style="width: 150px">
					<input name="registerCustomerBean.cardExno" maxlength="8" onkeyup="value=value.replace(/[^\d]/g,'')" id="cardExno" style="width:150px;">
				</td>
        		<td style="height: 40px; width: 85px">卡密码标识</td>
				<td style="width: 150px"> 
					启用<input name="registerCustomerBean.passFlag" type=radio id="passEnable" value="true">
					&nbsp;&nbsp;&nbsp;
					停用<input name="registerCustomerBean.passFlag" type=radio id="passDisenable" value="false" checked="checked">
				</td>
				<td style="height: 40px; width: 85px">卡密码</td>
				<td style="width: 150px">
					<input name="registerCustomerBean.cardPass" type="password" maxlength="16" id="cardPass" disabled="disabled" style="width:150px">
				</td>
        	</tr>
			<tr>
				<td style="height: 40px; width: 85px">客户编号<span style="color:red;">*</span></td>
				<td style="width: 150px">
					<input name="registerCustomerBean.guestNo" id="guestNo" value="${registerCustomerBean.guestNo}" readonly="readonly" style="width:150px;" maxlength="6">
				</td>
				<td style="height: 40px; width: 85px">备注</td>
				<td style="width: 150px">
					<input name="registerCustomerBean.remark" maxlength="20" id="remark">
				</td>
				<td align="right" colspan="2">
					<input type="button" id="jumpTo2" onclick="$('#tt').tabs('select', '司机信息');"value="下一项">
				</td>
			</tr>
			</table>
			</div>
			<div title="司机信息" style="padding: 20px;">
			<table style="font-size: 12px;">
			<tr>
				<td style="height: 40px; width: 85px">姓名<span style="color:red;">*</span></td>
				<td width="150px">
					<input name="registerCustomerBean.guestName" maxlength="10" id="guestName">
				</td>
				<td style="height: 40px; width: 85px">证件类型<span style="color:red;">*</span></td>
				<td width="150px">
					<select name="registerCustomerBean.guestType" id="guestType" style="width: 135px">
								<option></option>
								<c:forEach var="guestType" items="${guestType}">
									<option value="${guestType.key}">
										${guestType.value}
									</option>
								</c:forEach>
					</select>
				</td>
				<td style="height: 40px; width: 85px">证件号码<span style="color:red;">*</span></td>
				<td width="150px">
					<input name="registerCustomerBean.guestNum" maxlength="18" onkeyup="value=value.replace(/[^\d]/g,'')" id="guestNum">
				</td>
			</tr>
			<tr>
				<td style="height: 40px; width: 85px">电话</td>
				<td width="150px">
					<input name="registerCustomerBean.guestTel" maxlength="20" onkeyup="value=value.replace(/[^\d]/g,'')" id="guestTel">
				</td>
				<td style="height: 40px; width: 85px">电子邮箱</td>
				<td width="150px">
					<input name="registerCustomerBean.email" maxlength="30" id="email">
				</td>
				<td style="height: 40px; width: 85px">性别</td>
				<td width="150px">
					男<input name="registerCustomerBean.gender" type=radio id="genderMale" value="男"  checked="checked">
					&nbsp;&nbsp;&nbsp;
					女<input name="registerCustomerBean.gender" type=radio id="genderFemale" value="女">
				</td>
			</tr>
			<tr>
				<td style="height: 40px; width: 85px">邮政编码</td>
				<td>
					<input name="registerCustomerBean.zipCode" maxlength="8" onkeyup="value=value.replace(/[^\d]/g,'')" id="zipCode">
				</td>
				<td style="height: 40px; width: 85px">联系地址</td>
				<td width="150px">
					<input name="registerCustomerBean.customerAddr" maxlength="20" id="customerAddr">
				</td>
				<td style="height: 40px; width: 85px">开票类型</td>
				<td width="150px">
					<select name="registerCustomerBean.billType" id="billType" style="width: 135px">
						<c:forEach var="billType" items="${billType}">
							<option value="${billType.key}">
								${billType.value}
							</option>
						</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td style="height: 40px; width: 85px">所属部门</td>
				<td width="150px">
					<select name="registerCustomerBean.deptNo" id="deptNo" style="width: 135px">
						<option></option>
						<c:forEach var="deptNo" items="${registerCustomerBean.depNoToName}">
							<option value="${deptNo.key}">
								${deptNo.value}
							</option>
						</c:forEach>
				</select>
				</td>
				<td align="right" colspan="4">
					<input type="button" id="jumpTo3" onclick="$('#tt').tabs('select', '加油限制');"value="下一项">
				</td>
			</tr>
			</table>
			</div>
			<div title="加油限制" style="padding: 20px;">
			<table style="font-size: 12px;">
        			<tr>
        				<td style="height: 40px; width: 85px; ">每次加油限量</td>
						<td style="width: 150px">
							<input name="registerCustomerBean.refuelLimit" maxlength="5" onkeyup="value=value.replace(/[^\d]/g,'')" id="refuelLimit">
						</td>
						<td style="height: 40px; width: 85px; ">每天加油次数</td>
						<td style="width: 150px">
							<input name="registerCustomerBean.refuelTimes" maxlength="2" onkeyup="value=value.replace(/[^\d]/g,'')" id="refuelTimes">
						</td>
						<td style="height: 40px; width: 85px; ">每天消费金额</td>
						<td style="width: 150px">
							<input name="registerCustomerBean.consumeAmount" maxlength="8" onkeyup="value=value.replace(/[^\d]/g,'')" id="consumeAmount">
						</td>
        			</tr>
        			<tr>
        				<td style="height: 40px; width: 85px; ">限车号标识</td>
						<td style="width: 150px">
						启用<input name="registerCustomerBean.carNoFlag" type=radio id="carNoEnable" value="true">
						&nbsp;&nbsp;&nbsp;
						停用<input name="registerCustomerBean.carNoFlag" type=radio id="carNoDisenable" value="false" checked="checked">
						</td>
						<td style="height: 40px; width: 85px; ">限车号</td>
						<td style="width: 150px">
							<input name="registerCustomerBean.carNoConstr" maxlength="16" id="carNoConstr" disabled="disabled">
						</td>
						<td style="height: 40px; width: 85px; ">限制油品</td>
						<td style="width: 150px">
							<select name="registerCustomerBean.oilTypeLimit" id="oilTypeLimit" style="width:135px;">
								<option selected></option>
								<c:forEach var="oilTypeLimit" items="${oilTypeLimit}">
									<option value="${oilTypeLimit.key}">
										${oilTypeLimit.value}
									</option>
								</c:forEach>
							</select>
						</td>
        			</tr>
        			<tr>
        				<td style="height: 40px; width: 85px; ">限站标识</td>
						<td style="width: 150px">
						启用<input name="registerCustomerBean.stationFlag" type=radio id="stationEnable" value="true">
						&nbsp;&nbsp;&nbsp;
						停用<input name="registerCustomerBean.stationFlag" type=radio id="stationDisenable" value="false" checked="checked">
						</td>
						<td style="height: 40px; width: 85px; ">限站信息</td>
						<td style="width: 150px">
							<table>
								<tr>
									<td>
										<select multiple="multiple" name="registerCustomerBean.stationInfoLimit" id="stationInfoLimit" style="width: 100px;height:100px;" disabled="disabled">
										</select>
									</td>
									<td>
										<p><span id="addStationInforButton" style="font-size:30px">+</span></p>
										<p><span id="removeStationInforButton" style="font-size:30px">-</span></p>
									</td>
								</tr>
							</table>
						</td>
						<td>
							<select multiple="multiple" id="alternativeStationList" style="width:100px;height:100px;display:none">
								<c:forEach var="stationList" items="${stationList}">
									<option value="${stationList.key}">
										${stationList.value}
									</option>
								</c:forEach>
							</select>
						</td>
        			</tr>
        		</table>    
			</div>
		</div>
	</form>
</body>
</html>