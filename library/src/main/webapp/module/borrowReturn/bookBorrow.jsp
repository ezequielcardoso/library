<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<%@ include file="/common/common.jsp"%>
		<%@ include file="/common/extInclude.jsp"%>
		<link href="<%=path %>/css/style.css" type="text/css" rel="stylesheet" />
		<title>图书馆管理系统</title>
		
		<script type="text/javascript" src="<%=path%>/js/borrowReturn/BorrowReturnOperation.js"></script>
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
													align="absmiddle">借阅归还</strong>
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
											background="<%=path %>/images/module/titleb_01.jpg" class="title1">
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
									id="reader.cardNo" value="<s:property value='reader.cardNo'/>" onblur="loadReader()" size="20">
							</td>
							<TD width="8%" height=25 align="right" nowrap="nowrap">
								读者姓名：
							</TD>
							<td width="12%" align="left">
								<input name="reader.readerName" type="text" class="input2"
									id="reader.readerName" value="<s:property value='reader.readerName'/>" size="22">
							</td>
							<TD width="8%" height=25 align="right" nowrap="nowrap">
								读者部门：
							</TD>
							<td width="12%" align="left">
								<input name="reader.readerUnits.unitName" type="text" class="input2"
									id="reader.readerUnits.unitName" value="<s:property value='reader.readerUnits.unitName'/>" size="22">
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
								<input name="reader.readerType.readerCateName" type="text" class="input2"
									id="reader.readerType.readerCateName" value="<s:property value='reader.readerType.readerCateName'/>" size="20">
							</td>
							<TD width="8%" height=25 align="right" nowrap="nowrap">
								借阅证状态：
							</TD>
							<td width="12%" align="left">
								<input name="reader.cardState.itemName" type="text" class="input2"
									id="reader.cardState.itemName" value="<s:property value='reader.cardState.itemName'/>" size="22">
							</td>
							<TD width="8%" height=25 align="right" nowrap="nowrap">
								读者性别：
							</TD>
							<td width="12%" align="left">
								<input name="reader.sex" type="text" class="input2"
									id="reader.sex" value="<s:property value='reader.sex'/>" size="8">
							</td>
						</TR>

						<TR>
							<TD width="8%" height=25 align="right" nowrap="nowrap">
								未还数量：
							</TD>
							<td width="12%" align="left">
								<input name="reader.borrowedQuantiy" type="text" class="input2"
									id="reader.borrowedQuantiy" value="<s:property value='reader.borrowedQuantiy'/>" size="8">
							</td>
							<TD width="8%" height=25 align="right" nowrap="nowrap">
								累计借阅次数：
							</TD>
							<td width="12%" align="left">
								<input name="reader.totalBQuantity" type="text" class="input2"
									id="reader.totalBQuantity" value="<s:property value='reader.totalBQuantity'/>" size="8">
							</td>
							<TD width="8%" height=25 align="right" nowrap="nowrap">
								余额：
							</TD>
							<td width="12%" align="left">
								<input name="reader.leftMoney" type="text" class="input2"
									id="reader.leftMoney" value="<s:property value='reader.leftMoney'/>" size="8">
							</td>
						</TR>

						<TR>
							<TD width="8%" height=25 align="right" nowrap="nowrap">
								数量限制：
							</TD>
							<td width="12%" align="left">
								<input name="reader.readerType.borrowedQuantity" type="text" class="input2"
									id="reader.readerType.borrowedQuantity" value="<s:property value='reader.readerType.borrowedQuantity'/>" size="8">
							</td>
							<TD width="8%" height=25 align="right" nowrap="nowrap">
								租金：
							</TD>
							<td width="12%" align="left">
								<input name="reader.readerType.rent" type="text" class="input2"
									id="reader.readerType.rent" value="<s:property value='reader.readerType.rent'/>" size="8">
							</td>
							<TD width="8%" height=25 align="right" nowrap="nowrap">
								借阅天数：
							</TD>
							<td width="12%" align="left">
								<input name="reader.readerType.borrowDays" type="text" class="input2"
									id="reader.readerType.borrowDays" value="<s:property value='reader.readerType.borrowDays'/>" size="8">
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
											background="<%=path %>/images/module/titleb_01.jpg" class="title1">
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

						<TR>
							<TD align="left" valign="top" class=body
								style="padding-left: 12px;">

								<input type="button" class="btnl" value="借出">
							</TD>
						</TR>
						<tr>
							<td valign="top">
								<table width="98%" border="1" align="center" cellpadding="0"
									cellspacing="0" bordercolor="#bcc3c9"
									bordercolorlight="#bcc3c9" bordercolordark="#ffffff"
									bgcolor="#FFFFFF" style="margin-top: 5px">
									<tr>
										<td width="3%" align="center" bgcolor="#F4F5F9">
											<input name="productSel" id="productSel" type="checkbox"
												onclick=
	selectAll(this.checked);;
