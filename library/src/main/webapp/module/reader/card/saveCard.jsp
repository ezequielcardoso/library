<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<%@ include file="/common/common.jsp"%>
		<%@ include file="/common/extInclude.jsp"%>

		<link href="<%=path %>/css/style.css" type="text/css"
			rel="stylesheet" />
		<title>图书馆管理系统</title>
		<script type="text/javascript"
			src="<%=path %>/common/datePicker/datePicker/calendar/WdatePicker.js">
        </script>
	</head>
	<body>
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0" bgcolor="#dbecff">
			<tr>
				<td height="4" background="<%=path %>/images/module/bodybg.jpg"></td>
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
																src="<%=path %>/images/module/cl0.gif"
																align="absmiddle">读者管理</strong>
													</td>
													<td width="81%" height="25" class=body1
														style="text-align: left">
														<img src="<%=path %>/images/module/02a.gif">
														当前位置：读者管理 &gt;&gt;借阅证管理
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
												onClick="window.location='cardList.html'" value="修 改">
											<input type="button" class="btn" onClick="" value="重 置">
											<input type="button" class="btn"
												onClick="window.history.back(-1);" value="返 回">
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
														background="<%=path %>/images/module/titleb_01.jpg"
														class="title1">新增借阅证
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
									<tr>
										<td valign="top">

											<table width="60%" border="1" align="left" cellpadding="0"
												cellspacing="0" bordercolor="#bcc3c9"
												borderColorLight="#bcc3c9" borderColorDark="#ffffff"
												bgcolor="#FFFFFF" style="margin-top: 5px">
												<tr>
													<td width="15%" height="30" align="right" nowrap
														bgcolor="#F4F5F9">
														条形码：
													</td>
													<td width="35%" height="30" align="left" nowrap
														bgcolor="#F4F5F9">
														<input type="text" name="readerCard.barCode"
															id="readerCard.barCode" disabled="disabled"
															value="<s:property value='readerCard.barCode'/>" />
													</td>
												</tr>

												<tr bgcolor="#FAFBFC"
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">
													<td width="15%" height="30" align="right" nowrap
														bgcolor="#F4F5F9">
														借阅证号：
													</td>
													<td width="35%" height="30" align="left" nowrap
														bgcolor="#F4F5F9">
														<input type="text" name="readerCard.readerCardCode"
															id="readerCard.readerCardCode"
															value="<s:property value='readerCard.readerCardCode'/>" />
													</td>
												</tr>
												<tr
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">
													<td width="15%" height="30" align="right" nowrap
														bgcolor="#F4F5F9">
														读者姓名：
													</td>
													<td width="35%" height="30" align="left" nowrap
														bgcolor="#F4F5F9">
														<input type="text" name="readerCard.reader.readerName"
															id="readerCard.reader.readerName"
															value="<s:property value='readerCard.reader.readerName'/>" />
													</td>
												</tr>
												<tr
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">
													<td width="15%" height="30" align="right" nowrap
														bgcolor="#F4F5F9">
														密码：
													</td>
													<td width="35%" height="30" align="left" nowrap
														bgcolor="#F4F5F9">
														<input type="text" name="readerCard.password"
															id="readerCard.password"
															value="<s:property value='readerCard.password'/>" />
													</td>
												</tr>
												<tr
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">
													<td width="15%" height="30" align="right" nowrap
														bgcolor="#F4F5F9">
														单位：
													</td>
													<td width="35%" height="30" align="left" nowrap
														bgcolor="#F4F5F9">
														<input type="text"
															name="readerCard.readerUnits.readerUnitsName"
															id="readerCard.reader.readerUnits.readerUnitsName"
															value="<s:property value='readerCard.reader.readerUnits.readerUnitsName'/>" />
													</td>
												</tr>
												<tr
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">
													<td width="15%" height="30" align="right" nowrap
														bgcolor="#F4F5F9">
														登记日期：
													</td>
													<td width="35%" height="30" align="left" nowrap
														bgcolor="#F4F5F9">
														<input name="readerCard.entyDate" id="readerCard.entyDate"
															type="text"
															value="<s:property value='readerCard.entyDate'/>"
															onClick="WdatePicker();">
													</td>
												</tr>	
												<tr
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">
													<td width="15%" height="30" align="right" nowrap
														bgcolor="#F4F5F9">
														有效日期：
													</td>
													<td width="35%" height="30" align="left" nowrap
														bgcolor="#F4F5F9">
														<input name="readerCard.effectiveDate"
															id="readerCard.effectiveDate" type="text"
															value="<s:property value='readerCard.effectiveDate'/>"
															onClick="WdatePicker();">
													</td>
												</tr>
												<tr
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">
													<td width="15%" height="30" align="right" nowrap
														bgcolor="#F4F5F9">
														状态：
													</td>
													<td width="35%" height="30" align="left" nowrap
														bgcolor="#F4F5F9">
														<select>
														  <s:iterator id="dictItemView" value="dictItemViews" var="dictItemView">
														     <option value="<s:property value='key'/>"><s:property value="value"/></option> 
														  </s:iterator>
														</select>
													</td>
												</tr>
												<tr onMouseOver=this.style.backgroundColor='#eff1f4'; return true; 
													onMouseOut=this.style.backgroundColor='';>
													<td width="15%" height="30" align="right" nowrap
														bgcolor="#F4F5F9">
														简介：
													</td>
													<td width="35%" height="30" align="left" nowrap
														bgcolor="#F4F5F9">
														<textarea cols="60" rows="4"
															style="border-color: #bcc3c9; border-width: 1px;">
													            <s:property value="readerCard.readerCardDesc" />		 
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
