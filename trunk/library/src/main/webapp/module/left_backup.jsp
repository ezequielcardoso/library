<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>图书馆管理系统</title>

<%@include file="/common/common.jsp" %>

<script language="javascript"> 
<!-- 
function LMYC(number) { 
	var lbmc; 
	var treePic; 
    
	for (i=1;i<=number;i++) { 
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
	if (lbmc.style.display == 'none') { 
		LMYC(number); 
		lbmc.style.display = ''; 
		document.getElementById(tName).src="<%=path %>/images/module/t01.jpg";
		document.getElementById(imageName).style.height='';
	} 
} 
//--> 
</script>
</head>
<body>
    <table width="138" height="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td height="5"><img src="<%=path %>/images/module/main_05.jpg" width="138" height="5"></td>
      </tr>
      <tr>
        <td height="29" background="<%=path %>/images/module/main_08.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="title" style="padding-left:23px"><a href="javascript:void(0)" onClick="javascript:ShowFLT(1,6)"><strong>书刊管理</strong></a></td>
            <td width="32" align="right"><a href="javascript:void(0)" onClick="javascript:ShowFLT(1,6)"><img src="<%=path %>/images/module/t01.jpg" id="tPic1" width="32" height="29"></a></td>
          </tr>
        </table></td>
      </tr>
      <tr id="LM1" >
        <td valign="top" id="treePic1"><table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0" background="<%=path %>/images/module/main_12.jpg">
         <tr>
        <td height="8"><img src="<%=path %>/images/module/main_09.jpg" width="138" height="8"></td>
      </tr>
             <tr>
              <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="<%=path %>/book/bookMain.action" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">图书基本管理</a></td>
            </tr>
			 <tr>
              <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="<%=path %>/book/magazineMain.action" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">期刊基本管理</a></td>
            </tr>
            <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="book/bookStore.jsp" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">入库统计</a></td>
          </tr>
           <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="<%=path %>/press/pressMain.action" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">出版社管理</a></td>
          </tr>
		    <tr>
              <td>&nbsp;</td>
          </tr>
          <tr>
              <td height="17"><img src="<%=path %>/images/module/main_15.jpg"></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="29" background="<%=path %>/images/module/main_08.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td class="title" style="padding-left:23px"><a href="javascript:void(0)" onClick="javascript:ShowFLT(2,6)"><strong>借阅归还</strong></a></td>
              <td width="32" align="right"><a href="javascript:void(0)" onClick="javascript:ShowFLT(2,6)"><img src="<%=path %>/images/module/t02.jpg" id="tPic2" width="32" height="29"></a></td>
            </tr>
        </table></td>
      </tr>
      <tr id="LM2" style="DISPLAY: none">
        <td style="height:50px" valign="top" id="treePic2"><table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0" background="<%=path %>/images/module/main_12.jpg">
          <tr>
            <td height="8"><img src="<%=path %>/images/module/main_09.jpg" width="138" height="8"></td>
          </tr>
            <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'">
			<a href="<%=path %>/borrowReturn/bookBorrowMain.action" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">图书借阅登记</a>			</td>
          </tr>
		   <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'">
			<a href="<%=path %>/borrowReturn/magazineBorrowMain.action" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">期刊借阅登记</a>			</td>
          </tr>
		   
		  <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="<%=path %>/borrowReturn/bookReturnMain.action" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">图书归还</a></td>
          </tr>
		    <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="<%=path %>/borrowReturn/magazineReturnMain.action" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">期刊归还</a></td>
          </tr>
        	
		 <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'">
			<a href="<%=path %>/preOreder/bookPreOrderMain.action" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">图书预约登记</a>
			</td>
          </tr>
		  
		   <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'">
			<a href="<%=path %>/module/preOrder/bookPreOrder.jsp" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">图书预约</a>
			</td>
          </tr>

		   <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'">
			<a href="borrowReturn/magazineOrder.jsp" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">期刊预约登记</a>
			</td>
          </tr>
		  
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td height="17"><img src="<%=path %>/images/module/main_15.jpg"></td>
          </tr>
        </table></td>
      </tr>
     
	  <tr>
         <td height="29" background="<%=path %>/images/module/main_08.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
             <tr>
               <td class="title" style="padding-left:23px"><a href="javascript:void(0)" onClick="javascript:ShowFLT(3,6)"><strong>查询统计</strong></a></td>
               <td width="32" align="right"><a href="javascript:void(0)" onClick="javascript:ShowFLT(3,6)"><img src="<%=path %>/images/module/t02.jpg" id="tPic3" width="32" height="29"></a></td>
             </tr>
         </table></td>
       </tr>
      <tr id="LM3" style="DISPLAY: none">
        <td style="height:50px" valign="top" id="treePic3"><table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0" background="<%=path %>/images/module/main_12.jpg">
          <tr>
            <td height="8"><img src="<%=path %>/images/module/main_09.jpg" width="138" height="8"></td>
          </tr>
             <tr>
              <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="<%=path %>/module/statistics/bookBorrowed.jsp" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">图书借阅查询</a></td>
           </tr> 
			
			<tr>
              <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="<%=path %>/module/statistics/magazineBorrowed.jsp" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">期刊借阅查询</a></td>
            </tr> 
			  
			 <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'">
			<a href="<%=path %>/module/statistics/readerBorrowed.jsp" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">读者借阅统计</a>			</td>
          </tr> 
		
          <tr>
            <td>&nbsp;</td>
          </tr>
		  
          <tr>
            <td height="17"><img src="<%=path %>/images/module/main_15.jpg"></td>
          </tr>
        </table></td>
      </tr>
	  
	  
	   <tr>
         <td height="29" background="<%=path %>/images/module/main_08.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
             <tr>
               <td class="title" style="padding-left:23px"><a href="javascript:void(0)" onClick="javascript:ShowFLT(4,6)"><strong>读者管理</strong></a></td>
               <td width="32" align="right"><a href="javascript:void(0)" onClick="javascript:ShowFLT(4,6)"><img src="<%=path %>/images/module/t02.jpg" id="tPic4" width="32" height="29"></a></td>
             </tr>
         </table></td>
       </tr>
      <tr id="LM4" style="DISPLAY: none">
        <td style="height:50px" valign="top" id="treePic4"><table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0" background="<%=path %>/images/module/main_12.jpg">
          <tr>
            <td height="8"><img src="<%=path %>/images/module/main_09.jpg" width="138" height="8"></td>
          </tr>
		    <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="<%=path %>/reader/readerMain.action" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">读者维护</a></td>
          </tr>
          <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="<%=path %>/readerType/readerTypeMain.action" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">读者类别</a></td>
          </tr>
          <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="reader/readerAccount.jsp" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">读者账单</a></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
          </tr>
		  
          <tr>
            <td height="17"><img src="<%=path %>/images/module/main_15.jpg"></td>
          </tr>
          
        </table></td>
      </tr>
	  
	   <tr>
         <td height="29" background="<%=path %>/images/module/main_08.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
             <tr>
               <td class="title" style="padding-left:23px"><a href="javascript:void(0)" onClick="javascript:ShowFLT(5,6)"><strong>系统权限</strong></a></td>
               <td width="32" align="right"><a href="javascript:void(0)" onClick="javascript:ShowFLT(5,6)"><img src="<%=path %>/images/module/t02.jpg" id="tPic5" width="32" height="29"></a></td>
             </tr>
         </table></td>
       </tr>
      <tr id="LM5" style="DISPLAY: none">
        <td style="height:50px" valign="top" id="treePic5"><table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0" background="<%=path %>/images/module/main_12.jpg">
          <tr>
            <td height="8"><img src="<%=path %>/images/module/main_09.jpg" width="138" height="8"></td>
          </tr>
          <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="<%=path %>/module/rights/user.jsp" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">用户管理</a></td>
          </tr>
          <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="<%=path %>/module/rights/role.jsp" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">角色管理</a></td>
          </tr>
          <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="<%=path %>/module/rights/function.jsp" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">资源管理</a></td>
          </tr>
		  <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="<%=path %>/module/rights/dict.jsp" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">字典维护</a></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
          </tr>
		  
          <tr>
            <td height="17"><img src="<%=path %>/images/module/main_15.jpg"></td>
          </tr>
        </table></td>
      </tr>
	  
	  <tr>
         <td height="29" background="<%=path %>/images/module/main_08.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
             <tr>
               <td class="title" style="padding-left:23px"><a href="javascript:void(0)" onClick="javascript:ShowFLT(6,6)"><strong>系统管理</strong></a></td>
               <td width="32" align="right"><a href="javascript:void(0)" onClick="javascript:ShowFLT(6,6)"><img src="<%=path %>/images/module/t02.jpg" id="tPic6" width="32" height="29"></a></td>
             </tr>
         </table></td>
       </tr>
      <tr id="LM6" style="DISPLAY: none">
        <td style="height:50px" valign="top" id="treePic6"><table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0" background="<%=path %>/images/module/main_12.jpg">
          <tr>
            <td height="8"><img src="<%=path %>/images/module/main_09.jpg" width="138" height="8"></td>
          </tr>
		  <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="<%=path %>/punishment/readerAccountMain.action" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">书刊收费管理</a></td>
          </tr>
           <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="<%=path %>/punishment/readerAccountMain.action" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">借阅证挂失</a></td>
          </tr>
		  <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="<%=path %>/sysLog/sysLogMain.action" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">系统日志管理</a></td>
          </tr>
           <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="<%=path %>/libInfo/libInfoMain.action" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">图书馆信息管理</a></td>
          </tr>
		  <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="distributionStat.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">数据备份与还原</a></td>
          </tr>
		 
          <tr>
            <td>&nbsp;</td>
          </tr>
		  
          <tr>
            <td height="17"><img src="<%=path %>/images/module/main_15.jpg"></td>
          </tr>
        </table></td>
      </tr>
	  
      <tr>
        <td height="5"><img src="<%=path %>/images/module/leftbottom.jpg"></td>
      </tr>
    </table>
	

</body>
</html>
