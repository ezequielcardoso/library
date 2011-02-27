// Function CheckNumber(FormName,InputName,MaxLength,Flag) can check Input.value format.
// Thereinto:FormName is Form'name;InputName is Input's name;MaxLength is Input's Max lehgth;Flag is sing for Null/No Null. 

function CheckNumber(FormName,InputName,MaxLength,Flag){
		var nText = eval("document." + FormName + "." + InputName + ".value");							
		var nText1 = eval("Number(document." + FormName + "." + InputName + ".value)");		
		if (nText1.toString() =='NaN'){
			alert('请输入数值型内容！');
			eval("document." + FormName + "." + InputName + ".value='';")
			eval("document." + FormName + "." + InputName + ".focus();")
			return false;
		}
		if (Flag ==0 && nText.length==0){
			alert("该字段内容不允许为空！");
			eval("document." + FormName + "." + InputName + ".focus();")
			return false;
		}
		if (nText.indexOf('.') > 0){
			alert("整数不允许有小数点！");
			eval("document." + FormName + "." + InputName + ".focus();")
			return false;
		}
		if (nText.length>MaxLength){
			alert("输入数据长度超出范围！");
			eval("document." + FormName + "." + InputName + ".focus();")
			return false;
		}
		return true;
}
// Function CheckLength(FormName,TextAreaName,MaxLength,Flag) can cortrol length of TextArea'text.
// Thereinto:FormName is Form'name;TextAreaName is TextArea's name;MaxLength is max length of TextArea'text or Input'text;Flag is sing for Null/No Null. 

function CheckLength(FormName,TextAreaName,MaxLength,Flag){
		var TextAreaValue = eval("document." + FormName + "." + TextAreaName + ".value");
		if (Flag ==0 && TextAreaValue.length==0){
			alert("该字段内容不允许为空！");
			eval("document." + FormName + "." + TextAreaName + ".focus();");
			return false;
		}
		if (TextAreaValue.length > MaxLength){
			alert('输入内容长度超限,最多'+MaxLength+'个字符！');
			eval("document." + FormName + "." + TextAreaName + ".focus();");
			return false;
		}
		return true;
}
// Function CheckIDCard(FormName, InputName, MaxLength, Flag) can check anybody'ID,Not only check type of Number,But also length of the Number(15 or 18) 
// Thereinto:FormName is Form'name;InputName is Input's name;MaxLength is max length for Input;Flag is sing for Null/No Null. 

function CheckIDCard(FormName,InputName,MaxLength,Flag){
		if (!CheckNumber(FormName, InputName, MaxLength, Flag)) return false;
		var IDNumber = eval("Number(document." + FormName + "." + InputName + ".value.length)");
		if (Flag ==0 && IDNumber==0){
			alert("该字段内容不允许为空！");
			eval("document." + FormName + "." + InputName + ".focus();");
			return false;
		}
		if ((IDNumber != 0)&&(IDNumber != 15)&&(IDNumber != 18)){
			alert("输入的身份证号码长度错！");
			eval("document." + FormName + "." + InputName + ".focus();");
			return false;
		}
		return true;
}
// Function CheckEmail(FormName, InputName, Flag) can check any Email Address,and the Address must include a character:"@" and ".". 
// Thereinto:FormName is Form'name;InputName is Input's name;Flag is sing for Null/No Null. 

function CheckEmail(InputName, Flag){
   var Email = eval("document.all" + "." + InputName + ".value");
	 if (Flag ==0 && Email.length==0){
			alert("Email不允许为空！");
		  eval("document.all" + "." + InputName + ".focus();");
		  return false;
   }
   if ((Email.indexOf('@',0)==-1)||(Email.indexOf('@',0)== 0)||(Email.indexOf('.',0)==-1)){
    	alert('输入的邮件地址无效!')
			eval("document.all" + "." + InputName + ".value='';");
			eval("document.all" + "." + InputName + ".focus();");
			return false;
   }
   return true;
}
// Function CheckDecimal(FormName,InputName,MaxLength,BitNumber,Flag) can check bit for a Decimal Number(2bits). 
// Thereinto:FormName is Form'name;InputName is Input's name;MaxLength is max length of InputName'value;BitNumber is Input's value of bit;Flag is sing for Null/No Null. 

