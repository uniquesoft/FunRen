//include in departmentMaintain.jsp
$(document).ready(function(){
	$("#department_delete").click(function(){
		//alert("删除部门");
		var registerCustomerBean = $('#dg').datagrid('getSelected');
		 if (!registerCustomerBean){
			  $.messager.alert('错误','请选择记录!');
			  return;
		  }
		 //alert(registerCustomerBean.id);
		 var depId = registerCustomerBean.id;
		 if(confirm('确认删除部门?')){
			 deleteDepartment(depId);
		 }
	});
});

function deleteDepartment(depId){
	$.ajax({
		type : 'post',
		url :server_context+"/registMultiCustomer/deleteDepartment",
		data : {
			"registerCustomerBean.id" : depId
		},
		cache : false,
		dataType : 'json',
		success : function(){
			alert("删除成功");
			searchData();
		},
		error : function(){
			alert("删除失败");
		}
	});
}