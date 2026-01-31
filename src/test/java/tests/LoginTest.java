package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {
	LoginPage loginPage;
	@Test
	public void loginTest() throws Exception {
		loginPage = new LoginPage();
		loginPage.openLoginPopup();
		loginPage.enterUsername(ConfigReader.get("user"));
		loginPage.enterPassword(ConfigReader.get("password"));
		loginPage.clickLogin();
	}
}