function CheckDecimal(FormName,InputName,MaxLength,BitNumber,Flag){
	var rightPart;
	var idOfDecimal;
	var val    = eval("document." + FormName + "." + InputName + ".value");
	var nText1 = eval("Number(document." + FormName + "." + InputName + ".value)");		
	var len    = val.length;
	if (nText1.toString() =='NaN'){
		alert('请输入数值型内容！');
		eval("document." + FormName + "." + InputName + ".value='';")
		eval("document." + FormName + "." + InputName + ".focus();")
		return false;
	}
	if (Flag ==0 && len==0){
		alert("该字段内容不允许为空！");
		eval("document." + FormName + "." + InputName + ".focus();");
		return false;
	}	
	if (val.indexOf('.') == -1){
		if (len > MaxLength){
			alert("输入的数值超出范围，最多"+MaxLength+"位！");
			eval("document." + FormName + "." + InputName + ".focus();");
			return false;
		}
	}else{
		idOfDecimal = val.indexOf('.');
		rightPart   = val.substring(idOfDecimal+1,val.length);
		if (rightPart.length > BitNumber){
			alert("小数点后最多"+BitNumber+"位!");
			eval("document." + FormName + "." + InputName + ".focus();");
			return false;
		}
		return true;
	}
	return true;
}
// Function CheckDecimal(FormName,InputName,BitNumber,Flag) can check bit for a Decimal Number(2bits). 
// Thereinto:FormName is Form'name;InputName is Input's name;BitNumber is bit for InputName'value;Flag is sing for Null/No Null. 

function CheckStaticDecimal(FormName,InputName,BitNumber,Flag){
	var rightPart;
	var leftPart;
	var idOfDecimal;
	var nText1  = eval("Number(document." + FormName + "." + InputName + ".value)");		
	var val     = eval("document." + FormName + "." + InputName + ".value");
	var len     = val.length;
	idOfDecimal = val.indexOf('.');
	leftPart    = val.substring(0,idOfDecimal);
	rightPart   = val.substring(idOfDecimal+1,val.length);
	if (nText1.toString() =='NaN'){
		alert('请输入数值型内容！');
		eval("document." + FormName + "." + InputName + ".value='';")
		eval("document." + FormName + "." + InputName + ".focus();")
		return false;
	}
	if (Flag ==0 && len==0){
		alert("该字段内容不允许为空！");
		eval("document." + FormName + "." + InputName + ".focus();");
		return false;
	}	
	if (Number(val)>1||Number(val)<0){
		alert("该值必须大于'0'或小于'1'!");
		return false;
	}else{
		if (rightPart.length > BitNumber){
			alert("输入数值格式错误，小数点后最多"+BitNumber+"位！");
			eval("document." + FormName + "." + InputName + ".focus();");
			return false;
		}
	}
	return true;
}
// Function CheckNumberDecimal(FormName,InputName,MaxLength,BitNumber,Flag) can check a Decimal to control Number bits and decimal bits. 
// Thereinto:FormName is Form'name;InputName is Input's name;MaxLength is max length of Number;BitNumber is bit for InputName'value;Flag is sing for Null/No Null. 

function CheckNumberDecimal(FormName,InputName,MaxLength,BitNumber,Flag){
	var rightPart;
	var leftPart;
	var idOfDecimal;
	var nText1  = eval("Number(document." + FormName + "." + InputName + ".value)");		
	var val     = eval("document." + FormName + "." + InputName + ".value");
	var len     = val.length;
	idOfDecimal = val.indexOf('.');
	if (nText1.toString() =='NaN'){
		alert('请输入数值型内容！');
		eval("document." + FormName + "." + InputName + ".value='';")
		eval("document." + FormName + "." + InputName + ".focus();")
		return false;
	}
	if (Flag ==0 && len==0){
		alert("该字段内容不允许为空！");
		eval("document." + FormName + "." + InputName + ".focus();");
		return false;
	}	
  var LeftNumber=MaxLength-BitNumber-1;
	if (idOfDecimal == -1){
		if (len > LeftNumber){
			alert("输入数值整数部分超出范围，最多"+LeftNumber+"位！");
			eval("document." + FormName + "." + InputName + ".focus();");
			return false;
		}
	}else{		
		leftPart    = val.substring(0,idOfDecimal);
		rightPart   = val.substring(idOfDecimal+1,val.length);
		if (leftPart.length > LeftNumber){
			alert("输入数值整数部分超出范围，最多"+LeftNumber+"位！");
			eval("document." + FormName + "." + InputName + ".focus();");
			return false;
		}
		if (rightPart.length > BitNumber){
			alert("输入数值格式错误，小数点后最多"+BitNumber+"位！");
			eval("document." + FormName + "." + InputName + ".focus();");
			return false;
		}
	}
	return true;
}
// Function CheckInputDate(FormName,InputName,Flag) can check the format for DATE(mm/dd/yyyy).and check the month/day/year for input. 
// Thereinto:FormName is Form'name;InputName is Input's name;Flag is sing for Null/No Null. 

