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
            <td class="title" style="padding-left:23px"><a href="javascript:void(0)" onClick="javascript:ShowFLT(1,7)"><strong>书刊管理</strong></a></td>
            <td width="32" align="right"><a href="javascript:void(0)" onClick="javascript:ShowFLT(1,7)"><img src="<%=path %>/images/module/t01.jpg" id="tPic1" width="32" height="29"></a></td>
          </tr>
        </table></td>
      </tr>
      <tr id="LM1" >
        <td valign="top" id="treePic1"><table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0" background="<%=path %>/images/module/main_12.jpg">
         <tr>
        <td height="8"><img src="<%=path %>/images/module/main_09.jpg" width="138" height="8"></td>
      </tr>
             <tr>
              <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="<%=path %>/books/findBooksByPages.action" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">图书基本管理</a></td>
            </tr>
			 <tr>
              <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="book/magazineList.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">期刊基本管理</a></td>
            </tr>
             <tr>
              <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="book/category/category.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">图书分类管理</a></td>
            </tr>
            <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="book/statistics/bookStore.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">图书入库统计</a></td>
          </tr>
		   <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="book/statistics/magazineStore.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">期刊入库统计</a></td>
          </tr>
		  <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="book/statistics/managerStore.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">管理员入库统计</a></td>
          </tr>
           <tr>
              <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="book/bookLevel.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">图书密级</a></td>
            </tr>
           <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="book/press/pressManager.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">出版社管理</a></td>
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
              <td class="title" style="padding-left:23px"><a href="javascript:void(0)" onClick="javascript:ShowFLT(2,7)"><strong>借阅归还</strong></a></td>
              <td width="32" align="right"><a href="javascript:void(0)" onClick="javascript:ShowFLT(2,7)"><img src="<%=path %>/images/module/t02.jpg" id="tPic2" width="32" height="29"></a></td>
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
			<a href="borrowReturn/bookBorrow.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">图书借阅登记</a>			</td>
          </tr>
		   <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'">
			<a href="borrowReturn/magazineBorrow.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">期刊借阅登记</a>			</td>
          </tr>
		   
		  <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="borrowReturn/bookReturn.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">图书归还</a></td>
          </tr>
		    <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="borrowReturn/magazineReturn.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">期刊归还</a></td>
          </tr>
        	
			<tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'">
			<a href="borrowReturn/bookPreOrdering.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">图书预约登记</a>
			</td>
          </tr>
		  
		   <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'">
			<a href="borrowReturn/magazinePreOrdering.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">期刊预约登记</a>
			</td>
          </tr>
		  
          <!--<tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="#">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">增加数据</a></td>
          </tr>
          <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="#">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">增加数据</a></td>
          </tr>
          <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="#">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">增加数据</a></td>
          </tr>
          <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="#">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">增加数据</a></td>
          </tr>-->
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
               <td class="title" style="padding-left:23px"><a href="javascript:void(0)" onClick="javascript:ShowFLT(3,7)"><strong>查询统计</strong></a></td>
               <td width="32" align="right"><a href="javascript:void(0)" onClick="javascript:ShowFLT(3,7)"><img src="<%=path %>/images/module/t02.jpg" id="tPic3" width="32" height="29"></a></td>
             </tr>
         </table></td>
       </tr>
      <tr id="LM3" style="DISPLAY: none">
        <td style="height:50px" valign="top" id="treePic3"><table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0" background="<%=path %>/images/module/main_12.jpg">
          <tr>
            <td height="8"><img src="<%=path %>/images/module/main_09.jpg" width="138" height="8"></td>
          </tr>
             <tr>
              <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="basic/bookBorrowed.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">图书借阅查询</a></td>
           </tr> 
			
			<tr>
              <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="basic/magazineBorrowed.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">期刊借阅查询</a></td>
            </tr> 
			  
			 <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'">
			<a href="basic/borrowed.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">借阅统计</a>			</td>
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
               <td class="title" style="padding-left:23px"><a href="javascript:void(0)" onClick="javascript:ShowFLT(4,7)"><strong>读者管理</strong></a></td>
               <td width="32" align="right"><a href="javascript:void(0)" onClick="javascript:ShowFLT(4,7)"><img src="<%=path %>/images/module/t02.jpg" id="tPic4" width="32" height="29"></a></td>
             </tr>
         </table></td>
       </tr>
      <tr id="LM4" style="DISPLAY: none">
        <td style="height:50px" valign="top" id="treePic4"><table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0" background="<%=path %>/images/module/main_12.jpg">
          <tr>
            <td height="8"><img src="<%=path %>/images/module/main_09.jpg" width="138" height="8"></td>
          </tr>
		    <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="reader/readerList.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">读者维护</a></td>
          </tr>
          <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="reader/readerCategory.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">读者类别</a></td>
          </tr>
          <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="reader/readerAccount.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">读者账单</a></td>
          </tr>
		  
		   <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="reader/cardType.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">证件类别</a></td>
          </tr>
		  
          <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="reader/card/cardList.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">借阅证管理</a></td>
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
               <td class="title" style="padding-left:23px"><a href="javascript:void(0)" onClick="javascript:ShowFLT(5,7)"><strong>系统权限</strong></a></td>
               <td width="32" align="right"><a href="javascript:void(0)" onClick="javascript:ShowFLT(5,7)"><img src="<%=path %>/images/module/t02.jpg" id="tPic5" width="32" height="29"></a></td>
             </tr>
         </table></td>
       </tr>
      <tr id="LM5" style="DISPLAY: none">
        <td style="height:50px" valign="top" id="treePic5"><table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0" background="<%=path %>/images/module/main_12.jpg">
          <tr>
            <td height="8"><img src="<%=path %>/images/module/main_09.jpg" width="138" height="8"></td>
          </tr>
          <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="rights/department/department.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">部门管理</a></td>
          </tr>
          <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="rights/user/user.jsp" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">用户管理</a></td>
          </tr>
          <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="rights/role/role.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">角色管理</a></td>
          </tr>
          <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="rights/function/function.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">资源管理</a></td>
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
               <td class="title" style="padding-left:23px"><a href="javascript:void(0)" onClick="javascript:ShowFLT(6,7)"><strong>系统管理</strong></a></td>
               <td width="32" align="right"><a href="javascript:void(0)" onClick="javascript:ShowFLT(6,7)"><img src="<%=path %>/images/module/t02.jpg" id="tPic6" width="32" height="29"></a></td>
             </tr>
         </table></td>
       </tr>
      <tr id="LM6" style="DISPLAY: none">
        <td style="height:50px" valign="top" id="treePic6"><table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0" background="<%=path %>/images/module/main_12.jpg">
          <tr>
            <td height="8"><img src="<%=path %>/images/module/main_09.jpg" width="138" height="8"></td>
          </tr>
		  <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="system/chargeManager.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">书刊收费</a></td>
          </tr>
          <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="system/currencyManager.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">币种管理</a></td>
          </tr>
		  <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="system/loggingMananger.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">日志管理</a></td>
          </tr>
           <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="system/libraryManager.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">图书馆信息管理</a></td>
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
         <td height="29" background="<%=path %>/images/module/main_08.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
             <tr>
               <td class="title" style="padding-left:23px"><a href="javascript:void(0)" onClick="javascript:ShowFLT(7,7)"><strong>其他</strong></a></td>
               <td width="32" align="right"><a href="javascript:void(0)" onClick="javascript:ShowFLT(7,7)"><img src="<%=path %>/images/module/t02.jpg" id="tPic7" width="32" height="29"></a></td>
             </tr>
         </table></td>
       </tr>
      <tr id="LM7" style="DISPLAY: none">
        <td style="height:50px" valign="top" id="treePic7"><table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0" background="<%=path %>/images/module/main_12.jpg">
          <tr>
            <td height="8"><img src="<%=path %>/images/module/main_09.jpg" width="138" height="8"></td>
          </tr>
          <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="distributionStat.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">使用帮助</a></td>
          </tr>
          <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="distributionStat.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">关系系统</a></td>
          </tr>
		  
          <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="distributionStat.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">记事本</a></td>
          </tr>
          <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="distributionStat.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">计算器</a></td>
          </tr>
		   <tr>
            <td height="26" background="<%=path %>/images/module/main_11.jpg" class="menu" onMouseOver="this.style.background='url(<%=path %>/images/module/main_10.jpg)'" onMouseOut="this.style.background='url(<%=path %>/images/module/main_11.jpg)'"><a href="client/clientList.html" target="mainFrame">&nbsp;&nbsp;&nbsp; <img src="<%=path %>/images/module/0.gif">打印机</a></td>
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
