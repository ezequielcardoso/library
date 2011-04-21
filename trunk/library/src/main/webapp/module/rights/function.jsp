<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<%@ include file="/common/common.jsp"%>
		<%@ include file="/common/extInclude.jsp"%>
		<title>图书馆管理系统</title>
		<link rel="stylesheet" type="text/css" href="<%=path %>/common/extjs3.2/examples/ux/treegrid/treegrid.css" rel="stylesheet" /> 
		<script type="text/javascript" src="<%=path %>/common/extjs3.2/examples/ux/treegrid/TreeGridSorter.js"></script> 
        <script type="text/javascript" src="<%=path %>/common/extjs3.2/examples/ux/treegrid/TreeGridColumnResizer.js"></script> 
        <script type="text/javascript" src="<%=path %>/common/extjs3.2/examples/ux/treegrid/TreeGridNodeUI.js"></script> 
        <script type="text/javascript" src="<%=path %>/common/extjs3.2/examples/ux/treegrid/TreeGridLoader.js"></script> 
        <script type="text/javascript" src="<%=path %>/common/extjs3.2/examples/ux/treegrid/TreeGridColumns.js"></script> 
		<script type="text/javascript" src="<%=path %>/js/rights/function/Function.js"></script>
		<script type="text/javascript" src="<%=path %>/js/rights/function/FunctionTreeGrid.js"></script>
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
																src="<%=path %>/images/module/cl0.gif">系统权限/strong>
													</td>
													<td width="81%" height="25" class=body1
														style="text-align: left">
														<img src="<%=path%>/images/module/02a.gif">
														当前位置：系统权限 &gt;&gt;资源管理
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
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
														资源管理¨
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
														<div id="functionTreeGrid"></div>
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
