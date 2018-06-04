package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import chaye.Tea;
import chaye.TeaDaoImp;
import chaye.User;
import chaye.UserDaoImp;
import fujia.MD5;
import chaye.UserDaoImp;

import java.util.ArrayList;
import java.util.UUID;

@WebServlet("/UserServlet")    
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  ServletConfig  config;
    private UserDaoImp dao;
    public void init(ServletConfig config) throws ServletException {
		this.config=config;
	}
    public UserServlet() {
        super();
		dao = new UserDaoImp();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");          //post是加密，要在最前面一个都没有取的时候就设置，get是不加密的，必须要用强制转码
	
		if(request.getParameter("method")==null) 
		{//如果是上传文件的方法，则会进入到这个分支
			updateUserInfo(request,response);
		}else 
		{
			String methodName = request.getParameter("method");
			System.out.println(methodName);
				switch(methodName) {
				case "denglu":{
					getUserInfoBydenglu(request, response);
					break;	
				}
				case "tuichu": {
					tuichu(request, response);
					break;
				}
				
				case "registered":{	
					registered(request, response);
					break;
				}
				
				case "jiazai": {
					jiazai(request, response);
					break;
				}
				
				case "checkExists":{	
					checkExists(request, response);
					break;
				}
			
				
				
			}
		
		}
	}
	
	
	


	private void checkExists(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
			System.out.println("检测用户是否存在的方法");
			String  userid=request.getParameter("userid");
			boolean result=dao.checkUserExsit(userid);//调用dao方法判断userid是否存在
			//悄悄把数据会给他
			//用response（响应）对象中的输出流将处理好的结果输出给ajax请求对象
			response.setContentType("text/html;charset=UTF-8");//  text/html     ,text/xml    ,text/json
			PrintWriter  out=response.getWriter();//获取响应对象中的输出流
			out.write(result+"");
			out.flush();
			out.close();
			System.out.println(result);
		
	}
	protected void updateUserInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//用smartUpload来读取表单上传的文件和表单中的数据
				SmartUpload su = new SmartUpload();//创建一个smartUpload上传插件的对象
				// 上传初始化
				su.initialize(config,request,response);//,读取request，response中的数据到smartupload插件中
				try {
					su.upload();//把这个表单提交的数据读取到upload插件里
					su.save("/images");
				} catch (SmartUploadException e) {
					e.printStackTrace();
				}
				
				Request  re=su.getRequest();//如果要读取表单中的文本数据，必须要使用的smartUplod里面的request
		
				String  nicheng=re.getParameter("nicheng");
				String xingming=re.getParameter("xingming");
				//String touxiang=re.getParameter("touxiang");
				String	xingbie=re.getParameter("xingbie");
				String shoujihao=re.getParameter("shoujihao");
				System.out.println("手机号："+shoujihao);
				String youxiang=re.getParameter("youxiang");
				String userid=re.getParameter("userid");
				System.out.println("姓名："+xingming);
				System.out.println("id："+userid);
				/**
				 * 将表单取到的数据封装成一个user对象
				 */
				User user=new User();
				user.setNicheng(nicheng);
				user.setXingming(xingming);
				user.setXingbie(Integer.parseInt(xingbie));
				user.setShoujihao(Integer.parseInt(shoujihao));
				user.setYouxiang(youxiang);
				user.setUserid(Integer.parseInt(userid));
				
				System.out.println(user);
			
				
				File  uploadFile=su.getFiles().getFile(0);//从smartupload插件中读取出页面上传的多个文件对象
				System.out.println(uploadFile.getFileName());
				System.out.println(uploadFile.getSize());
				try {
					System.out.println(request.getRealPath("/images/uploadFiles/"));
				//	UUID //javaUUID ,算法，生成同一空间同一时间下绝不重复的字符串 36 
					String  uuidName=UUID.randomUUID().toString();
					java.io.File    destFile=new java.io.File(request.getRealPath("/images/uploadFiles/"));
					String childPath="";
					for(int n=0;n<uuidName.length();n++)
					{
						childPath+=uuidName.charAt(n)+"/";
					}
					java.io.File  f=new java.io.File(destFile,childPath);
					f.mkdirs();
					java.io.File  file=new java.io.File(f,uuidName+"."+uploadFile.getFileExt());
					
					uploadFile.saveAs(file.getAbsolutePath());
					String  urlPath=file.getAbsolutePath().substring(file.getAbsolutePath().indexOf("images"),file.getAbsolutePath().length());
					System.out.println("urlPath:"+urlPath);
					user.setTouxiang(urlPath);//将新上传的图片的路径设置到user对象中，传到dao里面修改新的头像地址
					
					
					
					boolean result=dao.update(user);
					System.out.println("result:"+result);
					System.out.println("user:"+user);
				} catch (SmartUploadException e) {
					e.printStackTrace();
				}
					request.setAttribute("u", user);
					request.getRequestDispatcher("user_info.jsp").forward(request, response);
	
	}


	private void jiazai(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("进jiazai");
		String userid=request.getParameter("userid");    //去得登陆的人的id
		System.out.println(userid);	
		User  searchedUsers=dao.getUserInfoBydenglu(userid);   //根据id 查数据库，取得user对象
		System.out.println(searchedUsers);
		request.setAttribute("u", searchedUsers);
		request.getRequestDispatcher("user_info.jsp").forward(request, response);
		
		
	}


	private void tuichu(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		System.out.println("laile1");
	
		request.getSession().removeAttribute("u");
		response.sendRedirect("index.jsp");
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
					System.out.println(request.getSession().getAttribute("generateCode"));
					System.out.println(request.getSession().getAttribute("generateCode").toString());
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
			
			String  rememberme=	request.getParameter("rememberme");
	
			if(rememberme!=null) {//说明用户勾选了，保存用户名和密码的选项
				System.out.println("进来存储cookie了");
				Cookie   useridCookie=new Cookie("userid", userid);
				Cookie   mimaCookie=new Cookie("mima", mima);
				useridCookie.setMaxAge(1000*60*60*24*3);
//				usernameCookie.setDomain("www.ershouche.com");
				mimaCookie.setMaxAge(1000*60*60*24*3);
//				passwordCookie.setDomain("www.ershouche.com");
				
				response.addCookie(useridCookie);
				response.addCookie(mimaCookie);
			}/*else {
				usernameCookie.setMaxAge(0);
//				usernameCookie.setDomain("www.ershouche.com");
				passwordCookie.setMaxAge(0);
//				passwordCookie.setDomain("www.ershouche.com");
				
			}*/
			
			
			
			
			//3.当数据准备完毕之后，应该跳转到下一个页面(jsp)
			request.getSession().setAttribute("u", searchedUsers);//回话范围内存储用户资料，这样能保证用户在一次绘画中可以保留用户登录的信息
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
