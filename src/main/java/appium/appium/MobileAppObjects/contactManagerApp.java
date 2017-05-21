package appium.appium.MobileAppObjects;

import org.openqa.selenium.WebElement;

import appium.appium.MobileWebDriver;
import io.appium.java_client.android.AndroidDriver;

public class contactManagerApp {

	MobileWebDriver androidDriver;

	public contactManagerApp(MobileWebDriver androidDriver) {
		this.androidDriver = androidDriver;
	}

	public void addContactName(String name){
		androidDriver.findElementById(name);
	}

}
