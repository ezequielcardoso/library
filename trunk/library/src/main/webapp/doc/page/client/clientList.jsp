<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" errorPage="" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>"广水"用水终端服务业务管理系</title>
<%
List list=(List)request.getAttribute("list");
 %>
<link href="include/css/style.css" type="text/css" rel="stylesheet"/>
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
		
		
		
		
function fEvent(sType,oInput){
		switch (sType){
			case "focus" :
				oInput.isfocus = true;
			case "mouseover" :
				oInput.style.borderColor = '#7a95d2';
				oInput.style.background = '#ffffcc';
				break;
			case "blur" :
				oInput.isfocus = false;
			case "mouseout" :
				if(!oInput.isfocus){
					oInput.style.borderColor='#cddeeb';
					oInput.style.background = '#ffffff';
				}
				break;
		}
	}
	
var number=1; 

function LMYC() { 
var lbmc; 
//var treePic; 
for (i=1;i<=number;i++) { 
lbmc = eval('LM' + i); 
var imageName='treePic'+ i; 
//document.getElementById(imageName).src="images/sj0.gif";
lbmc.style.display = ''; 
} 
} 

function ShowFLT(i) { 
lbmc = eval('LM' + i); 
var imageName='treePic'+ i;
if (lbmc.style.display == 'none') { 
LMYC(); 
} 
else
{
//document.getElementById(imageName).src="images/sj.gif";
//treePic.src = 'images/nofile.gif'; 
lbmc.style.display = 'none'; 
}
} 

//tab选项卡
var tabnumber=4; 

function tablmyc() { 
var tabnum; 
//var treePic; 
for (i=1;i<=tabnumber;i++) { 
tabnum = eval('tablm' + i); 
var tabName='tabid'+ i; 
document.getElementById(tabName).background="images/tab_titlebg.jpg";
document.getElementById(tabName).className="menu";
tabnum.style.display = 'none'; 
} 
} 

function Showtab(i) { 
tabnum = eval('tablm' + i); 
var tabName='tabid'+ i;
if (tabnum.style.display == 'none') { 
tablmyc(); 
document.getElementById(tabName).background="images/tab_title.jpg";
document.getElementById(tabName).className="title0";
tabnum.style.display = ''; 
} 

} 
    </script>
</head>

