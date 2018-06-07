package xzy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import md.User;
import md.readLine;

public class ExceladdTest {
	public static void main(String []args) {
		String path="C:\\Users\\lenovo\\Desktop\\5.xls";
		String s[]= {"1","2","3"};
		 werteexcel(s,path);
	}
	
	
	static void werteexcel(String num[],String s){

        //第一步，创建一个workbook对应一个excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //第二部，在workbook中创建一个sheet对应excel中的sheet     			//sheet是张
        HSSFSheet sheet = workbook.createSheet("用户表一");
        //第三部，在sheet表中添加表头第0行，老版本的poi对sheet的行列有限制
        HSSFRow row = sheet.createRow(9);      //rwo是行
        //第四步，创建单元格，设置表头
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("企业注册号");
        cell = row.createCell(1);
        cell.setCellValue("企业名称");

        //第五步，写入实体数据，实际应用中这些数据从数据库得到,对象封装数据，集合包对象。对象的属性值对应表的每行的值
        for (int i = 0; i <1; i++) {
            HSSFRow row1 = sheet.createRow(i);			//内容空几行：（i+1）就是从第二行开始
   
            //创建单元格设值
            row1.createCell(0).setCellValue(num[0]);
            row1.createCell(1).setCellValue(num[1]);
        }
        for (int i = 1; i <2; i++) {
            HSSFRow row1 = sheet.createRow(i);			//内容空几行：（i+1）就是从第二行开始
   
            //创建单元格设值
            row1.createCell(0).setCellValue(num[0]);
            row1.createCell(1).setCellValue(num[1]);
        }
        for (int i = 2; i <3; i++) {
            HSSFRow row1 = sheet.createRow(i);			//内容空几行：（i+1）就是从第二行开始
   
            //创建单元格设值
            row1.createCell(0).setCellValue(num[0]);
            row1.createCell(1).setCellValue(num[1]);
        }
        for (int i = 14; i <15; i++) {
            HSSFRow row1 = sheet.createRow(i);			//内容空几行：（i+1）就是从第二行开始
   
            //创建单元格设值
            row1.createCell(0).setCellValue(num[0]);
            row1.createCell(1).setCellValue(num[1]);
        }

        //将文件保存到指定的位置
        try {
            FileOutputStream fos = new FileOutputStream(s);
            workbook.write(fos);
            System.out.println("写入成功");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
