package Week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsAndWindows {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		String url = "https://www.irctc.co.in/";
		//String item = "Mobile";
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//getDriver.switchTo().frame(0);
		
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		System.out.println("Pressed ok button");
		
		driver.findElement(By.xpath("//span[@class='allcircle circleone']")).click();
		
		System.out.println("Launced flight link");
		
		Set<String> windowHandles = driver.getWindowHandles();
		List <String> windows = new ArrayList<>(windowHandles);
		driver.switchTo().window(windows.get(1));
		System.out.println("moved to flight window");
		
		driver.findElement(By.xpath("//button[contains(@class,'izooto-optin--cta izooto-optin--cta-later')]")).click();
		System.out.println("Dismissed notifiation");
		
		//driver.findElement(By.linkText("Contact Us")).click();
		
		
		driver.findElement(By.xpath("//a[@id='dropdown10']")).click();
		System.out.println("Selected contact us link");
			
		String flightsirctccoin = driver.findElement(By.xpath("(//a[@class='dropdown-item'])[3]")).getText();		
		
		System.out.println("Customer care email : "+flightsirctccoin);

		
		driver.switchTo().window(windows.get(0));
		driver.close();

	}

}
