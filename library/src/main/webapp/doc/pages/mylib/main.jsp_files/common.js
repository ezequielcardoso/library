function login(form){
  if ((form.username.value=='')&&(form.userpwd.value=='')){
    form.submit();
    return true;
  }
  if (chkblank(form.username,"用户名") == false) {return (false)}
  if(txtquote(form.username,'用户名')==false){return (false)}
  if (chkblank(form.userpwd,"密码") == false) {return (false)}
  if(txtquote(form.userpwd,'密码')==false){return (false)}
  form.submit();
  return true;
}

function checkword(){
var s = document.forms[0].searchword.value;
if(Trim(s) != ''){
	document.forms[0].submit();
	return true;
}
return false;
}

function submitsimple() {//v1.0
  document.simpleform.action = "/mwsearch/verify";
  document.simpleform.submit();
}

function clearinput(){
 document.regform.username.value="";
 document.regform.realname.value="";
 document.regform.userpwd.value="";
 document.regform.confirmpwd.value="";
 document.regform.pwdques.value="";
 document.regform.pwdanswer.value="";
 document.regform.email.value="";
}

function txtquote(text,msg){
  if(text.value != ''){
    var str = text.value;
    if (str.indexOf("'") != -1){
      alert(msg+"不接受单引号！");
      text.focus();
      return false;
    }
  }
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
  if (chkblank(form.username,"用户名") == false) {return (false)}
  if (txtquote(form.username,'用户名')==false){return (false)}
  if(form.username.value=='guest'){
	alert("该用户编号已存在！");
	form.username.focus();
	return false;
  }
  if (chkblank(form.realname,'真实姓名')==false){return (false)}
  if (txtquote(form.realname,'真实姓名')==false){return (false)}
  if (chkblank(form.userpwd,'密码')==false){return (false)}
  if (txtPassWord(form.userpwd,form.confirmpwd) == false) {return (false)}
  if (chkblank(form.pwdques,"密码提示问题") == false) {return (false)}
  if (txtquote(form.pwdques,'密码提示问题')==false){return (false)}
  if (chkblank(form.pwdanswer,"密码答案") == false) {return (false)}
  if (txtquote(form.pwdanswer,'密码答案')==false){return (false)}
  if (chkblank(form.email,'邮件地址')==false){return (false)}
  if (mail_check(form.email.value)==false){return (false)}
  form.submit();
  return true;
}

function txtPassWord(pwd1,pwd2){
  if (pwd1.value != pwd2.value){
    alert("两次输入的密码不一致！");
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

function updateuser(form){
  if (chkblank(form.user,"用户名") == false) {return (false)}
  if (txtquote(form.user,'用户名')==false){return (false)}
  if (chkblank(form.realname,'真实姓名')==false){return (false)}
  if (chkquote(form.realname,'真实姓名')==false){return (false)}
  if (txtPassWord(form.pwd,form.confirmpwd) == false) {return (false)}
  if (txtblank(form.email,'邮件地址')==false){return (false)}
  if (mail_check(form.email.value)==false){return (false)}
  form.submit();
  return true;
}

function chklength(text,msg){
  str=text.value.length;
  if(str>125){
    alert(msg+"超长！");
    text.focus();
    return false
  }
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

function  CA(){
  for(i=0;i<document.forms[0].checkbox.length;i++){
    if (document.forms[0].checkbox[i].value != 0){
      document.forms[0].checkbox[i].checked = document.forms[0].Select.checked
    }
  }
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

function myscroll_down() {
	window.frames['ifr'].scrollDown();
}

function myscroll_up() {
	//document.ifr.scrollUp();
	window.frames['ifr'].scrollUp();
}

function myscroll_stop() {
	//document.ifr.scrollStop();
	window.frames['ifr'].scrollStop();
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

function addURL(){
  tlist = document.getElementById("opttype");

  ttable = document.getElementById("type");
  tstable = document.getElementById("url");

  rowcout = ttable.rows.length;
  rowcout2 = tstable.rows.length;

  cout=0;
  newopt = new Option("--CALIS相关站点分类--","");
  tlist.options[cout] = newopt;
  cout++;
  
  for(i=0; i<rowcout; i++){   // table
    for(j=0; j<rowcout2; j++){  // field
      if(tstable.rows[j].cells[0].innerHTML == ttable.rows[i].cells[0].innerHTML){
          newopt = new Option(ttable.rows[i].cells[0].innerHTML,ttable.rows[i].cells[0].innerHTML);
          tlist.options[cout] = newopt; //table select
          cout++;
          break;  //加一个表名后跳出
       }
    }
  }
}

function addfld( iindex ){
  tlist = document.getElementById("opttype");
  tslist = document.getElementById("opturl");

  tstable = document.getElementById("url");
  rowcout=tstable.rows.length;
  cout=0;

  index = iindex;
  val = tlist.options[index].value;
  
  tslength = tslist.length;
  for(i=0; i<tslength; i++)
    tslist.options[i] = null;
  
  newopt = new Option("--CALIS相关站点--","");
  tslist.options[cout] = newopt; 
  cout++;

  for(i=0; i<rowcout; i++){   //field table
    if(tstable.rows[i].cells[0].innerHTML == val){
      newopt = new Option(tstable.rows[i].cells[2].innerHTML,tstable.rows[i].cells[1].innerHTML);
      tslist.options[cout]=newopt;
      cout++;
    }
  }
}

function selchanges(e){
  var ie = window.navigator.appVersion.indexOf('MSIE')==-1?false:true;
  var srcElement = ie?window.event.srcElement:e.target;
  index = srcElement.selectedIndex;
  addfld(index);
}