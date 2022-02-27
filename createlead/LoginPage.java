package week2.day1.createlead;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	
	public WebDriver loginDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		return(driver);
	}
	
	public void loginMethod(WebDriver driver) {
	
		String usrName = "Demosalesmanager";
		String pwd = "crmsfa";

		// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		System.out.println("Launching leaftaps application");
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		// 2. Enter UserName and Password Using Id Locator
		System.out.println("Entering userName and password into webapplication");
		driver.findElement(By.id("username")).sendKeys(usrName);
		driver.findElement(By.id("password")).sendKeys(pwd);

		// 3. Click on Login Button using Class Locator
		System.out.println("Clicking login button");
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	public static void main(String[] args) {
		
		LoginPage newLoginpage = new LoginPage();
		WebDriver getDriver = newLoginpage.loginDriver();
		newLoginpage.loginMethod(getDriver);
		getDriver.quit();
		
	}

}
