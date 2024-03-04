package com.mail.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mail.base.TestBase;
import com.mail.util.TestUtil;
import com.mail.Pages.HomePage;
import com.mail.Pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	String sheetname = "Sheet1";
	public LoginPageTest() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialization();
		loginpage = new LoginPage();
	//	homepage = new HomePage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil = new TestUtil();
		
	}

	@DataProvider
	public  Object[][] getTestData() throws InvalidFormatException, IOException
	{
		 Object[][] data = testutil.getTestData(sheetname);
		return data;
	}
	
	@Test(dataProvider = "getTestData")
	public void LoginTest(String email) throws IOException, InterruptedException
	{
		
		homepage.sendemail(email);
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
