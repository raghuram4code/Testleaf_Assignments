package week2_assignments.assignment2_leaftop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DuplicateLeadEmail {
	
	public String DuplicateLeadEmail(WebDriver driver,String titleValid) {
		
		boolean validation = false;
		
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		
		// 14 Verify the title as 'Duplicate Lead'
		validation =driver.findElement(By.xpath("//div[text()='"+titleValid+"']")).isDisplayed();
		if(validation)System.out.println("I verify that title has "+titleValid);
		else System.err.println("Title does not contian " +titleValid);
		
		// 15 Click Create Lead
		driver.findElement(By.xpath("//input[@class='smallSubmit'and @value='Create Lead']")).click();
		//span[text()='First name']/following::span[@id='viewLead_firstName_sp']
		String verFirstName=driver.findElement(By.xpath("//span[text()='First name']/following::span[@id='viewLead_firstName_sp']")).getText();
		
		return verFirstName;
			
	}

	public static void main(String[] args) {
		
		String usrName = "Demosalesmanager";
		String pwd = "crmsfa";
		String url = "http://leaftaps.com/opentaps/control/login";
		String titleValid = "Duplicate Lead";
		
		LoginPage newLoginPage = new LoginPage();
		Cmsfa newCmsfa = new Cmsfa();
		NavigationPanel newNavigationPanel = new NavigationPanel();
		//CreateLead newCreateLead = new CreateLead();
		FindLeads findingLeads = new FindLeads();

		WebDriverSetup drivsetup = new WebDriverSetup();
		WebDriver getDriver = drivsetup.chromeDriver();

		newLoginPage.loginMethod(getDriver, url, usrName, pwd);
		newCmsfa.crmPage(getDriver);
		newNavigationPanel.navigatingToLead(getDriver);
		//newCreateLead.createLeadMethod(getDriver, firstname);
		
		//String curPageName=findingLeads.findingLead(getDriver,firstname);
		String findLeadFirName=findingLeads.findingLeadByEmail(getDriver);
		
		DuplicateLeadEmail objDuplicateLeadEmail= new DuplicateLeadEmail();
		String validation =objDuplicateLeadEmail.DuplicateLeadEmail(getDriver,titleValid);
	
		// 16 Confirm the duplicated lead name is same as captured name
		if (validation.equals(findLeadFirName))  {
			System.out.println("I Confirm that duplicated lead name is same as captured name");
		}
		else System.err.println("I Confirm that duplicated lead name and captured name are not same");
				
		// 17 Close the browser (Do not log out)
		getDriver.quit();
		System.err.println("End of execution");

	}

}
