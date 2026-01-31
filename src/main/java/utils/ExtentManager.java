package utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {

			String reportPath = System.getProperty("user.dir") + File.separator
					+ "reports" + File.separator + "ExtentReport.html";

			ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

			spark.config().setOfflineMode(true);

			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Automation Report");
			spark.config().setReportName("Selenium Test Results");

			extent = new ExtentReports();
			extent.attachReporter(spark);
		}
		extent.flush();
		return extent;
	}
}
