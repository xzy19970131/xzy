<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<meta charset="UTF-8">
	<title>Basic DataGrid - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body style="margin: 0px;padding: 5px;">
	
	<table class="easyui-datagrid" id="dg" title="添加用户" style="width:100%;height:400px;margin: 0px;"
			data-options="singleSelect:true,collapsible:true,url:'admin/UserAction!add.action',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'userid',width:33%,align:'left'">用户编号</th>
				<th data-options="field:'username',width:33%,align:'left'">用户名</th>
				<th data-options="field:'nickname',width:34%,align:'left'">密码</th>
			</tr>
		</thead>
	</table>
<!-- 添加表格的事件-->
<script type="text/javascript">
		$(document).ready(function(){
			$('#dg').datagrid({
				onClickCell: function(index,field,value){
					if(field=='image'){
						imageDetail(value);
					}else if(field=='shipin'){
						value=value.replace("/>","controls='controls' />");
						imageDetail(value);
					}
				}
			});
			
			$('#w').window('close');
</script>
</body>
</html>