<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/Resources/easyui/jquery.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/Resources/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/Resources/easyui/themes/icon.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/Resources/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/Resources/js/site.js"></script>
</head>
<body>
	<div class="easyui-panel" title="New Topic"
		style="width: 100%; max-width: 400px; padding: 30px 60px;" noheader="true" border="false">
		<s:form id="ff" action="save" theme="simple">
			<div style="margin-bottom: 20px">
				pkid:
				<s:textfield name="customer.pkid" label="pkid"
					class="f1 easyui-textbox" theme="simple" />
			</div>
			<div style="margin-bottom: 20px">
				resId:
				<s:textfield name="customer.resId" label="resid"
					class="f1 easyui-textbox" theme="simple" />
			</div>
			<div style="margin-bottom: 20px">
				mobile:
				<s:textfield name="customer.mobile" label="mobile" theme="simple" />
			</div>
		</s:form>
		<div style="text-align:center;padding:5px 0">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">Submit</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">Clear</a>
        </div>
	</div>
	<script>
        function submitForm(){
            $('#ff').form('submit');
        }
        function clearForm(){
            $('#ff').form('clear');
        }
    </script>
</body>
</html>