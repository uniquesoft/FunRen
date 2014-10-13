//include in displayRegisterCustomer.jsp
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
		columns : registerCustomercolumns,
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

$(document).ready(function() {
		// 查询已售卡一览
		$("#search_button").click(function(){
			var cardNo = $("#cardNo").val();
			var guestName = $("#guestName").val();
			var cardExno = $("#cardExno").val();
			var cardType = $("#cardType").val();
			var guestType = $("#guestType").val();
			var guestNum = $("#guestNum").val();
			if (cardNo == '' && guestName == '' && cardExno == ''
				&& cardType == '' && guestType == ''&& guestNum == '') {
					$.messager.alert('错误', '至少填一项!');
					return;
				}
			//$.ajax拼接url的异步请求
			searchData();
		});
});

function searchData(pageNumber, pageSize) {
	var yz = $.ajax({
		type : 'post',
		url : server_context+'/registCustomer/showCustomerList',
		data : {
			"registerCustomerBean.cardNo" : $("#cardNo").val(),
			"registerCustomerBean.guestName" : $("#guestName").val(),
			"registerCustomerBean.cardExno" : $("#cardExno").val(),
			"registerCustomerBean.cardType" : $("#cardType").val(),
			"registerCustomerBean.guestType" : $("#guestType").val(),
			"registerCustomerBean.guestNum" : $("#guestNum").val(),
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
			}
			var data = $.parseJSON(gridData);
			$('#dg').datagrid('loadData', data);
		},
		error : function() {
			$.messager.alert('错误', '查询失败!');
		}
	});
}
//已售卡一览列
// 结合具体的RegisterCustomerBean.java
var registerCustomercolumns = [ [
        {field : 'guestNo',title : '客户编号',width : 80,align : 'left'},
	    {field : 'guestName',title : '客户姓名',width : 80,align : 'left'}, 
		{field : 'cardNo',title : '卡号',width : 180,align : 'left'}, 
		{field : 'cardType',title : '卡类型',width : 80,formatter: function(value,row,index){
			var key = "option[value='" + value + "']";
			var text = $("#cardType").find(key).text();
			return text;
		},align : 'left'}, 
		{field : 'cardStatus',title : '卡状态',width : 60,formatter: function(value,row,index){
			var key = "option[value='" + value + "']";
			var text = $("#cardStatus").find(key).text();
			return text;
		},align : 'left'},
		{field : 'guestType',title : '证件类型',width : 100,formatter: function(value,row,index){
			var key = "option[value='" + value + "']";
			var text = $("#guestType").find(key).text();
			return text;
		},align : 'left'},
		{field : 'guestNum',title : '证件号',width : 160,align : 'left'},
		{field : 'guestTel',title : '联系人电话',width : 100,align : 'left'},
		{field : 'create_date',title : '创建日期',width : 100,align : 'left'}, 
		{field : 'stationNo',title : '网点号',width : 80,align : 'left'}
	] ];