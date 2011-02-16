function loginIn(form){
  if (chkblank(form.username,"用户名") == false) {return (false)}
  if(txtquote(form.username,'用户名')==false){return (false)}
  if (chkblank(form.userpwd,"密码") == false) {return (false)}
  if(txtquote(form.userpwd,'密码')==false){return (false)}
  form.submit();
  return true;
}

function txtquote(text,msg){
  if(text.value != ''){
    String = text.value;
    if (String.indexOf("'") != -1){
      alert(msg+"含有非法字符！");
      text.focus();
      return false;
    }
  }
}

function LTrim(str)
{
    var whitespace1 = new String(" \t\n\r");
    var whitespace2 = new String("　\t\n\r");
    var s = new String(str);

    if (whitespace1.indexOf(s.charAt(0)) != -1)
    {
        var j=0, i = s.length;
        while (j < i && whitespace1.indexOf(s.charAt(j)) != -1)
        {
            j++;
        }
        s = s.substring(j, i);
    }
    if (whitespace2.indexOf(s.charAt(0)) != -1)
    {
        var j=0, i = s.length;
        while (j < i && whitespace2.indexOf(s.charAt(j)) != -1)
        {
            j++;
        }
        s = s.substring(j, i);
    }
    return s;
}


/*

==================================================================

RTrim(string):去除右边的空格

==================================================================

*/

function RTrim(str)
{
    var whitespace1 = new String(" \t\n\r");
    var whitespace2 = new String("　\t\n\r");
    var s = new String(str);

    if (whitespace1.indexOf(s.charAt(s.length-1)) != -1)
    {
        var i = s.length - 1;
        while (i >= 0 && whitespace1.indexOf(s.charAt(i)) != -1)
        {
            i--;
        }
        s = s.substring(0, i+1);
    }
    if (whitespace2.indexOf(s.charAt(s.length-1)) != -1)
    {
        var i = s.length - 1;
        while (i >= 0 && whitespace2.indexOf(s.charAt(i)) != -1)
        {
            i--;
        }
        s = s.substring(0, i+1);
    }
    return s;
}


/*

==================================================================

Trim(string):去除前后空格

==================================================================

*/

function Trim(str)
{
    return RTrim(LTrim(str));
}

function getPwd(form){
  if (chkblank(form.user,"用户名") == false) {return (false)}
  if (txtquote(form.user,'用户名')==false){return (false)}

  form.method = "post";
  form.action = "getpwd.jsp";
  form.submit();
  return true;
}
function reg(form){
  if (chkblank(form.user,"用户名") == false) {return (false)}
  if (txtquote(form.user,'用户名')==false){return (false)}
  if (txtblank(form.realname,'用户真实姓名')==false){return (false)}
  if (txtquote(form.realname,'用户真实姓名')==false){return (false)}
  if (txtblank(form.pwd,'密码')==false){return (false)}
  if (txtPassWord(form.pwd,form.confirmpwd) == false) {return (false)}
  if (txtblank(form.email,'电子邮件')==false){return (false)}
  if (mail_check(form.email.value)==false){return (false)}
  form.method="post";
  form.action="regres.jsp";
  form.submit();
  return true;
}

function updateuser1(form){
  if (chkblank(form.username,"用户名") == false) {return (false)}
  if (txtquote(form.username,'用户名')==false){return (false)}
  if (chkblank(form.realname,'用户真实姓名')==false){return (false)}
  if (txtPassWord(form.pwd,form.confirmpwd) == false) {return (false)}
  if (chkblank(form.pwdques,"密码提示问题") == false) {return (false)}
  if (txtquote(form.pwdques,'密码提示问题')==false){return (false)}
  if (chkblank(form.pwdanswer,"密码答案") == false) {return (false)}
  if (txtquote(form.pwdanswer,'密码答案')==false){return (false)}
  if (txtblank(form.email,'电子邮件')==false){return (false)}
  if (mail_check(form.email.value)==false){return (false)}
  form.method="post";
  form.action="useredtres.jsp";
  form.submit();
  return true;
}

