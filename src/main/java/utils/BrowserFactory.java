package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	public static WebDriver driver;
	public static void killAllChromeDrivers() {
		try {
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c",
					"taskkill /F /IM chromedriver.exe /T");
			pb.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initDriver() {
		if (driver == null) {
			killAllChromeDrivers();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
