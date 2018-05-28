package xm;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import md.User;
import md.readLine;

public class write {
	
	
	void werteexcel(String num[],String s){
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
            FileOutputStream fos = new FileOutputStream(s);
            workbook.write(fos);
            System.out.println("写入成功");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
