<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<%@ include file="/common/common.jsp"%>
		<%@ include file="/common/extInclude.jsp"%>
		<link href="<%=path %>/css/style.css" type="text/css" rel="stylesheet" />
		<title>图书馆管理系统</title>
		<script type="text/javascript" src="<%=path %>/js/common/common.js"></script>
		
		<script type="text/javascript"
			src="<%=path %>/js/borrowReturn/BookBorrow.js"></script>
		<script type="text/javascript"
			src="<%=path %>/js/borrowReturn/BookBorrowGridPanel.js"></script>

		
	</head>
	<body bgcolor="#dbecff">
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0" bgcolor="#dbecff">
			<tr>
				<td height="4" background="<%=path %>/images/module/bodybg.jpg"></td>
			</tr>
			<form action="" method="get" id="" name="">
			<tr>
				<td valign="top">

					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<table width="100%" border="0" align="center" cellpadding="0"
									cellspacing="0" class="title_border">
									<tr>
										<td width="19%" height="25" style="text-align: left">
											<strong>&nbsp;<img
													src="<%=path %>/images/module/cl0.gif" align="absmiddle">借阅归还</strong>
										</td>
										<td width="81%" height="25" class=body1
											style="text-align: left">
											<img src="<%=path %>/images/module/02a.gif">
											借阅归还&gt;&gt;图书借阅登记
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<table width="99%" border="0" cellspacing="0" cellpadding="0"
									align="center">
									<tr>
										<td width="189" height="25"
											background="<%=path %>/images/module/titleb_01.jpg"
											class="title1">
											读者信息
										</td>
										<td background="<%=path %>/images/module/titleb_02.jpg">
											&nbsp;
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
					<table width="80%" border="0" align="left" cellpadding="0"
						cellspacing="0" bordercolor="#ebebeb" borderColorLight="#ebebeb"
						borderColorDark="#ffffff" id="LM1">

						<TR align="right">
							<TD height=25 colspan="7" align="left" nowrap="nowrap"
								class="body" style="padding-left: 12px;">
								<strong>&nbsp;提示:</strong> 输入完借阅证号请按Enter键查看读者信息。
							</TD>
						</TR>

						<TR>
							<TD width="8%" height=25 align="right" nowrap="nowrap"
								style="padding-left: 12px;">
								借阅证号：
							</TD>
							<td width="12%" align="left">
								<input name="reader.cardNo" type="text" class="input2"
									id="reader.cardNo"  size="20">
								<input name="reader.id" type="text" class="input2"
									id="reader.id"  size="20">
							</td>
							<TD width="8%" height=25 align="right" nowrap="nowrap">
								读者姓名：
							</TD>
							<td width="12%" align="left">
								<input name="reader.readerName" type="text" class="input2"
									id="reader.readerName" size="22">
							</td>
							<TD width="8%" height=25 align="right" nowrap="nowrap">
								读者部门：
							</TD>
							<td width="12%" align="left">
								<input name="reader.readerUnits.unitName" type="text"
									class="input2" id="reader.readerUnits.unitName"
									size="22">
							</td>
							<TD width="200" height=25 align="center" nowrap="nowrap"
								rowspan="4">
								<img src="images/pc001.png" />
							</TD>
						</TR>

						<TR>
							<TD width="8%" height=25 align="right" nowrap="nowrap">
								读者类别：
							</TD>
							<td width="12%" align="left">
								<input name="reader.readerType.readerCateName" type="text"
									class="input2" id="reader.readerType.readerCateName"
									size="20">
							</td>
							<TD width="8%" height=25 align="right" nowrap="nowrap">
								借阅证状态：
							</TD>
							<td width="12%" align="left">
								<input name="reader.cardState.itemName" type="text"
									class="input2" id="reader.cardState.itemName"
									size="22">
							</td>
							<TD width="8%" height=25 align="right" nowrap="nowrap">
								读者性别：
							</TD>
							<td width="12%" align="left">
								<input name="reader.sex" type="text" class="input2"
									id="reader.sex"  size="8">
							</td>
						</TR>

						<TR>
							<TD width="8%" height=25 align="right" nowrap="nowrap">
								未还数量：
							</TD>
							<td width="12%" align="left">
								<input name="reader.borrowedQuantiy" type="text" class="input2"
									id="reader.borrowedQuantiy" size="8">
							</td>
							<TD width="8%" height=25 align="right" nowrap="nowrap">
								累计借阅次数：
							</TD>
							<td width="12%" align="left">
								<input name="reader.totalBQuantity" type="text" class="input2"
									id="reader.totalBQuantity" size="8">
							</td>
							<TD width="8%" height=25 align="right" nowrap="nowrap">
								余额：
							</TD>
							<td width="12%" align="left">
								<input name="reader.leftMoney" type="text" class="input2"
									id="reader.leftMoney" size="8">
							</td>
						</TR>

						<TR>
							<TD width="8%" height=25 align="right" nowrap="nowrap">
								数量限制：
							</TD>
							<td width="12%" align="left">
								<input name="reader.readerType.borrowedQuantity" type="text"
									class="input2" id="reader.readerType.borrowedQuantity"
									size="8">
							</td>
							<TD width="8%" height=25 align="right" nowrap="nowrap">
								租金：
							</TD>
							<td width="12%" align="left">
								<input name="reader.readerType.rent" type="text" class="input2"
									id="reader.readerType.rent" size="8">
							</td>
							<TD width="8%" height=25 align="right" nowrap="nowrap">
								借阅天数：
							</TD>
							<td width="12%" align="left">
								<input name="reader.readerType.borrowDays" type="text"
									class="input2" id="reader.readerType.borrowDays"
									size="8">
							</td>
						</TR>

					</TABLE>
				</td>
			</tr>
			<tr>
				<td valign="top">
					<table width="99%" border="0" align="center" cellpadding="0"
						cellspacing="0" bgcolor="#f1f8ff"
						style="border: 1px solid #2686d2; margin-top: 2px">
						<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="189" height="25"
											background="<%=path %>/images/module/titleb_01.jpg"
											class="title1">
											借阅列表
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
								<table width="98%" border="1" align="center" cellpadding="0"
									cellspacing="0" bordercolor="#bcc3c9"
									bordercolorlight="#bcc3c9" bordercolordark="#ffffff"
									bgcolor="#FFFFFF" style="margin-top: 5px">

									<tr>
										<td width="1200" height="280" align="left" valign="top">
											<div id="bookBorrowGrid"></div>
										</td>
									</tr>

								</table>

							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<script type="text/javascript"
			src="<%=path %>/js/borrowReturn/LoadReader.js"></script>

	</body>
</html>
