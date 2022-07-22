package Smoke;

import static org.testng.Assert.assertEquals;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import listeners.TestAllureListener;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import testBase.TestBase;

@Listeners({listeners.TestAllureListener.class})
public class Test1Test extends TestBase{
	
	@Test(priority=1,description="1st test")
	@Severity(SeverityLevel.NORMAL)
	@Description("1st test")
	
	public void Login() 
	{
		String browser1= System.getProperty("browser1","chrome");
		if(browser1.contains("chrome")) 
		{
			//getBrowser(browser1);
		}
		System.out.println("Firefox Launched");
	}
	
	@Test(dependsOnMethods="Login")
	public void SecondMethod() 
	{
		System.out.println("Initialize the workflow");
		assertEquals(false, true);
	}
	
	@Test
	public void ThirdMethod() 
	{
		System.out.println("Initialize the workflow");
	}
	
	@Test(dependsOnMethods="Login")
	public void FourthMethod() 
	{
		System.out.println("Initialize the workflow");
	}
	
}
