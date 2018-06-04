<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %><!-- EL的函数库=jstl的函数 -->

<%@page import="chaye.UserDao"%>
<%@page import="chaye.User" %>
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
<link rel="stylesheet" href="css/font-awesome-ie7.min.css">
<![endif]-->
<title>购物车</title>
<script type="text/javascript">
$(document).ready(function () {
   //全选
   $("#CheckedAll").click(function () {
	   if (this.checked) {                 //如果当前点击的多选框被选中
		   $('input[type=checkbox][name=checkitems]').attr("checked", true);
	   } else {
		   $('input[type=checkbox][name=checkitems]').attr("checked", false);
	   }
   });
   $('input[type=checkbox][name=checkitems]').click(function () {
	   var flag = true;
	   $('input[type=checkbox][name=checkitems]').each(function () {
		   if (!this.checked) {
			   flag = false;
		   }
	   });

	   if (flag) {
		   $('#CheckedAll').attr('checked', true);
	   } else {
		   $('#CheckedAll').attr('checked', false);
	   }
   });
   //输出值
   $("#send").click(function () {
	      if($("input[type='checkbox'][name='checkitems']:checked").attr("checked")){
	   var str = "你是否要删除选中的商品：\r\n";
	   $('input[type=checkbox][name=checkitems]:checked').each(function () {
		   str += $(this).val() + "\r\n";
	   })
	   alert(str);
		  }
		  else{
			   var str = "你为选中任何商品，请选择后在操作！"; 
			   alert(str);
       }
	   	    
   });
/*    $("#deleteall").click(function () {
	      if($("input[type='checkbox'][name='checkitems']:checked").attr("checked")){
	   var str = "你是否要删除所有的商品：\r\n";
	   $('input[type=checkbox][name=checkitems]:checked').each(function () {
		   str += $(this).val() + "\r\n";
	   })
	   alert(str);
		  }
		  else{
			   var str = "你将删除所有商品！"; 
			   alert(str);
    }
	   	    
}); */
})
</script>
</head>
<!--宽度1000的购物车样式-->
<body>
<c:import url="top3.jsp"></c:import>
<div id="shop_cart">
 <div id="header">
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
<!--提示购物步骤-->

 <div class="prompt_step">
  <img src="images/cart_step_01.png" />
 </div>
 <!--购物车商品-->
 <div class="Shopping_list">
  <div class="title_name">
    <ul>
	<li class="checkbox">&nbsp;</li>
	<li class="name">商品名称</li>
	<li class="scj">市场价</li>
	<li class="bdj">本店价</li>
	<li class="sl">购买数量</li>
	<li class="xj">小计</li>
	<LI class="cz">操作</LI>
  </ul>
 </div>
  <div class="shopping">
  <form  method="post" action="">
 <table class="table_list">
 <c:if test="${empty sessionScope.Teas }">
 	仓库里的老鼠快饿死了，<a href="index.jsp">去商城</a>逛逛吧~
 </c:if>
 <c:forEach var="t" items="${sessionScope.Teas }"> 
   <tr class="tr">
   <td class="checkbox"><input name="checkitems" type="checkbox" value="金龙鱼 东北大米 蟹稻共生 盘锦大米5KG" /></td>
    <td class="name">
	  <div class="img"><a href="#"><img src="Products/${t.key.shoutu}.jpg" /></a></div>
	  <div class="p_name"><a href="#">${t.key.mingzi}</a></div>
	</td>
	<td class="scj sp">${t.key.yuanjia }</td>
	<td class="bgj sp">${t.key.xianjia }</td>
	<td class="sl">
	    <div class="Numbers">
		  <a href="ShoppingTeaServlet?method=jian&chayeid=${t.key.chayeid }" onclick="updatenum('del');" class="jian">-</a>
		  <input id="number" name="number" type="text" value="${t.value}" class="number_text">
		  <a href="ShoppingTeaServlet?method=jia&chayeid=${t.key.chayeid }" onclick="updatenum('del');" class="jia">+</a>
		 </div>
	</td>
	<td class="xj">￥32.40</td>
	<td class="cz">
	 <p><a href="javascript:shanchu('ShoppingTeaServlet?method=deleteTea&chayeid=${t.key.chayeid}')">删除</a><P>
	 
	 <p><a href="#">收藏该商品</a></p>
	</td>
   </tr>
   </c:forEach> 
 </table>
 <div class="sp_Operation">
  <div class="select-all">
  <div class="cart-checkbox"><input type="checkbox"   id="CheckedAll" name="toggle-checkboxes" class="jdcheckbox" clstag="clickcart">全选</div>
  <div class="operation"><a href="#" id="send">删除选中商品</a></div> 
 <div class="operation"><a href="javascript:deleteAll()" id="deleteall">删除所有商品</a></div> 
    </div> 

	 <!--结算-->
	<div class="toolbar_right">
    <div class="p_Total">
	  <span class="text">商品总价：</span><span class="price sumPrice">32.40元</span>
	</div>
	<div class="Discount"><span class="text">以节省：</span><span class="price">5.1</span></div>
	<div class="btn">
	 <a class="cartsubmit" href="flow.php?step=checkout"></a>
	 <a class="continueFind" href="index.jsp"></a>
	</div>
  </div>
  </div>
   </form>
 </div>

</div>

<c:import url="Down.jsp"></c:import>

<!--结束-->
</div>
</body>
</html>


<script type="text/javascript">
	function deleteAll() {
		var choice=confirm("确认删除全部商品？");
		if(choice){
			location.href="ShoppingTeaServlet?method=deleteAll";
		}
	}
	function shanchu(url) {
		var choice=confirm("确认删除该商品？");
		if(choice){
			location.href=url;
		}
	}
	
</script>
