//included in displayRegisterCustomer.jsp
	var readFlag = false;
	$(document).ready(function(){
		$("#anonymousCard_add").click(function(){
		$('#saleCardIFrame')[0].src= server_context + '/view/card/customer/saleAnonymousCard.jsp'; 
        	$('#saleCardDialog').form('clear');
        	readFlag=false;
            $('#saleCardDialog').dialog({
                closed : false,
                title : '不记名卡售卡',
                shadow : true,
                modal : true,
                collapsible : true,
                buttons : [{
                	text : '读卡',
                    id : 'readBtn',
                    handler:function(){
                    	alert("读卡");
                    	readFlag = true;
                    }
                }, {
                    text : '售卡',
                    id : 'saleBtn',
                    handler : function() {
                    	//alert("不记名卡 readFlag is "+readFlag);
                        if(readFlag){
                        	var rDocument = document.getElementById("saleCardIFrame").contentWindow.document;
                        	var flag = validateAnonyFieldValue(rDocument);
                        	var saleAnonymousCard_form = rDocument.getElementsByTagName('form');
                        	//alert("不记名卡 flag is "+flag);
                        	//alert($(saleAnonymousCard_form).serialize());
                        	if(flag){
                        		//alert("不记名卡验证通过");
                        		$.ajax({
                        			data:$(saleAnonymousCard_form).serialize(),
                        			url:encodeURI(server_context+"/registCustomer/saveCardInfo"),type:'POST',timeout:3000,dataType:'html',
    	                			success:function(data){
    	                				$("#saleCardDialog").dialog("close");
    	                        				alert("不记名卡数据传输成功");
    	                        				$('#printCardIFrame')[0].src= server_context + '/view/card/customer/printAnonymousCard.jsp'
    	                        				+'?cardNo='+rDocument.getElementById('cardNo').value
    	                        				+'&cardExno='+rDocument.getElementById('cardExno').value
    	                        				+'&cardAmount='+rDocument.getElementById('cardAmount').value
    	                        				+'&deposit='+rDocument.getElementById('deposit').value
    	                        				+'&amount='+(parseFloat(rDocument.getElementById('cardAmount').value)+parseFloat(rDocument.getElementById('deposit').value))
    	                        				+'&effectiveDate='+document.getElementById("saleCardIFrame").contentWindow.window.$("#effectiveDate").datebox('getValue')
    	                        				+'&disEffectiveDate='+document.getElementById("saleCardIFrame").contentWindow.window.$("#disEffectiveDate").datebox('getValue');
    	    	                				$('#printCardDialog').dialog({
    	    	                					 closed : false,
    	    	                		                title : '不记名卡打印',
    	    	                		                shadow : true,
    	    	                		                modal : true,
    	    	                		                collapsible : true,
    	    	                		                buttons : [{
    	    	                		                	text : '返回',
    	    	                		                    id : 'returnBtn',
    	    	                		                    handler:function(){
    	    	                		                    	$("#printCardDialog").dialog("close");
    	    	                		                    }
    	    	                		                }]
    	    	                				});
    	    	        			},
    	    	        			error:function(){
    	    	        				$.messager.alert('错误','不记名卡信息保存失败，请重试!');
    	    	        			}
    	            		});
                        	}
                        }
                      }
                }, {
                    text : '重置',
                    id : 'resetBtn',
                    handler : function() {
                    	var rDocument = document.getElementById("saleCardIFrame").contentWindow.document;
                    	rDocument.getElementById('saleAnonymousCard_form').reset();
                    }
                }, {
                    text : '返回',
                    id : 'returnBtn',
                    handler : function() {
                    	$('#saleCardDialog').dialog("close");
                    }
                }]
        });
	
	});
});

	function validateAnonyFieldValue(rDocument){
		//alert("进入validateAnonyFieldValue");
		//卡号
    	var cardNo = rDocument.getElementById('cardNo').value;
    	if(cardNo == ''){
    		alert('卡号为必填项!');
			return false;
    	}
    	//卡片类型
		var cardType = rDocument.getElementById('cardType').value;
		if(cardType != '不记名用户卡'){
    		alert('卡片类型必须为不记名用户卡!');
			return false;
    	}
		//押金
		var deposit = rDocument.getElementById('deposit').value;
		if(deposit == ''){
    		alert('押金为必填项!');
			return false;
    	}
		if(isNaN(deposit)){
			alert('押金必须为数字!');
			return false;
		}
		//卡内金额
		var cardAmount = rDocument.getElementById('cardAmount').value;
		if(cardAmount == ''){
    		alert('卡内金额为必填项!');
			return false;
    	}
		if(isNaN(cardAmount)){
			alert('卡内金额必须为数字!');
			return false;
		}
		//生效日期
		var effectiveDate =document.getElementById("saleCardIFrame").contentWindow.window.$("#effectiveDate").datebox('getValue');
		if(effectiveDate == ''){
    		alert('生效日期为必填项!');
			return false;
    	}
		//失效日期
		var disEffectiveDate = document.getElementById("saleCardIFrame").contentWindow.window.$("#disEffectiveDate").datebox('getValue');
		if(disEffectiveDate == ''){
    		alert('失效日期为必填项!');
			return false;
    	}
		//印刷号
		var cardExno = rDocument.getElementById('cardExno').value;
		if(cardExno == ''){
    		alert('印刷号为必填项!');
			return false;
    	}
		//把限制区站全选中
		var stationInfoLimit= rDocument.getElementById('stationInfoLimit');
		for(var i=0;i<stationInfoLimit.options.length;i++)
		{
			stationInfoLimit.options[i].selected=true;
		}
		return true;
	}
	
