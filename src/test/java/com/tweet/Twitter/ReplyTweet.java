package com.tweet.Twitter;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.HomePage;
import PageObjects.LoginPage;

public class ReplyTweet extends Base{
	
	private SoftAssert softAssert = new SoftAssert();

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		Reporter.log("===>Opened Twitter.com<====",true );
	}
	
	@Test
	public void replyTweet() throws IOException
	{
		Reporter.log("===>The Page loaded<===", true);
		LoginPage loginPage = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(loginPage.get_LoginBtn()));
		wait.until(ExpectedConditions.titleContains("Twitter"));
		loginPage.loginTwitter("snarayanank", "Sathya99");
		HomePage homePage = new HomePage(driver);
		wait.until(ExpectedConditions.visibilityOf(homePage.getTweetBox()));
		Reporter.log("===>Logged into Twitter<===", true);
		homePage.searchUser("@snarayanank");
		homePage.getPeople().click();
		driver.findElement(By.partialLinkText("Sathiya")).click();
		softAssert.assertEquals(driver.getTitle(), "Sathiya Narayanan K (@snarayanank) / Twitter");
		Reporter.log("===>Opened the given user's twitter page<===", true);
		homePage.clickReplyButton();
		homePage.getReplyTextBox().click();
		homePage.getReplyTextBox().sendKeys("Test");
		homePage.getReplyTweetButton().click();
		Reporter.log("===>Commented on the tweet<===", true);
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
