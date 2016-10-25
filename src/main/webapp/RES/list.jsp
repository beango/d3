<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=utf-8"%>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html charset=utf-8">
</head>
<body>
	<h2>Hello World!</h2>
	<a href="<s:url value="/RES_VIPCUSTOMER/add.action" />">add</a>
	<ul>
		<s:iterator value="mapList">
			<li>资源ＩＤ：<s:property value="resId" /> 号码：<s:property
					value="mobile" /> <a
				href="<s:url value="/RES/add?pkid=%{pkid}"  />">edit</a>
				<a href="<s:url value="/RES/delete?pkid=%{pkid}"  />">delete</a></li>

		</s:iterator>
	</ul>
</body>
</html>
