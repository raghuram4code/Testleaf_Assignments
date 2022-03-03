package week2_assignments.assignment2_leaftop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateConnect {
	
	public void creatingcontact(WebDriver driver) {
		
		String usrName="Demosalesmanager",pwd ="crmsfa";
		String url ="http://leaftaps.com/opentaps/control/login";
		// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get(url);
		
		// 2. Enter UserName and Password Using Id Locator
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(usrName);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
		
		// 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
		// 4. Click on CRM/SFA Link
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		// 5. Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		// 6. Click on Create Contact
		driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
		
		// 7. Enter FirstName Field Using id Locator
		driver.findElement(By.xpath("//input[@id='firstNameField']")).sendKeys("myfirstname");
		
		// 8. Enter LastName Field Using id Locator
		driver.findElement(By.xpath("//input[@id='lastNameField']")).sendKeys("myLastname");
		
		// 9. Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Firstlocalname");
		
		// 10. Enter LastName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Lastlocalname");
		
		// 11. Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.xpath("//input[@name='departmentName']")).sendKeys("Mydepartment");
		
		// 12. Enter Description Field Using any Locator of your choice
		driver.findElement(By.name("description")).sendKeys("Some description");
		
		// 13. Enter your email in the E-mail address Field using the locator of your
		// choice
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("sampl@email.com");
		
		// 14. Select State/Province as NewYork Using Visible Text
		WebElement dropdown = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dd = new Select(dropdown);
		dd.selectByVisibleText("New York");
		
		// 15. Click on Create Contact
		driver.findElement(By.className("smallSubmit")).click();
		
		// 16. Click on edit button
		driver.findElement(By.linkText("Edit")).click();
		// 17. Clear the Description Field using .clear
		driver.findElement(By.xpath("//textarea[@name='description']")).clear();
		// 18. Fill ImportantNote Field with Any text
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("some importane note");
		
		// 19. Click on update button using Xpath locator
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		// 20. Get the Title of Resulting Page.         
		System.out.println("The page title is "+driver.getTitle());
	}

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(600));

		CreateConnect objCreateConnect = new CreateConnect();
		objCreateConnect.creatingcontact(driver);
		System.out.println("Successfully created contact");
		driver.close();
		System.err.println("End of the code");
	}
}
