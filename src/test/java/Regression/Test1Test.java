package Regression;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testBase.TestBase;
//@Listeners({listeners.TestAllureListener.class})
public class Test1Test extends TestBase{

	@Test
	public void OpenBrowser() 
	{
		String browser1= System.getProperty("browser1","chrome");
		if(browser1.contains("chrome")) 
		{

			getBrowser(browser1);
			
		}
		System.out.println("Launch Browser");
	}
	
	@Test(dependsOnMethods="OpenBrowser")
	public void SecondMethod() 
	{
		String browser1= System.getProperty("browser1","chrome");
		if(browser1.contains("chrome")) 
		{

			getBrowser(browser1);
			
		}
		System.out.println("Launch Browser2");	}
	
	@Test(groups= {"not_required"})
	public void ThirdMethod() 
	{
		String browser1= System.getProperty("browser1","chrome");
		if(browser1.contains("chrome")) 
		{

			getBrowser(browser1);
			
		}
		System.out.println("Launch Browser3");
	}
	
	@Test(dependsOnMethods="OpenBrowser")
	public void FourthMethod() 
	{
		System.out.println("Initialize the workflow");
	}
	
}
