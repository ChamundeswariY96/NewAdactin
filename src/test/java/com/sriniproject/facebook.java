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

public class facebook {
	public static WebDriver driver;
	public static String Url="https://www.facebook.com/";
			public static void browserLaunch() {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				List<String>opt=new ArrayList<String>();
				opt.add("start-maximized");
				opt.add("incognito");
				options.addArguments("options");
				//options.addArguments("start-maximized");
				//options.addArguments("incognito");
				driver= new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}
			public static void launchUrl() {
				driver.get(Url);
			}
			public static void logIn() {
				driver.findElement(By.xpath("//input[@id='email']")).sendKeys("chamu@123");
				driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("chamu");
				driver.findElement(By.xpath("//button[@name='login']")).click();
			}
			public static  void screenShot() throws InterruptedException, IOException {
				Thread.sleep(2000);
				TakesScreenshot ts = (TakesScreenshot) driver;
				File srcfile = ts.getScreenshotAs(OutputType.FILE);
				File dstfile = new File("D:\\Trends\\Adactin\\target\\ScreenShot\\error.png");
				FileUtils.copyFile(srcfile, dstfile);   

			}
			public static void navigationPage() {
				driver.navigate().back();
				driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

			}
			public static void userRegistration() {
				String SignUp = driver.findElement(By.xpath("//div[text()='Sign Up']")).getText();
				String SignUp2 = driver.findElement(By.xpath("(//button[@type='submit'])[2]")).getText();
				if(SignUp.equalsIgnoreCase(SignUp2)) {
					driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Suresh");
					driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("vaka");
					driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("9885343522");
					driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys("Suresh@Vaka");
					WebElement Day = driver.findElement(By.xpath("//select[@id='day']"));
					Select s = new Select(Day);
					s.selectByIndex(6);
					WebElement Month = driver.findElement(By.xpath("//select[@id='month']"));
					Select s1 = new Select(Month);
					s1.selectByValue("4");
					WebElement Year = driver.findElement(By.xpath("//select[@id='year']"));
					Select s2 = new Select(Year);
					s2.selectByVisibleText("1989");
					driver.findElement(By.xpath("//label[text()='Female']"));
					driver.findElement(By.xpath("//label[text()='Male']")).click();
					driver.findElement(By.xpath("//label[text()='Custom']"));
				}
			}
			public static  void screenShotUserRegistration() throws InterruptedException, IOException {
				Thread.sleep(2000);
				TakesScreenshot ts1 = (TakesScreenshot) driver;
				File srcfile1 = ts1.getScreenshotAs(OutputType.FILE);
				File dstfile1 = new File("D:\\Trends\\Adactin\\target\\ScreenShot\\registrationPage.png");
				FileUtils.copyFile(srcfile1, dstfile1);   
			}
			public static  void clickOnSubmit() {
				driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
			}
			public static  void close() {
				driver.close();
			}
			public static void main(String[] args) throws InterruptedException, Throwable {
				browserLaunch();
				launchUrl();
				logIn();
				screenShot();
				navigationPage();
				userRegistration();
				screenShotUserRegistration();
				clickOnSubmit();
				close();
			}

}
