<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@include file="/common/common.jsp"%>
		<%@include file="/common/extInclude.jsp"%>
		<title>广州市自来水综合业务管理平台</title>

		<script type="text/javascript" src="<%=path %>/js/rights/function/Function.js"></script>
		<script type="text/javascript" src="<%=path %>/js/rights/function/FunctionTreePanel.js"></script>

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
													align="absmiddle"><span class="body1" style="text-align: left">系统权限</span></strong>										</td>
								  <td width="81%" height="25" class=body1
											style="text-align: left">
											<img src="<%=path %>/images/module/02a.gif">
												系统权限 &gt;&gt;资源管理
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
					<table width="99%" border="0" align="left" cellpadding="0"
						cellspacing="0" bgcolor="#f1f8ff"
						style="border: 1px solid #2686d2; margin-top: 5px">
						<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="189" height="25"
											background="<%=path %>/images/module/titleb_01.jpg" class="title1">
											资源管理¨
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
								<table width="98%" border="1" align="left" cellpadding="0"
									cellspacing="0" bordercolor="#bcc3c9"
									bordercolorlight="#bcc3c9" bordercolordark="#ffffff"
									bgcolor="#FFFFFF" style="margin-top: 5px">
									<tr>
										<td width="300" height="500" align="left" valign="top">
											<div id="functionGrid">
											</div>
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
