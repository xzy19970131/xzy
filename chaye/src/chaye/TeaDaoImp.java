package chaye;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class TeaDaoImp extends BaseDaoImp implements TeaDao{

	@Override
	public boolean add(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object list() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据传入的数量查询出最近的指定数量的二手车信息
	 */
	public ArrayList<Tea>  listRecentTeasByCount(int count){  /**/
		ArrayList<Tea>  Teas=new  ArrayList<Tea>();//定义一个集合存储查询出来的所有车辆信息
		ResultSet rs=null;
	try {
		rs=getSta().executeQuery("select *  from  chaye order by  chayeid asc limit "+count);
		while(rs.next())
		{
			Tea  t=new Tea();
			t.setChayeid(rs.getInt("chayeid"));
			t.setMingzi(rs.getString("mingzi"));
			t.setYuanjia(rs.getInt("yuanjia"));
			t.setXianjia(rs.getInt("xianjia"));
			t.setShoutu(rs.getInt("shoutu"));
			t.setPinglunshu(rs.getInt("pinglunshu"));
	
			Teas.add(t);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	disposeResource(getSta(), rs, getCon());
		return  Teas;
	}

	@Override
	public ArrayList<Tea> getAllTeaByTuiguang() {
		ArrayList<Tea>  Teas=new  ArrayList<Tea>();//定义一个集合存储查询出来的所有车辆信息
		ResultSet rs=null;
	try {
		rs=getSta().executeQuery("select *  from  chaye   where  shifoutuiguang=1");
		while(rs.next())
		{

			Tea  t=new Tea();
			t.setChayeid(rs.getInt("chayeid"));
			t.setMingzi(rs.getString("mingzi"));
			t.setYuanjia(rs.getInt("yuanjia"));
			t.setXianjia(rs.getInt("xianjia"));
			t.setShoutu(rs.getInt("yshoutu"));
			t.setPinglunshu(rs.getInt("pinglunshu"));
			Teas.add(t);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	disposeResource(getSta(), rs, getCon());
		return  Teas;
	}
	

	public Tea getteaInfoById(int chayeId) {
		Tea  t=null;
		ResultSet rs=null;
		try {
			rs=getSta().executeQuery("select *  from chaye where chayeid="+chayeId);
			if(rs.next())
			{
				t=new Tea();
					t.setChayeid(rs.getInt("chayeid"));
					t.setMingzi(rs.getString("mingzi"));
					t.setYuanjia(rs.getInt("yuanjia"));
					t.setXianjia(rs.getInt("xianjia"));
					t.setShoutu(rs.getInt("shoutu"));
					t.setPinglunshu(rs.getInt("pinglunshu"));
			
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
			return  t;
	}
	
	
	
	
	public ArrayList<Tea> searchTeasByCondition(String mingzi, String min, String max) {
		/**
		 * 条件有很多种不同，那么sql语句就应该有对应的变动
		 */
		System.out.println(mingzi);
		String SQL="select *  from  chaye  where  1=1";
		if(mingzi!=null&&!mingzi.equals("")) {
			SQL+="   and  mingzi='" +mingzi+"'";
		}
		if(min!=null&&!min.equals("")) {
			SQL+="   and  xianjia>="+min;
		}
		if(max!=null&&!max.equals("")) {
			SQL+="   and  xianjia<="+max;
		}
	
		
		System.out.println(SQL);
		
		ArrayList<Tea> teas=new  ArrayList<Tea>();//定义一个集合存储查询出来的所有车辆信息
		ResultSet rs=null;
	try {
		rs=getSta().executeQuery(SQL);
		while(rs.next())
		{
			Tea t=new Tea();
			t.setChayeid(rs.getInt("chayeid"));
			t.setMingzi(rs.getString("mingzi"));
			t.setYuanjia(rs.getInt("yuanjia"));
			t.setXianjia(rs.getInt("xianjia"));
			t.setShoutu(rs.getInt("shoutu"));
			t.setPinglunshu(rs.getInt("pinglunshu"));
			teas.add(t);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	disposeResource(getSta(), rs, getCon());
		return  teas;
	}

	@Override
	public ArrayList<Tea> listTeaByPage(int page, int count) {
		ArrayList<Tea> Teas = new ArrayList<Tea>();// 定义一个集合存储查询出来的所有车辆信息
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery("select *  from  chaye   limit  "+(page-1)*count+" ,"+count);
			while (rs.next()) {

				Teas.add(parsetResultToTea(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
		return Teas;
	}

	private Tea parsetResultToTea(ResultSet rs) {
		Tea t = null;
		try {
			t = new Tea();
			t.setChayeid(rs.getInt("chayeid"));
			t.setMingzi(rs.getString("mingzi"));
			t.setYuanjia(rs.getInt("yuanjia"));
			t.setXianjia(rs.getInt("xianjia"));
			t.setShoutu(rs.getInt("shoutu"));
			t.setPinglunshu(rs.getInt("pinglunshu"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public int getAllCountOfTeas() {
		int  n=0;
		ResultSet  rs=null;
		try {
			  rs=getSta().executeQuery("select count(chayeid)  from  chaye");
			  rs.next();
			  n=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public ArrayList<String> mohuSearchList(String key) {
		ArrayList<String> teas = new ArrayList<String>();
		ResultSet  rs=null;
		try {
			System.out.println(key);
			  rs=getSta().executeQuery("select mingzi  from  chaye where mingzi like '%"+key+"%' limit 10");
			  while(rs.next())
			  {
				  teas.add(rs.getString(1));
			  }

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teas;
	}
	
	

	

}