function chkblank(text,msg){
  str=text.value;
  str=str.replace(" ","");
  str=str.replace("　","");
  if (str == '') {
    alert(msg+"不能为空！");
    text.focus();
    return false
  }
}
function txtPassWord(pwd1,pwd2){
  if (pwd1.value != pwd2.value){
    alert("两次输入的密码不相同！");
    pwd1.focus();
    return false
  }
  else{
    nr1=pwd1.value;
    flg=0;
    str="";
    spc=""
    arw="";
    for(var i=0;i<nr1.length;i++){
      cmp="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_."
      tst=nr1.substring(i,i+1)
      if (cmp.indexOf(tst)<0){
        flg++;
        str+=" "+tst;
        spc+=tst;
        arw+="^";
      }
      else{
        arw+="_";
      }
    }
    if (flg!=0){
      if (spc.indexOf(" ")>-1){
        str+="和空格";
      }
      alert("密码不接受："+str);
      return false;
    }
  }
}

function dosecondsearch(){
	var fld = document.forms[1].secondfield.value;
	if(fld == 'Format')
		s = document.forms[1].g1.value;
	else if(fld == 'Language')
		s = document.forms[1].y1.value;
	else if(fld == 'Type')
		s = document.forms[1].z1.value;
	else
		s = document.forms[1].searchword.value;
		
	if(Trim(s) != ''){
		document.forms[1].issecond.value = 1;
		document.forms[1].page.value = 1;
		document.forms[1].submit();
		return true;
	}
}

function  CA(){
  for(i=0;i<document.forms[0].checkbox.length;i++){
    if (document.forms[0].checkbox[i].value != 0){
      document.forms[0].checkbox[i].checked = document.forms[0].Select.checked
    }
  }
}

function simple_save(form){
	var s = form.searchword.value;
	if(Trim(s) != ''){
  		if(confirm("确定要保存该检索策略吗？")){
  			form.action="savecond.jsp?objid=1&type=0&op=0";
			form.target="_self";
			form.submit();
		}
	}
}

function adv_save(form){
	var s1 = checkinput1(form);
	var s2 = checkinput2(form);
	var s3 = checkinput3(form);
	
	s = s1 + s2 + s3;
	if(s!=''){
		if(confirm("确定要保存该检索策略吗？")){
    		form.action="savecond.jsp?objid=1&type=0&op=1";
    		form.submit();
  			return true;
  		}
  	}
}

function clearinput(){
  document.advform.txtInput1.value="";
  document.advform.txtInput2.value="";
  document.advform.txtInput3.value="";
  document.advform.starttime.value="";
  document.advform.endtime.value="";
}

function selchange(){
  index = event.srcElement.selectedIndex;
  addfield(index);
  setchange(1);
  setchange(2);
  setchange(3);
}

function getTableIndex(){
  objid = document.advform.objid.value;
  ttable = document.getElementById("table");
  rowcout = ttable.rows.length;
  for(i=0;i<rowcout;i++){
    if(ttable.rows[i].cells[0].innerHTML==objid)
      break;
  }
  return i;
}

function addList(){
  tlist = document.getElementById("objid");
  tslist1 = document.getElementById("set1");
  tslist2 = document.getElementById("set2");
  tslist3 = document.getElementById("set3");

  ttable = document.getElementById("table");
  tstable = document.getElementById("field");

  rowcout = ttable.rows.length;
  rowcout2 = tstable.rows.length;

  cout=0;
  for(i=0; i<rowcout; i++){   // table
    for(j=0; j<rowcout2; j++){  // field
      if(tstable.rows[j].cells[0].innerHTML == ttable.rows[i].cells[0].innerHTML){
          newopt = new Option(ttable.rows[i].cells[2].innerHTML,ttable.rows[i].cells[0].innerHTML);
          tlist.options[cout] = newopt; //table select
          cout++;
          break;  //加一个表名后跳出
       }
    }
  }
}

