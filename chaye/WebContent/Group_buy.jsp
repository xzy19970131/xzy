<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><base href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/chaye/"><meta charset="utf-8" />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/slide.js"></script>
<script src="js/common_js.js" type="text/javascript"></script>
<script src="js/jquery.foucs.js" type="text/javascript"></script>
<!--[if IE 7]>
<link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css">
<![endif]-->
<title>商品团购</title>
</head>

<body>
<!--顶部样式-->
<div id="top">
  <div class="top">
    <div class="Collection"><em></em><a href="#">收藏我们</a></div>
	<div class="hd_top_manu clearfix">
	  <ul class="clearfix">
	   <li class="hd_menu_tit zhuce" data-addclass="hd_menu_hover">欢迎光临本店！<a href="#" class="red">[请登录]</a> 新用户<a href="#" class="red">[免费注册]</a></li>
	   <li class="hd_menu_tit" data-addclass="hd_menu_hover"><a href="#">我的订单</a></li> 
	   <li class="hd_menu_tit" data-addclass="hd_menu_hover"> <a href="#">购物车(<b>0</b>)</a> </li>
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
<!--logo和搜索样式-->
<div id="header"  class="header">
  <div class="logo">
  <a href="#"><img src="images/logo.png" /></a>
  <div class="phone">
   免费咨询热线:<span class="telephone">400-3454-343</span>
  </div>
  </div>
  <div class="Search">
    <p><input name="" type="text"  class="text"/><input name="" type="submit" value=""  class="Search_btn"/></p>
	<p class="Words"><a href="#">苹果</a><a href="#">香蕉</a><a href="#">菠萝</a><a href="#">西红柿</a><a href="#">橙子</a><a href="#">苹果</a></p>
</div>
</div>
<!--导航栏样式-->
<div id="Menu" class="clearfix">
<div class="Menu_style">
  <div id="allSortOuterbox" class="display">
    <div class="Category"><a href="#" class="Menu_img"><em></em></a></div>
    <div class="hd_allsort_out_box_new">
	 <!--左侧栏目开始-->
	 <div class="Menu_list">	
	    <div class="menu_title">茶叶品种</div>
        <a href="#">贡茗茶</a><a href="#">冠茗茶</a><a href="#">佳茗茶</a><a href="#">珍茗茶</a><a href="#">绿茶</a><a href="#">毛尖茶</a>
	</div>	
    <div class="Menu_list">	
	    <div class="menu_title">茶叶价格</div>
        <a href="#">100以下</a><a href="#">100-200</a><a href="#">200-400</a><a href="#">400-600</a><a href="#">600-900</a><a href="#">1000以上</a>
	</div>	
     <div class="Menu_list">	
	    <div class="menu_title">推荐茶叶</div>
        <ul class="recommend">
         <li><a href="#" title="[2015年新茶]巴山雀舌毛尖茶新茶，含硒">[2015年新茶]巴山雀舌...</a></li>
         <li><a href="#" title="[2015年新茶]巴山雀舌毛尖茶新茶，含硒">[2015年新茶]巴山雀舌...</a></li>
         <li><a href="#" title="[2015年新茶]巴山雀舌毛尖茶新茶，含硒">[2015年新茶]巴山雀舌...</a></li>
         <li><a href="#" title="[2015年新茶]巴山雀舌毛尖茶新茶，含硒">[2015年新茶]巴山雀舌...</a></li>
         <li><a href="#" title="[2015年新茶]巴山雀舌毛尖茶新茶，含硒">[2015年新茶]巴山雀舌...</a></li>
        </ul>
	</div>	
	</div>		
	</div>
    <div class="Navigation" id="Navigation">
		 <ul class="Navigation_name">
			<li><a class="nav_on" id="mynav1"  href="index.html"><span>首页</span></a></li>
			<li><a class="nav_on" id="mynav2"  href="#"><span>巴山雀舌</span></a></li>
			<li><a class="nav_on" id="mynav3"  href="#"><span>贡茗</span></a></li>
			<li><a class="nav_on" id="mynav4"  href="#"><span>冠茗</span></a></li>
			<li><a class="nav_on" id="mynav5"  href="#"><span>臧芝堂（藏茶）</span></a></li>
			<li><a class="nav_on" id="mynav6"  href="#"><span>大巴山（茗茶）</span></a></li>
			<li><a class="nav_on" id="mynav7"  href="#"><span>达州（茶）</span></a></li>
			<li><a class="nav_on" id="mynav8"  href="#"><span>活动</span></a></li>
			<li><a class="nav_on" id="mynav8"  href="#"><span>联系我们</span></a></li>
		 </ul>			 
		</div>
	<script>$("#Navigation").slide({titCell:".Navigation_name li"});</script>
    <!--购物车-->	
    
     <div class="hd_Shopping_list" id="Shopping_list">
   <div class="s_cart"><em></em><a href="#">我的购物车</a> <i class="ci-right">&gt;</i><i class="ci-count" id="shopping-amount">0</i></div>
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
	  <a href="#" title="去购物车结算" id="btn-payforgoods" class="Shopping">去购物车结算</a>
	 </div>	 
   </div>	
  </div>
