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
 	User u=(User)session.getAttribute("u");    //取出User数据
	  if( u!=null) {
 %> 
	   
	   <li class="hd_menu_tit zhuce" data-addclass="hd_menu_hover">欢迎光临本店！<a href="UserServlet?method=jiazai&userid=<%=u.getUserid()%>" class="red"><%=u.getXingming() %></a><a href="UserServlet?method=tuichu" class="red">退出登录</a></li>
	   <%}else{ %>
<li class="hd_menu_tit zhuce" data-addclass="hd_menu_hover">欢迎光临本店！<a href="login.jsp" class="red">[请登录]</a> 新用户<a href="registered.jsp" class="red">[免费注册]</a></li>
	   <%} %>
	
 
	   <li class="hd_menu_tit" data-addclass="hd_menu_hover"><a href="#">我的订单</a></li> 
	   <li class="hd_menu_tit" data-addclass="hd_menu_hover"> <a href="shopping_car.jsp">购物车(<b>0</b>)</a> </li>
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
