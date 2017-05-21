package appium.appium;

import org.junit.Before;

public class MobileBasicTest {

	MobileWebDriver webDriver;

	@Before
	public void setup() throws Exception {
		webDriver = new MobileWebDriver();
		webDriver.init("ContactManager.apk", "avd1", "127.0.0.1:4723");
	}

}
