<%@page import="chaye.UserDao"%>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="chaye.User" %>

<!--顶部样式-->
<div id="top">
  <div class="top">
    <div class="Collection"><em></em><a href="#">收藏我们</a></div>
	<div class="hd_top_manu clearfix">
	  <ul class="clearfix">
	
	
   	 <%
 	User u=(User)session.getAttribute("loginedUser");    //取出User数据
	  if( u!=null) { 
 %> 
	   
	   <li class="hd_menu_tit zhuce" data-addclass="hd_menu_hover">欢迎光临本店！<a href="login.jsp" class="red"><%=u.getXingming() %></a> 新用户<a href="#" class="red">[免费注册]</a></li>
	   <%}else{ %>
<li class="hd_menu_tit zhuce" data-addclass="hd_menu_hover">欢迎光临本店！<a href="login.jsp" class="red">[请登录]</a> 新用户<a href="#" class="red">[免费注册]</a></li>
	   <%} %>
	
 
	   <li class="hd_menu_tit" data-addclass="hd_menu_hover"><a href="#">我的订单</a></li> 
	   <li class="hd_menu_tit" data-addclass="hd_menu_hover"> <a href="#">购物车(<b>0</b>)</a> </li>
	   <li class="hd_menu_tit" data-addclass="hd_menu_hover"><a href="#">联系我们</a></li>
	   <li class="hd_menu_tit list_name" data-addclass="hd_menu_hover"><a href="#" class="hd_menu">客户服务</a>
	    <div class="hd_menu_list">
		   <ul>
		    <li><a href="#">常见问题</a></li>
			<li><a href="#">在线退换货</a></li>
		    <li><a href="#">在线投诉</a></li>
			<li><a href="#">配送范围</a></li>
		   </ul>
		</div>	   
	   </li>
	  </ul>
	</div>
  </div>
</div>



<!--logo和搜索样式-->
<div id="header"  class="header">
  <div class="logo">
  <a href="#"><img src="images/logo.png" /></a>
  <div class="phone">
   免费咨询热线:<span class="telephone">400-3404-000</span>
  </div>
  </div>
  <div class="Search">
    <p><input name="" type="text"  class="text"/><input name="" type="submit" value=""  class="Search_btn"/></p>
	<p class="Words"><a href="#">苹果</a><a href="#">香蕉</a><a href="#">菠萝</a><a href="#">西红柿</a><a href="#">橙子</a><a href="#">苹果</a></p>
