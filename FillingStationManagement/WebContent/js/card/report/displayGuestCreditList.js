/**
 * this js works for displayGuestCreditList.jsp
 */
var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
var server_context=basePath;
$(function(){
   $('#guestCreditListTable').datagrid({
    iconCls:'icon-ok',
//    width:'auto',
//    height:'300',
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
    columns:guestCreditListcolumns,
    pagination:true,
    rownumbers:true,
    AllowPaging:true
   });
// 设置分页控件  
	var p = $('#guestCreditListTable').datagrid('getPager');
	$(p).pagination({
		 onSelectPage:function(pageNumber,pageSize){  
			 searchGuestPaymentDetail(pageNumber, pageSize);
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
	$('#guestCredit_search').click(function(){
		var guestName=$("#guestName").val();
		var guestNo=$("#guestNo").val();
		var cardNo=$("#cardNo").val();
		var payType=$("#payType").val();
		var tradeType=$("#tradeType").val();
		var startdate=$("#datepicker1").datebox('getValue');
		var enddate=$("#datepicker2").datebox('getValue');
		if(guestName=='' && guestNo=='' && cardNo=='' && payType=='' && tradeType=='' && startdate=='' && enddate=='' ){
			$.messager.alert('错误','至少填一项!');
			return;
		}
//		if(guestNo=='' && cardNo==''){
//			$.messager.alert('错误','客户编号和卡号至少填一项!');
//			return;
//		}
		searchGuestPaymentDetail();	
		
	});
});
function searchGuestPaymentDetail(pageNumber, pageSize){
	var yz = $.ajax({
		type : 'post',
		url : server_context + '/cardTradeReport/showGuestPaymentRecords',
		data : {
			"cardTradeReportBean.guestName" : $("#guestName").val(),
			"cardTradeReportBean.guestNo" : $("#guestNo").val(),
			"cardTradeReportBean.cardNo" : $("#cardNo").val(),
			"cardTradeReportBean.payType" : $("#payType").val(),
			"cardTradeReportBean.tradeType" : $("#tradeType").val(),
			"cardTradeReportBean.startDate" : $("#datepicker1").datebox('getValue'),
			"cardTradeReportBean.endDate" : $("#datepicker2").datebox('getValue'),
			"cardTradeReportBean.pageNumber" : pageNumber,
			"cardTradeReportBean.pageSize" : pageSize
			},
		cache : false,
		dataType : 'json',
		success : function(loaddata) {
			gridData = loaddata.jsonData;
			if(gridData == null){
				$('#guestCreditListTable').datagrid('loadData',{total:0,rows:[]});
			}
			var data = $.parseJSON(gridData);    
			$('#guestCreditListTable').datagrid('loadData', data);
		},
		error : function() {
		}
	});
}
var guestCreditListcolumns = [[ 
            			{field:'tradeDate',title:'交易日期',width:150,align:'left'},
            			{field:'incNo',title:'交易号',width:100,align:'left'},
            			{field:'guestName',title:'客户名称',width:100,align:'left'},
            			{field:'cardNo',title:'卡号',width:150,align:'left'},
            			{field:'cardStatus',title:'卡状态',width:60,formatter: function(value,row,index){
                  			var key = "option[value='" + value + "']";
                  			var text = $("#cardStatus").find(key).text();
                  			return text;
            			},align:'left'},
            			{field:'moneyBefore',title:'交易前金额',width:100,align:'left'},
            			{field:'tradeMoney',title:'交易额',width:100,align:'left'},
            			{field:'moneyAfter',title:'交易后余额',width:100,align:'left'},
            			{field:'tradeType',title:'交易类型',width:60,formatter: function(value,row,index){
                  			var key = "option[value='" + value + "']";
                  			var text = $("#tradeType").find(key).text();
                  			return text;
            			},align:'left'},
            			{field:'payType',title:'支付类型',width:60,formatter: function(value,row,index){
                  			var key = "option[value='" + value + "']";
                  			var text = $("#payType").find(key).text();
                  			return text;
            			},align:'left'},
            			{field:'userId',title:'操作员编号',width:80,align:'left'}
                       ]];