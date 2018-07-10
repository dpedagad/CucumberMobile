package stepDefs;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.Assert;
import utility.Hooks;

public class LaunchStepDef {

	private static IOSDriver driver;
	
	public LaunchStepDef() {
		this.driver = Hooks.getDriver();
	}
	
	@Test(priority=1)
	@Given("^user launches the AnF application$")
	public void user_launches_the_AnF_application() throws InterruptedException {
		
		Thread.sleep(5000);
	    driver.findElementByAccessibilityId("PLAYLIST").click();
	    Thread.sleep(2000);
	    System.out.println("App launched");	   
	}
	@Test(priority=2)
	@When("^user is on the explore page tap on the Playlist button$")
	public void user_is_on_the_explore_page_tap_on_the_Playlist_button() throws InterruptedException  {
		Thread.sleep(2000);
	    driver.findElementByAccessibilityId("ic play").click();
	    Thread.sleep(10000);
	    System.out.println("Music played");
	}

//	@Then("^user should be on playlist page and Play button should be displayed$")
//	public void user_should_be_on_plaulist_page_and_Play_button_should_be_displayed()  {
//	    // Write code here that turns the phrase above into concrete actions
//	   
//	}
//
//	@When("^user selects Play button$")
//	public void user_selects_Play_button()  {
//	    // Write code here that turns the phrase above into concrete actions
//	  
//	}
//
//	@Then("^Pause button should be displayed$")
//	public void pause_button_should_be_displayed()  {
//	    // Write code here that turns the phrase above into concrete actions
//	   
//	}

}
