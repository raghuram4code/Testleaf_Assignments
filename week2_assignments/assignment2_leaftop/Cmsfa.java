package week2_assignments.assignment2_leaftop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cmsfa {
	

	public void crmPage(WebDriver driver) {
		System.out.println("Clicking CRM/SFA Link");
		driver.findElement(By.linkText("CRM/SFA")).click();
		}
	
	public static void main(String[] args) {
		
		String usrName = "Demosalesmanager";
		String pwd = "crmsfa";
		String url = "http://leaftaps.com/opentaps/control/login"; 
		LoginPage newLoginPage = new LoginPage();	
		Cmsfa newCmsfa = new Cmsfa();
		
		WebDriverSetup drivsetup = new WebDriverSetup();
		WebDriver getDriver = drivsetup.chromeDriver();	
		
		newLoginPage.loginMethod(getDriver, url,usrName, pwd);
		newCmsfa.crmPage(getDriver);
		getDriver.quit();
	}
	
	
}
