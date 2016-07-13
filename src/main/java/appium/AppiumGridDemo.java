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
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class AppiumGridDemo {

	private static AndroidDriver driver;

	public static void main(String[] args) throws IOException {

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

		capabilities.setCapability("deviceName", "your_device_id");// to get
																	// device id
																	// see $adb
																	// devices

		driver = new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// print current activity name
		System.out.println(driver.currentActivity());
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

		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@text='LOGIN']"))));

	}

	private static boolean isElementExist(By by) {
		try {
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}

	}
}