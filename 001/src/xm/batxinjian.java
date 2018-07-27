package xm;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class batxinjian {
	public void creatBat(String command) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("C:\\Users\\lenovo\\Desktop\\java.bat");
			fw.write(command);
		} catch (IOException e) {
	
			e.printStackTrace();
			System.exit(0);
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(0);
				}
			}
		}
	}

	private String execute(String batname) {
		Process process;
		String line = null;
		StringBuffer sb = new StringBuffer();
		try {
			process = Runtime.getRuntime().exec(batname);
			InputStream fis = process.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			if (process.waitFor() != 0) {
				System.out.println("fail");
				return "fail";
			}
			System.out.println(batname + " run successful!");
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	public static void main(String[] args) {
		batxinjian df = new batxinjian();
		df.creatBat("cd C:\\Program Files (x86)\\湖北文理学院\\My Product Name\r\n" + 
				"OpenCV C:\\Users\\lenovo\\Desktop\\2\r\n");
		df.execute("C:\\Users\\lenovo\\Desktop\\java.bat");
	}
}