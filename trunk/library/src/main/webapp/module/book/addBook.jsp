<%@ page language="java" import="java.util.*;" pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	    <%@ include file="/common/common.jsp"%>
		<link href="<%=path%>/css/style.css" type="text/css" rel="stylesheet" />
		<title>图书馆管理系统</title>
		
		<link rel="stylesheet" type="text/css" href="<%=path%>/common/extjs3.2/resources/css/ext-all.css"  />
		<script type="text/javascript" src="<%=path%>/common/extjs3.2/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="<%=path%>/common/extjs3.2/ext-basex.js"></script>
		<script type="text/javascript" src="<%=path%>/common/extjs3.2/ext-all.js"></script>
		<script type="text/javascript" src="<%=path%>/js/book/BookAdd.js"></script>
		<script type="text/javascript" src="<%=path%>/js/book/BookAddPanel.js"></script>
		
	</head>
	<body>
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0" bgcolor="#dbecff">
			<tr>
				<td height="2" background="<%=path%>/images/module/bodybg.jpg"></td>
			</tr>
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td height="10" valign="top">
								<table width="99%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td>
											<table width="100%" border="0" align="center" cellpadding="0"
												cellspacing="0" class="title_border">
												<tr>
													<td width="19%" height="25" style="text-align: left">
														<strong>&nbsp;<img
																src="<%=path%>/images/module/cl0.gif" align="absmiddle">书刊管理</strong>
													</td>
													<td width="81%" height="25" class=body1
														style="text-align: left">
														<img src="<%=path%>/images/module/02a.gif">
														当前位置：书刊管理 &gt;&gt;图书基本管理
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td height="10" valign="top">
								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="0">
								  <div id="addGrid"></div>
								</table>
							</td>
						</tr>

					</table>
				</td>
			</tr>
		</table>
	

	</body>
</html>
