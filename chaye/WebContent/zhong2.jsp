<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <div class="user_left">
     <div class="user_info">
 		${u.touxiang}	
       <div class="Head_portrait"><img src="${u.touxiang}"  width="80px" height="80px"/><!--头像区域--></div>
       		
       <div class="user_name">用户${u.xingming }<a href="#">[个人资料]</a></div>
      </div>
      <ul class="Section">
       <li><a href="#"><em></em><span>我的特色馆</span></a></li>
       <li><a href="user_info.jsp"><em></em><span>个人信息</span></a></li>
       <li><a href="user_Password.jsp"><em></em><span>修改密码</span></a></li>
       <li><a href="#"><em></em><span>我的订单</span></a></li>
       <li><a href="#"><em></em><span>我的评论</span></a></li>
       <li><a href="user_integral.jsp"><em></em><span>我的积分</span></a></li>
       <li><a href="#"><em></em><span>我的收藏</span></a></li>
       <li><a href="user_address.jsp"><em></em><span>收货地址管理</span></a></li>
      </ul>
   </div>