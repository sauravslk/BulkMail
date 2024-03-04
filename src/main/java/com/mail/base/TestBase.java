package com.mail.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase
{
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException
	{
		FileInputStream fis = new FileInputStream("D:\\eclipse-workspace\\BulkMailProject\\src\\main\\java\\com\\mail\\config\\config.properties");
		prop = new Properties();
		prop.load(fis);
	
	}
	
	public void initialization()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	

}
