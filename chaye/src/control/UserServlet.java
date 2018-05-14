package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import chaye.Tea;
import chaye.TeaDaoImp;
import chaye.User;
import chaye.UserDaoImp;
import fujia.MD5;
import chaye.UserDaoImp;

import java.util.ArrayList;

@WebServlet("/UserServlet")    
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDaoImp dao;
 
    public UserServlet() {
        super();
		dao = new UserDaoImp();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");          //post是加密，要在最前面一个都没有取的时候就设置，get是不加密的，必须要用强制转码
		String methodName = request.getParameter("method");
		System.out.println(methodName);
			switch(methodName) {
			case "denglu":{
				getUserInfoBydenglu(request, response);
				break;	
			}
			case "registered":{	
				registered(request, response);
				break;
			}
		}
	
	}

	private void registered(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
	/*	//1.先去除用户输入的验证码
		String  code=request.getParameter("code");
		System.out.println("您在网页上输入的验证码："+code);
		//2.取出系统生成的验证码值
		String  systemCode=request.getSession().getAttribute("generateCode").toString();
		if(!code.equalsIgnoreCase(systemCode)) {//equlas会比较内容和大小写，   equalsingonrecase
			System.out.println("验证码验证失败了，立马调到前台页面");
			request.setAttribute("loginResultMessage", "codeError");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			//在后台servlet中，代码里面如果转发和重定向后面继续写其他业务代码，会报错
				return ;
		}*/
	
		int userid = Integer.parseInt(request.getParameter("userid"));
		
		System.out.println("前"+request.getCharacterEncoding());
		
		System.out.println("后"+request.getCharacterEncoding());
		String mima = request.getParameter("mima");
		String xingming= request.getParameter("xingming");
		System.out.println("999999999");
		System.out.println("账号:"+userid);
		System.out.println("姓名:"+xingming);
		//String password = request.getParameter("password");
		String youxiang = request.getParameter("youxiang");
		
		User user=new User();
		user.setUserid(userid);
		user.setMima(fujia.MD5.MD5(mima));
		user.setXingming(xingming);
		user.setYouxiang(youxiang);
		
		
		
		//user.setPassword(MD5.MD5(password));//在将表单提交过来的密码风涨到user对象前，先用md5算法把密码加密
		boolean  result=dao.add(user);
		if(result) {
			request.setAttribute("loginResultMessage", "registerSuccess");
		}else
		{
			request.setAttribute("loginResultMessage", "registerFail");
		}

		
		request.setAttribute("loginResultMessage", "codeError");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


	private void getUserInfoBydenglu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		//1.先去除用户输入的验证码
				String  code=request.getParameter("code");
				System.out.println("您在网页上输入的验证码："+code);
				if(request.getParameter("code")!=null)
				{
					//2.取出系统生成的验证码值
					String  systemCode=request.getSession().getAttribute("generateCode").toString();
					if(!code.equalsIgnoreCase(systemCode)) {//equlas会比较内容和大小写，   equalsingonrecase
						System.out.println("验证码验证失败了，立马调到前台页面");
						request.setAttribute("loginResultMessage", "codeError");
						request.getRequestDispatcher("index.jsp").forward(request, response);
						//在后台servlet中，代码里面如果转发和重定向后面继续写其他业务代码，会报错
							return ;
					}
				}
		
		
		
		
		
		
		//jsp如果充当是后台组件，那么应该吧所有的html标签删除

		//1.获取用户从上一个页面提交时输入的数据
		String  userid=new String(request.getParameter("userid"));//账号
		String  mima=request.getParameter("mima");//密码

		//2.根据数据查询数据库，找到对应的车辆信息
		UserDaoImp  dao=new UserDaoImp();
		User  searchedUsers=dao.getUserInfoBydenglu(userid);
		
		if(searchedUsers.getMima().equals(MD5.MD5(mima)))
		{
			//3.当数据准备完毕之后，应该跳转到下一个页面(jsp)
			request.getSession().setAttribute("loginedUser", searchedUsers);//回话范围内存储用户资料，这样能保证用户在一次绘画中可以保留用户登录的信息
			request.getRequestDispatcher("index.jsp").forward(request,response); //request对象负责让这个jsp跳转到下一个页面
			// response.sendRedirect("all-listings.jsp");//response对象的这个方法是重定向，它也会让当前jsp跳转到下一个制定的jsp
		
		}
		else { //账号密码错误
			request.getRequestDispatcher("mm.jsp").forward(request,response); //request对象负责让这个jsp跳转到下一个页面
		}
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		doGet(request, response);
	}

}
