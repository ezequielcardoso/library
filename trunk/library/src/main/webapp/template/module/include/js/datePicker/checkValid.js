
/**
*创建人：张宇清
*创建时间：2009-12-28
*作用：检验表单数据
*/



/**
 * 检查 obj 是否有输入值
 * obj 被检查的对象
 * message obj 的中文意思，用于提示
 */
function existString(obj, message)
{
	if (obj.value == null || obj.value.length < 1)
	{
		alert('请输入' + message + '。');  // 请输入：。
		obj.select();
		return false;
	}
		
	return true;
}

/**
 * 检查 obj 有没有超过最长长度
 * obj 被检查的对象
 * message obj 的中文意思，用于提示
 * maxLength 最长长度
 */
function maxLength(obj, message, maxLength)
{
	if (obj.value == null) {
		return true;
	}	
	if (obj.value.length > maxLength){
	  alert(message + '超过最大长度' + maxLength + '，请重新输入。');
		obj.select();
		return false;
	}
	return true;
}

/**
 * 检查 obj 是否有输入值，有没有超过最长长度
 * obj 被检查的对象
 * message obj 的中文意思，用于提示
 * maxLength 最长长度
 */
function maxStringLength(obj, message, maxLength)
{
  if (obj.value == null || obj.value.length < 1){
		alert('请输入' + message + '。');  // 请输入：。
		obj.select();
		return false;
	}	
	if (obj.value.replace(/[^\x00-\xff]/g, "**").length > maxLength){
	  	alert(message + '超过最大长度' + maxLength + '，请重新输入。');
		obj.select();
		return false;
	}
	return true;
}

/**
 * 检查 obj 是否有输入值，有没有超过最长长度
 * obj 被检查的对象
 * message obj 的中文意思，用于提示
 * maxLength 最长长度
 */
function maxLength(obj, message, maxLength)
{
	if (obj.value == null || obj.value.length < 1)
	{
		return true;
	}	
	if (obj.value.length > maxLength){
	  	alert(message + '超过最大长度' + maxLength + '，请重新输入。');
		obj.select();
		return false;
	}
	return true;
}

/**
 * 检查 obj 是否有输入值，是否足够最短长度，有没有超过最长长度
 * obj 被检查的对象
 * message obj 的中文意思，用于提示
 * minLength 最短长度
 * maxLength 最长长度
 */
function existStringLength(obj, message, minLength, maxLength)
{
	if (obj.value == null || obj.value.length < 1)
	{
		alert('\u8bf7\u8f93\u5165\uff1a' + message + '\u3002');  // 请输入：。
		obj.select();
		return false;
	}	
	if (obj.value.length < minLength){
	  alert(message + '不足最小长度' + minLength + '，请重新输入。'); 
		obj.select();
		return false;
	}
	if (obj.value.length > maxLength){
	  alert(message + '超过最大长度' + maxLength + '，请重新输入。');
		obj.select();
		return false;
	}
	return true;
}
/**
 * 检查 obj 是否有选择
 * obj 被检查的对象
 * falseValue 失败时的值
 * message obj 的中文意思，用于提示
 */
function checkSelect(obj, flaseValue, message)
{
	if (obj.value == flaseValue)
	{
		alert('请选择：' + message + '。');
		obj.focus();
		return false;
	}
	
	return true;
}

/**
 * 检查 obj 是否有选择(特指radio单选框)
 * obj 被检查的对象
 * message obj 的中文意思，用于提示
 */
function checkRadioSelect(obj,  message)
{
	flag=0;
	for(i=0;i<obj.length;i++){
		if(obj[i].checked){
		    flag=1;
		}
	}
	if(flag==0){
		alert("请选择"+message);
		return false;
	}
	return true;

}
/**
 * 检查 obj 是否是字符和数字
 * obj 被检查的对象
 * name obj 的中文意思，用于提示
 */
