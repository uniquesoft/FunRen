//include in departmentMaintain.jsp
$(function() {
	$('#dg').datagrid({
		iconCls : 'icon-ok',
		width:'auto',
		height:'auto',
		nowrap : false,
		striped : true,
		fit : true,// 自动大小
		collapsible : true,
		singleSelect : true,
		loadMsg : '数据装载中......',
		sortName : 'code',
		sortOrder : 'desc',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		columns : departmentcolumns,
		pagination : true,
		rownumbers : true,
		AllowPaging : true
	});

	// 设置分页控件
	var p = $('#dg').datagrid('getPager');
	$(p).pagination({
		onSelectPage : function(pageNumber, pageSize) {
			searchData(pageNumber, pageSize);
		}
	});

	$(p).pagination({
		pageSize : 20,// 每页显示的记录条数，默认为10
		pageList : [ 20 ],// 可以设置每页记录条数的列表
		beforePageText : '第',// 页数文本框前显示的汉字
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});
});

$(document).ready(function(){
	$("#searchDepartment").click(function(){
				//alert("查询部门");
				var guestName = $("#guestName").val();
				var guestNo = $("#guestNo").val();
				var cardNo = $("#cardNo").val();
				if (guestName =='' && guestNo =='' && cardNo =='') {
				$.messager.alert('错误', '查询条件不能全为空!');
				return;
			}
				// 3.$.ajax拼接url的异步请求
				searchData();
			});
	$("#returnBack").click(function(){
		window.location.href=basePath+"/registMultiCustomer/registMultiCustomerInit";
	});
});

function searchData(pageNumber, pageSize) {
	var yz = $.ajax({
		type : 'post',
		url :server_context+"/registMultiCustomer/showDepartmentList",
		data : {
			"registerCustomerBean.guestName" : $("#guestName").val(),
			"registerCustomerBean.guestNo" : $("#guestNo").val(),
			"registerCustomerBean.cardNo" : $("#cardNo").val(),
			"registerCustomerBean.pageNumber" : pageNumber,
			"registerCustomerBean.pageSize" : pageSize
		},
		cache : false,
		dataType : 'json',
		success : function(loaddata) {
			gridData = loaddata.jsonData;
			if (gridData == null) {
				$('#dg').datagrid('loadData', {
					total : 0,
					rows : []
				});
				alert("没有找到对应的记录");
			}
			var data = $.parseJSON(gridData);
			$('#dg').datagrid('loadData', data);
		},
		error : function() {
			alert("数据传输失败");
		}
	});
}

//检索一览列合具体的RegisterCustomerBean.java看，
var departmentcolumns = [ [
        {field : 'guestNo',title : '客户编号',width : 160,align : 'left'},
        {field : 'guestName',title : '单位名称',width : 160,align : 'left'},
		{field : 'deptNo',title : '部门编号',width : 160,align : 'left'},
		{field : 'depName',title : '部门名称',width : 160,align : 'left'},
		{field : 'depMaster',title : '部门联系人',width : 180,align : 'left'},
		{field : 'depTel',title : '部门电话',width : 200,align : 'left'}
	] ];