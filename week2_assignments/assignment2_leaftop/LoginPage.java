package week2_assignments.assignment2_leaftop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	
	public void loginMethod(WebDriver driver,String url,String usrName,  String pwd) {
		
		// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		System.out.println("Launching leaftaps application");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(600));

		// 2. Enter UserName and Password Using Id Locator
		System.out.println("Entering userName and password into webapplication");
		driver.findElement(By.id("username")).sendKeys(usrName);
		driver.findElement(By.id("password")).sendKeys(pwd);

		// 3. Click on Login Button using Class Locator
		System.out.println("Clicking login button");
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	public static void main(String[] args) {
		
		String usrName = "Demosalesmanager";
		String pwd = "crmsfa";
		String url = "http://leaftaps.com/opentaps/control/login";
		
		
		
		WebDriverSetup drivsetup = new WebDriverSetup();
		WebDriver getDriver = drivsetup.chromeDriver();
		LoginPage newLoginPage = new LoginPage();
		newLoginPage.loginMethod(getDriver, url,usrName, pwd);
		
		getDriver.quit();
		
	}

}
