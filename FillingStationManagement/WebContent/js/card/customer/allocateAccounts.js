/**
 * this js works to allocate accounts
 */
var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
var server_context=basePath;

$(document).ready(function(){
	$("#account_allocate").click(function() {
		$('#allocateAccountDialog').form('clear');
	  var transferAccountsBean = $('#viceCardTable').datagrid('getSelected');
	  if (!transferAccountsBean){
		  $.messager.alert('错误','请选择记录!');
	  }else{
		  if(transferAccountsBean.viceCardStatus!='1'){
			  $.messager.alert('错误','当前副卡状态非正常，不能进行账户分配，请重新选择!');
			  return false;
		  }
			$('#allocateAccountIFrame')[0].src= server_context + '/transferAccounts/showAccountsInfo?transferAccountsBean.mainCardNo='+transferAccountsBean.mainCardNo+'&'+'transferAccountsBean.viceCardNo='+transferAccountsBean.viceCardNo;
	        	$('#allocateAccountDialog').dialog({
	        		closed : false,
	                title : '账户分配',
	                shadow : true,
	                modal : true,
	                collapsible : true,
	                buttons : [{
	                	text : '保存',
	                    iconCls : 'icon-save',
	                    id : 'sBtn',
	                    handler:function() {
	                    	saveTotalInformation();
	                    	
	                    }
	                }, {
	                    text : '取消',
	                    id : 'cBtn',
	                    handler : function() {
	                        $('#allocateAccountDialog').dialog('close');
	                    }
	                } ]
	        });
	  }
  });
});		
	function validateValue(rDocument){
		var allocateAmount = rDocument.getElementById('allocateAmount');
		var allocateType = rDocument.getElementById('allocateType');
		
		if(check(allocateType)){
			$.messager.alert('错误','分配类型必须选择!');
			return false;
		}
		if(check(allocateAmount) ){
			$.messager.alert('错误','分配数额必须填写!');
			return false;
		}
		if(allocateType.value=='0'){
			if(allocateAmount.value <= 0){
				$.messager.alert('错误','分配金额应大于零，请重新填写!');
				return false;
			}
			if(allocateAmount.value >= 99999999){
				$.messager.alert('错误','分配金额应小于99999999，请重新填写!');
				return false;
			}
			if((allocateAmount.value - rDocument.getElementById('mainCardProvisionAccount').value)>0){
				$.messager.alert('错误','分配金额大于主卡的备付账户余额，请重新填写!');
				return false;
			}
			if(rDocument.getElementById('viceCardProvisionAccount').value >= 99999999){
				$.messager.alert('错误','副卡备付账户金额已满，无法分配!');
				return false;
			}
			if((parseInt(allocateAmount.value)+parseInt(rDocument.getElementById('viceCardProvisionAccount').value))>99999999){
				$.messager.alert('错误','分配后副卡备付账户金额已满，请重新填写!');
				return false;
			}
		}
		if(allocateType.value=='1'){
			if(allocateAmount.value <= 0){
				$.messager.alert('错误','分配积分应大于零，请重新填写!');
				return false;
			}
			if((allocateAmount.value - rDocument.getElementById('mainCardPoint').value)>0){
				$.messager.alert('错误','分配积分大于主卡的积分余额，请重新填写!');
				return false;
			}
		}
		return true;
	}
	// 表单验证
	var check = function (input) {
	    if (input.value == '') {
	        input.focus();
	        return true;
	    } else {
	        return false;
	    };
	};

function saveTotalInformation(){
	var rDocument = document.getElementById("allocateAccountIFrame").contentWindow.document;
	var flag = validateValue(rDocument);
	if(flag){
		$.messager.confirm('提示', '您确认提交?提交后将不可更改', function(correct){
			if (correct){
				var result = saveAllocate();
				if(result){
					var doc = document.getElementById("allocateAccountIFrame").contentWindow.window;
					var mainCardProvisionAccount = doc.$("#mainCardProvisionAccount").val() - doc.$("#allocateAmount").val();
					var mainCardPoint = doc.$("#mainCardPoint").val() - doc.$("#allocateAmount").val();
					var viceCardProvisionAccount = new Number(rDocument.getElementById("viceCardProvisionAccount").value) + new Number(rDocument.getElementById("allocateAmount").value);
					var viceCardPoint = parseFloat(rDocument.getElementById("viceCardPoint").value) + parseFloat(rDocument.getElementById("allocateAmount").value);
					$('#printIFrame')[0].src= server_context + '/view/card/customer/printAllocateAccounts.jsp?guestNo='+
					doc.$("#guestNo").val()+'&mainCardGuestName='+encodeURI(encodeURI(doc.$("#mainCardGuestName").val()))+'&allocateAmount='+
					doc.$("#allocateAmount").val()+'&mainCardProvisionAccount='+mainCardProvisionAccount+'&viceCardNo='+
					doc.$("#viceCardNo").val()+'&viceCardProvisionAccount='+viceCardProvisionAccount+'&allocateType='+
					doc.$("#allocateType").val()+'&viceCardPoint='+viceCardPoint+'&mainCardPoint='+mainCardPoint;
					$('#printDialog').dialog({
						 closed : false,
			                title : '加油卡分配打印',
			                shadow : true,
			                modal : true,
			                collapsible : true,
			                buttons : [{
			                	text : '返回',
			                    id : 'returnBtn',
			                    handler:function(){
			                    	updateTable();
			                    	$("#printDialog").dialog("close");
			                    }
			                }],
			                onBeforeClose:function(){
			                	updateTable();
			                }
					});
					$("#allocateAccountDialog").dialog("close");
					updateTable();
				}
			}else{
				return correct;
			}
		});
		
		/*$.ajax({
			data:$(addEmplform).serialize(),
			url:encodeURI(server_context+"/cardStorage/saveCardOrder"),type:'POST',timeout:3000,dataType:'html',
			success:function(data){
				
			},
			error:function(){
				$.messager.alert('错误','请重试!');
			}
		});*/
		
		
	}
};
function saveAllocate(){
	var rDocument = document.getElementById("allocateAccountIFrame").contentWindow.document;
	var addEmplform = rDocument.getElementsByTagName('form');
	var flag = false;
	var yz = $.ajax({
		type : 'post',
		url : server_context+'/transferAccounts/saveAllocateRecords',
		data:$(addEmplform).serialize(),
		cache : false,
		async:false,
		dataType : 'json',
		success : function(loaddata) {
			$.messager.alert('成功','保存账户分配信息成功!');
			flag=true;
		},
		error : function() {
			$.messager.alert('错误','保存失败，请重试!');
		}
	});
	return flag;
}