</div>
</div>
<!---->
<div style="background:url(images/group_img.jpg) no-repeat; height:472px; width:100%; background-position:center"></div>
<!--位置-->
<div class="Bread_crumbs">
 <div class="Inside_pages clearfix">
   <div class="left">当前位置：<a href="#">首页</a>&gt;<a href="#">素菜馆</a></div>
 </div>
</div>

<!--团购样式-->
<div class="Inside_pages clearfix">
 <div class="Group_buy">
    <div class="Group_title"><em></em>今日团购<span>GROUP-BUYING</span></div>
    <div class="Group_list clearfix">
     <div class="left_Group">
      <div class="Group_prodcut">
      <div class="clearfix">
       <div class="Group_info">
         <a href="#" class="Collect"></a>
         <ul>
          <li class="Group_p_name"><a href="#">浦江斗志红提</a></li>
          <li class="Group_p_about">绿色有机无污染水果</li>
          <Li>礼盒装 500g</Li>
          <li class="Group_price"><span class="Current_price"><i>￥</i>15.00</span> <span class="Group_List">原价：18.00</span></li>
          <li class="Group_p_buy">
           <span class="Group_Number"><em></em>234人购买</span>
           <span class="Group_button right"><a href="#" class="buy_button"></a></span>
          </li>
         </ul>
       </div>
       <div class="Group_img"><a href=""><img src="Products/26.jpg"  height="195" width="326"/></a></div>
       </div>
       <div class="Group_time">
         <em></em>距离结束还有2天4小时32分23秒
       </div>
      </div>
           <div class="Group_prodcut">
      <div class="clearfix">
       <div class="Group_info">
         <ul>
          <li class="Group_p_name"><a href="#">浦江斗志红提</a></li>
          <li class="Group_p_about">绿色有机无污染水果</li>
          <Li>礼盒装 500g</Li>
          <li class="Group_price"><span class="Current_price"><i>￥</i>15.00</span> <span class="Group_List">原价：18.00</span></li>
          <li class="Group_p_buy">
           <span class="Group_Number"><em></em>234人购买</span>
           <span class="Group_button right"><a href="#" class="buy_button"></a></span>
          </li>
         </ul>
       </div>
       <div class="Group_img"><a href=""><img src="Products/25.jpg"  height="195" width="326"/></a></div>
       </div>
       <div class="Group_time">
         <em></em>距离结束还有2天4小时32分23秒
       </div>
      </div>     <div class="Group_prodcut">
      <div class="clearfix">
       <div class="Group_info">
         <ul>
          <li class="Group_p_name"><a href="#">浦江斗志红提</a></li>
          <li class="Group_p_about">绿色有机无污染水果</li>
          <Li>礼盒装 500g</Li>
          <li class="Group_price"><span class="Current_price"><i>￥</i>15.00</span> <span class="Group_List">原价：18.00</span></li>
          <li class="Group_p_buy">
           <span class="Group_Number"><em></em>234人购买</span>
           <span class="Group_button right"><a href="#" class="buy_button"></a></span>
          </li>
         </ul>
       </div>
       <div class="Group_img"><a href=""><img src="Products/24.jpg"  height="195" width="326"/></a></div>
       </div>
       <div class="Group_time">
         <em></em>距离结束还有2天4小时32分23秒
       </div>
      </div>     <div class="Group_prodcut">
      <div class="clearfix">
       <div class="Group_info">
         <ul>
          <li class="Group_p_name"><a href="#">浦江斗志红提</a></li>
          <li class="Group_p_about">绿色有机无污染水果</li>
          <Li>礼盒装 500g</Li>
          <li class="Group_price"><span class="Current_price"><i>￥</i>15.00</span> <span class="Group_List">原价：18.00</span></li>
          <li class="Group_p_buy">
           <span class="Group_Number"><em></em>234人购买</span>
           <span class="Group_button right"><a href="#" class="buy_button"></a></span>
          </li>
         </ul>
       </div>
       <div class="Group_img"><a href=""><img src="Products/23.jpg"  height="195" width="326"/></a></div>
       </div>
       <div class="Group_time">
         <em></em>距离结束还有2天4小时32分23秒
       </div>
      </div>     <div class="Group_prodcut">
      <div class="clearfix">
       <div class="Group_info">
         <ul>
          <li class="Group_p_name"><a href="#">浦江斗志红提</a></li>
          <li class="Group_p_about">绿色有机无污染水果</li>
          <Li>礼盒装 500g</Li>
          <li class="Group_price"><span class="Current_price"><i>￥</i>15.00</span> <span class="Group_List">原价：18.00</span></li>
          <li class="Group_p_buy">
           <span class="Group_Number"><em></em>234人购买</span>
           <span class="Group_button right"><a href="#" class="buy_button"></a></span>
          </li>
         </ul>
       </div>
       <div class="Group_img"><a href=""><img src="Products/22.jpg"  height="195" width="326"/></a></div>
       </div>
       <div class="Group_time">
         <em></em>距离结束还有2天4小时32分23秒
       </div>
      </div>
     </div>
     <!--右侧团购样式-->
     <div class="right_Group">
     <div class="right_Group_p_style">
       <div class="clearfix">
        <div class="left_Group_name">
        <a href="#" class="Collect"></a>
         <ul>
          <li class="Group_p_name"><a href="#">浦江斗志红提</a></li>
          <li class="Group_p_about">绿色有机无污染水果,孝敬爸妈的理想选择</li>
          <Li class="spacing">礼盒装 500g</Li>
          <li class="Group_price"><span class="Current_price"><i>￥</i>15.00</span> <span class="Group_List">原价：18.00</span></li>
          <li class="Group_p_buy">
           <span class="Group_Number"><em></em>234人购买</span>
           <span class="Group_button right"><a href="#" class="buy_button"></a></span>
          </li>
         </ul>
        </div>
        <div class="right_Group_img"><a href=""><img src="Products/1-11.jpg"  height="370" width="326"/></a></div>
       </div>
        <div class="Group_time">
         <em></em>距离结束还有2天4小时32分23秒
       </div>
     </div>
     <!--团购列表-->
     <div class="other_Group clearfix">
       <div class="g_p_list">
        <div class="g_p_style"> 
         <div class="g_p_img"><a href="#"><img src="Products/16.jpg"  height="220" width="254"/></a></div>
        <ul>
         <a href="#" class="Collect"></a>     
        <li><a href="" class="name">浦江斗志红提</a></li>
        <li>绿色有机无污染水果</li>
        <li class="Group_price"><span class="Current_price"><i>￥</i>15.00</span> <span class="Group_List">原价：18.00</span></li>
        <li class="Group_p_buy">
           <span class="Group_Number">234人购买</span>
           <span class="Group_button right"><a href="#" class="buy_button"></a></span>
          </li>
        </ul>
        </div>
       </div>
         <div class="g_p_list">
        <div class="g_p_style"> 
         <div class="g_p_img"><a href="#"><img src="Products/18.jpg"  height="220" width="254"/></a></div>
        <ul>
         <a href="#" class="Collect"></a>     
        <li><a href="" class="name">浦江斗志红提</a></li>
        <li>绿色有机无污染水果</li>
        <li class="Group_price"><span class="Current_price"><i>￥</i>15.00</span> <span class="Group_List">原价：18.00</span></li>
        <li class="Group_p_buy">
           <span class="Group_Number">234人购买</span>
           <span class="Group_button right"><a href="#" class="buy_button"></a></span>
          </li>
        </ul>
        </div>
       </div>
         <div class="g_p_list">
        <div class="g_p_style"> 
         <div class="g_p_img"><a href="#"><img src="Products/17.jpg"  height="220" width="254"/></a></div>
        <ul>
         <a href="#" class="Collect"></a>     
        <li><a href="" class="name">浦江斗志红提</a></li>
        <li>绿色有机无污染水果</li>
        <li class="Group_price"><span class="Current_price"><i>￥</i>15.00</span> <span class="Group_List">原价：18.00</span></li>
        <li class="Group_p_buy">
           <span class="Group_Number">234人购买</span>
           <span class="Group_button right"><a href="#" class="buy_button"></a></span>
          </li>
        </ul>
        </div>
       </div>
         <div class="g_p_list">
        <div class="g_p_style"> 
         <div class="g_p_img"><a href="#"><img src="Products/19.jpg"  height="220" width="254"/></a></div>
        <ul>
         <a href="#" class="Collect"></a>     
        <li><a href="" class="name">浦江斗志红提</a></li>
        <li>绿色有机无污染水果</li>
        <li class="Group_price"><span class="Current_price"><i>￥</i>15.00</span> <span class="Group_List">原价：18.00</span></li>
        <li class="Group_p_buy">
           <span class="Group_Number">234人购买</span>
           <span class="Group_button right"><a href="#" class="buy_button"></a></span>
          </li>
        </ul>
        </div>
       </div>
       <!---->
     </div>
     </div>
    </div>
 
