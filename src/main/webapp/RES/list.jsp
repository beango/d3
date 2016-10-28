<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html charset=utf-8">
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
<body style="margin: 0;">
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="add()">ADD</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="edit()">Edit</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="deleteentity()">Remove</a>
	</div>
	<table id="dg" class="easyui-datagrid" title="Basic DataGrid"
		style="width: 100%; height: 100%"
		data-options="singleSelect:true,collapsible:true,url:'<s:url value="/RES_VIPCUSTOMER/getlistjson" />',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'pkid'">pkid</th>
				<th data-options="field:'resId'">resId</th>
				<th data-options="field:'mobile',align:'right'">mobile</th>
				<th data-options="field:'reason',align:'right'">reason</th>
				<th data-options="field:'ctime'"
					formatter="Common.ToLocal">ctime</th>

			</tr>
		</thead>
	</table>

	<script type="text/javascript">
		function add() {
			var url = '<s:url value="/RES_VIPCUSTOMER/add" />';
			OpenDialog('增加', url);
		}
		
		function edit(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
            	var url = '<s:url value="/RES_VIPCUSTOMER/add?pkid=" />' + row.pkid;
    			OpenDialog('增加', url);
            }
        }
		
		function deleteentity(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('Confirm','Are you sure you want to destroy this user?',function(r){
                    if (r){
                        $.post('<s:url value="/RES_VIPCUSTOMER/delete" />',{pkid:row.pkid},function(result){
                            if (result.success){
                                $('#dg').datagrid('reload');    // reload the user data
                            } else {
                                $.messager.show({    // show error message
                                    title: 'Error',
                                    msg: result.errorMsg
                                });
                            }
                        },'json');
                    }
                });
            }
		}
		
		function OpenDialog(title, url) {
			$("#div_Info").remove();
			var div = $("<div id='div_Info' title='"+title+"'></div>")
					.appendTo($("BODY"));
			var content = div.load(url, {});
			$("#div_Info").data("url", url);
			div.dialog({
				autoOpen : true,
				width : 300,
				height : 200,
				modal : true,
				resizable : false,
				bgiframe : true,
				close : function(evt, ui) {
					div.dialog("destroy");
					div.html("").remove();
				}
			});
		}
	</script>
</body>
</html>