<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<%@ include file="/common/common.jsp"%>
		<%@ include file="/common/extInclude.jsp"%>
		
		<link href="<%=path%>/css/style.css" type="text/css"rel="stylesheet" />
		<title>图书馆管理系统</title>
		 <script type="text/javascript" src="<%=path %>/js/tree/BaseTree.js"></script>
         <script type="text/javascript" src="<%=path %>/js/tree/BaseCheckTree.js"></script>
		 <script type="text/javascript" src="<%=path%>/js/common/common.js"></script>
		 <script type="text/javascript" src="<%=path%>/js/reader/ReaderUnitTreePanel.js"></script>
		 <script type="text/javascript" src="<%=path%>/js/reader/UnitForm.js"></script>
		 <script type="text/javascript" src="<%=path%>/js/combobox/ArrayLocalComboBox.js"></script>
		 <script type="text/javascript" src="<%=path %>/js/reader/ReaderUnitsCheckTree.js"></script>
         <script type="text/javascript" src="<%=path %>/js/reader/ReaderUnitsCheckTreeWindow.js"></script>
		 <script type="text/javascript" src="<%=path%>/js/reader/Reader.js"></script>
		 <script type="text/javascript" src="<%=path%>/js/reader/ReaderGridPanel.js"></script>
	    
   </head>
	<body>
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0" bgcolor="#dbecff">
				<tr id="ye" >
				<td height="4" background="<%=path%>/images/module/bodybg.jpg"></td>
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
																src="<%=path%>/images/module/cl0.gif"> </strong><strong>读者管理</strong></td>
													<td width="81%" height="25" class=body1
														style="text-align: left">
														<img src="<%=path%>/images/module/02a.gif">
														当前位置：读者管理 &gt;&gt;读者维护
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr  id="yb" >
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
														background="<%=path%>/images/module/titleb_01.jpg" class="title1">
														查询列表
													</td>
													<td background="<%=path%>/images/module/titleb_02.jpg">&nbsp;
													</td>
													<td width="213" align="right"
														background="<%=path%>/images/module/titleb_03.jpg"
														style="padding-bottom: 10px">
														&nbsp;&nbsp;
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td valign="top">
											<table id="tab1" width="98%" border="1" align="center"
												cellpadding="0" cellspacing="0" bordercolor="#bcc3c9"
												borderColorLight="#bcc3c9" borderColorDark="#ffffff"
												bgcolor="#FFFFFF" style="margin-top: 5px">
												<tr>
                                                    <td width="200" height="500" align="left" valign="top">
														<div id="readerUnitsTree"></div>
													</td>
													<td width="800" height="500" align="left" valign="top">
														<div id="readerGrid"></div>
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
