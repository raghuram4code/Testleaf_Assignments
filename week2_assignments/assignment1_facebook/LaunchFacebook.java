package week2_assignments.assignment1_facebook;

import java.util.concurrent.TimeUnit;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class LaunchFacebook {
	
	public void launchFacebk(WebDriver driver, String url) {

		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get(url);
		
		// Step 4: Maximise the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(600));
	}
	
	public static void main(String[] args) {
		
		String url = "https://en-gb.facebook.com/";
		
		WebDriverSetup driverSetup = new WebDriverSetup();
		WebDriver driver =  driverSetup.chromeDriver();
		
		
		LaunchFacebook openingFbkurl= new LaunchFacebook();
		openingFbkurl.launchFacebk(driver,url);		

	}

}
