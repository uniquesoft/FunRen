/**
 * this js works to display invoice detail
 */

var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
var server_context=basePath;
$(function(){
	   $('#InvoiceListTable').datagrid({
	    iconCls:'icon-ok',
//	    width:'auto',
//	    height:'300',
	    nowrap:false,
	    striped: true,
	    fit: true,//自动大小 
	    collapsible:true,
	    singleSelect:true,
	    loadMsg:'数据装载中......',
	    sortName:'code',
	    sortOrder:'desc',
	    remoteSort:false,
	    frozenColumns:[[
	     {field:'ck',checkbox:true}
	    ]],
	    columns:invoiceListcolumns,
	    pagination:true,
	    rownumbers:true,
	    AllowPaging:true
	   });
	// 设置分页控件  
		var pager = $('#InvoiceListTable').datagrid('getPager');
		$(pager).pagination({
			 onSelectPage:function(pageNumber,pageSize){ 
			 	searchInvoice(pageNumber, pageSize);
			 }  
		});
	  
	  $(pager).pagination({  
	      pageSize: 20,//每页显示的记录条数，默认为10  
	      pageList: [20],//可以设置每页记录条数的列表  
	      beforePageText: '第',//页数文本框前显示的汉字  
	      afterPageText: '页    共 {pages} 页',  
	      displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	  }); 
});
$(document).ready(function(){
	$("#invoice_detail").click(function() {
		var classChangeBean = $('#shiftChangeListTable').datagrid('getSelected');
		if (!classChangeBean){
			 $.messager.alert('错误','请选择记录!');
		}
		else{
			var pageSize=$('#InvoiceListTable').datagrid('getPager').data("pagination").options.pageSize;
			var pageNumber=$('#InvoiceListTable').datagrid('getPager').data("pagination").options.pageNumber;
			var yz = $.ajax({
				type : 'post',
				url : server_context + '/classChange/showInvoiceRecords',
				data : {
					"classChangeBean.classNo" : classChangeBean.classNo,
					"classChangeBean.pageNumber" : pageNumber,
					"classChangeBean.pageSize" : pageSize
					},
				cache : false,
				dataType : 'json',
				success : function(loaddata) {
					gridData = loaddata.jsonData;
					if(gridData == null){
						$('#InvoiceListTable').datagrid('loadData',{total:0,rows:[]});
					}
					var data = $.parseJSON(gridData);    
					$('#InvoiceListTable').datagrid('loadData', data);
				},
				error : function() {
				}
			});	   
			
			$('#InvoiceDetailDialog').window({
	    		closed : false,
	            title : '发票明细',
	            shadow : true,
	            modal : true,
	            collapsible : true,
	            buttons : [{
	                text : '取消',
	                id : 'cBtn',
	                handler : function() {
	                    $('#InvoiceDetailDialog').window('close');
	                }
	            } ]
			});
		}
	});
});

function searchInvoice(pageNumber, pageSize){
	var classChangeBean = $('#shiftChangeListTable').datagrid('getSelected');
	var yz = $.ajax({
		type : 'post',
		url : server_context + '/classChange/showInvoiceRecords',
		data : {
			"classChangeBean.classNo" : classChangeBean.classNo,
			"classChangeBean.pageNumber" : pageNumber,
			"classChangeBean.pageSize" : pageSize
			},
		cache : false,
		dataType : 'json',
		success : function(loaddata) {
			gridData = loaddata.jsonData;
			if(gridData == null){
				$('#InvoiceListTable').datagrid('loadData',{total:0,rows:[]});
			}
			var data = $.parseJSON(gridData);    
			$('#InvoiceListTable').datagrid('loadData', data);
		},
		error : function() {
		}
	});	   
};

var invoiceListcolumns = [[ 
   							{field:'invoiceCode',title:'发票代码',width:100,align:'left'},
                      			{field:'startCode',title:'起始号',width:70,align:'left'},
                      			{field:'endCode',title:'结束号',width:70,align:'left'},
                      			{field:'invoiceNo',title:'发票号',width:100,align:'left'},
                      			{field:'invoiceSum',title:'发票总数',width:70,align:'left'},
                      			{field:'invoiceMoney',title:'开票金额',width:70,align:'left'},
                      			{field:'invoiceAmount',title:'开票总数',width:70,align:'left'},
                      			{field:'workDate',title:'业务日期',width:90,align:'left'}
                                 ]];