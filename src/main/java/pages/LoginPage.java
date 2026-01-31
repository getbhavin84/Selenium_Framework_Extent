package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserFactory;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;

	public By loginBtn = By.xpath(
			"//a[contains(text(),'Login') or contains(text(),'Sign in')]");
	public By email = By.xpath("//input[contains(@placeholder,'Email')]");
	public By password = By.xpath("//input[@type='password']");
	public By submit = By.xpath("//button[contains(text(),'Login')]");

	public LoginPage() {
		driver = BrowserFactory.driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public void openLoginPopup() {
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
	}

	public void enterUsername(String user) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(email))
				.sendKeys(user);
	}

	public void enterPassword(String pass) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(password))
				.sendKeys(pass);
	}

	public void clickLogin() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
		Thread.sleep(3000);
		// Clicking on my naukri logo
		driver.findElement(By.xpath("//img[@alt='naukri user profile img']"))
				.click();

		// Clicking on View & Update Profile link
		driver.findElement(By.linkText("View & Update Profile")).click();

		System.out.println("clicked on my naukri");
		// driver.findElement(By.linkText("Edit Profile")).click();

		// Delete Existing resume

		System.out.println("Deleting exsisting resume...");
		String lastuploadTimebeforedelete = driver
				.findElement(By.xpath("//div[contains(@class,'updateOn')]"))
				.getText();

		driver.findElement(
				By.xpath("//*[@title='Click here to delete your resume']"))
				.click();

		// p[normalize-space(text())='Are you sure you want to delete the
		// Resume?']/following::button
		driver.findElement(By.xpath(
				"//p[contains(normalize-space(text()),'Are you sure you want to delete the resume?')]/following::button"))
				.click();

		Thread.sleep(2000);
		System.out.println("Deleted successfully");

		// driver.findElement(By.xpath("//div[@class='crossIcon chatBot
		// chatBot-ic-cross']")).click();
		// div[@class='crossIcon chatBot chatBot-ic-cross']
		/*
		 * WebElement eleprofile2 =
		 * driver.findElement(By.xpath("//li[2]/a/div[2]")); Actions builder2 =
		 * new Actions(driver);
		 * builder2.moveToElement(eleprofile2).build().perform();
		 * System.out.println("clicked on my naukri");
		 * driver.findElement(By.linkText("Edit Profile")).click();
		 * //driver.findElement(By.xpath(
		 * "//div[@id='root']/div/div/span/div/div/div/div/div[2]/div/div/div/ul/li[12]/span"
		 * )).click();
		 * //driver.findElement(By.xpath("//a[normalize-space(text())='Update']"
		 * )).click ();
		 * 
		 * Thread.sleep(3000); //
		 * builder.moveToElement(driver.findElement(By.xpath(
		 * "//*[@id='attachCV']"))). click().build().perform();;
		 * 
		 * // builder.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();;
		 * 
		 * //builder.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		 * 
		 * //builder.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		 * 
		 * // builder.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		 * //Thread.sleep(20000);
		 * //driver.findElement(By.xpath("//*[@id='attachCV']")).click();
		 * //driver.findElement(By.xpath("//*[@id='attachCV']")).click();
		 * 
		 */
		// Attach again code

		System.out.println("Attaching new...");

		driver.findElement(By.id("attachCV")).clear();
		driver.findElement(By.id("attachCV")).sendKeys(new CharSequence[]{
				"F:\\RESUME\\19feb24RESUME COLLECTION\\Bhavin Soni Test Manager Automation and Manual Testing 15yrs.docx"});
		Thread.sleep(2000);
		String uploadTimeNew = driver
				.findElement(By.xpath("//div[contains(@class,'updateOn')]"))
				.getText();
		System.out.println(
				"Last updated this resume at: " + lastuploadTimebeforedelete);
		System.out.println("New updated this resume now at: " + uploadTimeNew);
		System.out.println("Closing browser..");

		driver.navigate().refresh();
		Thread.sleep(2000);

	}
}
