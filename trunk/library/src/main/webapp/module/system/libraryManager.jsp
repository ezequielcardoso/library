<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <%@ include file="/common/common.jsp"%>
		<%@ include file="/common/extInclude.jsp"%>
		<link href="<%=path %>/css/style.css" type="text/css" rel="stylesheet" />
		<title>图书馆管理系统</title>
</head>
<body>
  <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#dbecff">
  <tr>
    <td height="2" background="<%=path %>/images/module/bodybg.jpg"></td>
  </tr>
  <tr>
    <td height="274" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="10" valign="top"><table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
          
            <tr>
              <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0"   class="title_border">
                  <tr>
                    <td width="19%" height="25" style="text-align:left"><strong>&nbsp;<img src="<%=path %>/images/module/cl0.gif" align="absmiddle"  >系统管理</strong></td>
                    <td width="81%" height="25"   class=body1 style="text-align:left"><img src="<%=path %>/images/module/02a.gif"  > 当前位置：系统管理 &gt;&gt;图书馆信息管理</td>
                  </tr>
              </table></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td height="10" valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" >
            <tr>
              <td height="30" class="body1">
                <input type="button" class="btn" onClick="alert('设置图书馆信息成功')" value="设 置">
                <input type="button" class="btn" onClick="document.getElementById('productInfor').reset();" value="重 填">
                <input type="button" class="btn"  onClick="window.history.back(-1);" value="返 回">
                </td>
            </tr>
          </table>
        </td>
      </tr>
      <tr>
        <td valign="top">
        <table width="99%" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#f1f8ff" style="border:1px solid #2686d2;margin-top:0px">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="189" height="33" background="<%=path %>/images/module/titleb_01.jpg" class="title1">图书馆信息设置</td>
                  <td height="30" background="<%=path %>/images/module/titleb_02.jpg">&nbsp;</td>
                  <td width="213" align="right" background="<%=path %>/images/module/titleb_03.jpg" style="padding-bottom:10px">&nbsp;&nbsp;</td>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td valign="top">
          
               <table width="55%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#bcc3c9"  borderColorLight="#bcc3c9"
                borderColorDark="#ffffff" bgcolor="#FFFFFF" style="margin-top:5px">
            
                   <tr>
                       <TD height=30 align="right" valign="center" nowrap class=body width="87">
                             图书管名字：
                        </TD>
                         <TD height=25 align="left" valign="top" class=body width="140">
                           <input name="" type="text"  id="" class="" 
                                 size="20" >   
                        </TD>
                        <TD width="107" height=30 align="right" valign="center" nowrap class=body>开户费：</TD>
                         <TD width="284" height=30 align="left" valign="top" class=body>
                           <input name="" type="text"  id="" class="" 
                                 size="20" >
                        </TD> 

            </tr>
            
              <tr>
                       <TD height=30 align="right" valign="center" nowrap class=body width="87">
                             电话：
                     </TD>
                         <TD height=25 align="left" valign="top" class=body width="140">
                           <input name="" type="text"  id="" class="" 
                                 size="20" >   
                        </TD>
                        <TD height=30 align="right" valign="center" nowrap class=body>
                             负责人：
                     </TD>
                         <TD height=30 align="left" valign="top" class=body>
                           <input name="" type="text"  id="" class="" 
                                 size="20" >
                        </TD> 

            </tr>
           
             <tr>
                       <TD height=30 align="right" valign="center" nowrap class=body width="87">押金倍数： </TD>
                         <TD height=25 align="left" valign="top" class=body width="140">
                           <input name="" type="text"  id="" class="" 
                                 size="20" >   
                        </TD>
                        <TD height=30 align="right" valign="center" nowrap class=body>
                             超期日罚金：
                     </TD>
                         <TD height=30 align="left" valign="top" class=body>
                           <input name="" type="text"  id="" class="" 
                                 size="20" >
                        </TD> 

            </tr>
            
             <tr>
                       <TD height=30 align="right" valign="center" nowrap class=body width="87">地址： </TD>
                         <TD height=25 align="left" valign="top" class=body colspan="3">
                           <input name="" type="text"  id="" class="" 
                                 size="68" >   
                        </TD>
            </tr>
                 
            <tr>	
                     <td height="60" align="right" nowrap bgcolor="#F4F5F9">
														简介：													</td>
					  <td height="80" colspan="3" align="left" bgcolor="#F4F5F9">
<textarea cols="53" rows="4"
									style="border-color: #bcc3c9; border-width: 1px;">
                   </textarea>													</td>
											  </tr>

         
            
             </table>
           
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
