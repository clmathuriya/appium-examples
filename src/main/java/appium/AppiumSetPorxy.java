package appium;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

import org.apache.commons.io.FileUtils;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class AppiumSetPorxy {

	private static AndroidDriver driver;

	public static void main(String[] args) throws IOException {
		System.setProperty("ANDROID_HOME", "/home/rss-23/Android/Sdk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		// capabilities.setCapability("app", new
		// File("data/pal.apk").getAbsolutePath());
		// capabilities.setCapability("androidUseRunningApp", true);
		// capabilities.setCapability("appPackage", "com.preplane");
		capabilities.setCapability("appPackage", "com.android.settings");
		capabilities.setCapability("appActivity", ".Settings");
		// capabilities.setCapability("appActivity",
		// ".ui.welcomeactivity.WelcomeActivity");
		capabilities.setCapability("platformName", "ANDROID");

		capabilities.setCapability("deviceName", "your_device_id");// to get
																	// device id
																	// see $adb
																	// devices

		driver = new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// click on wifi
		driver.findElement(By.id("com.android.settings:id/title")).click();
		// print current activity name
		// select plancess tech wifi
		TouchAction action = new TouchAction(driver);
		action.longPress(driver.findElement(By.id("android:id/title"))).release().perform();

		// select modify network
		driver.findElement(By.xpath("//*[@text='Modify network']")).click();

		// select proxy type
		driver.findElement(By.id("com.android.settings:id/proxy_settings")).click();

		//
		driver.findElement(By.xpath("//*[@text='Manual']")).click();
		// hide keyboard
		driver.hideKeyboard();

		// set host
		driver.findElement(By.id("com.android.settings:id/proxy_hostname")).sendKeys("192.168.2.118");
		// hide keyboard
		driver.hideKeyboard();
		driver.findElement(By.id("com.android.settings:id/proxy_port")).sendKeys("8090");
		// save settings

		driver.findElement(By.xpath("//*[@text='Save']")).click();

		System.out.println(driver.currentActivity());
		// verify if skip button displayed

		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@text='LOGIN']"))));

	}

	private static boolean isElementExist(By by) {
		try {
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public static String getIP() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "127.0.0.1";
		}
	}

	public void setProxy(AndroidDriver driver) {

		driver.startActivity("com.android.settings", ".Settings");
		// click on wifi
		driver.findElement(By.id("com.android.settings:id/title")).click();
		// print current activity name
		// select plancess tech wifi
		TouchAction action = new TouchAction(driver);
		action.longPress(driver.findElement(By.id("android:id/title"))).release().perform();

		// select modify network
		driver.findElement(By.xpath("//*[@text='Modify network']")).click();

		// select proxy type
		driver.findElement(By.id("com.android.settings:id/proxy_settings")).click();

		//
		driver.findElement(By.xpath("//*[@text='Manual']")).click();
		// hide keyboard
		driver.hideKeyboard();

		// set host
		driver.findElement(By.id("com.android.settings:id/proxy_hostname")).sendKeys("192.168.2.118");
		// hide keyboard
		driver.hideKeyboard();
		driver.findElement(By.id("com.android.settings:id/proxy_port")).sendKeys("8090");
		// save settings

		driver.findElement(By.xpath("//*[@text='Save']")).click();

		System.out.println(driver.currentActivity());
		// verify if skip button displayed

		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@text='LOGIN']"))));

	}
}