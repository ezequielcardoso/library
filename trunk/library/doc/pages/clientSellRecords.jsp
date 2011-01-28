<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
				<script type='text/javascript' src='./dwr/engine.js'></script>
		<script type='text/javascript' src='./dwr/util.js'></script>
		<script type='text/javascript' src='./dwr/interface/contractCheck.js'></script>
		<link href="include/css/style.css" type="text/css" rel="stylesheet">
		<title>广州市自来水综合业务管理平台</title>
		<script language="JavaScript">
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



var recordID=0;


function resetQuery()
{
var searchFrm=document.getElementById("sellRecordSearch");
searchFrm.reset();
}




function querySellRecord()
{

	var searchFrm=document.getElementById("sellRecordSearch");
    var keyValue=document.getElementById("keyValue").value;
    
    if(keyValue!=""){
    alert(keyValue);
    	searchFrm.action="sellRecordCURD!querySellRecords.action";
    	searchFrm.submit();
    }
    else{
       alert("请输入查询值。");
      
    }

}


function delSellRecord(method)
{
   if(recordID!=0)
   {
      
        window.location="<%=path%>/sellRecordCURD!"+method+".action?recid="+recordID+"";
   }
   else{
   		alert("请先选择 一条销售记录");
   		return false;
   }
}


function createContract(){
	var sellID=document.getElementById("sell_"+recordID).value;
    var isExist=contractCheck.isContractExist(sellID,resutlHandler);

}

function resutlHandler(data){
  if(data==false){
    alert("该销售单已经签定合同");
    window.location="<%=path%>/ContractCURD!queryClientContract.action?sellId="+recordID+"";  //查询合同信息
  }
  else{
  alert("该销售单尚未签定合同");
  	window.location="<%=path%>/ContractCURD!newContract.action?sellId="+recordID+"";
  }

}


function sellRecordDetail(recordId)
{
      recordID=document.getElementById("sell_"+recordId).value;
      var contractBTN=document.getElementsByName("contractBTN");
      for(i=0;i<contractBTN.length;i++){
      contractBTN[i].disabled="";
       var isExist=contractCheck.isContractExist(recordID,isHandler);
      }
      
}

function isHandler(data)
{
if(data==false){
   
  }
  else{
  
  }
}

