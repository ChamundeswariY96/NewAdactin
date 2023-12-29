package com.mavenproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadAllData {
	
		
	private static void readAllData() throws IOException {
		
	File f = new File("C:\\Users\\HP\\Desktop\\UserData.xlsx");
	FileInputStream fis = new FileInputStream(f);
	Workbook wb = new XSSFWorkbook(fis);
	Sheet sheet = wb.getSheet("Data");
	int NumberOfRows = sheet.getPhysicalNumberOfRows();
	System.out.println(NumberOfRows);
	for (int i = 0; i <NumberOfRows; i++) {
		Row row = sheet.getRow(i);
		int NumberOfCells = row.getPhysicalNumberOfCells();
		//System.out.println(NumberOfCells);
		for (int j = 0; j <NumberOfCells; j++) {
			Cell cell = row.getCell(j);
			CellType cellType = cell.getCellType();
			if(cellType.equals(CellType.STRING)) {
				String stringCellValue = cell.getStringCellValue();
				System.out.println(stringCellValue);
				
			}
			else if(cellType.equals(CellType.NUMERIC)) {
				double numericCellValue = cell.getNumericCellValue();
				int d = (int) numericCellValue;
				System.out.println(d);
				
			}
			
		}
		
	}
	wb.close();
	
	}
	public static void main(String[] args) throws IOException {
		readAllData();
	}
}