function addfield( iindex ){
  tlist = document.getElementById("objid");
  tslist1 = document.getElementById("set1");
  tslist2 = document.getElementById("set2");
  tslist3 = document.getElementById("set3");

  tstable = document.getElementById("field");
  rowcout=tstable.rows.length;
  cout=0;

  index = iindex;
  val = 1;//tlist.options[index].value;
  
  tslist1.style.display = "block";
  tslist2.style.display = "block";
  tslist3.style.display = "block";

  tslength = tslist1.length;
  for(i=0; i<tslength; i++)
    tslist1.options[i] = null;
  tslength = tslist2.length;
  for(i=0; i<tslength; i++)
    tslist2.options[i] = null;
  tslength = tslist3.length;
  for(i=0; i<tslength; i++)
    tslist3.options[i] = null;

  for(i=0; i<rowcout; i++){   //field table
    if(tstable.rows[i].cells[0].innerHTML == val){
      newopt = new Option(tstable.rows[i].cells[2].innerHTML,tstable.rows[i].cells[1].innerHTML);
      tslist1.options[cout]=newopt;
      newopt = new Option(tstable.rows[i].cells[2].innerHTML,tstable.rows[i].cells[1].innerHTML);
      tslist2.options[cout]=newopt;
      newopt = new Option(tstable.rows[i].cells[2].innerHTML,tstable.rows[i].cells[1].innerHTML);
      tslist3.options[cout]=newopt;
      cout++;
    }
  }
}

function mail_check(strmail){
  if(!isValidEmailAddress(strmail)){
    alert("邮件地址不合法！");
    return false;
  }
  return true;
}

function isValidEmailAddress(strEmail){
  var i, strDomain, cChar;
  var nDotCount=0;
  var bFindAlpha=false;
  var bLastIsDot=false;
  var strValid="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_.";
  var strStart="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  if(strEmail.length==0) return true;
  if(strStart.indexOf(strEmail.charAt(0))==-1) return false;
  i=strEmail.indexOf("@");
  if(i==-1 || i==0 || i==strEmail.length-1) return false;
  strDomain = strEmail.substring(i+1,strEmail.length);

  if(strDomain.indexOf("@")!=-1) return false;
  if(strDomain.charAt(0)==".") return false;
  if(strDomain.charAt(strDomain.length-1)==".") return false;

  for(i=0;i<strDomain.length;i++){
    cChar = strDomain.charAt(i);
    if(strValid.indexOf(cChar)==-1) return false;
    if(cChar=="."){
      if(bLastIsDot) return false;
      bLastIsDot=true;
      nDotCount++;
    }else bLastIsDot=false;
    if( (("a"<=cChar) && (cChar<="z")) || (("A"<=cChar)&&(cChar<="Z")) )
      bFindAlpha=true;
  }
  if(bFindAlpha && (0==nDotCount)) return false;
  return true;
}

function setchange(indexset){
	document.all("btn"+indexset).disabled = true;

  tlist = document.getElementById("objid");
  tslist1 = document.getElementById("set1");
  tslist2 = document.getElementById("set2");
  tslist3 = document.getElementById("set3");

  switch (indexset){
  case 1:
    fldindex=tslist1.selectedIndex;
    pvalfield=tslist1.options[fldindex].value;
    textfield=tslist1.options[fldindex].text;
    document.advform.btn1.value = "查看"+textfield;
    break;
  case 2:
    fldindex=tslist2.selectedIndex;
    pvalfield=tslist2.options[fldindex].value;
    textfield=tslist2.options[fldindex].text;
    document.advform.btn2.value = "查看"+textfield;
    break;
  case 3:
    fldindex=tslist3.selectedIndex;
    pvalfield=tslist3.options[fldindex].value;
    textfield=tslist3.options[fldindex].text;
    document.advform.btn3.value = "查看"+textfield;
    break;
  }
  var tbindex=tlist.selectedIndex;
  valtable = 1;//tlist.options[tbindex].value;
  fieldvaluetable = document.getElementById("fieldvalue");
  var fieldvaluecount = fieldvaluetable.rows.length;
  for(i=0; i<fieldvaluecount; i++){  // index
    if(fieldvaluetable.rows(i).cells(0).innerText == valtable){  // table
      if(fieldvaluetable.rows(i).cells(1).innerText == pvalfield){  //field
      	document.all("btn"+indexset).disabled = false;
      	break;
      }
    }
  }
}

