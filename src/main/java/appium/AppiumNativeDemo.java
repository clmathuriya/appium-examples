package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.android.AndroidDriver;

public class AppiumNativeDemo {

	private static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability("app", new File("data/pal.apk").getAbsolutePath());
		// capabilities.setCapability("androidUseRunningApp", true);
		capabilities.setCapability("deviceName", "your_device_id");// to get
																	// device id
																	// see $adb
																	// devices

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		// print current activity name
		System.out.println(driver.currentActivity());
		// verify if skip button displayed
		Asserts.check(driver.findElement(By.id("")).isDisplayed(), "verify if skip button displayed");

		// click on next button while it displayed
		while (isElementExist(By.id(""))) {
			driver.findElement(By.id("")).click();
		}
		// verrify getstarted button displayed
		System.out.println("get started button displayed ? " + driver.findElement(By.xpath("")).isDisplayed());
		// click on get started button

	}

	private static boolean isElementExist(By by) {
		try {
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}

	}
}