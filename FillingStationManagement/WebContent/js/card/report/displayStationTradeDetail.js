/**
 * this 
 */
var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
var server_context=basePath;
$(function(){
	   $('#stationTradeListTable').datagrid({
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
	    columns:stationTradeListcolumns,
	    pagination:true,
	    rownumbers:true,
	    AllowPaging:true
	   });
	// 设置分页控件  
		var pg = $('#stationTradeListTable').datagrid('getPager');
		$(pg).pagination({
			 onSelectPage:function(pageNumber,pageSize){  
				 searchStationTrade(pageNumber, pageSize);
			 }  
		});
	  
	  $(pg).pagination({  
	      pageSize: 20,//每页显示的记录条数，默认为10  
	      pageList: [20],//可以设置每页记录条数的列表  
	      beforePageText: '第',//页数文本框前显示的汉字  
	      afterPageText: '页    共 {pages} 页',  
	      displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	  }); 
	  
	 

	 });
$(document).ready(function(){
	$("#stationTrade_detail").click(function() {
		var classChangeBean = $('#shiftChangeListTable').datagrid('getSelected');
		if (!classChangeBean){
			 $.messager.alert('错误','请选择记录!');
		}
		else{
			var pageSize=$('#stationTradeListTable').datagrid('getPager').data("pagination").options.pageSize;
			var pageNumber=$('#stationTradeListTable').datagrid('getPager').data("pagination").options.pageNumber;
			var yz = $.ajax({
				type : 'post',
				url : server_context + '/classChange/showStationTradeRecords',
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
						$('#stationTradeListTable').datagrid('loadData',{total:0,rows:[]});
					}
					var data = $.parseJSON(gridData);    
					$('#stationTradeListTable').datagrid('loadData', data);
				},
				error : function() {
				}
			});	   
			
			$('#stationTradeDetailDialog').window({
	    		closed : false,
	            title : '网点交易明细',
	            shadow : true,
	            modal : true,
	            collapsible : true,
	            buttons : [{
	                text : '取消',
	                id : 'cBtn',
	                handler : function() {
	                    $('#stationTradeDetailDialog').window('close');
	                }
	            } ]
			});
		}
	});
});

function searchStationTrade(pageNumber, pageSize){
	
	var classChangeBean = $('#shiftChangeListTable').datagrid('getSelected');
	var yz = $.ajax({
		type : 'post',
		url : server_context + '/classChange/showStationTradeRecords',
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
				$('#stationTradeListTable').datagrid('loadData',{total:0,rows:[]});
			}
			var data = $.parseJSON(gridData);    
			$('#stationTradeListTable').datagrid('loadData', data);
		},
		error : function() {
		}
	});	   
	
};

var stationTradeListcolumns = [[ 
                            {field:'guestName',title:'客户名称',width:80,align:'left'},
                            {field:'guestNo',title:'客户编号',width:60,align:'left'},
                            {field:'incNo',title:'交易编号',width:70,align:'left'},
   							{field:'tradeType',title:'交易类型',width:50,formatter: function(value,row,index){
   									var key = "option[value='" + value + "']";
   									var text = $("#tradeType").find(key).text();
   									return text;
   							},align:'left'},
   							{field:'payType',title:'支付类型',width:60,formatter: function(value,row,index){
									var key = "option[value='" + value + "']";
									var text = $("#payType").find(key).text();
									return text;
							},align:'left'},
							{field:'moneySum',title:'金额',width:60,align:'left'},
							{field:'workDate',title:'业务日期',width:100,align:'left'},
                  			{field:'accDate',title:'入账日期',width:100,align:'left'}
                            ]];
