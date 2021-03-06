	$(document).ready(function(){
		$("#readCard").click(function(){
			alert("读卡");
		});
		$("#search").click(function(){
			//alert("查询");
			var cardNo = $("#cardNO").val();
			var guestNo = $("#guestNO").val();
			if( cardNo == '' && guestNo == ''){
				$.messager.alert('错误', '卡号和客户编号不能都为空');
				return;
			}
			//alert("通过检查");
			document.customer_form.submit();
		});
		$("#haveCardDelete").click(function(){
			//alert("有卡销户");
			//判断查询的卡号，客户编号是否为空
			var cardNo = $("#cardNo").text();
			var guestNo = $("#guestNo").text();
			//alert('$'+cardNo+'$');
			//alert('$'+guestNo+'$');
			if(cardNo == '' || guestNo == ''){
				$.messager.alert('错误', '卡号和客户编号不能为空');
				return;
			}
			//判断是否为单位卡主卡
			var cardType = $("#cardType").text();
			var mainCardFlag = $("#mainCardFlag").text();
			if(!(cardType == '多用户'&&mainCardFlag == 'true')){
				$.messager.alert('错误', '必须是单位卡主卡');
				return;
			}
			//判断是否满足销户条件
			var cardStatus = $("#cardStatus").text();
			var guestStatus = $("#guestStatus").text();
			if(!(cardStatus == '启用' && guestStatus == '使用中')){
				$.messager.alert('错误', '卡状态必须是启用,客户状态必须是使用中');
				return;
			}
			//alert("通过检查");
			deleteCustomer(cardNo,guestNo);
		});
		$("#notHaveCardDelete").click(function(){
			//alert("无卡销户");
			if(confirm('无卡销户必须要先挂失,确定已经挂失经过48小时?')){
				//判断查询的卡号，客户编号是否为空
				var cardNo = $("#cardNo").text();
				var guestNo = $("#guestNo").text();
				//alert('$'+cardNo+'$');
				//alert('$'+guestNo+'$');
				if(cardNo == '' || guestNo == ''){
					$.messager.alert('错误', '卡号和客户编号不能为空');
					return;
				}
				//判断是否为单位卡主卡
				var cardType = $("#cardType").text();
				var mainCardFlag = $("#mainCardFlag").text();
				if(!(cardType == '多用户'&&mainCardFlag == 'true')){
					$.messager.alert('错误', '必须是单位卡主卡');
					return;
				}
				//判断是否满足销户条件
				var cardStatus = $("#cardStatus").text();
				var guestStatus = $("#guestStatus").text();
				if(!(cardStatus == '挂失' && guestStatus == '使用中')){
					$.messager.alert('错误', '卡状态必须是挂失,客户状态必须是使用中');
					return;
				}
				//alert("通过检查");
				deleteCustomerNoCard(cardNo,guestNo);
			}else{
				if(confirm('要进行挂失吗?')){
					//alert("挂失");
					var cardNo = $("#cardNo").text();
					//alert('$'+cardNo+'$');
					cardLost(cardNo);
				}else{
					alert("结束");
				}
			}
		});
		
	});
	//单位客户有卡销户
	function deleteCustomer(cardNo,guestNo){
		$.ajax({
			type : 'post',
			url : server_context+'/customerDelete/deleteMultiCustomer',
			data : {
				"customerDeleteBean.cardNo" : cardNo,
				"customerDeleteBean.guestNo" : guestNo
			},
			cache : false,
			dataType : 'json',
			success : function(){
				$.messager.alert('错误', 'sss!');
				document.customer_form.submit();
				
				
			},
			error : function(){
				$.messager.alert('错误', '销户失败!');
			}
			
		});
	}
	//单位客户无卡销户
	function deleteCustomerNoCard(cardNo,guestNo){
		$.ajax({
			type : 'post',
			url : server_context+'/customerDelete/deleteMultiCustomerNoCard',
			data : {
				"customerDeleteBean.cardNo" : cardNo,
				"customerDeleteBean.guestNo" : guestNo
			},
			cache : false,
			dataType : 'json',
			success : function(){
				$.messager.alert('成功', '销户成功!');
			},
			error : function(){
				$.messager.alert('错误', '销户失败!');
			}
		});
	}
	//卡挂失
	function cardLost(cardNo){
		$.ajax({
			url:encodeURI(server_context+'/cardMaintain/cardLost'),type:'POST',timeout:3000,dataType:'html',
			data : {
				"cardMaintainBean.cardNo" : cardNo
				},
			cache : false,
			success : function() {
				$.messager.alert('成功', '卡挂失成功!');
				
			},
			error : function() {
				$.messager.alert('失败', '卡挂失失败!');
			}
		});
	}
	function print(){
		$('#printCardIFrame')[0].src= server_context + '/view/card/customer/customCancel/printCustomerDelete.jsp';
		$('#printCardDialog').dialog({
			closed : false,
            title : '司机卡注销打印',
            shadow : true,
            modal : true,
            collapsible : true,
            buttons : [{
            	text : '返回',
                id : 'returnBtn',
                handler:function(){
                	alert("返回");
                	$("#printCardDialog").dialog("close");
                }
            }]
	});
	}