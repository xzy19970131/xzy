package xm;

import java.io.*;
import java.util.*;

public class javabat {   
    public void runbat(int timeFortmat) {
        String cmd = "cmd /c start C:\\Users\\lenovo\\Desktop\\33.bat";

        try {
            Process ps = Runtime.getRuntime().exec(cmd);
            System.out.println(ps.getInputStream());
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }          
    
    public static void main(String[] args){
           javabat  test1 = new javabat ();           
           test1.runbat(1340);
    }
}     
