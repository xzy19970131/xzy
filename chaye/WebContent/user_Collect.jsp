<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><base href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/chaye/"><meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.min.1.8.2.js" type="text/javascript"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/slide.js"></script>
<script src="js/common_js.js" type="text/javascript"></script>
<script src="js/jquery.foucs.js" type="text/javascript"></script>
<title>我的收藏</title>
</head>

<body>
<!--顶部样式-->
<c:import url="top2.jsp"></c:import>
<!--用户中心(收藏)-->
<div class="user_style clearfix" id="user">
<div class="user_title"><em></em>用户中心</div>
  <div class="clearfix user" >
  <!--左侧菜单栏样式-->
<c:import url="zhong2.jsp"></c:import>
     <!--右侧内容样式-->
   <div class=" right_style r_user_style user_right">
    <div class="user_Borders clearfix">
    <div class="title_name">
        <span class="name">用户收藏</span>
       </div>
   <!--收藏样式-->
    <div class="Collect">
      <ul class="Collect_list">
     
        <li>
       <div class="Collect_pro_name">
         <a href="#" class="delete_Collect"></a>
        <p class="img center"><a href="#"><img src="images/product_img_17.png" /></a></p>
        <p><a href="#">天然绿色多汁香甜无污染水蜜桃</a></p>
        <p class="Collect_Standard">礼盒装</p>
        <p class="Collect_price">￥234</p>
        </div>
       </li>
      </ul>
      <!--分页-->
      <div class="pages_Collect clearfix">
       <a href="#" class="on">《</a>
       <a href="#">1</a>
       <a href="#">2</a>
       <a href="#">3</a>
       <a href="#">4</a>
       <a href="#">》</a>
      </div>
    </div>
    </div>
   </div>
  </div>
 </div>
 <div class="footerbox">
   <!--友情链接-->
       <div class="Links">
        <div class="link_title">友情链接</div>
        <div class="link_address"><a href="#">四川茶叶协会</a>  <a href="#">链接地址</a>  <a href="#">链接地址</a>  <a href="#">链接地址 </a>   <a href="#">链接地址</a> <a href="#">链接地址</a> <a href="#">链接地址</a></div>
       </div>
</div>
<!--底部样式-->
<c:import url="Down.jsp"></c:import>
</body>
</html>
