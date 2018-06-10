package xzy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class read {
	String s[];
	public void readLine(String s2){
	    File file = new File(s2);
	    BufferedReader reader = null;
	    String tempString = null;
	    int line =1;
	    try {
	    	s = new String[2];
	    
	    	int i=0;
	      //  System.out.println("以行为单位读取文件内容，一次读一整行：");
	        reader = new BufferedReader(new FileReader(file));
	        while ((tempString = reader.readLine()) != null) {
	        	if(!tempString.equals("")) {
	        		s[i]=tempString;
	           // System.out.println(tempString);
	            i++;
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
	public String[] getS() {
		return s;
	}
	public void setS(String[] s) {
		this.s = s;
	}

}
