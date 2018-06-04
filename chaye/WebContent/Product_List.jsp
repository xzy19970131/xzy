<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="chaye.Tea"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><base href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/chaye/"><meta charset="utf-8" />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" tyle="text/css" />
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.min.1.8.2.js" type="text/javascript"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript"></script>
<script src="js/common_js.js" type="text/javascript"></script>
<script src="js/footer.js" type="text/javascript"></script>
<!--[if IE 7]>
<link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css">
<![endif]-->
<title>产品列表</title>
</head>

<body>
<!--顶部样式-->
<c:import url="top.jsp"></c:import>
<%-- <%@include file="top.jsp" %> --%>

<!--内页样式-->
 <div class="Inside_pages">
    <div class="products">
    <!--当前位置（面包屑）-->
     <div class="Location_link">
     <em></em><a href="#">产品中心</a>  &lt;   <a href="#">巴山雀舌</a>  
     </div>
    <!--筛选条件样式-->
      <div class="products_Select marginbottom">
       <div class="Filter">
  <div class="Filter_list clearfix">
   <div class="Filter_title"><span>品牌：</span></div>
   <div class="Filter_Entire"><a href="#">全部</a></div>
   <div class="p_f_name">
    <a href="#" title="莱家/Loacker">莱家/Loacker </a>  
	<a href="#" title="">丽芝士/Richeese</a>  
	<a href="#" title="白色恋人/SHIROI KOIBITO ">白色恋人/SHIROI KOIBITO </a> 
	<a href="#">爱时乐/Astick </a> 
	<a href="#">利葡/LiPO </a> 
	<a href="#">友谊牌/Tipo </a> 
	<a href="#"> 三立/SANRITSU  </a>  
	<a href="#"> 皇冠/Danisa </a>  
	<a href="#">丹麦蓝罐/Kjeldsens</a>  
   </div>
  </div>
  <div class="Filter_list clearfix">
  <div class="Filter_title"><span>包装方式：</span></div>
  <div class="Filter_Entire"><a href="#">全部</a></div>
  <div class="p_f_name">
  <a href="#">袋装</a><a href="#">盒装</a><a href="#">罐装</a><a href="#">礼盒装</a><a href="#">散装(称重)</a>
  </div>
  </div>
  <div class="Filter_list clearfix">
  <div class="Filter_title"><span>价格：</span></div>
  <div class="Filter_Entire"><a href="#">全部</a></div>
  <div class="p_f_name">
    <a href="#">0-50</a><a href="#">50-150</a><a href="#">150-500</a><a href="#">500-1000</a><a href="#">1000以上</a>
  </div>
  </div>
 </div>
      </div>
      <!--产品列表列表-->
      <div class="products_list marginbottom">
      <div class="Sorted">
  <div class="Sorted_style">
   <a href="#" class="on">综合<i class="icon-angle-down"></i></a>
   <a href="#">销量<i class="icon-angle-down"></i></a>
   <a href="#">价格<i class="icon-angle-down"></i></a>
   <a href="#">新品<i class="icon-angle-down"></i></a>
   </div>
   <!--页数-->
   <div class="s_Paging">
   <span> 1/12</span>
   <a href="#" class="on">&lt;</a>
   <a href="#">&gt;</a>
   </div>
 </div>
 <!--产品列表样式-->
 <div class="p_list  clearfix">
   <ul>
   
<%--    		<%
					ArrayList<Tea>  teas=(ArrayList<Tea> )request.getAttribute("teas");
					for(Tea  t:teas) {%>
    <li class="gl-item">
	<div class="Borders">
	 <div class="img"><a href="Product_Detailed.html"><img src="Products/<%=t.getShoutu()%>.jpg" style="width:220px;height:220px"/></a></div>	 
	 <div class="name"><a href="Product_Detailed.html"><%=t.getMingzi() %></a></div>
     <div class="Price">商城价：<b>¥<%=t.getXianjia() %></b><span>原价：<em><%=t.getYuanjia() %></em></span></div>
	 <div class="Review">已有<a href="#">2345</a>评论</div>
	 <div class="p-operate">
	  <a href="#" class="p-o-btn Collect"><em></em>收藏</a>
	  <a href="#" class="p-o-btn shop_cart"><em></em>加入购物车</a>
	 </div>
	 </div>
	</li>
		<%}%> --%>
   <c:forEach items="${requestScope.teas }" var="t" varStatus="s" step="2"><!-- varStatus显示循环的状态      下面的index是序列    count是迭代的第几个       
         step是迭代的间隔，默认是1 -->
     
    <li class="gl-item">	<%-- ${s.index} ..${s.count} --%>
	<div class="Borders">  
	
		
	
	 <div class="img"><a href="TeaServlet?method=detail&chayeid=${t.chayeid}"><img src="Products/${t.shoutu}.jpg" style="width:220px;height:220px"/></a></div>	 
	 <div class="name"><a href="Product_Detailed.html">${t.mingzi}</a></div>
     <div class="Price">商城价：<b>¥${t.xianjia}</b><span>原价：<em>${t.yuanjia}</em></span></div>
	 <div class="Review">已有<a href="#">2345</a>评论</div>
	 <div class="p-operate">
	  <a href="#" class="p-o-btn Collect"><em></em>收藏</a>
	  <a href="ShoppingTeaServlet?method=add&chayeid=${t.chayeid}" class="p-o-btn shop_cart"><em></em>加入购物车</a>
	 </div>
	 </div>
	</li>
</c:forEach>

   </ul>
   <div class="Paging_style">
   
   
   				
	<a  href="TeaServlet?method=listTeaByPage&page=1&count=3"  class="pages">首页</a>
	<a  href="TeaServlet?method=listTeaByPage&page=${requestScope.pageBean.previousPage}&count=20"  class="pages">上一页</a>
	<a  href="TeaServlet?method=listTeaByPage&page=${requestScope.pageBean.nextPage}&count=20"  class="pages">下一页</a>
	<a  href="TeaServlet?method=listTeaByPage&page=${requestScope.pageBean.allPages}&count=20"  class="pages">尾页</a>
	
	当前第${requestScope.pageBean.nowPage}页/总共${requestScope.pageBean.allPages}页，
	每页${requestScope.pageBean.everPageCount}条/总共${requestScope.pageBean.allCount}条,
	跳到第
						
   
     <!-- <a href="#" class="pn-prev disabled">&lt;上一页</a>
	 <a href="#" class="on">1</a>
	 <a href="#">2</a>
	 <a href="#">3</a>
	 <a href="#">4</a>
	 <a href="#">下一页&gt;</a>
	 <a href="#">尾页</a>
	<span class="p-skip"><em>共<b>232</b>页&nbsp;&nbsp;到第</em><input id="page_jump_num" value="1" onkeydown="javascript:if(event.keyCode==13){page_jump();return false;}" class="input-txt"><em>页</em><a href="javascript:page_jump();" class="btn btn-default">确定</a></span> -->
   </div>
 </div>
      </div>
      <!--分页样式-->
    <div class="Paging marginbottom">
    
    </div>
    </div>    
      <!--友情链接-->
       <div class="Links">
        <div class="link_title">友情链接</div>
        <div class="link_address"><a href="#">四川茶叶协会</a>  <a href="#">链接地址</a>  <a href="#">链接地址</a>  <a href="#">链接地址 </a>   <a href="#">链接地址</a> <a href="#">链接地址</a> <a href="#">链接地址</a></div>
       </div>
 </div>

<%--  <%@include file="Down.jsp"%> --%>
<c:import url="Down.jsp"></c:import>
</body>
</html>
