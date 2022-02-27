package week2.day1.createlead;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditLead {
	
	public void editLeadMethod(WebDriver driver) {

		// 16. Click on edit button
		System.out.println("Editing lead ");
		driver.findElement(By.linkText("Edit")).click();

		// 17. Clear the Description Field using .clear()
		System.out.println("Clearing descrition");
		driver.findElement(By.id("updateLeadForm_description")).clear();

		// 18. Fill ImportantNote Field with Any text
		System.out.println("Updating Important Note");
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Updating important with some data");

		// 19. Click on update button
		System.out.println("Clicking Upate lead button");
		driver.findElement(By.className("smallSubmit")).click();
		// 20. Get the Title of Resulting Page. refer the video using driver.getTitle()
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);

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
		//edit lead
		EditLead newEditLead = new EditLead();
		newEditLead.editLeadMethod(getDriver);
		getDriver.quit();
	}

}
