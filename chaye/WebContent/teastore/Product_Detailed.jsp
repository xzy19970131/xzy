<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="chaye.Tea"%>
<%@page import="chaye.TeaDaoImp"%>
<%
	//在页面加载前，先把这个页面要显示的数据准备好
	Tea t=(Tea)request.getAttribute("teaInfo2");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" tyle="text/css" />
<link href="css/show.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.min.1.8.2.js" type="text/javascript"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript"></script>
<script src="js/common_js.js" type="text/javascript"></script>
<script src="js/footer.js" type="text/javascript"></script>
<script src="js/jqzoom.js" type="text/javascript"></script>
<!--[if IE 7]>
<link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css">
<![endif]-->
<title>产品名称详细介绍购买</title>
</head>

<body>
<!--顶部样式-->
<%@include file="top.jsp" %>


<!--内页样式-->
<div class="Inside_pages">
<!--面包屑-->
 <div class="Location_link">
     <em></em><a href="#">产品中心</a>  &lt;   <a href="#">巴山雀舌</a>  &lt;   <a href="#">贡茗产品介绍</a>   
     </div>
 <!--产品购买介绍样式-->
 <div class="Detailed">
     <!--产品详细介绍-->
 <div class="Details_style clearfix" id="goodsInfo">
  <div class="mod_picfold clearfix">
    <div class="clearfix" id="detail_main_img">
	 <div class="layout_wrap preview">
     <div id="vertical" class="bigImg">
		<img src="Products/<%=t.getShoutu()%>.jpg"        width="   " height="" alt="" id="midimg" />
		<div style="display:none;" id="winSelector"></div>
	</div>
     <div class="smallImg">
		<div class="scrollbutton smallImgUp disabled">&lt;</div>
		<div id="imageMenu">
			<ul>
				<li><img src="small/01.jpg" width="68" height="68" alt="洋妞"/></li>
				<li><img src="small/02.jpg" width="68" height="68" alt="洋妞"/></li>
				<li><img src="small/03.jpg" width="68" height="68" alt="洋妞"/></li>
				<li><img src="small/04.jpg" width="68" height="68" alt="洋妞"/></li>
				<li><img src="small/05.jpg" width="68" height="68" alt="洋妞"/></li>
				<li><img src="small/06.jpg" width="68" height="68" alt="洋妞"/></li>
                <li><img src="small/07.jpg" width="68" height="68" alt="洋妞"/></li>
			</ul>
		</div>
		<div class="scrollbutton smallImgDown">&gt;</div>
	</div><!--smallImg end-->	
	<div id="bigView" style="display:none;"><div><img width="800" height="800" alt="" src="" /></div></div>
	 </div>
  
	</div>
		 <div class="Sharing">
	 <div class="bdsharebuttonbox bdshare-button-style0-16" data-bd-bind="1441079683326"><a href="#" class="bds_more" data-cmd="more">分享到：</a><a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a></div>
