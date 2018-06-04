package com.oracle.TeaMall.dao;

import java.util.ArrayList;

import com.oracle.TeaMall.bean.User;

public interface UserDAO extends BaseDAO {
	public User  login(String username,String password);
	public  User getUserInfoByUserId(int userid);
//	public boolean checkUserExsit(String username);
	public ArrayList<User>  listUserByPage(int count,int page);
//	public int  getAllCountOfUser();
	public boolean changePasswd(String usernameByChange,String newPasswd);
	
}
