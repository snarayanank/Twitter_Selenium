package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	@FindBy(xpath = "//a[@href='/login']")
	WebElement loginBtn;
	public void clickOn_LoginBtn() {
		loginBtn.click();
	}
	public WebElement get_LoginBtn() {
		return loginBtn;
	}
	
	@FindBy(xpath = "//a[@href='/i/flow/signup']")
	WebElement signupBtn;
	
	
	@FindBy(xpath = "//span[contains(text(),'Phone, email, or username')]")
	WebElement loginFieldMessage;
	public WebElement getLoginMessage() {
		return loginFieldMessage;
	}
	
	public void loginTwitter(String uName, String pwd) {
		loginBtn.click();
		if (userName.isEnabled()) {
		userName.sendKeys(Keys.CONTROL + "a");
		userName.sendKeys(Keys.DELETE);
		userName.sendKeys(uName);
		}
		if (passwd.isEnabled()) {
		passwd.clear();
		passwd.sendKeys(pwd);
		}
		loginBtn2.click();
	}
	
	@FindBy(xpath = "//input[@name='session[username_or_email]']")
	//@FindBy(xpath = "//div[@class='css-901oao r-1awozwy r-k200y r-hkyrab r-6koalj r-1qd0xha r-1b6yd1w r-16dba41 r-ad9z0x r-bcqeeo r-13qz1uu r-qvutc0']//input[@name='session[username_or_email]']")
	WebElement userName;
	
	@FindBy(css= "input[name='session[password]']")
	WebElement passwd;

	@FindBy(css= "div[data-testid='LoginForm_Login_Button']")
	WebElement loginBtn2;
	public void clickOn_LoginBtn2() {
		loginBtn2.click();
	}
	
	@FindBy(xpath="//span[contains(text(),'Forgot password?')]")
	WebElement forgotPwdLink;
	public WebElement get_forgotPwdLink() {
		return forgotPwdLink;
	}
	
	@FindBy(xpath="//span[contains(text(),'The username and password you entered did not')]")
	WebElement errorMessage;
	public String getErrorMessage() {
		return errorMessage.getText();
	}
}
