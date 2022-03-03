package week2_assignments.assignment2_leaftop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSetup {
	
	public WebDriver chromeDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		return(driver);
	}
	
	public WebDriver firefox() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(); 	
		return(driver);
	}

}
