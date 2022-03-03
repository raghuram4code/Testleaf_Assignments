package week2_assignments.assignment2_leaftop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindLeads {

	public String findingLead(WebDriver driver,String chkname) {
				
		// * 7 Click Find leads //a [@class ='selected']
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		// * 8 Enter first name (//label [text()='First name:'])[3]/following::input[@name='lastName']
		driver.findElement(By.xpath("(//label [text()='First name:'])[3]/following::input[@name='firstName']")).sendKeys(chkname);
		
		// * 9 Click Find leads button //button[@class='x-btn-text' and contains(text(),'Find')]
		driver.findElement(By.xpath("//button[@class='x-btn-text' and contains(text(),'Find')]")).click();
		
		// * 10 Click on first resulting lead 
		
		//((//a[contains(text(),'"+chkname+"')])[1]/preceding::a[@class='linktext'])[4]
		//(//div[text()='Lead ID']//following::a[@class='linktext'])[1]
		driver.findElement(By.xpath("(//div[text()='Lead ID']//following::a[@class='linktext'])[1]")).click();
		//driver.findElement(By.xpath("((//a[contains(text(),'"+chkname+"')])[1]/preceding::a[@class='linktext'])[4]")).click();
		
		// * 11 Verify title of the page
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		return pageTitle;
	}
	
	public String findingLeadByEmail(WebDriver driver) {

		// 7 Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		// 8 Click on Email //span[text()='Email']
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		
		// 9 Enter Email
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("mytestmail@gmail.com");
		
		// 10 Click find leads button
		driver.findElement(By.xpath("//button[@class='x-btn-text' and contains(text(),'Find')]")).click();
		
		// 11 Capture name of First Resulting lead
		String capFirstName=driver.findElement(By.xpath("(//div[text()='Lead ID']//following::a[@class='linktext'])[3]")).getText();
		System.out.println(capFirstName);
		
		// 12 Click First Resulting lead
		driver.findElement(By.xpath("(//div[text()='Lead ID']//following::a[@class='linktext'])[1]")).click();
		System.out.println("Clicked first id ");
		
		return capFirstName;
	}

	public static void main(String[] args) {
		String usrName = "Demosalesmanager";
		String pwd = "crmsfa";
		String url = "http://leaftaps.com/opentaps/control/login";
		String firstname ="AssignFirstName";
		String leadSearchPage= "View Lead | opentaps CRM";
		
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
		
		String curPageName=findingLeads.findingLead(getDriver,firstname);
		String findLeadFirName=findingLeads.findingLeadByEmail(getDriver);
		
		System.out.println(leadSearchPage);
		
		if (curPageName.equals(leadSearchPage) ) {
			System.out.println("Navigated to Right page");
		}
		else System.err.println("Navigation failed");
		
		System.out.println(findLeadFirName);
		System.err.println("End of project");
		
		//getDriver.quit();
	}

}
