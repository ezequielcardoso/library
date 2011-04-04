<%@ page language="java" import="java.util.*;" pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
				
		<%@ include file="/common/common.jsp"%>
		<%@ include file="/common/extInclude.jsp"%>
		<link href="<%=path %>/css/style.css" type="text/css" rel="stylesheet" />
		<title>广州市自来水综合业务管理平台</title>

		<script type="text/javascript" src="<%=path %>/js/book/category/Category.js" charset="UTF-8"></script>
		<script type="text/javascript" src="<%=path %>/js/book/category/CategoryTreePanel.js" charset="UTF-8"></script>
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
													align="absmiddle">书刊管理</strong>										
                                        </td>
								  <td width="81%" height="25" class=body1
											style="text-align: left">
											<img src="<%=path %>/images/module/02a.gif">
												书刊管理 &gt;&gt;书刊分类管理
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
						cellspacing="0" bordercolor="#ebebeb" borderColorLight="#ebebeb"
						borderColorDark="#ffffff" id="LM1">

					</TABLE>
				</td>
			</tr>
			<tr>
				<td valign="top">
					<table width="99%" border="0" align="center" cellpadding="0"
						cellspacing="0" bgcolor="#f1f8ff"
						style="border: 1px solid #2686d2; margin-top: 5px">
						<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="189" height="25"
											background="<%=path %>/images/module/titleb_01.jpg" class="title1">
											书刊分类管理¨
										</td>
										<td background="<%=path %>/images/module/titleb_02.jpg">&nbsp;
											
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
								<table width="98%" border="1" align="center" cellpadding="0"
									cellspacing="0" bordercolor="#bcc3c9"
									bordercolorlight="#bcc3c9" bordercolordark="#ffffff"
									bgcolor="#FFFFFF" style="margin-top: 5px">
									<tr>

									</tr>

								</table>
								<table width="99%" height="680" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td width="310" height="363" align="left" valign="top" >
											<div id="categoryTree">
											</div>
										</td>
										<td width="500" height="363" align="left" valign="top"
											class="body">
											<table width="100%" height="338" border="0">
												<tr>
													<td height="39">
                                                    	<input type="button" class="btn" value="重置"
															onClick="">
														<input type="button" class="btn" value="增加"
															onClick="">
														<input type="button" class="btn" value="修改"
															onClick="">
														<input type="button" class="btn" value="删除"
															onClick="">
													</td>
												</tr>
												<tr>
													<td height="293" align="left" valign="top" nowrap="nowrap">
														<table width="80%" border="1" align="left" cellpadding="0"
															cellspacing="0" bordercolor="#bcc3c9"
															borderColorLight="#bcc3c9" borderColorDark="#ffffff"
															bgcolor="#dbecff" style="margin-top: 5px">
<tr>
																<td width="25%" height="33" align="right" valign="middle"
																	nowrap="nowrap" bgcolor="#F4F5F9">
																	分类代号：																</td>
<td width="25%" align="left" bgcolor="#F4F5F9"
																	style="padding-left: 10px;">
																	<input name="productName" type="text" value="ddd" size="40" />
																</td>
															</tr>
															<tr>
																<td width="20%" height="39" align="right" valign="middle" nowrap="nowrap" bgcolor="#F4F5F9">分类名称：																</td>
<td width="30%" align="left" bgcolor="#F4F5F9"
																	style="padding-left: 10px;">
																	<input type="text" size="40" value="2010-12-2" />
																</td>
															</tr>
															<tr>
																<td width="20%" height="33" align="right" valign="middle" nowrap="nowrap" bgcolor="#F4F5F9">是否启用：																</td>
<td width="30%" align="left" bgcolor="#F4F5F9"
																	style="padding-left: 10px;">
																	<input type="text" size="40" value="24" />
																	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																</td>
															</tr>
															<tr bgcolor="#FAFBFC"
																onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
																onMouseOut="this.style.backgroundColor='';">
																<td width="20%" height="33" align="right" valign="middle" nowrap="nowrap" bgcolor="#F4F5F9">分类排序：																</td>
<td width="30%" align="left" bgcolor="#F4F5F9"
																	style="padding-left: 10px;">

																	<select id="state" name="state"
																		style="border-style: solid; border-color: #bcc3c9; width: 180px;">
																		<s:if test='state=="1"'>
																			<option value="1" selected>
																				核审中
																			</option>
																			<option value="-1">
																				在馆
																			</option>
																			<option value="0">
																				外借
																			</option>
																		</s:if>
																		<s:if test='state=="-1"'>
																			<option value="1">
																				正常供应
																			</option>
																			<option value="-1" selected>
																				已经停产
																			</option>
																			<option value="0">
																				现在缺货
																			</option>
																		</s:if>
																		<s:if test='state=="0"'>
																			<option value="1">
																				正常供应
																			</option>
																			<option value="-1">
																				已经停产
																			</option>
																			<option value="0" selected>
																				现在缺货
																			</option>
																		</s:if>
																	</select>
																</td>

															</tr>
															<tr bgcolor="#FAFBFC"
																onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
																onMouseOut="this.style.backgroundColor='';">
																<td width="20%" height="100" align="right" valign="middle" nowrap="nowrap" bgcolor="#F4F5F9">分类描述：																</td>
<td width="30%" align="left" bgcolor="#F4F5F9"
																	style="padding-left: 10px;">
																	<textarea cols="40" rows="6">8</textarea>
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
				</td>
			</tr>
		</table>
	</body>
</html>
