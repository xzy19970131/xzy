package control;

import java.io.File;

import qqmodel.qqUser;
public class Operator {

	public static boolean   register(qqUser user) {
		
		File  data=new File("databases/"+user.getUsername()+".qq");
		if(data.exists())return false;		
		return updateProfile(qquser);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
