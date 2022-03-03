package week2_assignments.assignment2_leaftop;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	
	public void deleting(WebDriver driver) {
		
		String usrName="Demosalesmanager",pwd ="crmsfa";
		String url ="http://leaftaps.com/opentaps/control/login";
		// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get(url);
		// 2 Enter the username
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(usrName);
	
		// 3 Enter the password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
		
		// 4 Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		// 5 Click crm/sfa link
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		// 6 Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		// 7 Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		// 8 Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		// 9 Enter phone number
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("1");
		
		// 10 Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		// 11 Capture lead ID of First Resulting lead
		
		WebElement firstLead= driver.findElement(By.xpath("(//div[text()='Lead ID']//following::a[@class='linktext'])[1]"));
		String firstLeadId= firstLead.getText();
			
		// 12 Click First Resulting lead
		firstLead.click();
		
		// 13 Click Delete
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		// 14 Click Find leads		
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		// 15 Enter captured lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(firstLeadId);
		
		// 16 Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		// 17 Verify message "No records to display" in the Lead List. This message
		// confirms the successful deletion
		
		String errMsg= driver.findElement(By.xpath("//div[contains(text(),'No records to display')]")).getText();
		System.out.println(errMsg);
		
		List<WebElement> errmsgElements = driver.findElements(By.xpath("//div[@class='x-paging-info']"));
		if(errmsgElements.size()>0)System.out.println("I confirm that "+firstLeadId+"is deleted");
		else System.out.println("Deletion of id "+firstLeadId+"is not successful");
		
		if(errMsg.contains("No records")) System.out.println("I confirm that "+firstLeadId+"is deleted");
		else System.out.println("Deletion of id "+firstLeadId+"is not successful");
		
		 for (int i=0;i<errmsgElements.size();i++) {
		System.out.println(errmsgElements.get(i).getText());}
		
		}
		
		
	

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(600));

		DeleteLead objDeleteLead = new DeleteLead();
		objDeleteLead.deleting(driver);
		driver.close();
		System.err.println("End of the code");

	}
	
}

