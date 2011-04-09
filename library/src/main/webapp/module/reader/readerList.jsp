<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<%@ include file="/common/common.jsp"%>
		<%@ include file="/common/extInclude.jsp"%>
		
		<link href="<%=path%>/css/style.css" type="text/css"rel="stylesheet" />
		<title>图书馆管理系统</title>
	
   </head>
	<body>
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0" bgcolor="#dbecff">
				<tr id="ye" style="DISPLAY: block">
				<td height="4" background="<%=path%>/images/module/bodybg.jpg"></td>
			</tr>
			<tr>
				<td valign="top" height="10">
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						height="100%">
						<tr id="yd" style="DISPLAY: block">
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
																src="<%=path%>/images/module/cl0.gif"> </strong><strong>读者管理</strong></td>
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
						<tr id="yy" style="DISPLAY: block">
							<td height="10" valign="top">
								<table width="60%" border="0" align="left" cellpadding="0"
									cellspacing="0" bordercolor="#ebebeb"
									borderColorLight="#ebebeb" borderColorDark="#ffffff" id="LM1">
							          <TR>
										<TD  width="60"  height=25 align="right" valign="middle" nowrap="nowrap">
										借阅证号：       </TD>
									    <td width="30" align="left" nowrap>
										<input name=txtkeyvalue type="text" class="input2"
												id="txtkeyvalue" value="" size="20"> 
										</td>
										<TD  width="60"  height=25 align="right" nowrap="nowrap">
										读者姓名：              </TD>
									    <td width="30" align="left" nowrap>
										<input name=txtkeyvalue type="text" class="input2"
												id="txtkeyvalue" value="" size="20">
										</td>
									 </TR>
									 
									 <TR>
										<TD  width="60"  height=25 align="right" nowrap="nowrap">
							   	      读者类别：              </TD>
									    <td width="30" align="left" nowrap>
										<input name=txtkeyvalue type="text" class="input2"
												id="txtkeyvalue" value="" size="20">
										</td>
										<TD  width="60"  height=25 align="right" nowrap="nowrap">
								      读者部门：              </TD>
									    <td width="30" align="left" nowrap>
										<input name=txtkeyvalue type="text" class="input2"
												id="txtkeyvalue" value="" size="20">
										</td>
									 </TR>
									 
									 
									<TR align="left">
										
										<TD height=25 colspan="8" valign="top" nowrap class=body style="padding-left:18px;">
										   <input type="button" class="btnl" value="查 询">
										   <input type="button" class="btnl" value="添 加"
													onclick="window.location='saveReader.jsp'">
                                             <input type="button" class="btnl" value="修 改"
													onclick="window.location='modifyReader.html'">        
										   <input type="button" class="btnl" value="删 除">		
										</TD>
									</TR>
							    	
						   
								</TABLE>
							</td>
						</tr>
						<tr  id="yb" style="DISPLAY: block">
							<td height="10" valign="top">
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
											<table id="tab1" width="98%" border="1" align="center"
												cellpadding="0" cellspacing="0" bordercolor="#bcc3c9"
												borderColorLight="#bcc3c9" borderColorDark="#ffffff"
												bgcolor="#FFFFFF" style="margin-top: 5px">
												<tr>
													<td width="4%" class="body">
														<input type="checkbox" id="selectAll" name="selectAll"
															onClick="selectAll();">
													</td>
													<td align="center" bgcolor="#F4F5F9" class="body">
														读者编号
													</td>
													<td align="center" bgcolor="#F4F5F9" class="body">
														读者姓名
													</td>
													<td align="center" bgcolor="#F4F5F9" class="body">
														性别
													</td>
													<td align="center" bgcolor="#F4F5F9" class="body">
														类别
													</td>


													<td align="center" bgcolor="#F4F5F9" class="body">
														系
													</td>
													<td align="center" bgcolor="#F4F5F9" class="body">
														专业</td>
													<td align="center" bgcolor="#F4F5F9" class="body">班级</td>
                                                    <td align="center" bgcolor="#F4F5F9" class="body">余额</td>
												</tr>
										
											
												
												<tr onClick="oncli()"
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">

                                                     <td width="4%" class="body">
														<input type="checkbox" name="proSelect">
													</td>
													 
													<td width="11%" class="body">
														080301009</td>
													<td width="27%" class="body">
														huan
													</td>
													<td width="11%" class="body">
														男
													</td>
													<td width="9%" class="body">学生</td>
													<td class="body">
														计算机
														<br>
													</td>


													<td align="center" class="user">
														计算机科学与技术
													</td>
													<td align="center" class="user">
														五班
													</td>
                                                    <td align="center" class="user">
														56
													</td>

												</tr>
												
													<tr onClick="oncli()"
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">

                                                     <td width="4%" class="body">
														<input type="checkbox" name="proSelect">
													</td>
													 
													<td width="11%" class="body">
														080301009</td>
													<td width="27%" class="body">
														huan
													</td>
													<td width="11%" class="body">
														男
													</td>
													<td width="9%" class="body">学生</td>
													<td class="body">
														计算机
														<br>
													</td>


													<td align="center" class="user">
														计算机科学与技术
													</td>
													<td align="center" class="user">
														五班
													</td>
                                                    <td align="center" class="user">
														56
													</td>

												</tr>
												
													<tr onClick="oncli()"
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">

                                                     <td width="4%" class="body">
														<input type="checkbox" name="proSelect">
													</td>
													 
													<td width="11%" class="body">
														080301009</td>
													<td width="27%" class="body">
														huan
													</td>
													<td width="11%" class="body">
														男
													</td>
													<td width="9%" class="body">学生</td>
													<td class="body">
														计算机
														<br>
													</td>


													<td align="center" class="user">
														计算机科学与技术
													</td>
													<td align="center" class="user">
														五班
													</td>
                                                    <td align="center" class="user">
														56
													</td>

												</tr>
												
													<tr onClick="oncli()"
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">

                                                     <td width="4%" class="body">
														<input type="checkbox" name="proSelect">
													</td>
													 
													<td width="11%" class="body">
														080301009</td>
													<td width="27%" class="body">
														huan
													</td>
													<td width="11%" class="body">
														男
													</td>
													<td width="9%" class="body">学生</td>
													<td class="body">
														计算机
														<br>
													</td>


													<td align="center" class="user">
														计算机科学与技术
													</td>
													<td align="center" class="user">
														五班
													</td>
                                                    <td align="center" class="user">
														56
													</td>

												</tr>
												
													<tr onClick="oncli()"
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">

                                                     <td width="4%" class="body">
														<input type="checkbox" name="proSelect">
													</td>
													 
													<td width="11%" class="body">
														080301009</td>
													<td width="27%" class="body">
														huan
													</td>
													<td width="11%" class="body">
														男
													</td>
													<td width="9%" class="body">学生</td>
													<td class="body">
														计算机
														<br>
													</td>


													<td align="center" class="user">
														计算机科学与技术
													</td>
													<td align="center" class="user">
														五班
													</td>
                                                    <td align="center" class="user">
														56
													</td>

												</tr>
											
											</table>
											<table width="99%" border="0" align="center" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="30" align="center" class="body">
														共有11条主题 共2页 现在是第1页 [首页] [上一页] [下一页] [尾页]&nbsp; 跳转到
														<select size="1" name=""
															onChange="viewpage(this.value,this.name);">
															<option value="t0">
																第1页
															</option>
															<option selected value="t0_1">
																第2页
															</option>
														</select>
														<script language=javascript>      
  <!--
  function viewpage(val,id)
  {
  location="produc"+val+".html"}
  //-->
                  </script>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr id="div_yy" style="DISPLAY: none" height="100%">
							<td>
							</td>
						</tr>
						
						<tr>
							<td valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0"
									id="tab" style="DISPLAY: none" height="100%">
									<tr>
										<td height="30">
											<table width="99%" border="0" align="center" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="30" valign="bottom">
														<table width="99%" border="0" align="center"
															cellpadding="0" cellspacing="0">
															<tr>
																<td width="90" height="25" align="center"
																	background="<%=path%>/images/module/tab_title.jpg" id="tabid1"
																	class="title0" style="padding-top: 5px">
																	<a href="#" onClick="javascript:Showtab(1)">读者基本信息</a>
																</td>
																<td width="90" align="center"
																	background="<%=path%>/images/module/tab_titlebg.jpg" class="menu"
																	id="tabid2" style="padding-top: 5px">
																	<a href="#" onClick="javascript:Showtab(2)">读者借阅信息</a>
																</td>
																<td width="90" align="center"
																	background="<%=path%>/images/module/tab_titlebg.jpg" class="menu"
																	id="tabid3" style="padding-top: 5px">
																	<a href="#" onClick="javascript:Showtab(3)">读者预约图书</a>
																</td>
																<td width="90" align="center"
																	background="<%=path%>/images/module/tab_titlebg.jpg" class="menu"
																	id="tabid4" style="padding-top: 5px">
																	<a href="#" onClick="javascript:Showtab(4)">读者逾期图书</a>
																</td>
															
																
																<td>&nbsp;
																	

																</td>
																	<td align="right" valign="bottom">
											                        	<table width="72" border="0" cellspacing="0"
															cellpadding="0">
															<tr>
																<td>
																	<img src="<%=path%>/images/login/btn_01.jpg" width="23" height="19" onClick="test12(1)" title="缩小">
																</td>
																<td>
																	<img src="<%=path%>/images/login/btn_02.jpg" width="26" height="19" onClick="test12(2)" title="还原">
																</td>
																<td>
																	<img src="<%=path%>/images/login/btn_03.jpg" width="23" height="19" onClick="test12(3)" title="放大">
																</td>
															</tr>
														</table>
										                        </td>
															</tr>
														</table>
													</td>
												</tr>
												<tr>
													<td height="2" bgcolor="#4590e1"></td>
												</tr>
											</table>
										</td>
									


									</tr>
									<tr id="tablm1">
										<td align="center" valign="top">
											<iframe name="info" marginwidth="0" marginheight="0"
												src="readerDetails.html" width="99%" scrolling="yes"
												frameborder="0" height="99%">
											</iframe>
										</td>
									</tr>
									<tr id="tablm2" style="DISPLAY: none">
										<td align="center" valign="top">
											<iframe name="info" marginwidth="0" marginheight="0"
												src="readerBorrored.html" width="99%" scrolling="yes"
												frameborder="0" height="99%"></iframe>
										</td>
									</tr>
									<tr id="tablm3" style="DISPLAY: none">
										<td align="center" valign="top">
											<iframe name="info" marginwidth="0" marginheight="0"
												src="readerPreOrder.html" width="99%" scrolling="yes"
												frameborder="0" height="99%"></iframe>
										</td>
									</tr>
									<tr id="tablm4" style="DISPLAY: none">
										<td align="center" valign="top">
											<iframe name="info" marginwidth="0" marginheight="0"
												src="overdue.html" width="99%" scrolling="yes"
												frameborder="0" height="99%"></iframe>
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
