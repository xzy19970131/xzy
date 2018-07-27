package md;

import java.io.IOException;

public class dos2 {
	
	
	public static void main(String[] args) {
		mkdir();
		
	}
	public static void mkdir(){
		Runtime rt = Runtime.getRuntime();
		//String cmddir = "cmd /k mkdir f:\\66666666";
	//	 String cmddir = "cmd /k cd:f";
		 String cmddir2 = "";
        System.out.println(cmddir2);
        try {
          //  rt.exec(cmddir);
            rt.exec(cmddir2);
            System.out.println("成功执行！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
