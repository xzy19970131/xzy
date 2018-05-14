<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" tyle="text/css" />
<script src="js/jquery.min.1.8.2.js" type="text/javascript"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript"></script>
<script src="js/common_js.js" type="text/javascript"></script>
<script src="js/footer.js" type="text/javascript"></script>


<%-- <c:import url="java.util.ArrayList"></c:import> --%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="chaye.TeaDaoImp"%>
<%@page import="chaye.Tea"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %><!-- EL的函数库=jstl的函数 -->

<c:if test="${requestScope.allTeas  eq  null}">
	<c:redirect  url="TeaServlet?method=index"></c:redirect><!-- 跳转页面的标签，重定向 -->
</c:if>

<%-- <c:set var="age" value="66" scope="request"></c:set>   测试<c:choose>标签用法 
<c:choose>
	<c:when test="${requestScope.age<10 }">111</c:when>
	<c:when test="${requestScope.age<20 }">222</c:when>
	<c:when test="${requestScope.age<30 }">333</c:when>
	<c:when test="${requestScope.age<40 }">444</c:when>
	<c:otherwise>sss</c:otherwise>
</c:choose> --%>


<c:forTokens items="肖振宇，王，啦啦啦" delims="，" var="n">
<Span style="border: 1px black yellow; margin-right: 10px;">${n }</Span>
</c:forTokens>

<title>茶叶商城首页</title>
</head>

<body>
<%-- <%@include file="top.jsp" %> --%>
<c:import url="top.jsp"></c:import>

      <!--内容样式-->
        <div class="Selling_list">        
         <div id="slideBox_list" class="slideBox_list">
           <div class="hd">
				<span class="arrow"><a class="next"></a><a class="prev"></a></span>
				<ul><li><a href="#">热销产品</a></li><li><a href="#">新品推荐</a></li><li><a href="#">限时促销</a></li></ul>
			</div>
			<div class="bd">
			 <ul>
             <li class="s_Products">
              <div class="Products_list_name">
					   <div class="img center"><a href="Product_Detailed.html"><img src="Products/2.jpg" /></a></div>
					   <div class="title_name"><a href="Product_Detailed.html">【2015年新茶】巴山雀舌60克毛尖马克罐（绿）</a></div>
					   <div class="s_Price clearfix">
                       <span class="Current_price">商城价<em>￥39.00</em></span>
                       <span class="Original_Price">原价&nbsp;<em>76.00</em></span>
                       </div>
                       <div class="p_comment">已有<a href="#">2345</a>人评论</div>
             
              </div>
				 </li>
					
				
             </ul>
               <ul>
             <li class="s_Products">
              <div class="Products_list_name">
					   <div class="img center"><a href="#"><img src="Products/2.jpg" /></a></div>
					   <div class="title_name"><a href="#">【2015年新茶】巴山雀舌60克毛尖马克罐（绿）</a></div>
					   <div class="s_Price clearfix">
                       <span class="Current_price">商城价<em>￥39.00</em></span>
                       <span class="Original_Price">原价&nbsp;<em>76.00</em></span>
                       </div>
                      <div class="time">剩余时间：<i>5</i>时<i>30</i>分<i>34</i>秒</div>
              </div>
				 </li>
					<li class="s_Products">
                     <div class="Products_list_name">
					   <div class="img center"><a href="#"><img src="Products/3.jpg" /></a></div>
					   <div class="title_name"><a href="#">52°五岭洞藏黑金刚1500ml(双瓶装)</a></div>
					   <div class="s_Price clearfix">
                       <span class="Current_price">商城价<em>￥39.00</em></span>
                       <span class="Original_Price">原价&nbsp;<em>76.00</em></span>
                       </div>
                        <div class="time">剩余时间：<i>5</i>时<i>30</i>分<i>34</i>秒</div>
                       </div>
					</li>	
					<li class="s_Products">
                     <div class="Products_list_name">
					   <div class="img center"><a href="#"><img src="Products/1.jpg" /></a></div>
					   <div class="title_name"><a href="#">52°泸州老窖封藏老酒（窖藏）</a></div>
					  <div class="s_Price clearfix">
                       <span class="Current_price">商城价<em>￥39.00</em></span>
                       <span class="Original_Price">原价&nbsp;<em>76.00</em></span>
                       </div>
                       <div class="time">剩余时间：<i>5</i>时<i>30</i>分<i>34</i>秒</div>
                       </div>
					</li>
					<li class="s_Products">
                      <div class="Products_list_name">
					   <div class="img center"><a href="#"><img src="Products/3.jpg" /></a></div>
					   <div class="title_name"><a href="#">桐木关正山小种 特级XZ1390-250g 天地盖硬盒 本朴</a></div>
					 <div class="s_Price clearfix">
                       <span class="Current_price">商城价<em>￥39.00</em></span>
                       <span class="Original_Price">原价&nbsp;<em>76.00</em></span>
                       </div>
                       <div class="time">剩余时间：<i>5</i>时<i>30</i>分<i>34</i>秒</div>
                       </div>
					</li>	
					<li class="s_Products">
                     <div class="Products_list_name">
					   <div class="img center"><a href="#"><img src="Products/3.jpg" /></a></div>
					   <div class="title_name"><a href="#">52°泸州老窖封藏老酒（窖藏）</a></div>
					   <div class="s_Price clearfix">
                       <span class="Current_price">商城价<em>￥39.00</em></span>
                       <span class="Original_Price">原价&nbsp;<em>76.00</em></span>
                       </div>
                     <div class="time">剩余时间：<i>5</i>时<i>30</i>分<i>34</i>秒</div>
                       </div>	
                       </li>	
             </ul>
            </div>
         </div>
         <script type="text/javascript">jQuery(".slideBox_list").slide();</script>
       </div>
       <!--产品系列样式表-->
       <div class="Area"> 
         <div class="Area_title">
         <div class="name"><em class="icon_title"></em>巴山雀舌系列</div>
         <div class="right">
         <span class="p_link"><a href="#">贡茶</a><a href="#">毛尖茶</a><a href="#">乌龙茶</a><a href="#">贡茶</a></span>
         <span class="more"><a href="#">更多《</a></span>
         </div>
         </div>
         <div class="Area_list clearfix">
          <div class="Area_ad">
            <a href="#"><img src="images/AD-04.jpg" /></a>
            <a href="#"><img src="images/AD-03.jpg" /></a>
          </div>
          <div class="Area_p_list">
          <ul>
  <%--
