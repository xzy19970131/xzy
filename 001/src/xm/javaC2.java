package xm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class javaC2 {

	public static void main(String[] args) throws IOException {
		String cmd = "C:\\Users\\Public\\Desktop\\王恒.exe.lnk" + " " + "C:\\Users\\lenovo\\Desktop\\6" ;
		  //System.out.println("cmd:"+cmd);

		  //执行exe文件
		   final Process proc = Runtime.getRuntime().exec(cmd);

		   //读取exe文件在exe控制台的输出结果
		   BufferedReader stdout = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		   String l;
		   l = stdout.readLine();//读取一行

	}

}
