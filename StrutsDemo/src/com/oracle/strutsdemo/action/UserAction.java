package com.oracle.strutsdemo.action;

public class UserAction {
	private String a;
	private String password;
	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	/**
	 * 业务方法
	 * @return
	 */

	public String   execute() {
		System.out.println("进入到action后台判断登陆的方法了");
		System.out.println(a+"\t"+password);
		if(a.equals("2015117119")&&password.equals("123456")) {
			return "test";
		}else
		{
			return "b";
		}
	}

}
