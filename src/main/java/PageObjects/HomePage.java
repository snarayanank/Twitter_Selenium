package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	@FindBy(xpath = "//span[contains(text(),'Home')]")
	WebElement homePageLink;
	public WebElement getHomePageLink() {
		return homePageLink;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Explore')]")
	WebElement exploreLink;
	
	@FindBy(xpath = "//span[contains(text(),'Notifications')]")
	WebElement notificationLink;
	
	@FindBy(xpath = "//input[@placeholder='Search Twitter']")
	WebElement searchField;
	public void searchUser(String user) {
		searchField.click();
		searchField.sendKeys(user);
		searchField.sendKeys(Keys.ENTER);
	}
	
	@FindBy(xpath = "//div[@data-testid='tweetButtonInline']")
	WebElement tweetButton;
	public WebElement getTweetButton() {
		return tweetButton;
	}
	
	@FindBy(xpath = "//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")
	WebElement tweetText;
	
	@FindBy(xpath = "//span[contains(text(),'Home')]")
	WebElement likeTweet;
	
	@FindBy(linkText="People")
	WebElement peopleTab;
	public WebElement getPeople() {
		return peopleTab;
	}

	@FindBy(xpath = "//div[@data-testid='like']")
	WebElement likeButton;
	public void clickLikeButton() {
		likeButton.click();
	}
	
	@FindBy(xpath = "//div[@data-testid='reply']")
	WebElement replyButton;
	public void clickReplyButton() {
		replyButton.click();
	}
	
	@FindBy(xpath = "//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")
	WebElement replyTxtBox;
	public WebElement getReplyTextBox() {
		return replyTxtBox;
	}
	
	@FindBy(xpath = "//div[@data-testid='tweetButton']")
	WebElement replyTweetButton;
	public WebElement getReplyTweetButton() {
		return replyTweetButton;
	}
	
	@FindBy(xpath = "//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")
	WebElement tweetBox;
	public WebElement getTweetBox() {
		return tweetBox;
	}
	
	@FindBy(xpath = "//h2[@class='css-4rbku5 css-901oao css-bfa6kz r-hkyrab r-1qd0xha r-1b6yd1w r-1vr29t4 r-ad9z0x r-bcqeeo r-qvutc0']//span[@class='css-901oao css-16my406 r-1qd0xha r-ad9z0x r-bcqeeo r-qvutc0'][contains(text(),'Home')]")
	WebElement homeText;
	public String getHomeText() {
		return homeText.getText();
	}
	
	@FindBy(xpath = "//div[@data-testid='caret']")
	WebElement tweetOption;
	public void tweetOptionClick() {
		tweetOption.click();
	}
	
	@FindBy(xpath="//span[contains(text(),'Delete')]")
	WebElement deleteTweetBtn;
	public void deleteTweet() {
		deleteTweetBtn.click();
	}
	
	@FindBy(xpath="//div[@data-testid='confirmationSheetConfirm']")
	WebElement deleteConfirmBtn;
	public void confirmDelete() {
		deleteConfirmBtn.click();
	}
}
