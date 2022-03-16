package Week4.day1.assignments;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import week2_assignments.assignment2_leaftop.*;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		
		
		String usrName = "Demosalesmanager";
		String pwd = "crmsfa";
		String url = "http://leaftaps.com/opentaps/control/login";
		
		
		
		WebDriverSetup drivsetup = new WebDriverSetup();
		WebDriver driver = drivsetup.chromeDriver();
		LoginPage newLoginPage = new LoginPage();
		Cmsfa newCmsfa = new Cmsfa();
		
		newLoginPage.loginMethod(driver, url,usrName, pwd);
		newCmsfa.crmPage(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(600));
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlelist = new ArrayList<>(windowHandles);	
		
		driver.switchTo().window(windowHandlelist.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("first");
		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[text()='Contact ID']//following::a[@class='linktext'])[1]")).click();
		driver.switchTo().window(windowHandlelist.get(0));
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		windowHandles.addAll(driver.getWindowHandles());
		List<String> windowHandlelist2 = new ArrayList<>(windowHandles);
		System.out.println(windowHandles);

		driver.switchTo().window(windowHandlelist2.get(2));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("first");
		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[text()='Contact ID']//following::a[@class='linktext'])[6]")).click();
		driver.switchTo().window(windowHandlelist.get(0));
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		String title = driver.getTitle();
		System.out.println(title);
		if (title.contains("View")) {
			System.out.println("Merge is successful");
		}
		else
		{
			System.out.println("Some issue with Merge");
		}
		
		driver.quit();
		
		
	}

}
