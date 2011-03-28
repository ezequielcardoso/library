<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图书馆管理系统</title>
<%@include file="/common/common.jsp" %>
</head>
<frameset rows="99,*,27" cols="*" frameborder="NO" border="0" framespacing="0">
  <frame src="<%=path%>/module/top.jsp" name="topFrame" scrolling="NO" noresize>
  <frameset cols="138,11,*"  frameborder="NO" border="0" framespacing="0" id="indexFrame">
    <frame src="<%=path%>/rights/findModuleFunctions.action" name="leftFrame" scrolling="no" noresize id="leftFrame"> 
 <!--   <frame src="<%=path%>/module/left_backup.jsp" name="leftFrame" scrolling="no" noresize id="leftFrame"> -->
    <frame src="<%=path%>/module/callleftmenu.jsp" name="leftbarFrame" scrolling="NO" noresize>
    <frame src="<%=path%>/module/main.htm" name="mainFrame" noresize scrolling="yes">
  </frameset>
  <frame src="<%=path%>/module/bottom.jsp" name="bottomFrame" scrolling="NO" noresize>
</frameset>
<noframes><body>
<center>
抱歉！本页使用了框架，由于您的浏览器不支持框架，所以本页无法显示，请使用支持框架的浏览器浏览！
</center>
</body></noframes>
</html>
