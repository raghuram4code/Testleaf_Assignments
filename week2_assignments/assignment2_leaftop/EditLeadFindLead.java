package week2_assignments.assignment2_leaftop;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditLeadFindLead {
	
	public List<WebElement> FindingLead(WebDriver driver,String chngName) {		

		// * 12 Click Edit
		System.out.println("Editing lead ");
		//driver.findElement(By.linkText("Edit")).click();
		// with xpath a[text()='Edit']
		driver.findElement(By.xpath("//a[text()='Edit']")).click();

		// * 13 Change the company name
		System.out.println("Clearing Companyname");
		//WebElement curCompName=driver.findElement(By.id("updateLeadForm_companyName"));
		WebElement curCompName=driver.findElement(By.xpath("//input[contains(@id,'companyName')]"));
		curCompName.clear();
		curCompName.sendKeys(chngName);
		

		// * 14 Click Update
		System.out.println("Clicking Upate lead button");
		//driver.findElement(By.className("smallSubmit")).click();
		//input[@class='smallSubmit'and @value='Update']
		driver.findElement(By.xpath("//input[@class='smallSubmit'and @value='Update']")).click();
		
		//String chngCompName=driver.findElement(By.id("viewLead_companyName_sp")).getText();
		//span[contains(@id,'companyName')]
		//String chngCompName=driver.findElement(By.xpath("//span[contains(@id,'companyName')]")).getText();
		
		List<WebElement> listCompanyName = driver.findElements(By.xpath("//span[contains(text(),'"+chngName+"')]"));
		
		 System.out.println(listCompanyName.size()); 
		 for (int i=0;i<listCompanyName.size();i++) 
		 { System.out.println(listCompanyName.get(i).getText()); }
		 
		// * 15 Confirm the changed name appears
		//String pageName = driver.getTitle();
		//System.out.println(chngCompName);
		
		return listCompanyName;

	}

	public static void main(String[] args) {
		String usrName = "Demosalesmanager";
		String pwd = "crmsfa";
		String url = "http://leaftaps.com/opentaps/control/login";
		String firstname ="AssignFirstName";
		String leadSearchPage= "View Lead | opentaps CRM";
		String newCompName = "Assign Bank corporation";
		
		LoginPage newLoginPage = new LoginPage();
		Cmsfa newCmsfa = new Cmsfa();
		//CreateLead newCreateLead = new CreateLead();
		NavigationPanel newNavigationPanel = new NavigationPanel();
		
		FindLeads findingLeads = new FindLeads();
		EditLeadFindLead editingLead = new EditLeadFindLead();

		WebDriverSetup drivsetup = new WebDriverSetup();
		WebDriver getDriver = drivsetup.chromeDriver();

		newLoginPage.loginMethod(getDriver, url, usrName, pwd);
		newCmsfa.crmPage(getDriver);
		
		//newCreateLead.createLeadMethod(getDriver, firstname);
		newNavigationPanel.navigatingToLead(getDriver);
		String curPageName=findingLeads.findingLead(getDriver,firstname);
		System.out.println("I am currently at page:" + 
		curPageName+" & expected page is "+leadSearchPage );
		
		List<WebElement> chngCompName =editingLead.FindingLead(getDriver, newCompName);
		
		if (chngCompName.size()>0) System.out.println("Company name changed successfully");
		else System.err.println("Failed to change company name");
		
		getDriver.quit();

	}

}
