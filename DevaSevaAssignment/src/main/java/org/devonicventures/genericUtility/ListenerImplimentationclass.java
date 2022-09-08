package org.devonicventures.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplimentationclass implements ITestListener {
	
	private ExtentTest test;
	public static ExtentTest testLog;
	private ExtentReports report;
	
	@Override
	public void onTestStart(ITestResult result) {
		test.assignAuthor("Santhruptha");
		test.assignCategory("smoke");
}
	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+"passed");
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName()+"test failed");
		test.fail(result.getThrowable());
		String path = ThreadSafeClass.getMobileUtility().TakesScreenShotInBase64();
		test.addScreenCaptureFromBase64String(path, result.getMethod().getMethodName());
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName()+"test skipped");
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}
	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./emailable-report/extent-reports");
		spark.config().setDocumentTitle("Dream 11 TestCase");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Dream 11 Report");
		
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Device Name", "Note 7 pro");
		report.setSystemInfo("Platform", "Android");
		report.setSystemInfo("Platform Version", "10.0.0");
		
		test=report.createTest(context.getClass().getSimpleName());
		testLog=test;
		
	}
	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
