<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>����������ˮ�ۺ�ҵ�����ƽ̨</title>
</head>
<frameset rows="99,*,27" cols="*" frameborder="NO" border="0" framespacing="0">
  <frame src="<%=path%>/module/top.jsp" name="topFrame" scrolling="NO" noresize>
  <frameset cols="138,11,*"  frameborder="NO" border="0" framespacing="0" id="indexFrame">
    <frame src="<%=path%>/module/left.jsp" name="leftFrame" scrolling="no" noresize id="leftFrame">
    <frame src="<%=path%>/module/callleftmenu.jsp" name="leftbarFrame" scrolling="NO" noresize>
    <frame src="<%=path%>/module/main.htm" name="mainFrame" noresize scrolling="yes">
  </frameset>
  <frame src="<%=path%>/module/bottom.jsp" name="bottomFrame" scrolling="NO" noresize>
</frameset>
<noframes><body>
<center>
��Ǹ����ҳʹ���˿�ܣ����������������֧�ֿ�ܣ����Ա�ҳ�޷���ʾ����ʹ��֧�ֿ�ܵ�����������
</center>
</body></noframes>
</html>
