//included in displayRegisterCustomer.jsp
	var readFlag=false;
	$(document).ready(function(){
		$("#personalCard_add").click(function(){
		$('#saleCardIFrame')[0].src= server_context + '/view/card/customer/salePersonalCard.jsp'; 
        	$('#saleCardDialog').form('clear');
        	readFlag=false;
            $('#saleCardDialog').dialog({
                closed : false,
                title : '个人记名卡售卡',
                shadow : true,
                modal : true,
                collapsible : true,
                buttons : [{
                	text : '读卡',
                    id : 'readBtn',
                    handler:function() {
                    	alert("读卡");
                    	readFlag=true;
                    }
                }, {
                    text : '售卡',
                    id : 'saleBtn',
                    handler : function() {
                    	//alert("个人记名卡 readFlag is "+readFlag);
                    	if(readFlag){
                    		var pDocument = document.getElementById("saleCardIFrame").contentWindow.document;
                        	var flag = validatePersFieldValue(pDocument);
                        	var salePersonalCard_form = pDocument.getElementsByTagName('form');
                        	//alert("个人记名卡 flag is "+flag);
                        	if(flag){
                        		//alert("个人记名卡验证通过");
                        		$.ajax({
                        			data:$(salePersonalCard_form).serialize(),
                        			url:encodeURI(server_context +"/registCustomer/saveCardInfo"),type:'POST',timeout:3000,dataType:'html',
    	                			success:function(data){
    	                				$("#saleCardDialog").dialog("close");
                        				alert("数据传输成功");
                        				var billTypeSel = pDocument.getElementById('billType');
                        				$('#printCardIFrame')[0].src= server_context + '/view/card/customer/printPersonalCard.jsp'
                        				+'?cardNo='+pDocument.getElementById('cardNo').value
                        				+'&cardExno='+pDocument.getElementById('cardExno').value
                        				+'&cardAmount='+pDocument.getElementById('cardAmount').value
                        				+'&deposit='+pDocument.getElementById('deposit').value
                        				+'&amount='+(parseFloat(pDocument.getElementById('cardAmount').value)+parseFloat(pDocument.getElementById('deposit').value))
                        				+'&guestName='+encodeURI(encodeURI(pDocument.getElementById('guestName').value))
                        				+'&billType='+encodeURI(encodeURI(billTypeSel.options[billTypeSel.selectedIndex].text))
                        				+'&guestTel='+pDocument.getElementById('guestTel').value;
    	                				$('#printCardDialog').dialog({
    	                					 closed : false,
    	                		                title : '个人记名卡打印',
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
    	    	        				$.messager.alert('错误','个人记名卡信息保存失败，请重试!');
    	    	        			}
    	            		});
                        	}
                    	}
                      }
                },{
                    text : '重置',
                    id : 'resetBtn',
                    handler : function() {
                    	//alert("重置");
                    	var pDocument = document.getElementById("saleCardIFrame").contentWindow.document;
                    	pDocument.getElementById('salePersonalCard_form').reset();
                    }
                } ,{
                    text : '返回',
                    id : 'returnBtn',
                    handler : function() {
                    	$('#saleCardDialog').dialog("close");
                    }
                }]
        });
	
	});
	});

	function validatePersFieldValue(pDocument){
		//alert("进入validatePersFieldValue");
		//卡号
    	var cardNo = pDocument.getElementById('cardNo').value;
    	if(cardNo == ''){
    		alert('卡号为必填项!');
			return false;
    	}
    	//卡片类型
		var cardType = pDocument.getElementById('cardType').value;
		if(cardType != '单用户'){
    		alert('卡片类型必须为单用户!');
			return false;
    	}
		//押金
		var deposit = pDocument.getElementById('deposit').value;
		if(deposit == ''){
    		alert('押金为必填项!');
			return false;
    	}
		if(isNaN(deposit)){
			alert('押金必须为数字!');
			return false;
		}
		//卡内金额
		var cardAmount = pDocument.getElementById('cardAmount').value;
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
		var cardExno = pDocument.getElementById('cardExno').value;
		if(cardExno == ''){
    		alert('印刷号为必填项!');
			return false;
    	}
		//持卡人姓名
		var guestName = pDocument.getElementById('guestName').value;
		if(guestName == ''){
    		alert('姓名为必填项!');
			return false;
    	}
		//证件类型
		var guestType = pDocument.getElementById('guestType').value;
		if(guestType == ''){
    		alert('证件类型为必填项!');
			return false;
    	}
		//证件号码
		var guestNum = pDocument.getElementById('guestNum').value;
		if(guestNum == ''){
    		alert('证件号码为必填项!');
    		return false;
    	}
		//把限制区站全选中
		var stationInfoLimit= pDocument.getElementById('stationInfoLimit');
		for(var i=0;i<stationInfoLimit.options.length;i++)
		{
			stationInfoLimit.options[i].selected=true;
		}
		return true;
	}
		