<script>
window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"16"},"share":{"bdSize":16},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];
</script>
  <!--收藏-->
	  <div class="Collect"><a href="javascript:collect(92)"><em class="ico1"></em>收藏商品( 2345 )</a></div>
	 </div>
   </div> 
   <!--信息样式-->
    <div class="textInfo">
    <form action="javascript:addToCart(97)" name="ECS_FORMBUY" id="ECS_FORMBUY">
	  <div class="title"><h1><%=t.getMingzi() %></h1><p>进口饼干糕点 西式糕点 休闲轻松</p></div>
	  <div class="mod_detailInfo_priceSales">
	  <div class="margins">
	  <div class="Price clearfix text_name"><label>价格</label><span class="Prices"><h4>￥<%=t.getXianjia()%></h4> <b><%=t.getYuanjia() %></b></span></div>
	  <div class="Activity clearfix text_name"><label>重量</label><span class="weight">345克</span></div>
      <div class="Size clearfix text_name"><label>规格</label><a href="#">袋装</a><a href="#">礼盒装</a><a href="#">铁盒</a></div>
      <div class="Sales_volume">
       <div class="Sales_info"><h5>销量</h5><b>2345</b></div>
      </div>
	  </div>
	  <div class="s_Review">
	   <a href="#">好评率<b>95%</b>[评论<b>87653</b>条]</a>
	  </div>
	  </div>
	 <div class="buyinfo" id="detail_buyinfo">
		<dl>
        <dt>数量</dt>
        <dd>
		  <div class="choose-amount left">
			<a class="btn-reduce" href="javascript:;" onclick="setAmount.reduce('#buy-num')">-</a>
			<a class="btn-add" href="javascript:;" onclick="setAmount.add('#buy-num')">+</a>
			<input class="text" id="buy-num" value="1" onkeyup="setAmount.modify('#buy-num');">		
		 </div>
		 <div class="P_Quantity">剩余：50000件</div>        
        </dd>
	  <dd>
	    <div class="wrap_btn"> <a href="javascript:addToCart_bak(92)" class="wrap_btn1" title="加入购物车"></a> 
		  <a href="javascript:addToCart(92)" class="wrap_btn2" title="立即购买"></a> </div>
		  </dd>
	  </dl>
	  </div>
	  <div class="Guarantee clearfix">
	   <dl><dt>商城服务</dt><dd><em></em>正品保障</dd><dd><em></em>售后无忧</dd><dd><em></em>原产认证</dd> 
	   <dd class="manner"> <div class="payment " id="payment">
                                    <a href="javascript:void(0);" class="paybtn">支付方式<span class="icon-angle-down"></span></a>
                                <ul><li>货到付款</li><li>礼品卡支付</li><li>网上支付</li><li>银行转账</li></ul></div>
	  </dd></dl></div>	  
	</form>
  </div>
  </div> 
 </div>
 <!---->
  <div class="clearfix">
  <div class="left_style">
   <div class="Records">
     <div class="title_name">用户浏览记录</div>
	 <ul>
	  <li>
	   <a href="#">
	   <p><img src="Products/4.jpg" data-bd-imgshare-binded="1"></p>
	   <p class="p_name">SanmiuSunflower新苗向日葵 乳酪夹心饼干 270g 菲律宾进口</p>
	   </a>
	   <p><span class="p_Price">￥5.30</span><b>10.4</b></p>
	  </li>
	  <li>
	   <a href="#">
	   <p><img src="Products/5.jpg" data-bd-imgshare-binded="1"></p>
	   <p class="p_name">商品名称</p>
	   </a>
	   <p><span class="p_Price">￥5.30</span><b>10.4</b></p>
	  </li>
	  <li>
	   <a href="#">
	   <p><img src="Products/3.jpg" data-bd-imgshare-binded="1"></p>
	   <p class="p_name">商品名称</p>
	   </a>
	   <p><span class="p_Price">￥5.30</span><b>10.4</b></p>
	  </li>
	 </ul>
   </div>
   </div>
   <div class="right_style">
    <div class="inDetail_boxOut ">
	 <div class="inDetail_box">
	  <div class="fixed_out ">
	   <ul class="inLeft_btn fixed_bar">
                  <li><a id="property-id" href="#shangpsx" class="current">商品属性</a></li>
                  <li><a id="detail-id" href="#shangpjs">规格与包装</a></li>
                  <li><a id="shot-id" href="#miqsp">售后服务</a></li>
                  <li><a id="coms1-id" href="#coms1">买家评论</a></li>
                </ul>
	  </div>
      <!---->
      <div class="product_details">
      <div id="shangpsx">
       <div class="title"><img src="images/title_name_03.png" /></div>
       <ul class="shangpsx_info">
        <li><label>生产许可证编号</label><span>QS3301 1401 0973</span></li>
        <li><label>产品标准号</label><span>GB/T 18650</span></li>
        <li><label>生产日期</label><span>2015年4月</span></li>
        <li><label>有效期</label><span>三年</span></li>
        <li><label>产品名称</label><span>艺福堂茶叶 绿茶 龙井茶 西湖龙井 雨前靠谱茶</span></li>
        <li><label>净含量</label><span>250g</span></li>
        <li><label>包装</label><span>罐装</span></li>
        <li><label>品牌</label><span>艺福堂</span></li>
        <li><label>食品工艺</label><span>炒青绿茶</span></li>
        <li><label>级别</label><span>三级</span></li>
        <li><label>产地</label><span>中国大陆杭州</span></li>
        <li><label>价格</label><span>100-199元</span></li>
       </ul>
      </div>
      <div id="shangpjs">
       <img src="images/pro_img.png" />
      </div>
      <div id="coms1">
        <div class="productContent" id="status2">
	 <div class=""></div>
      <div class="iComment clearfix">
        <div class="rate"><strong id="goodRate">100<span>%</span></strong><br>
          <span>好评度</span></div>
        <div class="percent" id="percentRate">
          <dl>
            <dt>好评<span>(100%)</span></dt>
            <dd>
              <div style="width:100px;"></div>
            </dd>
          </dl>
          <dl>
            <dt>中评<span>(0%)</span></dt>
            <dd class="d1">
              <div style="width:0;"> </div>
            </dd>
          </dl>
          <dl>
            <dt>差评<span>(0%)</span></dt>
            <dd class="d1">
              <div style="width:0;"> </div>
            </dd>
          </dl>
        </div>
        <div class="actor">
          <dl>
            <dt>发表评价即可获得10积分，精华评论更有 <font color="red">额外奖励</font> 积分；<br>
              还有7个多倍积分名额哦，赶紧抢占吧！<br>
              只有购买过该商品的用户才能进行评价。</dt>           
          </dl>
        </div>
      </div>
	  <div class="commentBox" style="display: block;">
		<form action="javascript:;" onsubmit="submitComment(this)" method="post" name="commentForm" id="commentForm">
		  <h3>商品评分</h3>
		  <p class="tip">请直接点击相应的星级进行评分</p>
		  <div id="star">
			<ul>
			  <li class=""><span onclick="dorank(1)"></span>
				<p>1分</p>
				<p>非常不满意</p>
			  </li>
			  <li class=""><span onclick="dorank(2)"></span>
				<p>2分</p>
				<p>不满意</p>
			  </li>
			  <li class=""><span onclick="dorank(3)"></span>
				<p>3分</p>
				<p>一般</p>
			  </li>
			  <li class=""><span onclick="dorank(4)"></span>
				<p>4分</p>
				<p>满意</p>
			  </li>
			  <li class=""><span onclick="dorank(5)"></span>
				<p>5分</p>
				<p>非常满意</p>
			  </li>
			</ul>
			<input type="hidden" name="rank" id="rank" value="1">
			<input type="hidden" name="cmt_type" value="">
			<input type="hidden" name="id" value="78">
			<input type="hidden" name="email" id="email" value="null@mial.com">
		  </div>
		  <h4>评论内容</h4>
		  <div class="bd">
			<textarea name="content" id="content" class="textarea_long" onkeyup="checkLength(this);"></textarea>
			<p class="g">
			  <label>&nbsp; </label>
			  <input type="submit" value="发表" class="btn_common">
			  <span t="word_calc" class="word"><b id="sy">0</b>/1000</span> </p>
		  </div>
		</form>
		</div>
		<div id="ECS_COMMENT"> <div class="Comment">
