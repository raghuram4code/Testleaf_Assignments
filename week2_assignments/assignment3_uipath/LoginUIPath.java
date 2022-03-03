package week2_assignments.assignment3_uipath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginUIPath {
	
	
	
	private void loggingToUIpath(WebDriver driver) {
		
		String url = "https://acme-test.uipath.com/login";
		String email= "kumar.testleaf@gmail.com", pwd ="leaf@12";
		
		// 1. Load url "https://acme-test.uipath.com/login"
		driver.get(url);
		
		// 2. Enter email as "kumar.testleaf@gmail.com"
		driver.findElement(By.id("email")).sendKeys(email);
		
		// 3. Enter Password as "leaf@12"
		driver.findElement(By.id("password")).sendKeys(pwd);
		// 4. Click login button
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		System.out.println("User logged in successfully");
		// 5. Get the title of the page and printd
		System.out.println("Current page title is "+driver.getTitle());
		// 6. Click on Log Out
	
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		System.out.println("Browser logged out successfully");
		
		// 7. Close the browser (use -driver.close())
	

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(600));

		LoginUIPath objLoginUIPath = new LoginUIPath();
		objLoginUIPath.loggingToUIpath(driver);
		
		driver.close();
		System.err.println("End of the code");

	}

}
