package com.tweet.Twitter;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.HomePage;
import PageObjects.LoginPage;

public class LikeTweet extends Base{
	private SoftAssert softAssert = new SoftAssert();
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		Reporter.log("===>Opened Twitter.com<====",true );
	}
	
	@Test
	public void likeTweet() throws IOException
	{
		Reporter.log("===>The Page loaded<===", true);
		LoginPage loginPage = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(loginPage.get_LoginBtn()));
		wait.until(ExpectedConditions.titleContains("Twitter"));
		loginPage.loginTwitter("snarayanank", "Sathya99");
		HomePage homePage = new HomePage(driver);
		wait.until(ExpectedConditions.visibilityOf(homePage.getTweetBox()));
		homePage.searchUser("@snarayanank");
		homePage.getPeople().click();
		driver.findElement(By.partialLinkText("Sathiya")).click();
		softAssert.assertEquals(driver.getTitle(), "Sathiya Narayanan K (@snarayanank) / Twitter");
		homePage.clickLikeButton();
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
}