</div>
    <!--友情链接-->
       <div class="Links">
        <div class="link_title">友情链接</div>
        <div class="link_address"><a href="#">四川茶叶协会</a>  <a href="#">链接地址</a>  <a href="#">链接地址</a>  <a href="#">链接地址 </a>   <a href="#">链接地址</a> <a href="#">链接地址</a> <a href="#">链接地址</a></div>
       </div>
</div></div>
<!--底部样式-->
<div class="footer">
 <div class="streak"></div>
 <div class="footerbox clearfix">
  <div class="left_footer">
   <div class="img"><img src="images/img_33.png" /></div>
   <div class="phone">
    <h2>服务咨询电话</h2>
    <p class="Numbers">400-0000-000</p>
   </div>
  </div>
  <div class="right_footer">
   <dl>
    <dt><em class="icon_img"></em>购物指南</dt>
    <dd><a href="#">怎样购物</a></dd>
    <dd><a href="#">积分政策</a></dd>
    <dd><a href="#">会员优惠</a></dd>
    <dd><a href="#">订单状态</a></dd>
    <dd><a href="#">产品信息</a></dd>
    <dd><a href="#">怎样购物</a></dd>
   </dl>
   <dl>
    <dt><em class="icon_img"></em>配送方式</dt>
    <dd><a href="#">快递资费及送达时间</a></dd>
    <dd><a href="#">快递覆盖地区查询</a></dd>
    <dd><a href="#">验货与签收</a></dd>
    <dd><a href="#">订单状态</a></dd>
    <dd><a href="#">产品信息</a></dd>
    <dd><a href="#">怎样购物</a></dd>
   </dl>
   <dl>
    <dt><em class="icon_img"></em>配送方式</dt>
    <dd><a href="#">货到付款</a></dd>
    <dd><a href="#">支付宝</a></dd>
    <dd><a href="#">财付通</a></dd>
    <dd><a href="#">网银支付</a></dd>
    <dd><a href="#">银联支付</a></dd>
   </dl>
   <dl>
    <dt><em class="icon_img"></em>售后服务</dt>
    <dd><a href="#">退换货原则</a></dd>
    <dd><a href="#">退换货要求与运费规则</a></dd>
    <dd><a href="#">退换货流程</a></dd>
   </dl>
   <dl>
    <dt><em class="icon_img"></em>关于我们</dt>
    <dd><a href="#">关于我们</a></dd>
    <dd><a href="#">友情链接</a></dd>
    <dd><a href="#">媒体报道</a></dd>
    <dd><a href="#">新闻动态</a></dd>
    <dd><a href="#">企业文化</a></dd>
 
   </dl>
  </div>
 </div>
 <div class="slogen">
  <div class="footerbox clearfix ">
  <ul class="wrap">
	 <li>
	  <a href="#"><img src="images/icon_img_02.png" data-bd-imgshare-binded="1"></a>
	  <b>正品保证</b>
	  <span>正品行货 放心选购</span>
	 </li>
	 <li><a href="#"><img src="images/icon_img_03.png" data-bd-imgshare-binded="2"></a>
	  <b>满68元包邮</b>
	  <span>购物满68元，免费快递</span>
	 </li>
	 <li>
	  <a href="#"><img src="images/icon_img_04.png" data-bd-imgshare-binded="3"></a>
	  <b>厂家直供</b>
	  <span>价格更低，质量更可靠</span>
	 </li>
      <li>
	  <a href="#"><img src="images/icon_img_05.png" data-bd-imgshare-binded="4"></a>
	  <b>权威认证</b>
	  <span>政府扶持单位，安全保证</span>
	 </li>
	</ul>
  </div>
 </div>
 <div class="footerbox Copyright">
  <p><a href="#">关于我们</a> | <a href="#">隐私申明</a> | <a href="#">成为供应商</a> | <a href="#">茶叶</a> | <a href="#">博客</a> |<a href="#">友情链接</a> | <a href="#">网站地图</a></p>
  <p>Copyright 2010 - 2015 巴山雀舌 四川巴山雀舌茗茶实业有限公司 zuipin.cn All Rights Reserved </p>
  <p>川ICP备10200063号-1</p>
   <a href="#" class="return_img"></a>
 </div>
</div>

</body>
</html>
