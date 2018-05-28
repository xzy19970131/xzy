package xm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import md.readLine;


public class xm {
	 static String[] s; 
	
	
	//用dos调用识别图片的方法
	public static void photoRecognize(String ptotoPath,String txtPath){
		Runtime rt = Runtime.getRuntime();
		String cmddir = "tesseract"+ " "+ptotoPath+" "+txtPath+" "+ "-l chi_sim";    //完整的dos语句
        System.out.println(cmddir);				//输出dos语句
        try {					
            rt.exec(cmddir);						//运行dos语句
            System.out.println("成功执行！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	//读取txt到控制台的方法
	static String[] readLine(String txtPath){
	    File file = new File(txtPath);
	    BufferedReader reader = null;
	    String tempString = null;
	    int line =1;
	    try {
	    	s= new String[2];
	    
	    	int i=0;
	      //  System.out.println("以行为单位读取文件内容，一次读一整行：");
	        reader = new BufferedReader(new FileReader(file));
	        while ((tempString = reader.readLine()) != null) {
	        	if(!tempString.equals("")) {
	        		s[i]=tempString;
	        //    System.out.println(tempString);
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
		return s;
	}
	
	//把数据写入到Excel        第一个参数是要写入的数据，第二个是生成Excel的路径
	static void writeToExcel(String num[],String excelPath){
	readLine readLine = new readLine();
    	
        //第一步，创建一个workbook对应一个excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //第二部，在workbook中创建一个sheet对应excel中的sheet
        HSSFSheet sheet = workbook.createSheet("用户表一");
        //第三部，在sheet表中添加表头第0行，老版本的poi对sheet的行列有限制
        HSSFRow row = sheet.createRow(0);
        //第四步，创建单元格，设置表头
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("企业注册号");
        cell = row.createCell(1);
        cell.setCellValue("企业名称");

        //第五步，写入实体数据，实际应用中这些数据从数据库得到,对象封装数据，集合包对象。对象的属性值对应表的每行的值
        for (int i = 0; i <1; i++) {
            HSSFRow row1 = sheet.createRow(i + 1);
   
            //创建单元格设值
            row1.createCell(0).setCellValue(num[0]);
            row1.createCell(1).setCellValue(num[1]);
        }

        //将文件保存到指定的位置
        try {
            FileOutputStream fos = new FileOutputStream(excelPath);
            workbook.write(fos);
            System.out.println("写入成功");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	

	public static void main(String[] args) {
		//photoRecognize("f:/4.png","f:/4");
		
		File file = new File("f:/4.txt");
		String s[] =readLine("f:/4.txt");
		writeToExcel(s,"f:/4.xls");
		for(int i=0;i<s.length;i++)
		{
			System.out.println(s[i]);
		}
	/*	while(true) {
			if(file.exists())
			{
				readLine("f:/4.txt");
				break;
			}
		}*/
		
		

	}

}
