<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<%@ include file="/common/common.jsp"%>
		<%@ include file="/common/extInclude.jsp"%>
		<link href="<%=path %>/css/style.css" type="text/css" rel="stylesheet" />
		<title>图书馆管理系统</title>
		<script type="text/javascript" src="<%=path %>/js/book/Book.js"></script>
		<script type="text/javascript"
			src="<%=path %>/js/book/BookGridPanel.js"></script>
	</head>
	<body>
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0" bgcolor="#dbecff">
			<tr id="ye">
				<td height="4" background="<%=path %>/images/module/bodybg.jpg"></td>
			</tr>
			<tr>
				<td valign="top" height="10">
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						height="100%">
						<tr id="yd">
							<td height="10" valign="top">
								<table width="99%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td>
											<table width="100%" border="0" align="center" cellpadding="0"
												cellspacing="0" class="title_border">
												<tr>
													<td width="19%" height="25" style="text-align: left">
														<strong>&nbsp;<img align="absmiddle"
																src="<%=path %>/images/module/cl0.gif">书刊管理</strong>
													</td>
													<td width="81%" height="25" class=body1
														style="text-align: left">
														<img src="<%=path%>/images/module/02a.gif">
														当前位置：书刊管理&gt;&gt;图书基本管理
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr id="yy">
							<td height="10" valign="top">
								<table width="96%" border="0" align="center" cellpadding="0"
									cellspacing="0" bordercolor="#ebebeb"
									borderColorLight="#ebebeb" borderColorDark="#ffffff" id="LM1">
									<TR>
										<TD width="7%" height=25 align="right" nowrap class="body">
											条形码：
										</TD>
										<TD width="11%" height=25 align="left" nowrap class="body">
											<input name="barCode" type="text" class="input2"
												id="barCode" size="15">
										</TD>
										<TD width="7%" height=25 align="right" nowrap class="body">
											书名：
										</TD>
										<TD width="11%" height=25 align="left" nowrap class="body">
											<input name="bookName" type="text" class="input2"
												id="bookName" size="15">
										</TD>
										<TD width="9%" height=25 align="right" nowrap class="body">
											图书拼写：
										</TD>
										<TD width="12%" height=25 align="left" nowrap class="body">
											<input name="spell" type="text" class="input2"
												id="spell" size="15">
										</TD>
										<TD width="7%" height=25 align="right" nowrap class="body">
											出版社：
										</TD>
										<TD width="36%" height=25 align="left" nowrap class="body">
											<input name="press" type="text" class="input2"
												id="press" size="15">
										</TD>
									</TR>
									<TR>
										<TD height=25 align="right" nowrap class="body">
											位置：
										</TD>
										<TD height=25 align="left" nowrap class="body">
											<input name="location" type="text" class="input2"
												id="location" size="15">
										</TD>
										<TD height=25 align="right" nowrap class="body">
											编号：
										</TD>
										<TD height=25 align="left" class="body">
											<input name="bookNo" type="text" class="input2"
												id="bookNo" size="15">
										</TD>
										<TD height=25 align="right" nowrap class="body">
											索书号：
										</TD>
										<TD height=25 align="left" nowrap class="body">
											<input name="searchBookId" type="text" class="input2"
												id="searchBookId"size="15">
										</TD>
										<TD height=25 align="right" nowrap class="body">
											种次号：
										</TD>
										<TD height=25 align="left" class="body">
											<input name="speciesId" type="text" class="input2"
												id="speciesId" size="15">
										</TD>
									</TR>
									<TR>
										<TD height=25 align="right" nowrap class="body">
											分类：
										</TD>
										<TD height=25 align="left" nowrap class="body">
											<input name="firstCategory" type="text" class="input2"
												id="firstCategory" size="15">
										</TD>
										<TD height=25 align="right" nowrap class="body">
											二级分类：
										</TD>
										<TD height=25 align="left" class="body">
											<input name="secondCategory" type="text" class="input2"
												id="secondCategory" size="15">
										</TD>
										<TD height=25 align="right" nowrap class="body">
											作者：
										</TD>
										<TD height=25 align="left" nowrap class="body">
											<input name="author" type="text" class="input2"
												id="author"size="15">
										</TD>
										<TD height=25 align="right" nowrap class="body">
											录入人：
										</TD>
										<TD height=25 align="left" class="body">
											<input name="operator" type="text" class="input2"
												id="operator" size="15">
										</TD>
									</TR>
								</TABLE>
						<tr id="yb">
							<td height="10" valign="top">
								<table width="99%" border="0" align="center" cellpadding="0"
									cellspacing="0" bgcolor="#f1f8ff"
									style="border: 1px solid #2686d2; margin-top: 2px">
									<tr>
										<td>
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="189" height="33"
														background="<%=path %>/images/module/titleb_01.jpg"
														class="title1">
														查询列表
													</td>
													<td background="<%=path %>/images/module/titleb_02.jpg">&nbsp;
														
													</td>
													<td width="213" align="right"
														background="<%=path %>/images/module/titleb_03.jpg"
														style="padding-bottom: 10px">
														&nbsp;&nbsp;
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr id="yy">
										<td valign="top">
											<table id="tab1" width="97%" border="1" align="center"
												cellpadding="0" cellspacing="0" bordercolor="#bcc3c9"
												borderColorLight="#bcc3c9" borderColorDark="#ffffff"
												bgcolor="#FFFFFF" style="margin-top: 5px">
												<tr>
													<td width="1000" height="300" align="left" valign="top">
														<div id="bookGrid"></div>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