</div>
</div>
<!--菜单栏样式-->
<!--导航栏样式-->
<div id="Menu" class="clearfix">
  <div class="Menu_style">
  <div id="allSortOuterbox">
    <div class="Category"><a href="#" class="Menu_img"><em></em></a></div>
    <div class="hd_allsort_out_box_new">
	 <!--左侧栏目开始-->
	 <div class="Menu_list">	
	    <div class="menu_title">茶叶品种</div>
        <a href="Product_List.html">铁观音</a>
        <a href="Product_List.html">茉莉花茶</a>
        <a href="Product_List.html">乌龙茶</a>
        <a href="Product_List.html">冰红茶</a>
 
	</div>
	<form action="searchCarByCondition.jsp" id="boxpanel" class="form-panel" />
	<input type="hidden" name="method" value="chazhao">
	茶叶名<input type="text"  id="chayeming" name="mingzi">	
    <div class="Menu_list">	
	    <div class="menu_title">茶叶价格</div>
    	 最低价<input type="text" style="width: 20px" id="zuidijia" name="min">-----
		<input type="text" style="width: 20px" id="zuigaojia" name="max">最高价
    	 <br>
     	<button id="submitSearch" class="submit-search" type="submit">查找</button>   <!-- 这里一定要用 type=submit ，才能提交表单-->
		
		<script>
			/*function sousuo(){
				
				mingzi=document.getElementById('chayeming').value;
				min=document.getElementById('zuidijia').value;
				max=document.getElementById('zuigaojia').value;

		
			}*/
		</script>
		
			</form>
	</div>	
     <div class="Menu_list">	
	    <div class="menu_title">推荐茶叶</div>
        <ul class="recommend">
         <li><a href="#" title="[2015年新茶]巴山雀舌毛尖茶新茶，含硒">[2015年新茶]巴山雀舌...</a></li>
         <li><a href="#" title="[2015年新茶]巴山雀舌毛尖茶新茶，含硒">[2015年新茶]巴山雀舌...</a></li>
         <li><a href="#" title="[2015年新茶]巴山雀舌毛尖茶新茶，含硒">[2015年新茶]巴山雀舌...</a></li>
         <li><a href="#" title="[2015年新茶]巴山雀舌毛尖茶新茶，含硒">[2015年新茶]巴山雀舌...</a></li>
         <li><a href="#" title="[2015年新茶]巴山雀舌毛尖茶新茶，含硒">[2015年新茶]巴山雀舌...</a></li>
        </ul>
	</div>	
	</div>		
	</div>
	<!--菜单栏-->
	<div class="Navigation" id="Navigation">
		 <ul class="Navigation_name">
			<li><a class="nav_on" id="mynav1"  href="index.html"><span>首页</span></a></li>
			<li><a class="nav_on" id="mynav2"  href="Product_List.html"><span>巴山雀舌</span></a></li>
			<li><a class="nav_on" id="mynav3"  href="#"><span>贡茗</span></a></li>
			<li><a class="nav_on" id="mynav4"  href="#"><span>冠茗</span></a></li>
			<li><a class="nav_on" id="mynav5"  href="#"><span>臧芝堂</span></a></li>
			<li><a class="nav_on" id="mynav6"  href="#"><span>大巴山茶</span></a></li>
			<li><a class="nav_on" id="mynav7"  href="#"><span>达州（茶）</span></a></li>
			<li><a class="nav_on" id="mynav8"  href="Group_buy.htm"><span>今日团购</span></a></li>
			<li><a class="nav_on" id="mynav8"  href="#"><span>联系我们</span></a></li>
		 </ul>			 
		</div>
	<script>$("#Navigation").slide({titCell:".Navigation_name li"});</script>
    <!--购物车-->	
    
     <div class="hd_Shopping_list" id="Shopping_list">
   <div class="s_cart"><em></em><a href="shopping_cart.html">我的购物车</a> <i class="ci-right">&gt;</i><i class="ci-count" id="shopping-amount">0</i></div>
   <div class="dorpdown-layer">
    <div class="spacer"></div>
	 <!--<div class="prompt"></div><div class="nogoods"><b></b>购物车中还没有商品，赶紧选购吧！</div>-->
	 <ul class="p_s_list">	   
		<li>
		    <div class="img"><img src="images/tianma.png"></div>
		    <div class="content"><p><a href="#">产品名称</a></p><p>颜色分类:紫花8255尺码:XL</p></div>
			<div class="Operations">
			<p class="Price">￥55.00</p>
			<p><a href="#">删除</a></p></div>
		  </li>
		</ul>		
	 <div class="Shopping_style">
	 <div class="p-total">共<b>1</b>件商品　共计<strong>￥ 515.00</strong></div>
	  <a href="shopping_cart.html" title="去购物车结算" id="btn-payforgoods" class="Shopping">去购物车结算</a>
	 </div>	 
   </div>	
  </div>
</div>

<!--幻灯片样式-->
<div class="Plates"  id="mian">
<div class="bottom_style clearfix">
    <div class="image_display">
	<!--幻灯片样式-->
	  <div class="slider">
	   <div id="slideBox" class="slideBox">
			<div class="hd">
				<ul></ul>
			</div>
			<div class="bd">
				<ul>
					<li><a href="#" target="_blank"><img src="images/ad-1.png" /></a></li>
			        <li><a href="#" target="_blank"><img src="images/ad-3.jpg" /></a></li>
				</ul>
			</div>
			<a class="prev" href="javascript:void(0)"></a>
			<a class="next" href="javascript:void(0)"></a>
		</div>
		<script type="text/javascript">
		jQuery(".slideBox").slide({titCell:".hd ul",mainCell:".bd ul",autoPlay:true,autoPage:true,interTime:9000});
		</script>
	 </div>     
     </div>
    </div>
</div>