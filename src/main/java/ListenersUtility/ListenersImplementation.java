package ListenersUtility;

import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseClass.BaseClass;

public class ListenersImplementation implements ITestListener,ISuiteListener
{
    public ExtentSparkReporter spark;
    public ExtentReports report;
    public ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		Reporter.log("report configuration",true);
	    Date d = new Date();
	    String newdate = d.toString().replace(" ", "_").replace(":", "_");
	    ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report_"+newdate+".html");
	    spark.config().setDocumentTitle("NINZACRM Test results");
	    spark.config().setReportName("CRM Report");
	    spark.config().setTheme(Theme.DARK);
	    
	    report=new ExtentReports();
	    report.attachReporter(spark);
	    report.setSystemInfo("OS", "windows11");
	    report.setSystemInfo("browser", "Edge");
	    }

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		Reporter.log("report backup",true);
	}

	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO,"===" +result.getMethod().getMethodName()+"execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testname = result.getMethod().getMethodName();
	    Reporter.log("====" + testname + " PASSED ====", true);
        Date d = new Date();
	    String newdate = d.toString().replace(" ", "-").replace(":", "-");
        TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
	    String base64Screenshot = ts.getScreenshotAs(OutputType.BASE64);
        test.addScreenCaptureFromBase64String(base64Screenshot, testname + newdate);
	    test.log(Status.PASS, "====" + testname + " PASSED ====");
	}
	    
	

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		Reporter.log("===="+testname+"FAILURE====" ,true);
	    Date d = new Date();
	    String newdate = d.toString().replace(" ", "-").replace(":", "-");
	    TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
	     String temp = ts.getScreenshotAs(OutputType.BASE64);
	     test.addScreenCaptureFromBase64String(temp,testname + newdate);
	     test.log(Status.FAIL,"===="+testname+ "FAILURE====");
	   
	}

   @Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

}
