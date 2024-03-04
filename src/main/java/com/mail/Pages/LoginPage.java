package com.mail.Pages;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.mail.util.TestUtil;
import com.mail.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name="loginfmt")
	WebElement loginid;
	
	@FindBy(id="idSIButton9")
	WebElement loginbutton;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(xpath="//input[@id='idSIButton9']")
	WebElement passwordbutton;
	
	@FindBy(xpath="//input[@id='idSIButton9']")
	WebElement yesbutton;
		
	
	
	public LoginPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String login, String pwd) throws InterruptedException, IOException
	{
		Thread.sleep(1000);
		loginid.sendKeys(login);
		loginbutton.click();
		Thread.sleep(5000);
		password.sendKeys(pwd);
		Thread.sleep(1000);
		passwordbutton.click();
		
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver,1000);
		
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='idSIButton9']")));
			yesbutton.click();
		}
		catch(StaleElementReferenceException st)
		{
			yesbutton.click();
		}
		catch(WebDriverException e)
		{
			e.printStackTrace();
		}
		
		return new HomePage();
		
	}
	
	
	
}
