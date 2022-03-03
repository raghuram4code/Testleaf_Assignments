package week2_assignments.assignment1_facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSetup {
	
	public WebDriver chromeDriver() {
		// Step 1: Download and set the path 	
		WebDriverManager.chromedriver().setup();
		
		// Step 2: Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();
		return(driver);
	}
	
	public static void main(String[] args) {
		WebDriverSetup driverSetup = new WebDriverSetup();
		WebDriver driver =  driverSetup.chromeDriver();
	}

}
