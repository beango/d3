<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="path" value="%{pageContext.request.contextPath}" />
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
<body>
	<div class="easyui-layout" style="width: 100%; height: 100%;">
		<div data-options="region:'north'" style="height: 50px"></div>
		<div id="p" data-options="region:'west'" title="West"
			style="width: 20%; padding: 10px">
			<p>width: 30%</p>
		</div>
		<div data-options="region:'center'" title="Center" noheader="true" border="false">
			<div class="easyui-tabs" id="tt" style="width: 100%; height: 100%">
				<div title="About" style="padding: 0">
					<p>WELCOM.
					<a href="#" onclick="tabAdd('VIPCUSTOMER', '<%=request.getContextPath()%>/RES_VIPCUSTOMER/list');">ADDTAB</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			setTabs();
		});
		function setTabs() {
			$('#tt').tabs({
				plain : false,
				narrow : true,
				pill : false,
				justified : false
			})
		}
		function tabAdd(title, href, icon)
		{
			var tt = $('#tt');  
			if (tt.tabs('exists', title)){//如果tab已经存在,则选中并刷新该tab          
		        tt.tabs('select', title);  
		        //refreshTab({tabTitle:title,url:href});  
		    } else {  
		        if (href){  
		            var content = '<iframe scrolling="no" frameborder="0"  src="'+href+'" style="width:100%;height:100%;"></iframe>';  
		        } else {  
		            var content = '未实现';  
		        }  
		        tt.tabs('add',{  
		            title:title,  
		            closable:true,  
		            content:content,  
		            iconCls:icon||'icon-default'  
		        });  
		    }  
		}
		/**     
		 * 刷新tab 
		 * @cfg  
		 *example: {tabTitle:'tabTitle',url:'refreshUrl'} 
		 *如果tabTitle为空，则默认刷新当前选中的tab 
		 *如果url为空，则默认以原来的url进行reload 
		 */  
		function refreshTab(cfg){  
		    var refresh_tab = cfg.tabTitle?$('#tt').tabs('getTab',cfg.tabTitle):$('#tt').tabs('getSelected');  
		    if(refresh_tab && refresh_tab.find('iframe').length > 0){  
		    var _refresh_ifram = refresh_tab.find('iframe')[0];  
		    var refresh_url = cfg.url?cfg.url:_refresh_ifram.src;  
		    //_refresh_ifram.src = refresh_url;  
		    _refresh_ifram.contentWindow.location.href=refresh_url;  
		    }  
		}  
	</script>
</body>
</html>
