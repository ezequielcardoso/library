<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<%@ include file="/common/common.jsp"%>
		<%@ include file="/common/extInclude.jsp"%>
		
		<link href="<%=path%>/css/style.css" type="text/css"rel="stylesheet" />
		<title>图书馆管理系统</title>
	    <script type="text/javascript" src="<%=path%>/common/datePicker/datePicker/calendar/WdatePicker.js">
        </script>
	    <script type="text/javascript" src="<%=path%>/js/common/common.js"></script>
		<script type="text/javascript" src="<%=path%>/js/reader/ReaderCard.js"></script>
		<script type="text/javascript" src="<%=path%>/js/reader/ReaderCardGridPanel.js"></script>
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
																src="<%=path%>/images/module/cl0.gif"> 读者管理</strong>
													</td>
													<td width="81%" height="25" class=body1
														style="text-align: left">
														<img src="<%=path%>/images/module/02a.gif">
														当前位置：读者管理 &gt;&gt;借阅证管理
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr id="yy" >
							<td height="10" valign="top">
								<table width="60%" border="0" align="left" cellpadding="0"
									cellspacing="0" bordercolor="#ebebeb"
									borderColorLight="#ebebeb" borderColorDark="#ffffff" id="LM1">
									
								      <TR >
									   <TD  height=25 align="right" nowrap="nowrap"  style="padding-left:10px;">
										  <INPUT type=radio CHECKED value=1 name="series"> 模糊                </TD>
									   <td  align="right" nowrap>
										 <INPUT type=radio value=2 name="series"> 精确
										</td>
										<TD  height=25 align="right"  nowrap="nowrap"><span class="body">单位</span>：              </TD>
									   <td   align="left" nowrap >
										<input name=txtkeyvalue type="text" class="input2"
												id="txtkeyvalue" value="" size="15">
										</td>
										<TD  height=25 align="right" nowrap="nowrap">
										   <INPUT type=radio CHECKED value=1 name="serie"> 模糊:                </TD>
									   <td  align="right" nowrap>
										<INPUT type=radio value=2 name="serie" size="30"> 精确
										</td>
										<TD    height=25 align="right" nowrap="nowrap"><span class="body">条形码</span>：              </TD>
									    <td  align="left" nowrap>
										<input name=txtkeyvalue type="text" class="input2"
												id="txtkeyvalue" value="" size="15">
										</td>
									 </TR>
									 
									  <TR >
									   <TD  height=25 align="right" nowrap="nowrap">
										  <INPUT type=radio CHECKED value=1 name="series"> 模糊                </TD>
									   <td  align="right" nowrap>
										 <INPUT type=radio value=2 name="series" > 精确
										</td>
										<TD   height=25 align="right" nowrap="nowrap"><span class="body">号码</span>：              </TD>
									   <td  align="left" nowrap>
										<input name=txtkeyvalue type="text" class="input2"
												id="txtkeyvalue" value="" size="15">
										</td>
										<TD  height=25 align="right" nowrap="nowrap">
										   <INPUT type=radio CHECKED value=1 name="serie"> 模糊:                </TD>
									   <td align="right" nowrap>
										<INPUT type=radio value=2 name="serie" size="30"> 精确
										</td>
										<TD    height=25 align="right" nowrap="nowrap"><span class="body">姓名</span>：              </TD>
									    <td  align="left" nowrap>
										<input name=txtkeyvalue type="text" class="input2"
												id="txtkeyvalue" value="" size="15">
										</td>
									 </TR>
							        <TR >
									   <TD  height=25 align="right" nowrap="nowrap" colspan="2" style="padding-left:22px;">
										 <input type="checkbox" name="proSelect">
										 <span class="body">办证时间</span>：     </TD>
									   <TD   height=25 align="right" nowrap>
										从&nbsp;
									   </TD>
									    <td  align="left" nowrap>
										<input name="" type="text" class="input2"
												id="txtkeyvalue" value="2010-2-2" size="15" onClick="WdatePicker();" >
										</td>
										  <td align="right" nowrap colspan="3">
										        到
									</td>
										  <td align="left" nowrap >
										       <input name="" type="text" class="input2"
												id="txtkeyvalue" value="2010-2-2" size="15" onClick="WdatePicker();" >
										</td>
								 </TR>
								</TABLE>
							</td>
						</tr>
						<tr  id="yb" >
							<td height="0" valign="top">
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
											<table id="tab1" width="97%" border="1" align="center"
												cellpadding="0" cellspacing="0" bordercolor="#bcc3c9"
												borderColorLight="#bcc3c9" borderColorDark="#ffffff"
												bgcolor="#FFFFFF" style="margin-top: 5px">
									             <tr>
												     <td width="1000" height="300" align="left" valign="top">
														<div id="readerCardGrid"></div>
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
