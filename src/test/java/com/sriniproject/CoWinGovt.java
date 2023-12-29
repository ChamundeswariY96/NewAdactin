package com.sriniproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CoWinGovt {
	public static WebDriver driver;
	public static String Url="https://www.cowin.gov.in/";
	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		//options.addArguments("incognito");
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
	}
	public static void launchUrl() {
		driver.get(Url);
	}
	public static void moveToElement() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,2000);");
		WebElement PlaceHolder = driver.findElement(By.xpath("(//h1[@class='text-center accessibility-plugin-ac'])[2]"));
		js.executeScript("arguments[0].scrollIntoView();", PlaceHolder);
		//js.executeScript("window.scrollBy(0,-200);");

	}
	public static void clickToElement() throws InterruptedException {
		driver.findElement(By.xpath("//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c69-352 ng-star-inserted']")).click();
	}
	public static void main(String[] args) throws InterruptedException {
		browserLaunch();
		launchUrl();
		moveToElement();
		clickToElement();
		
	}

}
