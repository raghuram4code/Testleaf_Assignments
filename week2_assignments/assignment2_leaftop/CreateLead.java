package week2_assignments.assignment2_leaftop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {
	
	public void createLeadMethod(WebDriver driver,String firstName) {	

	// 6. Click on Create Lead
	System.out.println("Clicking Creat lead link");
	driver.findElement(By.linkText("Create Lead")).click();

	// 7. Enter CompanyName Field Using id Locator
	System.out.println("Entering Company Name");
	driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf AB corporation");
	
	// 8. Enter FirstName Field Using id Locator
	System.out.println("Entering first name");
	driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
	
	// 9. Enter LastName Field Using id Locator
	System.out.println("Entering last name");
	driver.findElement(By.id("createLeadForm_lastName")).sendKeys("MyLastName");
	
	// 10. Enter FirstName(Local) Field Using id Locator
	System.out.println("Entering first name local");
	driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("MylocalFirstName");
	
	// 11. Enter Department Field Using any Locator of Your Choice
	System.out.println("Entering department field");
	driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("MyDepartment");
	
	// 12. Enter Description Field Using any Locator of your choice
	System.out.println("Entering descrition");
	driver.findElement(By.id("createLeadForm_description"))
			.sendKeys("This the description field entered for testleaf first assigment for creating lead");
	
	// 13. Enter your email in the E-mail address Field using the locator of your
	// choice
	System.out.println("Entering email address");
	driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("mytestmail@gmail.com");
	
	// 14. Select State/Province as NewYork Using Visible Text
	System.out.println("Entering postal code");
	driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("3456");
	WebElement elementDropDown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
	Select dd = new Select(elementDropDown);
	dd.selectByVisibleText("New York");
	 
	// 15. Click on Create Button
	System.out.println("Clicking create lead button");
	driver.findElement(By.className("smallSubmit")).click();

	// 16. Get the Title of Resulting Page. refer the video using driver.getTitle()
	String pageTitle = driver.getTitle();
	System.out.println(pageTitle);
	}

	public static void main(String[] args) {
		
		String usrName = "Demosalesmanager";
		String pwd = "crmsfa";
		String url = "http://leaftaps.com/opentaps/control/login"; 
		String firstname ="AssignFirstName";
		
		LoginPage newLoginPage = new LoginPage();	
		Cmsfa newCmsfa = new Cmsfa();
		CreateLead newCreateLead = new CreateLead();
		NavigationPanel newNavigationPanel = new NavigationPanel();
		
		WebDriverSetup drivsetup = new WebDriverSetup();
		WebDriver getDriver = drivsetup.chromeDriver();
		
		newLoginPage.loginMethod(getDriver, url,usrName, pwd);
		newCmsfa.crmPage(getDriver);
		newNavigationPanel.navigatingToLead(getDriver);
		newCreateLead.createLeadMethod(getDriver, firstname);
	
		getDriver.quit();
	}

}
