<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<base  href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/TeaMallBackStage/">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<title>Basic DataGrid - jQuery EasyUI Demo</title>
</head>
<!-- singleSelect:true,collapsible:true, -->
<!-- rownumbers:true,pagination:true, -->
<body style="margin: 0px;padding: 5px;">
	<table class="easyui-datagrid" id="dg" title="用户列表" style="width:100%;height:400px;margin: 0px;"
			data-options="singleSelect:true,collapsible:true,url:'admin/UserAction!listUserByPage.action?rows=3&page=1',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'userid',width:110,align:'left'">用户账号</th>
				<th data-options="field:'username',width:90,align:'left'">姓名</th>
				<th data-options="field:'nickname',width:110,align:'left'">昵称</th>
				<th data-options="field:'sex',width:40,align:'left'">性别</th>
				<th data-options="field:'age',width:40,align:'left'">年龄</th>
				<th data-options="field:'job',width:60,align:'left'">职业</th>
				<th data-options="field:'image',width:50,align:'left'">头像</th>
			</tr>
		</thead>
	</table>
	
	
	
	<script type="text/javascript">
		$(function(){
			var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
			pager.pagination({
				buttons:[{
					iconCls:'icon-search',
					handler:function(){
						alert('search');
					}
				},{
					iconCls:'icon-add',
					handler:function(){
						alert('add');
					}
				},{
					iconCls:'icon-edit',
					handler:function(){
						alert('edit');
					}
				}]
			});			
		})
	</script>
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
			
			$('#w').window('close')
			
			
			/* $(function(){
				var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
				pager.pagination({
					buttons:[{
						iconCls:'icon-search',
						handler:function(){
							alert('search');
						}
					},{
						iconCls:'icon-edit',
						handler:function(){
							$("#w").panel({'title':'编辑用户信息','width':400,'height':400});
							$("#w").html('<iframe scrolling="auto" frameborder="0"  src="editCar.jsp" style="width:100%;height:100%;"></iframe>');
							$("#w").window("open");
						}
					},{
						iconCls:'icon-remove',
						handler:function(){
							var n=$("#dg").datagrid('getSelected');
							var i=$('#dg').datagrid('getRowIndex', $("#dg").datagrid('getSelected'));
							if(n==null){
								$.messager.alert('温馨提示','必须选中要删除的行才能删除!','error');
							}else
							{
								$.messager.confirm('确认信息', '确认删除编号为:'+n.productid+'的用户信息吗?', function(r){
									if (r){
										$.get("admin/ProductAction!deleteProductInfoByProductId.action?product.productId="+n.productid,function(data){
												var noticeMessage='删除失败!';
												if(data==true){
													noticeMessage='删除成功!'
													$("#dg").datagrid('deleteRow',i)
												    $('#t1').datagrid('reload');  
													//alert(noticeMessage);
												}
												$.messager.show({
													title:'操作提示',
													msg:noticeMessage,
													timeout:2000,
													showType:'slide'
												});
												
												
										})
									}
								});

							}
						}
					},{
						iconCls:'icon-add',
						handler:function(){
							alert('edit');
						}
					}]
				});			
			}) */
			
			

		})
		
		function imageDetail(src){
			src=src.replace("20px","100%");
			src=src.replace("20px","100%");
			$("#w").html(src);
			$('#w').window('open');
		}

	</script>
	
<%-- <c:if test="${requestScope.message eq 'registerSuccess' }">
		<script type="text/javascript">
		$.messager.alert('温馨提示','添加用户成功!','info');
		</script>
	</c:if>
	<c:if test="${requestScope.message eq 'registerFail' }">
		<script type="text/javascript">
		$.messager.alert('温馨提示','添加用户失败!','error');
		</script>
	</c:if> --%>


</body>
</html>