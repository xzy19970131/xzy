package xm;

import java.io.File;
 
 public class fileName {
  

     public static void main(String[] args) 
     {     //这是遍历文件夹下所有文件名的代码
         getFileName();
     }

     public static void getFileName() 
     {
    	 String path = "C:\\Users\\lenovo\\Desktop\\myimg"; // 路径
        File f = new File(path);
         if (!f.exists()) //判断目录是否存在
         {
            System.out.println(path + " not exists");
            return;
         }
         File fa[] = f.listFiles();
         for (int i = 0; i < fa.length; i++)  			//遍历输出目录名
         {
            File fs = fa[i];
            if (fs.isDirectory()) 
            {
               System.out.println(fs.getName() + " [目录]");			//判断是文件夹目录，还是文件
            } 
            else 
           {
                System.out.println(fs.getName());				//输出文件名
                System.out.println(fs.getAbsolutePath());			//输出完整的绝对路径
           }
        }
     }
}