function showContract()
{
	var sellID=document.getElementById("sell_"+recordID).value
     window.location="<%=path%>/ContractCURD!queryClientContract.action?sellId="+sellID+"";
}

    </script>
	</head>
	<body>
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0" bgcolor="#dbecff">
			<tr>
				<td height="4" background="images/bodybg.jpg"></td>
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
														<strong>&nbsp;<img src="images/cl0.gif"
																align="absmiddle">销售记录</strong>
													</td>
													<td width="81%" height="25" class=body1
														style="text-align: left">
														<img src="images/02a.gif">
														销售管理>>销售记录
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
											<input type="button" class="btn" value="检索"
												onClick="javascript:ShowFLT(1)">
											&nbsp;
											<input type="button" class="btn" onClick="delSellRecord(1);"
												name="contractBTN" disabled="true" value="删除">
											&nbsp;
											<input type="button" class="btn" name="contractBTN"
												onclick="createContract();" disabled="true" value="生成合同">
											<input type="button" class="btn" name="contractBTN"
												onclick="showContract();" disabled="true" value="合同信息">
											&nbsp;&nbsp;
										</td>
									</tr>
								</table>

								<form action="" id="sellRecordSearch" method="post">
									<table width="98%" border="0" align="center" cellpadding="0"
										cellspacing="0" bordercolor="#ebebeb"
										borderColorLight="#ebebeb" borderColorDark="#ffffff" id="LM1">
										<TR
											onMouseOver="this.style.backgroundColor='#f6fbfe';return true;"
											onMouseOut="this.style.backgroundColor='';">
											<TD height=25 align="left" class="body">
												&nbsp;&nbsp;条件：
												<select name="searchCondition" class="input2"
													id="searchCondition">

													<option value="clientName" selected>
														客户名称
													</option>
													<option value="linkMan">
														联系人
													</option>
													<option value="phone">
														联系电话
													</option>
													<option value="mobilePhone">
														联系人手机
													</option>
													<option value="address">
														地址
													</option>
												</select>
												<span style="color: red">*</span>
											</TD>
										</TR>
										<TR
											onMouseOver="this.style.backgroundColor='#f6fbfe';return true;"
											onMouseOut="this.style.backgroundColor='';">
											<TD height=25 align="left" valign="top" class=body>
												输入值：
												<input name=keyValue type="text" class="input2"
													id="keyValue" value="" size="30">
												<span style="color: red">*&nbsp;&nbsp;&nbsp;&nbsp; <input
														type="button" class="btnl" onClick="querySellRecord();"
														value="查 询"> </span>
												<input type="button" class="btnl" onClick="resetQuery();"
													value="重 设">
											</TD>
										</TR>
									</TABLE>
								</form>

							</td>
						</tr>
						<tr>
							<td valign="top">
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
											<table width="98%" border="1" align="center" cellpadding="0"
												cellspacing="0" bordercolor="#bcc3c9"
												borderColorLight="#bcc3c9" borderColorDark="#ffffff"
												bgcolor="#FFFFFF" style="margin-top: 5px">
												<tr>
													<td width="2%" align="center" bgcolor="#F4F5F9">
														选项
													</td>
													<td width="11%" align="center" bgcolor="#F4F5F9"
														class="body">
														客户名称
													</td>
													<td width="27%" align="center" bgcolor="#F4F5F9"
														class="body">
														购买产品
													</td>
													<td width="11%" align="center" bgcolor="#F4F5F9"
														class="body">
														购买数量
													</td>
													<td width="9%" align="center" bgcolor="#F4F5F9"
														class="body">
														购买日期
													</td>
													<td width="15%" align="center" bgcolor="#F4F5F9"
														class="body">
														总金额
													</td>
													<td width="8%" align="center" bgcolor="#F4F5F9"
														class="body">
														详细情况<span style="color:#FF0000"></span>
													</td>
												</tr>
												<s:iterator value="clientSellRecords" var="record">
					
														<tr align="center"
															onMouseOver="this.style.backgroundColor='#eff1f4';return true;"
															onMouseOut="this.style.backgroundColor='';">
															<td width="2%" align="center">
																<input name="recordSelector"
																	id="sell_1" type="radio"
																	value="1"
																	onclick="1"
																	onselect="1">
															</td>
															<td width="11%" class="body">
																<a style="color: #FF0000"
																	href="">aaa</a>
															</td>
															<td width="27%" class="body">
																<a style="color: #FF0000"
																	href="#">a001
																</a>&nbsp;
															</td>
															<td width="11%" class="body" style="color: #FF0000">
															29
															</td>
															<td width="9%" class="body" style="color: #FF0000">
																2010-10-01
															</td>
															<td class="body" style="color: #FF0000">
																200000
															</td>
															<td align="center" class="user">
																<a
																	href="#">查看</a>
															</td>
														</tr>
												
												</s:iterator>



											</table>
						<table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td height="30" align="center"  class="body" >共有<s:property value="#request.totalNum"/>条记录
                    共<s:property value="#request.pages"/>页
                    现在是第<s:property value="#request.pageNo"/>页
                    
                    <a href="#">[首页]</a>
                    <s:if test="#request.pageNo!=1">
                      <a href="#">[上一页]</a>
                    </s:if>
                    <s:else>
                      <a href="#">[上一页]</a>
                   </s:else>
                   <s:if test="#request.pageNo!=#request.pages">
                     <a href="#">[下一页]</a>
                   </s:if>
                   <s:else>
                   <a href="#">[下一页]</a>
                   </s:else>
                    <a href="#">[尾页]</a><%--
                    
                    &nbsp; 跳转到第
                    <select size="1" id="pageSelector" name="pageNo" onChange="viewpage(this.value,<s:property value="queryMethod"/>);">
                    <%
                  	int pages=1,pageNo=1;
                    if(request.getAttribute("pages")!=null&&request.getAttribute("pageNo")!=null){
                   		 pages=Integer.parseInt(request.getAttribute("pages").toString()); 
                   		 pageNo=Integer.parseInt(request.getAttribute("pageNo").toString()); 
                    }
                    %>
                    
                    	</option>
                    	
                        </select>页
 <script language=javascript>      
  <!--
  function viewpage(val,method)
  {
  window.location="sellRecordCURD!"+method+".action?pageNo="+val+"";
  }
  //-->
                  </script>
										--%></td>
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
