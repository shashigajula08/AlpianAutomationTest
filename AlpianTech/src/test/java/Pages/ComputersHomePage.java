package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import DriverUtil.Base;
import Reporting.Reports;

public class ComputersHomePage {
	
	By SearchField = By.xpath("//input[@name='f']");
	By SubmitButton = By.xpath("//input[@id='searchsubmit']");
	By ResultText = By.xpath("//section[@id='main']/h1");
	By AddButton = By.xpath("//a[@id='add']");
	
	
	public void fnSearchForComputer(String sSearch){
		
		WebElement eleSearch = Base.driver.findElement(SearchField);
		eleSearch.sendKeys(sSearch);
		Reports.Test.log(Status.INFO, "Searching for computer - "+sSearch);
		
		WebElement eleSearchSubmit = Base.driver.findElement(SubmitButton);
		eleSearchSubmit.click();
		Reports.Test.log(Status.INFO, "Click Submit button");
	}
	
	public void fnVerifySearchResulttext() {
				
		WebElement eleValidateCompName = Base.driver.findElement(ResultText);
		String Datafound = eleValidateCompName.getText();
		Reports.Test.log(Status.INFO, "Captured results text displaying");
		if(Datafound=="One computer found")
		{
			Reports.Test.log(Status.PASS, "Result text displays expected - "+Datafound);
			
		}
		else 
		{
			Reports.Test.log(Status.FAIL, "Result text displays not expected - "+Datafound);
		}
		
	}
	
	public void fnClickCreateCompButton() {
		WebElement eleAdd = Base.driver.findElement(AddButton);
		eleAdd.click();
		Reports.Test.log(Status.INFO, "Clicked on AddButton");
	}

}
