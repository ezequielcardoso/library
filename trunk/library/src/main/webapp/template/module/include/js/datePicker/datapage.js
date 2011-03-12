/**
创建时间:2009-12-29
创建人:张宇清
用途:分面功能

*/


/*
page_num分页行数
obj_form表单名
obj_page_no第几页
total_num总行数
第1页 共0笔记录 下一页
第一页
下一页
上一页
最后页

*/
function getDataPage(page_num,obj_form,obj_page_no,total_num){
	var inner_html='';
	var firstpage,prevpage,nextpage,lastpage,inputpage,btnpage,showpage,pagecount;
	pagecount=Math.ceil(total_num/page_num);
	if(pagecount>1){
		if(obj_page_no==1){
			firstpage='<TD class=body style="cursor:hand" onclick="javascript:alert(\'已经是最前页\');"><IMG height=15 src="'+mBasePath+'/images/page/Page_First.gif" width=14 align=absMiddle alt="最前页"></TD>';
			prevpage='<TD class=body style="cursor:hand" onclick="javascript:alert(\'已经是第一页\');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Previous.gif" width=14 align=absMiddle alt="上一页"></TD>';
			nextpage='<TD class=body style="cursor:hand" onclick="click_move_to_image('+page_num+','+"document.forms[0]"+','+(parseInt(obj_page_no)+1)+','+total_num+');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Next.gif" width=14 align=absMiddle alt="下一页"></TD>';
			lastpage='<TD class=body style="cursor:hand" onclick="click_move_to_image('+page_num+','+"document.forms[0]"+','+pagecount+','+total_num+');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Last.gif" width=14 align=absMiddle alt="最后页"></TD>';
		}else if(obj_page_no==pagecount){
			firstpage='<TD class=body style="cursor:hand" onclick="click_move_to_image('+page_num+','+"document.forms[0]"+',1,'+total_num+');"><IMG height=15 src="'+mBasePath+'/images/page/Page_First.gif" width=14 align=absMiddle alt="最前页"></TD>';
			prevpage='<TD class=body style="cursor:hand" onclick="click_move_to_image('+page_num+','+"document.forms[0]"+','+(parseInt(obj_page_no)-1)+','+total_num+');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Previous.gif" width=14 align=absMiddle alt="上一页"></TD>';
			nextpage='<TD class=body style="cursor:hand" onclick="javascript:alert(\'已经是最后页\');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Next.gif" width=14 align=absMiddle alt="下一页"></TD>';
			lastpage='<TD class=body style="cursor:hand" onclick="javascript:alert(\'已经是最后页\');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Last.gif" width=14 align=absMiddle alt="最后页"></TD>';
			/*
			inner_html+='<img src="images/BtnPageNext1.gif" title="下一页" onclick="click_move_to_image('+page_num+','+"document.forms[0]"+','+(parseInt(obj_page_no)+1)+','+total_num+');" align="absmiddle">&nbsp;';//加上下一页按钮
			*/
		}else{
			firstpage='<TD class=body style="cursor:hand" onclick="click_move_to_image('+page_num+','+"document.forms[0]"+',1,'+total_num+');"><IMG height=15 src="'+mBasePath+'/images/page/Page_First.gif" width=14 align=absMiddle alt="最前页"></TD>';
			prevpage='<TD class=body style="cursor:hand" onclick="click_move_to_image('+page_num+','+"document.forms[0]"+','+(parseInt(obj_page_no)-1)+','+total_num+');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Previous.gif" width=14 align=absMiddle alt="上一页"></TD>';
			nextpage='<TD class=body style="cursor:hand" onclick="click_move_to_image('+page_num+','+"document.forms[0]"+','+(parseInt(obj_page_no)+1)+','+total_num+');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Next.gif" width=14 align=absMiddle alt="下一页"></TD>';
			lastpage='<TD class=body style="cursor:hand" onclick="click_move_to_image('+page_num+','+"document.forms[0]"+','+pagecount+','+total_num+');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Last.gif" width=14 align=absMiddle alt="最后页"></TD>';
		}
		inputpage='<TD class=body><INPUT name="pagename" class=btn_page id="pagename" value="'+obj_page_no+'" size="3"></TD>';
		btnpage='<TD class=body><INPUT class=btn_page type=button value=GO onclick="click_jump_to_image('+page_num+','+"document.forms[0]"+',document.forms[0].pagename,'+total_num+');"></TD>';		
	}else{
		firstpage='<TD class=body style="cursor:hand" onclick="javascript:alert(\'已经是最前页\');"><IMG height=15 src="'+mBasePath+'/images/page/Page_First.gif" width=14 align=absMiddle alt="最前页"></TD>';
		prevpage='<TD class=body style="cursor:hand" onclick="javascript:alert(\'已经是第一页\');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Previous.gif" width=14 align=absMiddle alt="上一页"></TD>';
		nextpage='<TD class=body style="cursor:hand" onclick="javascript:alert(\'已经是最后页\');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Next.gif" width=14 align=absMiddle alt="下一页"></TD>';
		lastpage='<TD class=body style="cursor:hand" onclick="javascript:alert(\'已经是最后页\');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Last.gif" width=14 align=absMiddle alt="最后页"></TD>';
		inputpage='<TD class=body><INPUT name=pagename class=btn_page id=pagename value="'+obj_page_no+'" size="3"></TD>';
		btnpage='<TD class=body><INPUT class=btn_page type=button value=GO onclick="javascript:alert(\'目前只有一页,无须进行跳转!\');"></TD>';
	}
	showpage='<TD class=body>&nbsp;'+page_num+'条/页&nbsp;共&nbsp;'+total_num+'条&nbsp;'+pagecount+'页</TD>';
	inner_html=firstpage+prevpage+nextpage+lastpage+inputpage+btnpage+showpage;
	document.write(inner_html);
}


/**
 * 
 * 直接跳转到第几页
 */
function click_jump_to_image(page_num, obj_form, obj_page_no,total_num){
	if(obj_page_no==null||obj_page_no.value.length<1){
		alert('请输入页数！');
		return;
	}
	if(!checkNumber(obj_page_no,'页码')){
	  return false;
	}
	if(parseInt(obj_page_no.value*page_num)-9>total_num){
		alert('超出页面范围!');
		return false;
	}
	obj_form.curr_page.value=obj_page_no.value;
	obj_form.submit();

 
}


/**
 * 
 * 上一页或者下一页
 */
function click_move_to_image(page_num, obj_form, obj_page_no,total_num){  
  obj_form.curr_page.value=obj_page_no;
  obj_form.submit();
  return false;
}