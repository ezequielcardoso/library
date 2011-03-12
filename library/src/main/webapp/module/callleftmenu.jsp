<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
  contentType="text/html; charset=utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"" />
<title>图书馆管理系统</title>
<%@include file="/common/common.jsp" %>
<script language="JavaScript" type="text/javascript">
function backIn()
{
	if (parent.frames['indexFrame'].cols=='138,11,*')
	{
		parent.frames['indexFrame'].cols='0,11,*'
		document.getElementById('leftbar').style.display=""
		document.getElementById('rightbar').style.display="none"
	} else {
		parent.frames['indexFrame'].cols='138,11,*'
		document.getElementById('leftbar').style.display="none"
	  	document.getElementById('rightbar').style.display=""
	}
}
</script>
</head>
<body><table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%"  background="<%=path %>/images/module/main_14.jpg">
  <tr>
    <td><table width="11" height="100%" border="0" cellpadding="0" cellspacing="0" style="background:url(<%=path %>/images/module/main_06.jpg) fixed no-repeat top;">
  <tr>
  <td  style="display:none" id="leftbar"><a href="#"><img src="<%=path %>/images/module/main_130.jpg" alt="" border="0" onClick="backIn()"></a>
    <td id="rightbar"><a href="#"><img src="<%=path %>/images/module/main_13.jpg" alt="" border="0" onClick="backIn()"></a>  </td>
  </tr>
</table></td>
  </tr>
</table>


</body>
</html>
