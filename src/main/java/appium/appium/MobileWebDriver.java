package appium.appium;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import appium.appium.Utils.autoUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;

public class MobileWebDriver {

	AndroidDriver<WebElement> driver;
	


	/**
	 * 
	 * @param apkFileName
	 * @param deviceName
	 * @param appiumServerAddress
	 * @throws Exception
	 */
	public void init(String apkFileName, String deviceName, String appiumServerAddress) throws Exception {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File((System.getProperty("user.dir") + "/files/apk"));
		File app = new File(appDir, apkFileName);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformVersion", "6.0");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.example.android.contactmanager");

		capabilities.setCapability("appActivity", ".ContactManager");
		
		driver = new AndroidDriver<>(new URL("http://" + appiumServerAddress + "/wd/hub"), capabilities);
	}
	
	public WebElement findElementById(String id) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10, 1000);
			element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return element;

	}

	public WebElement findElementByText(String text) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10, 1000);
			element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(text)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return  element;
	}

	public void quit() {
		driver.quit();

	}

	public void sendTextToElement(String elementText, String textTosend) {
		driver.getKeyboard().sendKeys(textTosend);

	}

	public void takeScreenshot() throws Exception {
		File file = driver.getScreenshotAs(OutputType.FILE);
		autoUtils.copy(file, System.getProperty("user.dir") + "\\files\\scr\\" + file.getName());

	}

	public void setConnection(Connection connection) {
		driver.setConnection(connection);
	}

	public void setLocation(double latitude, double longitude, double altitude) {
		driver.setLocation(new Location(latitude, longitude, altitude));

	}

	public void startApp(String activityName, String activityPackage) {
		driver.startActivity(activityPackage, activityName);
		
	
		
	
	}

	

}
