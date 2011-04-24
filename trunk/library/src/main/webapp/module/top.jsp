<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<%@ include file="/common/common.jsp"%>
		<link href="<%=path%>/css/style.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="500" valign="top"  
								background="<%=path%>/images/module/main_02.jpg">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="51">
											&nbsp;
										</td>
									</tr>
									<tr>
										<td height="21" style="padding-left: 42px" class="title">
											<MARQUEE onmouseover=
	Javascript:
	;
this.stop();
onmouseout=
	Javascript:
	;
this.start();
scrollAmount=4 scrollDelay=40 width="100%"
												height=13>
												图书馆管理系统试用版
											</MARQUEE>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="27">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="508" height="27"
								background="<%=path%>/images/module/title_01.jpg" align="right">
								&nbsp;&nbsp;欢迎您：administrator&nbsp;&nbsp;
								<img src="<%=path%>/images/module/play.gif" width="16"
									height="17" align="absmiddle">
								&nbsp;
								<SCRIPT language=javascript>
	var isnMonths = new initArray("01月", "02月", "03月", "04月", "05月", "06月",
			"07月", "08月", "09月", "10月", "11月", "12月");
	var isnDays = new initArray("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
	today = new Date();
	function initArray() {
		for (i = 0; i < initArray.arguments.length; i++)
			this[i] = initArray.arguments[i];
	}
	function getFullYear(d) {
		yr = d.getYear();
		if (yr < 1000)
			yr += 1900;
		return yr;
	}
	document.write(getFullYear(today) + "年" + isnMonths[today.getMonth()]
			+ today.getDate() + "日&nbsp;" + isnDays[today.getDay()]);
</SCRIPT>
							</td>
							<td background="<%=path%>/images/module/title_02.jpg">
								&nbsp;
							</td>
							<td width="500" align="right"
								background="<%=path%>/images/module/title_03.jpg">
								<a href="main.htm" target="mainFrame"><img
										src="<%=path%>/images/module/home.gif" align="absmiddle">首页</a>&nbsp;
								<a href="login.html" target="_parent"><img
										src="<%=path%>/images/module/quit.jpg" align="absmiddle">退出系统&nbsp;&nbsp;</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
