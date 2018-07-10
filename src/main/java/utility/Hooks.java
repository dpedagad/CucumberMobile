package utility;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Hooks {
	
	private static IOSDriver<IOSElement> driver = null;
	
	private static AppiumDriverLocalService service;
	
	@Parameters({"wda", "pfv", "iDevice", "UDID", "port"})
	@Before("@appium")
	public void setUP(String wda, String pfv, String iDevice, String UDID, String port) {
		DesiredCapabilities caps = new DesiredCapabilities();
		 service = new AppiumServiceBuilder().usingPort(Integer.valueOf(port)).build();
		service.start();
		
		if (service==null || !service.isRunning()) {
			throw new AppiumServerHasNotBeenStartedLocallyException("An Appium server node is not started");
		}
		
		//String url = "http://127.0.0.1:4723/wd/hub";
		
		caps.setCapability("platformName", "iOS");
		caps.setCapability("deviceName", iDevice);
		caps.setCapability("platformVersion", pfv);
		caps.setCapability("browserName", "");
		caps.setCapability("deviceOrientation", "PORTRAIT");		    
		caps.setCapability("bundleId", "com.abercrombie.anfiphone");
		caps.setCapability("automationName", "XCUITest");
		caps.setCapability("clearSystemFiles", true);
		caps.setCapability("newCommandTimeout", "120");
		caps.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, wda);
	   // capabilities.setCapability("app", "/Users/pmasur/Downloads/Abercrombie-2.ipa");
		caps.setCapability("udid", UDID);
		caps.setCapability("keychainPath", "/Users/pmasur/Library/Keychains/iOSkeychain.keychain-db");
		caps.setCapability("keychainPassword", "Anf1Hco2");
		 
			  driver = new IOSDriver<IOSElement>(service.getUrl(), caps);
			   
			
	}
	
	@AfterTest(alwaysRun = true)
	public void tearDown() {
	if (driver != null) {
        driver.quit();
        }
	if (service!=null) {
		service.stop();
	}
	}
	
	public static IOSDriver getDriver()
	{
		return driver;
	}

}
