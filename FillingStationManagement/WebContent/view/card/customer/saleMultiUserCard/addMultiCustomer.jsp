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
<script type="text/javascript" src="<%=basePath%>js/card/customer/saleMultiUserCard/addMultiCustomer.js"></script>
<script type="text/javascript" src="<%=basePath%>js/card/customer/stationLimit.js"></script>
<title>新建单位客户</title>
</head>
<body id="customerAdd_body">
	<div style="color: #2874ff; font-size: 14px; margin-left:680px; margin-top: -8px; margin-bottom: 10px">
	当前站点:<span>${stationName}</span>
	当前班次 :<span>${classNo}</span>
	</div>
	<form id="customerAdd_form" method="post" action="saveCustomer">
	<div id="tt" class="easyui-tabs" style="width:950px;height:450px;">
    	<div title="单位卡售卡" style="padding:20px;">
       		<table>
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
				<!-- 
				<td style="height: 40px; width: 85px; ">卡内金额<span style="color:red;">*</span></td>
				<td style="width: 150px">
					<input name="registerCustomerBean.cardAmount" maxlength="8" onkeyup="value=value.replace(/[^\d]/g,'')" id="cardAmount" style="width:150px; display:none;">
				</td>
				-->
				<td style="height: 40px; width: 85px">押金<span style="color:red;">*</span></td>
				<td style="width: 150px">
					<input name="registerCustomerBean.deposit" maxlength="8" onkeyup="value=value.replace(/[^\d]/g,'')"  id="deposit" style="width:150px;">
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
				<td style="height: 40px; width: 85px">备注</td>
				<td style="width: 150px">
					<input name="registerCustomerBean.remark" maxlength="20" id="remark" style="width:150px;">
				</td>
				<td align="right" colspan="4">
					<input type="button" id="readCard" value="读卡" style="width:60px;">
					<input type="button" id="jumpTo2" onclick="$('#tt').tabs('select', '客户档案');"value="下一项">
				</td>
			</tr>
       		</table>
    	</div>
    	<div title="客户档案" data-options="closable:true" style="padding:20px;">
        <table><tr>
				<td style="height: 40px; width: 85px">单位名称<span style="color:red;">*</span></td>
				<td style="width: 150px">
					<input name="registerCustomerBean.guestName" maxlength="10" id="guestName">
				</td>
				<td style="height: 40px; width: 85px">单位证件<span style="color:red;">*</span></td>
				<td style="width: 150px">
					<select name="registerCustomerBean.guestType" id="guestType" style="width: 135px">
								<option></option>
								<c:forEach var="guestType" items="${guestType}">
									<option value="${guestType.key}">
										${guestType.value}
									</option>
								</c:forEach>
					</select>
				</td>
				<td style="height: 40px; width: 85px">单位证件号<span style="color:red;">*</span></td>
				<td style="width: 150px">
					<input name="registerCustomerBean.guestNum" maxlength="18" onkeyup="value=value.replace(/[^\d]/g,'')" id="guestNum">
				</td>
			</tr>
			<tr>
        		<td style="height: 40px; width: 85px">联系人姓名</td>
				<td  style="width: 150px">
					<input name="registerCustomerBean.contactName" maxlength="10" id="contactName">
				</td>
				<td style="height: 40px; width: 85px">联系人证件</td>
				<td  style="width: 150px">
					<select name="registerCustomerBean.contactType" id="contactType" style="width: 135px">
								<option></option>
								<c:forEach var="guestType" items="${guestType}">
									<option value="${guestType.key}">
										${guestType.value}
									</option>
								</c:forEach>
					</select>
				</td>
				<td style="height: 40px; width: 85px">联系人证件号</td>
				<td style="width: 150px">
					<input name="registerCustomerBean.contactNum" maxlength="18" onkeyup="value=value.replace(/[^\d]/g,'')" id="contactNum">
				</td>
        	</tr>
			<tr>
				<td style="height: 40px; width: 85px">电话</td>
				<td style="width: 150px">
					<input name="registerCustomerBean.guestTel" maxlength="20" onkeyup="value=value.replace(/[^\d]/g,'')" id="guestTel">
				</td>
				<td style="height: 40px; width: 85px">电子邮箱</td>
				<td style="width: 150px">
					<input name="registerCustomerBean.email" maxlength="30" id="email">
				</td>
				<td style="height: 40px; width: 85px">性别</td>
				<td style="width: 150px">
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
				<td style="width: 150px">
					<input name="registerCustomerBean.customerAddr" maxlength="20" id="customerAddr">
				</td>
				<td style="height: 40px; width: 85px">开票类型</td>
				<td style="width: 150px">
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
        		<td style="height: 40px; width: 85px">开户银行<span style="color:red;">*</span></td>
				<td  style="width: 150px">
					<select name="registerCustomerBean.bankType" id="bankType" style="width: 135px">
								<option></option>
								<c:forEach var="bankType" items="${bankType}">
									<option value="${bankType.key}">
										${bankType.value}
									</option>
								</c:forEach>
					</select>
				</td>
				<td style="height: 40px; width: 85px">银行帐号<span style="color:red;">*</span></td>
				<td style="width: 150px">
					<input name="registerCustomerBean.bankAcc" maxlength="20" onkeyup="value=value.replace(/[^\d]/g,'')" id="bankAcc">
				</td>
				<td style="height: 40px; width: 85px">税务登记号<span style="color:red;">*</span></td>
				<td style="width: 150px">
					<input name="registerCustomerBean.taxNum" maxlength="20" onkeyup="value=value.replace(/[^\d]/g,'')" id="taxNum">
				</td>
        	</tr>
        	<tr>
				<td style="height: 40px; width: 85px">单位类型 </td>
				<td style="width: 150px">
					<select name="registerCustomerBean.corpType" id="corpType" style="width: 135px">
								<option></option>
								<c:forEach var="corpType" items="${corpType}">
									<option value="${corpType.key}">
										${corpType.value}
									</option>
								</c:forEach>
					</select>
				</td>
				<td style="height: 40px; width: 85px">联系人生日 </td>
				<td style="width: 150px">
					<input name="registerCustomerBean.contactBir" class="easyui-datebox" editable="false" id="contactBir" style="width: 135px">
				</td>
				<td style="height: 40px; width: 85px">备注 </td>
				<td  style="width: 150px">
					<input name="registerCustomerBean.guestRemark" maxlength="20" id="guestRemark">
				</td>
       		</tr>
       		<tr>
       			<td style="height: 40px; width: 100%; text-align: right;" colspan="6">
					<input type="button" id="saleCard" value="售卡" style="width:50px">
					<input type="reset" id="reset" value="重置" style="width:50px">
					<input type="reset" id="returnBack" value="返回" style="width:50px">
				</td>
       		</tr>
        </table>
        <div id="printCardDialog" class="easyui-window" closed="true" modal="true" title="标题" style="width: 850px; height: 450px;">
		<iframe scrolling="auto" id='printCardIFrame' frameborder="0" src="" style="width: 100%; height: 100%;"></iframe>
		</div>
   	   	</div>
	</div>
	</form>
</body>
</html>