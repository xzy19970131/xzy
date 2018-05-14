package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import chaye.NewDaoImp;
import chaye.PageBean;
import chaye.Tea;
import chaye.TeaDao;
import chaye.TeaDaoImp;


@WebServlet("/TeaServlet")
public class TeaServlet extends HttpServlet {
	

	private TeaDao  dao;
	private NewDaoImp  newDAO;
	
	private static final long serialVersionUID = 1L;
    public TeaServlet() {
    	dao=new TeaDaoImp();
    	newDAO=new NewDaoImp();

     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String methodName=request.getParameter("method");//通过前端传过来的method参数来识别用户是要调用哪个方法
		switch (methodName) {
		case "detail":
		{
			detail(request,response);
			break;
		}
		case "index":
		{
			indexMethod(request,response);
			break;
		}
		case "listTeaByPage":
		{
			System.out.println("666");
			listTeaByPage(request,response);
			break;
		}
		default:
			break;
		}
	}
	
	private void listTeaByPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String  page=request.getParameter("page");
		String count=request.getParameter("count");
		ArrayList<Tea>  Teas=dao.listTeaByPage(Integer.parseInt(page),Integer.parseInt(count));
		


		
		/*
		 * 通过计算将分页中所有要用到的数字全部算出来
		 */
		int nowPage=Integer.parseInt(page);//当前页
		int allCount=dao.getAllCountOfTeas();//因为分页在页面上要知道最大页，所以，我们要调用dao中查询所有条数的方法，获得Tea有多少条
		int pageOfCount=Integer.parseInt(count);
		int allPages=(allCount%pageOfCount==0)?allCount/pageOfCount:(allCount/pageOfCount+1);//求总页数
		int perviousPage=nowPage<=1?1:(nowPage-1);
		int nextPage=nowPage>=allPages?allPages:(nowPage+1);
		
		/*
		 * 将所有的分页 中的属性封装成一个分页bean，将一个对象整体保存传到页面上
		 */
		PageBean  pageBean=new PageBean();
		pageBean.setNowPage(nowPage);
		pageBean.setPreviousPage(perviousPage);
		pageBean.setNextPage(nextPage);
		pageBean.setAllCount(allCount);
		pageBean.setAllPages(allPages);
		pageBean.setEverPageCount(pageOfCount);
		
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("teas", Teas);

		request.getRequestDispatcher("Product_List.jsp").forward(request, response);


		
	}


	private void indexMethod(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ssssssss");
//		System.out.println("进入后台来准备给数据了");
		//在页面没有加载完之前，先把这个页面要显示的数据查出来，准备好，下面才可以用
		
		System.out.println(dao.listRecentTeasByCount(8).size());
		ArrayList<Tea> allTeas=dao.listRecentTeasByCount(8);//这里应该调用查询N个车辆信息的方法，把需要显示在首页的车辆信息查询出来
		
		System.out.println(dao.listRecentTeasByCount(8).size());
		
		request.setAttribute("allTeas", allTeas);
	//	request.setAttribute("tuiguangTeas", allTeasOfTuiguang);
	//	request.getRequestDispatcher("NewServlet?method=listForIndex").include(request, response);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}


	private void detail(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("555555555555555555");
		//在页面加载前，先把这个页面要显示的数据准备好
		TeaDaoImp  dao=new TeaDaoImp();
		Tea teaInfo2=dao.getteaInfoById(Integer.parseInt(request.getParameter("chayeid")));
		System.out.println(teaInfo2.getMingzi());
		
		//3.当数据准备完毕之后，应该跳转到下一个页面(jsp)
		request.setAttribute("teaInfo2", teaInfo2);
		request.getRequestDispatcher("Product_Detailed.jsp").forward(request, response);
		
		//request.setAttribute("teaInfo2", teaInfo2);//回话范围内存储用户资料，这样能保证用户在一次绘画中可以保留用户登录的信息
	//	request.getRequestDispatcher("Product_Detailed.jsp").forward(request,response); //request对象负责让这个jsp跳转到下一个页面
		
		// response.sendRedirect("all-listings.jsp");//response对象的这个方法是重定向，它也会让当前jsp跳转到下一个制定的jsp
		
	}
	
	
	
	
	
	
	




	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