function CheckInputDate(FormName,InputName){
		var error = 0;
		var data = eval("document." + FormName + "." + InputName + ".value");	
		if((data.charAt(2)!="/" && data.charAt(5)!="/") || data.length!=10)
			error = 1;
		else if(isNaN(data.charAt(0))||isNaN(data.charAt(1))||isNaN(data.charAt(3))||isNaN(data.charAt(4))||isNaN(data.charAt(6))||isNaN(data.charAt(7))||isNaN(data.charAt(8))||isNaN(data.charAt(9)))
			error = 1;
		else
		{
			day = eval(data.charAt(3)+data.charAt(4));
			day = parseInt(day);
			mnth = eval(data.charAt(0)+data.charAt(1));
			mnth = parseInt(mnth);
			yr = eval(data.charAt(6)+data.charAt(7)+data.charAt(8)+data.charAt(9));
			yr = parseInt(yr);
			if(mnth>12 || mnth<1)
				error = 2;
			mnthArray = new Array(31,29,31,30,31,30,31,31,30,31,30,31);
			mnth = mnth-1;
			mydate = new Date(yr,mnth,day);
			if(day > parseInt(mnthArray[parseInt(mnth)]))
				error = 3;
		}
		switch(error){
			case 1: alert("日期的格式应该满足格式:月月/日日/年年年年!");
					break;
			case 2: alert("输入的月份不可用!");
					break;
			case 3: alert("输入的日期不可用!");
					break;
		}
		return true;
}


function CheckInputDate2(FormName,InputName){
		var error = 0;
		var data = eval("document." + FormName + "." + InputName + ".value");	
		if((data.charAt(4)!="-" && data.charAt(7)!="-") || data.length!=10)
			error = 1;
		else if(isNaN(data.charAt(0))||isNaN(data.charAt(1))||isNaN(data.charAt(2))||isNaN(data.charAt(3))||isNaN(data.charAt(5))||isNaN(data.charAt(6))||isNaN(data.charAt(8))||isNaN(data.charAt(9)))
			error = 1;
		else
		{
			day = eval(data.charAt(8)+data.charAt(9));
			day = parseInt(day);
			mnth = eval(data.charAt(5)+data.charAt(6));
			mnth = parseInt(mnth);
			yr = eval(data.charAt(0)+data.charAt(1)+data.charAt(2)+data.charAt(3));
			yr = parseInt(yr);
			if(mnth>12 || mnth<1)
				error = 2;
			mnthArray = new Array(31,29,31,30,31,30,31,31,30,31,30,31);
			mnth = mnth-1;
			mydate = new Date(yr,mnth,day);
			if(day > parseInt(mnthArray[parseInt(mnth)]))
				error = 3;
		}
		switch(error){
			case 1: alert("日期的格式应该满足格式:年年年年-月月-日日!");
					return false;
					break;
			case 2: alert("输入的月份不可用!");
					return false;
					break;
			case 3: alert("输入的日期不可用!");
					return false;
					break;
		}
		return true;
}

// Function CheckSelectDate(formname,SelectYearName,SelectMonthName,SelectDayName) can check the format that it's adapt DATE for some select options link value.
// Thereinto:FormName is Form'name;SelectYearName/SelectMonthName/SelectDayName is Select Options's name(Year/Month/Day).

function CheckSelectDate(FormName,SelectYearName,SelectMonthName,SelectDayName){
	var YearValue  = eval("Number(document."+FormName+"."+SelectYearName+".value)");
	var MonthValue = eval("Number(document."+FormName+"."+SelectMonthName+".value)");
	var DayValue   = eval("Number(document."+FormName+"."+SelectDayName+".value)");
	if ((YearValue/4)!=parseInt(YearValue/4)){
		var maxdays=28;
	}else{ 
		var maxdays=29;
	}
	if (MonthValue == 4||MonthValue ==6||MonthValue ==9||MonthValue ==11){
		var maxdays=30;
		if (DayValue>maxdays){
		alert(YearValue+"年"+MonthValue+"月没有"+DayValue+"日!");
		return false;		
		}
	}
	if (MonthValue == 2 && DayValue>maxdays){
		alert(YearValue+"年"+MonthValue+"月没有"+DayValue+"日!");
		return false;
	}
	return true;
}
// Function ChangToNext() can change focuse by "Enter" key.But when the key's type of focusing is "Submit",the action'll execute Submit action.
// eg:<body onkeydown="ChangToNext()"></body>

