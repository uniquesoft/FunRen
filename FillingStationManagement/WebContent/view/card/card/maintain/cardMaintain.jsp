<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>

<%@include file="../../../common/common.jsp"%>
<script type="text/javascript" src="<%=basePath%>js/card/card/maintain/cardMaintain.js"></script>
<script type="text/javascript" src="<%=basePath%>js/card/card/maintain/cardLost.js"></script>
<script type="text/javascript" src="<%=basePath%>js/card/card/maintain/cancelLossCard.js"></script>
<script type="text/javascript" src="<%=basePath%>js/card/card/maintain/changePass.js"></script>
<script type="text/javascript" src="<%=basePath%>js/card/card/maintain/replaceCard.js"></script>
<script type="text/javascript" src="<%=basePath%>js/card/card/maintain/unLockCard.js"></script>
</head>
<body>
	<s:form id="form1">
	<TABLE style="font-size: 9px; font-family: Arial; table-layout: fixed; width: 100%; height: 76%">
		<tr>
			<td width="86%" valign="top" style="border-left: #7BAED5 solid 0px; padding-left: 2px">
				<span class="pageFontStyle">卡片处理</span>
				<hr class="lineColor">
				<table style="font-size: 12px;width: 100%; height: 50px; font-weight: bold;" class="tableContent">
					<tr>
						<td height="3px" style="width: 80px;">卡号:
						<td height="30px" >
						    <input name="cardMaintainBean.cardNo" style="width: 150px" maxlength="20" id="cardNo"></input>
						</td>
						<td height="30px" style="width: 80px;">客户名称:</td>
						<td height="30px" width="80px" >
						    <input name="cardMaintainBean.guestName" style="width: 150px"  maxlength="20" id="guestName"></input>
						</td>
						<td height="30px" style="width: 80px;">客户编号:</td>
						<td height="30px" width="80px" >
						    <input name="cardMaintainBean.guestNo" onkeyup="value=value.replace(/[^(\d)]/g,'')"  maxlength="6" style="width: 150px" id="guestNo"></input>
						</td>
					</tr>
					<tr>
						<td height="30px" style="width: 80px;">证件类型:</td>
						<td height="30px" width="80px" >
						    <select name="cardMaintainBean.guestType" style="width: 150px" id="guestType">
								<s:set var="guestTypeKey" value="cardMaintainBean.guestType">
								</s:set>
								<option value="${guestTypeKey}">${guestType[guestTypeKey]}</option>
								<c:forEach var="guestType" items="${guestType}">
									<option value="${guestType.key}">${guestType.value}</option>
								</c:forEach>
						    </select>
						</td>
						<td height="30px" style="width: 80px;">证件号:</td>
						<td height="30px" width="80px" >
						    <input name="cardMaintainBean.guestNum" style="width: 150px"  maxlength="18" id="guestNum" onkeyup="value=value.replace(/[^(\d)]/g,'')"></input>
						</td>
						<td width="30px"></td>
						<td width="200px"style="text-align:left" >
							<input type='button' value='读&nbsp;卡' id="cardMaintain_readCard"  style="width: 50px">
							<input type='button' value='查&nbsp;询' id="cardMaintain_search" style="width: 50px">
							<input type='button' value='重&nbsp;置' id="cardMaintain_clickclear" style="width: 50px">
						</td>
					</tr>
				</table>
				<hr class="lineColor">
				<table class="tableContent">
					<tr>
						<td><input type='button' value='挂&nbsp;失' id="cardMaintain_lost" style="width: 80px;"></td>
						<td><input type='button' value='止&nbsp;挂' id="cardMaintain_cancelLost" style="width: 80px;"></td>
						<td><input type='button' value='补&nbsp;卡' id="cardMaintain_replace" style="width: 80px;"></td>
						<td><input type='button' value='解&nbsp;灰' id="cardMaintain_unlock" style="width: 80px;"></td>
						<td><input type='button' value='密码修改' id="cardMaintain_changepass" style="width: 80px;"></td>
					</tr>
				</table>
				<table id="card_dg" title="查询信息" style="width: auto; height: auto;">
				</table>
			</td>
		</tr>	
		<!-- 隐藏 -->
		<tr>
			<!-- 卡状态 -->
			<td style="display:none">
				<select name="cardMaintainBean.cardStatus" id="cardStatus">
				<option selected>   </option>
				<c:forEach var="cardSta" items="${cardStatus}">
					<option value="${cardSta.key}">${cardSta.value}</option>
				</c:forEach>
				</select>
			</td>
			<!-- 卡类型 -->
			<td style="display:none">
				<select name="cardMaintainBean.cardType" id="cardType">
				<option selected>   </option>
				<c:forEach var="cardType" items="${cardType }">
					<option value="${cardType.key }">${cardType.value }
				</option>
				</c:forEach>
				</select>
			</td>
		</tr>
		</TABLE>
	</s:form>
	    <div id="addCardLostDialog" class="easyui-window" closed="true" modal="true" title="标题" style="width: 800px; height: 350px;">
		    <iframe scrolling="auto" id='addCardLostIFrame' frameborder="0" src="" style="width: 100%; height: 100%;"></iframe>
	    </div>
	    <div id="addCancelLossCardDialog" class="easyui-window" closed="true" modal="true" title="标题" style="width: 800px; height: 	350px;">
		    <iframe scrolling="auto" id='addCancelLossCardIFrame' frameborder="0" src="" style="width: 100%; height: 100%;"></iframe>
	    </div>
	    <div id="addUnLockCardDialog" class="easyui-window" closed="true" modal="true" title="标题" style="width: 800px; height: 	350px;">
		    <iframe scrolling="auto" id='addUnLockCardIFrame' frameborder="0" src="" style="width: 100%; height: 100%;"></iframe>
	    </div>
	    <div id="changePassDialog" class="easyui-window" closed="true" modal="true" title="标题" style="width: 800px; height: 350px;">
		    <iframe scrolling="auto" id='changePassIFrame' frameborder="0" src="" style="width: 100%; height: 100%;"></iframe>
	    </div>
	    <div id="replaceCardDialog" class="easyui-window" closed="true" modal="true" title="标题" style="width: 800px; height: 450px;">
		    <iframe scrolling="auto" id='replaceCardIFrame' frameborder="0" src="" style="width: 100%; height: 100%;"></iframe>
	    </div>

	    <div id="printCardLostDialog" class="easyui-window" closed="true" modal="true" title="标题" style="width: 850px; height: 400px;">
		    <iframe scrolling="auto" id='printCardLostIFrame' frameborder="0" src="" style="width: 100%; height: 100%;"></iframe>
	    </div>
	    <div id="printReplaceCardDialog" class="easyui-window" closed="true" modal="true" title="标题" style="width: 850px; height: 400px;">
		    <iframe scrolling="auto" id='printReplaceCardIFrame' frameborder="0" src="" style="width: 100%; height: 100%;"></iframe>
	    </div>
	    <div id="printChangePassDialog" class="easyui-window" closed="true" modal="true" title="标题" style="width: 850px; height: 400px;">
		    <iframe scrolling="auto" id='printChangePassIFrame' frameborder="0" src="" style="width: 100%; height: 100%;"></iframe>
	    </div>
	    <div id="confirmMaincard" closed="true" modal="true"  class="easyui-window" title="请确认" style="width: 360px; height: 140px; padding: 10px;closed:true">
		   <table>
		    	<tr>
			   		 <td>请插入主卡后点击确定核对客户身份，或按取消返回</td>
		  	 	</tr>
		    	<tr>
			    	<td>
			    	<input type='button' value='确&nbsp;定'  id="cardLost_yes2">
			   		<input type='button' value='取&nbsp;消'  id="cardLost_no2">
			   		</td>
		    	</tr>
		    </table>
		</div>
</body>