/>
										</td>
										<td width="7%" align="center" bgcolor="#F4F5F9" class="body">
											条形码
										</td>
										<td width="16%" align="center" bgcolor="#F4F5F9" class="body">
											图书名称
										</td>
										<td width="9%" align="center" bgcolor="#F4F5F9" class="body">
											图书编号
										</td>
										<td width="13%" align="center" bgcolor="#F4F5F9" class="body">
											操作员编号
										</td>
										<td width="17%" align="center" bgcolor="#F4F5F9" class="body">
											操作人名称
										</td>
										<td width="4%" align="center" bgcolor="#F4F5F9" class="body">
											作者
										</td>
										<td width="7%" align="center" bgcolor="#F4F5F9" class="body">
											类别
										</td>
										<td width="8%" align="center" bgcolor="#F4F5F9" class="body">
											借阅天数
										</td>
										<td width="6%" align="center" bgcolor="#F4F5F9" class="body">
											租金
										</td>
										<td width="14%" align="center" bgcolor="#F4F5F9" class="body">
											<span id="TabState2" onclick=
	readySelect(2);;
nmouseover="this.style.cursor='pointer';">图书分类</span>
											<select name="stroState" size="1" id="stroState2"
												style="display: none"
												onblur="this.style.display='none'; document.getElementById('TabState2').style.display='';"
												onchange="selectRecord(this.value)">
												<option value="0">
													正常
												</option>
												<option value="1">
													返修
												</option>
												<option value="2">
													出库
												</option>
												<option value="3">
													已售
												</option>
												<option value="4" selected="selected">
													已录入
												</option>
												<option value="5">
													退库
												</option>
												<option value="6">
													退货
												</option>
											</select>
										</td>
									</tr>

									<tr align="center"
										onmouseover=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onmouseout=
	this.style.backgroundColor = '';;
style="cursor: pointer">
										<td width="3%" align="center">
											<input name="productSelector" id="product_001"
												type="checkbox" />
										</td>
										<td width="7%" class="body" ondblclick=
	
>
											<input name=txtkeyvalue type="text" class="input2"
												id="txtkeyvalue" value="KS EF001" size="10">
										</td>
										<td width="16%" class="body" ondblclick=
	
>
											图书
										</td>
										<td width="9%" class="body">
											KS EF001
										</td>
										<td width="13%" class="body">
											高等数学
										</td>
										<td width="17%" class="body" align="center">
											huan
										</td>
										<td class="body">
											高强
										</td>
										<td class="body">
											图书
										</td>
										<td class="body">
											18
										</td>
										<td class="body">
											0.2
										</td>
										<td align="center" class="user">
											<select name="state2">
												<option value="0">
													A
												</option>
												<option value="1">
													B
												</option>
												<option value="2">
													C
												</option>
												<option value="3">
													D
												</option>
												<option value="4">
													E
												</option>
												<option value="5">
													F
												</option>
												<option value="6" selected="selected">
													G
												</option>
											</select>
										</td>
									</tr>

									<tr align="center"
										onmouseover=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onmouseout=
	this.style.backgroundColor = '';;
style="cursor: pointer">
										<td width="3%" align="center">
											<input name="productSelector" id="product_001"
												type="checkbox" />
										</td>
										<td width="7%" class="body" ondblclick=
	
>
											<input name=txtkeyvalue type="text" class="input2"
												id="txtkeyvalue" value="KS EF001" size="10">
										</td>
										<td width="16%" class="body" ondblclick=
	
>
											图书
										</td>
										<td width="9%" class="body">
											KS EF001
										</td>
										<td width="13%" class="body">
											高等数学
										</td>
										<td width="17%" class="body" align="center">
											huan
										</td>
										<td class="body">
											高强
										</td>
										<td class="body">
											图书
										</td>
										<td class="body">
											18
										</td>
										<td class="body">
											0.2
										</td>
										<td align="center" class="user">
											<select name="state2">
												<option value="0">
													A
												</option>
												<option value="1">
													B
												</option>
												<option value="2">
													C
												</option>
												<option value="3">
													D
												</option>
												<option value="4">
													E
												</option>
												<option value="5">
													F
												</option>
												<option value="6" selected="selected">
													G
												</option>
											</select>
										</td>
									</tr>

									<tr align="center"
										onmouseover=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onmouseout=
	this.style.backgroundColor = '';;
style="cursor: pointer">
										<td width="3%" align="center">
											<input name="productSelector" id="product_001"
												type="checkbox" />
										</td>
										<td width="7%" class="body" ondblclick=
	
