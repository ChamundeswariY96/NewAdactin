package com.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;
	public static String value=null;
	public static WebDriver browserLaunch(String type) {
		if(type.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Trends\\Adactin\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (type.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Trends\\Adactin\\chromedriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (type.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "D:\\\\Trends\\Adactin\\chromedriver\\edgedriver.exe");
			driver = new EdgeDriver();
		}
		else
		{
			System.setProperty("webdriver.internetexplorer.driver", "D:\\Trends\\Adactin\\chromedriver\\internetexplorerdriver.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;

	}
	public static WebDriver getUrl(String url) {
		driver.get(url);
		return driver;
	}
	public static void dropDown(String type,WebElement element,String value) {
		Select s = new Select(element);
		if (type.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		}else if (type.equalsIgnoreCase("index")) {
			int data = Integer.parseInt(value);
			s.selectByIndex(data);
		}else if (type.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);
		}
	}
	public static String readData(String path,int sheetIndex,int rowIndex,int cellIndex) throws IOException {
		//String value=null;
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(sheetIndex);
		Row row = sheetAt.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		CellType cellType = cell.getCellType();
		if (cellType.equals(CellType.STRING)) {
			value = cell.getStringCellValue();
			//System.out.println(value);
			
		} else if (cellType.equals(CellType.NUMERIC)) {
			double numericCellValue = cell.getNumericCellValue();
			int data = (int) numericCellValue;
			value = String.valueOf(data);
			//System.out.println(value);
			
		}
		wb.close();
		
	return value;
		
	}
	
	public static void inputValueElement(WebElement element,String value) {
		
			element.sendKeys(value);
	}
	public static  void clickOnElement(WebElement element) {
		element.click();

	}
	public static WebDriver close() {
		driver.close();
		return driver;

	}
	public static WebDriver quit() {
		driver.quit();
		return driver;
	}
	
	

}
