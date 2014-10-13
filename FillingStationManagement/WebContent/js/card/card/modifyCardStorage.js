/**
 * this js works for modifing card storage records
 */

var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
var server_context=basePath;

$(document).ready(function(){
	$("#card_modify").click(function() {
		$('#editCardDialog').form('clear');
	  var cardStorageBean = $('#cardListTable').datagrid('getSelected');
	  if (!cardStorageBean){
		  $.messager.alert('错误','请选择记录!');
	  }else{
		  	if(cardStorageBean.receiptStatus=='2'){
		  		$.messager.alert('错误','已入库记录不可编辑');
		  		return false;
		  	}
		  	if(cardStorageBean.receiptStatus=='4'){
		  		$.messager.alert('错误','作废记录不可编辑');
		  		return false;
		  	}
		  	if( ($('#stationNum').val()!=cardStorageBean.supplier) && ($('#stationNum').val()!=cardStorageBean.receiver)){
		  		$.messager.alert('错误','当前申请单与您所在网点无关，您无法更改！');
				return false;
		  	}
		  	if(cardStorageBean.receiptStatus=='3' && ($('#stationNum').val()==cardStorageBean.supplier)){
		  		$.messager.alert('错误','当前申请单状态为已出库，您作为供货方无法进行编辑！');
				return false;
		  	}
		  	if(cardStorageBean.receiptStatus=='1' && cardStorageBean.receiptType=='4' && $('#stationNum').val()==cardStorageBean.receiver){
		  		$.messager.alert('错误','当前申请单状态为申请，您作为领取方无法进行编辑！');
		  		return false;
		  	}
			$('#editCardIFrame')[0].src= server_context + '/cardStorage/refreshCardOrder?cardStorageBean.id='+cardStorageBean.id;
	        	$('#editCardDialog').dialog({
	        		closed : false,
	                title : '申请修改',
	                shadow : true,
	                modal : true,
	                collapsible : true,
	                buttons : [{
	                	text : '保存',
	                    iconCls : 'icon-save',
	                    id : 'sBtn',
	                    handler:function() {
	                    	saveTotalInformation();
	                    	updateTable();
	                    }
	                }, {
	                    text : '取消',
	                    id : 'cBtn',
	                    handler : function() {
	                    	updateTable();
	                    	document.getElementById("editCardIFrame").contentWindow.document.getElementById('cardListModify-form').reset();
	                        $('#editCardDialog').dialog('close');
	                    }
	                } ]
	        });
	  }
  });
});		
	function validateCardValue(rDocument){
		var cardSum = rDocument.getElementById('cardSum');
		
		var supplier = rDocument.getElementById('supplier');
		
		if(check(cardSum)){
			alert("数量不能为空！");
			return false;
		}
		if(check(supplier)){
			alert("供货方不能为空！");
			return false;
		}
		rDocument.getElementById("receiptType").disabled = false;
		if(rDocument.getElementById("receiptType").value=='1'){
			if(rDocument.getElementById('receiptStatusBefore').value=='1'){
				if(rDocument.getElementById('receiver').value == rDocument.getElementById('stationNum').value){
					if(rDocument.getElementById('receiptStatus').value=='2' && rDocument.getElementById('receiptStatus').value=='3'){
						$.messager.alert('错误','您作为领取方不能将单据状态从申请改为已入库或已出库！');
						return false;
					}
						
				}
				if(rDocument.getElementById('supplier').value == rDocument.getElementById('stationNum').value){
					if(rDocument.getElementById('receiptStatus').value!='3'){
						$.messager.alert('错误','您作为供货方不能将单据状态从申请改为除已出库外的其他状态！');
						return false;
					}
				}
			}
			if(rDocument.getElementById('receiptStatusBefore').value=='3'){
				if(rDocument.getElementById('receiver').value == rDocument.getElementById('stationNum').value){
					if(rDocument.getElementById('receiptStatus').value!='2'){
						$.messager.alert('错误','您作为领取方不能将单据状态从已出库改为除已入库外的其他状态！');
						return false;
					}
				}
				if(rDocument.getElementById('supplier').value == rDocument.getElementById('stationNum').value){
					if(rDocument.getElementById('receiptStatus').value!='3'){
						$.messager.alert('错误','您作为供货方不能修改当前单据状态！');
						return false;
					}
				}
			}
		}
		else if(rDocument.getElementById("receiptType").value=='4'){
			if(rDocument.getElementById('receiptStatusBefore').value=='1'){
				if(rDocument.getElementById('supplier').value == rDocument.getElementById('stationNum').value){
					if(rDocument.getElementById('receiptStatus').value=='2' ){
						$.messager.alert('错误','您作为供货方不能将单据状态从申请改为已入库！');
						return false;
					}
				}
			}
			if(rDocument.getElementById('receiptStatusBefore').value=='3'){
				if(rDocument.getElementById('receiver').value == rDocument.getElementById('stationNum').value){
					if(rDocument.getElementById('receiptStatus').value!='2'){
						$.messager.alert('错误','您作为领取方不能将单据状态从已出库改为除已入库外的其他状态！');
						return false;
					}
				}
			}
		}
		if(rDocument.getElementById("receiptStatus").value=='3'){
			if(document.getElementById("editCardIFrame").contentWindow.window.$("#datepicker2").datebox('getValue')==""){
				$.messager.alert('错误','当前单据状态为已出库，出库日期不能为空！');
				return false;
			}
			if(document.getElementById("editCardIFrame").contentWindow.window.$("#datepicker3").datebox('getValue')!=""){
				$.messager.alert('错误','当前单据状态为已出库，不能填写入库日期！');
				return false;
			}
			
		}
		if(rDocument.getElementById("receiptStatus").value=='1'){
			if(document.getElementById("editCardIFrame").contentWindow.window.$("#datepicker2").datebox('getValue')!=''){
				$.messager.alert('错误','当前单据状态为申请，不能填写出库日期！');
				return false;
			}
			if(document.getElementById("editCardIFrame").contentWindow.window.$("#datepicker3").datebox('getValue')!=''){
				$.messager.alert('错误','当前单据状态为申请，不能填写入库日期！');
				return false;
			}
		}
		if(rDocument.getElementById("receiptStatus").value=='2'){
			if(document.getElementById("editCardIFrame").contentWindow.window.$("#datepicker2").datebox('getValue')==''){
				$.messager.alert('错误','当前单据状态为已入库，出库日期不能为空！');
				return false;
			}
			if(document.getElementById("editCardIFrame").contentWindow.window.$("#datepicker3").datebox('getValue')==''){
				$.messager.alert('错误','当前单据状态为已入库，入库日期不能为空！');
				return false;
			}
		}
		return true;
	}

