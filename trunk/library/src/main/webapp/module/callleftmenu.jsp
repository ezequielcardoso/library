<%@ page language="java" import="java.util.*" pageEncoding="GBK"
  contentType="text/html; charset=GBK"%>
<%
String path = request.getContextPath();
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="../css/style.css" type="text/css" rel="stylesheet"/>
<title>广州市自来水综合业务管理平台</title>
<script language="JavaScript" type="text/javascript">
function backIn()
{
if (parent.frames['indexFrame'].cols=='138,11,*')
{
	parent.frames['indexFrame'].cols='0,11,*'
	  document.getElementById('leftbar').style.display=""
	  document.getElementById('rightbar').style.display="none"
}
else{
	parent.frames['indexFrame'].cols='138,11,*'
	document.getElementById('leftbar').style.display="none"
	  document.getElementById('rightbar').style.display=""
	}
}
</script>
</head>
<body><table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%"  background="../images/module/main_14.jpg">
  <tr>
    <td><table width="11" height="100%" border="0" cellpadding="0" cellspacing="0" style="background:url(../images/module/main_06.jpg) fixed no-repeat top;">
  <tr>
  <td  style="display:none" id="leftbar"><a href="#"><img src="../images/module/main_130.jpg" alt="" border="0" onClick="backIn()"></a>
    <td id="rightbar"><a href="#"><img src="../images/module/main_13.jpg" alt="" border="0" onClick="backIn()"></a>  </td>
  </tr>
</table></td>
  </tr>
</table>


</body>
</html>
