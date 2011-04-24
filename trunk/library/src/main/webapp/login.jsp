<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
  contentType="text/html; charset=utf-8"%>

<html>
<head>
<title>图书馆管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<%@include file="/common/common.jsp" %>
<script type="text/javascript" src="<%=path %>/js/login.js"></script>

</head>
<body  scroll="no">
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
    <td height="678" background="<%=path%>/images/login/bglogin.jpg"><table  width="1024" height="678" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td><img src="<%=path%>/images/login/login_01.jpg" width="287" height="271" alt=""></td>
        <td><img src="<%=path%>/images/login/login_02.jpg" width="106" height="271" alt=""></td>
        <td><img src="<%=path%>/images/login/login_03.jpg" width="221" height="271" alt=""></td>
        <td><img src="<%=path%>/images/login/login_04.jpg" width="61" height="271" alt=""></td>
        <td><img src="<%=path%>/images/login/login_05.jpg" width="119" height="271" alt=""></td>
        <td><img src="<%=path%>/images/login/login_06.jpg" width="230" height="271" alt=""></td>
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
        <td><img src="<%=path%>/images/login/login_13.jpg" width="287" height="56" alt=""></td>
        <td><img src="<%=path%>/images/login/login_14.jpg" width="106" height="56" alt=""></td>
        <td width="221" height="56" background="<%=path%>/images/login/login_15.jpg">
        	<table width="100%" border="0" align="right" cellpadding="0" cellspacing="0">
	          <tr>
	            <td width="31%" height="28" align="right">用户名：</td>
	            <td width="69%"><input name="user.userName" id="user.userName" class="input1" maxlength="18" /></td>
	          </tr>
	          <tr>
	            <td height="28" align="right">密码：</td>
	            <td><input name="user.password" id="user.password" type="password" class="input1" maxlength="18" /></td>
	          </tr>
        	</table>
        </td>
        <td><input align="absMiddle" id="image1" onClick="loginVerify();" src="<%=path%>/images/login/login_16.jpg" type="image" ></td>
        <td><img src="<%=path%>/images/login/login_17.jpg" width="119" height="56" alt=""></td>
        <td><img src="<%=path%>/images/login/login_18.jpg" width="230" height="56" alt=""></td>
      </tr>
      <tr>
        <td><img src="<%=path%>/images/login/login_19.jpg" width="287" height="26" alt=""></td>
        <td><img src="<%=path%>/images/login/login_20.jpg" width="106" height="26" alt=""></td>
        <td><img src="<%=path%>/images/login/login_21.jpg" width="221" height="26" alt=""></td>
        <td><img src="<%=path%>/images/login/login_22.jpg" width="61" height="26" alt=""></td>
        <td><img src="<%=path%>/images/login/login_23.jpg" width="119" height="26" alt=""></td>
        <td><img src="<%=path%>/images/login/login_24.jpg" width="230" height="26" alt=""></td>
      </tr>
      <tr>
        <td><img src="<%=path%>/images/login/login_25.jpg" width="287" height="252" alt=""></td>
        <td><img src="<%=path%>/images/login/login_26.jpg" width="106" height="252" alt=""></td>
        <td><img src="<%=path%>/images/login/login_27.jpg" width="221" height="252" alt=""></td>
        <td><img src="<%=path%>/images/login/login_28.jpg" width="61" height="252" alt=""></td>
        <td><img src="<%=path%>/images/login/login_29.jpg" width="119" height="252" alt=""></td>
        <td><img src="<%=path%>/images/login/login_30.jpg" width="230" height="252" alt=""></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td bgcolor="#0752d2">&nbsp;</td>
  </tr>
</table>
</body>
</html>