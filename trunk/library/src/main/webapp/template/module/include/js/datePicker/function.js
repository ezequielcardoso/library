//===============================================================================
//getStrAllocateLen - get string's length allocated in database
//===============================================================================
function getStrAllocateLen(str){
	var iLen=0;
	var iUnicode;
	
	for(i=0;i<str.length;i++){
		iUnicode=str.charCodeAt(i);
		if (iUnicode<=128){				//英文字符
			iLen+=1;
		}else{
			if (iUnicode>128 && iUnicode<=255){
				iLen+=2;
			}else{
				if (iUnicode>=4112){	//中文字符
					iLen+=2;
				}else{
					iLen+=1;			//其他字符
				}
			}
		}
	}
	return(iLen);
}

//===============================================================================
//openWindow - 
//===============================================================================
function openWindow(url, w, h,n)
{
	var options = "width=" + w + ",height=" + h + ",";
	options += "resizable=yes,scrollbars=yes,status=yes,";
	options += "location=no,menubar=no,toolbar=no,directories=no,top=10,left=119";
	if(n=="")
	{
		var date=new Date();
		n=date.getSeconds();
	}
	n=n+"ab";	
	var newWin=window.open(url,n, options);
	newWin.focus();
}
//===============================================================================
//validatePageNum - validate if the string inputed is a validatePageNum
//===============================================================================
function chartoint(num){
	var mask = '0123456789';
	return mask.indexOf(num);
}
function validatePageNum(obj,pageCount)
{     
     if(isNaN(obj.value))
     {
           alert("您输入了无效页码，请输入数字！");
           obj.value="";
           return false;
     }
     else
     {  
        var str=obj.value;
        var intvalue=0;
		for(var i=0;i<str.length;i++)
		{
			if(chartoint(str.substring(i,i+1))==-1)
			{
				alert("您输入的页码不正确，请输入整数！");
				obj.value="";
	                 return false;
			}
			intvalue = intvalue*10+chartoint(str.substring(i,i+1));
   			if((intvalue>pageCount)||(intvalue<1))
   			{
			         alert("您输入的页码超出可取范围，请重新输入！");
			         obj.value="";
			         return false;
			}
		}
		return true;
	}
	
}
//===============================================================================
//validateInputString - validate if the string inputed contain the invalid chat
//===============================================================================
function validateInputString(strInput){
	if (typeof(strInput)!="string"){
		return(false);
	}
	var i;
	var iCode;
	for (i=0;i<strInput.length;i++){
		iCode=strInput.charCodeAt(i);
		if (iCode!=95){		//	char _
			if (iCode<48 || iCode>122 || (iCode>57 && iCode<65) || (iCode>90 && iCode<97) ){
				return(false);
			}
		}
	}
	return(true);
}

//===============================================================================
//replaceString - in strSource string,search the strFind string and replace with strReplace string 
//===============================================================================
function replaceString(strSource,strFind,strReplace){
	var pos = 0
	var srcLen
	var fndLen
	var repLen
	var strRtn=""
	
	if (typeof(strSource)!='string' || typeof(strFind)!='string' || typeof(strReplace)!='string' ){
		reportError(L_errFuncParaTypeMissMatch_ErrMsg,"replaceString")
		return -1;
	}
	srcLen = strSource.length;
	fndLen = strFind.length;
	repLen = strReplace.length;
	if ( srcLen==0 || srcLen<fndLen || fndLen==0 )
		return strSource;
	pos=strSource.indexOf(strFind,0);
	while ( pos!=-1){
		strRtn += strSource.substr(0,pos);
		strRtn += strReplace;
		strSource=strSource.substr(pos+fndLen);
		pos=strSource.indexOf(strFind,0);
	}
	strRtn+=strSource;
	return strRtn;
}

// Valiate a string that can present a date
// Correct format is 1999/1/31 or 1999-1-13
function isDateStr(sDate)
{
	var aDate = sDate.split('-');
	if(aDate.length == 3 )
	{
		if(isDate(aDate[0], aDate[1], aDate[2])) return(true);
		return(false);
	}
	aDate = sDate.split('/');
	if(aDate.length == 3 )
	{
		if(isDate(aDate[0], aDate[1], aDate[2])) return(true);
		return(false);
	}
	return(false);
}

//===============================================================================
//isDate - check if strYear,strMonth and strDay can combine to date
//===============================================================================
function isDate(strYear,strMonth,strDay){
	if (typeof(strYear)!='string' || typeof(strMonth)!='string' || typeof(strDay)!='string'){
		reportError(L_errFuncParaTypeMissMatch_ErrMsg,"isDate")
		return false;
	}
	var iYear = strYear * 1
	var iMonth = strMonth * 1
	var iDay = strDay * 1
	if (isNaN(iYear) || isNaN(iMonth) || isNaN(iDay)){
		return false;
	}
	if (iYear<1000 || iYear>9999)
		return false;
	if (iMonth<1 || iMonth>12)
		return false;
	if (iDay<1 || iDay>31)
		return false;
	var strDate = iMonth+"/"+iDay+"/"+iYear
	var objDate = new Date(strDate)
	iYear = objDate.getFullYear()
	iMonth = objDate.getMonth()+1
	iDay = objDate.getDate()
	if (strDate!=(iMonth+"/"+iDay+"/"+iYear))
		return false;
	return true;	
}