>
											<input name=txtkeyvalue type="text" class="input2"
												id="txtkeyvalue" value="KS EF001" size="10">
										</td>
										<td width="16%" class="body" ondblclick=
	
>
											图书
										</td>
										<td width="9%" class="body">
											KS EF001
										</td>
										<td width="13%" class="body">
											高等数学
										</td>
										<td width="17%" class="body" align="center">
											huan
										</td>
										<td class="body">
											高强
										</td>
										<td class="body">
											图书
										</td>
										<td class="body">
											18
										</td>
										<td class="body">
											0.2
										</td>
										<td align="center" class="user">
											<select name="state2">
												<option value="0">
													A
												</option>
												<option value="1">
													B
												</option>
												<option value="2">
													C
												</option>
												<option value="3">
													D
												</option>
												<option value="4">
													E
												</option>
												<option value="5">
													F
												</option>
												<option value="6" selected="selected">
													G
												</option>
											</select>
										</td>
									</tr>

									<tr align="center"
										onmouseover=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onmouseout=
	this.style.backgroundColor = '';;
style="cursor: pointer">
										<td width="3%" align="center">
											<input name="productSelector" id="product_001"
												type="checkbox" />
										</td>
										<td width="7%" class="body" ondblclick=
	
>
											<input name=txtkeyvalue type="text" class="input2"
												id="txtkeyvalue" value="KS EF001" size="10">
										</td>
										<td width="16%" class="body" ondblclick=
	
>
											图书
										</td>
										<td width="9%" class="body">
											KS EF001
										</td>
										<td width="13%" class="body">
											高等数学
										</td>
										<td width="17%" class="body" align="center">
											huan
										</td>
										<td class="body">
											高强
										</td>
										<td class="body">
											图书
										</td>
										<td class="body">
											18
										</td>
										<td class="body">
											0.2
										</td>
										<td align="center" class="user">
											<select name="state2">
												<option value="0">
													A
												</option>
												<option value="1">
													B
												</option>
												<option value="2">
													C
												</option>
												<option value="3">
													D
												</option>
												<option value="4">
													E
												</option>
												<option value="5">
													F
												</option>
												<option value="6" selected="selected">
													G
												</option>
											</select>
										</td>
									</tr>

									<tr align="center"
										onmouseover=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onmouseout=
	this.style.backgroundColor = '';;
style="cursor: pointer">
										<td width="3%" align="center">
											<input name="productSelector" id="product_001"
												type="checkbox" />
										</td>
										<td width="7%" class="body" ondblclick=
	
>
											<input name=txtkeyvalue type="text" class="input2"
												id="txtkeyvalue" value="KS EF001" size="10">
										</td>
										<td width="16%" class="body" ondblclick=
	
