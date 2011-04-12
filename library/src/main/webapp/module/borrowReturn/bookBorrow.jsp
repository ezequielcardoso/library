<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<%@ include file="/common/common.jsp"%>
		<%@ include file="/common/extInclude.jsp"%>
		<link href="<%=path %>/css/style.css" type="text/css" rel="stylesheet" />
		<title>图书馆管理系统</title>

		<script type="text/javascript"
			src="<%=path %>/js/borrowReturn/BROperation.js"></script>
		<script type="text/javascript"
			src="<%=path %>/js/borrowReturn/BorrowTabPanel.js"></script>
		<script type="text/javascript"
			src="<%=path %>/js/borrowReturn/Borrow.js"></script>
	</head>
	<body bgcolor="#dbecff">
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0" bgcolor="#dbecff">
			<tr>
				<td height="4" background="<%=path %>/images/module/bodybg.jpg"></td>
			</tr>
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
                            <td width="1000" height="300" align="left" valign="top">
							        <div id="borrowTab"></div>
							</td> 
						</tr>
						<tr>

						</tr>
					</table>
				</td>
			</tr>
		</table>

	</body>
</html>
