<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/Resources/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/Resources/easyui/themes/icon.css" />
</head>
<body>
	<s:form action="save">
		<s:textfield name="customer.pkid" label="pkid" />
		<s:textfield name="customer.resId" label="resid" />
		<s:textfield name="customer.mobile" label="mobile" />
		<s:submit />
	</s:form>
</body>
</html>