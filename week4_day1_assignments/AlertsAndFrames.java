package Week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsAndFrames {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver getDriver = new ChromeDriver();
		String url = "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt";
		//String item = "Mobile";
		
		getDriver.get(url);
		getDriver.manage().window().maximize();
		getDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//getDriver.switchTo().frame(0);
		
		WebElement frameElement = getDriver.findElement(By.id("iframeResult"));
		getDriver.switchTo().frame(frameElement);
		System.out.println("I am on iframe now now");	
		
		getDriver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		Alert alert = getDriver.switchTo().alert();
		alert.sendKeys("Raghuram");
		System.out.println("Entered Text to alert succesfully");	
		alert.accept();
		
		String text = getDriver.findElement(By.id("demo")).getText();
		
		if (text.contains("Raghuram")) {
			System.out.println("Response have the text I have entered");
		}
		else
		{
			System.out.println("Response does not have the text I have entered");
		}
		
		getDriver.switchTo().defaultContent();
		System.out.println("I am on main page now");		
		
		getDriver.quit();
	}

}
