<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base  href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/TeaMallBackStage/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>

<title>修改用户信息</title>
</head>
<body>
	<form id="ff" method="post">
			<div style="margin-bottom:20px">
				账号<input class="easyui-textbox" name="userid" style="width:300px" data-options="label:'Name:',required:true">
			</div>
			<div style="margin-bottom:20px">
				密码<input class="easyui-textbox" name="password" style="width:300px" data-options="label:'Email:',required:true,validType:'email'">
			</div>
			<div style="margin-bottom:20px">
				姓名<input class="easyui-textbox" name="username" style="width:300px" data-options="label:'Subject:',required:true">
			</div>
		
		</form>
<div style="text-align:left;padding:5px 0">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">Submit</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">Clear</a>
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