<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<%@ include file="/common/common.jsp"%>
		<%@ include file="/common/extInclude.jsp"%>

		<link href="<%=path%>/css/style.css" type="text/css" rel="stylesheet" />
		<title>图书馆管理系统</title>
	</head>
	<body>
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0" bgcolor="#dbecff">
			<tr>
				<td height="4" background="<%=path%>/images/module/bodybg.jpg"></td>
			</tr>
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td height="10" valign="top">
								<table width="99%" border="0" align="center" cellpadding="0"
									cellspacing="0">

									<tr>
										<td>
											<table width="100%" border="0" align="center" cellpadding="0"
												cellspacing="0" class="title_border">
												<tr>
													<td width="19%" height="25" style="text-align: left">
														<strong>&nbsp;<img
																src="<%=path%>/images/module/cl0.gif" align="absmiddle">读者管理</strong>
													</td>
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
						<tr>
							<td height="10" valign="top">
								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="30" class="body1">
											<input type="button" class="btn"
												onClick="alert('读者添加成功.');window.location='readerList.html'"
												value="增加">
											<input type="button" class="btn"
												onClick=
	document.getElementById('productInfor').reset();;
value="重填">
											<input type="button" class="btn"
												onClick=
	window.history.back(-1);;
value="返回">
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td valign="top">
								<table width="99%" border="0" align="center" cellpadding="0"
									cellspacing="0" bgcolor="#f1f8ff"
									style="border: 1px solid #2686d2; margin-top: 0px">
									<tr>
										<td>
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="189" height="36"
														background="<%=path%>/images/module/titleb_01.jpg"
														class="title1">
														&nbsp;增加读者
													</td>
													<td height="30"
														background="<%=path%>/images/module/titleb_02.jpg">
														&nbsp;
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
											<table width="70%" border="1" align="left" cellpadding="0"
												cellspacing="0" bordercolor="#bcc3c9"
												borderColorLight="#bcc3c9" borderColorDark="#ffffff"
												bgcolor="#FFFFFF" style="margin-top: 5px">
												<tr
													onMouseOver=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onMouseOut=
	this.style.backgroundColor = '';;
>
													<td width="15%" height="30" align="right" nowrap
														bgcolor="#F4F5F9">
														读者编号：
													</td>
													<td width="35%" height="30" align="left" nowrap
														bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="15">
													</td>
													<td width="15%" align="right" nowrap bgcolor="#F4F5F9">
														读者卡号：
													</td>
													<td width="35%" height="30" align="left" nowrap
														bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="15">
													</td>
												</tr>

												<tr
													onMouseOver=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onMouseOut=
	this.style.backgroundColor = '';;
>
													<td width="15%" height="30" align="right" nowrap
														bgcolor="#F4F5F9">
														读者姓名：
													</td>
													<td width="35%" align="left" nowrap bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="15">
													</td>
													<td width="15%" align="right" nowrap bgcolor="#F4F5F9">
														联系电话：
													</td>
													<td width="35%" height="30" align="left" nowrap
														bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="15">
													</td>
												</tr>

												<tr
													onMouseOver=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onMouseOut=
	this.style.backgroundColor = '';;
>
													<td width="15%" height="30" align="right" nowrap
														bgcolor="#F4F5F9">
														性别：
													</td>
													<td width="35%" align="left" nowrap bgcolor="#F4F5F9">
														<input type="radio" name="gender" value="1"
															checked="checked" />
														<label for="radio3">
															男
														</label>
														<input type="radio" name="gender" value="2" />
														<label for="radio4">
															女
														</label>
													</td>
													<td width="15%" align="right" nowrap bgcolor="#F4F5F9">
														邮箱：
													</td>
													<td width="35%" height="30" align="left" nowrap
														bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="15">
													</td>
												</tr>

												<tr
													onMouseOver=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onMouseOut=
	this.style.backgroundColor = '';;
>
													<td width="15%" height="30" align="right" nowrap
														bgcolor="#F4F5F9">
														分类：
													</td>
													<td width="35%" align="left" nowrap bgcolor="#F4F5F9">
														<select id="state" name="state"
															style="border-style: solid; border-color: #bcc3c9; width: 80px;">
															<option value="1">
																学生
															</option>
															<option value="-1">
																教师
															</option>
															<option value="0">
																临时工
															</option>
														</select>
													</td>
													<td width="15%" align="right" nowrap bgcolor="#F4F5F9">
														有效证件：
													</td>
													<td width="35%" height="30" align="left" nowrap
														bgcolor="#F4F5F9">
														<select id="state" name="state"
															style="border-style: solid; border-color: #bcc3c9; width: 80px;">
															<option value="1">
																学生证
															</option>
															<option value="-1">
																身份证
															</option>
															<option value="0">
																驾驶本
															</option>
														</select>
													</td>
												</tr>

												<tr
													onMouseOver=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onMouseOut=
	this.style.backgroundColor = '';;
>
													<td width="15%" height="30" align="right" nowrap
														bgcolor="#F4F5F9">
														部门：
													</td>
													<td width="35%" align="left" nowrap bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="15">
													</td>
													<td width="15%" align="right" nowrap bgcolor="#F4F5F9">
														班级：
													</td>
													<td width="35%" height="30" align="left" nowrap
														bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="15">
													</td>
												</tr>

												<tr
													onMouseOver=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onMouseOut=
	this.style.backgroundColor = '';;
>
													<td width="15%" height="30" align="right" nowrap
														bgcolor="#F4F5F9">
														系：
													</td>
													<td width="35%" align="left" nowrap bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="15">
													</td>
													<td width="15%" align="right" nowrap bgcolor="#F4F5F9">
														拼音：
													</td>
													<td width="35%" height="30" align="left" nowrap
														bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="15">
													</td>
												</tr>
												<tr
													onMouseOver=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onMouseOut=
	this.style.backgroundColor = '';;
>
													<td height="60" align="right" nowrap bgcolor="#F4F5F9">
														简介：
													</td>
													<td height="80" colspan="3" align="left" bgcolor="#F4F5F9">
														<textarea cols="68" rows="4"
															style="border-color: #bcc3c9; border-width: 1px;">
                   </textarea>
													</td>

												</tr>

											</table>
										</td>
									</tr>
								</table>

								<table width="99%" border="0" align="center" cellpadding="0"
									cellspacing="0">
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

	</body>
</html>
