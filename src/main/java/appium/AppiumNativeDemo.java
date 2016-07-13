package appium;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class AppiumNativeDemo {

	private static AndroidDriver driver;

	public static void main(String[] args) throws IOException {

		System.setProperty("ANDROID_HOME", "/home/rss-23/Android/Sdk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability("app", new File("data/pal.apk").getAbsolutePath());
		// capabilities.setCapability("androidUseRunningApp", true);
		capabilities.setCapability("appPackage", "com.preplane");
		// capabilities.setCapability("appPackage", "com.android.settings");
		// capabilities.setCapability("appActivity", ".SubSettings");
		capabilities.setCapability("appActivity", ".ui.welcomeactivity.WelcomeActivity");

		capabilities.setCapability("deviceName", "your_device_id");// to get
																	// device id
																	// see $adb
																	// devices

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// print current activity name
		// new AppiumSetPorxy().setProxy(driver);
		System.out.println(driver.currentActivity());
		driver.launchApp();
		// verify if skip button displayed
		Asserts.check(driver.findElement(By.id("com.preplane:id/skip")).isDisplayed(),
				"verify if skip button displayed");

		// click on next button while it displayed
		while (isElementExist(By.className("android.widget.ImageButton"))) {
			driver.findElement(By.className("android.widget.ImageButton")).click();
		}
		// verrify getstarted button displayed
		System.out.println(
				"get started button displayed ? " + driver.findElement(By.id("com.preplane:id/done")).isDisplayed());
		// take screen shot
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("screenshots/img" + System.currentTimeMillis() + ".png"));
		// click on get started button
		driver.findElement(By.id("com.preplane:id/done")).click();

	}

	private static boolean isElementExist(By by) {
		try {
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}

	}
}