<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base  href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/TeaMallBackStage/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>

</head>
<body>

	<div class="easyui-panel" title="用户登录" style="width:100%;max-width:400px;padding:30px 60px;">
	
		<form id="ff"  action="admin/UserAction!login.action" method="post">
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="userid" style="width:100%" data-options="label:'用户名:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-passwordbox" name="password" style="width:100%" data-options="label:'密码:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="code" style="width:100%" data-options="label:'验证码:'">
			</div>
		 	<!--  <input type="submit" value="登录">  -->
			 	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">清空</a> 
		</form>
		<div style="text-align:center;padding:5px 0">
		
 	
		</div>
	</div>
   	<script>
		function submitForm(){
		
			//$('#ff').form('submit');
			 $('#ff').submit(); 	
	/* 		var  code=$("[name='code']").val();
			$.get("admin/CodeAction!checkCode.action?code="+code,function(data){
				if(data=='false')
				{
					$('#dlg').html("<span style='color:red;font-weight:bold'>验证码错误！</span>");
					errorMessage('温馨提示','验证码错误！');
					$('#dlg').dialog('open');
				}else
				{
					$('#ff').submit();
				}
			})
			 */
			
		}
		function clearForm(){
			$('#ff').form('clear');
		}
	</script> 
 


</body>
</html>