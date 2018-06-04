<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base  href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/TeaMallBackStage/">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<title>巴山雀舌茶叶商城后台管理-首页</title>
</head>
<body>
	<div class="easyui-layout" style="width:100%;height:582px;">
	<!-- 这里是标题栏和用户栏 -->
		<div data-options="region:'north'" style="height:100px">
			<h1 style="font-family: 宋体;line-height: 24px;margin-left: 30px;margin-top: 30px;text-shadow: 1px 1px 10px blue;float: left"><span>巴山雀舌茶叶商城后台管理系统</span></h1>
			<img style="width:60px;height:60px;border:red 1px solid;border-radius:30px;margin-left:500px;margin-top:15px" alt="" src="images/people.png"><span style="position:relative;top:-25px;left:10px">张三，欢迎您！<a href="#">|安全退出</a></span>
		</div>
		<!-- 这里是一些链接，方便用户快速跳转 -->
		<div data-options="region:'south',split:true" style="height:50px;"><a href="#">去首页</a>|<a href="#">查阅使用说明</a>|<a href="#">使用前必读</a></div>
		<!-- 这里是菜单栏 -->
		<div data-options="region:'west',split:true" title="导航菜单" style="width:200px;">
			<ul  id="sysmenu" class="easyui-tree" data-options="
				method: 'get',
				animate: true,
			">
			<li  data-options="state:'closed'">
				<span>所有功能</span>
					<ul>
					
						<li data-options="state:'closed'">
							<span>商品管理</span>
							<ul>
								<li>
									<span>待付款</span>
								</li>
								<li>
									<span>待收货</span>
								</li>
								<li>
									<span>待评价</span>
								</li>
							</ul>
						</li>
						
							
								<li data-options="state:'closed'">
								<span>用户管理</span>
								<ul>
								<li  data-options="plain:true,iconCls:'icon-add'">
								<span>添加用户</span>
								</li>
								<li data-options="plain:true,iconCls:'icon-remove'">
									<span>删除用户</span>
								</li>
								<li>
									<span>修改用户</span>
								</li>
								<li>
									<span>查看全部</span>
								</li>
								<li>
									<span>搜索用户</span>
								</li>
								</ul>
							</li>

						
						<li data-options="state:'closed'">
							<span>订单管理</span>
							<ul>
								<li>
									<span>待付款</span>
								</li>
								<li>
									<span>待收货</span>
								</li>
								<li>
									<span>待评价</span>
								</li>
							</ul>
						</li>
						<li data-options="state:'closed'">
							<span>广告推送管理</span>
							<ul>
								<li>
									<span>添加广告</span>
								</li>
								<li>
									<span>删除广告</span>
								</li>
							</ul>
						</li>
						<li data-options="state:'closed'">
							<span>友情链接管理</span>
							<ul>
								<li>
									<span>增加链接</span>
								</li>
								<li>
									<span>删除链接</span>
								</li>
							</ul>
						</li>
						<li data-options="state:'closed'">
							<span>新闻管理</span>
							<ul>
								<li>
									<span>添加新闻</span>
								</li>
								<li>
									<span>删除新闻</span>
								</li>
							</ul>
						</li>
					</ul>
				</li>
			</ul>
		</div>
<!-- 		<div data-options="region:'center'">
			<div id="main" class="easyui-tabs" style="width:100%;height:100%">
	
			</div>
		</div> -->
		<!--  中间区域选项卡区域-->
		<div data-options="region:'center',iconCls:'icon-ok'">
		
			<div id="tt" class="easyui-tabs" data-options="tools:'#tab-tools'" style="width:100%;height:100%">
				<div title="系统消息" style="padding:10px">
					<p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
					<ul>
					<li>easyui is a collection of user-interface plugin based on jQuery.</li>
					<li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
					<li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
					<li>complete framework for HTML5 web page.</li>
					<li>easyui save your time and scales while developing your products.</li>
					<li>easyui is very easy but powerful.</li>
					</ul>
				</div>
				

			</div>
		
		</div>
		
	</div>
	<span style="display:block;line-height:40px;text-align: center">Copyright 2010 - 2015 巴山雀舌 四川巴山雀舌茗茶实业有限公司 zuipin.cn All Rights Reserved&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;川ICP备10200063号-1</span>

<!-- 这是动态管理选项卡的js函数 -->
	<!-- 添加信选项卡的js -->
	<script type="text/javascript">
		var index = 1;
		function addPanel(t,url){
			index++;
			
			if ($('#tt').tabs('exists', t)){
				$('#tt').tabs('select', t);
			} else {
				var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
				$('#tt').tabs('add',{
					title:t,
					content:content,
					closable:true,
					iconCls:'icon-man'
				});
			}
		}
		function removePanel(){
			var tab = $('#tt').tabs('getSelected');
			if (tab){
				var index = $('#tt').tabs('getTabIndex', tab);
				$('#tt').tabs('close', index);
			}
		}
	</script>

	<script type="text/javascript">
		$(document).ready(function(){
			
			
			$('#sysmenu').tree({
				onClick: function(node){
					
					if(node.text=='添加用户'){
						addPanel(node.text,'addUser.jsp');
					}else if(node.text=='删除用户'){
						addPanel(node.text,'delUser.jsp');
					}
					else if(node.text=='修改用户'){
						addPanel(node.text,'modUser.jsp');
					}else if(node.text=='查看全部'){
						addPanel(node.text,'allUser.jsp');
					}else if(node.text=='搜索用户'){
						addPanel(node.text,'selUser.jsp');
					}
				}
			});
		})
	</script>

</body>
</html>