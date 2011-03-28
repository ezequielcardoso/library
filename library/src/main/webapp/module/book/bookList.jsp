<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<%@ include file="/common/common.jsp"%>
		<link href="<%=path%>/css/style.css" type="text/css" rel="stylesheet" />
		<title>图书馆管理系统</title>
		
		<link rel="stylesheet" type="text/css" href="<%=path%>/common/extjs3.2/resources/css/ext-all.css" />
		<script type="text/javascript" src="<%=path%>/common/extjs3.2/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="<%=path%>/common/extjs3.2/ext-basex.js"></script>
		<script type="text/javascript" src="<%=path%>/common/extjs3.2/ext-all.js"></script>
		<script type="text/javascript" src="<%=path%>/js/book/Book.js"></script>
		<script type="text/javascript" src="<%=path%>/js/book/BookGridPanel.js"></script>
		
   </head>
	
	<body>
	
	  <div id="bookGrid"></div>
	
	</body>
	</html>
