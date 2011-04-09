<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<%@ include file="/common/common.jsp"%>
		<%@ include file="/common/extInclude.jsp"%>
		
		<link href="<%=path%>/css/style.css" type="text/css"rel="stylesheet" />
		<title>图书馆管理系统</title>
		<script type="text/javascript"
			src="<%=path%>/common/datePicker/datePicker/calendar/WdatePicker.js">
        </script>
        
        <script type="text/javascript" src="<%=path %>/js/tree/BaseTree.js"></script>
		<script type="text/javascript" src="<%=path %>/js/tree/BaseCheckTree.js"></script>
		<script type="text/javascript" src="<%=path %>/js/tree/BaseCheckTreeWindow.js"></script>
		<script type="text/javascript" src="<%=path %>/js/dictItem/BookSourceCheckTree.js"></script>
		<script type="text/javascript" src="<%=path %>/js/dictItem/BookSecurityCheckTree.js"></script>
		<script type="text/javascript" src="<%=path %>/js/dictItem/CurrencyCheckTree.js"></script>
		<script type="text/javascript" src="<%=path %>/js/dictItem/BookStateCheckTree.js"></script>
		<script type="text/javascript" src="<%=path %>/js/dictItem/BookLevelCheckTree.js"></script>
		<script type="text/javascript" src="<%=path %>/js/dictItem/CategoryCheckTree.js"></script>
		<script type="text/javascript" src="<%=path %>/js/dictItem/PressCheckTree.js"></script>
        <script type="text/javascript" src="<%=path %>/js/book/BookOperation.js"></script>
        
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
														当前位置：书刊管理 &gt;&gt;期刊基本管理
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
								<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" style="left: 5px">
							    <tr>
										<td height="30" class="body1">
											<input type="button" class="btn" onClick="saveMagazine();" value="保存">
											<input type="button" class="btn" onClick="resetMagazineForm();" value="清除">
											<input type="button" class="btn" onClick="window.location='<%=path%>/book/magazineMain.action'" value="返回">
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
														新建期刊
													</td>
													<td background="<%=path%>/images/module/titleb_02.jpg">&nbsp;
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
											<table width="80%" border="1" align="left" cellpadding="0"
												cellspacing="0" bordercolor="#bcc3c9" borderColorLight="#bcc3c9" borderColorDark="#ffffff"
												bgcolor="#FFFFFF" style="margin-top: 5px">
								               <tr>
													<td width="15%" height="30" align="right" nowrap  bgcolor="#F4F5F9">
														刊名：
													</td>
													<td align="left" bgcolor="#F4F5F9" colspan="3">
														<input name="book.bookName" type="text" id="book.bookName" size="72"
															value="<s:property value='book.bookName'/>">
														<input name="book.bookId" type="hidden" id="book.bookId"
															value="<s:property value='book.bookId'/>">	
													</td>
												</tr>
												<tr>
													<td width="15%" height="30" align="right" nowrap
														bgcolor="#F4F5F9">
														条形码：
													</td>
													<td width="35%" align="left" bgcolor="#F4F5F9">
													  <input name="book.barCode" type="text" id="book.barCode" size="29"
															value="<s:property value='book.barCode'/>" >
													</td>
											  <td width="15%" height="30" align="right" nowrap bgcolor="#F4F5F9">
														ISSN：													</td>
											  <td width="35%" align="left" bgcolor="#F4F5F9">
										<input name="book.ISSN" type="text" id="book.ISSN" size="29"
															value="<s:property value='book.ISSN'/>">
													</td>
											  </tr>
												<tr>
													<td width="15%" align="right" nowrap bgcolor="#F4F5F9">
														期刊编号：
													</td>
													<td width="35%" height="30" align="left" nowrap
														bgcolor="#F4F5F9">
													  <input name="book.bookNo" type="text" id="book.bookNo" size="29"
															value="<s:property value='book.bookNo'/>">
													</td>
					  <td height="30" align="right" nowrap bgcolor="#F4F5F9">
														种次号：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<input name="book.speciesId" type="text" id="book.speciesId" size="29"
															value="<s:property value='book.speciesId'/>">
													</td>
												</tr>
												<tr>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														邮发代码：
													</td>
													<td width="35%" align="left" bgcolor="#F4F5F9">
													  <input name="book.emailNo" type="text" id="book.emailNo" size="29"
															value="<s:property value='book.emailNo'/>">
													</td>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														国内统一刊号：
													</td>
													<td width="35%" align="left" bgcolor="#F4F5F9">
													  <input name="book.ISBN" type="text" id="book.ISBN" size="29"
															value="<s:property value='book.ISBN'/>">
													</td>															
												</tr>
												<tr >
													
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														类别：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<input name="book.firstCategory.itemName" type="text" id="book.firstCategory.itemName" size="18"
															value="<s:property value='book.firstCategory.itemName'/>" disabled>
														<input name="book.firstCategory.itemId" type="hidden" id="book.firstCategory.itemId" size="29"
															value="<s:property value='book.firstCategory.itemId'/>">
														<input type="button" onclick="checkCategory(1, 'book.firstCategory.itemId', 'book.firstCategory.itemName');" 
															style="width:60px; height:25px" value="选 择">
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														二级分类：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.secondCategory.itemName" type="text" id="book.secondCategory.itemName" size="18"
															value="<s:property value='book.secondCategory.itemName'/>" disabled>
														<input name="book.secondCategory.itemId" type="hidden" id="book.secondCategory.itemId" size="29"
															value="<s:property value='book.secondCategory.itemId'/>">
														<input type="button" onclick="checkCategory(2, 'book.secondCategory.itemId', 'book.secondCategory.itemName');" 
															style="width:60px; height:25px" value="选 择">	
													</td>
												</tr>
												<tr >
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														三级分类：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<input name="book.thirdCategory.itemName" type="text" id="book.thirdCategory.itemName" size="18"
															value="<s:property value='book.thirdCategory.itemName'/>" disabled>
														<input name="book.thirdCategory.itemId" type="hidden" id="book.thirdCategory.itemId" size="29"
															value="<s:property value='book.thirdCategory.itemId'/>">
														<input type="button" onclick="checkCategory(3, 'book.thirdCategory.itemId', 'book.thirdCategory.itemName');" 
															 style="width:60px; height:25px" value="选 择">		
													</td>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														存放位置：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<input name="book.location" type="text" id="book.location" size="29"
															value="<s:property value='book.location'/>">
													</td>
												</tr>
												<tr 
													>
													<td align="right" nowrap bgcolor="#F4F5F9">
														出版社：
													</td>
													<td width="35%" align="left" bgcolor="#F4F5F9">
										        <input name="book.press.pressName" type="text" id="book.press.pressName" size="18"
															value="<s:property value='book.press.pressName'/>" disabled>
														<input name="book.press.pressId" type="hidden" id="book.press.pressId" size="29"
															value="<s:property value='book.press.pressId'/>">
														<input type="button"  onClick="checkPress();" style="width:60px; height:25px" value="选 择">	
													</td>
					  <td align="right" nowrap bgcolor="#F4F5F9">
														出版日期：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.publisherDate" id="book.publisherDate" type="text" value="<s:property value='book.publisherDate'/>"
															onClick=WdatePicker(); size="29">
													</td>
												</tr>
												<tr>
													<td width="15%" align="right" nowrap bgcolor="#F4F5F9">
													     第几期：
													</td>
													<td width="35%" height="30" align="left" nowrap
														bgcolor="#F4F5F9"> 
													  <input name="book.stage" type="text" id="book.stage" size="29"
															value="<s:property value='book.stage'/>">
													</td>
					  <td height="30" align="right" nowrap bgcolor="#F4F5F9">
														总第几期：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<input name="book.allStage" type="text" id="book.allStage" size="29"
															value="<s:property value='book.allStage'/>">
													</td>
												</tr>
												<tr>
													<td align="right" nowrap bgcolor="#F4F5F9">
														来源：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.bookSource.itemName" type="text" id="book.bookSource.itemName" size="18"
															value="<s:property value='book.bookSource.itemName'/>" disabled>
														<input name="book.bookSource.itemId" type="hidden" id="book.bookSource.itemId" size="29"
															value="<s:property value='book.bookSource.itemId'/>">
														<input type="button" id="clickBookSourceBtn" onClick="checkBookSource();" style="width:60px; height:25px" value="选 择">		
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														捐赠人：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.donator" type="text" id="book.donator" size="29"
															value="<s:property value='book.donator'/>">
													</td>
												</tr>
												<tr 
													>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														版次：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<input name="book.revision" type="text" id="book.revision" size="29"
															value="<s:property value='book.revision'/>">
													</td>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														密级：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<input name="book.bookSecurity.itemName" type="text" id="book.bookSecurity.itemName" size="18"
															value="<s:property value='book.bookSecurity.itemName'/>" disabled>
														<input name="book.bookSecurity.itemId" type="hidden" id="book.bookSecurity.itemId" size="29"
															value="<s:property value='book.bookSecurity.itemId'/>">
															<input type="button" onClick="checkBookSecurity();" style="width:60px; height:25px" value="选 择">	
													</td>
												</tr>
												<tr 
													>
													<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														页数：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<input name="book.pages" type="text" id="book.pages" size="29"
															value="<s:property value='book.pages'/>">
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														状态：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.bookState.itemName" type="text" id="book.bookState.itemName" size="18"
															value="<s:property value='book.bookState.itemName'/>" disabled>
														<input name="book.bookState.itemId" type="hidden" id="book.bookState.itemId" size="29"
															value="<s:property value='book.bookState.itemId'/>">
														<input type="button" id="clickBookStateBtn" onClick="checkBookState();" style="width:60px; height:25px" value="选 择">	
													</td>
												</tr>
												<tr>
														<td height="30" align="right" nowrap bgcolor="#F4F5F9">
														币种：
													</td>
													<td align="left" bgcolor="#F4F5F9">
														<input name="book.currency.itemName" type="text" id=book.currency.itemName size="18"
															value="<s:property value='book.currency.itemName'/>" disabled>
														<input name="book.currency.itemId" type="hidden" id="book.currency.itemId" size="29"
															value="<s:property value='book.currency.itemId'/>">
														<input type="button" id="clickCurrencyBtn" onClick="checkCurrency()" style="width:60px; height:25px" value="选 择">		
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														价格：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.price" type="text" id="book.price" size="29"
															value="<s:property value='book.price'/>">
													</td>												
												</tr>
												<tr>
														<td align="right" nowrap bgcolor="#F4F5F9">
														数量：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.quantity" type="text" id="book.quantity" size="29"
															value="<s:property value='book.quantity'/>">
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														拼音：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.spell" type="text" id="book.spell" size="29"
															value="<s:property value='book.spell'/>">
													</td>
												</tr>
                                                <tr>
													<td align="right" nowrap bgcolor="#F4F5F9">
														期刊级别：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.bookLevel.itemName" type="text" id=book.bookLevel.itemName size="18"
															value="<s:property value='book.bookLevel.itemName'/>" disabled>
														<input name="book.bookLevel.itemId" type="hidden" id="book.bookLevel.itemId" size="29"
															value="<s:property value='book.bookLevel.itemId'/>">
														<input type="button" onClick="checkBookLevel()" style="width:60px; height:25px" value="选 择">		
													</td>
													<td align="right" nowrap bgcolor="#F4F5F9">
														录入人：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.operator" type="text" id="book.operator" size="29"
															value="<s:property value='book.operator'/>" disabled>
													</td>
												</tr>
                                                <tr>
													<td align="right" nowrap bgcolor="#F4F5F9">
														电子文档：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input type="button" id="clickAttachmentBtn" style="width:60px; height:25px"  value="查 看">
													</td>
													 <td align="right" nowrap bgcolor="#F4F5F9">
														入库日期：
													</td>
													<td height="30" align="left" bgcolor="#F4F5F9">
														<input name="book.storeDate" id="book.storeDate" type="text" value="<s:property value='book.storeDate'/>"
															onClick=WdatePicker(); size="29" disabled="disabled">
													</td>
												</tr>
												<tr>
													<td height="60" align="right" nowrap bgcolor="#F4F5F9">
														简介：
													</td>
													<td height="80" colspan="3" align="left" bgcolor="#F4F5F9">
														<textarea cols="60" rows="4" name="book.bookDesc" id="book.bookDesc"
															style="border-color: #bcc3c9; border-width: 1px;">
                                                          <s:property value="book.bookDesc"/>  
                                                        </textarea>
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
