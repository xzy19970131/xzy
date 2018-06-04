package chaye;

import java.util.ArrayList;

public interface UserDao {
	


	/**
	 * 定义一个查询需要推广显示到滚动区域二手车信息的方法
	 */
	public  ArrayList<User>  getAllTeaByTuiguang();

	boolean checkUserExsit(String username);
	


}
