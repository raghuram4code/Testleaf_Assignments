package week2.day1.createlead;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DuplicateLead {
	
	private void methodDuplicateLead(WebDriver driver) {
		
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
		//loginpage
		LoginPage newLoginPage = new LoginPage();
		WebDriver getDriver = newLoginPage.loginDriver();
		newLoginPage.loginMethod(getDriver);
		
		//cmsfa link
		Cmsfa newcmsfa = new Cmsfa();
		newcmsfa.crmPage(getDriver);
		
		//create lead
		CreateLead newCreateLead = new CreateLead();
		newCreateLead.createLeadMethod(getDriver);
		
		//duplicate lead
		DuplicateLead newDuplicateLead = new DuplicateLead();
		newDuplicateLead.methodDuplicateLead(getDriver);
		getDriver.quit();
	}

}
