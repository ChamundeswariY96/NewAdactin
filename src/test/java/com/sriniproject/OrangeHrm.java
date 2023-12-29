package com.sriniproject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrm {
	public static WebDriver driver;
	public static String Url="https://opensource-demo.orangehrmlive.com/";
	
	public static void browserLaunch() {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			List<String>opt = new ArrayList<String>();
			//options.addArguments("Start-maximized");
			//options.addArguments("incognito");
			opt.add("start-maximized");
			opt.add("incognito");
			options.addArguments(opt);
			driver= new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public static void launchUrl() {
          driver.get(Url);
	}
	public static void logIn() {
		String uname = driver.findElement(By.xpath("(//p[@class='oxd-text oxd-text--p'])[1]")).getText();
		String uname1 = driver.findElement(By.xpath("//input[@name='username']")).getText();
		if(uname.contains(uname1)) {
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		}
		
		String pword = driver.findElement(By.xpath("(//p[@class='oxd-text oxd-text--p'])[2]")).getText();
		String pword1 = driver.findElement(By.xpath("//input[@name='password']")).getText();
		if(pword.contains(pword1)) {
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		}
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	public static void myInfo() throws InterruptedException {
		
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;

		 js1.executeScript("window.scrollBy(0,2000);");
		 WebElement MyInfo = driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[6]"));
		 MyInfo.click();
	}
	
	public static void screenShot() throws IOException, InterruptedException {
		Thread.sleep(4000);
		 
		 TakesScreenshot ts = (TakesScreenshot) driver;
		 File srcfile = ts.getScreenshotAs(OutputType.FILE);
		 File dsctfile = new File("D:\\Trends\\Adactin\\target\\ScreenShot\\MyInfo.png");
		 FileHandler.copy(srcfile, dsctfile);
		 
	 }
	public static void clickOnSave() throws InterruptedException {
		Thread.sleep(3000);
		 
		 WebElement save = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		 JavascriptExecutor js2 = (JavascriptExecutor) driver;
		 js2.executeScript("arguments[0].scrollIntoView();",save);
		 
		 save.click();
		 Thread.sleep(2000);
		 
	}
	public static void screenShot1() throws IOException {
		TakesScreenshot ts2 = (TakesScreenshot) driver;
		 File srcfile1 = ts2.getScreenshotAs(OutputType.FILE);
		 File dsctfile1 = new File("D:\\Trends\\Adactin\\target\\ScreenShot\\Savedpage.png");
		 FileHandler.copy(srcfile1, dsctfile1);
	}
	public static void logOut() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		 Thread.sleep(4000);
		 TakesScreenshot ts2 = (TakesScreenshot) driver;
		 File srcfile2 = ts2.getScreenshotAs(OutputType.FILE);
		 File dsctfile2 = new File("D:\\Trends\\Adactin\\target\\ScreenShot\\UserProfile.png");
		 FileHandler.copy(srcfile2, dsctfile2);
		 driver.findElement(By.xpath("//a[text()='Logout']")).click();
		 Thread.sleep(3000);

	}
	public static void close() {
		 driver.close();
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		browserLaunch();
		launchUrl();
		logIn();
		myInfo();
		screenShot();
		clickOnSave();
		screenShot1();
		logOut();
		close();
		
	}

}
