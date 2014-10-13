	// 表单验证
	var check = function(input) {
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

		//email验证
		function checkEmail(str){
			 var reg=/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@[_a-z\d\-]+(\.[_a-z\d\-]+)*(\.(info|biz|com|edu|gov|net|am|bz|cn|cx|hk|jp|tw|vc|vn))$/;
			 if(str==null ||str=="")
				 return true;
			 if(reg.test(str))
			  return true;
			 else{
			 $.messager.alert("错误","输入Email格式错误");
			 return false;
			 }
		}
		
		//匹配中国邮政编码(6位)
		function checkPostcode(str)
		{
		if(str==null ||str=="")
			 return true;
		var result=str.match(/^[0-9][0-9]{5}$/);
		if(result==null){
			$.messager.alert("错误","输入邮政编码格式错误");
			return false;
		}
		return true;
		}
		
		//匹配身份证(15位或18位)
		function checkIDCard (str) {
			if(str==null ||str=="")
				 return true;
			isIDCard1=/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;
			isIDCard2=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/;
			if (isIDCard1.test(str)||isIDCard2.test(str))
				return true;
			else{
				$.messager.alert("错误","输入身份证格式错误");
				return false;
			}
		}
		
		//匹配手机号码和电话号码
		function checkPhone (str) {
			if(str==null ||str=="")
				 return true;
			isPhone1=/^0?(13[0-9]|15[012356789]|18[0236789]|14[57])[0-9]{8}$/;
			isPhone2=/^(\d{7,8})(-(\d{3,}))?$/;
			if (isPhone1.test(str)||isPhone2.test(str))
				return true;
			else{
				$.messager.alert("错误","输入号码格式错误");
				return false;
			}
		}
