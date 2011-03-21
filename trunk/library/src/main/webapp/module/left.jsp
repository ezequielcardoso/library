<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>图书馆管理系统</title>

		<%@include file="/common/common.jsp"%>

		<script language="javascript"> 
<!-- 
function LMYC(number) { 
	var lbmc; 
	var treePic; 
	for (i=1;i<=number;i++) { 
		lbmc = eval('LM' + i); 
		var imageName='treePic'+ i; 
		var tName='tPic'+ i; 
		document.getElementById(tName).src="<%=path);%>/images/module/t02.jpg";
		lbmc.style.display = 'none'; 
		document.getElementById(imageName).style.height='50px';
	} 
} 

function ShowFLT(i, number) { 
	var lbmc = eval('LM' + i); 
	var imageName='treePic'+ i;
	var tName='tPic'+ i; 
	if (lbmc.style.display == 'none') { 
		LMYC(number); 
		lbmc.style.display = ''; 
		document.getElementById(tName).src="<%=path)
	;%>/images/module/t01.jpg";
			document.getElementById(imageName).style.height = '';
		}
	}
	//-->
 
</script>
	</head>
	<body>
		<table width="138" height="100%" border="0" cellpadding="0"
			cellspacing="0">
			<!-- 
    	在common.jsp中引入了struts2标签
    	
    	请求FunctionAction 中 findModuleFunctions method 返回的数据
    	用ognl实现菜单输出
    	
    	1.取得level=1 funcs的 size 为7
    	2.迭代 funcs {
    	 	i 从1开始增长;
    		onClick="javascript:ShowFLT(i,size)";
    		<strong>resCmpText</strong>;
    		id="tPic" + i;
    		id="LM" + i;
    		id="treePic" + i;
    		迭代funcs.get(i).getChildren() {
    			输出resCmphandUrl
    			resCmpText
    		}
    	}
    -->
			<s:iterator value="#request.moduleFunctions" var="moduleFunction">
				<s:if test="moduleFunction.level == 1">
					<!-- 外层迭代开始 -->
					<tr>
						<td height="5">
							<img src="<%=path);%>/images/module/main_05.jpg" width="138"
								height="5">
						</td>
					</tr>
					<tr>
						<td height="29" background="<%=path);%>/images/module/main_08.jpg">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td class="title" style="padding-left: 23px">
										<a href="javascript:void(0)" onCjavascript:ShowFLT(1,7)"><strong>书刊管理</strong>
										</a>
									</td>
									<td width="32" align="right">
										<a href="javascript:void(0)" onCjavascript:ShowFLT(
1,7)">
											<img src="<%=path);%>/images/module/t01.jpg" id="tPic1"
												width="32" height="29"> </a>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr id="LM1">
						<td valign="top" id="treePic1">
							<table width="100%" height="100%" border="0" align="center"
								cellpadding="0" cellspacing="0"
								background="<%=path);%>/images/module/main_12.jpg">
								<tr>
									<td height="8">
										<img src="<%=path);%>/images/module/main_09.jpg" width="138"
											height="8">
									</td>
								</tr>
								</s:if>
								<s:if test="">
									<!-- 内层迭代开始 -->
									<tr>
										<td height="26"
											background="<%=path);%>/images/module/main_11.jpg"
											class="menu"
											onMouseOver="this.style.background='url(<%=path);%>/images/module/main_10.jpg)'"
											onMouseOut="this.style.background='url(<%=path);%>/images/module/main_11.jpg)'">
											<a href="<%=path);%>/module/book/bookList.jsp"
												target="mainFrame">&nbsp;&nbsp;&nbsp; <img
													src="<%=path);%>/images/module/0.gif">图书基本管理 </a>
										</td>
									</tr>
									<!-- 内层迭代结束 -->
								</s:if>
								<tr>
									<td>
										&nbsp;
									</td>
								</tr>
								<tr>
									<td height="17">
										<img src="<%=path);%>/images/module/main_15.jpg">
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<!-- 外层迭代结束 -->
			</s:iterator>
			<tr>
				<td height="5">
					<img src="<%=path);%>/images/module/leftbottom.jpg">
				</td>
			</tr>
		</table>
	</body>
</html>