function ChangToNext(){
  if ((window.event.srcElement.type != "submit") && (window.event.srcElement.type != "textarea")){
    if (event.keyCode==13){
		  event.keyCode=9;
    }
  }
}
// Function ChangeLocation(locationid,idname,id) can location select option when Chang SupSelect Value. parameter of location is will location select name;idname is subselect name
//

function ChangeLocation(supname,subname,arrayName){
	var i=0;
	var j=0;
	supname=eval("document."+supname+".options[document."+supname+".selectedIndex]");
	supname=supname.value;
	subname=eval("document."+subname);
	subname.length=0;
	for(i=0;i<arrayName.length;i++){
		if (arrayValue[1][i]==supname){
			if (j==0){
				subname.options[subname.length]=new Option("请选择......", "");
			}
			subname.options[subname.length]=new Option(arrayValue[0][i], arrayValue[2][i]);
	        j++;
        }
    }
    if(j==0){
		subname.length=0;
		subname.options[subname.length]=new Option("没有可供选择项！", "");
	}
}

/** 
* 防范SQL注入漏洞，检测输入的字符 
* 需要检测的特殊字符及字符串有：",","-","/","\\","'","%","""  @!#$>?:"$%^
* @param  strInput 待检测的字符 
* @author Tony Lin Added on 2008-10-21 
*/ 
function checkInputChar(strInput){ 
var forbidChar = new Array(",","/","\\","'","%","\"","#","$","^","&","*","!","~","|","~","@","?","!",">","<","{","}"); //增加了特殊字符的全面度   张桂军 2009-09-28
for (var i = 0;i < forbidChar.length ; i++){ 
  if(strInput.indexOf(forbidChar[i]) >= 0){ 
            alert("您输入的信息: "+strInput+" 中含有非法字符: "+forbidChar[i]+" 请更正！"); 
      return false; 
  } 
} 
return true; 
} 

/** 
* 遍历form内元素text类型检测字符合法性，此方法结合 checkInputChar(strInput)使用 
* JSP页面只要调用该方法，并传入form名即可自动完成该form内所有元素字符的检测 
* @param  formName 待检测的form名 
* @author Tony Lin Added on 2008-10-21 
*/ 
function validationFormText(){ 
var actionForm = document.forms[0]; 
for (var i=0;i<actionForm.length;i++ ){
  if (actionForm.elements[i].value != "" && (actionForm.elements[i].type == "text")
		  || actionForm.elements[i].type=="textarea"){ //添加了文本域的输入判断，防止特殊字符  张桂军  2009-09-28
    if(!checkInputChar(actionForm.elements[i].value)){ 
	    actionForm.elements[i].focus(); 
	    return false; 
   	} 
  } 
} 
	return true; 
} 

//by lzf
// Trim() , Ltrim() , RTrim()
String.prototype.Trim = function() 
{ 
return this.replace(/(^\s*)|(\s*$)/g, ""); 
} 
String.prototype.LTrim = function() 
{ 
return this.replace(/(^\s*)/g, ""); 
} 
String.prototype.RTrim = function() 
{ 
return this.replace(/(\s*$)/g, ""); 
} 


//by lzf 2009-0908
function checkPhone(phone)   
{   
//验证电话号码手机号码，包含153，159号段   
if (phone != ""){    
var p1 = /^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/;   
var p2 = /^(\d{11})|(0+\d{11})$/;   
var me = false;   
if (p1.test(phone) || p2.test(phone)) me=true;   
if (!me){      
alert('对不起，您输入的电话号码有错误。');     
return false;   
}   
}  
return true;   
}   
   


function checkMobile(mobile)   
{     
if (mobile != ""){      
var reg0 = /^13\d{5,9}$/;   
var reg1 = /^153\d{4,8}$/;   
var reg2 = /^159\d{4,8}$/;   
var reg3 = /^0\d{10,11}$/; 
var reg4 = /^150\d{4,8}$/;
var reg5 = /^158\d{4,8}$/;
var reg6 = /^15\d{5,9}$/; 
var my = false;   
if (reg0.test(mobile))my=true;   
if (reg1.test(mobile))my=true;   
if (reg2.test(mobile))my=true;   
if (reg3.test(mobile))my=true; 
if (reg4.test(mobile))my=true;   
if (reg5.test(mobile))my=true;   
if (reg6.test(mobile))my=true;   
if (!my){ 
alert('对不起，您输入的手机或小灵通号码有错误。');     
return false;   
}   
return true;   
}   
} 

function checkSpace(str) {
if(/\s+/.test(str)) {
	alert('密码中有空格，请重新输入');
	return false;
}
return true;
}

