package week2.day1.createlead;

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
		 
		LoginPage newLoginpage = new LoginPage();	
		Cmsfa newCmsfa = new Cmsfa();
		
		WebDriver getDriver = newLoginpage.loginDriver();	
		
		newLoginpage.loginMethod(getDriver);
		newCmsfa.crmPage(getDriver);
		getDriver.quit();	
	}
	
	
}