<div class="CommentTab">
  <ul>
	<li class="active" onclick="javascript:gotoPage(1,78,0,0);">全部评论(0)</li>
	<li onclick="javascript:gotoPage(1,78,0,3);">好评(0)</li>
	<li onclick="javascript:gotoPage(1,78,0,2);">中评(0)</li>
	<li onclick="javascript:gotoPage(1,78,0,1);">差评(0)</li>
  </ul>
</div>
<div class="CommentText" id="goodsdetail_comments_list" style="display:block">
  <ul class="clearfix">
	  </ul>
  <div class="discuss_Paging">
	<div class="discuss"> 
	  <span class="f_l f6" style="margin-right:10px;">共 <b>0</b> 条评论</span>
	  <p id="commentPager_4"> 
	  <a href="javascript:gotoPage(1,78,0,0)">首页</a>          
	  <a class="prev" href="javascript:;">上一页</a>                    
	  <a class="next" href="javascript:;">下一页</a>          
	  <a class="last" href="javascript:;">尾页</a>	  
	   </p>
	</div>
  </div>
</div>
</div>

<script type="text/javascript">
//<![CDATA[
var cmt_empty_username = "请输入您的用户名称";
var cmt_empty_email = "请输入您的电子邮件地址";
var cmt_error_email = "电子邮件地址格式不正确";
var cmt_empty_content = "您没有输入评论的内容";
var captcha_not_null = "验证码不能为空!";
var cmt_invalid_comments = "无效的评论内容!";

