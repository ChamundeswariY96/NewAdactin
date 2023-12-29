package com.mavenproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {
			
	public static void writeData() throws IOException {

	
	File f = new File("D:\\Trends\\Adactin\\target\\DataEngine\\UserData.xlsx");
	FileInputStream fis = new FileInputStream(f);
	Workbook wb = new XSSFWorkbook(fis);
	Sheet sheet = wb.createSheet("PlacementDetails");
//	Row row = sheet.createRow(0);
//	Cell cell = row.createCell(0);
//	cell.setCellValue("UserName");
//	sheet.createRow(0).createCell(0).setCellValue("UserName");
//	sheet.getRow(0).createCell(1).setCellValue("Password");
//	sheet.createRow(1).createCell(0).setCellValue("James");
//	sheet.getRow(1).createCell(1).setCellValue("james123");
	for (int i = 0; i <=5; i++) {
		sheet.createRow(i);
		for (int j = 0; j <=5; j++) {
			sheet.getRow(i).createCell(j);
			
		}
		
	}
	FileOutputStream fos = new FileOutputStream(f);
	wb.write(fos);
	System.exit(0);
							
	System.out.println("write successfully");
	wb.close();
	}
	
	
public static void main(String[] args) throws IOException {
	writeData();
}

}
