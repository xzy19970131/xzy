package md;

import java.io.IOException;

public class dos {
	
	
	public static void main(String[] args) {
		mkdir();
		
	}
	public static void mkdir(){
		Runtime rt = Runtime.getRuntime();
       // String cmddir = "cmd /k mkdir f:\\66666666";    //这行会在F盘建立一个66666的目录文件夹
		String cmddir = "cmd /k C:\\Users\\Public\\Desktop\\王恒.exe.lnk";
        System.out.println(cmddir);
        try {
            rt.exec(cmddir);
            System.out.println("成功执行！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