//***********************************************
//***********************************************
//***********************************************
//***********************************************--%>
      <c:forEach  var="t"  items="${requestScope.allTeas }" varStatus="s">
        		
			
        	<li class="s_Products">
            <div class="Area_product_c">
                     <div class="img center">
                     		<a href="TeaServlet?method=detail&chayeid=${t.chayeid}"><img src="Products/${t.shoutu}.jpg" />
                     		</a>
                     </div>
					 
					   <div class="title_name"><a href="#"><%-- ${fn:substring(t.mingzi,0,2)} 第一个是数据源，第二个是开始位子，第三个是长度为2--%>${t.mingzi}</a></div>
					   <div class="s_Price clearfix">
                       <span class="Current_price">商城价<em>￥${t.xianjia}</em></span>
                       <span class="Original_Price">原价&nbsp;<em>${t.yuanjia}</em></span>
             			  </div>
             			  
             			  
             			
             			  
            </div>
           
           
           </li>
      
  			</c:forEach>

 	 <a href="TeaServlet?method=listTeaByPage&page=1&count=20">查看更多>></a>
 	 	<!-- <a href="CarServlet?method=listCarByPage&page=1&count=3" class="see">查看更多</a> -->
  
         
          </ul>
          </div>
         </div>
       </div>
       <!--产品版块-->
        <div class="Area"> 
         <div class="Area_title">
         <div class="name"><em class="icon_title"></em>巴山雀舌系列</div>
         <div class="right">
         <span class="p_link"><a href="#">贡茶</a><a href="#">毛尖茶</a><a href="#">乌龙茶</a><a href="#">贡茶</a></span>
         <span class="more"><a href="#">更多《</a></span>
         </div>
         </div>
         <div class="Area_list clearfix">
          <div class="Area_ad">
            <a href="#"><img src="images/AD-02.jpg" /></a>
            <a href="#"><img src="images/AD-01.jpg" /></a>
          </div>
          
          
          
          <div class="Area_p_list">
	      <ul>
           <li class="s_Products">
            <div class="Area_product_c">
              <div class="img center"><a href="#"><img src="Products/1.jpg" /></a></div>
					   <div class="title_name"><a href="#">52°泸州老窖封藏老酒（窖藏）</a></div>
					   <div class="s_Price clearfix">
                       <span class="Current_price">商城价<em>￥39.00</em></span>
                       <span class="Original_Price">原价&nbsp;<em>76.00</em></span>
               </div>
            </div>
           </li>
           
          </ul>
          </div>
         </div>
       </div>
       
       <c:import url="Down.jsp"></c:import>   <!-- 用JSTL导入 -->
    <%--   <%@include file="Down.jsp"%> --%>
     
</body>
</html>