>
											图书
										</td>
										<td width="9%" class="body">
											KS EF001
										</td>
										<td width="13%" class="body">
											高等数学
										</td>
										<td width="17%" class="body" align="center">
											huan
										</td>
										<td class="body">
											高强
										</td>
										<td class="body">
											图书
										</td>
										<td class="body">
											18
										</td>
										<td class="body">
											0.2
										</td>
										<td align="center" class="user">
											<select name="state2">
												<option value="0">
													A
												</option>
												<option value="1">
													B
												</option>
												<option value="2">
													C
												</option>
												<option value="3">
													D
												</option>
												<option value="4">
													E
												</option>
												<option value="5">
													F
												</option>
												<option value="6" selected="selected">
													G
												</option>
											</select>
										</td>
									</tr>



								</table>
								<div id="dv_1" style="margin-top: 20px; display: none">
									<table width="99%" border="0" align="center" cellpadding="0"
										cellspacing="0">
										<tr>
											<td height="30" align="center" class="body">

												<table width="100%" height="100%" border="0" cellpadding="0"
													cellspacing="0" bgcolor="#dbecff">
													<tr>
														<td height="4" background="<%=path %>/images/module/bodybg.jpg"></td>
													</tr>
													<tr>
														<td valign="top">
															<table width="100%" border="0" cellpadding="0"
																cellspacing="0">

																<tr>
																	<td height="10" valign="top">
																		<table width="98%" border="0" align="center"
																			cellpadding="0" cellspacing="0" bordercolor="#ebebeb"
																			borderColorLight="#ebebeb" borderColorDark="#ffffff"
																			id="LM1">
																			<TR>
																				<TD align="left" class="body">
																					&nbsp;
																				</TD>
																			</TR>
																		</TABLE>
																	</td>
																</tr>
																<tr>
																	<td valign="top">
																		<table width="99%" border="0" align="center"
																			cellpadding="0" cellspacing="0" bgcolor="#f1f8ff"
																			style="border: 1px solid #2686d2; margin-top: 5px">
																			<tr>
																				<td>
																					<table width="100%" border="0" cellspacing="0"
																						cellpadding="0">
																						<tr>
																							<td height="20" class="title1"
																								style="color: #333333; font-size: 20px"
																								align="left" bgcolor="#F4F5F9">
																								图书信息&nbsp;&nbsp;
																							</td>
																						</tr>
																					</table>
																				</td>
																			</tr>

																			<form action="" method="post" id="productInfor"
																				name="productInfor">
																			<tr>
																				<td valign="top">

																					<table width="90%" border="1" align="center"
																						cellpadding="0" cellspacing="0"
																						bordercolor="#bcc3c9" borderColorLight="#bcc3c9"
																						borderColorDark="#ffffff" bgcolor="#FFFFFF"
																						style="margin-top: 5px">
																						<tr>
																							<td width="20%" align="right" bgcolor="#F4F5F9">
																								条形码:
																							</td>
																							<td width="30%" align="left" bgcolor="#F4F5F9"
																								style="padding-left: 50px;">
																								<input type="text" name="productName"
																									id="productName" value="KS EF001"
																									style="width: 200px; border-style: solid; border-color: #bcc3c9; border-width: 1px;" />
																							</td>
																							<td width="27%" align="right" bgcolor="#F4F5F9">
																								图书编号:
																							</td>
																							<td width="73%" align="left" bgcolor="#F4F5F9"
																								style="padding-left: 50px;">
																								<input type="text" name="productName"
																									id="productName" value="KS EF001"
																									style="width: 200px; border-style: solid; border-color: #bcc3c9; border-width: 1px;" />
																							</td>
																						</tr>
																						<tr
																							onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
																							onMouseOut="this.style.backgroundColor='';">
																							<td width="27%" align="right" bgcolor="#F4F5F9">
																								图书名称:
																							</td>
																							<td width="73%" align="left" bgcolor="#F4F5F9"
																								style="padding-left: 50px;">
																								<input type="text" size="25" value="高等数学" />
																							</td>
																							<td width="27%" align="right" bgcolor="#F4F5F9">
																								图书数量:
																							</td>
																							<td width="73%" align="left" bgcolor="#F4F5F9"
																								style="padding-left: 50px;">
																								<input type="text" size="25" name="" value="5" />
																							</td>
																						</tr>
																						<tr bgcolor="#FAFBFC"
																							onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
																							onMouseOut="this.style.backgroundColor='';">
																							<td width="27%" align="right" bgcolor="#F4F5F9">
																								图书分类:
																							</td>
																							<td width="73%" align="left" bgcolor="#F4F5F9"
																								style="padding-left: 50px;">

																								<select name="state2">
																									<option value="0">
																										A
																									</option>
																									<option value="1">
																										B
																									</option>
																									<option value="2">
																										C
																									</option>
																									<option value="3">
																										D
																									</option>
																									<option value="4">
																										E
																									</option>
																									<option value="5">
																										F
																									</option>
																									<option value="6" selected="selected">
																										G
																									</option>
																								</select>
																							</td>
																							<td width="27%" align="right" bgcolor="#F4F5F9">
																								出版社:
																							</td>
																							<td width="73%" align="left" bgcolor="#F4F5F9"
																								style="padding-left: 50px;">
																								<input type="text" readonly
																									style="width: 200px; border-style: solid; border-color: #bcc3c9; border-width: 1px;"
																									value="大连出版社" />
																							</td>
																						</tr>
																						<tr bgcolor="#FAFBFC"
																							onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
																							onMouseOut="this.style.backgroundColor='';">
																							<td width="27%" align="right" bgcolor="#F4F5F9">
																								图书描述:
																							</td>
																							<td width="73%" colspan="3" align="left"
																								bgcolor="#F4F5F9" style="padding-left: 50px;">
																								<textarea
																									style="width: 750px; border-style: solid; border-color: #bcc3c9; border-width: 1px;">无</textarea>
																							</td>
																						</tr>
																						<tr>
																							<td height="30" colspan="4" class="body1">
																								&nbsp;
																								<input type="button" class="btn"
																									onClick="document.getElementById('dv_1').style.display='none';"
																									value="关闭">
																								&nbsp;
																							</td>
																						</tr>
																					</table>

																				</td>
																			</tr>

																			</form>

																		</table>

																		<table width="99%" border="0" align="center"
																			cellpadding="0" cellspacing="0">
																			<tr>
																				<td height="30" align="center" class="body">
																					&nbsp;
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
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

	</body>
</html>
