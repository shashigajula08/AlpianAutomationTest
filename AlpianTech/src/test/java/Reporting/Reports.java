package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	public static ExtentReports Extent;
	public static ExtentTest Test;

	public void createHtmlReport(String sReportsName)
	{
		Extent = new ExtentReports();
		ExtentSparkReporter Exspark = new ExtentSparkReporter(sReportsName);
		Extent.attachReporter(Exspark);

	}


	public void createTest(String sTestname)
	{
		Test = Extent.createTest(sTestname);
	}


	public void PassStepTest(String sDescription)
	{
		Test.log(Status.PASS, sDescription);
	}


	public void FailStepTest(String sDescription)
	{
		Test.log(Status.FAIL, sDescription);
	}

	public void FlushReports() {
		Extent.flush();
	}


}





