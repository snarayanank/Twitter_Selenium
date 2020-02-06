package com.tweet.Twitter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.Reporter;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	public String currDir = System.getProperty("user.dir");
	
	public WebDriver initializeDriver() throws IOException{
		//Read config properties for generic input
		prop = new Properties();
		FileInputStream fIpStr = new FileInputStream(
				currDir + "\\src\\main\\java\\resources\\config.properties");	
		prop.load(fIpStr);
		
		//Get Browser Name
		String browserName = prop.getProperty("browser");
		//Get timeout value for implicit wait
		int pageLoadTimeOut=Integer.parseInt(prop.getProperty("pageLoadTimeOut"));
		int implicitTimeOut=Integer.parseInt(prop.getProperty("implicitTimeOut"));
		
		switch (browserName) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", currDir + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			Reporter.log("===>Chrome Browser started<====",true );
			break;

		case "Firefox":
			System.setProperty("webdriver.gecko.driver", currDir + "\\functionalTest\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			Reporter.log("===>Firefox Browser Started<====",true );
			break;

		case "InternetExplorer":
			InternetExplorerOptions capabilities= new InternetExplorerOptions();
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			System.setProperty("webdriver.ie.driver", currDir + "\\functionalTest\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver(capabilities);
			Reporter.log("===>Internet Explorer Started<====",true );
			break;
		}
		Reporter.log("===>Browser Session Started<====",true );
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicitTimeOut, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(currDir+"//ScreenShots//"+result+"screenshot.png"));
		Reporter.log("===>Screen Shot Taken for failed case " + result + "<====",true );
	}


}
