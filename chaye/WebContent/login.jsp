<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><base href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/chaye/"><meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" tyle="text/css" />
<script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript"></script>
<script src="js/common_js.js" type="text/javascript"></script>
<title>用户登录</title>
</head>

<body>
<!--顶部样式-->
<div class="common_top">
 <div class="Narrow">
  <div class=" left logo"><a href="#"><img src="images/logo.png" /></a></div>
  <!--电话图层-->
  <div class="phone"><label>全国服务热线：</label><em>400-345-5633</em></div>
 </div>
</div>




<div class="login_bg" >
<div class="login Narrow">
   <div class="login_advertising"><img src="images/bg_03.png" /></div>
   
   <form action="UserServlet"  method="post" id="loginForm">
   <input type="hidden" name="method"  value="denglu" />
  
  <div class="login_frame">
   <div class="login-form">
     <div class="login-name"><h1 class="name">用户登录</h1><span class="login_link"><a href="registered.html"><b></b>用户注册</a></span></div>
	  <!--提示信息-->
	    <div class="Prompt">账号密码不能为空！ </div>
	    <div class="form clearfix">
	     <div class="item item-fore1"><label for="loginname" class="login-label name-label"></label><input name="userid" type="text"  class="text" placeholder="请输入用户" value="${cookie.userid.value}" style="width:120px;"/>
		 <span id="userExist"></span>
		 </div>
		 <div class="item item-fore2"><label for="nloginpwd" class="login-label pwd-label" ></label><input name="mima" type="password"  class="text" placeholder="用户密码" value="${cookie.mima.value}"/>
	     </div> 
	     <input type="checkbox" name="rememberme"/>记住密码
	     
	      <p>
				<label>验证码</label>
				<img id="code" src="CodeServlet"  style="position: relative;top: 11px;" />
				<input class="input-medium" type="text"  name="code" style="width: 50px;"/>
			</p>

	<!--      <input name="yzm" type="yzm"  placeholder="验证码"/>
	  -->
	 
			<!-- 	<label>验证码</label>
			<img id="code" src="CodeServlet"  style="position: relative;top: 11px;" />
			<input  type="text"  name="code" style="width: 60px;"/>
		   -->
	     
	     <div class="Forgetpass"><a href="#">忘记密码？</a></div>
	    </div>	
	    <div class="login-btn">
	
	         <a href="javascript:void()" class="btn_login" id="submitButton">登&nbsp;&nbsp;&nbsp;&nbsp;录</a>
	<!--  <button type="submit">登&nbsp;录</button>  -->
	 

<!-- $(".btn_login").click(function    //Tensir老师说事件注入


location.href='Usersxxx';) -->
	
	  </div>
    </div>
    <script type="text/javascript">
	$(document).ready(function(){
/* 		$("#registerButton").click(function(){
			$("#method").val("register");
			$("#loginForm").submit();//用jquery提交表单的代码
		}) */

/* 		$("#closeLogin").click(function(){
			$("#loginDiv").css("right",-220);
			$("#login").show();
		}) */
			
		$("#submitButton").click(function(){      //登陆用<a>超链接时候，添加事件注入，起到跟submit一样的作用
			$("#loginForm").submit();
		})
		
		/* $("[name='sellCar']").mouseover(function(){
			$(this).css("boxShadow","-1px -1px  12px  red");
		}) */
	/* 	$("[name='sellCar']").mouseout(function(){
			$(this).css("boxShadow","");
		}) */
		$("#code").click(function(){    	//事件注入，点击生成新的验证码
			$("#code").attr("src",'CodeServlet?time='+new Date());
		})
		
		
/* 		var xhr;      //定义一个全局对象，存Ajax对象
			
		//定义一个处理ajax返回结果的函数，这里面写处理结果的代码
		function processResult(){
			if(xhr.readyState==4){
				if(xhr.status==200)
				{
					var result=xhr.responseText;
					//所有的http流传过来的数据，看似是true和false，实际是string内型
					if(result=='true')
					{
						$("#userExist").html("<b style='color:green'>√</b>");    //htnl里面写html代码
						
					}else{
						$("#userExist").html("<b style='color:red'>X</b>");
					}
				}
			}
		}	 */
		
		//$(document).ready(function(){    //当界面加载完成注入事件。因为现在就在ready中，所以不需要这句
			$("[name='userid']").blur(function(){  //焦点失去事件           
				//$.get(URL,callback);    这是语法，在W3c上有
				//$.post(URL,data,callback);
				$.get("UserServlet?method=checkExists&userid="+$(this).val(),function(data,status){     //结果直接映射在data和status里面
				//	var result=xhr.responseText;
					//所有的http流传过来的数据，看似是true和false，实际是string内型
					if(data=='true')
					{
						$("#userExist").html("<b style='color:green'>√</b>");    //htnl里面写html代码
					}else{
						$("#userExist").html("<b style='color:red'>X</b>");
					}
					
				});
				
				
			})
	//	})
		
		
		/* $("[name='userid']").blur(function () {
			var yourInputuserid=$(this).val();      //来存在页面输入的userid
		
			if(window.ActiveXObject){						//创建Ajax对象
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}else if(window.XMLHttpRequest){
				xhr = new XMLHttpRequest();
			}else{
				alert("can't create xhr object!");
			}
			
			//2.准备数据回传过来之后的处理的函数
			xhr.onreadystatechange=processResult;
			
			//3.用ajax对象发起后台“静默”请求
			xhr.open("get","UserServlet?method=checkExists&userid="+yourInputuserid);
			xhr.send(null);		//get这里为空，参数在url里面，post参数要写send里面；post要设置请求头xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

			//alert($(this).val());
		}) */
	
	});
	</script>

    <div class="Login_Method">
    </div>
  </div>
  
   </form>
</div>
</div>




<!--底部样式-->
 <div class="bottom_footer">
   <p><a href="#">关于我们</a> | <a href="#">联系我们</a> | <a href="#">商家入驻</a> | <a href="#">法律申明</a> | <a href="#">友情链接</a>  </p>
	 <p>Copyright©2014四川金祥保险销售有限公司.All Rights Reserved. </p>
	 <p>川ICP备09150084号</p>
   </div>
</body>
</html>
