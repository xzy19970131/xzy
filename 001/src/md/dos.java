package md;

import java.io.IOException;

public class dos {
	
	
	public static void main(String[] args) {
		mkdir();
		
	}
	public static void mkdir(){
		Runtime rt = Runtime.getRuntime();
        String cmddir = "cmd /k mkdir f:\\66666666";
        System.out.println(cmddir);
        try {
            rt.exec(cmddir);
            System.out.println("成功执行！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
