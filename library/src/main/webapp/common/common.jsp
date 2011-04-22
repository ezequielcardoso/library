<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script language="JavaScript">
	var contextPath = '<%=path%>';
</script>
<link href="<%=path %>/css/style.css" type="text/css" rel="stylesheet" />
<%@ taglib uri="/struts-tags" prefix="s"%>

<script language="JavaScript" src="<%=path %>/js/common/PageSize.js"></script>
