package chaye;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDaoImp extends BaseDaoImp implements UserDao {
	
	public boolean add(Object o) {
		User user=(User)o;
		boolean result=false;
		Statement  sta=null;
		try {
			sta=getSta();
			int count=sta.executeUpdate("insert into  user(userid,mima,youxiang,xingming) values('"+user.getUserid()+"','"+user.getMima()+"','"+user.getYouxiang()+"','"+user.getXingming()+"')");
			result=(count>0)?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean delete(Object id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object o) {
		System.out.println("进update了");
		User user=(User)o;
		boolean result=false;
		Statement  sta=null;
		try {
			sta=getSta();
			int count=sta.executeUpdate("update user set nicheng='"+user.getNicheng()+"',xingbie='"+user.getXingbie()+"',touxiang='"+user.getTouxiang()+"',xingming='"+user.getXingming()+"',shoujihao='"+user.getShoujihao()+"',youxiang='"+user.getYouxiang()+"' where userid='"+user.getUserid()+"'");
	
			result=(count>0)?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}


	@Override
	public Object list() {
		// TODO Auto-generated method stub
		return null;
	}

	


	

	public User getUserInfoBydenglu(String userid) {
		User  u = new User();
		ResultSet rs=null;
		try {
			rs=getSta().executeQuery("select *  from user where userid="+userid);
			if(rs.next())
			{
					u.setNicheng(rs.getString("nicheng"));
					u.setXingming(rs.getString("xingming"));
					u.setTouxiang(rs.getString("touxiang"));
					u.setXingbie(rs.getInt("xingbie"));
					u.setShoujihao(rs.getInt("shoujihao"));
					u.setUserid(rs.getInt("userid"));
					u.setYouxiang(rs.getString("youxiang"));
					u.setMima(rs.getString("mima"));
			
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
			return  u;
	}
	
	

	@Override
	public ArrayList<User> getAllTeaByTuiguang() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean checkUserExsit(String userid) {
		boolean result=false;
		Statement  sta=null;
		try {
			sta=getSta();
			ResultSet  rs=sta.executeQuery("select  count(userid)  from  user where userid='"+userid+"'");
			rs.next();
			result=(rs.getInt(1)>0)?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
