<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>用户中心</title>
</head>

<body>
<!--顶部样式-->
<c:import url="top2.jsp"></c:import>
<!--用户中心-->
<c:import url="zhong.jsp"></c:import>
    <div class=" right_style r_user_style">
      <div class="user_Borders">
       <div class="title_name">
        <span class="name">个人信息设置</span>
       </div>
       <div class="about_user_info">
	<form action="UserServlet" method="post"  enctype="multipart/form-data">
		<input  type="hidden"  name="userid"  value="${u.userid }"/>
		
       <div class="user_layout">
         <ul >
          <li><label class="user_title_name">用户头像：<input type="file"  name="headImage" /></label></li>
          <li><label class="user_title_name">用户昵称：</label><input name="nicheng" type="text"  class="add_text" value="${u.nicheng }"/><i>*</i></li>
          <li><label class="user_title_name">真实姓名：</label><input name="xingming" type="text"  class="add_text" value="${u.xingming }"/><i>*</i></li>
         	
          <li><label class="user_title_name">用户性别：</label>  
               <c:if test="${u.xingbie eq 1 }">
                 <label class="sex"> <input type="radio" name="xingbie" value="1" id="RadioGroup1_0" checked="checked"/><span>男</span></label>
                <label class="sex"><input type="radio" name="xingbie" value="0" id="RadioGroup1_1" /><span>女</span></label> 
          </c:if>
                
              <c:if test="${u.xingbie ne 1 }">
                <label class="sex"> <input type="radio" name="xingbie" value="1" id="RadioGroup1_0" /><span>男</span></label>
                <label class="sex"><input type="radio" name="xingbie" value="0" id="RadioGroup1_1" checked="checked"/><span>女</span></label> 
            </c:if>
                
                <i>*</i>         
          </li>
          <li><label class="user_title_name">手&nbsp;机&nbsp;号：</label><input name="shoujihao" type="text"  class="add_text" value="${u.shoujihao }"/><i>*</i></li>
          <li><label class="user_title_name">邮箱地址：</label><input name="youxiang" type="text"  class="add_text" value="${u.youxiang }"/><i>*</i></li>         
         </ul>
         <div class="operating_btn"><input name="name" type="submit" value="提交"  class="submit—btn"/></div>
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

