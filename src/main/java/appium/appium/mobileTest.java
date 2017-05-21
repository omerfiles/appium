package appium.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.Connection;

public class mobileTest {

	MobileWebDriver driver;

	@Before
	public void setup() throws Exception {
		driver = new MobileWebDriver();
		driver.init("ContactManager.apk", "Nexus5", "127.0.0.1:4723");
	}

	@Test
	public void test1() throws Exception {

		//driver.setConnection(Connection.WIFI);

		// driver.setLocation(34.55, 27.44, 300);

//		driver.startApp("com.android.calculator2.Calculator", "com.android.calculator2");

		driver.findElementByText("Add Contact").click();

		driver.findElementById("com.example.android.contactmanager:id/contactNameEditText").sendKeys("aaaa");

		driver.takeScreenshot();

	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
