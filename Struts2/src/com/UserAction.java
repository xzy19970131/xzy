package com;

public class UserAction {
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	public String execute() {
		if(username.equals("admin")&&password.equals("123456"))
		{
			return "a";
		}else {
			return "b";
		}

	}

}
