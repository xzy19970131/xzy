package xm;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class JavaC {
    public static void main(String[] args) {
        try {
           
            Process cProcess = Runtime.getRuntime().exec("C:\\Users\\lenovo\\Desktop/JavaC.exe");
            InputStream in = cProcess.getInputStream();
            String line = null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "GBK"));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
             }
            System.out.println("1111111");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
