$(document).ready(function(){
	$("#cardMaintain_searchfor").click(function(){
		 var cardno=document.getElementById("cardNo").value;
		 var guestTel=document.getElementById("guestTel").value;
		 var guestType=document.getElementById("guestType").value;
		 var guestNum=document.getElementById("guestNum").value;
		 var guestName=document.getElementById("guestName").value;
		 if(cardno=='' && guestTel=='' && guestName=='' ){
				if(guestType=='' && guestNum==''){
					$.messager.alert("错误",'卡号或者电话或者客户名称必填一项!');
					return false;
				}
				else if(guestType=='' || guestNum==''){
					$.messager.alert("错误",'证件类型和证件号必须都填!');
					return false;
				}
			 }
	document.myForm.reset();
		if(cardno!='')
		$("#cardNo").val(cardno);
	else if(guestTel!='')
		$("#guestTel").val(guestTel);
	else if(guestName!=''){
		$("#guestName").val(guestName);
	}
	else if(guestType!='' && guestNum!=''){
		$("#guestType").val(guestType);
		$("#guestNum").val(guestNum);
	}
	document.myForm.submit();
	});
	$("#cardMaintain_clear").click(function(){
		document.myForm.reset();
	});
});
