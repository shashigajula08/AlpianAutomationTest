package DriverUtil;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Reporting.Reports;

public class Base {
	
	public static WebDriver driver;

	public void fnLaunchBrowesr()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\shashi\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Reports.Test.log(Status.PASS, "Launched Chrome Browser");
		//add implicit wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	
	public void fnNavigatetoURL(String sUrl)
	{
		driver.navigate().to(sUrl);
		Reports.Test.log(Status.PASS, "Navigated to Url - "+sUrl);
	}
	
	public void fnCloseApplication() {
		driver.close();
		Reports.Test.log(Status.PASS, "Close complete application");
	}
	
}
