<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="chaye.User"%>
<%@page import="chaye.UserDaoImp"%>

<%@page import="java.util.ArrayList"%>
    
    
<%
//jsp如果充当是后台组件，那么应该吧所有的html标签删除

//1.获取用户从上一个页面提交时输入的数据
String  userid=new String(request.getParameter("userid"));//账号
String  mima=request.getParameter("mima");//密码




//2.根据数据查询数据库，找到对应的车辆信息
UserDaoImp  dao=new UserDaoImp();
User  searchedUsers=dao.getUserInfoBydenglu(userid,mima);

//3.当数据准备完毕之后，应该跳转到下一个页面(jsp)
session.setAttribute("loginedUser", searchedUsers);//回话范围内存储用户资料，这样能保证用户在一次绘画中可以保留用户登录的信息
request.getRequestDispatcher("index.jsp").forward(request,response); //request对象负责让这个jsp跳转到下一个页面
// response.sendRedirect("all-listings.jsp");//response对象的这个方法是重定向，它也会让当前jsp跳转到下一个制定的jsp
%>
