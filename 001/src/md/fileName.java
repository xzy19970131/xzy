package md;

import java.io.File;
 
 public class fileName {
  

     public static void main(String[] args) {     //这是遍历文件夹下所有文件名的代码(原始代码)
         getFileName();
     }

     public static void getFileName() {
    	 String path = "C:\\Users\\lenovo\\Desktop\\chaye"; // 路径
        File f = new File(path);
         if (!f.exists()) {
            System.out.println(path + " not exists");
            return;
         }
 
         File fa[] = f.listFiles();
         for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            if (fs.isDirectory()) {
               System.out.println(fs.getName() + " [目录]");
             } else {
                System.out.println(fs.getName());
           }
        }
     }
     }