package testBase;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;//by jatin on 13-may
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties OR;
	public File f1;
	public FileInputStream file;
	public ITestResult result;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	public static SoftAssert sa;
	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		sa = new SoftAssert();
		//extent = new ExtentReports(System.getProperty("user.dir") + "/src/main/java/reports/test"
		//		+ formater.format(calendar.getTime()) + ".html", false);
	}
	public void sendEmail() throws EmailException {
try {
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("jatinqa61@gmail.com", "Jatin@123"));
		email.setSSLOnConnect(true);
		email.setFrom("jatinqa61@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("jatinqa61@gmail.com");
		email.send();
}
catch(Exception e) {
	System.out.println(e.getCause());
	//e.printStackTrace();
}
}
	
	@AfterMethod()
	public void afterMethod(ITestResult result) throws IOException, EmailException {
		if(result.getStatus()==ITestResult.FAILURE) {
			sendEmail();
			System.out.println("Failed email sent!");
		}
	}
	public void getBrowser(String browser) {
		 if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/drivers/geckodriver.exe");
				//WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get("https://www.google.com");
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase("chrome")) {			
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get("https://www.github.com");
				driver.manage().window().maximize();
				tdriver.set(driver);
			}
		}

	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}

	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}
//	@BeforeTest
//	public void launchBrowser() {
//		try {
//			loadPropertiesFile();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		Config config = new Config(OR);
//		System.out.println("browser "+config.getBrowser());
//		getBrowser(config.getBrowser());
//		
//
//		
//		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
//		driver.get(config.getWebsite());
//		
//	}

	@AfterTest
	public void endTests() 
	{
		//driver.quit();
	}	
}