package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {
            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter("./extent-reports/extent-report.html");

            sparkReporter.config().setReportName("GroceryappTestin Automation Report");
            sparkReporter.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Project", "GroceryappTesting");
            extent.setSystemInfo("Tester", "Amrita");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}