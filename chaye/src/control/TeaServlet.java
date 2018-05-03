package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaye.NewDaoImp;
import chaye.Tea;
import chaye.TeaDao;
import chaye.TeaDaoImp;
import chaye.User;
import chaye.UserDaoImp;


@WebServlet("/teastore/TeaServlet")
public class TeaServlet extends HttpServlet {
	

	private TeaDao  dao;
	private NewDaoImp  newDAO;
	
	private static final long serialVersionUID = 1L;
    public TeaServlet() {
        super();
     
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
		
		}
	
		default:
			break;
		}
	}
	
	private void detail(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
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
