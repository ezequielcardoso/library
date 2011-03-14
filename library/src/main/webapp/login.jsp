<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
  contentType="text/html; charset=utf-8"%>

<html>
<head>
<title>图书馆管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="/common/common.jsp" %>
<!--

<script language="JavaScript">
function mysubmit(form1)
	{
		if( form1.user.value =="" ) {
                alert("请输入用户名！")
				form1.user.focus();
                return false;
       }
	   
	    if( form1.password.value =="" ) {
                alert("请输入密码！")
				form1.password.focus();
                return false;
       } 
	       return true;
	}
</script>
-->
</head>
<body  scroll="no">
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
    <td height="678" background="<%=path%>/images/module/bglogin.jpg"><table  width="1024" height="678" border="0" align="center" cellpadding="0" cellspacing="0">
      <form name="login" method="post" action="<%=path%>/module/index.jsp" onSubmit="return mysubmit(this)">
      <tr>
        <td><img src="<%=path%>/images/module/login_01.jpg" width="287" height="271" alt=""></td>
        <td><img src="<%=path%>/images/module/login_02.jpg" width="106" height="271" alt=""></td>
        <td><img src="<%=path%>/images/module/login_03.jpg" width="221" height="271" alt=""></td>
        <td><img src="<%=path%>/images/module/login_04.jpg" width="61" height="271" alt=""></td>
        <td><img src="<%=path%>/images/module/login_05.jpg" width="119" height="271" alt=""></td>
        <td><img src="<%=path%>/images/module/login_06.jpg" width="230" height="271" alt=""></td>
      </tr>
      <tr>
        <td><img src="<%=path%>/images/login/login_07.jpg" width="287" height="73" alt=""></td>
        <td><img src="<%=path%>/images/login/login_08.jpg" width="106" height="73" alt=""></td>
        <td><img src="<%=path%>/images/login/login_09.jpg" width="221" height="73" alt=""></td>
        <td><img src="<%=path%>/images/login/login_10.jpg" width="61" height="73" alt=""></td>
        <td><img src="<%=path%>/images/login/login_11.jpg" width="119" height="73" alt=""></td>
        <td><img src="<%=path%>/images/login/login_12.jpg" width="230" height="73" alt=""></td>
      </tr>
      <tr>
        <td><img src="<%=path%>/images/module/login_13.jpg" width="287" height="56" alt=""></td>
        <td><img src="<%=path%>/images/module/login_14.jpg" width="106" height="56" alt=""></td>
        <td width="221" height="56" background="<%=path%>/images/module/login_15.jpg"><table width="100%" border="0" align="right" cellpadding="0" cellspacing="0">
          <tr>
            <td width="31%" height="28" align="right">用户名：</td>
            <td width="69%"><input name="user" class="input1" maxlength="18" onMouseOver="fEvent('mouseover',this)" onFocus="fEvent('focus',this)" onBlur="fEvent('blur',this)" onMouseOut="fEvent('mouseout',this)"/></td>
          </tr>
          <tr>
            <td height="28" align="right">密码：</td>
            <td><input name="password" type="password" class="input1" id="password" maxlength="18" onMouseOver="fEvent('mouseover',this)" onFocus="fEvent('focus',this)" onBlur="fEvent('blur',this)" onMouseOut="fEvent('mouseout',this)"/></td>
          </tr>
        </table></td>
        <td><input align="absMiddle" id="image1" name="image1" src="<%=path%>/images/module/login_16.jpg" type="image" ></td>
        <td><img src="<%=path%>/images/module/login_17.jpg" width="119" height="56" alt=""></td>
        <td><img src="<%=path%>/images/module/login_18.jpg" width="230" height="56" alt=""></td>
      </tr>
      <tr>
        <td><img src="<%=path%>/images/module/login_19.jpg" width="287" height="26" alt=""></td>
        <td><img src="<%=path%>/images/module/login_20.jpg" width="106" height="26" alt=""></td>
        <td><img src="<%=path%>/images/module/login_21.jpg" width="221" height="26" alt=""></td>
        <td><img src="<%=path%>/images/module/login_22.jpg" width="61" height="26" alt=""></td>
        <td><img src="<%=path%>/images/module/login_23.jpg" width="119" height="26" alt=""></td>
        <td><img src="<%=path%>/images/module/login_24.jpg" width="230" height="26" alt=""></td>
      </tr>
      <tr>
        <td><img src="<%=path%>/images/module/login_25.jpg" width="287" height="252" alt=""></td>
        <td><img src="<%=path%>/images/module/login_26.jpg" width="106" height="252" alt=""></td>
        <td><img src="<%=path%>/images/module/login_27.jpg" width="221" height="252" alt=""></td>
        <td><img src="<%=path%>/images/module/login_28.jpg" width="61" height="252" alt=""></td>
        <td><img src="<%=path%>/images/module/login_29.jpg" width="119" height="252" alt=""></td>
        <td><img src="<%=path%>/images/module/login_30.jpg" width="230" height="252" alt=""></td>
      </tr>
      </form>
    </table></td>
  </tr>
  <tr>
    <td bgcolor="#0752d2">&nbsp;</td>
  </tr>
</table>
</body>
</html>