<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<%@ include file="/common/common.jsp"%>
		<%@ include file="/common/extInclude.jsp"%>
		<link href="<%=path %>/css/style.css" type="text/css" rel="stylesheet" />
		<title>图书馆管理系统</title>
		<script type="text/javascript" src="<%=path %>/js/common/common.js"></script>
		<script type="text/javascript" src="<%=path%>/js/combobox/ArrayLocalComboBox.js"></script>
		<script type="text/javascript" src="<%=path %>/js/borrowReturn/MagazineReturn.js"></script>
		<script type="text/javascript" src="<%=path %>/js/borrowReturn/MagazineReturnGridPanel.js"></script>

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
							<td>
								<table width="100%" border="0" align="center" cellpadding="0"
									cellspacing="0" class="title_border">
									<tr>
										<td width="19%" height="25" style="text-align: left">
											<strong>&nbsp;<img src="<%=path %>/images/module/cl0.gif"
													align="absmiddle">书刊归还</strong>
										</td>
										<td width="81%" height="25" class=body1
											style="text-align: left">
											<img src="<%=path %>/images/module/02a.gif">
											书刊归还&gt;&gt;期刊归还
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
											background="<%=path %>/images/module/titleb_01.jpg" class="title1">
											归还列表
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
					</table>
				</td>
			</tr>
			<tr>
				<td valign="top">
					<table width="98%" border="0" align="left" cellpadding="0"
						cellspacing="0" bordercolor="#ebebeb" borderColorLight="#ebebeb"
						borderColorDark="#ffffff" id="LM1">

						<tr>
							<td width="1200" height="500" align="left" valign="top">
								<div id="magazineReturnGrid"></div>
							</td>
						</tr>
						
						
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
