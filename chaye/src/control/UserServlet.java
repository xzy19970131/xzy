package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chaye.Tea;
import chaye.TeaDaoImp;
import chaye.User;
import chaye.UserDaoImp;
import chaye.UserDaoImp;

import java.util.ArrayList;

@WebServlet("/teastore/UserServlet")    
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDaoImp dao;
 
    public UserServlet() {
        super();
		dao = new UserDaoImp();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String methodName = request.getParameter("method");
		System.out.println(methodName);
		switch(methodName) {
		case "denglu":{
			getUserInfoBydenglu(request, response);
			break;
			
		}
		case "zhuce":{
			
		}
		}
		
		
		

		
	}

	private void getUserInfoBydenglu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//jsp如果充当是后台组件，那么应该吧所有的html标签删除

		//1.获取用户从上一个页面提交时输入的数据
		String  userid=new String(request.getParameter("userid"));//账号
		String  mima=request.getParameter("mima");//密码




		//2.根据数据查询数据库，找到对应的车辆信息
		UserDaoImp  dao=new UserDaoImp();
		User  searchedUsers=dao.getUserInfoBydenglu(userid,mima);

		//3.当数据准备完毕之后，应该跳转到下一个页面(jsp)
		request.getSession().setAttribute("loginedUser", searchedUsers);//回话范围内存储用户资料，这样能保证用户在一次绘画中可以保留用户登录的信息
		request.getRequestDispatcher("index.jsp").forward(request,response); //request对象负责让这个jsp跳转到下一个页面
		// response.sendRedirect("all-listings.jsp");//response对象的这个方法是重定向，它也会让当前jsp跳转到下一个制定的jsp
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		doGet(request, response);
	}

}
