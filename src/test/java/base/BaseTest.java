package base;

import org.testng.annotations.*;
import utils.*;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        BrowserFactory.initDriver();
        String env = ConfigReader.get("env");
        BrowserFactory.driver.get(ConfigReader.get(env + "Url"));
    }

    @AfterMethod
    public void tearDown() {
        BrowserFactory.quitDriver();
    }
}
