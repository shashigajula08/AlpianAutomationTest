package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import DriverUtil.Base;
import Reporting.Reports;

public class UpdateComputer {
	
	By FirstSearchResult = By.xpath("//tbody/tr[1]/td[1]/a");
	By ComputerName = By.xpath("//input[@id='name']");
	By SaveButton = By.xpath("//input[@value='Save this computer']");
	
	public void fnUpdateComputerName(String sVerifyUpdateName)
	{
		
		WebElement eleSelectSearch = Base.driver.findElement(FirstSearchResult);
		eleSelectSearch.click();
		Reports.Test.log(Status.INFO, "Click on first result- ");
		WebElement eleCmpName = Base.driver.findElement(ComputerName);
		eleCmpName.clear();
		eleCmpName.sendKeys(sVerifyUpdateName);		
		Reports.Test.log(Status.INFO, "Update the computer name to - "+sVerifyUpdateName);
	}
	

	public void fnSave()
	{
		WebElement eleSave = Base.driver.findElement(SaveButton);
		eleSave.click();	
		Reports.Test.log(Status.INFO, "Click on Save this Computer Button");
	}
	
	public void fnverifyupadatecomp(String sUpdatedCompname)
	{

		
		WebElement eleSelectSearch = Base.driver.findElement(FirstSearchResult);
		eleSelectSearch.click();
		Reports.Test.log(Status.INFO, "Click on first result- ");
		
		WebElement eleCmpName = Base.driver.findElement(ComputerName);
		String sCompName = eleCmpName.getText();
		Reports.Test.log(Status.INFO, "Capture the name displaying");
		
		if(sCompName==sUpdatedCompname)
		{
			Reports.Test.log(Status.PASS, "Updated name is displaying correctly - "+sCompName+"-"+sUpdatedCompname);
		}
		else
		{
			Reports.Test.log(Status.FAIL, "Updated name is not displaying correctly - "+sCompName+"-"+sUpdatedCompname);
			
		}		
		
	}
	
	public void fnClickFirstResult() {
		WebElement eleSelectSearch = Base.driver.findElement(FirstSearchResult);
		eleSelectSearch.click();
		Reports.Test.log(Status.INFO, "Click on first result- ");
	}

}
