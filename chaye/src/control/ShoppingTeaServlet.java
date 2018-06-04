package control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import chaye.Tea;
import chaye.TeaDaoImp;


@WebServlet("/ShoppingTeaServlet")
public class ShoppingTeaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeaDaoImp  dao;
    public ShoppingTeaServlet() {
    	dao=new TeaDaoImp();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("66665555");
		String method=request.getParameter("method");
		System.out.println("5555566");
		System.out.println(method);
		switch (method) {
		case "add":
		{	
			add(request, response);
			break;
		}
		case "deleteTea"://判断用户请求的参数中，告诉我们是进入哪个后台业务方法
		{	
			deleteTea(request, response);
			break;
		}
		case "deleteAll":
		{	
			deleteAll(request, response);
			break;
		}
		case "listAllTeas":
		{	
			listAllTeas(request, response);
			break;
		}
		case "jia":
		{	
			jia(request, response);
			break;
		}
		case "jian":
		{	
			jian(request, response);
			break;
		}
		default:
			break;
		}
		
	
	}
	
	private void jia(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		
		HashMap<Tea, Integer>  Teas=(	HashMap<Tea, Integer> )request.getSession().getAttribute("Teas");
		//1.先获取前端页面点击'添加到购物车'按钮时传过来的商品ID
		String  chayeid=request.getParameter("chayeid");
		System.out.println(chayeid);
		Tea  t=dao.getteaInfoById(Integer.parseInt(chayeid));
		int  nowCount=Teas.get(t);
		System.out.println("后:"+nowCount);
		Teas.put(t, nowCount+1);
		response.sendRedirect("shopping_car.jsp");//当数据添加到购物车之后，直接跳转到购物车页面，让用户看一下购物车的信息
	}


	private void jian(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
	
		
		HashMap<Tea, Integer>  Teas=(	HashMap<Tea, Integer> )request.getSession().getAttribute("Teas");
		//1.先获取前端页面点击'添加到购物车'按钮时传过来的商品ID
		String  chayeid=request.getParameter("chayeid");
		Tea  t=dao.getteaInfoById(Integer.parseInt(chayeid));
		int  nowCount=Teas.get(t)-1;
		Teas.put(t, nowCount);
		response.sendRedirect("shopping_car.jsp");//当数据添加到购物车之后，直接跳转到购物车页面，让用户看一下购物车的信息
	
	}


	/**
	 * 添加商品到購物車的方法
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
		protected void add(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		
			//1.先获取前端页面点击'添加到购物车'按钮时传过来的商品ID
			String  chayeid=request.getParameter("chayeid");
			System.out.println("加入购物车的id："+chayeid);
			//2.将这个车辆id存储到  ‘购物车’   里面
			//先判断session中有没有存储购物车集合，如果有，说明之前已经买过东西，如果没有说明没买过东西
			if(request.getSession().getAttribute("Teas")==null)
			{
					HashMap<Tea, Integer>  Teas=new HashMap<>();
					//创建一个map集合，这个集合就是‘购物车’，这里面存用户添加了哪些商品以及对应的数量
					Teas.put(dao.getteaInfoById(Integer.parseInt(chayeid)), 1);//将页面中添加的商品id和数量存储到购物车里
					
					//3.为了保证购物车能够在多次操作后依然能读取里面的数据，我们需要用session来存储购物车的数据
					request.getSession().setAttribute("Teas", Teas);
			}else {
				HashMap<Tea, Integer>  Teas=(	HashMap<Tea, Integer> )request.getSession().getAttribute("Teas");
				//创建一个map集合，这个集合就是‘购物车’，这里面存用户添加了哪些商品以及对应的数量
				
				//因为session中已经存过购物车集合，说明之前买过东西，此时在添加新商品的时候应该先判断之前买过这个商品吗
				//如果买过，应该是在原来的数量上加现在的数量，如果没买过就直接将这个商品添加到集合中
				
				if(Teas.containsKey(new Tea(Integer.parseInt(chayeid))))
				{
					System.out.println("9999");
					Tea  t=dao.getteaInfoById(Integer.parseInt(chayeid));
					int  nowCount=Teas.get(t)+1;
					Teas.put(t, nowCount);
				}
				else {
						Teas.put(dao.getteaInfoById(Integer.parseInt(chayeid)),  1);//将页面中添加的商品id和数量存储到购物车里
				}
//				3.为了保证购物车能够在多次操作后依然能读取里面的数据，我们需要用session来存储购物车的数据
				request.getSession().setAttribute("Teas", Teas);
				
				//4.为了提升用户体验度，我们除了讲用户购物车的数据放入session，同时再存入cookie，方便用户关闭页面时再打开能看到之前的购物车商品
				
		/*		for(Tea  tt:Teas.keySet()) {
					Cookie  r=new Cookie("car"+tt.getChayeid(), tt.getChayeid()+","+Teas.get(tt));//我改了
					r.setMaxAge(1000*60*60*24*15);
					response.addCookie(r);
				}*/
			}
		
			response.sendRedirect("shopping_car.jsp");//当数据添加到购物车之后，直接跳转到购物车页面，让用户看一下购物车的信息
		}
		/**
		 * 这是处理删除购物车商品的方法
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
		protected void deleteTea(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			System.out.println("9999");
			//1.获取要删除的车辆id
			System.out.println("删除");
			String id=request.getParameter("chayeid");
			//2.从session里面取出购物车集合
			HashMap<Tea, Integer>  shoppingTeas=(	HashMap<Tea, Integer> )request.getSession().getAttribute("Teas");
			for(Tea c:shoppingTeas.keySet()) {
				if(c.getChayeid()==Integer.parseInt(id)) {
					shoppingTeas.remove(c);
					Cookie[] cs=request.getCookies();
					for(Cookie css:cs) {
						if(css.getName().equals("Tea"+id)) {
							css.setMaxAge(0);
							response.addCookie(css);
							break;
						}
					}
					break;
				}
			}
			//3.档购物车的商品删除成功后，跳转到购物车页面
			response.sendRedirect("shopping_car.jsp");
		}
		/**
		 * 清空购物车方法
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
		protected void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println();
			request.getSession().removeAttribute("Teas");
			response.sendRedirect("shopping_car.jsp");
		}
		/**
		 * 从cookie中度取出所有的购物车信息显示到购物车页面上
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
		protected void listAllTeas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			/**
			 * 调用这个方法，说明是要查看购物车，我们直接读取cookie中存储的商品信息，然后将cookie中读取的商品信息查出来然后存起来，显示在页面上
			 */
			HashMap<Tea, Integer>  shoppingTeas=new HashMap<>();
			Cookie[]  cs=request.getCookies();
			if(cs!=null)
			{
				for(Cookie c:cs) {
					if(c.getName().startsWith("Tea")) {
						String[] kv=c.getValue().replaceAll("\"", "").split(",");
						shoppingTeas.put(dao.getteaInfoById(Integer.parseInt(kv[0])), Integer.parseInt(kv[1]));
					}
				}
			}
			request.getSession().setAttribute("Teas", shoppingTeas);
			request.getRequestDispatcher("shoppingTea.jsp").forward(request, response);
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
