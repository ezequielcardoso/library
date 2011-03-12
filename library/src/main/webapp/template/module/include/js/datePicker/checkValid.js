
/**
*�����ˣ�������
*����ʱ�䣺2009-12-28
*���ã����������
*/



/**
 * ��� obj �Ƿ�������ֵ
 * obj �����Ķ���
 * message obj ��������˼��������ʾ
 */
function existString(obj, message)
{
	if (obj.value == null || obj.value.length < 1)
	{
		alert('������' + message + '��');  // �����룺��
		obj.select();
		return false;
	}
		
	return true;
}

/**
 * ��� obj ��û�г��������
 * obj �����Ķ���
 * message obj ��������˼��������ʾ
 * maxLength �����
 */
function maxLength(obj, message, maxLength)
{
	if (obj.value == null) {
		return true;
	}	
	if (obj.value.length > maxLength){
	  alert(message + '������󳤶�' + maxLength + '�����������롣');
		obj.select();
		return false;
	}
	return true;
}

/**
 * ��� obj �Ƿ�������ֵ����û�г��������
 * obj �����Ķ���
 * message obj ��������˼��������ʾ
 * maxLength �����
 */
function maxStringLength(obj, message, maxLength)
{
  if (obj.value == null || obj.value.length < 1){
		alert('������' + message + '��');  // �����룺��
		obj.select();
		return false;
	}	
	if (obj.value.replace(/[^\x00-\xff]/g, "**").length > maxLength){
	  	alert(message + '������󳤶�' + maxLength + '�����������롣');
		obj.select();
		return false;
	}
	return true;
}

/**
 * ��� obj �Ƿ�������ֵ����û�г��������
 * obj �����Ķ���
 * message obj ��������˼��������ʾ
 * maxLength �����
 */
function maxLength(obj, message, maxLength)
{
	if (obj.value == null || obj.value.length < 1)
	{
		return true;
	}	
	if (obj.value.length > maxLength){
	  	alert(message + '������󳤶�' + maxLength + '�����������롣');
		obj.select();
		return false;
	}
	return true;
}

/**
 * ��� obj �Ƿ�������ֵ���Ƿ��㹻��̳��ȣ���û�г��������
 * obj �����Ķ���
 * message obj ��������˼��������ʾ
 * minLength ��̳���
 * maxLength �����
 */
function existStringLength(obj, message, minLength, maxLength)
{
	if (obj.value == null || obj.value.length < 1)
	{
		alert('\u8bf7\u8f93\u5165\uff1a' + message + '\u3002');  // �����룺��
		obj.select();
		return false;
	}	
	if (obj.value.length < minLength){
	  alert(message + '������С����' + minLength + '�����������롣'); 
		obj.select();
		return false;
	}
	if (obj.value.length > maxLength){
	  alert(message + '������󳤶�' + maxLength + '�����������롣');
		obj.select();
		return false;
	}
	return true;
}
/**
 * ��� obj �Ƿ���ѡ��
 * obj �����Ķ���
 * falseValue ʧ��ʱ��ֵ
 * message obj ��������˼��������ʾ
 */
function checkSelect(obj, flaseValue, message)
{
	if (obj.value == flaseValue)
	{
		alert('��ѡ��' + message + '��');
		obj.focus();
		return false;
	}
	
	return true;
}

/**
 * ��� obj �Ƿ���ѡ��(��ָradio��ѡ��)
 * obj �����Ķ���
 * message obj ��������˼��������ʾ
 */
function checkRadioSelect(obj,  message)
{
	flag=0;
	for(i=0;i<obj.length;i++){
		if(obj[i].checked){
		    flag=1;
		}
	}
	if(flag==0){
		alert("��ѡ��"+message);
		return false;
	}
	return true;

}
/**
 * ��� obj �Ƿ����ַ�������
 * obj �����Ķ���
 * name obj ��������˼��������ʾ
 */
