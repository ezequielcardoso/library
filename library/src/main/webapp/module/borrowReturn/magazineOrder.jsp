<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<%@ include file="/common/common.jsp"%>
		<%@ include file="/common/extInclude.jsp"%>
		<link href="<%=path %>/css/style.css" type="text/css" rel="stylesheet" />
		<title>图书馆管理系统</title>
		<script type="text/javascript"
			src="<%=path %>/js/borrowReturn/MagazineOrder.js"></script>
		<script type="text/javascript"
			src="<%=path %>/js/borrowReturn/MagazineOrderGridPanel.js"></script>
	</head>
	<body>
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0" bgcolor="#dbecff">
			<tr id="ye" >
				<td height="4" background="<%=path %>/images/module/bodybg.jpg"></td>
			</tr>
			<tr>
				<td valign="top" height="10">
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						height="100%">
						<tr id="yd" >
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
																src="<%=path %>/images/module/cl0.gif">借阅归还</strong>
													</td>
													<td width="81%" height="25" class=body1
														style="text-align: left">
														<img src="<%=path %>/images/module/02a.gif">
														当前位置：借阅归还&gt;&gt;期刊预约登记
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<TR>
										<TD>
											<table width="98%" border="0" align="center" cellpadding="0"
												cellspacing="0">

											</table>
										</TD>
									</TR>
								</table>
							</td>
						</tr>
						<tr id="yy" >
							<td height="10" valign="top">
								<table width="80%" border="0" align="center" cellpadding="0"
									cellspacing="0" bordercolor="#ebebeb"
									borderColorLight="#ebebeb" borderColorDark="#ffffff" id="LM1">

                                 <TR>
										<TD width="18%" height=25 align="right" nowrap="nowrap"
											style="padding-left: 10px;">
											读者条形码：
										</TD>
										<td width="13%" align="left" nowrap>
											<input name="readerBarCode" type="text" class="input2"
												id="readerBarCode" size="15">
										</td>
										<TD width="9%" height=25 align="right" nowrap="nowrap">
											姓名：
										</TD>
										<td width="14%" align="left" nowrap>
											<input name="readerName" type="text" class="input2"
												id="readerName" size="15">
										</td>
										<TD width="11%" height=25 align="right" nowrap="nowrap"
											style="padding-left: 10px;">
											读者单位：
										</TD>
										<td width="35%" align="left" nowrap>
											<input name="unitName" type="text" class="input2"
												id="unitName" size="15">
										</td>
									</TR>
								
									<TR>
										<TD width="18%" height=25 align="right" nowrap="nowrap"
											style="padding-left: 8px;">
											图书条形码：
										</TD>
										<td width="13%" align="left" nowrap>
											<input name="bookBarCode" type="text" class="input2"
												id="bookBarCode"  size="15">
										</td>
										<TD height=25 align="right" nowrap="nowrap">
											书名：
										</TD>
										<td width="14%" align="left" nowrap>
											<input name="bookName" type="text" class="input2"
												id="bookName" size="15">
										</td>
										<TD height=25 align="right" nowrap="nowrap">
											图书类别：
										</TD>
										<td width="35%" align="left" nowrap>
											<input name="firstCategoryName" type="text" class="input2"
												id="firstCategoryName" size="15">
										</td>
									</TR>

								</TABLE>
						<tr id="yb" >
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
													<td background="<%=path %>/images/module/titleb_02.jpg">
														&nbsp;


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
									<tr>
										<td valign="top">
											<table id="tab1" width="97%" border="1" align="center"
												cellpadding="0" cellspacing="0" bordercolor="#bcc3c9"
												borderColorLight="#bcc3c9" borderColorDark="#ffffff"
												bgcolor="#FFFFFF" style="margin-top: 5px">
												<tr>
													<td width="1000" height="300" align="left" valign="top">
														<div id="magazineOrderGrid"></div>
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
