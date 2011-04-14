<%@ page language="java" import="java.util.*;" pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<%@ include file="/common/common.jsp"%>
		<%@ include file="/common/extInclude.jsp"%>
     	<title>图书馆管理系统</title>
     	  <script type="text/javascript" src="<%=path %>/js/system/LibInfoOperation.js">
	    </script>
	</head>
	<body>
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0" bgcolor="#dbecff">
			<tr>
				<td height="2" background="<%=path %>/images/module/bodybg.jpg"></td>
			</tr>
			<tr>
				<td height="274" valign="top">
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
																src="<%=path %>/images/module/cl0.gif" align="absmiddle">系统管理</strong>
													</td>
													<td width="81%" height="25" class="body1"
														style="text-align: left">
														<img src="<%=path %>/images/module/02a.gif">
														当前位置：系统管理 &gt;&gt;图书馆信息管理
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
												value="设置" onClick="save();">
											<input type="button" class="btn" value="清除" onClick="clear();">
											<input type="button" class="btn"
												onClick="window.history.back(-1);" value="返回">
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
													<td width="189" height="33"
														background="<%=path %>/images/module/titleb_01.jpg"
														class="title1">
														图书馆信息设置
													</td>
													<td height="30"
														background="<%=path %>/images/module/titleb_02.jpg">&nbsp;
														
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
									<tr>
										<td valign="top">
											<table width="51%" border="1" align="center" cellpadding="0"
												cellspacing="0" bordercolor="#bcc3c9"
												borderColorLight="#bcc3c9" borderColorDark="#ffffff"
												bgcolor="#FFFFFF" style="margin-top: 5px">
												<tr align="right">
												  <td nowrap>
                                                     <input type="hidden" name="libInfo.id" id="libInfo.id"
                                                       value="<s:property value='libInfo.id'/>">   
                                                  </td>
											  </tr>
												<tr align="right" valign="middle">
													<TD width="113" height="30" align="right" nowrap  
														class="body">
														图书管名字：
												  </TD>
													<TD
														width="140" height="25" align="left" nowrap  class="body">
														<input name="libInfo.libName" type="text" id="libInfo.libName"
														  value="<s:property value='libInfo.libName'/>" size="20">  
												  </TD>
													<TD width="113" height="30" align="right" nowrap 
														 class="body">
														开户费：
											    </TD>
													<TD width="206" height="30" align="left" nowrap 
														class="body">
														<input name="libInfo.baseCost" type="text" id="libInfo.baseCost"
														 value="<s:property value='libInfo.baseCost'/>" size="20">
													</TD>
											  </tr>
												<tr align="right">
											  <TD width="113" height="30" align="right" valign="center" nowrap  
														class="body">
														电话：
												  </TD>
													<TD
														width="140" height="25" align="left" valign="top" nowrap  class="body">
														<input name="libInfo.telphone" type="text" id="libInfo.telphone"
														 value="<s:property value='libInfo.telphone'/>" size="20">
												  </TD>
													<TD height="30" align="right" valign="center" nowrap  
														class="body">
														负责人：
													</TD>
													<TD height="30" align="left" valign="top" nowrap  class="body">
														<input name="libInfo.libManager" type="text" id="libInfo.libManager" 
														value="<s:property value='libInfo.libManager'/>" size="20">
													</TD>
											  </tr>
												<tr align="right">
													<TD width="113" height="30" align="right" valign="center" nowrap  
														class="body">
														押金倍数：
													</TD>
													<TD
														width="140" height="25" align="left" valign="top" nowrap  class="body">
														<input name="libInfo.depositeTimes" type="text" id="libInfo.depositeTimes" 
														value="<s:property value='libInfo.depositeTimes'/>" size="20">
												  </TD>
													<TD height="30" align="right" valign="center" nowrap  
														class="body">
														超期日罚金：
													</TD>
													<TD height="30" align="left" valign="top" nowrap  class="body">
														<input name="libInfo.payADay" type="text" id="libInfo.payADay" 
														value="<s:property value='libInfo.payADay'/>" size="20">
													</TD>
											  </tr>
												<tr align="right">
													<TD width="113" height="23" align="right" valign="center" nowrap  
														class="body">
														地址：
													</TD>
													<TD height="23" align="left" valign="top" nowrap  class="body">
														<input name="libInfo.address" type="text" id="libInfo.address" 
														value="<s:property value='libInfo.address'/>" size="20">
												  </TD>
													<TD height="23" align="right" valign="center" nowrap  
														class="body">
														本馆资金：
												  </TD>
													<TD height="23" align="left" valign="top" nowrap  class="body">
														<input name="libInfo.libFunds" type="text" id="libInfo.libFunds" 
														value="<s:property value='libInfo.libFunds'/>" size="20">
													</TD>
											  </tr>
												<tr align="right">
													<td width="100" height="60" align="right" nowrap   bgcolor="#F4F5F9">
														简介：
													</td>
													<td height="60" colspan="3" align="left" nowrap  bgcolor="#F4F5F9">
														<textarea  name="libInfo.libDesc" rows="8" cols="70" id="libInfo.libDesc"
															style="border-color: #bcc3c9; border-width: 1px;">
                                                            <s:property value="libInfo.libDesc"/>
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
