package utils;

import java.io.File;
import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {
    public static void capture(String name) {
        try {
            File src = ((TakesScreenshot) BrowserFactory.driver)
                    .getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("screenshots/" + name + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
