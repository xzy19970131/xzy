package chaye;
import java.util.ArrayList;

public interface TeaDao extends BaseDao{
	/*
	 * 设计一个可以根据用户传入的数量查询显示出最近发布的二手车信息
	 */
	public ArrayList<Tea>  listRecentTeasByCount(int count);
	

	/**
	 * 定义一个查询需要推广显示到滚动区域二手车信息的方法
	 */
	public  ArrayList<Tea>  getAllTeaByTuiguang();
	

}
