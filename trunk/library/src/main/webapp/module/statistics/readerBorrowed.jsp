<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<%@ include file="/common/common.jsp"%>
		<%@ include file="/common/extInclude.jsp"%>
		<link href="<%=path %>/css/style.css" type="text/css" rel="stylesheet" />
		<title>图书馆管理系统</title>
		<script type="text/javascript" src="<%=path %>/js/statistics/ReaderBorrowedStatic.js"></script>
		<script type="text/javascript" src="<%=path %>/js/statistics/ReaderBorrowedStaticGridPanel.js"></script>
	</head>
	<body bgcolor="#dbecff">
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0" bgcolor="#dbecff">
			<tr>
				<td height="4" background="<%=path %>/images/module/bodybg.jpg"></td>
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
											background="<%=path %>/images/module/titleb_01.jpg" class="title1">
											读者信息列表
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
                                      	<td width="1000" height="300" align="left" valign="top">
														<div id="readerStaticGrid"></div>
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