function getfieldvalue(index){
	tlist = document.getElementById("objid");
  tslist1 = document.getElementById("set1");
  tslist2 = document.getElementById("set2");
  tslist3 = document.getElementById("set3");
  switch (index){
  case 1:
    fldindex=tslist1.selectedIndex;
    fldval=tslist1.options[fldindex].value;
    break;
  case 2:
    fldindex=tslist2.selectedIndex;
    fldval=tslist2.options[fldindex].value;
    break;
  case 3:
    fldindex=tslist3.selectedIndex;
    fldval=tslist3.options[fldindex].value;
    break;
  }
  var tbindex=tlist.selectedIndex;
  tabval = tlist.options[tbindex].value;
  win=window.open("fldval.jsp?index="+index+"&objid="+tabval+"&fldid="+fldval,"_blank","width=560,height=300,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no");
}

function isPosInteger(inputVal)
{
	inputStr = inputVal.toString()
	for (var i = 0; i < inputStr.length; i++)
	{
  	var oneChar = inputStr.charAt(i)
    if ((oneChar < "1" || oneChar > "9")&&(i==0))
    {
    	return false
    }
    if ((oneChar < "0" || oneChar > "9")&&(i!=0))
    {
    	return false
    }
	}
	return true
}

function checkinput1(form){
	var s = '';
	if (form.set1.value=="Type")
		s = form.z1.value;
	else if (form.set1.value=="Format")	
		s = form.g1.value;
	else if (form.set1.value=="Language")	
		s = form.y1.value;
	else
		s = form.txtInput1.value;
	return Trim(s);
}

function checkinput2(form){
	var s = '';
	if (form.set2.value=="Type")
		s = form.z2.value;
	else if (form.set2.value=="Format")	
		s = form.g2.value;
	else if (form.set2.value=="Language")	
		s = form.y2.value;
	else
		s = form.txtInput2.value;
	return Trim(s);
}

function checkinput3(form){
	var s = '';
	if (form.set3.value=="Type")
		s = form.z3.value;
	else if (form.set3.value=="Format")	
		s = form.g3.value;
	else if (form.set3.value=="Language")	
		s = form.y3.value;
	else
		s = form.txtInput3.value;
	return Trim(s);
}

function checkinfo(form){	
	var starttime = Trim(form.starttime.value);
	var endtime = Trim(form.endtime.value);
	if(starttime!=''){
		var strDate;
		eval( "strDate = starttime" );
		if( !isYearString(strDate) )
		{
			alert("起始时间输入不正确！");
			form.starttime.focus();
			return false;
		}
		if(endtime==''){
			alert('截止时间不能为空！');
			form.endtime.focus();
			return false;
		}
	}
	if(endtime!=''){
		var strDate;
		eval( "strDate = endtime" );
		if( !isYearString(strDate) )
		{
			alert("截止时间输入不正确！");
			form.endtime.focus();
			return false;
		}
		if(starttime==''){
			alert('起始时间不能为空！');
			form.starttime.focus();
			return false;
		}
		if(starttime > endtime){
			alert("起始时间不能大于截止时间！");
			form.endtime.focus();
			return false;
		}
	}
	var s1 = checkinput1(form);
	var s2 = checkinput2(form);
	var s3 = checkinput3(form);
	
	s = starttime + endtime + s1 + s2 + s3;

	if(s!='')
		return true;
	else
		return false;
}

function isYearString(sDate){	
	if (!isPosInteger(sDate)) return false
	if (sDate < 1900 || sDate > 2100) return false
	return true;
}

function isDateString(sDate)
{	var iaMonthDays = [31,28,31,30,31,30,31,31,30,31,30,31]
	var iaDate = new Array(3)
	var year, month, day

	if (arguments.length != 1) return false
	iaDate = sDate.toString().split("-")
	if (iaDate.length != 3) return false
	if (iaDate[1].length > 2 || iaDate[2].length > 2) return false

	year = parseFloat(iaDate[0])
	month = parseFloat(iaDate[1])
	day=parseFloat(iaDate[2])

	if (year < 1900 || year > 2100) return false
	if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) iaMonthDays[1]=29;
	if (month < 1 || month > 12) return false
	if (day < 1 || day > iaMonthDays[month - 1]) return false
	return true
}