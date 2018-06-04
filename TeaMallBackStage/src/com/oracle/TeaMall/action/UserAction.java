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
	
	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}
	private  UserDAO  dao;
	private int page;
	private int rows;
	
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
		String username =u.getUsername();
		String password =u.getPassword();
		User user=new User();
		user.setUsername(username);
		user.setPassword(MD5.MD5(password));//在将表单提交过来的密码风涨到user对象前，先用md5算法把密码加密
		boolean  result=dao.add(user);
		
		
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

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request=arg0;
	}
		
	}

