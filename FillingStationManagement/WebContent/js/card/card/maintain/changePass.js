//此JS用于卡片维护的修改密码操作
$(function() {
	$('#enter_password').window({
		modal:true,
		closed:false,
		 onBeforeClose:function(){
			window.history.go(-1); 
			wondow.history.back();
         }
	});
	$('#enter_new_password').window({
		modal:true,
		closed:true,
		onBeforeClose:function(){
			window.history.go(-1); 
			wondow.history.back();
	    }
	});
});
var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var basePath = localObj.protocol + "//" + localObj.host + "/" + contextPath;
var server_context = basePath;

$(document).ready(function() {
	$("#cardMaintain_changepass").click(function(){
		$('#changePassDialog').form('clear');
		var cardMaintainBean = $('#card_dg').datagrid('getSelected');
		  if (!cardMaintainBean){
			  $.messager.alert("错误",'请选择记录!');
		  }else{
			  $('#changePassIFrame')[0].src= server_context + '/cardMaintain/showChangePass?cardMaintainBean.id='+cardMaintainBean.id;
			  if(cardMaintainBean.cardType=="13"){
				  $.messager.alert("错误",'不记名卡不能修改密码!');
				  return ;
			  }
			  if(cardMaintainBean.cardStatus!='1'){
				  $.messager.alert("错误","该卡不在使用状态下");
				  return ;
			  }
			  $('#changePassDialog').dialog({
	        		closed : false,
	        		title: "密码修改",
	                shadow : true,
	                modal : true,
	                collapsible : true,
	                onBeforeClose:function(){
	                	updateTable();
	                }
	        });
		  }
	});
	$("#changePass").click(function(){
		if($("#cardNo").text()==''){
			$.messager.alert("错误","卡号必填！");
		}
		else if($("#passFlag").val()=='N'){
			$.messager.alert("错误","密码未启用！");
		}
		else
			window.location.href=server_context+"/cardMaintain/judgePass?aaa="+$("#cardNo").text();
	});
	$("#startUsingPass").click(function(){
		if($("#passFlag").val()=='Y'){
			$.messager.alert("已启用","密码已启用，无需启用密码");
		}
		else if(confirm('确定要启用密码吗?(如果不修改为新密码则启用失败)'))
		{
			$("#passFlag").val('Y');
			$.messager.alert("启用","密码已启用");
		}
	});
	$("#cardMaintain_clear").click(function(){
		document.getElementById("changePassDialog").reset();
	});
	$("#cardMaintain_no1").click(function() {
		window.history.go(-1); 
		wondow.history.back();
	});
	$("#cardMaintain_yes1").click(function() {
		full=checkPass();
		if(full==1){
			$.messager.alert("正确","正确");
		$("#enter_new_password").window('open');
		}
		else{
			$.messager.alert("错误","密码错误！");
			$("#oldPassword").val('');
		}
	});
	$("#cardMaintain_no2").click(function() {
		window.history.go(-1); 
		wondow.history.back();
	});
	$("#cardMaintain_yes2").click(function() {
		var a=document.getElementById("newPassword2").value;
		var b=document.getElementById("newPassword").value;
		if(a!=b){
			$.messager.alert("错误",'2次输入的密码不一致');
			$("#newPassword").val('');
			$("#newPassword2").val('');
		}
		if(a==b){
		click_changePass();
		$("#haddenClass").val(a);
		$.messager.alert("成功","修改成功！");
		window.history.go(-1); 
		wondow.history.back();
	}
	});
});

function checkPass(){
	var bool='';
	var yk = $.ajax({
		type : 'post',
		url : server_context+'/cardMaintain/checkPass',
		async: false,
		data : {
			"cardMaintainBean.cardNo" :$("#haddenClass").val(),
			"cardMaintainBean.cardPass":document.getElementById('oldPassword').value
			},
		success: function(data) {
			bool=1;
		},
		error: function() {
			bool=0;
		}
	});
	return bool;
}

function click_changePass(){
	var yz = $.ajax({
		type : 'post',
		url : server_context+'/cardMaintain/changePass',
		data : {
			"cardMaintainBean.cardNo" : $("#haddenClass").val(),
			"cardMaintainBean.cardPass":document.getElementById("newPassword").value
			},
		success : function() {
		},
		error : function() {
		}
	});
}
//重新查询
function updateTable(){
	var pageSize=$('#card_dg').datagrid('getPager').data("pagination").options.pageSize;
	var pageNumber=$('#card_dg').datagrid('getPager').data("pagination").options.pageNumber;
	var yz = $.ajax({
		type : 'post',
		url : server_context+'/cardMaintain/showCardMaintainList',
		data : {
			"cardMaintainBean.cardNo" : $("#cardNo").val(),
			"cardMaintainBean.guestName" : $("#guestName").val(),
			"cardMaintainBean.guestNo" : $("#guestNo").val(),
			"cardMaintainBean.guestType" :$("#guestType").val(),
			"cardMaintainBean.guestNum" :$("#guestNum").val(),
			"cardMaintainBean.pageNumber" : pageNumber,
			"cardMaintainBean.pageSize" : pageSize
			},
		cache : false,
		dataType : 'json',
		success : function(loaddata) {
			gridData = loaddata.jsonData;
			if(gridData == null){
				$('#card_dg').datagrid('loadData',{total:0,rows:[]});
			}
			var data = $.parseJSON(gridData);    
			$('#card_dg').datagrid('loadData', data);
		},
		error : function() {
		}
	});
}
