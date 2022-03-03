package week2_assignments.assignment2_leaftop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DuplicateLead {
	
	public void methodDuplicateLead(WebDriver driver) {
		
		// 17. Click on Duplicate button "Duplicate Lead"
		System.out.println("Creating Duplicate Lead");
		driver.findElement(By.linkText("Duplicate Lead")).click();

		// 18. Clear the CompanyName Field using .clear() And Enter new CompanyName
		System.out.println("clearing existing Company Name and givingother name");
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("MyTestleaf AB corporation");

		// 19.Clear the FirstName Field using .clear() And Enter new FirstName
		System.out.println("clearing first name, last name and entering another name");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("MyOtherFirstName");
		driver.findElement(By.id("createLeadForm_lastName")).clear();
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("MyOtherLastName");

		// 20.Click on Create Lead Button
		System.out.println("Clicking create lead button");
		driver.findElement(By.className("smallSubmit")).click();
		// 21. Get the Title of Resulting Page(refer the video) using driver.getTitle()
		String pageTitleDuplicate = driver.getTitle();
		System.out.println(pageTitleDuplicate);
	}
	
	public static void main(String[] args) {
		
		String usrName = "Demosalesmanager";
		String pwd = "crmsfa";
		String url = "http://leaftaps.com/opentaps/control/login"; 
		String firstname ="MyFirstName";
		
		//loginpage
		LoginPage newLoginPage = new LoginPage();
		WebDriverSetup drivsetup = new WebDriverSetup();
		WebDriver getDriver = drivsetup.chromeDriver();
		newLoginPage.loginMethod(getDriver, url,usrName, pwd);
		
		//cmsfa link
		Cmsfa newcmsfa = new Cmsfa();
		newcmsfa.crmPage(getDriver);
		
		//Navigating to Leads 
		NavigationPanel newNavigationPanel = new NavigationPanel();
		newNavigationPanel.navigatingToLead(getDriver);
		
		//create lead
		CreateLead newCreateLead = new CreateLead();
		newCreateLead.createLeadMethod(getDriver, firstname);
		
		
		//duplicate lead
		DuplicateLead newDuplicateLead = new DuplicateLead();
		newDuplicateLead.methodDuplicateLead(getDriver);
		
		getDriver.quit();

	}

}
