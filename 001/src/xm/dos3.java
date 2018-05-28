package xm;

import java.io.IOException;

public class dos3 {
	public static void photoRecognize(String ptotoPath,String txtPath){
		Runtime rt = Runtime.getRuntime();
		String cmddir = "tesseract"+ " "+ptotoPath+" "+txtPath+" "+ "-l chi_sim";    //完整的dos语句
        System.out.println(cmddir);				//输出dos语句
        try {					
            rt.exec(cmddir);						//运行dos语句
            System.out.println("成功执行！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
