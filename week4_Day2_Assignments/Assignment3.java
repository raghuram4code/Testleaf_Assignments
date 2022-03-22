package Week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {
	
	public static Actions builder;

	public static String getInteger(String str) {
		// TODO Auto-generated method stub
		String patternToFind = "\\d+";

		Pattern compile = Pattern.compile(patternToFind);

		Matcher matcher = compile.matcher(str);

		while (matcher.find()) {
			System.out.println(matcher.group());
		}

		str = str.replaceAll("[\\D]", " ");
		str = str.trim();
		str = str.replaceAll("\\s+", " ");
		if (str.equals(""))
			return "0";

		return str;

	}

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		Assignment3 objAssignment3 = new Assignment3();

		String minPrice = "900", maxPrice = "1400";
		
		// 1. Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		builder = new Actions(driver);
		
		// 2. Go to MensFashion
		WebElement findMenshoeselement = driver.findElement(By.xpath("//span[@class='catText']"));
		builder.moveToElement(findMenshoeselement).perform();
		Thread.sleep(3000);
		
		// 3. Go to Sports Shoes
		WebElement sportshoesElement = driver.findElement(By.xpath("//span[@class='linkTest']")); 
		builder.moveToElement(sportshoesElement).click(sportshoesElement).perform();

		// 4. Get the count of the sports shoes
		String itemsString = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		String totalItems = getInteger(itemsString);
		System.out.println("No of sports shoes displayed are :" + totalItems);

		// 5. Click Training shoes
		// getting all the elements

		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='child-cat-name ']")); 
		for (WebElement webElement : findElements) {
			if (webElement.getText().contains("Training Shoes")) { // validating if trainging shoes is available
				webElement.click();
				break;
			}
		}
		
		// Creating an empty integeer list
		List<Integer> pricListBeforeSorting = new ArrayList(); 
		// check if show more button is available
		Thread.sleep(2000);
		WebElement showMoreButton = driver.findElement(By.id("see-more-products"));
		while (showMoreButton.isDisplayed()) {
			builder.moveToElement(showMoreButton).click().perform();
			Thread.sleep(2000);
		}

		List<WebElement> sections = driver
				.findElements(By.xpath("//section[@class='js-section clearfix dp-widget dp-fired']"));
		List<WebElement> priceElement = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		System.out.println("No of Training shoes: " + priceElement.size());
		
		for (WebElement price : priceElement) {
			pricListBeforeSorting.add(Integer
					.parseInt(price.getAttribute("display-price").replaceAll("[\\D^,]", " ").trim().replace(" ", "")));
		}
		Collections.sort(pricListBeforeSorting);
		
		// 6. Sort by Low to High
		WebElement sortButton = driver.findElement(By.xpath("//i[contains(@class,'sd-icon sd-icon-expand-arrow')]"));
		builder.moveToElement(sortButton).click().perform();
		builder.moveToElement(driver.findElement(By.xpath("(//li[@data-index='1'])[2]"))).click().perform();
		Thread.sleep(2000);
		List<Integer> lowToHighPriceList = new ArrayList(); // Creating an empty integeer list
		while (showMoreButton.isDisplayed()) {
			builder.moveToElement(showMoreButton).click().perform();
			Thread.sleep(2000);
		}
		List<WebElement> lowToHighpriceElement = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		for (WebElement price : lowToHighpriceElement) {
			lowToHighPriceList.add(Integer
					.parseInt(price.getAttribute("display-price").replaceAll("[\\D^,]", " ").trim().replace(" ", "")));
		}

		// 7. Check if the items displayed are sorted correctly
		if (lowToHighPriceList.equals(pricListBeforeSorting)) {
			System.out.println("I confirm that items were sorted from Low to High");
		} else {
			System.out.println("Items were not sorted as per price");
		}

		// 8.Select the price range (900-1200)
		WebElement minPriceElement = driver.findElement(By.name("fromVal"));
		WebElement maxPriceElement = driver.findElement(By.name("toVal"));

		String sugMinPrice = minPriceElement.getAttribute("value");
		String sugMaxPrice = maxPriceElement.getAttribute("value");
		minPriceElement.clear();
		Thread.sleep(1000);
		minPriceElement.sendKeys(minPrice);
		maxPriceElement.clear();
		Thread.sleep(1000);
		maxPriceElement.sendKeys(maxPrice, Keys.ENTER);

		System.out.println("Suggested Minimum Price :" + sugMinPrice + " & Suggested Maximum Price: " + sugMaxPrice);
		List<WebElement> priceSearchResult = driver.findElements(By.xpath("//div[contains(@class,'filter-msg')]/p"));
		if (priceSearchResult.get(0).isDisplayed()) {
			System.out.println(priceSearchResult.get(0).getText());

		} else {
			
			// 9.Filter with color Navy
			Thread.sleep(5000);
			List<WebElement> checkListElements = driver
					.findElements(By.xpath("//input[@type='checkbox']/following-sibling::label/a"));
			String selectedColour = "";
			for (int i = 0; i < checkListElements.size(); i++) {
				String text = checkListElements.get(i).getText();
				//System.out.println(text + "---------->" + i + text.contains("Navy"));
				if (text.contains("Navy")) {
					try {
						builder.moveToElement(checkListElements.get(i)).click().perform();
						selectedColour = checkListElements.get(i).getText();
						System.out.println("Selected Navy Colured Shoe");
						break;
					} catch (StaleElementReferenceException e) {
						selectedColour = checkListElements.get(1).getText();
						//System.out.println(selectedColour);
						builder.moveToElement(checkListElements.get(1)).click().perform();
						break;
					}
				}
			}
			
			Thread.sleep(2000);
			// 10 verify the all applied filters
			
				String rs = driver.findElement(By.xpath("//a[@class='clear-filter-pill']")).getText();
				if(rs.contains(minPrice)&&rs.contains(maxPrice)) {
					System.out.println("Price filter is applied");
				}
				String navy = driver.findElement(By.xpath("//a[@class='clear-filter-pill  ']")).getText();
				System.out.println("Filter colour is" + navy);
				if(navy.contains("Navy")) {
					System.out.println("Colour filter is applied");
				}
			
			// 11. Mouse Hover on first resulting Training shoes
			// 12. click QuickView button
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1500)");
			WebElement elementFirstItem = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
			WebElement elementQuickView = driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar')]"));
			builder.moveToElement(elementFirstItem).click(elementQuickView).perform();
			
			// 13. Print the cost and the discount percentage
			String costOfShoes  = driver.findElement(By.className("payBlkBig")).getText();
			String discount = driver.findElement(By.xpath("//span[text()='1,249 ']/following-sibling::span")).getText();
			System.out.println("Price of Selected shoe is "+costOfShoes+"And Discount is  "+discount);
			
			// 14. Take the snapshot of the shoes.			
			File screenShot = driver.getScreenshotAs(OutputType.FILE);
			File shoeImage = new File("./snaps/shoeImage.jpg");
			FileUtils.copyFile(screenShot, shoeImage);
			
			// 15. Close the current window
			driver.findElement(By.xpath("//div[contains(@class,'close close1')]")).click();
			Thread.sleep(1000);
			
			// 16. Close the main window
			driver.close();

		}

	}

}
