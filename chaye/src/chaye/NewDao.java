package chaye;

import java.util.ArrayList;

public interface NewDao extends BaseDao {
public ArrayList<New>  listRecentNewsByCount(int count);
	
	public NewDao getNewInfoById(int id);
}
