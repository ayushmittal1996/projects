package calc;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoApp {
	WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException{
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability("BROWSER_NAME", "Android");
//		capabilities.setCapability("VERSION", "4.4.2"); 
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","11");
		capabilities.setCapability("app","D:\\eclipse\\calc\\res\\ApiDemos-debug.apk");
		capabilities.setCapability("deviceName","Android SDK built for x86");
		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity",".view.TextFields"); // This is Launcher activity of your app (you can get it from apk info app)
	//Create RemoteWebDriver instance and connect to the Appium server
	 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
	   driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
	}

	@Test
	public void testCal() throws Exception {
	   //locate the Text on the calculator by using By.name()
	   WebElement textBox = driver.findElement(By.id("io.appium.android.apis:id/edit"));
	   textBox.sendKeys("Hello by Ayush");
		//Check the calculated value on the edit box
	assert textBox.getText().equals("Hello by Ayush"):"Actual value is : "+textBox.getText()+" did not match with expected value: 'Hello by Ayush'";

	}

	@AfterClass
	public void teardown(){
		//close the app
		driver.quit();
	}

}
