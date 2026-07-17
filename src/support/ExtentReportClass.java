package support;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ExtentReportClass implements ITestListener {
	ExtentReports report = new ExtentReports();
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("report/myreport.html");
	ExtentTest extentTest;

	public void onTestStart(ITestResult result) {
		report.attachReporter(htmlReporter);
		extentTest = report.createTest(result.getMethod().getMethodName());
		extentTest.log(Status.INFO, "The test start");
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "The test passed");
	}

	public void onTestFailure(ITestResult result) {

	    TakesScreenshot ts = (TakesScreenshot) Constant.driver;

	    File source = ts.getScreenshotAs(OutputType.FILE);

	    String destinationPath = System.getProperty("user.dir")
	            + File.separator + "screenshots"
	            + File.separator + result.getName() + ".png";

	    File finalDestination = new File(destinationPath);

	    try {
	        FileUtils.copyFile(source, finalDestination);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    extentTest.log(Status.FAIL, "Step is fail, see screenshot please")
	    .addScreenCaptureFromPath(destinationPath);
	    
	}

	public void onFinish(ITestContext context) {
		extentTest.log(Status.INFO, "The test finished");
		report.flush();
	}
}