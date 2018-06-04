<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>用户积分</title>
</head>

<body>
<!--顶部样式-->

<c:import url="top2.jsp"></c:import>
<!--用户中心(积分)-->
<div class="user_style clearfix" id="user">
<div class="user_title"><em></em>用户中心</div>
  <div class="clearfix user" >
  <!--左侧菜单栏样式-->
<c:import url="zhong2.jsp"></c:import>
    <!--右侧内容样式-->
     <div class="right_style r_user_style">
      <div class="user_Borders">
      <div class="title_name">
        <span class="name">用户积分</span>
       </div>
       <!--积分样式-->
       <div class="user_integral_style slideTxtBox">
         <div class="hd">
          <ul>
           <li>积分获取记录</li>
           <LI>积分使用记录</LI>
          </ul>
         </div>
         <div class="bd">
           <ul>
            <div class="Integral_Number"><em></em>你当前的积分：<b>3434</b></div>
            <table>
             <thead>
               <tr>
                <td>积分获取订单号</td>
                <td>订单金额</td>
                <td>积分</td>
                <td>获取日期</td>
               </tr>
             </thead>
             <tbody>
              <tr>
               <td>4546546546454</td>
               <td>￥345</td>
               <td>455</td>
               <td>2015-12-12 12:23:34</td>
              </tr>
               <tr>
               <td>4546546546454</td>
               <td>￥345</td>
               <td>455</td>
               <td>2015-12-12 12:23:34</td>
              </tr>
               <tr>
               <td>4546546546454</td>
               <td>￥345</td>
               <td>455</td>
               <td>2015-12-12 12:23:34</td>
              </tr>
              
             </tbody>
            </table>
           </ul>
           <ul>
           <div class="Integral_Number"><em></em>你消费的积分：<b>544</b></div>
           </ul>
         </div>
       </div>
       <script>jQuery(".slideTxtBox").slide({trigger:"click"});</script>
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
