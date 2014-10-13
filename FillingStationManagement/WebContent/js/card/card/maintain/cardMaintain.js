//此JS用于卡片维护的查询操作
var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var basePath = localObj.protocol + "//" + localObj.host + "/" + contextPath;
var server_context = basePath;
$(function(){
   $('#card_dg').datagrid({
    iconCls:'icon-ok',
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
    columns:cardMaintaincolumns,
    pagination:true,
    rownumbers:true,
    AllowPaging:true
   });
   
//   设置分页控件  
	var p = $('#card_dg').datagrid('getPager');
	$(p).pagination({
		 onSelectPage:function(pageNumber,pageSize){  
		 	searchData(pageNumber, pageSize);
		 }  
	});
   
   $(p).pagination({  
       pageSize: 20,//每页显示的记录条数，默认为10  
       pageList: [20],//可以设置每页记录条数的列表  
       beforePageText: '第',//页数文本框前显示的汉字  
       afterPageText: '页    共 {pages} 页',  
       displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
   }); 
  });

$(document).ready(function(){
	//读卡接口
	  $("#cardMaintain_readCard").click(function(){
		  $.messager.alert("读卡","读卡");
	  });
	  $("#cardMaintain_search").click(function(){
			var cardno=$("#cardNo").val();
			 var guestName=$("#guestName").val();
			 var guestNo=$("#guestNo").val();
			 var guestType=$("#guestType").val(); 
			 var guestNum=$("#guestNum").val();
			 if(cardno=='' && guestNo=='' && guestName==''){
				if(guestType=='' && guestNum==''){
					$.messager.alert("错误",'卡号或者客户编号或者客户名称必填一项!');
					return false;
				}
				else if(guestType=='' || guestNum==''){
					$.messager.alert("错误",'证件类型和证件号必须都填!');
					return false;
				}
			 }
			searchData();
	  });
	  $("#cardMaintain_clickclear").click(function(){
		  document.getElementById("form1").reset();
	  });
	});
	  
	function searchData(pageNumber, pageSize){
		/*if($("#cardNo").val()=='' && $("#guestName").val()=='' && $("#guestNo").val()=='' && $("#guestType").val()=='' && $("#guestNum").val()=='')
			return ;*/
		var yz = $.ajax({
			type : 'post',
			url : server_context+'/cardMaintain/showCardMaintainList',
			data : {
				"cardMaintainBean.cardNo" : $("#cardNo").val(),
				"cardMaintainBean.guestName" : $("#guestName").val(),
				"cardMaintainBean.guestNo" : $("#guestNo").val(),
				"cardMaintainBean.guestType" :$("#guestType").val(),
				"cardMaintainBean.guestNum" :$("#guestNum").val(),
				"cardMaintainBean.pageNumber" : pageNumber,
				"cardMaintainBean.pageSize" : pageSize
				},
			cache : false,
			dataType : 'json',
			success : function(loaddata) {
				gridData = loaddata.jsonData;
				if(gridData == null){
					$('#card_dg').datagrid('loadData',{total:0,rows:[]});
				}
				var data = $.parseJSON(gridData);    
				$('#card_dg').datagrid('loadData', data);
			},
			error : function() {
			}
		});
	}
	
//检索一览列
var cardMaintaincolumns = [[
                {field:'guestName',title:'客户名称',width:100, align:'center'}, 
        		{field:'guestNo',title:'客户编号',width:80, align:'center'},
        		{field:'cardNo',title:'卡号',width:150, align:'center'},
        		{field:'guestType',title:'证件类型',width:120, formatter: function(value,row,index){
        			var key= "option[value='" + value + "']";
        			var text = $("#guestType").find(key).text();
        			return text;
        		},align:'center'},
        		{field:'guestNum',title:'证件号',width:150, align:'center'},
        		{field:'disEffectiveDate',title:'有效期',width:140, align:'center'},
        		{field:'cardType',title:'卡类型',width:100, formatter: function(value,row,index){
          			var key = "option[value='" + value + "']";
          			var text = $("#cardType").find(key).text();
          			return text;
    			},align:'center'},
        		{field:'cardStatus',title:'卡状态',width:100,formatter: function(value,row,index){
        			var key = "option[value='" + value + "']";
        			var text = $("#cardStatus").find(key).text();
        			return text;
        		}, align:'center'}
            ]];