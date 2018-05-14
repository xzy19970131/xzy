<%@page import="chaye.Tea"%>
<%@page import="chaye.TeaDaoImp"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %><!-- EL的函数库=jstl的函数 -->
<%
//jsp如果充当是后台组件，那么应该吧所有的html标签删除

//1.获取用户从上一个页面提交时输入的数据
String  mingzi=new String(request.getParameter("mingzi"));//品牌
String  min=request.getParameter("min");//最低价
String max=request.getParameter("max");//最高价


//2.根据数据查询数据库，找到对应的车辆信息
TeaDaoImp  dao=new TeaDaoImp();
ArrayList<Tea>  searchedCars=dao.searchTeasByCondition(mingzi, min, max);




 
//<%-- <c:set value="teas" var="searchedCars" scope="session"></c:set> --
	request.setAttribute("teas", searchedCars);
//这里是将查询出来的集合存储到request，然后通过转发传递到下一个jsp中显示出来
//3.当数据准备完毕之后，应该跳转到下一个页面(jsp) 

request.getRequestDispatcher("Product_List.jsp").forward(request,response); //request对象负责让这个jsp跳转到下一个页面
// response.sendRedirect("all-listings.jsp");//response对象的这个方法是重定向，它也会让当前jsp跳转到下一个制定的jsp

%>

