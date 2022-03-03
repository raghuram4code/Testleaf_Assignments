package week2_assignments.assignment1_facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EnterData {
	
	public void EnteringData(WebDriver driver) {
		// Step 7: Enter the first name
		// input[@name='firstname']or //div[@class='placeholder' and text()='First
		// name']/following-sibling::input

		WebElement firstName = driver.findElement(By.name("firstname"));
		firstName.sendKeys("Sample");
		firstName.clear();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("MyFirstName");

		// Step 8: Enter the last name
		// input[@name='lastname'] or //div[text()='Surname']/following-sibling::input

		driver.findElement(By.xpath("//div[text()='Surname']/following-sibling::input")).sendKeys("MyLastName");

		// Step 9: Enter the mobile number
		// input[contains(@aria-label,'Mobile')]
		driver.findElement(By.xpath("//input[contains(@aria-label,'Mobile')]")).sendKeys("+61436422227");

		// Step 10: Enter the password
		// input[@id = 'password_step_input']
		driver.findElement(By.xpath("//input[@id = 'password_step_input']")).sendKeys("Thi$i$myP@ssword");

		// Step 11: Handle all the three drop downs
		// select[@aria-label= 'Day'] //select[@id= 'day'] //select[@aria-label=
		// 'Month'] //select[@id= 'month']//select[@aria-label= 'Year'] //select[@id=
		// 'year']
		
		WebElement elementDropDownMon = driver.findElement(By.id("month"));
		Select dMon = new Select(elementDropDownMon);
		dMon.selectByVisibleText("May");
	
		WebElement elementDropDownYear = driver.findElement(By.id("year"));
		Select dYear = new Select(elementDropDownYear);
		dYear.selectByVisibleText("1988");
		
		WebElement elementDropDownDay = driver.findElement(By.id("day"));
		Select dDay = new Select(elementDropDownDay);
		dDay.selectByVisibleText("9");

		// Step 12: Select the radio button "Female"
		// label[text()= 'Female']
		driver.findElement(By.xpath("//label[text()= 'Female']")).click();

	}

	public static void main(String[] args) {
		
		String url = "https://en-gb.facebook.com/";
		
		WebDriverSetup driverSetup = new WebDriverSetup();
		WebDriver driver =  driverSetup.chromeDriver();
		
		LaunchFacebook openingFbkurl= new LaunchFacebook();
		openingFbkurl.launchFacebk(driver,url);
		
		CreateFacebookAccount iamCreatingAccount = new CreateFacebookAccount();
		iamCreatingAccount.creatingAcct(driver);

		EnterData iamEnteringData = new EnterData();
		iamEnteringData.EnteringData(driver);
	}

}