<body>
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0" bgcolor="#dbecff">
				<tr id="ye" style="DISPLAY: block">
				<td height="4" background="images/bodybg.jpg"></td>
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
																src="images/cl0.gif"> </strong><strong>客户信息列表</strong>
													</td>
													<td width="81%" height="25" class=body1
														style="text-align: left">
														<img src="images/02a.gif">
														当前位置dfdfd：客户管理 &gt;&gt;客户信息
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
								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="0" bordercolor="#ebebeb"
									borderColorLight="#ebebeb" borderColorDark="#ffffff" id="LM1">
									<TR>
										<TD height=25 align="left" class="body" >
											客户姓名:
											<span class="body"><input type="text"
													name="txtkeyvalue" class="input_border1" id="txtkeyvalue"
													value="" size="20">客户类型<span class="body">：&nbsp;</span>
											</span>
											<select name="ddlPayMethod" class="sel_border"
												id="ddlPayMethod"
												onchange="SingleDictionaryAdd('../Common/Dictionary/SingleDictionaryAdd.aspx?DTypeID=27',this)">
												<option value="">
													请选择
												</option>
												<option value="64">
													个体dfdfdfddf
												</option>
												<option value="65">
													团体
												</option>
												<option value="65">
													其他
												</option>

											</select>
											<span class="body"><span class="body"> </span>电话：<span
												class="body"><input type="text" name="txtkeyvalue"
														class="input_border1" id="txtkeyvalue" value="" size="20">
											</span> </span>
											地&nbsp; &nbsp; 址：
											<span class="body"><input type="text"
													name="txtkeyvalue" class="input_border1" id="txtkeyvalue"
													value="" size="20">
											</span>

											<span style="color: red;"></span>
										</TD>

									</TR>
									<TR align="right">
										
										<TD height=25 valign="top" class=body>
											<span class="body"><span class="body"></span> <span
												class="body"><span class="body"></span>
											</span> <span style="color: red;">&nbsp;&nbsp;&nbsp; <input
														type="button" class="btnl" value="查 询"> </span> <input
													type="button" class="btnl" value="添加"
													onclick="window.location='client/addClientInfo.jsp'">
										</TD>
									</TR>
								</TABLE>
							</td>
						</tr>
						<tr  id="yb" style="DISPLAY: block">
							<td height="10" valign="top">
								<table width="99%" border="0" align="center" cellpadding="0"
									cellspacing="0" bgcolor="#f1f8ff"
									style="border: 1px solid #2686d2; margin-top: 5px">
									<tr>
										<td>
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="189" height="33"
														background="images/titleb_01.jpg" class="title1">
														查询列表
													</td>
													<td background="images/titleb_02.jpg">&nbsp;
														

													</td>
													<td width="213" align="right"
														background="images/titleb_03.jpg"
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
													<td align="center" bgcolor="#F4F5F9" class="body">
														客户编号
													</td>
													<td align="center" bgcolor="#F4F5F9" class="body">
														客户名称
													</td>
													<td align="center" bgcolor="#F4F5F9" class="body">
														客户类型
													</td>
													<td align="center" bgcolor="#F4F5F9" class="body">
														所属区域
													</td>


													<td align="center" bgcolor="#F4F5F9" class="body">
														首要联系人
													</td>
													<td align="center" bgcolor="#F4F5F9" class="body">
														办公电话
													</td>
													<td align="center" bgcolor="#F4F5F9" class="body">
														地址
													</td>

												</tr>
										
												<%
			if(list.size()>0){
			 for(int i=0;i<list.size();i++){
		         Object[] obj = (Object[])list.get(i);
		         
			 %>
												
												<tr onClick="oncli()"
													onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
													onMouseOut="this.style.backgroundColor='';">

													<td width="11%" class="body">
													<%=obj[0]==null?"无数据":obj[0].toString() %>
													</td>
													<td width="27%" class="body">
														<%=obj[1]==null?"无数据":obj[1].toString() %>
													</td>
													<td width="11%" class="body">
														<%=obj[2]==null?"无数据":obj[2].toString() %>
													</td>
													<td width="9%" class="body">
														<%=obj[3]==null?"无数据":obj[3].toString() %>
													</td>
													<td class="body">
													<%=obj[4]==null?"无数据":obj[4].toString() %>
														
													</td>


													<td align="center" class="user">
														<%=obj[5]==null?"无数据":obj[5].toString() %>
													</td>
													<td align="center" class="user">
														<%=obj[6]==null?"无数据":obj[6].toString() %>
													</td>
												</tr>
												<%}} %>
											
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
																	background="images/tab_title.jpg" id="tabid1"
																	class="title0" style="padding-top: 5px">
																	<a href="#" onClick="javascript:Showtab(1)">客户基本信息</a>
																</td>
																<td width="90" align="center"
																	background="images/tab_titlebg.jpg" class="menu"
																	id="tabid2" style="padding-top: 5px">
																	<a href="#" onClick="javascript:Showtab(2)">购买记录</a>
																</td>
																<td width="90" align="center"
																	background="images/tab_titlebg.jpg" class="menu"
																	id="tabid3" style="padding-top: 5px">
																	<a href="#" onClick="javascript:Showtab(3)">联系人</a>
																</td>
																<td width="90" align="center"
																	background="images/tab_titlebg.jpg" class="menu"
																	id="tabid4" style="padding-top: 5px">
																	<a href="#" onClick="javascript:Showtab(4)">销售订单</a>
																</td>
															
																
																<td>&nbsp;
																	

																</td>
																	<td align="right" valign="bottom">
											                        	<table width="72" border="0" cellspacing="0"
															cellpadding="0">
															<tr>
																<td>
																	<img src="images1/btn_01.jpg" width="23" height="19" onClick="test12(1)" title="缩小">
																</td>
																<td>
																	<img src="images1/btn_02.jpg" width="26" height="19" onClick="test12(2)" title="还原">
																</td>
																<td>
																	<img src="images1/btn_03.jpg" width="23" height="19" onClick="test12(3)" title="放大">
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
												src="addClient.html" width="99%" scrolling="yes"
												frameborder="0" height="99%">
											</iframe>
										</td>
									</tr>
									<tr id="tablm2" style="DISPLAY: none">
										<td align="center" valign="top">
											<iframe name="info" marginwidth="0" marginheight="0"
												src="clientSellRecords.html" width="99%" scrolling="yes"
												frameborder="0" height="99%"></iframe>
										</td>
									</tr>
									<tr id="tablm3" style="DISPLAY: none">
										<td align="center" valign="top">
											<iframe name="info" marginwidth="0" marginheight="0"
												src="linkman.html" width="99%" scrolling="yes"
												frameborder="0" height="99%"></iframe>
										</td>
									</tr>
									<tr id="tablm4" style="DISPLAY: none">
										<td align="center" valign="top">
											<iframe name="info" marginwidth="0" marginheight="0"
												src="../distribution/distributionOrder.html" width="99%" scrolling="yes"
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