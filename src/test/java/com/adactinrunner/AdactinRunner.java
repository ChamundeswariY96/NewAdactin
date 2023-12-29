package com.adactinrunner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.baseclass.BaseClass;

public class AdactinRunner extends BaseClass {
	public static WebDriver driver=BaseClass.browserLaunch("Chrome");   //null
	

	public static void main(String[] args) throws IOException {
	//	driver= browserLaunch("chrome");    //ChromeDriver
		driver= getUrl("https://adactinhotelapp.com/");
		WebElement uname = driver.findElement(By.xpath("//input[@id='username']"));
		String userdata = readData(".\\dataengine\\UserData.xlsx", 0, 1, 0);
		inputValueElement(uname, userdata);
		// uname.sendKeys("Chamundeswari");
		WebElement pword = driver.findElement(By.xpath("//input[@name='password']"));
		String passdata = readData(".\\dataengine\\UserData.xlsx", 0, 1, 1);
		inputValueElement(pword, passdata);
		// pword.sendKeys("Chamu@793");
		WebElement login = driver.findElement(By.xpath("//input[contains(@id,'login')]"));
		clickOnElement(login);
		// login.click();
//		dropDown("value", uname, "James");
//		dropDown("index", pword, "test@456");
//		dropDown("text", login, "login");
		close();
		

	}

	
}
