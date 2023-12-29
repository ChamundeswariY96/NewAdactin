package com.sriniproject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Adactin {
	static WebDriver driver;
	static String url="https://adactinhotelapp.com/";

	public static void browserLaunch() {
		//System.setProperty("webdriver.chrome.driver", "D:\\Trends\\Mini_Project\\ChromeDriver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		List<String>opt = new ArrayList<String>();
		opt.add("start-maximized");
		opt.add("incognito");
		options.addArguments(opt);
		//options.addArguments("start-maximized");
		//options.addArguments("incognito");
		driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static void launchUrl() {
		driver.get(url);
	}

	public static void logIn() {
		WebElement uname = driver.findElement(By.xpath("//input[@type='text']"));
		uname.sendKeys("Chamundeswari");
		WebElement pword = driver.findElement(By.xpath("//input[@name='password']"));
		pword.sendKeys("Chamu@793");
		WebElement login = driver.findElement(By.xpath("//input[contains(@id,'login')]"));
		login.click();

	}
	public static void selectLocation() throws InterruptedException {
		WebElement location = driver.findElement(By.xpath("(//select[contains(@class,search_combobox)])[1]"));
		Select s = new Select(location);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);			//single drop down bcoz it returns false 
		Thread.sleep(4000);
		s.selectByIndex(3);
	}
	public static void selectHotels() throws InterruptedException {
		WebElement hotels = driver.findElement(By.xpath("//select[@id='hotels']"));
		Select s1 = new Select(hotels);
		Thread.sleep(4000);
		s1.selectByValue("Hotel Sunshine");
	}
	public static void selectRoomType() throws InterruptedException {
		WebElement Room_Type = driver.findElement(By.xpath("(//select[@class='search_combobox'])[3]"));
		Select s2= new Select(Room_Type);
		Thread.sleep(3000);
		s2.selectByVisibleText("Deluxe");
	}
	public static void selectNumberOfRooms() throws InterruptedException {
		WebElement NumberOfRooms = driver.findElement(By.xpath("(//select[contains(@class,'search_combobox')])[4]"));
		Select s3 = new Select(NumberOfRooms);
		Thread.sleep(4000);
		s3.selectByIndex(3);
	}
	public static  void selectAdultsPerRoom() throws InterruptedException {
		WebElement Adult_Room = driver.findElement(By.xpath("//select[@name='adult_room']"));
		Select s4 = new Select(Adult_Room);
		Thread.sleep(4000);
		s4.selectByIndex(3);
	}
	public static void selectChildrenPerRoom() throws InterruptedException {
		WebElement Children_Room = driver.findElement(By.xpath("(//select[@class='search_combobox'])[6]"));
		Select s5 = new Select(Children_Room);
		Thread.sleep(4000);
		s5.selectByValue("3");
	}
	public static void clickSubmitButton() {
		WebElement Submit = driver.findElement(By.xpath("//input[contains(@type,'submit')]"));
		Submit.click();

	}
	public static  void clickRadioButton() {
		driver.findElement(By.xpath("//input[@type='radio']")).click();
		driver.findElement(By.xpath("//input[contains(@value,'Continue')]")).click();
		
	}
	public static void bookAHotel() throws Throwable {
		Thread.sleep(4000);
		WebElement fname = driver.findElement(By.xpath("(//input[contains(@class,'reg_input')])[1]"));
		fname.sendKeys("Chamundeswari");
		
		Thread.sleep(4000);
		WebElement lname = driver.findElement(By.xpath("(//input[contains(@class,'reg_input')])[2]"));
		lname.sendKeys("Yanamala");
		
		Thread.sleep(4000);
		WebElement Address = driver.findElement(By.xpath("//textarea[@name='address']"));
		Address.sendKeys("Chennai");
		
		Thread.sleep(4000);
		WebElement CC_Num = driver.findElement(By.xpath("//input[contains(@id,'cc_num')]"));
		CC_Num.sendKeys("1234567894567891");
		
		WebElement CC_Type = driver.findElement(By.xpath("(//select[contains(@class,'select_combobox')])[1]"));
		Select s6 = new Select(CC_Type);
		Thread.sleep(4000);
		s6.selectByValue("MAST");
		
		WebElement Select_Month = driver.findElement(By.xpath("(//select[contains(@class,'select_combobox2')])[1]"));
		Select s7 = new Select(Select_Month);
		Thread.sleep(4000);
		s7.selectByVisibleText("November");
		
		WebElement Select_Year = driver.findElement(By.xpath("//select[@name='cc_exp_year']"));
		Select s8 = new Select(Select_Year);
		Thread.sleep(4000);
		s8.selectByIndex(13);
		
		WebElement CVV = driver.findElement(By.xpath("(//input[contains(@type,'text')])[14]"));
		CVV.sendKeys("345");
		
		driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
	}
	public static void myIternary() {
		driver.findElement(By.xpath("//input[contains(@name,'my_itinerary')]")).click();
	}
	public static void logOut() {
		driver.findElement(By.xpath("//input[@value='Logout']")).click();
	}
	public static void screenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		File dstfile = new File("D:\\Trends\\Adactin\\target\\ScreenShot\\Incognito.png");
		//FileHandler.copy(srcfile, dstfile);
		FileUtils.copyFile(srcfile, dstfile);
	}
	
	
	public static void main(String[] args) throws Throwable {
		browserLaunch();
		launchUrl();
		logIn();
		selectLocation();
		selectHotels();
		selectRoomType();
		selectNumberOfRooms();
		selectAdultsPerRoom();
		selectChildrenPerRoom();
		clickSubmitButton();
		clickRadioButton();
		bookAHotel();
		//screenShot();
		myIternary();
		logOut();
		screenShot();
		
	}

}
