<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../include/css/style.css" type="text/css" rel="stylesheet"/>

</head>

<body bgcolor="#dbecff">
<form action="client!add.action" method="post"
									id="clientInfor" name="clientInfor">
  <table width="99%" border="0" align="center" cellpadding="0"
						cellspacing="0" bgcolor="#f1f8ff"
						style="border: 0px solid #2686d2; margin-top: 5px">
						<tr>
							<td valign="top">
								
									<table width="100%" border="1" align="center" cellpadding="0"
										cellspacing="0" bordercolor="#bcc3c9"
										borderColorLight="#bcc3c9" borderColorDark="#ffffff"
										bgcolor="#FFFFFF" style="margin-top: 5px">
										<tr>
											<td width="23%" align="right" bgcolor="#F4F5F9">
												客户姓名:
											</td>
											<td align="left" bgcolor="#F4F5F9"
												style="padding-left: 50px;">
												<input type="text" name="clientName" id="clientName" value=""
													style="border-style: solid; border-color: #bcc3c9; border-width: 1px;" />
											</td>
											<td align="right" bgcolor="#F4F5F9">
												客户类型:
											</td>
											<td align="left" bgcolor="#F4F5F9"
												style="padding-left: 50px;">
												<select id="clientType" name="clientType">
													<option value="1" selected>
														个体
													</option>
													<option value="2">
														企业
													</option>
												</select>
											</td>
										</tr>

										<tr>
											<td align="right" bgcolor="#F4F5F9">
												联系人:
											</td>
											<td align="left" bgcolor="#F4F5F9"
												style="padding-left: 50px;">
												<input type="text" name="linkMan" id="linkMan"
													style="width: 250px; border-style: solid; border-color: #bcc3c9; border-width: 1px;" />

											</td>
											<td align="right" bgcolor="#F4F5F9">
												电话:
											</td>
											<td align="left" bgcolor="#F4F5F9"
												style="padding-left: 50px;">
												<input type="text" id="phone" name="phone" value=""
													style="width: 150px; border-style: solid; border-color: #bcc3c9; border-width: 1px;" />
											</td>
										</tr>

										<tr>
											<td align="right" bgcolor="#F4F5F9">
												手机:
											</td>
											<td align="left" bgcolor="#F4F5F9"
												style="padding-left: 50px;">
												<input type="text" id="mobilePhone" name="mobilePhone" value=""
													style="width: 210px; border-style: solid; border-color: #bcc3c9; border-width: 1px;" />
											</td>
											<td align="right" bgcolor="#F4F5F9"> 
												证件类型: 
											</td>
											<td align="left" bgcolor="#F4F5F9"
												style="padding-left: 50px;">
												<select id="provice" name="provice">
													<option value="身份证" selected>
														身份证
													</option>
													
													<option value="军官证">
														军官证
													</option>
												</select>
											</td>
										</tr>

										
									
										<tr  bgcolor="#FAFBFC">
											<td colspan="2" align="right" bgcolor="#F4F5F9">
												地址:
											</td>
											<td colspan="2" align="left" bgcolor="#F4F5F9"
												style="padding-left: 50px;">
												<textarea id="address" name="address"
													style="width: 500px; border-style: solid; border-color: #bcc3c9; border-width: 1px;"></textarea>
											</td>
										</tr>
									</table>
								
							</td>
						</tr>
					</table>
         
          <table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
          <td height="30" align="center"  class="body" >  
          <input type="submit" class="btn"  value="保存"/>
          </td>
              </tr>
          </table>

</form>

</body>
</html>