package appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AppiumDefaultBrowserDemo {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		// capabilities.setCapability("androidUseRunningApp", true);
		capabilities.setCapability("deviceName", "your_device_id");// to get
																	// device id
																	// see $adb
																	// devices

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.get("http://www.hdfcbank.com/");
		String w1 = driver.getWindowHandle();
		driver.findElement(By.partialLinkText("desktop website")).click();
		for (String w : driver.getWindowHandles()) {
			if (!w1.equals(w)) {
				driver.switchTo().window(w);
				break;
			}
		}
		driver.findElement(By.id("loginsubmit")).click();
		System.out.println(driver.getWindowHandles().size());
		System.out.println(driver.getTitle());

	}
}
