<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>����������ˮ�ۺ�ҵ�����ƽ̨</title>
<link href="../css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="149"><img src="../images/module/main_01.jpg" width="149" height="72" alt=""></td>
        <td width="804" valign="top" background="../images/login/main_02.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="51">&nbsp;</td>
          </tr>
          <tr>
            <td height="21" style="padding-left:42px" class="title"><MARQUEE onmouseover=Javascript:this.stop() 
                        onmouseout=Javascript:this.start() scrollAmount=4
                        scrollDelay=40  width="100%" height=13>
             ���棺��ĩ���ܽ���....
            </MARQUEE></td>
          </tr>
        </table></td>
        <td background="../images/module/main_03.jpg">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="27"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="508" height="27" background="../images/module/title_01.jpg">&nbsp;&nbsp;��ӭ����administrator&nbsp;&nbsp;<img src="../images/module/play.gif" width="16" height="17" align="absmiddle">&nbsp;<SCRIPT language=javascript>
var isnMonths=new initArray("01��","02��","03��","04��","05��","06��","07��","08��","09��","10��","11��","12��");
var isnDays=new initArray("������","����һ","���ڶ�","������","������","������","������");
today=new Date();
function initArray()
{
	for(i=0;i<initArray.arguments.length;i++)
	this[i]=initArray.arguments[i];
}
function getFullYear(d)
{
	yr = d.getYear();
	if(yr<1000)	yr += 1900;
	return yr;
}
document.write(getFullYear(today) +"��"  + isnMonths[today.getMonth()] +  today.getDate()+"��&nbsp;" +  isnDays[today.getDay()]);
       </SCRIPT></td>
        <td background="../images/module/title_02.jpg">&nbsp;</td>
        <td width="500" align="right" background="../images/module/title_03.jpg"><a href="main.htm" target="mainFrame"><img src="../images/module/home.gif" align="absmiddle">��ҳ</a>&nbsp;<a href="login.html" target="_parent"><img src="../images/module/quit.jpg"  align="absmiddle">�˳�ϵͳ&nbsp;&nbsp;</a></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
