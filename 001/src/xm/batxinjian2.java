package xm;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class batxinjian2 {
 public void creatBat(String command){
  FileWriter fw=null;
  try {
   fw=new FileWriter("D:\\del.bat");
   fw.write(command);
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
   System.exit(0);
  }finally{
   if(fw!=null){
    try {
     fw.close();
    } catch (IOException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
     System.exit(0);
    }
   }
  }
 }

 private String execute(String batname){
  Process process; 
  String line = null; 
  StringBuffer sb=new StringBuffer();
        try { 
            process = Runtime.getRuntime().exec(batname); 
            InputStream fis = process.getInputStream(); 
            BufferedReader br = new BufferedReader(new InputStreamReader(fis)); 
            while ((line = br.readLine()) != null) { 
             System.out.println(line);
            } 
            if(process.waitFor()!=0){
             System.out.println("fail");
             return "fail";
            }
            System.out.println(batname+" run successful!");
            return "success";
        } catch (Exception e) { 
            e.printStackTrace(); 
            return "fail";
        }
 }
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  batxinjian2 df=new batxinjian2();
  df.creatBat("del  D:\\text.txt");
  df.execute("D:\\del.bat");
 }

}
