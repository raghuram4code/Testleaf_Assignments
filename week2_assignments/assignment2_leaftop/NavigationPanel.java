package week2_assignments.assignment2_leaftop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPanel {
	
	public void navigatingToLead(WebDriver driver) {
		
		// 5. Click on Leads Button
		System.out.println("Navigating to leads Tab");
		driver.findElement(By.linkText("Leads")).click();
	}
	private void navigatingToContacts(WebDriver driver) {
		// TODO Auto-generated method stub

	}

}
