<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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

function updateProduct(){
	var form=document.getElementById("productInfor");
	form.action="productCURD!updateProduct.action";
	form.submit();
}
    </script>
</head>
<body>
  <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#dbecff">
  <tr>
    <td height="4" background="images/bodybg.jpg"></td>
  </tr>
  <tr>
    <td valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="10" valign="top"><table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
          
            <tr>
              <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0"   class="title_border">
                  <tr>
                    <td width="19%" height="25" style="text-align:left"><strong>&nbsp;<img src="images/cl0.gif" align="absmiddle"  >产品信息</strong></td>
                    <td width="81%" height="25"   class=body1 style="text-align:left"><img src="images/02a.gif"  > 当前位置：产品管理 &gt;&gt;产品信息</td>
                  </tr>
              </table></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td height="10" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" >
            <tr>
              <td height="30" class="body1">&nbsp;
                <input type="button" class="btn" onclick="updateProduct();" value="修 改">
                &nbsp;
                <input type="button" class="btn" onclick="window.history.back(-1);" value="返回">
                &nbsp;
                </td>
            </tr>
          </table>
         <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#ebebeb"  borderColorLight="#ebebeb"
	borderColorDark="#ffffff" id="LM1"  >
              <TR>
                <TD align="left" class="body">&nbsp;</TD>
              </TR>
          </TABLE></td>
      </tr>
      <tr>
        <td valign="top">
        <table width="99%" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#f1f8ff" style="border:1px solid #2686d2;margin-top:5px">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="189" height="33" background="images/titleb_01.jpg" class="title1">&nbsp;</td>
                  <td background="images/titleb_02.jpg">&nbsp;</td>
                  <td width="213" align="right" background="images/titleb_03.jpg" style="padding-bottom:10px">&nbsp;&nbsp;</td>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td valign="top">
            <form action="" method="post" id="productInfor" name="productInfor">
            <input type="hidden" value="<s:property value="productId" />">
   <table width="70%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#bcc3c9"  borderColorLight="#bcc3c9"
	borderColorDark="#ffffff" bgcolor="#FFFFFF" style="margin-top:5px">
              <tr>
                <td width="27%"  align="right" bgcolor="#F4F5F9">产品名称:</td>
                <td width="73%"  align="left" bgcolor="#F4F5F9" style="padding-left:50px;"><input type="text" name="productName" id="productName" value="<s:property value="productName" />" style=" width:500px; border-style:solid; border-color:#bcc3c9; border-width:1px;" /></td>
                </tr>
              <tr onMouseOver="this.style.backgroundColor='#eff1f4';return true;" onMouseOut="this.style.backgroundColor='';">
                 <td width="27%"  align="right" bgcolor="#F4F5F9">产品类型:</td>
                <td width="73%"  align="left" bgcolor="#F4F5F9" style="padding-left:50px;">  
                <select id="protype" name="protype"  style="border-style:solid; border-color:#bcc3c9; width:200px">
                <option value="A"> 类型A</option>
                  <option value="B"> 类型B</option>
                    <option value="C"> 类型C</option>
                </select>
                &nbsp;&nbsp;<a href="#">增加类型</a>
                </td>
                </tr>
              <tr bgcolor="#FAFBFC" onMouseOver="this.style.backgroundColor='#eff1f4';return true;" onMouseOut="this.style.backgroundColor='';">
                 <td width="27%"  align="right" bgcolor="#F4F5F9">产品状态:</td>
                <td width="73%"  align="left" bgcolor="#F4F5F9" style="padding-left:50px;">
                
                <select id="state" name="state"   style="border-style:solid; border-color:#bcc3c9; width:200px;">
                <s:if test='state=="1"'>
                <option value="1" selected>正常供应</option>
                 <option value="-1">已经停产</option>
				<option value="0">现在缺货</option>
                </s:if>
                   <s:if test='state=="-1"'>
                <option value="1" >正常供应</option>
                 <option value="-1" selected>已经停产</option>
				<option value="0">现在缺货</option>
                </s:if>
               <s:if test='state=="0"'>
                <option value="1" >正常供应</option>
                 <option value="-1" >已经停产</option>
				<option value="0" selected>现在缺货</option>
                </s:if>
                </select>
                </td>
                </tr>
              <tr onMouseOver="this.style.backgroundColor='#eff1f4';return true;" onMouseOut="this.style.backgroundColor='';">
                <td width="27%"  align="right" bgcolor="#F4F5F9">产品条形码:</td>
                <td width="73%"  align="left" bgcolor="#F4F5F9" style="padding-left:50px;"><input type="text" readonly style="width:500px; border-style:solid; border-color:#bcc3c9; border-width:1px;" /></td>
                </tr>
              <tr bgcolor="#FAFBFC" onMouseOver="this.style.backgroundColor='#eff1f4';return true;" onMouseOut="this.style.backgroundColor='';">
                <td width="27%"  align="right" bgcolor="#F4F5F9">产品备注:</td>
                <td width="73%"  align="left" bgcolor="#F4F5F9" style="padding-left:50px;">
                <textarea style=" width:500px; border-style:solid; border-color:#bcc3c9; border-width:1px;"></textarea></td>
                </tr>
            </table>
            </form>
             </td>
          </tr>
        </table>
         
          <table width="99%" border="0" align="center" cellpadding="0" cellspacing="0"><tr><td height="30" align="center"  class="body" >&nbsp;</td>
              </tr>
          </table></td>
      </tr>
    </table></td>
  </tr>
</table>

</body>
</html>
