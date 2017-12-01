package control;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import qqmodel.qqUser;
public class Operator {

	public static boolean   register(qqUser user) {
		File  data=new File("source/"+user.getName()+".qq");
		if(data.exists())return false;
		return updateProfile(user);
	}
	public static boolean  updateProfile(qqUser user) {
		try {
			ObjectOutputStream  out=new ObjectOutputStream(new FileOutputStream("databases/"+user.getName()+".qq"));
			out.writeObject(user);
			out.flush();
			out.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	


	public static qqUser login(String name, String password) {

		return null;
	}

}
