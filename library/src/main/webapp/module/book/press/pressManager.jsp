<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="/common/common.jsp"%>
<%@ include file="/common/extInclude.jsp"%>
<link href="<%=path%>/css/style.css" type="text/css" rel="stylesheet" />
<title>"广水用水"终端服务综合业务管理平台</title>
        <link rel="stylesheet" type="text/css" href="<%=path %>/common/extjs3.2/resources/css/ext-all.css" />
		<script type="text/javascript" src="<%=path %>/common/extjs3.2/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="<%=path %>/common/extjs3.2/ext-basex.js"></script>
		<script type="text/javascript" src="<%=path %>/common/extjs3.2/ext-all.js"></script>
<script type="text/javascript" src="<%=path%>/js/book/press/Press.js"></script>
<script type="text/javascript"
	src="<%=path%>/js/book/press/PressGridPanel.js"></script>
</head>
<body>
<table width="100%" height="100%" border="0" cellpadding="0"
	cellspacing="0" bgcolor="#dbecff">
	<tr id="ye">
		<td height="4" background="<%=path%>/images/module/bodybg.jpg"></td>
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
								<td width="19%" height="25" style="text-align: left"><strong>&nbsp;<img
									align="absmiddle" src="<%=path%>/images/module/cl0.gif">
								书刊管理</strong></td>
								<td width="81%" height="25" class=body1 style="text-align: left">
								<img src="<%=path%>/images/module/02a.gif"> 当前位置：书刊管理
								&gt;&gt;出版社管理</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr id="yy">
				<td height="10" valign="top">
				<table width="50%" border="0" align="left" cellpadding="0"
					cellspacing="0" bordercolor="#ebebeb" borderColorLight="#ebebeb"
					borderColorDark="#ffffff" id="LM1">


					<TR>
						<TD height=25 align="right" valign="top" nowrap class=body
							width="10%" style="padding-left: 8px;"><INPUT type=radio
							CHECKED value=1 name="units"> <LABEL for=radio3>模糊</LABEL>
						</TD>
						<TD height=25 align="right" valign="top" nowrap class=body
							width="10%"><INPUT type=radio value=2 name="units">
						<LABEL for=radio4>精确</LABEL></TD>
						<TD height=25 align="right" valign="center" nowrap class=body>
						出版社代码：</TD>
						<TD height=25 align="left" valign="center" nowrap class=body
							width="50"><input name=txtkeyvalue2 type="text"
							class="input2" id="txtkeyvalue2" value="" size="20"></TD>
					</TR>
					<TR>
						<TD height=25 align="right" valign="top" nowrap class=body
							width="10%" style="padding-left: 8px;"><INPUT type=radio
							CHECKED value=1 name="units"> <LABEL for=radio3>模糊</LABEL>
						</TD>
						<TD height=25 align="right" valign="top" nowrap class=body><INPUT
							type=radio value=2 name="units"> <LABEL for=radio4>精确</LABEL>
						</TD>
						<TD width="20%" height=25 align="right" valign="center" nowrap
							class=body>出版社名称：</TD>
						<TD height=25 align="left" valign="center" nowrap class=body
							width="50"><input name=txtkeyvalue2 type="text"
							class="input2" id="txtkeyvalue2" value="" size="20"></TD>
					</TR>
					<TR>
						<TD height=25 align="right" valign="top" nowrap class=body
							width="10%" style="padding-left: 8px;"><INPUT type=radio
							CHECKED value=1 name="units"> <LABEL for=radio3>模糊</LABEL>
						</TD>
						<TD height=25 align="right" valign="top" nowrap class=body><INPUT
							type=radio value=2 name="units"> <LABEL for=radio4>精确</LABEL>
						</TD>
						<TD width="20%" height=25 align="right" valign="center" nowrap
							class=body>出版社地：</TD>
						<TD height=25 align="left" valign="center" nowrap class=body>
						<input name=txtkeyvalue2 type="text" class="input2"
							id="txtkeyvalue2" value="" size="20"></TD>
					</TR>
				</TABLE>
				</td>
			</tr>
			<tr id="yb">
				<td height="0" valign="top">
				<table width="99%" border="0" align="center" cellpadding="0"
					cellspacing="0" bgcolor="#f1f8ff"
					style="border: 1px solid #2686d2; margin-top: 0px">
					<tr>
						<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="189" height="33"
									background="<%=path%>/images/module/titleb_01.jpg"
									class="title1">查询列表</td>
								<td background="<%=path%>/images/module/titleb_02.jpg">&nbsp;


								</td>
								<td width="213" align="right"
									background="<%=path%>/images/module/titleb_03.jpg"
									style="padding-bottom: 10px">&nbsp;&nbsp;</td>
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
								<td width="100" height="300" align="left" valign="top">
								   <div id="pressGridPanel"></div>
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
