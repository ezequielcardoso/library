<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		    <link href="<%=path%>/css/style.css" type="text/css" rel="stylesheet">
		<title>广州市自来水综合业务管理平台</title>
     <script type="text/javascript" src="<%=path%>/common/datePicker/datePicker/calendar/WdatePicker.js">
     </script>
     </head>
	 <body>
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0" bgcolor="#dbecff">
			<tr>
				<td height="2" background="<%=path%>/images/module/bodybg.jpg"></td>
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
													<td width="81%" height="25" class=body1
														style="text-align: left">
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
								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="30" class="body1">
											<input type="button" class="btn"
												onClick="alert('图书增加成功.');window.location='<%=path %>/books/books_saveBook.action'"
												value="增 加">
											<input type="button" class="btn"
												onClick=
	document.getElementById('productInfor').reset();;
value="重 填">
											<input type="button" class="btn"
												onClick=
	window.history.back(-1);;
value="返 回">
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
														background="<%=path%>/images/module/titleb_01.jpg" class="title1">
														增加图书
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
														书名：					  </td>
<td align="left" bgcolor="#F4F5F9" colspan="3">
														<input name="book.bookName" type="text" id="bookName" size="62">
													</td>
												</tr>
												<tr
													onMouseOver=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onMouseOut=
	this.style.backgroundColor = '';;
>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														条形码：
												  </td>
													<td width="35%" align="left" bgcolor="#F4F5F9">
													  <input name="book.barCode" type="text" id="barcode" size="18">												  </td>
													<td width="15%" align="right" nowrap bgcolor="#F4F5F9">
														图书编号：													</td>
									  <td width="35%" height="30" align="left" bgcolor="#F4F5F9">
<input name="book.bookNo" type="text" id="bookNo" size="18">												  </td>
											  </tr>
												<tr
													onMouseOver=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onMouseOut=
	this.style.backgroundColor = '';;
>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														索书号：													</td>
											  <td align="left" bgcolor="#F4F5F9">
														<input name="book.searchBookId" type="text" id="searchBookId" size="18">
													</td>
													<td width="15%" align="right" nowrap bgcolor="#F4F5F9">
														出版社：													</td>
					  <td width="35%" height="30" align="left" bgcolor="#F4F5F9">
<select id="press" name="book.press">
															<option value="book.press.id">
																大连出版社xxxx
															</option>
															<option value="-1">
																中国出版社
															</option>
															<option value="0">
																河大出版色和
															</option>
														</select>													</td>
											  </tr>
												<tr
													onMouseOver=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onMouseOut=
	this.style.backgroundColor = '';;
>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														种次号：													</td>
											  <td align="left" bgcolor="#F4F5F9">
													<input name="book.speciesId" type="text" id="speciesId" size="18">
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														分类：													</td>
											  <td height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.bookLevel.shortName" type="text" id="bookLevel" size="18">
													</td>
												</tr>
												<tr
													onMouseOver=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onMouseOut=
	this.style.backgroundColor = '';;
>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														二级分类：													</td>
											  <td align="left" bgcolor="#F4F5F9">
													<input name="barcode" type="text" id="barcode" size="18">
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														出版日期：													</td>
											  <td height="30" align="left" bgcolor="#F4F5F9">
														<input type="text" name="book.publisherDate" id="publisherDate"
															onClick=
	WdatePicker();;
size="18">
													</td>
												</tr>


												<tr
													onMouseOver=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onMouseOut=
	this.style.backgroundColor = '';;
>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														版次：													</td>
											  <td align="left" bgcolor="#F4F5F9">
													<input name="book.revision" type="text" id="revision" size="18">
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														电子文档：													</td>
											  <td height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.electoricDoc" type="file" id="electoricDoc">
													</td>
												</tr>


												<tr
													onMouseOver=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onMouseOut=
	this.style.backgroundColor = '';;
>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														密级：													</td>
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
														数量：													</td>
											  <td height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.quantity" type="text" id="quantity" size="18">
													</td>
												</tr>

												<tr
													onMouseOver=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onMouseOut=
	this.style.backgroundColor = '';;
>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														页数：													</td>
											  <td align="left" bgcolor="#F4F5F9">
													<input name="book.pages" type="text" id="pages" size="18">
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														价格：													</td>
											  <td height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.price" type="text" id="price" size="18">
													</td>
												</tr>

												<tr
													onMouseOver=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onMouseOut=
	this.style.backgroundColor = '';;
>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														存放位置：													</td>
											  <td align="left" bgcolor="#F4F5F9">
													<input name="book.location" type="text" id="location" size="18">
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														状态：													</td>
											  <td height="30" align="left" bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="18">
													</td>
												</tr>

												<tr
													onMouseOver=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onMouseOut=
	this.style.backgroundColor = '';;
>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														ISBN：													</td>
											  <td align="left" bgcolor="#F4F5F9">
													<input name="book.ISBN" type="text" id="ISBN" size="18">
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														拼音：													</td>
											  <td height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.spell" type="text" id="spell" size="18">
													</td>
												</tr>

												<tr
													onMouseOver=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onMouseOut=
	this.style.backgroundColor = '';;
>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														类别：													</td>
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
														来源：													</td>
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

												<tr
													onMouseOver=
	this.style.backgroundColor = '#eff1f4';
	return true;;
onMouseOut=
	this.style.backgroundColor = '';;
>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														币种：													</td>
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
														捐赠人：													</td>
											  <td height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.donator" type="text" id="donator" size="18">
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
														简介：													</td>
					  <td height="80" colspan="3" align="left" bgcolor="#F4F5F9">
	<textarea cols="60" rows="4" id="bookDesc" name="book.bookDesc"
															style="border-color: #bcc3c9; border-width: 1px;">
                   </textarea>													</td>
											  </tr>


											</table>

									  </td>
									</tr>
								</table>

								<table width="99%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="30" align="center" class="body">&nbsp;
											
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