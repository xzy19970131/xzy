package com.oracle.TeaMall.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.json.JSONArray;
import org.json.JSONObject;


import com.oracle.TeaMall.bean.User;
import com.oracle.TeaMall.dao.UserDAO;
import com.oracle.TeaMall.dao.UserDAOImp;
import com.oracle.TeaMall.util.MD5;
import com.oracle.TeaMall.util.Responser;

//component
//javabean 豆子
//功能bean和模型bean
public class UserAction  implements RequestAware{
	private Map<String,Object>  request=new HashMap<>();
	private  User  u;
	private int userid;
	private String password;
	private  UserDAO  dao;
	private int page;
	private int rows;
	private int i;
	
	

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public UserAction() {
		dao=new UserDAOImp();
	}
	/**
	 * 添加用户
	 */
	public String add() {
		int userid =u.getUserid();
		String password =u.getPassword();
		User user=new User();
		user.setUserid(userid);
		user.setPassword(MD5.MD5(password));//在将表单提交过来的密码风涨到user对象前，先用md5算法把密码加密
		boolean  result=dao.add(user);
		
		
		if(result) {
			return "registerSuccess";
		}else
		{
			return "registerFail";
		}
	}
	public String del(int userid) {
		System.out.println("进了del");
		boolean  result=dao.delete(userid);;
		
		
		if(result) {
			return "registerSuccess";
		}else
		{
			return "registerFail";
		}
	}
	/**
	 * 分页加载用户资料
	 */
	public void listUserByPage() {
		ArrayList<User>  users=dao.listUserByPage(rows, page);
		JSONArray  js=new JSONArray();
		for(User u:users)
		{
			try {
				JSONObject  j=new JSONObject();
				
				j.put("userid", u.getUserid());
				j.put("username", u.getUsername());
				j.put("sex",(u.getSex()==0)?"男":"女");
				j.put("age", u.getAge());
				j.put("job", u.getJob());
				j.put("nickname", u.getNickname());
				j.put("image", "<img src='"+u.getImage()+"' style='width:20px;height:20px' />");
				js.put(j);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/*需多次使用，已封装在Responser中
		 * ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		 * PrintWriter out=ServletActionContext.getResponse().getWriter;
		 * out.write(js.toString());
		 * out.flush();
		 * out.close();
		 */
		System.out.println(js.toString());
		try {
			Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), js.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 处理登陆的业务方法
	 * @return
	 */

	public String   login() {
		System.out.println("进UserAction");
		System.out.println(userid+password);
		User u=dao.login(userid, MD5.MD5(password));
		System.out.println("resultUser:"+u);
		if(u!=null) {
			ServletActionContext.getRequest().getSession().setAttribute("user", u);
			System.out.println("success");
			return "success";
		}else
		{		System.out.println("fail");
			return "fail";
		}
	}
	
	public String  sss() {
		System.out.println("oooo");
		System.out.println(i);	
		System.out.println("ppppp");
		return "s";

	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request=arg0;
	}
		
	}

