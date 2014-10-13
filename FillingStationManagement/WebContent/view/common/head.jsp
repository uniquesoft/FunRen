<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="com.fr.station.common.data.ApplicationContext"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- js -->
<script type="text/javascript" src="<%=basePath%>js/system/head.js"></script>

<!-- css -->
<link type="text/css" rel="stylesheet" href="css/head.css" /> 

<body onload="show()">
	<div class="header">
		<div class="logo">
			<div class="top_menu">
				<table style="width:100; height:50;" >
                        <tr>
                            <td><a href="Index.aspx" target="_parent"><img src="images/system/qyxx_r3_c21.jpg"  style="width:67; height:50; margin-left: 15px; padding-left: 5px" border="0" alt="" /></a></td>
                            <td><a href="javascript:void(0)" id="editpass"><img src="images/system/qyxx_r3_c221.jpg" style="width:67; height:50;" border="0" alt="" /></a></td>
                            <td><a href="Login.aspx" target="_parent" onclick="return confirm('你确认要重新登陆吗?');"><img src="images/system/qyxx_r3_c23.jpg" style="width:65; height:50;"  border="0" alt="你确认要重新登陆吗" /></a></td>
                            <td><a href="Login.aspx" target="_parent" onclick="return confirm('你确认要退出吗?');"><img src="images/system/qyxx_r3_c24.jpg" style="width:67; height:50;"  border="0" alt="你确认要退出吗" /></a></td>
                            <td><a href="javascript:void(0)" onclick="javascript:AddFavorite('#','Angel工作室软件制作');"><img src="images/system/qyxx_r3_c22.jpg" style="width:67; height:50;"  border="0" alt="" /></a></td>
                            <td><a href="#" target="_parent"><img src="images/system/qyxx_r3_c25.jpg" style="width:67; height:50;" border="0" alt="" /></a></td>
                        </tr>
                    </table>
			</div>
		</div>
	</div>

	<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#F0F5F9">
       <tr>
           <td height="27" align="left" valign="middle" class="qy_menuleftbg" style="width: 880px">
               <table border="0" cellspacing="0" cellpadding="0">
                   <tr>
                       <td width="26" align="right" valign="middle">
                           <img src="images/system/340.gif" width="16" height="16" />
                       </td>
                       <td class="qy_topk2px" colspan="2">&nbsp;
                                                                       用户名：<span class="qy_lsfont">${userName}</span>&nbsp;&nbsp;
                                                                       角色：<span class="qy_lsfont"><%=ApplicationContext.getInstance().getRoleName()%></span>&nbsp;&nbsp;
                                                                       登陆时间:        
						     <%Date currentTime = new Date(); 
								SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								out.println(formatter.format(currentTime));
						        %>&nbsp;&nbsp;
                                                                       今日天气：<iframe src="http://m.weather.com.cn/m/pn4/weather.htm " width="150" height="16" marginwidth="0"
                               marginheight="0" hspace="0" vspace="0" frameborder="0" scrolling="no" allowtransparency="true"></iframe>
                           <span style="color: red"></span>
                       </td>
                   </tr>
               </table>
           </td>
           <td align="right" valign="middle" class="qy_menurighbg">
               <table width="320" border="0" cellspacing="0" cellpadding="0">
                   <tr>
                       <td width="21" align="left" valign="middle">
                           <img src="images/system/320.gif" width="16" height="16" alt="" />
                       </td>
                       <td id="nowDiv" align="left" valign="middle" class="qy_date" >
                       </td>
                   </tr>
               </table>
           </td>
       </tr>
   </table>
</body>