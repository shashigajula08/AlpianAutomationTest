package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import DriverUtil.Base;
import Reporting.Reports;

public class ReadComputer {
	
	String sComputerName;
	String sIntro;
	String sDiscon;
	String sCompany;

	
	By IntroDate = By.xpath ("//table[@class='computers zebra-striped']/tbody/tr/td[2]");
	By DiscDate = By.xpath("//table[@class='computers zebra-striped']/tbody/tr/td[3]");
	By  CompName = By.xpath(("//table[@class='computers zebra-striped']/tbody/tr/td/a"));
	By  CompanyName = By.xpath(("//table[@class='computers zebra-striped']/tbody/tr/td[4]"));
	By compName = By.xpath("//input[@id='name']");
	By Indroduced = By.xpath("//input[@id='introduced']");
	By Discontinued = By.xpath("//input[@id='discontinued']");
	By CompanyNames = By.xpath("//select[@id='company']");
	
	public void fnCaptureValues()
	{

		//Capture values from the computer
		
		//ComputerName
		WebElement eleCompName = Base.driver.findElement(CompName);
		sComputerName = eleCompName.getText();
		Reports.Test.log(Status.INFO, "Captured computer name - "+sComputerName);
		
		WebElement eleIntro = Base.driver.findElement(IntroDate);
		sIntro = eleIntro.getText();
		Reports.Test.log(Status.INFO, "Captured computer sIntro - "+sIntro);
		
		WebElement eleDisc = Base.driver.findElement(DiscDate);
		sDiscon = eleDisc.getText();
		Reports.Test.log(Status.INFO, "Captured computer sDiscon - "+sDiscon);
		
		WebElement eleCompany = Base.driver.findElement(CompanyName);
		sCompany = eleCompany.getText();
		Reports.Test.log(Status.INFO, "Captured computer sCompany - "+sCompany);
		
		
	}
	
	
	public void fnValidateComputerDetails() {
		
		//ASCI White
		WebElement eleCompName = Base.driver.findElement(compName);
		if(sComputerName.equals(eleCompName.getAttribute("value"))) {
			Reports.Test.log(Status.PASS, "Computer name is displaying correctly - "+sComputerName);
		}else {
			Reports.Test.log(Status.FAIL, "Computer name is not displaying correctly - "+sComputerName);
		}

		/*
		 * WebElement eleIntro = Base.driver.findElement(Indroduced);
		 * if(sIntro==(eleIntro.getAttribute("value"))) { Reports.Test.log(Status.PASS,
		 * "Introduced date is displaying correctly - "+sIntro+"-"+eleIntro.getAttribute
		 * ("value")); }else { Reports.Test.log(Status.FAIL,
		 * "Introduced date  is not displaying correctly - "+sIntro+"-"+eleIntro.
		 * getAttribute("value")); }
		 * 
		 * WebElement eleDisc = Base.driver.findElement(Discontinued);
		 * if(sDiscon.equals(eleDisc.getAttribute("value"))) {
		 * Reports.Test.log(Status.PASS,
		 * "Discontinued date is displaying correctly - "+sDiscon); }else {
		 * Reports.Test.log(Status.FAIL,
		 * "Discontinued date  is not displaying correctly - "+sDiscon); }
		 */
		/*
		 * WebElement eleCompany = Base.driver.findElement(CompanyNames); Select
		 * sCompany = new Select(eleCompany);
		 * 
		 * if(sCompany.equals(sCompany.getFirstSelectedOption().getText())) {
		 * Reports.Test.log(Status.PASS,
		 * "Company is displaying correctly - "+sCompany+"-"+sCompany.
		 * getFirstSelectedOption().getText()); }else { Reports.Test.log(Status.FAIL,
		 * "Company  is not displaying correctly - "+sCompany+"-"+sCompany.
		 * getFirstSelectedOption().getText()); }
		 */
		
		
	}

}
