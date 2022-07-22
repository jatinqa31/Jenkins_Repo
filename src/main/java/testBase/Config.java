/**
 * 
 */
package testBase;

import java.util.Properties;

/**
 * @author Rajesh.Kumar4
 *
 */
public class Config extends TestBase{
	
	private Properties OR;
	
	public Config(Properties OR){
		this.OR = OR;
	}
	public String getDesination_location() {
		return OR.getProperty("Desination_location");
	}
	public String getHotel_Name() {
		return OR.getProperty("Hotel_Name");
	}

	public String getCheckin() {
		return OR.getProperty("Checkin");
	}
	
	public String getCheckout() {
		return OR.getProperty("Checkout");
	}
	
	public String getAdult() {
		return OR.getProperty("Adult");
	}

	public String getWebsite() {
		return OR.getProperty("Website");
	}

	public int getPageLoadTimeOut() {
		return Integer.parseInt(OR.getProperty("PageLoadTimeOut"));
	}

	public int getImplicitWait() {
		return Integer.parseInt(OR.getProperty("ImplcitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(OR.getProperty("ExplicitWait"));
	}

	/*public String getDbType() {
		return OR.getProperty("DataBase.Type");
	}

	public String getDbConnStr() {
		return OR.getProperty("DtaBase.ConnectionStr");
	}*/
	
	public String getBrowser() {
		return OR.getProperty("Browser");
	}
	public String getusername() {
		return OR.getProperty("username");
	}

	public String getpassword() {
		return OR.getProperty("password");
	}
	public String reportConfigPath() {
		return OR.getProperty("reportConfigPath");
	}
}