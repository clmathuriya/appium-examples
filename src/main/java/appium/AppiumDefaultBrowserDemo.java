package appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AppiumDefaultBrowserDemo {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Browser");
		// capabilities.setCapability("androidUseRunningApp", true);
		capabilities.setCapability("deviceName", "ZX1D63LJRD");// to get
																// device id
																// see $adb
																// devices

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.navigate().to("https://www.google.co.in");

		WebElement e = driver.findElement(By.name("q"));

		e.sendKeys("cheese");

		System.out.println(driver.getWindowHandles().size());
		System.out.println(driver.getTitle());

	}
}
