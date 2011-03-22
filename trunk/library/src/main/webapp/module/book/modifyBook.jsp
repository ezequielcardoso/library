<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<%@include file="/common/common.jsp"%>
		<link href="<%=path%>/css/style.css" type="text/css"rel="stylesheet" />
		<title>图书馆管理系统</title>
		<script type="text/javascript"
			src="<%=path%>/common/datePicker/datePicker/calendar/WdatePicker.js">
  </script>
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
														<strong>&nbsp;<img src="<%=path%>/images/module/cl0.gif"
																align="absmiddle">书刊管理</strong>
													</td>
													<td width="81%" height="25" class=body1 style="text-align: left">
														<img src="<%=path%>/images/module/02a.gif">
														当前位置：书刊管理 &gt;&gt;图书基本管理
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
								<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
									<tr>
										<td height="30" class="body1">
											<input type="button" class="btn"
												onClick="alert('图书修改成功.');window.location='<%=path%>/books/modifyBook.action'"
												value="修 改">
											<input type="button" class="btn" document.getElementById('productInfor').reset();; value="重填">
											<input type="button" class="btn" window.history.back(-1);" value="返回">
										</td>
									</tr>
								</table>
						</tr>
						<tr>
							<td valign="top">
								<table width="99%" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#f1f8ff"
									     style="border: 1px solid #2686d2; margin-top: 0px">
									<tr>
										<td>
											<table width="100%" border="0" cellspacing="0"	cellpadding="0">
												<tr>
													<td width="189" height="36" background="<%=path%>/images/module/titleb_01.jpg" class="title1">
														修改图书
													</td>
													<td background="<%=path%>/images/module/titleb_02.jpg">
														&nbsp;
													</td>
													<td width="213" align="right" background="<%=path%>/images/module/titleb_03.jpg" style="padding-bottom: 10px">
														&nbsp;&nbsp;
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td valign="top">
											<table width="70%" border="1" align="left" cellpadding="0"
												cellspacing="0" bordercolor="#bcc3c9" borderColorLight="#bcc3c9" borderColorDark="#ffffff"
												bgcolor="#FFFFFF" style="margin-top: 5px">
												<tr onMouseOver=this.style.backgroundColor ='#eff1f4';return true;
													onMouseOut=this.style.backgroundColor= '';>
													<td width="15%" height="30" align="right" nowrap  bgcolor="#F4F5F9">
														书名：
													</td>
													<td align="left" bgcolor="#F4F5F9" colspan="3">
														<input name="barcode" type="text" id="barcode" size="62"
															value="">
															<s:property value="book.bookName"/>
													</td>
												</tr>
												<tr onMouseOver=this.style.backgroundColor ='#eff1f4';return true;
													onMouseOut=this.style.backgroundColor= '';>
													<td width="15%" height="30" align="right" nowrap
														bgcolor="#F4F5F9">
														条形码：
													</td>
													<td width="35%" align="left" bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="18"
															value="KF ES001" disabled>
													</td>
													<td width="15%" align="right" nowrap bgcolor="#F4F5F9">
														图书编号：
													</td>
													<td width="35%" height="30" align="left" nowrap
														bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="18"
															value="B001">
													</td>
												</tr>
												<tr onMouseOver=this.style.backgroundColor ='#eff1f4';return true;
													onMouseOut=this.style.backgroundColor= '';>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														索书号：
													</td>
													<td width="30%" align="left" bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="18"
															value="b001">
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														出版社：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<select id="state" name="state">
															<option value="1">
																大连出版社xxxx
															</option>
															<option value="-1">
																中国出版社
															</option>
															<option value="0">
																河大出版色和
															</option>
														</select>
													</td>
												</tr>
												<tr onMouseOver=this.style.backgroundColor ='#eff1f4';return true;
													onMouseOut=this.style.backgroundColor= '';>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														种次号：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="18"
															value="001">
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														分类：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="18"
															value="数学">
													</td>
												</tr>
												<tr onMouseOver=this.style.backgroundColor ='#eff1f4';return true;
													onMouseOut=this.style.backgroundColor= '';>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														二级分类：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="18"
															value="难">
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														出版日期：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input type="text" value="2010-2-2"
															onClick=WdatePicker();size="18">
													</td>
												</tr>
												<tr onMouseOver=this.style.backgroundColor ='#eff1f4';return true;
													onMouseOut=this.style.backgroundColor= '';>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														版次：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="18"
															value="2">
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														电子文档：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="barcode" type="file" id="barcode">
													</td>
												</tr>
												<tr onMouseOver=this.style.backgroundColor ='#eff1f4';return true;
													onMouseOut=this.style.backgroundColor= '';>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														密级：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<select id="state" name="state"
															style="border-style: solid; border-color: #bcc3c9; width: 100px;">
															<option value="1">
																秘密
															</option>
															<option value="-1">
																普通
															</option>
															<option value="0">
																一般
															</option>
														</select>
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														数量：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="18"
															value="2">
													</td>
												</tr>
												<tr onMouseOver=this.style.backgroundColor ='#eff1f4';return true;
													onMouseOut=this.style.backgroundColor= '';>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														页数：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="18"
															value="98">
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														价格：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="18"
															value="98">
													</td>
												</tr>
												<tr onMouseOver=this.style.backgroundColor ='#eff1f4';return true;
													onMouseOut=this.style.backgroundColor= '';>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														存放位置：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="18"
															value="A区 b号柜">
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														状态：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="18"
															value="正常">
													</td>
												</tr>
												<tr onMouseOver=this.style.backgroundColor ='#eff1f4';return true;
													onMouseOut=this.style.backgroundColor= '';>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														ISBN：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="18"
															value="afdsg23gdsa">
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														拼音：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="18"
															value="abc">
													</td>
												</tr>
												<tr onMouseOver=this.style.backgroundColor ='#eff1f4';return true;
													onMouseOut=this.style.backgroundColor= '';>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														类别：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<select id="state" name="state"
															style="border-style: solid; border-color: #bcc3c9; width: 100px;">
															<option value="1">
																计算机
															</option>
															<option value="-1">
																土木工程
															</option>
															<option value="0">
																医药
															</option>
														</select>
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														来源：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<select id="state" name="state"
															style="border-style: solid; border-color: #bcc3c9; width: 100px;">
															<option value="1">
																捐赠
															</option>
															<option value="-1">
																购买
															</option>
														</select>
													</td>
												</tr>
												<tr onMouseOver=this.style.backgroundColor ='#eff1f4';return true;
													onMouseOut=this.style.backgroundColor= '';>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														币种：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<select id="state" name="state"
															style="border-style: solid; border-color: #bcc3c9; width: 100px;">
															<option value="1">
																人名币
															</option>
															<option value="-1">
																美元
															</option>
															<option value="0">
																日元
															</option>
														</select>
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														捐赠人：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="18"
															value="huan">
													</td>
												</tr>
												<tr onMouseOver=this.style.backgroundColor ='#eff1f4';return true;
													onMouseOut=this.style.backgroundColor= '';>
													<td height="60" align="right" nowrap bgcolor="#F4F5F9">
														简介：
													</td>
													<td height="80" colspan="3" align="left" bgcolor="#F4F5F9">
														<textarea cols="60" rows="4"
															style="border-color: #bcc3c9; border-width: 1px;">
                                                           该生无数次给学校图书馆捐赠图书，值得大家学习，是时代的楷模，人民的榜样，党的好儿子，可惜还是个团员</textarea>
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