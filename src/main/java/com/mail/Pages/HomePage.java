package com.mail.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mail.base.TestBase;

public class HomePage extends TestBase
{

	@FindBy(xpath="//button[contains(@aria-label,'Expand to see more New options')]")
	WebElement maildropdown;
	
	
	@FindBy(xpath="//button[contains(@name,'Mail')]//div")
	WebElement newmail;
	
	@FindBy(xpath="//input[contains(@aria-label,'Add a subject')]")
	WebElement subject;
	
	@FindBy(xpath="//span[contains(text,'Send')]")
	WebElement sendbutton;
	
	public HomePage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendemail(String emailid) throws InterruptedException
	{
		Thread.sleep(1000);
		maildropdown.click();
		Thread.sleep(1000);
		newmail.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@role,'combobox')]")).sendKeys(emailid);
		subject.sendKeys("test email");
		sendbutton.click();
	}
	
	
}
