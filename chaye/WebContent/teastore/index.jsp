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


<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="chaye.TeaDaoImp"%>
<%@page import="chaye.Tea"%>
<%
TeaDaoImp  dao=new TeaDaoImp();
ArrayList<Tea> TeaDaoImpallTeas=dao.listRecentTeasByCount(24);//这里应该调用查询N个车辆信息的方法，把需要显示在首页的车辆信息查询出来
ArrayList<Tea> allTeasOfTuiguang=dao.getAllTeaByTuiguang();//这里应该调用的是查询那些推广的车辆信息的方法
%>

<title>茶叶商城首页</title>
</head>

<body>
<%@include file="top.jsp" %>

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
        <%

//***********************************************
//***********************************************
//***********************************************
//***********************************************
         	for(Tea t:TeaDaoImpallTeas)
        {		
			%>
        	<li class="s_Products">
            <div class="Area_product_c">
                     <div class="img center"><a href="Product_Detailed.jsp?chayeid=<%=t.getChayeid()%>"><img src="Products/<%=t.getShoutu()%>.jpg" /></a></div>
					
		
					   <div class="title_name"><a href="#"><%=t.getMingzi()%></a></div>
					   <div class="s_Price clearfix">
                       <span class="Current_price">商城价<em>￥<%=t.getXianjia()%></em></span>
                       <span class="Original_Price">原价&nbsp;<em><%=t.getYuanjia()%></em></span>
             			  </div>
            </div>
           
           </li>
      
        <% }%>
        
        
  
         
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
       
       
      <%@include file="Down.jsp"%>
     
</body>
</html>
