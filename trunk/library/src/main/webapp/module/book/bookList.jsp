<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="<%=path%>/css/style.css" type="text/css" rel="stylesheet" />
		<title>"广水用水"终端服务综合业务管理平台</title>
		<script language="JavaScript">
		function test12(i){
			if(i==1){
				 document.getElementById("div_yy").style.display="block";
				 document.getElementById("ye").style.display="none";
				 document.getElementById("yd").style.display="block";
				document.getElementById("yy").style.display="block";
				document.getElementById("yb").style.display="block";
			}else if(i==2){
				 document.getElementById("div_yy").style.display="none";
				 document.getElementById("ye").style.display="none";
				 document.getElementById("yd").style.display="block";
				document.getElementById("yy").style.display="block";
				document.getElementById("yb").style.display="block";
			}else if(i==3){
			document.getElementById("ye").style.display="none";
				document.getElementById("yd").style.display="none";
				document.getElementById("yy").style.display="none";
				document.getElementById("yb").style.display="none";
				 document.getElementById("div_yy").style.display="none";
			}
			
		}
		function oncli(){
		  var div1=document.getElementById("tab");
		        div1.style.display="block";
		   
		       // var d=div1.style.display;
		        //if(d=="block"){
		          //div1.style.display="none";
		        //}
		        //else{
		          // div1.style.display="block"
		        //}
				var cols = window.event.srcElement.parentElement.cells;
				//document.getElementById("my").value=cols(0).innerText;
				id = cols(0).innerText;
				
		}


//tab选项卡
var tabnumber=5; 

function tablmyc() { 
var tabnum; 
//var treePic; 
for (i=1;i<=tabnumber;i++) { 
tabnum = eval('tablm' + i); 
var tabName='tabid'+ i; 
document.getElementById(tabName).background="<%=path%>/images/module/tab_titlebg.jpg";
document.getElementById(tabName).className="menu";
tabnum.style.display = 'none'; 
} 
} 

function Showtab(i) { 
tabnum = eval('tablm' + i); 
var tabName='tabid'+ i;
if (tabnum.style.display == 'none') { 
tablmyc(); 
document.getElementById(tabName).background="<%=path%>/images/module/tab_title.jpg";
document.getElementById(tabName).className="title0";
tabnum.style.display = ''; 
} 

} 

