package appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class AppiumChromeDemo {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		// capabilities.setCapability("androidUseRunningApp", true);
		capabilities.setCapability("deviceName", "your_device_id");// to get
																	// device id
																	// see $adb
																	// devices

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.get("http://www.hdfcbank.com/");
		String w1 = driver.getWindowHandle();
		driver.findElement(By.partialLinkText("Desktop Website")).click();
		for (String w : driver.getWindowHandles()) {
			if (!w1.equals(w)) {
				driver.switchTo().window(w);
				break;
			}
		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@alt='Close']")));
		driver.findElement(By.id("loginsubmit")).click();
		System.out.println(driver.getWindowHandles().size());
		System.out.println(driver.getTitle());

	}
}
