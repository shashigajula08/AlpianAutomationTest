package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import DriverUtil.Base;
import Reporting.Reports;

public class CreateComputer {

	
	By compName = By.xpath("//input[@id='name']");
	By Indroduced = By.xpath("//input[@id='introduced']");
	By Discontinued = By.xpath("//input[@id='discontinued']");
	By CompanyName = By.xpath("//select[@id='company']");
	By CreateComp = By.xpath("//input[@value='Create this computer']");
	By CompDone = By.xpath("//section[@id='main']/div[1]/strong");


	public void fnCreate(String sCompName)
	{


		// Computer name
		WebElement eleCmpName = Base.driver.findElement(compName);
		eleCmpName.sendKeys(sCompName);
		Reports.Test.log(Status.INFO, "Entered computer name - "+sCompName);
		// Introduced
		WebElement eleIndroduced = Base.driver.findElement(Indroduced);
		eleIndroduced.sendKeys("2022-05-30");
		Reports.Test.log(Status.INFO, "Entered Introduced date - "+"2022-05-30");

		// Discontinued 
		WebElement eleDisContinued = Base.driver.findElement( Discontinued );
		eleDisContinued.sendKeys("2022-06-30");
		Reports.Test.log(Status.INFO, "Entered Discontinued date - "+"2022-06-30");
		// Company //select[@id='company']

		WebElement eleCompany = Base.driver.findElement(CompanyName);
		//eleCompany.click();
		Select sCompany = new Select(eleCompany);
		sCompany.selectByVisibleText("RCA");
		Reports.Test.log(Status.INFO, "Selected company - "+"RCA");

		WebElement eleCreateComp = Base.driver.findElement(CreateComp );
		eleCreateComp.click();
		Reports.Test.log(Status.INFO, "Clicked on Create computer button");


	}

	//	create this function in a separate class if needed
	public void fnValidateSuccessMessage()
	{

		WebElement eleDone = Base.driver.findElement(CompDone);

		String sDone = eleDone.getText();
		Reports.Test.log(Status.INFO, "Captured text on the screen");
		if(sDone.equals("Done !"))
		{
			Reports.Test.log(Status.PASS, "Computer created success message displaying");
		}
		else
		{
			Reports.Test.log(Status.FAIL, "Computer created success message is not displaying");
		}

	}







}
