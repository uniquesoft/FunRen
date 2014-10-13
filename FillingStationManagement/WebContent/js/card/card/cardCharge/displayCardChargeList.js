	var localObj = window.location;
	var contextPath = localObj.pathname.split("/")[1];
	var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
	var server_context=basePath;
	$(document).ready(function(){
		$("#readCard").click(function(){
		alert("读卡");
		});
		$("#search").click(function(){
			//alert("查询");
			var cardNo = $("#cardNo").val();
			var guestNo = $("#guestNo").val();
			if(cardNo == '' && guestNo == ''){
				$.messager.alert('错误', '卡号和客户编号不能同时为空');
				return;
			}
			//提交表单
			document.cardAccount_form.submit();
		});
		$("#charge").click(function(){
			//alert("充值");
			//判断是否经过查询
			var cardNo = $("#cardNo").val();
			var guestNo = $("#guestNo").val();
			if(cardNo =='' || guestNo == ''){
				$.messager.alert('错误', '必须先查询!');
				return;
			}
			//判断卡号
			var spanCardNo = $("#cardNum").text();
			//alert('$'+spanCardNo+'$');
			if(spanCardNo == ''){
				alert("查询的卡号不能为空");
				return;
			}
			//判断客户编号
			var spanGuestNo = $("#customerNo").text();
			//alert('$'+spanGuestNo+'$');
			if(spanGuestNo == ''){
				alert("查询的客户编号不能为空");
				return;
			}
			
			//判断卡状态
			var cardStatus = $("#cardStatus").text();
			//alert('$'+cardStatus+'$');
			if(cardStatus != '启用'){
				alert("卡状态必须为启用");
				return;
			}
			//判断充值总和
			var rechargeAmount = $("#rechargeAmount").text();
			//alert('$'+rechargeAmount+'$');
			if(rechargeAmount == ''){
				alert("充值总和不能为空");
				return;
			}
			//判断消费总和
			var consumeSum = $("#consumeSum").text();
			//alert('$'+consumeSum+'$');
			if(consumeSum == ''){
				alert("消费总和不能为空");
				return;
			}
			//判断卡内余额
			var cardAccount = $("#cardAccount").text();
			//alert('$'+cardAccount+'$');
			if(cardAccount == ''){
				alert("卡内余额不能为空");
				return;
			}
			//判断交易额是否为空
			var chargeAmount = $("#chargeAmount").val();
			if(chargeAmount == ''){
				$.messager.alert('错误', '交易额不能为空!');
				return;
			}
			//判断交易类型是否是充值
			var tradeType = $("#tradeType").find("option:selected").text();
			//alert(tradeType);
			if(tradeType != '充值'){
				$.messager.alert('错误', '交易类型只能是充值!');
				return;
			}
			if(parseFloat($("#chargeAmount").val())<0){
				$.messager.alert('错误', '交易额不能是负数!');
				return;
			}
			if((parseFloat($("#cardAccount").text())+parseFloat($("#chargeAmount").val()))>99999999){
				$.messager.alert('错误', '超出账户最大额度');
				return;
			}
			//alert("做充值");
			doCharge();
		});
		$("#reset").click(function(){
			//alert("重置");
			var cardNo = document.getElementById("cardNo");
			cardNo.value = "";
			var guestNo = document.getElementById("guestNo");
			guestNo.value = "";
			var chargeAmount = document.getElementById("chargeAmount");
			chargeAmount.value = "";
		});
		$("#cancel").click(function(){
			//alert("扣款");
			//判断是否经过查询
			var cardNo = $("#cardNo").val();
			var guestNo = $("#guestNo").val();
			if(cardNo =='' || guestNo == ''){
				$.messager.alert('错误', '必须先查询!');
				return;
			}
			//判断卡号
			var spanCardNo = $("#cardNum").text();
			//alert('$'+spanCardNo+'$');
			if(spanCardNo == ''){
				alert("查询的卡号不能为空");
				return;
			}
			//判断客户编号
			var spanGuestNo = $("#customerNo").text();
			//alert('$'+spanGuestNo+'$');
			if(spanGuestNo == ''){
				alert("查询的客户编号不能为空");
				return;
			}
			
			//判断卡状态
			var cardStatus = $("#cardStatus").text();
			//alert('$'+cardStatus+'$');
			if(cardStatus != '启用'){
				alert("卡状态必须为启用");
				return;
			}
			//判断充值总和
			var rechargeAmount = $("#rechargeAmount").text();
			//alert('$'+rechargeAmount+'$');
			if(rechargeAmount == ''){
				alert("充值总和不能为空");
				return;
			}
			//判断消费总和
			var consumeSum = $("#consumeSum").text();
			//alert('$'+consumeSum+'$');
			if(consumeSum == ''){
				alert("消费总和不能为空");
				return;
			}
			//判断卡内余额
			var cardAccount = $("#cardAccount").text();
			//alert('$'+cardAccount+'$');
			if(cardAccount == ''){
				alert("卡内余额不能为空");
				return;
			}
			//判断交易额是否为空
			var chargeAmount = $("#chargeAmount").val();
			if(chargeAmount == ''){
				$.messager.alert('错误', '交易额不能为空!');
				return;
			}
			//判断交易类型是否是 消费 退款 撤销
			var tradeType = $("#tradeType").find("option:selected").text();
			//alert('$'+tradeType+'$');
			if(tradeType != '消费'&&tradeType != '退款'&&tradeType != '撤销'){
				$.messager.alert('错误', '交易类型只能是消费,退款,撤销!');
				return;
			}
			if(parseFloat($("#chargeAmount").val())<0){
				$.messager.alert('错误', '交易额不能是负数!');
				return;
			}
			if(parseFloat($("#chargeAmount").val())>parseFloat($("#cardAccount").text())){
				$.messager.alert('错误', '扣款额不能大于卡内余额');
				return;
			}
			//alert("做扣款");
			deductAccount();
		});
		//改变交易流水号的显示
		$("#payType").change(function(){
			if(this.value == '12'){
				$("#bankSerialNum").show();
				$("#serialNumLabel").show();
			}
			else{
				$("#bankSerialNum").hide();
				$("#serialNumLabel").hide();
			}
		});
	});
	//充值
	function doCharge(){
		$.ajax({
			type : 'post',
			url : server_context+'/cardCharge/saveCardChargeInfo',
			data : {
				"cardChargeBean.id" : $("#cardAccId").val(),
				"cardChargeBean.cardNo" : $("#cardNum").text(),
				"cardChargeBean.guestNo" : $("#guestNo").text(),
				"cardChargeBean.guestName" : $("#guestName").text(),
				"cardChargeBean.cardAccount" : $("#cardAccount").text(),
				"cardChargeBean.rechargeAmount" : $("#rechargeAmount").text(),
				"cardChargeBean.consumeSum" : $("#consumeSum").text(),
				"cardChargeBean.chargeAmount" : $("#chargeAmount").val(),
				"cardChargeBean.payType" : $("#payType").val(),
				"cardChargeBean.tradeType" : $("#tradeType").val(),
				"cardChargeBean.bankSerialNum" : $("#bankSerialNum").val()
			},
			cache : false,
			dataType : 'json',
			success : function(){
				$.messager.alert('成功', '已充值!');
				$('#printCardIFrame')[0].src= server_context + '/view/card/card/cardCharge/printCardCharge.jsp'
				+'?cardNo='+$("#cardNum").text()
				+'&cardType='+encodeURI(encodeURI($("#cardType").text()))
				+'&cardStatus='+encodeURI(encodeURI($("#cardStatus").text()))
				+'&guestNo='+$("#customerNo").text()
				+'&guestName='+encodeURI(encodeURI($("#guestName").text()))
				+'&tradeType='+encodeURI(encodeURI($("#tradeType").find("option:selected").text()))
				+'&chargeAmount='+document.getElementById("chargeAmount").value
				+'&payType='+encodeURI(encodeURI($("#payType").find("option:selected").text()))
				+'&cardAccount='+(parseFloat($("#cardAccount").text())+parseFloat(document.getElementById("chargeAmount").value));
				$('#printCardDialog').dialog({
						closed : false,
		                title : '充值凭证打印',
		                shadow : true,
		                modal : true,
		                collapsible : true,
		                buttons : [{
		                	text : '返回',
		                    id : 'returnBtn',
		                    handler:function(){
		                    	//alert("返回");
		                    	$("#printCardDialog").dialog("close");
		                    	document.cardAccount_form.submit();
		                    }
		                }]
				});
			},
			error : function(){
				$.messager.alert('错误', '充值失败!');
			}
		});
	}
	//扣款
	function deductAccount(){
		$.ajax({
			type : 'post',
			url : server_context+'/cardCharge/saveCardChargeInfo',
			data : {
				"cardChargeBean.id" : $("#cardAccId").val(),
				"cardChargeBean.cardNo" : $("#cardNum").text(),
				"cardChargeBean.guestNo" : $("#guestNo").text(),
				"cardChargeBean.guestName" : $("#guestName").text(),
				"cardChargeBean.cardAccount" : $("#cardAccount").text(),
				"cardChargeBean.rechargeAmount" : $("#rechargeAmount").text(),
				"cardChargeBean.consumeSum" : $("#consumeSum").text(),
				"cardChargeBean.chargeAmount" : $("#chargeAmount").val(),
				"cardChargeBean.payType" : $("#payType").val(),
				"cardChargeBean.tradeType" : $("#tradeType").val(),
				"cardChargeBean.bankSerialNum" : $("#bankSerialNum").val()
			},
			cache : false,
			dataType : 'json',
			success : function(){
				$.messager.alert('成功', '已扣款!');
				$('#printCardIFrame')[0].src= server_context + '/view/card/card/cardCharge/printCardCharge.jsp'
				+'?cardNo='+$("#cardNum").text()
				+'&cardType='+encodeURI(encodeURI($("#cardType").text()))
				+'&cardStatus='+encodeURI(encodeURI($("#cardStatus").text()))
				+'&guestNo='+$("#customerNo").text()
				+'&guestName='+encodeURI(encodeURI($("#guestName").text()))
				+'&tradeType='+encodeURI(encodeURI($("#tradeType").find("option:selected").text()))
				+'&chargeAmount='+document.getElementById("chargeAmount").value
				+'&payType='+encodeURI(encodeURI($("#payType").find("option:selected").text()))
				+'&cardAccount='+(parseFloat($("#cardAccount").text())-parseFloat(document.getElementById("chargeAmount").value));
				$('#printCardDialog').dialog({
						closed : false,
		                title : '扣款凭证打印',
		                shadow : true,
		                modal : true,
		                collapsible : true,
		                buttons : [{
		                	text : '返回',
		                    id : 'returnBtn',
		                    handler:function(){
		                    	//alert("返回");
		                    	$("#printCardDialog").dialog("close");
		                    	document.cardAccount_form.submit();
		                    }
		                }]
				});
			},
			error : function(){
				$.messager.alert('错误', '扣款失败!');
			}
		});
	}
