package Week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Step1: Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		
		//Step2: Mouseover on Brands and Search L'Oreal Paris
		
		WebElement brand = driver.findElement(By.xpath("//a[contains(text(),'brands')]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brand).perform();			
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		
		//Step3:  Click L'Oreal Paris
		driver.findElement(By.partialLinkText("L'Oreal Paris")).click();

		 //Step 4: Check the title contains L'Oreal Paris(Hint-GetTitle)
		String pageTitle = driver.getTitle();
		if(pageTitle.contains("L'Oreal Paris")){
			System.out.println("I checked that page moved to L'Oreal Paris");
		}
		
		
		
		//step 5: Click sort By and select customer top rated
		driver.findElement(By.className("sort-name")).click();
		//driver.findElement(By.xpath("//div[@id='filter-sort']//child::button")).click();
		driver.findElement(By.xpath("(//div[@class='control-indicator radio '])[3]")).click();
		//driver.findElement(By.xpath("//span[contains(text(),'customer top rated')]")).click();
		
		
		//Step 6: Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[contains(text(),'Category')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[contains(text(),'Hair')])[1]")).click();	//hair	
		driver.findElement(By.xpath("(//span[contains(text(),'Hair')])[2]")).click();// haircare click
		driver.findElement(By.xpath("(//span[contains(text(),'Shampoo')])")).click(); //Shampoo
		
		//Step7: Click->Concern->Color Protection
		driver.findElement(By.xpath("(//span[contains(text(),'Concern')])")).click(); //Concern
		driver.findElement(By.xpath("//span[contains(text(),'Color Protection')]")).click(); //Colorprotection
		Thread.sleep(5000);
		
		//Step8: check whether the Filter is applied with Shampoo
		String filtertext = driver.findElement(By.xpath("//span[@class='filter-value']")).getText();
		System.out.println(filtertext);
		if(filtertext.contains("Shampoo")) {
			System.out.println("I confirm that Shampoo filter is applied");
		}
		else {
			System.out.println("Shampoo filter is not appplied");
		}
		
		//Step9: Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("(//div[@class='css-xrzmfa'])[1]")).click();

		//Step 10: GO to the new window and select size as 175ml
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allWindowList = new ArrayList<String>();

		allWindowList.addAll(allWindows);
		String newWindow = allWindowList.get(1);
		driver.switchTo().window(newWindow);

		WebElement selectSIZE = driver.findElement(By.tagName("select"));
		Select dd = new Select(selectSIZE);
		dd.selectByIndex(0);
		
		//Step11: Print the MRP of the product
		String priceShampoo = (driver
				.findElement(By.xpath("(//span[contains(text(),'MRP:')]/following-sibling::span)[1]")).getText()).replaceAll("[\\D]", "").trim();
		System.out.println("The shampoo price is:" + priceShampoo);
		
		//Step12: Click on ADD to BAG
		driver.findElement(By.xpath("(//span[contains(text(),'ADD TO BAG')])[1]")).click();
		//Step13: Go to Shopping Bag 
		driver.findElement(By.xpath("//div[@class='css-0 e1ewpqpu1']")).click();

		// Step 14: Print the Grand Total amount
		Thread.sleep(5000);		
		WebElement cartFrame =driver.findElement(By.xpath("//iframe[contains(@class,'css')]"));
		driver.switchTo().frame(cartFrame);
		String totalAmount = (driver.findElement(By.xpath("(//div[@class='value'])[4]")).getText()).replaceAll("[\\D]", "").trim();
		System.out.println("Grand Total is:"+ totalAmount);

		// Step15: Click Proceed
		driver.findElement(By.xpath("//span[contains(text(),'PROCEED')]")).click();
		driver.switchTo().defaultContent();
		
		//Step16: click on Continue as Guest
		driver.findElement(By.xpath("//button[contains(text(),'CONTINUE AS GUEST')]")).click();
		
		//Step17: Check if Grant total is same in step 14
		String secondGrandTotal = driver.findElement(By.xpath("(//div[@class='value']/span)[2]")).getText();		
		System.out.println("Final cart price is: "+secondGrandTotal);		
		if (totalAmount.equals(secondGrandTotal)) {
			System.out.println("Price is matching");
		}
		else {
			System.out.println("Price is not matching");
		}
		
		//Step 18: close all Windows
		driver.quit();
	}

}