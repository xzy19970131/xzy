<%@page import="chaye.UserDao"%>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="chaye.User" %>

<!--顶部样式-->
<c:import url="top3.jsp"></c:import>


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
