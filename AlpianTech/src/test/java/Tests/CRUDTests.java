package Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DriverUtil.Base;
import Pages.ComputersHomePage;
import Pages.CreateComputer;
import Pages.DeleteComputer;
import Pages.ReadComputer;
import Pages.UpdateComputer;
import Reporting.Reports;

public class CRUDTests {
	Base DriverUtil = new Base();
	ComputersHomePage HomePage = new ComputersHomePage();
	CreateComputer CreatecompPage = new CreateComputer();
	UpdateComputer UpdatecompPage = new UpdateComputer();
	DeleteComputer objDeletecomp = new DeleteComputer();
	ReadComputer objReadComp = new ReadComputer();
	Reports Reporter = new Reports();
	
	@BeforeTest
	public void PreReqRun() {
		Reporter.createHtmlReport(".//CompDBTestsResults");
	}
	
	@AfterTest
	public void AfterTestRun() {
		Reporter.FlushReports();
	}
	
	@Test
	public void fnCreateComputer()
	{
		Reporter.createTest("Test-Create a New Computer");
		DriverUtil.fnLaunchBrowesr();
		DriverUtil.fnNavigatetoURL("https://computer-database.gatling.io/computers");
		HomePage.fnClickCreateCompButton();
		CreatecompPage.fnCreate("Shashi");
		CreatecompPage.fnValidateSuccessMessage();
		DriverUtil.fnCloseApplication();
	}
	
	@Test
	public void fnVerifyCreate()
	{
		Reporter.createTest("Test-Verify newly created computer");
		DriverUtil.fnLaunchBrowesr();
		DriverUtil.fnNavigatetoURL("https://computer-database.gatling.io/computers");
		HomePage.fnSearchForComputer("ShaShi");
		HomePage.fnVerifySearchResulttext();
		DriverUtil.fnCloseApplication();
	}
	
	
	@Test
	public void fnUpdateComputer()
	{
		Reporter.createTest("Test-Update Computer");
		DriverUtil.fnLaunchBrowesr();
		DriverUtil.fnNavigatetoURL("https://computer-database.gatling.io/computers");
		HomePage.fnSearchForComputer("ASCI White");
		UpdatecompPage.fnUpdateComputerName("Ask");
		UpdatecompPage.fnSave();
		CreatecompPage.fnValidateSuccessMessage();
		DriverUtil.fnCloseApplication();
	}
	
	@Test
	public void fnVerifyUpdated()
	{
		Reporter.createTest("Test-Verify Updated Computer");
		DriverUtil.fnLaunchBrowesr();
		DriverUtil.fnNavigatetoURL("https://computer-database.gatling.io/computers");
		HomePage.fnSearchForComputer("ASCI White");
		UpdatecompPage.fnverifyupadatecomp("Ask");
		DriverUtil.fnCloseApplication();
	}
	
	@Test
	public void fnReadComputer()
	{
		Reporter.createTest("Test-Read Computer");
		DriverUtil.fnLaunchBrowesr();
		DriverUtil.fnNavigatetoURL("https://computer-database.gatling.io/computers");;
		HomePage.fnSearchForComputer("ASCI White");
		objReadComp.fnCaptureValues();
		UpdatecompPage.fnClickFirstResult();
		objReadComp.fnValidateComputerDetails();
		//DriverUtil.fnCloseApplication();
	}
	
	@Test
	public void fnDeleteComputer()
	{
		Reporter.createTest("Test-Delete Computer");
		DriverUtil.fnLaunchBrowesr();
		DriverUtil.fnNavigatetoURL("https://computer-database.gatling.io/computers");
		HomePage.fnSearchForComputer("ASCI White");
		UpdatecompPage.fnClickFirstResult();
		objDeletecomp.fnDeleteComp();
		CreatecompPage.fnValidateSuccessMessage();
		DriverUtil.fnCloseApplication();
	}
	
	

	
	@Test
	public void fnverifydelete()
	{
		Reporter.createTest("Test-Verify Delete Computer");
		DriverUtil.fnLaunchBrowesr();
		DriverUtil.fnNavigatetoURL("https://computer-database.gatling.io/computers");
		objDeletecomp.fnverifydeletecomp("ASCI White");
		DriverUtil.fnCloseApplication();
		
	}
}