/**
 * 提交评论信息
*/
function submitComment(frm)
{
  var cmt = new Object;

  //cmt.username        = frm.elements['username'].value;
  cmt.email           = frm.elements['email'].value;
  cmt.content         = frm.elements['content'].value;
  cmt.type            = frm.elements['cmt_type'].value;
  cmt.id              = frm.elements['id'].value;
  cmt.enabled_captcha = frm.elements['enabled_captcha'] ? frm.elements['enabled_captcha'].value : '0';
  cmt.captcha         = frm.elements['captcha'] ? frm.elements['captcha'].value : '';
  cmt.rank            = frm.elements['rank'].value;

/*  for (i = 0; i < frm.elements['comment_rank'].length; i++)
  {
    if (frm.elements['comment_rank'][i].checked)
    {
       cmt.rank = frm.elements['comment_rank'][i].value;
     }
  }*/

//  if (cmt.username.length == 0)
//  {
//     alert(cmt_empty_username);
//     return false;
//  }

  if (cmt.email.length > 0)
  {
     if (!(Utils.isEmail(cmt.email)))
     {
        alert(cmt_error_email);
        return false;
      }
   }
   else
   {
        alert(cmt_empty_email);
        return false;
   }

   if (cmt.content.length == 0)
   {
      alert(cmt_empty_content);
      return false;
   }

   if (cmt.enabled_captcha > 0 && cmt.captcha.length == 0 )
   {
      alert(captcha_not_null);
      return false;
   }

   Ajax.call('comment.php', 'cmt=' + cmt.toJSONString(), commentResponse, 'POST', 'JSON');
   frm.elements['content'].value = '';
   return false;
}

/**
 * 处理提交评论的反馈信息
*/
  function commentResponse(result)
  {
    if (result.message)
    {
      alert(result.message);
    }

    if (result.error == 0)
    {
      var layer = document.getElementById('ECS_COMMENT');

      if (layer)
      {
        layer.innerHTML = result.content;
      }
    }
  }

//]]>
</script></div>
      	<script type="text/javascript">
		$('.CommentTab ul').find('li').click(function(){
		  $('.CommentTab ul').find('li').removeClass('active');
		  $('.CommentText').css({display:'none'});
		  $(this).addClass('active');
		  $('.CommentText').eq($(this).index()).css({display:'block'});
		});
		</script>
    </div>
      </div>
      </div>
	 </div>	  
	</div>
   </div>
  </div>
 <!--友情链接-->
       <div class="Links">
        <div class="link_title">友情链接</div>
        <div class="link_address"><a href="#">四川茶叶协会</a>  <a href="#">链接地址</a>  <a href="#">链接地址</a>  <a href="#">链接地址 </a>   <a href="#">链接地址</a> <a href="#">链接地址</a> <a href="#">链接地址</a></div>
       </div>
</div>



  <%@include file="Down.jsp" %>
</body>
</html>
