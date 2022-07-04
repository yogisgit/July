package com.july.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public Object[] getData() throws IOException {
		
		ArrayList<String> al = new ArrayList<String>();
		String path = "/Users/yogi/Java/July/src/main/java/com/july/testData/data.xlsx";
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("Sheet1");
		
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(0).getLastCellNum();
		
		for(int r=0;r<=rows;r++)
		{	
			XSSFRow row=sheet.getRow(r);
			
			for(int c=0;c<cols;c++)
			{
				XSSFCell cell=row.getCell(c);
				
				switch(cell.getCellType())
				{
				case STRING: 
					al.add(cell.getStringCellValue()); 
					break;
				default:
					break;
				}
			}
		}
		Object[] obj = new Object[1];
		for(int i=0; i<al.size(); i++) {
			obj[0] = al.get(i);
		}
		return obj;
	}

//	public static void main(String...args) throws IOException {
//		ExcelUtil eu = new ExcelUtil();
//		Object[] data = eu.getData();
//		System.out.println(data[0]);
//	}
}
