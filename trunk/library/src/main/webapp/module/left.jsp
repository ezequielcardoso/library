<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>图书馆管理系统</title>
		<%@include file="/common/common.jsp"%>

		<script language="javascript"> 

function LMYC(number) { 
	var lbmc; 
	var treePic; 
	for (i=0;i<number;i++) { 
		alert(i);
		lbmc = eval('LM' + i); 
		var imageName='treePic'+ i; 
		var tName='tPic'+ i; 
		document.getElementById(tName).src="<%=path %>/images/module/t02.jpg";
		lbmc.style.display = 'none'; 
		document.getElementById(imageName).style.height='50px';
	} 
} 

function ShowFLT(i, number) { 
	var lbmc = eval('LM' + i); 
	var imageName='treePic'+ i;
	var tName='tPic'+ i; 
	alert("22222222222222222222222222");
    if (lbmc.style.display == 'none') { 
    	alert("111111111111111111");
		LMYC(number); 
		lbmc.style.display = ''; 
		document.getElementById(tName).src="<%=path %>/images/module/t01.jpg";
			document.getElementById(imageName).style.height = '';
		}
	}
 
</script>
	</head>
	<body>
		<table width="138" height="100%" border="0" cellpadding="0"
			cellspacing="0">
				<tr>
					<td height="5">
						<img src="<%=path%>/images/module/main_05.jpg" width="138"
							height="5">
					</td>
				</tr>
				<!-- 外层迭代开始 -->
				<s:iterator value="#request.moduleFunctions" id="parent" status="status" >
					<tr>
						<td height="29" background="<%=path%>/images/module/main_08.jpg">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td class="title" style="padding-left: 23px">
										<a href="javascript:void(0)" onClick="javascript:ShowFLT(<s:property value="#status.index"/>,<s:property value="#request.moduleFunctions.size()"/>-1)"><strong><s:property value="resCmpText"/></strong>
										</a>
									</td>
									<td width="32" align="right">
										<a href="javascript:void(0)" onClick="javascript:ShowFLT(<s:property value="#status.index"/>,<s:property value="#request.moduleFunctions.size()"/>-1)">
											<img src="<%=path%>/images/module/t01.jpg" id="tPic<s:property value="#status.index"/>"
												width="32" height="29"> </a>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr id="LM<s:property value="#status.index"/>">
						<td valign="top" id="treePic<s:property value="#status.index"/>">
							<table width="100%" height="100%" border="0" align="center"
								cellpadding="0" cellspacing="0"
								background="<%=path%>/images/module/main_12.jpg">
								<tr>
									<td height="8">
										<img src="<%=path%>/images/module/main_09.jpg" width="138"
											height="8">
									</td>
								</tr>
								<!-- 内层迭代开始 -->
								<s:iterator id="child" value="children">
								<tr>
									<td height="26"
										background="<%=path%>/images/module/main_11.jpg"
										class="menu"
										onMouseOver="this.style.background='url(<%=path%>/images/module/main_10.jpg)'"
										onMouseOut="this.style.background='url(<%=path%>/images/module/main_11.jpg)'">
										<a href="<%=path%>/module/<s:property value="resCmpHandURL"/>"
											target="mainFrame">&nbsp;&nbsp;&nbsp; <img
												src="<%=path%>/images/module/0.gif"><s:property value="resCmpText"/> </a>
									</td>
								</tr>
								</s:iterator>
								<!-- 内层迭代结束 -->
								<tr>
									<td>
										&nbsp;
									</td>
								</tr>
								<tr>
									<td height="17">
										<img src="<%=path%>/images/module/main_15.jpg">
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</s:iterator>
				<!-- 外层迭代结束 -->
			
			<tr>
				<td height="5">
					<img src="<%=path%>/images/module/leftbottom.jpg">
				</td>
			</tr>
		</table>
	</body>
</html>
