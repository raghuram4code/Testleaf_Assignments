package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {

		// importing chromedriver setup
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
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

		// 4. Click on CRM/SFA Link
		System.out.println("Clicking CRM/SFA Link");
		driver.findElement(By.linkText("CRM/SFA")).click();

		// 5. Click on Leads Button
		System.out.println("Navigating to leads Tab");
		driver.findElement(By.linkText("Leads")).click();

		// 6. Click on Create Lead
		System.out.println("Clicking Creat lead link");
		driver.findElement(By.linkText("Create Lead")).click();

		// 7. Enter CompanyName Field Using id Locator
		System.out.println("Entering Company Name");
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf AB corporation");
		
		// 8. Enter FirstName Field Using id Locator
		System.out.println("Entering first name");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("MyFirstName");
		
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

}
