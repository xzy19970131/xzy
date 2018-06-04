package control.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(filterName="sessionChecker",urlPatterns="/UserServlet")
public class SessionChecker implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//判断是否是非法访问需要登录的后台
		//1.先获取用户访问的url地址
		HttpServletRequest r = (HttpServletRequest) request;
		HttpServletResponse rs =(HttpServletResponse)response;
		String parameters=r.getQueryString();  //参数
		String url= r.getRequestURI();		//路径
		if(parameters==null) 
		{   //如果用户要登录，表单参数是隐藏的，所以判断parameters参数为null时候，就直接放行，让进入登录页面
			chain.doFilter(request, response);
			return;
		}
		if(parameters.contains("method=jiazai")) 
		{
			//判断session中有没有登录
			if(r.getSession().getAttribute("u")!=null) 
			{
				System.out.println("放行");
				chain.doFilter(request,response);//如果登录了，就放行
			}else 
			{
				System.out.println("没有登录，不让进");
				rs.sendRedirect("index.jsp");
			}
	
		}else 
		{
			chain.doFilter(request,response);   //如果不是要查看个人中心，其他功能不拦截，直接放行
		}

		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