function selectAll()
{
var proList=document.getElementsByName("proSelect");
if(document.getElementById("selectAll").checked==true){
   
   for(k=0;k<proList.length;k++)
   {
      proList[k].checked=true;
   }
}
else{
 for(j=0;j<proList.length;j++)
   {
      proList[j].checked=false;
   }
}
}
    </script>
	</head>
	<body>
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0" bgcolor="#dbecff">
			<tr id="ye">
				<td height="4" background="<%=path%>/images/module/bodybg.jpg"></td>
			</tr>
			<tr>
				<td valign="top" height="10">
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						height="100%">
						<tr id="yd">
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
																src="<%=path%>/images/module/cl0.gif">书刊管理</strong>													</td>
													<td width="81%" height="25" class=body1
														style="text-align: left">
														<img src="<%=path%>/images/module/02a.gif">
														当前位置：书刊管理&gt;&gt;图书基本管理
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<TR>
										<TD>
											<table width="98%" border="0" align="center" cellpadding="0"
												cellspacing="0">

											</table>
										</TD>
									</TR>
								</table>
							</td>
						</tr>
						<tr id="yy" >
							<td height="10" valign="top">
								<table width="96%" border="0" align="center" cellpadding="0"
									cellspacing="0" bordercolor="#ebebeb"
									borderColorLight="#ebebeb" borderColorDark="#ffffff" id="LM1">
						
									<TR>
                                        <TD width="5%" height=25 align="right" nowrap class="body">
                                       	  <INPUT type=radio CHECKED value=1 name="location"> 
                                          <LABEL for=radio3>模糊</LABEL>                                      
                                        </TD>
                                <TD width="5%" height=25 align="right" nowrap class="body">
                                       	  <INPUT type=radio value=2 name="location"> 
                                      <LABEL for=radio4>精确</LABEL></TD>
                                        <TD width="7%" height=25 align="right" nowrap class="body">
                               		     条形码：                                        </TD>
                                      <TD width="15%" height=25 align="left" nowrap class="body">
                                   	  <input name=txtkeyvalue type="text" class="input2"
												id="txtkeyvalue" value="" size="15"></TD>
                                        <TD width="5%"  height=25 align="right" nowrap class="body">
                                       	  <INPUT type=radio CHECKED value=1 name="bookNo"> 
                                      <LABEL for=radio3>模糊</LABEL></TD>
                                    <TD width="5%"  height=25 align="right" nowrap class="body">
                                   	  <INPUT type=radio value=2 name="bookNo"> 
                                      <LABEL for=radio4>精确</LABEL></TD>
                                     <TD width="6%" height=25 align="right" nowrap class="body">
                               		     书名：                                        </TD>
                                        <TD width="28%"  height=25 align="left" nowrap class="body">
                                   	  <input name=txtkeyvalue2 type="text" class="input2"
												id="txtkeyvalue2" value="" size="15"></TD>
									  <TD width="24%" height=25 align="left" class="body">								      </TD>		
								  </TR>
								  <TR>
                                  		<TD  align="right" nowrap class="body">
											<INPUT type=radio CHECKED value=1 name="barCode"> 
                                            <LABEL for=radio3>模糊</LABEL> 
								    </TD>
                                        <TD height=25 align="right" nowrap class="body">
											<INPUT type=radio value=2 name="barCode"> 
                                    <LABEL for=radio4>精确</LABEL></TD>
                                        <TD height=25 align="right" nowrap class="body">位置： </TD>
                                        <TD height=25 align="left" nowrap class="body">
											<input name=txtkeyvalue type="text" class="input2"
												id="txtkeyvalue" value="" size="15">								    </TD>
                                        <TD height=25 align="right" nowrap class="body">
											<INPUT type=radio CHECKED value=1 name="bookName"> 
                                    <LABEL for=radio3>模糊</LABEL>								    </TD>
                                        <TD height=25 align="right" nowrap class="body">
											<INPUT type=radio value=2 name="bookName"> 
                                            <LABEL for=radio4>精确</LABEL>
								    </TD>
                                        <TD height=25 align="right" nowrap class="body">编号： </TD>
                                    <TD height=25 align="left" class="body">
											<input name=txtkeyvalue type="text" class="input2"
												id="txtkeyvalue" value="" size="15">
								    </TD>								
								  </TR>
                                  
                                    <TR>
                                  		<TD height=25 nowrap class="body" colspan="8" align="left">
											<input type="button" class="btnl" value="查 询">
                                            <input type="button" class="btnl"
												onClick="window.location='modifyBook.html';"
												value="修改">
                                                <input name="button" type="button" class="btnl"
												onClick=""
												value="删除">
                                                <input type="button" class="btnl"
												onClick="window.location='<%=path %>/books/books_showSaveBook.action';" value="增加">
                                                <input type="button" class="btnl"
												onClick="window.location='addProduct.html';" value="导入图书">
                                                <input type="button" class="btnl"
												onClick="" value="导出Excel">
                                                <input type="button" class="btnl"
												onClick="" value="图书标签">
                                                <input type="button" class="btnl"
												onClick="" value="打印条形码">
								    </TD>
                                  </TR>
             
             	  </TABLE>
				      <tr  id="yb">
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
											<table id="tab1" width="97%" border="1" align="center"
												cellpadding="0" cellspacing="0" bordercolor="#bcc3c9"
												borderColorLight="#bcc3c9" borderColorDark="#ffffff"
												bgcolor="#FFFFFF" style="margin-top: 5px">
												<tr align="center">
													<td width="4%" class="body">
														<input type="checkbox" id="selectAll" name="selectAll"
															onClick="selectAll();">
													</td>
													<td align="center" bgcolor="#F4F5F9" class="body">图书编号</td>
													<td align="center" bgcolor="#F4F5F9" class="body">
														名称													</td>
													<td align="center" bgcolor="#F4F5F9" class="body">分类号</td>
													<td align="center" bgcolor="#F4F5F9" class="body" width="8%">作者</td>
													<td width="8%" align="center" bgcolor="#F4F5F9"
														class="body">
														种次号</td>
													<td width="7%" align="center" bgcolor="#F4F5F9"
														class="body">
														数量</td>
													<td width="8%" align="center" bgcolor="#F4F5F9"
														class="body">
														入库时间</td>
													<td width="8%" align="center" bgcolor="#F4F5F9"
														class="body">页数</td>
													<td width="8%" align="center" bgcolor="#F4F5F9"
														class="body">
														附件</td>		
													<td width="8%" align="center" bgcolor="#F4F5F9"
														class="body">
														状态
													</td>
												</tr>
												<tr align="center" onDblClick="oncli()"
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">
													<td width="4%" class="body">
														<input type="checkbox" name="proSelect">
													</td>
													<td width="7%" class="body">ES013</td>
													<td width="16%" class="body">三毛流浪记<br>
													</td>
													<td class="body">
														E1000
														<br>
													</td>
													<td class="body">
														三毛</td>
													<td class="body">
														A1000</td>
													<td align="center" class="user">
														2
														<br>
													</td>
													<td align="center" class="user">
														2010-2-2<br>
													</td>
													<td align="center" class="user">
														98
														<br>
													</td>
													<td align="center" class="user">
													  <img src="<%=path%>/images/module/cd.png">
													<br>
													</td>
													<td align="center" class="user">
														<select name="state2">
															  <option value="0" >核审中</option>
															  <option value="1" selected="selected">在馆</option>
															  <option value="2" >借出</option>
                                                       </select>
													</td>
												</tr>
												<tr onClick="oncli()"
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">
												</tr>
												<tr align="center" onDblClick="oncli()"
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">
													<td width="4%" class="body">
														<input type="checkbox" name="proSelect">
													</td>
													<td width="7%" class="body">ES014</td>
													<td width="16%" class="body">
														上下五千年<br>
													</td>
													<td width="5%" class="body">E1000</td>
													<td class="body">不详</td>
													<td class="body">
														A1001
														<br>
													</td>
													<td align="center" class="user">
														1<br>
													</td>
													<td align="center" class="user">
														2010-2-5<br>
													</td>
													<td align="center" class="user">
														354
														<br>
													</td>
													<td align="center" class="user"><br>
												  </td>
													<td align="center" class="user">
														<select name="state2">
															  <option value="0" >核审中</option>
															  <option value="1" selected="selected">在馆</option>
															  <option value="2" >借出</option>
                                                       </select>
													</td>

												</tr>
												<tr onClick="oncli()"
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">
												</tr>
											  <tr align="center" onDblClick="oncli()"
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">
													<td width="4%" class="body">
														<input type="checkbox" name="proSelect">
													</td>
												  <td width="7%" class="body">ES015</td>
												  <td width="16%" class="body">网络基础<br>												  </td>
												  <td width="5%" class="body">E1001<br>												  </td>
												  <td class="body">黎明<br>												  </td>
											    <td class="body">A1000</td>
												  <td align="center" class="user">
													  1</td>
												  <td align="center" class="user">
													  2010-6-6</td>
												  <td align="center" class="user">
													  354
													  <br>												  </td>
												  <td align="center" class="user">
													  <img src="<%=path%>/images/module/cd.png"></td>
												  <td align="center" class="user">
													  <select name="state2">
														    <option value="0" >核审中</option>
														    <option value="1" selected="selected">在馆</option>
														    <option value="2" >借出</option>
                                                     </select>												  </td>
												</tr>
												<tr onClick="oncli()"
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">
												</tr>
												<tr align="center" onDblClick="oncli()"
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">
													<td width="4%" class="body">
														<input type="checkbox" name="proSelect">
													</td>
													<td width="7%" class="body" style="color: #FF0000;">ES016</td>
													<td width="16%" class="body" style="color: #FF0000;">
														Java web开发</td>
													<td width="5%" class="body" style="color: #FF0000;">J1000</td>
													<td class="body" style="color: #FF0000;">
														孙鑫</td>
													<td class="body" style="color: #FF0000;">B1000</td>
													<td align="center" class="user" style="color: #FF0000">
														5</td>
													<td align="center" class="user" style="color: #FF0000">
														2012-2-2</td>
													<td align="center" class="user">
														354
														<br>													</td>
													<td align="center" class="user">
													    <br>
														</td>
													<td align="center" class="user" style="color: #FF0000">
														<select name="state2">
															  <option value="0" selected="selected">核审中</option>
															  <option value="1" >在馆</option>
															  <option value="2" >借出</option>
                                                       </select>													</td>
												</tr>
												<tr onClick="oncli()"
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">
												</tr>
												<tr align="center" onDblClick="oncli()"
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">
													<td width="4%" class="body">
														<input type="checkbox" name="proSelect">
													</td>
													<td width="7%" class="body" style="color: #FF0000">ES017</td>
													<td width="16%" class="body" style="color: #FF0000">
														数据结构
														<br>													</td>
													<td width="5%" class="body" style="color: #FF0000">J1000</td>
													<td class="body" style="color: #FF0000">
														贵超</td>
													<td class="body" style="color: #FF0000">A1000</td>
													<td align="center" class="user" style="color: #FF0000">
														8</td>
													<td align="center" class="user" style="color: #FF0000">
														2010-3-3</td>
													<td align="center" class="user">
														354
														<br>													</td>
													<td align="center" class="user">
														<br></td>
													<td align="center" class="user" style="color: #FF0000">
														<select name="state2">
															  <option value="0" selected="selected">核审中</option>
															  <option value="1" >在馆</option>
															  <option value="2" >借出</option>
                                                       </select>													</td>
												</tr>
												<tr onClick="oncli()"
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">
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
																	<a href="#" onClick="javascript:Showtab(1)">库存信息</a>
																</td>
																<td width="90" height="25" align="center"
																	background="<%=path%>/images/module/tab_titlebg.jpg" id="tabid2"
																	class="menu" style="padding-top: 5px">
																	<a href="#" onClick="javascript:Showtab(2)">图书基本信息</a>
																</td>
																<td width="90" height="25" align="center"
																	background="<%=path%>/images/module/tab_titlebg.jpg" id="tabid3"
																	class="menu" style="padding-top: 5px">
																	<a href="#" onClick="javascript:Showtab(3)">出版社信息</a>
																</td>
																<td width="90" height="25" align="center"
																	background="<%=path%>/images/module/tab_titlebg.jpg" id="tabid4"
																	class="menu" style="padding-top: 5px">
																	<a href="#" onClick="javascript:Showtab(4)">分类信息</a>
																</td>
																<td width="90" height="25" align="center"
																	background="<%=path%>/images/module/tab_titlebg.jpg" id="tabid5"
																	class="menu" style="padding-top: 5px">
																	<a href="#" onClick="javascript:Showtab(5)">附件信息</a>
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
												src="bookStore.html" width="99%" scrolling="yes"
												frameborder="0" height="99%">
											</iframe>
										</td>
									</tr>
									<tr id="tablm2" style="DISPLAY: none">
										<td align="center" valign="top">
											<iframe name="info" marginwidth="0" marginheight="0"
												src="bookBasic.html" width="99%"
												scrolling="yes" frameborder="0" height="99%">
											</iframe>
										</td>
									</tr>
									<tr id="tablm3" style="DISPLAY: none">
										<td align="center" valign="top">
											<iframe name="info" marginwidth="0" marginheight="0"
												src="../common/press.html" width="99%"
												scrolling="yes" frameborder="0" height="99%">
											</iframe>
										</td>
									</tr>
									<tr id="tablm4" style="DISPLAY: none">
										<td align="center" valign="top">
											<iframe name="info" marginwidth="0" marginheight="0"
												src="bookCategory.html" width="99%"
												scrolling="yes" frameborder="0" height="99%">
											</iframe>
										</td>
									</tr>
									<tr id="tablm5" style="DISPLAY: none">
										<td align="center" valign="top">
											<iframe name="info" marginwidth="0" marginheight="0"
												src="../common/attachment.html" width="99%"
												scrolling="yes" frameborder="0" height="99%">
											</iframe>
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
