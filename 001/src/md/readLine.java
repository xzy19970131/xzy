package md;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class readLine {
    public static void main(String[] args) {
    File file = new File("f:\\22.txt");
    BufferedReader reader = null;
    String tempString = null;
    int line =1;
    try {
      //  System.out.println("以行为单位读取文件内容，一次读一整行：");
        reader = new BufferedReader(new FileReader(file));
        while ((tempString = reader.readLine()) != null) {
        	if(!tempString.equals("")) {
            System.out.println(tempString);
            line ++ ;}
        }
        reader.close();
    } catch (Exception e) {
        e.printStackTrace();
    } finally{
        if(reader != null){
            try {
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    }
}
