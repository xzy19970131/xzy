package md;

import java.io.IOException;

public class dos3 {
	
	
	public static void main(String[] args) {
		mkdir();
		
	}
	public static void mkdir(){
		Runtime rt = Runtime.getRuntime();
		String s1="f:\\4.png";
		String s2="f:\\22";
		String cmddir = "tesseract"+ " "+s1+" "+s2+" "+ "-l chi_sim";
        System.out.println(cmddir);
        try {
            rt.exec(cmddir);
            System.out.println("成功执行！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
