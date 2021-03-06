//此JS用于卡维护界面的解灰卡操作
function judge(){
	if(window.ActiveXObject)//判断浏览器是否属于IE
		{
			var browser=navigator.appName;
			var b_version=navigator.appVersion;
			var version=b_version.split(";");
			var trim_Version=version[1].replace(/[ ]/g,"");
			if(browser=="Microsoft Internet Explorer" && (trim_Version=="MSIE7.0" || trim_Version=="MSIE8.0" || trim_Version=="MSIE9.0"))//是否是IE8
			{
				return true;
			}
		}
	return false;
}
$(function() {
	$('#confirmMaincard').window({
		modal : true,
		closed : true
	});
});
var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var basePath = localObj.protocol + "//" + localObj.host + "/" + contextPath;
var server_context = basePath;
$(document).ready(function() {
		$("#cardMaintain_unlock").click(function() {
			$('#addUnLockCardDialog').form('clear');
			var cardMaintainBean = $('#card_dg').datagrid('getSelected');
			if (!cardMaintainBean) {
				$.messager.alert("错误","请选择记录!");
			} else {
				$('#addUnLockCardIFrame')[0].src = server_context+ '/cardMaintain/showUnLockCard?cardMaintainBean.id='+ cardMaintainBean.id;
				  if(cardMaintainBean.cardType=="13"){
					  $.messager.alert("错误","不记名卡不能解灰!");
					  return ;
				  }
				  if(cardMaintainBean.cardStatus!="5"){
					  $.messager.alert("错误","不在灰卡状态下无需解灰!");
					  return ;
				  }
				var iframe = document.getElementById("addUnLockCardIFrame").contentWindow;
				$('#addUnLockCardDialog').dialog(
				{
					closed : false,
					title : '解灰',
					shadow : true,
					modal : true,
					collapsible : true,
					buttons : [
					{
						text : '解灰',
						id : 'sBtn',
						handler : function() {
							var rDocument = document.getElementById("addUnLockCardIFrame").contentWindow.document;
							var flag = validateFieldValue(rDocument);
						}
					},
					{
						text : '取消',
						id : 'cBtn',
						handler : function() {
							$('#addUnLockCardDialog').dialog('close');
						}
					}],
					onBeforeClose:function(){
	                	updateTable();
	                }
				});
			}
		});
		function validateFieldValue(rDocument) {
			unLockCard(rDocument);
			return true;
		}

});

	function unLockCard(rDocument) {
		if(judge()){//如果是IE8
		var yz = $.ajax({
				type : 'post',
				url :server_context+'/cardMaintain/unLockCard',
				data : {
					"cardMaintainBean.cardNo" : rDocument.getElementById('cardNo').innerText,
					"cardMaintainBean.guestType" : rDocument.getElementById("guestType").value,
					"cardMaintainBean.guestNum" : rDocument.getElementById("guestNum").innerText
				},
				cache : false,
				success : function(data) {
					$("#addUnLockCardDialog").dialog("close");
					$.messager.alert("成功",'恭喜你解灰成功!');
				},
				error : function() {
					$.messager.alert("失败",'解灰失败，请重试!');
				}
			});
	}
		//如果不是IE8
		else{
				var yz = $.ajax({
							type : 'post',
							url :server_context+'/cardMaintain/unLockCard',
							data : {
								"cardMaintainBean.cardNo" : rDocument.getElementById('cardNo').textContent,
								"cardMaintainBean.guestType" : rDocument.getElementById("guestType").value,
								"cardMaintainBean.guestNum" : rDocument.getElementById("guestNum").textContent
							},
							cache : false,
							success : function(data) {
								$("#addUnLockCardDialog").dialog("close");
								$.messager.alert("成功",'恭喜你解灰成功!');
							},
							error : function() {
								$.messager.alert("错误",'解灰失败，请重试!');
							}
						});
		}
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