//===============================================================================
//isTime - check if strHour,strMinute and strSecond can combine to time
//===============================================================================
function isTime(strHour,strMinute,strSecond){
	if (typeof(strHour)!='string' || typeof(strMinute)!='string' || typeof(strSecond)!='string'){
		reportError(L_errFuncParaTypeMissMatch_ErrMsg,"isDate")
		return false;
	}
	if (strHour=="" && strMinute=="" && strSecond==""){
		return true;
	}
	var iHour = strHour * 1
	var iMinute = strMinute * 1
	var iSecond = strSecond * 1
	if (isNaN(iHour) || isNaN(iMinute) || isNaN(iSecond)){
		return false;
	}
	if (iHour<0 || iHour>23) return false;
	if (iMinute<0 || iMinute>59) return false;
	if (iSecond<0 || iSecond>59) return false;
	return true;
}

// To clear starting & ending space in a string object
function trimStr(sVal)
{
	var iPos;
	//clear starting space
	while(true)
	{
		iPos = sVal.indexOf(' ');
		if(iPos == -1) break;
		if(iPos > 0) break;
		sVal = sVal.slice(1);
	}
	//clear ending space
	while(true)
	{
		iPos = sVal.lastIndexOf(' ');
		if(iPos == -1) break;
		if(iPos < sVal.length-1) break;
		sVal = sVal.slice(0, iPos);
	}
	return(sVal);
}

//鼠标移入,移出变换图标
function MM_findObj(n, d) 
{
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage()
{
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

function MM_swapImgRestore()
{
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

//显示或隐藏左侧
function changeSize(){
	if(top.root.cols!='0,*'){
		top.root.cols='0,*';
	}else{
		top.root.cols='137,*';
	}
}

//显示或隐藏
function turnit(ss)
{
	
    if (ss.style.visibility=="hidden") 
    {	
        ss.style.visibility="visible";
    }else{
        ss.style.visibility="hidden"; 
    }
}

//判断提醒，开始和结束时间的顺序是否正确

function checkTimeSequence(wakeStr,startStr,endStr)
{
	var wake = wakeStr.split(' ');
	var start = startStr.split(' ');
	var end = endStr.split(' ');
	var wakeTime,startTime,endTime;
	if(wake.length==2)
	{
		var aDate = wake[0].split('-');
		var aTime = wake[1].split(':');
		wakeTime = aDate[0]*100000000+aDate[1]*1000000+aDate[2]*10000+aTime[0]*100+aTime[1]*1;
	}
	if(wake.length==1)
	{
		var aDate = wake[0].split('-');
		wakeTime = aDate[0]*100000000+aDate[1]*1000000+aDate[2]*10000;
	}
	if(start.length==2)
	{
		var aDate = start[0].split('-');
		var aTime = start[1].split(':');
		startTime = aDate[0]*100000000+aDate[1]*1000000+aDate[2]*10000+aTime[0]*100+aTime[1]*1;
	}
	if(start.length==1)
	{
		var aDate = start[0].split('-');
		startTime = aDate[0]*100000000+aDate[1]*1000000+aDate[2]*10000;
	}
	if(end.length==2)
	{
		var aDate = end[0].split('-');
		var aTime = end[1].split(':');
		endTime = aDate[0]*100000000+aDate[1]*1000000+aDate[2]*10000+aTime[0]*100+aTime[1]*1;
	}
	if(end.length==1)
	{
		var aDate = end[0].split('-');
		endTime = aDate[0]*100000000+aDate[1]*1000000+aDate[2]*10000;
	}
	
	if(startTime>endTime)
		return false;
	else
		return true;
}

function checkPage(pageNum,pageNow,pageCount)
{
	
	if (pageCount==0)//无内容
	{
		alert("没有内容显示！");
		return false;
	}
	else
	{
		if ((pageCount==1)&&(pageNow==1))//只有一页的情况，警告只有一页
		{
			if ((pageNum==1)&&(pageNum!=""))
			{
				alert("只有一页！");
				return false;
			}
			if (pageNum==0)
			{
				alert("只有一页！");
				return false;
			}
			if (pageNum==2)
			{
				alert("只有一页！");
				return false;
			}
		}
		else//多页情况
		{
			//如果输入页要大于总页数且输入页不等于1且当前页等于总页数时，说明已到最后一页
			if ((pageNum>=pageCount)&&(pageNum!=1)&&(pageCount==pageNow)&&(pageNum!=""))
			{
				alert("已经是最后一页了！");
				return false;
			}
			//如果输入页小于等于当前页且输入页不等于1且当前页等于1，说明已到达第一页
			if ((pageNum<=pageNow)&&(pageNum!=1)&&(pageNow==1))
			{
				alert("已经是第一页了！");
				return false;
			}
			//如果输入页小于等于当前页且输入页等于1且当前页等于1，说明已到达第一页
			if ((pageNum<=pageNow)&&(pageNum==1)&&(pageNow==1))
			{
				alert("已经是第一页了！");
				return false;
			}
		}
	}
	return true;
}

function checkStartTimeAndEndTime(startStr,endStr)
{
	var start = startStr.split(' ');
	var end = endStr.split(' ');
	var startTime,endTime;
	if(start.length==2)
	{
		var aDate = start[0].split('-');
		var aTime = start[1].split(':');
		startTime = aDate[0]*100000000+aDate[1]*1000000+aDate[2]*10000+aTime[0]*100+aTime[1]*1;
	}
	if(start.length==1)
	{
		var aDate = start[0].split('-');
		startTime = aDate[0]*100000000+aDate[1]*1000000+aDate[2]*10000;
	}
	if(end.length==2)
	{
		var aDate = end[0].split('-');
		var aTime = end[1].split(':');
		endTime = aDate[0]*100000000+aDate[1]*1000000+aDate[2]*10000+aTime[0]*100+aTime[1]*1;
	}
	if(end.length==1)
	{
		var aDate = end[0].split('-');
		endTime = aDate[0]*100000000+aDate[1]*1000000+aDate[2]*10000;
	}
	
	if(startTime>endTime)
		return true;
	else
		return false;
}