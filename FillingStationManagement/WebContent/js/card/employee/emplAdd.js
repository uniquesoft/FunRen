	var localObj = window.location;
	var contextPath = localObj.pathname.split("/")[1];
	var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
	var server_context=basePath;

	$(document).ready(function(){
		$("#empl_add").click(function() {
		$('#addEmployeeIFrame')[0].src= server_context + '/view/card/employee/employeeAdd.jsp'; 
        	$('#addEmployeeDialog').form('clear');
            $('#addEmployeeDialog').dialog({
                closed : false,
                title : '员工注册',
                shadow : true,
                modal : true,
                collapsible : true,
                buttons : [{
                	text : '保存',
                    iconCls : 'icon-save',
                    id : 'sBtn',
                    handler:function() {
                    	var rDocument = document.getElementById("addEmployeeIFrame").contentWindow.document;
                    	var flag = validateFieldValue(rDocument);
                    	var addEmplform = rDocument.getElementsByTagName('form');
                    	if(flag){
                    		$.ajax({
                    			data:$(addEmplform).serialize(),
                    			url:encodeURI("saveUser"),type:'POST',timeout:3000,dataType:'html',
	                			success:function(data){
	    	        				$("#addEmployeeDialog").dialog("close");
	    	        				$.messager.alert('成功','恭喜你保存成功!');
	    	        			},
	    	        			error:function(){
	    	        				$.messager.alert('错误','保存失败，请重试!');
	    	        			}
	            		});
                    	}
                    }
                }, {
                    text : '取消',
                    id : 'cBtn',
                    handler : function() {
                        $('#addEmployeeDialog').dialog('close');
                    }
                } ]
        });
	
	});
	});

	function validateFieldValue(rDocument){
    	var newName = rDocument.getElementById('emplName');
		var emplPass = rDocument.getElementById('emplPass');
		var shiftType = rDocument.getElementById('shiftType');
		var shiftNum = rDocument.getElementById('emplShiftNum');
		if (check(newName) || check(emplPass) || check(shiftType) || check(shiftNum)){
			return false;
		}else{
			return true;
		}
	}
		
	// 表单验证
	var check = function (input) {
	    if (input.value == '') {
	    	inputError(input);
	        input.focus();
	        return true;
	    } else {
	        return false;
	    };
	};

	// 输入错误提示
	var inputError = function (input) {
	    clearTimeout(inputError.timer);
	    var num = 0;
	    var fn = function () {
	        inputError.timer = setTimeout(function () {
	            input.className = input.className == '' ? 'form-error' : '';
	            if (num == 5) {
	                input.className = '';
		            } else {
		                fn(num ++);
		            };
		        }, 150);
		    };
		    fn();
		};
