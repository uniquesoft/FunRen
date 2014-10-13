/**
 * this js works to show card storage detail
 */

var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
var server_context=basePath;
$(function(){
	   $('#cardAccountListTable').datagrid({
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
	    columns:cardAccountListcolumns,
	    pagination:true,
	    rownumbers:true,
	    AllowPaging:true
	   });
	// 设置分页控件  
		var page = $('#cardAccountListTable').datagrid('getPager');
		$(page).pagination({
			 onSelectPage:function(pageNumber,pageSize){ 
			 	searchCardAccount(pageNumber, pageSize);
			 }  
		});
	  
	  $(page).pagination({  
	      pageSize: 20,//每页显示的记录条数，默认为10  
	      pageList: [20],//可以设置每页记录条数的列表  
	      beforePageText: '第',//页数文本框前显示的汉字  
	      afterPageText: '页    共 {pages} 页',  
	      displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	  }); 
});
$(document).ready(function(){
	$("#cardStorage_detail").click(function() {
		var classChangeBean = $('#shiftChangeListTable').datagrid('getSelected');
		if (!classChangeBean){
			 $.messager.alert('错误','请选择记录!');
		}
		else{
			var pageSize=$('#cardAccountListTable').datagrid('getPager').data("pagination").options.pageSize;
			var pageNumber=$('#cardAccountListTable').datagrid('getPager').data("pagination").options.pageNumber;
			var yz = $.ajax({
				type : 'post',
				url : server_context + '/classChange/showCardStroageRecords',
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
						$('#cardAccountListTable').datagrid('loadData',{total:0,rows:[]});
					}
					var data = $.parseJSON(gridData);    
					$('#cardAccountListTable').datagrid('loadData', data);
				},
				error : function() {
				}
			});	   
			
			$('#cardStorageDetailDialog').window({
	    		closed : false,
	            title : '卡片出入库明细',
	            shadow : true,
	            modal : true,
	            collapsible : true,
	            buttons : [{
	                text : '取消',
	                id : 'cBtn',
	                handler : function() {
	                    $('#cardStorageDetailDialog').window('close');
	                }
	            } ]
			});
		}
	});
});

function searchCardAccount(pageNumber, pageSize){
	var classChangeBean = $('#shiftChangeListTable').datagrid('getSelected');
	var yz = $.ajax({
		type : 'post',
		url : server_context + '/classChange/showCardStroageRecords',
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
				$('#cardAccountListTable').datagrid('loadData',{total:0,rows:[]});
			}
			var data = $.parseJSON(gridData);    
			$('#cardAccountListTable').datagrid('loadData', data);
		},
		error : function() {
		}
	});	   
};

var cardAccountListcolumns = [[ 
   							{field:'cardType',title:'卡片类型',width:60,formatter: function(value,row,index){
   									var key = "option[value='" + value + "']";
   									var text = $("#cardType").find(key).text();
   									return text;
   							},align:'left'},
   							{field:'inSum',title:'入库数量',width:60,align:'left'},
                      			{field:'outSum',title:'出库数量',width:60,align:'left'},
                      			{field:'chSum',title:'调整数量',width:60,align:'left'},
                      			{field:'cardSum',title:'库存数量',width:60,align:'left'},
                      			{field:'workDate',title:'业务日期',width:100,align:'left'},
                      			{field:'accDate',title:'入账日期',width:100,align:'left'},
                      			{field:'userId',title:'操作员编号',width:72,align:'left'}
                                 ]];

