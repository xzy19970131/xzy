package md;

import java.io.IOException;

public class dos3 {

	public static void main(String[] args) {
		photoRecognize();
		
	}
	public static void photoRecognize(){
		Runtime rt = Runtime.getRuntime();
		String s1="f:/4.png";              //s1存图片路径
		String s2="f:/22";					//s2存生成的txt路径
		String cmddir = "tesseract"+ " "+s1+" "+s2+" "+ "-l chi_sim";    //完整的dos语句
        System.out.println(cmddir);				//输出dos语句
        try {					
            rt.exec(cmddir);						//运行dos语句
            System.out.println("成功执行！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