function checkCardSum(){
	if(document.getElementById("editCardIFrame").contentWindow.window.$("#receiptStatus").val()=="3" && document.getElementById("editCardIFrame").contentWindow.window.$("#receiptStatusBefore").val()=="1"){
		var row =document.getElementById("editCardIFrame").contentWindow.window.$("#tt").datagrid('getRows');
		for ( var i = 0; i < row.length; i++) {
			 document.getElementById("editCardIFrame").contentWindow.window.$("#tt").datagrid('endEdit', i);
		}
		var totalLen = row.length;
		if(totalLen > 0){
			if(row[totalLen-1].startNo == '' || row[totalLen-1].endNo == ''){
				$.messager.alert('错误','起始号和结束号必须填写，若为多余行，请删除后再提交！');
				return false;
			}
			if(row[totalLen-1].startNo.length != 20 || row[totalLen-1].endNo.length != 20){
				$.messager.alert('错误','卡号必须20位！');
				return false;
			}
//			var startStr = row[totalLen-1].startNo.substring(11,20);
//			var stacount=0;
//			while(stacount<9 ){
//				if(startStr.charAt(stacount)=='0'){
//					stacount++;
//				}
//				else{
//					break;
//				}
//			}
//			var endStr = row[totalLen-1].endNo.substring(11,20);
//			var endcount=0;
//			while(endcount<9 ){
//				if(endStr.charAt(endcount)=='0'){
//					endcount++;
//				}
//				else{
//					break;
//				}
//			}
//			var staNumber = parseInt(startStr.substring(stacount));
//			var edNumber = parseInt(endStr.substring(endcount));
//			var cardAmount = parseInt(edNumber-staNumber)+ 1;
			var cardAmount = calculateCardSum(row,totalLen-1);
			document.getElementById("editCardIFrame").contentWindow.window.$('#tt').datagrid('updateRow',{index:totalLen-1,row:{startNo:row[totalLen-1].startNo,endNo:row[totalLen-1].endNo,cardSum:cardAmount,note:row[totalLen-1].note}});
			for ( var i = 0; i < row.length; i++) {
				 document.getElementById("editCardIFrame").contentWindow.window.$("#tt").datagrid('endEdit', i);
			}
		}
		
		var sum = 0;
		for(var i=0; i<row.length; i++){
//			var startString = row[i].startNo.substring(11,20);
//			var count=0;
//			while(count<9 ){
//				if(startString.charAt(count)=='0'){
//					count++;
//				}
//				else{
//					break;
//				}
//			}
//			var endString = row[i].endNo.substring(11,20);
//			var zeorcount=0;
//			while(zeorcount<9){
//				if(endString.charAt(zeorcount)=='0'){
//					zeorcount++;
//				}
//				else{
//					break;
//				}
//			} 
//			var startNumber = parseInt(startString.substring(count));
//			var endNumber = parseInt(endString.substring(zeorcount));
			var cardAcount = calculateCardSum(row,i);
			if(cardAcount>=0){
				sum += cardAcount;
			}
			else{
				$.messager.alert('错误','结束号不能小于起始号！');
				return false;
			}
		}
		if(sum != document.getElementById("editCardIFrame").contentWindow.window.$("#cardSum").val()){
			$.messager.alert('错误','输入的总数量与总数量不符，请重新输入！');
			return false;
		}
	}
	return true;
};
function calculateCardSum(row,index){
	var startStr = row[index].startNo.substring(11,20);
	var stacount=0;
	while(stacount<9 ){
		if(startStr.charAt(stacount)=='0'){
			stacount++;
		}
		else{
			break;
		}
	}
	var endStr = row[index].endNo.substring(11,20);
	var endcount=0;
	while(endcount<9 ){
		if(endStr.charAt(endcount)=='0'){
			endcount++;
		}
		else{
			break;
		}
	}
	var staNumber = parseInt(startStr.substring(stacount));
	var edNumber = parseInt(endStr.substring(endcount));
	var cardAmount = parseInt(edNumber-staNumber)+ 1;
	return cardAmount;
}
function savetable(cardDetail){
		$.ajax({
			type : 'post',
			url : server_context+"/cardStorageDetail/saveCardDetailOrder",
			data : {
				"cardStorageDetailBean.cardDetail" : cardDetail.join('\n')
				},
			success:function(data){
				$.messager.alert('成功','保存卡片详细信息成功!');
				$('#editCardDialog').dialog('close');
				updateTable();
			},
			error:function(){
				$.messager.alert('错误','保存失败，请重试!');
			},
			onBeforeClose:function(){
	        	updateTable();
	        }
		});
	
}
	
