<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  <body>
    		<center><font size="10">用户管理系统</font></center>
    		<br>
    		<br/>
    		<br/>
    		<center>
    			增加用户<br>
    			<form action="user/addUser.action" method="get">
    				姓:&nbsp&nbsp&nbsp
    			<input name="user.firstName" type="text"><br/>
    				名:&nbsp&nbsp&nbsp
    			<input name="user.lastName" type="text"><br/>
    			<input name="user.id" type="hidden" >
    			<input type="submit" value="提交">
    			</form>
    		</center>
  </body>
</html>
