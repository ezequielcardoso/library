<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function sub_fun(){
		window.forms.submit();
	}
	</script>
  </head>
  
  <body>
  	<form name="forms" action="test.do" method="post">
	   	<table border=1>
	   		<TR>
		   		<th>EMPNO</th>
		   		<th>ENAME</th>
		   		<th>JOB</th>
	   		</TR>
	   	
	   		<s:iterator value="#request.allinfo">
	   			<tr>
	   		<Td>
	   		<s:property value="ids"/>
	   		</td>
	   		<Td>
	   		<s:property value="content"/>
	   		</td>
	   		<Td>
	   		<s:property value="content"/>
	   			</td>
	   			</tr>
	   		</s:iterator>
	   	</table><hr/>
	   	<s:property value="#request.page.totalPages" />
	   	共有<s:property value="#request.page.totalRows"/>条信息
	   	<a href="pageAction!pagelist.action?curpage=1&method=first">首页</a>&nbsp;&nbsp;
	   	<a href="pageAction!pagelist.action?curpage=<s:property value="#request.page.currentPage" />&method=pervious">上一页</a>&nbsp;&nbsp;
	   	<a href="pageAction!pagelist.action?curpage=<s:property value="#request.page.currentPage" />&method=next">下一页</a>&nbsp;&nbsp;
	   	<a href="pageAction!pagelist.action?curpage=<s:property value="#request.page.totalPages" />&method=last">尾页</a>&nbsp;&nbsp;  ${page.currentPage }/${page.totalPages} 页
	   	&nbsp;&nbsp;&nbsp;
	   	<input type="hidden" name="method" value="toPage"/>
	   	<select name="curpage">
	   		<option value="1">1</option>
	   		<option value="2">2</option>
	   		<option value="3">3</option>
	   	</select>&nbsp;&nbsp;<input type="submit" value="转到" onclick="sub_fun();"/>
   	</form>  
  </body>
</html>