function checkCharAndNum(obj, name)
{
	var str = obj.value;
	var re = '[^a-zA-Z0-9]{1,}';
	var r = str.match(re);	
	//alert("r = " + r + " , " + str);
	if (r!=null)
	{
		alert(name + 'ֻ������ĸa-z A-Z ������ 0-9�����ܰ��������ַ���');
		obj.focus();
		obj.select();
		return false;
	}
	return true;
}
/**
 * ��� obj �Ƿ��� EMAIL ��ַ
 * obj �����Ķ���
 * name obj ��������˼��������ʾ
 * isMust��ʾEmail��ַ�Ƿ����Ϊ��,�����0Ϊ����Ϊ�գ������1Ϊ����Ϊ��
 */
function checkEMail(obj, name, isMust)
{
	var str = obj.value;
	if (str == null)
	  str = "";
	  
	if (isMust == 1){
		if (str.length < 1){
		  alert('������' + name + '��');  // �����룺��
			obj.select();
			return false;
		}
	  }
	if (str.length > 0){
		var r1 = str.match('\\.+');	
		var r2 = str.match('\\@+');	
		if (r1 != null && r2 != null)
		{
		  return true;
		}
		else
		{
			alert(name + ' Email��ַ������� . �� @��');
			obj.focus();
			obj.select();
			return false;
		}
		}
	return true;
}
/**
 * ��� obj �Ƿ��ǵ绰����
 * obj �����Ķ���
 * name obj ��������˼��������ʾ
 */
function checkTel(obj, name)
{
	var str = obj.value;
	var re = '[^0-9-]{1,}';
	var r = str.match(re);	
	if (r!=null)
	{
		alert(name + 'ֻ�������� 0-9 �� -�����ܰ��������ַ���');
		obj.focus();
		obj.select();
		return false;
	}
	return true;
}
/**
 * ��� obj �Ƿ�������
 * obj �����Ķ���
 * name obj ��������˼��������ʾ
 */
function checkNum(obj, name)
{
	var str = obj.value;
	if (str == null || str.length < 1){
	  return true;
	}
	var re = '^(-{0,1}|\\+{0,1})[0-9]+(\\.{0,1}[0-9]*)$';
	var r = str.match(re);	
	if (r==null)
	{
		alert(name + ' ��������Ч�����֣�ֻ�������� 0-9 �� + - . �����ܰ��������ַ���');
		obj.focus();
		obj.select();
		return false;
	}
	return true;
}
/**
 * ��� obj �Ƿ�������,
 * obj �����Ķ���
 * name obj ��������˼��������ʾ
 */
function checkNumber(obj, name)
{
	if (obj.value == null) {
		return true;
	}
	var str = obj.value;
	var re = '[^0-9.]{1,}';
	var r = str.match(re);	
	if (r!=null)
	{
		alert(name + 'ֻ�������� 0-9 �����ܰ��������ַ���');
		obj.focus();
		obj.select();
		return false;
	}
	return true;
}

/**
 * �����ָ�ʽ����С�������λ�����ñ�����ǰ�뱣֤ pObj ����ֵ��
 * pObj ����ʽ���Ķ���
 */
function changeToFloat(pObj)
{
	var temp = trim(pObj.value); 
	var temp1 = "";
	var temp2 = "";
	if (!isEmpty(temp)){
		if(temp.indexOf("-")==0) {
			temp = temp.substring(1);
			temp1 = "-";
		}
	  temp = ""+Math.round(temp*100);
	  temp2 = temp.substring(0,temp.length-2);
	  if(temp2 ==null || temp2==""){
	   	if(temp.length==1){
	   		temp = "0.0" + temp.substring(temp.length-2);
	    }
	   	else{
	   	  temp = "0."+temp.substring(temp.length-2);
	   	}
	  }
	  else{
	    temp = temp2+"."+temp.substring(temp.length-2);
	  }
	  pObj.value = temp1+temp; 
  }   
}

/**
 * ȥ�ո�
 * pObj ����ʽ���Ķ���
 */
function trim(data)
{
 	return data.replace(/(^\s*)|(\s*$)/g, "");
}

// Function Description: �����ַ�����ʵ�ʳ���, һ��������2������
String.prototype.len=function()
{
	var str=this;
	return str.replace(/[^\x00-\xff]/g, "**").length
}