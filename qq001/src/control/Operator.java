package control;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import qqmodel.qqUser;
public class Operator {

	public static boolean   register(qqUser qqUser) {
		File  data=new File("data/"+qqUser.getName()+".qq");
		if(data.exists())return false;
		return updateProfile(qqUser);
	}
	public static boolean  updateProfile(qqUser qqUser) {
		try {
			ObjectOutputStream  out=new ObjectOutputStream(new FileOutputStream("data/"+qqUser.getName()+".qq"));
			out.writeObject(qqUser);
			out.flush();
			out.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	public static qqUser  login(String qqUsername,String password) {
		File  data=new File("data/"+qqUsername+".qq");
		if(!data.exists()) {
			return null;
		}else
		{
			
			try {
				ObjectInputStream  in=new ObjectInputStream(new FileInputStream("data/"+qqUsername+".qq"));
				qqUser dbqqUser=(qqUser)in.readObject();
				if(password.equals(dbqqUser.getPassword()))
				{
					return dbqqUser;
				}else
				{
					return null;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}


	public static void main(String[] args) {
		
		/*try {
			ObjectInputStream  in=new ObjectInputStream(new FileInputStream("data/111.qq"));
			System.out.println(in.readObject());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//准备几条数据存储到数据库里面当做测试数据
		qqUser  qqUser=new qqUser("111","男","111",18,"/image/QQ.png","老王","只要锄头轮的好，没有挖不到的墙角");
		qqUser  qqUser1=new qqUser("222","女","222",28,"/image/QQ.png","zyj","只要锄头轮的好，没有挖不到的墙角");
		qqUser  qqUser2=new qqUser("333","男","333",38,"/image/QQ.png","mm","只要锄头轮的好，没有挖不到的墙角");
		qqUser  qqUser3=new qqUser("444","女","444",48,"/image/QQ.png","yy","只要锄头轮的好，没有挖不到的墙角");
		qqUser  qqUser4=new qqUser("555","男","555",18,"/image/QQ.png","xzy","只要锄头轮的好，没有挖不到的墙角");
		qqUser  qqUser5=new qqUser("666","女","666",28,"/image/QQ.png","小红","只要锄头轮的好，没有挖不到的墙角");
		qqUser  qqUser6=new qqUser("777","男","777",58,"/image/QQ.png","小明","只要锄头轮的好，没有挖不到的墙角");

//		Map<String,Set<qqUser>>  myGroups=new HashMap<>();
//		
//		Set<qqUser>  qun1Friends=new HashSet<>();
//		
//		qun1Friends.add(qqUser1);
//		qun1Friends.add(qqUser2);
//		
//		myGroups.put("吹牛皮群",qun1Friends);
//		
		
		
//		Set<qqUser>  qun2Friends=new HashSet<>();
//		
//		qun2Friends.add(qqUser5);
//		qun2Friends.add(qqUser6);
//		
//		myGroups.put("扯淡群",qun2Friends);
//		qqUser.setMyGroups(myGroups);
//		
		
		//给qqUser用户封装一个好友列表信息
		Map<String,HashSet<qqUser>> friends = new HashMap<>();
		HashSet<qqUser>  f1s=new HashSet<>();
				f1s.add(qqUser1);
				f1s.add(qqUser2);
				f1s.add(qqUser3);
				friends.put("大学室友", f1s);
				
				HashSet<qqUser> f2s = new HashSet<>();
				f2s.add(qqUser4);
				f2s.add(qqUser5);
				friends.put("大学损友", f2s);
				
				HashSet<qqUser>
				f3s=new HashSet<>();
				f3s.add(qqUser6);
				friends.put("暗恋的对象", f3s);
				
				qqUser.setFriends(friends);
	
				Map<String,HashSet<qqUser>> 	friends1=new HashMap<>();
				HashSet<qqUser>  f1s1=new HashSet<>();
				f1s1.add(qqUser);
				f1s1.add(qqUser3);	
				friends1.put("好盆友", f1s1);
				qqUser4.setFriends(friends1);
				
				
		try {
			ObjectOutputStream  out=new ObjectOutputStream(new FileOutputStream("data/"+qqUser.getName()+".qq"));
			out.writeObject(qqUser);
			out.flush();
			out.close();
			
			out=new ObjectOutputStream(new FileOutputStream("data/"+qqUser1.getName()+".qq"));
			out.writeObject(qqUser1);
			out.flush();
			out.close();
			
			out=new ObjectOutputStream(new FileOutputStream("data/"+qqUser2.getName()+".qq"));
			out.writeObject(qqUser2);
			out.flush();
			out.close();
			
			out=new ObjectOutputStream(new FileOutputStream("data/"+qqUser3.getName()+".qq"));
			out.writeObject(qqUser3);
			out.flush();
			out.close();
			
			out=new ObjectOutputStream(new FileOutputStream("data/"+qqUser4.getName()+".qq"));
			out.writeObject(qqUser4);
			out.flush();
			out.close();
			out=new ObjectOutputStream(new FileOutputStream("data/"+qqUser5.getName()+".qq"));
			out.writeObject(qqUser5);
			out.flush();
			out.close();
			out=new ObjectOutputStream(new FileOutputStream("data/"+qqUser6.getName()+".qq"));
			out.writeObject(qqUser6);
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
