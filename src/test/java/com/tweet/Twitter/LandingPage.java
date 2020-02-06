package com.tweet.Twitter;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.HomePage;
import PageObjects.LoginPage;

public class LandingPage extends Base{
	
	private SoftAssert softAssert = new SoftAssert();
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		Reporter.log("===>Opened Twitter.com<====",true );
	}
	
	@Test(dataProvider="getCredentials")
	public void loginTwitter(String uName, String pwd, String expCase) throws IOException {
		Reporter.log("===>The Page loaded<===", true);
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(loginPage.get_LoginBtn()));
		wait.until(ExpectedConditions.titleContains("Twitter"));
		softAssert.assertEquals(driver.getTitle(),"Twitter. It's what's happening / Twitter");
		loginPage.loginTwitter(uName, pwd);
		Reporter.log("===>Testing " + expCase + " login case<====",true );
		if (expCase=="Invalid") {
			assertTrue(loginPage.getErrorMessage().contains("The username and password"));
			Reporter.log("===>Verified " + expCase + " login case<====",true );
		}
		else
		{
			assertTrue(homePage.getHomePageLink().isDisplayed());
			Reporter.log("===>Verified " + expCase + " login case<====",true );
		}
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getCredentials()
	{
		Object[][] credentials = new Object[2][3];
		//1st Credential - Invalid
		credentials[0][0]="TestUser";
		credentials[0][1]="TestPwd";
		credentials[0][2]="Invalid";
		//2nd Credential - Valid
		credentials[1][0]=prop.getProperty("validUser");
		credentials[1][1]=prop.getProperty("validPwd");
		credentials[1][2]="Valid";
		
		return credentials;
	}

}
