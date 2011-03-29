<%@ page language="java" import="java.util.*;" pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		
		<%@ include file="/common/common.jsp"%>
		<%@ include file="/common/extInclude.jsp"%>
		
     	<title>图书馆管理系统</title>
		
		<script type="text/javascript" src="<%=path %>/common/datePicker/datePicker/calendar/WdatePicker.js">
	    </script>
	    <script type="text/javascript" src="<%=path %>/js/book/BookOperation.js">
	    </script>
	    <script type="text/javascript">
		     //摁下回车键时，光标会自动下移
			 function document.onkeydown(){
			    if(window.event.keyCode == 13 && window.event.srcElement.type != "button"){
			       window.event.keyCode = 9; 
			   }
		     } 
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
														<strong>&nbsp;<img
																src="<%=path%>/images/module/cl0.gif"
																align="absmiddle">书刊管理</strong>
													</td>
													<td width="81%" height="25" class=body1
														style="text-align: left">
														<img src="<%=path %>/images/module/02a.gif">
														当前位置：书刊管理 &gt;&gt;图书基本管理
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
			<form  enctype="multipart/form-data" name="addBook" method="post" action="<%=path%>/books/saveBook.action">
						<tr>
							<td height="10" valign="top">
								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="30" class="body1">
											<input type="submit" class="btn" value="增 加">
											<!-- 
											<input type="button" class="btn" onClick="saveBook()"
												value="增 加">
											 -->
											<input type="reset" " class="btn" value="重填">
											<input type="button" class="btn"
												onClick="window.location='<%=path%>/books/bookMain.action'"
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
												    <td width="189" height="36" background="<%=path%>/images/module/titleb_01.jpg"
														class="title1">
														增加图书
													</td>
													<td background="<%=path%>/images/module/titleb_02.jpg">
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
												<tr onMouseOver=this.style.backgroundColor
													= '#eff1f4';return true;onMouseOut=this.style.backgroundColor='';>
													<td width="15%" height="30" align="right" nowrap bgcolor="#F4F5F9">
														书名：
													</td>
													<td align="left" bgcolor="#F4F5F9" colspan="3">
														<input name="book.bookName" type="text" id="bookName" size="62">
													</td>
												</tr>
                                                <tr onMouseOver=this.style.backgroundColor = '#eff1f4';return true;
												          onMouseOut=this.style.backgroundColor='';>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														条形码：
													</td>
													<td width="35%" align="left" bgcolor="#F4F5F9">
														<input name="book.barCode" type="text" id="barcode"
															size="18">
													</td>
													<td width="15%" align="right" nowrap bgcolor="#F4F5F9">
														图书编号：
													</td>
													<td width="35%" height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.bookNo" type="text" id="bookNo"
															size="18">
													</td>
												</tr>
                                                <tr onMouseOver=this.style.backgroundColor = '#eff1f4';return true;
												          onMouseOut=this.style.backgroundColor='';>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														索书号：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<input name="book.searchBookId" type="text"
															id="searchBookId" size="18">
													</td>
													<td width="15%" align="right" nowrap bgcolor="#F4F5F9">
														出版社：
													</td>
													<td width="35%" height="30" align="left" bgcolor="#F4F5F9">
														<select>
														   <s:iterator value="presses" var="press">
															    <option value="<s:property value="#press.id"/>">
														           <s:property value="#press.pressName"/>
														    	</option>
															</s:iterator>
														</select>
													</td>
												</tr>
                                                <tr onMouseOver=this.style.backgroundColor = '#eff1f4';return true;
												          onMouseOut=this.style.backgroundColor='';>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														种次号：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<input name="book.speciesId" type="text" id="speciesId"
															size="18">
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														分类：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<select>
														   <s:iterator value="categorys" var="category">
															<option value="<s:property value="#category.categoryId"/>">
														      <s:property value="#category.categoryName"/>
															</option>
															</s:iterator>
														</select>
													</td>
												</tr>
                                                <tr onMouseOver=this.style.backgroundColor = '#eff1f4';return true;
												          onMouseOut=this.style.backgroundColor='';>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														二级分类：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<input name="barcode" type="text" id="barcode" size="18">
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														出版日期：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input type="text" name="book.publisherDate"
															id="publisherDate" onClick=WdatePicker(); size="18">
													</td>
												</tr>


                                                <tr onMouseOver=this.style.backgroundColor = '#eff1f4';return true;
												          onMouseOut=this.style.backgroundColor='';>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														版次：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<input name="book.revision" type="text" id="revision" size="18">
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														电子文档：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.fileName" type="file" id="fileName">
													</td>
												</tr>
                                                <tr onMouseOver=this.style.backgroundColor = '#eff1f4';return true;
												          onMouseOut=this.style.backgroundColor='';>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														密级：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<select>
														   <s:iterator value="securityViews" var="securityView">
															<option value="<s:property value="#securityView.key"/>">
														      <s:property value="#securityView.value"/>
															</option>
															</s:iterator>
														</select>
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														数量：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.quantity" type="text" id="quantity"
															size="18">
													</td>
												</tr>

                                                <tr onMouseOver=this.style.backgroundColor = '#eff1f4';return true;
												          onMouseOut=this.style.backgroundColor='';>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														页数：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<input name="book.pages" type="text" id="pages" size="18">
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														价格：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.price" type="text" id="price" size="18">
													</td>
												</tr>

                                                <tr onMouseOver=this.style.backgroundColor = '#eff1f4';return true;
												          onMouseOut=this.style.backgroundColor='';>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														存放位置：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<input name="book.location" type="text" id="location" size="18">
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														图书状态：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<select>
														   <s:iterator value="bookStateViews" var="bookStateView">
															<option value="<s:property value="#bookStateView.key"/>">
														      <s:property value="#bookStateView.value"/>
															</option>
															</s:iterator>
														</select>
													</td>
												</tr>
												<tr onMouseOver=this.style.backgroundColor='#eff1f4';
	                                                  return true;onMouseOut=this.style.backgroundColor='';>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														ISBN：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<input name="book.ISBN" type="text" id="ISBN" size="18">
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														拼音：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.spell" type="text" id="spell" size="18">
													</td>
												</tr>

												<tr onMouseOver=this.style.backgroundColor= '#eff1f4';return true;;
                                                        onMouseOut=this.style.backgroundColor='';;>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														密级：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<select>
														   <s:iterator value="bookLevelViews" var="bookLevelView">
														   	<option value="<s:property value="#bookLevelView.key"/>">
															      <s:property value="#bookLevelView.value"/>
																</option>
															</s:iterator>
														</select>
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														来源：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<select>
														   <s:iterator value="resourceViews" var="resourceView">
															<option value="<s:property value="#resourceView.key"/>">
														      <s:property value="#resourceView.value"/>
															</option>
															</s:iterator>
														</select>
													</td>
												</tr>
												<tr onMouseOver=this.style.backgroundColor = '#eff1f4';return true;
												          onMouseOut=this.style.backgroundColor='';>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														币种：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<select>
														   <s:iterator value="currencyViews" var="currencyView">
															<option value="<s:property value="#currencyView.key"/>">
														      <s:property value="#currencyView.value"/>
															</option>
															</s:iterator>
														</select>
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														捐赠人：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.donator" type="text" id="donator"
															size="18">
													</td>
												</tr>
                                                <tr onMouseOver=this.style.backgroundColor = '#eff1f4';return true;
												          onMouseOut=this.style.backgroundColor='';>
													<td height="60" align="right" nowrap bgcolor="#F4F5F9">
														简介：
													</td>
													<td height="80" colspan="3" align="left" bgcolor="#F4F5F9">
														<textarea cols="60" rows="4" id="bookDesc"
															name="book.bookDesc" style="border-color: #bcc3c9; border-width: 1px;">
                                                        </textarea>
													</td>
												</tr>


											</table>
										</td>
									</tr>
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
						</form>
					</table>
				</td>
			</tr>
		</table>

	</body>
</html>
