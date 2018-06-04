package com.oracle.TeaMall.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.oracle.TeaMall.bean.User;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;



public class UserDAOImp extends BaseDAOImp implements UserDAO {
	/**
	 * 添加用户
	 */
	@Override
	public boolean add(Object o) {
		User user=(User)o;
		boolean result=false;
		Statement sta=null;
		try {
			sta=getSta();
			int count=sta.executeUpdate("insert into  user2(userid,username,password)   values(null,'"+user.getUsername()+"','"+user.getPassword()+"')");
			//由于userID列不能为空，所以在这里用一个变量的值来填充，后面为保证userid按顺序增加，将rownum的值赋给它
			result=(count>0)?true:false;
		} catch (Exception e) {
		}
		return result;
	}
	/**
	 * 删除用户
	 */
	@Override
	public boolean delete(Object id) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 修改用户
	 */
	public boolean update(Object o) {
		User u=(User)o;
		PreparedStatement  preSta=null;
		int result=0;
		try {
			  preSta=getPreSta("update user2 set username=? ,nickname=?,sex=?,age=?,image=?,job=?,jialing=?,email=?,tel=?,jianjie=? where userid=?");
			  preSta.setString(1, u.getUsername());
			  preSta.setString(2, u.getNickname());
			  preSta.setInt(3, u.getSex());;
			  preSta.setInt(4, u.getAge());;
			  preSta.setString(5, u.getImage());
			  preSta.setString(6, u.getJob());
			  preSta.setInt(7, u.getJialing());
			  preSta.setString(8, u.getEmail());
			  preSta.setString(9, u.getTel());
			  preSta.setString(10, u.getJianjie());
			  preSta.setInt(11, u.getUserid());
			  result=preSta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result>0?true:false;
	}

	private PreparedStatement getPreSta(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(String username, String password) {
		User  user=null;
		PreparedStatement  sta=null;
		ResultSet rs=null;
		try {
			sta=getPreSta("select *  from user2 where username=? and password=?");
			sta.setString(1, username);
			sta.setString(2, password);
			rs=sta.executeQuery();
			if(rs.next()) {
				user=new User();
				user.setAge(rs.getInt("age"));
				user.setImage(rs.getString("image"));
				user.setNickname(rs.getString("nickname"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getInt("sex"));
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * 搜索功能
	 */
	@Override
	public User getUserInfoByUserId(int userid) {
		User  user=null;
		ResultSet rs=null;
		try {
			rs=getSta().executeQuery("select *  from user2 where userid=?");
			if(rs.next()) {
				user=new User();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				if(rs.getString("image")!=null)
				{
					user.setAge(rs.getInt("age"));
					user.setImage(rs.getString("image"));
					user.setNickname(rs.getString("nickname"));
					user.setPassword(rs.getString("password"));
					user.setSex(rs.getInt("sex"));
					user.setUserid(rs.getInt("userid"));
					user.setUsername(rs.getString("username"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;	
		}

	@Override
	public boolean changePasswd(String usernameByChange,String newPasswd) {
		String password=newPasswd;
		String username=usernameByChange;
		ResultSet rs = null;
		int result=0;
		try {
			result=getSta().executeUpdate("UPDATE USER2 SET PASSWORD='"+password+"' WHERE USERNAME='"+username+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result>0?true:false;
	}
	
	@Override
	public ArrayList<User> listUserByPage(int count, int page) {
		System.out.println("后台dao方法listUserByPage"+count+"--"+page);
		ArrayList<User>  users=new ArrayList<>();
		PreparedStatement  sta=null;
		ResultSet rs=null;
		try {
			rs = getSta().executeQuery("select *  from  user2  limit  "+((page-1)*count)+" ,"+count);
			//sta=getPreSta("select *  from user limit "+((page-1)*count)+","+count);
			/*sta.setInt(1, (page-1)*count);
			sta.setInt(2, count);
			rs=sta.executeQuery();*/
			while(rs.next()) {
				User  user=new User();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				if(rs.getString("image")!=null)
				{
					user.setAge(rs.getInt("age"));
					user.setImage(rs.getString("image"));
					user.setNickname(rs.getString("nickname"));
					user.setSex(rs.getInt("sex"));
					user.setJob(rs.getString("job"));
					user.setJialing(rs.getInt("jialing"));
					user.setEmail(rs.getString("email"));
					user.setTel(rs.getString("tel"));
					user.setJianjie(rs.getString("jianjie"));
				}
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
		//disposeResource(sta,	rs);
		return users;
	}

}
