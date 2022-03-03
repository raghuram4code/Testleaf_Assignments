package week2_assignments.assignment1_facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateFacebookAccount {
	
	public void creatingAcct(WebDriver driver) {

		// Step 6: Click on Create New Account button
		// a[contains(text(),'Create') and @role='button']
		// driver.findElement(By.xpath("//a[contains(text(),'Create New
		// Account')]")).click();

		driver.findElement(By.linkText("Create New Account")).click();
		
	}
	

	public static void main(String[] args) {
		String url = "https://en-gb.facebook.com/";
		
		WebDriverSetup driverSetup = new WebDriverSetup();
		WebDriver driver =  driverSetup.chromeDriver();
		
		LaunchFacebook openingFbkurl= new LaunchFacebook();
		openingFbkurl.launchFacebk(driver,url);
		
		CreateFacebookAccount iamCreatingAccount = new CreateFacebookAccount();
		iamCreatingAccount.creatingAcct(driver);

	}

}
