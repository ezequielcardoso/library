/**
����ʱ��:2009-12-29
������:������
��;:���湦��

*/


/*
page_num��ҳ����
obj_form����
obj_page_no�ڼ�ҳ
total_num������
��1ҳ ��0�ʼ�¼ ��һҳ
��һҳ
��һҳ
��һҳ
���ҳ

*/
function getDataPage(page_num,obj_form,obj_page_no,total_num){
	var inner_html='';
	var firstpage,prevpage,nextpage,lastpage,inputpage,btnpage,showpage,pagecount;
	pagecount=Math.ceil(total_num/page_num);
	if(pagecount>1){
		if(obj_page_no==1){
			firstpage='<TD class=body style="cursor:hand" onclick="javascript:alert(\'�Ѿ�����ǰҳ\');"><IMG height=15 src="'+mBasePath+'/images/page/Page_First.gif" width=14 align=absMiddle alt="��ǰҳ"></TD>';
			prevpage='<TD class=body style="cursor:hand" onclick="javascript:alert(\'�Ѿ��ǵ�һҳ\');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Previous.gif" width=14 align=absMiddle alt="��һҳ"></TD>';
			nextpage='<TD class=body style="cursor:hand" onclick="click_move_to_image('+page_num+','+"document.forms[0]"+','+(parseInt(obj_page_no)+1)+','+total_num+');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Next.gif" width=14 align=absMiddle alt="��һҳ"></TD>';
			lastpage='<TD class=body style="cursor:hand" onclick="click_move_to_image('+page_num+','+"document.forms[0]"+','+pagecount+','+total_num+');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Last.gif" width=14 align=absMiddle alt="���ҳ"></TD>';
		}else if(obj_page_no==pagecount){
			firstpage='<TD class=body style="cursor:hand" onclick="click_move_to_image('+page_num+','+"document.forms[0]"+',1,'+total_num+');"><IMG height=15 src="'+mBasePath+'/images/page/Page_First.gif" width=14 align=absMiddle alt="��ǰҳ"></TD>';
			prevpage='<TD class=body style="cursor:hand" onclick="click_move_to_image('+page_num+','+"document.forms[0]"+','+(parseInt(obj_page_no)-1)+','+total_num+');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Previous.gif" width=14 align=absMiddle alt="��һҳ"></TD>';
			nextpage='<TD class=body style="cursor:hand" onclick="javascript:alert(\'�Ѿ������ҳ\');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Next.gif" width=14 align=absMiddle alt="��һҳ"></TD>';
			lastpage='<TD class=body style="cursor:hand" onclick="javascript:alert(\'�Ѿ������ҳ\');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Last.gif" width=14 align=absMiddle alt="���ҳ"></TD>';
			/*
			inner_html+='<img src="images/BtnPageNext1.gif" title="��һҳ" onclick="click_move_to_image('+page_num+','+"document.forms[0]"+','+(parseInt(obj_page_no)+1)+','+total_num+');" align="absmiddle">&nbsp;';//������һҳ��ť
			*/
		}else{
			firstpage='<TD class=body style="cursor:hand" onclick="click_move_to_image('+page_num+','+"document.forms[0]"+',1,'+total_num+');"><IMG height=15 src="'+mBasePath+'/images/page/Page_First.gif" width=14 align=absMiddle alt="��ǰҳ"></TD>';
			prevpage='<TD class=body style="cursor:hand" onclick="click_move_to_image('+page_num+','+"document.forms[0]"+','+(parseInt(obj_page_no)-1)+','+total_num+');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Previous.gif" width=14 align=absMiddle alt="��һҳ"></TD>';
			nextpage='<TD class=body style="cursor:hand" onclick="click_move_to_image('+page_num+','+"document.forms[0]"+','+(parseInt(obj_page_no)+1)+','+total_num+');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Next.gif" width=14 align=absMiddle alt="��һҳ"></TD>';
			lastpage='<TD class=body style="cursor:hand" onclick="click_move_to_image('+page_num+','+"document.forms[0]"+','+pagecount+','+total_num+');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Last.gif" width=14 align=absMiddle alt="���ҳ"></TD>';
		}
		inputpage='<TD class=body><INPUT name="pagename" class=btn_page id="pagename" value="'+obj_page_no+'" size="3"></TD>';
		btnpage='<TD class=body><INPUT class=btn_page type=button value=GO onclick="click_jump_to_image('+page_num+','+"document.forms[0]"+',document.forms[0].pagename,'+total_num+');"></TD>';		
	}else{
		firstpage='<TD class=body style="cursor:hand" onclick="javascript:alert(\'�Ѿ�����ǰҳ\');"><IMG height=15 src="'+mBasePath+'/images/page/Page_First.gif" width=14 align=absMiddle alt="��ǰҳ"></TD>';
		prevpage='<TD class=body style="cursor:hand" onclick="javascript:alert(\'�Ѿ��ǵ�һҳ\');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Previous.gif" width=14 align=absMiddle alt="��һҳ"></TD>';
		nextpage='<TD class=body style="cursor:hand" onclick="javascript:alert(\'�Ѿ������ҳ\');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Next.gif" width=14 align=absMiddle alt="��һҳ"></TD>';
		lastpage='<TD class=body style="cursor:hand" onclick="javascript:alert(\'�Ѿ������ҳ\');"><IMG height=15 src="'+mBasePath+'/images/page/Page_Last.gif" width=14 align=absMiddle alt="���ҳ"></TD>';
		inputpage='<TD class=body><INPUT name=pagename class=btn_page id=pagename value="'+obj_page_no+'" size="3"></TD>';
		btnpage='<TD class=body><INPUT class=btn_page type=button value=GO onclick="javascript:alert(\'Ŀǰֻ��һҳ,���������ת!\');"></TD>';
	}
	showpage='<TD class=body>&nbsp;'+page_num+'��/ҳ&nbsp;��&nbsp;'+total_num+'��&nbsp;'+pagecount+'ҳ</TD>';
	inner_html=firstpage+prevpage+nextpage+lastpage+inputpage+btnpage+showpage;
	document.write(inner_html);
}


/**
 * 
 * ֱ����ת���ڼ�ҳ
 */
function click_jump_to_image(page_num, obj_form, obj_page_no,total_num){
	if(obj_page_no==null||obj_page_no.value.length<1){
		alert('������ҳ����');
		return;
	}
	if(!checkNumber(obj_page_no,'ҳ��')){
	  return false;
	}
	if(parseInt(obj_page_no.value*page_num)-9>total_num){
		alert('����ҳ�淶Χ!');
		return false;
	}
	obj_form.curr_page.value=obj_page_no.value;
	obj_form.submit();

 
}


/**
 * 
 * ��һҳ������һҳ
 */
function click_move_to_image(page_num, obj_form, obj_page_no,total_num){  
  obj_form.curr_page.value=obj_page_no;
  obj_form.submit();
  return false;
}