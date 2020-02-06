package com.tweet.Twitter;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;

public class CreateTweet extends Base {
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		Reporter.log("===>Opened Twitter.com<====",true );
	}
	
	@Test
	public void createTweet() throws IOException
	{
		LoginPage loginPage = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(loginPage.get_LoginBtn()));
		wait.until(ExpectedConditions.titleContains("Twitter"));
		loginPage.loginTwitter("validuser", "validpwd");
		HomePage homePage = new HomePage(driver);
		wait.until(ExpectedConditions.visibilityOf(homePage.getTweetBox()));
		homePage.getTweetBox().click();
		homePage.getTweetBox().sendKeys("Hello World");
		homePage.getTweetButton().click();
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}

}
