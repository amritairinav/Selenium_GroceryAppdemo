package generatereport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utility.ExtentReportUtility;

public class Listeners implements ITestListener {

	ExtentReports extent = ExtentReportUtility.getInstance();
	ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if (test.get() != null) {
			test.get().log(Status.PASS, "Test case passed");
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (test.get() != null) {
			test.get().log(Status.FAIL, "Test case failed");
			test.get().log(Status.FAIL, result.getThrowable());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		if (test.get() != null) {
			test.get().log(Status.SKIP, "Test case skipped");
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}