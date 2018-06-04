<%@page language="java"  contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><base href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/chaye/"><meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.min.1.8.2.js" type="text/javascript"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/slide.js"></script>
<script src="js/common_js.js" type="text/javascript"></script>
<script src="js/jquery.foucs.js" type="text/javascript"></script>
<title>修改密码</title>
</head>

<body>
<!--顶部样式-->
<c:import url="top2.jsp"></c:import>

<!--修改密码样式-->
<div class="user_style clearfix" id="user">
<div class="user_title"><em></em>用户中心</div>
  <div class="clearfix user" >
  <!--左侧菜单栏样式-->
<c:import url="zhong2.jsp"></c:import>
    <!--右侧样式-->
    <div class="right_style r_user_style user_right">
      <div class="user_Borders">     
       <div class="title_name">
        <span class="name">修改密码</span>
       </div>
       <!--修改密码样式-->
       <div class="about_user_info">
        <form id="form1" name="form1" method="post" action="">   
       <div class="user_layout">
         <ul >
          <li><label class="user_title_name">原密码：</label><input name="" type="password"  class="add_text"/><i>*</i></li>
          <li><label class="user_title_name">新密码：</label><input name="" type="password"  class="add_text"/><i>*</i></li>
          <li><label class="user_title_name">确认新密码：</label><input name="" type="password"  class="add_text"/><i>*</i></li>         
         </ul>
         <div class="operating_btn"><input name="name" type="submit" value="确认"  class="submit—btn"/></div>
         </div>
          </form>
        
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