function saveTotalInformation(){
	var rDocument = document.getElementById("editCardIFrame").contentWindow.document;
	var flag = validateCardValue(rDocument);
	var cardSumFlag = checkCardSum();
	var addEmplform = rDocument.getElementsByTagName('form');
	if(flag && cardSumFlag){
		var row =document.getElementById("editCardIFrame").contentWindow.window.$("#tt").datagrid('getRows');
		 for ( var i = 0; i < row.length; i++) {
			 document.getElementById("editCardIFrame").contentWindow.window.$("#tt").datagrid('endEdit', i);
		}

		var cardDetail = [];
		
		for(var i=0; i<row.length; i++){
		    cardDetail.push(row[i].startNo + ":" + row[i].endNo + ":" + row[i].note + ";");
		}
		rDocument.getElementById("cardCategory").disabled = false;
		rDocument.getElementById("receiptType").disabled = false;
		rDocument.getElementById("receiptStatus").disabled = false;
		rDocument.getElementById("datepicker2").disabled = false;
		rDocument.getElementById("datepicker3").disabled = false;
		$.ajax({
			data:$(addEmplform).serialize(),
			url:encodeURI(server_context+"/cardStorage/saveCardOrder"),type:'POST',timeout:0,dataType:'html',
			success:function(data){
				if(rDocument.getElementById('receiptStatus').value=='3'){
					savetable(cardDetail);
				}
				else{
					$.messager.alert('成功','保存卡片详细信息成功!');
					$('#editCardDialog').dialog('close');
					updateTable();
				}
				
			},
			error:function(){
				$.messager.alert('错误','请重试!');
			},
			onBeforeClose:function(){
            	updateTable();
            }
		});
		
		
	}
}
