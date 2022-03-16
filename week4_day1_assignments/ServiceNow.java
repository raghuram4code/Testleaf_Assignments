package Week4.day1.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {
	
	private void serviceNowLogin(WebDriver driver, String url) {
		driver.get(url);
		System.out.println("Step1: Load ServiceNow application URL ");
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame);
		
		
		WebElement elementeUsername = driver.findElement(By.xpath("//input[@name='user_name']"));
		elementeUsername.sendKeys("admin");
		System.out.println("Step2: Enter username");
		 
		WebElement elementPassword = driver.findElement(By.xpath("//input[@name='user_password']"));
		elementPassword.sendKeys("Smile#01");
		System.out.println("Step3: Enter password");
		
		driver.findElement(By.xpath("//div/button[@type='submit']")).click();
		System.out.println("Step4: Click Login");

	}
	
	public void searchIncident(WebDriver driver) {
		
		
		driver.findElement(By.id("filter")).sendKeys("incident");
		System.out.println("Step5: Search “incident “ Filter Navigator");
		
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		System.out.println("Step6: Click All");

	}
	
	private void clickNewIncident(WebDriver driver) {
		
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame1);
		
		driver.findElement(By.id("sysverb_new")).click();
		System.out.println("Step7:Click New button");

	}
	
	public String enterCaller(WebDriver driver,String name) throws InterruptedException {
		
		driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
		
		System.out.println("Step8: Select a value for Caller and Enter value for short_description");
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handleList = new ArrayList<>(windowHandles);
		
		driver.switchTo().window(handleList.get(1));
		
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(name,Keys.ENTER);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("sys_user_table_header_search_control")));
		driver.findElement(By.id("sys_user_table_header_search_control")).sendKeys(name,Keys.ENTER);
		
		Thread.sleep(3000);
		
		WebElement table = driver.findElement(By.className("list2_body"));
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		//System.out.println(rows);
		//System.out.println(rows.get(0));
		List<WebElement> tddata = rows.get(0).findElements(By.tagName("td"));
		
		if(tddata.size()>1) {		
			
		WebElement text1 = tddata.get(2).findElement(By.tagName("a"));
		  String text = tddata.get(3).getText();
		System.out.println(text);
			
		if(text.equals(name)) {
			text1.click();	
			driver.switchTo().window(handleList.get(0));
			
		}
		}else
		{
			driver.findElement(By.id("sysverb_new")).click();
			driver.findElement(By.id("sys_user.first_name")).sendKeys("MyFirstName");
			driver.findElement(By.id("sys_user.last_name")).sendKeys("MyLastName");
			driver.findElement(By.id("sys_user.title")).sendKeys("MR");
			driver.findElement(By.id("sys_user.email")).sendKeys("firstName.lastName@gmail.com");
			driver.findElement(By.id("sysverb_insert_bottom")).click();
			//button[@id='sysverb_insert_bottom']
			driver.switchTo().window(handleList.get(0));
		}
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.id("incident.short_description")).sendKeys("This is a short description");
		String incidentnumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("Step9: Read the incident number and save it a variable");
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		System.out.println("Step10: Click on Submit button");
		System.out.println(incidentnumber+ " is the incident number");
		
		
		return incidentnumber;
	

	}
	
	public void verifyIncident(WebDriver driver,String incidentNumber) {
		// TODO Auto-generated method stub
		//WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		//driver.switchTo().frame(frame1);
		
		WebElement SelectNumber = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select dd = new Select(SelectNumber);
		dd.selectByVisibleText("Number");
		WebElement searchNumber = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		searchNumber.sendKeys(incidentNumber,Keys.ENTER);
		 
			WebElement table = driver.findElement(By.className("list2_body"));
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			List<WebElement> tddata = rows.get(0).findElements(By.tagName("td"));
			
			if(tddata.size()>1) {		
				
			String text1 = tddata.get(2).findElement(By.tagName("a")).getText();
			  
			System.out.println(text1+" is searched ");
			if (incidentNumber.equals(text1)) {
				System.out.println(incidentNumber+" created successfully");
			}
			else
			{
			
					System.out.println(text1+"is different from "+incidentNumber );
	
			}
			}
			

	}
	

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		WebDriverManager.chromedriver().setup(); //Setting chrome driver
		ChromeDriver driver = new ChromeDriver(); //instantiating chromedriver object
		driver.manage().window().maximize(); // maximizing window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));//implicit wait
		String url ="https://dev27644.service-now.com";
		String name ="MyFirstName";
		ServiceNow objServiceNow = new ServiceNow();
		
		objServiceNow.serviceNowLogin(driver, url);
		objServiceNow.searchIncident(driver);
		objServiceNow.clickNewIncident(driver);
		String incindentNumber = objServiceNow.enterCaller(driver, name);
		//objServiceNow.searchIncident(driver);
		objServiceNow.verifyIncident(driver, incindentNumber);
		
		File screenShot = driver.getScreenshotAs(OutputType.FILE);
		File image = new File("./snaps/img001.jpg");
		FileUtils.copyFile(screenShot, image);
		
	
	}

}
