package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import DriverUtil.Base;
import Reporting.Reports;

public class DeleteComputer {
	By Elesearch =  By.xpath("//input[@name='f']"); 
	By eleSeaSubmit = By.xpath("//input[@id='searchsubmit']");
	By eleSeaSearch = By.xpath("//tbody/tr[1]/td[1]/a");
	By DeleteButton = By.xpath("//input[@value='Delete this computer']");
	
	
	
	public void fnDeleteComp()
	{
		
		WebElement eleDeleteComp = Base.driver.findElement(DeleteButton);
		eleDeleteComp.click();
		Reports.Test.log(Status.INFO, "Click on Delete this computer button");
	}
	
	public void fnverifydeletecomp(String sSearch)
	{
		WebElement eleSearch = Base.driver.findElement(Elesearch);
		eleSearch.sendKeys(sSearch);
		
		
		WebElement eleSearchSubmit = Base.driver.findElement(eleSeaSubmit);
		eleSearchSubmit.click();
		
		WebElement eleSelectSearch = Base.driver.findElement(eleSeaSearch);
		String sDeleteName = eleSelectSearch.getText();
		
		if(sDeleteName.equals(sSearch))
		{
			Reports.Test.log(Status.FAIL, "Deleted computer is still displaying");
		}
		else
		{
			Reports.Test.log(Status.PASS, "Deleted computer is not displaying");
		}
			
			
		
	}

}
