package Week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPrice {
	
	public void openURL(WebDriver driver, String url) {
		// TODO Auto-generated method stub
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

	}
	
	public String searchItemAmazon(WebDriver driver,String item) {
		// TODO Auto-generated method stub
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(item,Keys.ENTER);
		String text ="";
		
		System.out.println("\n *********************** From search item method *******************************");
		String firstElementReview = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']")).getText();
		//System.out.println(firstElementReview);
		
		String mrp1 = driver.findElement(By.xpath("(//span[@data-a-size='b']//span)[2]")).getText();
		
		String mrp  = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println(" MRP is:" +mrp );
		System.out.println("Price displayed");
		//String  totalReviews= driver.findElement(By.xpath("//a[@id='acrCustomerReviewLink']//span")).getText();
		System.out.println("Total Ratings for this phone " + firstElementReview );
		
		driver.findElement(By.xpath("//i[@class='a-icon a-icon-popover']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5, 0));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'a-icon-row a-spacing-small')]")));
		
		WebElement tabledata = driver.findElement(By.xpath("//table[@id='histogramTable']"));
		
		List<WebElement> firstrow = tabledata.findElements(By.tagName("tr"));
		List<WebElement> firstrowdata = firstrow.get(0).findElements(By.tagName("td"));
		
//		System.out.println(firstrowdata);
		String text2 = firstrowdata.get(2).getText();
		
		System.out.println(text2+" of ratings have 5 stars") ;
		
		
		 List<WebElement> findElements = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		for (WebElement element : findElements) {
			 text =element.getText();
			if(text.contains("OnePlus")) {
				element.click();
				break;
		}
		}
		System.out.println("First oneplus is "+ text);
		
		return mrp;
		
	}
	
	
	public void getPrice(WebDriver driver,String firstPhoneCost) {
		
		//System.out.println("I am in getprice class");
		System.out.println("\n *********************** From get Price method *******************************");
		
		String mrpWOSymbol="";
		Set<String> windowHandles = driver.getWindowHandles();
		List <String> windows = new ArrayList<>(windowHandles);
		driver.switchTo().window(windows.get(1));
		//System.out.println(windows);
		
		String mrp = driver.findElement(By.xpath("//div[@id='corePrice_desktop']/div[1]/table[1]/tbody[1]/tr[2]/td[2]/span[1]/span[2]")).getText();
		//String text = driver.findElement(By.xpath("(//span[@data-a-size='b']//span)[4]")).getText();
		//String discount =driver.findElement(By.xpath("(//span[@data-a-size='b']//span)[6]")).getText();		
		//driver.findElement(By.xpath("//i[@class='a-icon a-accordion-radio a-icon-radio-inactive']")).click();
		
		for(int i=1; i<mrp.length();i++)
			mrpWOSymbol = mrpWOSymbol+mrp.charAt(i);
		System.out.println(" MRP is:" +mrpWOSymbol );
		System.out.println("Price displayed");
		String  totalReviews= driver.findElement(By.xpath("//a[@id='acrCustomerReviewLink']//span")).getText();
		System.out.println("Total Ratings for this phone " + totalReviews );
		
		//String firstElementReview = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']")).getText();
		
		WebElement findElement = driver.findElement(By.xpath("//a[@class='a-popover-trigger a-declarative']"));
		findElement.click();
		
		Actions builder = new Actions(driver);
		builder.moveToElement(findElement).clickAndHold(findElement).perform();
		
			
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5, 0));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'a-icon-row a-spacing-small')]")));
		
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(null));
		
		System.out.println("Frame displayed");
		
		//WebElement frame =driver.findElement(By.xpath("//div[contains(@class,'a-icon-row a-spacing-small')]"));
		//driver.switchTo().frame(frame);
		
		//String starPercentage = driver.findElement(By.xpath("//table[@id='histogramTable']//a")).getText();
		//String attribute = driver.findElement(By.xpath("//table[@id='histogramTable']//a")).getAttribute("title");
		
		WebElement tabledata = driver.findElement(By.xpath("(//table[@id='histogramTable']/following::table)[4]"));
//		System.out.println(tabledata);
		
//		WebElement popoverelement = driver.findElement(By.className("a-popover-inner"));
//		//div[@class='a-popover-wrapper']//div
//		System.out.println(popoverelement);
//		
//		List<WebElement> tabledetails = popoverelement.findElements(By.id("histogramTable"));
//		System.out.println(tabledetails);
		
		List<WebElement> firstrow = tabledata.findElements(By.tagName("tr"));
 //       System.out.println(firstrow);
//		for (int i=0; i<firstrow.size();i++) {
//			System.out.println(firstrow.get(i).getText());
//		}
		
		List<WebElement> firstrowdata = firstrow.get(0).findElements(By.tagName("td"));
//		System.out.println(firstrowdata);
		String text2 = firstrowdata.get(2).getText();
//		
//		//String star = driver.findElement(By.xpath("(//a[contains(@title,'reviews have 5 stars')]//div)[3]")).getText();
		System.out.println(text2+" of ratings have 5 stars") ;
		System.out.println("captrured rating percentage");
		
		builder.release().perform();
		
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.id("attach-close_sideSheet-link")).click();
		driver.findElement(By.id("nav-cart-count")).click();
		String cartPrice = driver.findElement(By.xpath("(//span[contains(@class,'a-color-price sc-price-container')]//span)[3]")).getText().trim();
		System.out.println("CartPrice is : "+cartPrice);
		
		if(mrpWOSymbol.equals(cartPrice)) {
			System.out.println("Order successfully moved to cart");
		}
		else{
			System.out.println("wrong order moved to cart");
		}
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "https://www.amazon.in/";
		String searchItem ="oneplus 9 pro";
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		AmazonPrice objAmazonPrice = new AmazonPrice();
		
		objAmazonPrice.openURL(driver,url);
		String firstPhoneCost =objAmazonPrice.searchItemAmazon(driver, searchItem);
		objAmazonPrice.getPrice(driver,firstPhoneCost);
		
		driver.quit();

	}

}