function checkCharAndNum(obj, name)
{
	var str = obj.value;
	var re = '[^a-zA-Z0-9]{1,}';
	var r = str.match(re);	
	//alert("r = " + r + " , " + str);
	if (r!=null)
	{
		alert(name + '只接受字母a-z A-Z 和数字 0-9，不能包含其它字符。');
		obj.focus();
		obj.select();
		return false;
	}
	return true;
}
/**
 * 检查 obj 是否是 EMAIL 地址
 * obj 被检查的对象
 * name obj 的中文意思，用于提示
 * isMust表示Email地址是否可以为空,如果是0为可以为空，如果是1为不能为空
 */
function checkEMail(obj, name, isMust)
{
	var str = obj.value;
	if (str == null)
	  str = "";
	  
	if (isMust == 1){
		if (str.length < 1){
		  alert('请输入' + name + '。');  // 请输入：。
			obj.select();
			return false;
		}
	  }
	if (str.length > 0){
		var r1 = str.match('\\.+');	
		var r2 = str.match('\\@+');	
		if (r1 != null && r2 != null)
		{
		  return true;
		}
		else
		{
			alert(name + ' Email地址必须包括 . 和 @。');
			obj.focus();
			obj.select();
			return false;
		}
		}
	return true;
}
/**
 * 检查 obj 是否是电话号码
 * obj 被检查的对象
 * name obj 的中文意思，用于提示
 */
function checkTel(obj, name)
{
	var str = obj.value;
	var re = '[^0-9-]{1,}';
	var r = str.match(re);	
	if (r!=null)
	{
		alert(name + '只接受数字 0-9 和 -，不能包含其它字符。');
		obj.focus();
		obj.select();
		return false;
	}
	return true;
}
/**
 * 检查 obj 是否是数字
 * obj 被检查的对象
 * name obj 的中文意思，用于提示
 */
function checkNum(obj, name)
{
	var str = obj.value;
	if (str == null || str.length < 1){
	  return true;
	}
	var re = '^(-{0,1}|\\+{0,1})[0-9]+(\\.{0,1}[0-9]*)$';
	var r = str.match(re);	
	if (r==null)
	{
		alert(name + ' 请输入有效的数字，只接受数字 0-9 和 + - . ，不能包含其它字符。');
		obj.focus();
		obj.select();
		return false;
	}
	return true;
}
/**
 * 检查 obj 是否是数字,
 * obj 被检查的对象
 * name obj 的中文意思，用于提示
 */
function checkNumber(obj, name)
{
	if (obj.value == null) {
		return true;
	}
	var str = obj.value;
	var re = '[^0-9.]{1,}';
	var r = str.match(re);	
	if (r!=null)
	{
		alert(name + '只接受数字 0-9 ，不能包含其它字符。');
		obj.focus();
		obj.select();
		return false;
	}
	return true;
}

/**
 * 将数字格式化成小数点后两位（调用本方法前请保证 pObj 是数值）
 * pObj 被格式化的对象
 */
function changeToFloat(pObj)
{
	var temp = trim(pObj.value); 
	var temp1 = "";
	var temp2 = "";
	if (!isEmpty(temp)){
		if(temp.indexOf("-")==0) {
			temp = temp.substring(1);
			temp1 = "-";
		}
	  temp = ""+Math.round(temp*100);
	  temp2 = temp.substring(0,temp.length-2);
	  if(temp2 ==null || temp2==""){
	   	if(temp.length==1){
	   		temp = "0.0" + temp.substring(temp.length-2);
	    }
	   	else{
	   	  temp = "0."+temp.substring(temp.length-2);
	   	}
	  }
	  else{
	    temp = temp2+"."+temp.substring(temp.length-2);
	  }
	  pObj.value = temp1+temp; 
  }   
}

/**
 * 去空格
 * pObj 被格式化的对象
 */
function trim(data)
{
 	return data.replace(/(^\s*)|(\s*$)/g, "");
}

// Function Description: 返回字符串的实际长度, 一个汉字算2个长度
String.prototype.len=function()
{
	var str=this;
	return str.replace(/[^\x00-\xff]/g, "**").length
}