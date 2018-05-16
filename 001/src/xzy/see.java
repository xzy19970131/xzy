package xzy;

import java.io.IOException;
public class see {
	public static void mkdir(String s1,String s2){
		Runtime rt = Runtime.getRuntime();
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
