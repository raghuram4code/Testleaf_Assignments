package week3.Assignments;

import java.time.Duration;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClothShopping implements BrowseShoppingSite {

	public void launchPage(WebDriver driver, String url) {
		// TODO Auto-generated method stub
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(600));
		//driver.switchTo().alert().dismiss();

		
	}
	
	public void searchItem(WebDriver driver,String item) {
		
		driver.findElement(By.xpath("//input[@placeholder='Search AJIO']")).sendKeys(item,Keys.ENTER);
		
		
	}

	public void selectCategory(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//label[@for='Men']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();

		
	}

	public void getItemText(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		String itemText = driver.findElement(By.xpath("//div[@class='length']")).getText();
		System.out.println(itemText);
		
		
	}

	public void printBrand(WebDriver driver) throws InterruptedException {
		//Set<WebElement> brandName = (Set<WebElement>) driver.findElements(By.xpath("//div[@class='brand']"));
		//System.out.println(brandName);
		//System.out.println(brandName.size());
		
		Thread.sleep(3000);
		
		List<WebElement> brandNameList = driver.findElements(By.xpath("//div[@class='brand']"));
		
		Set<String>  brandName = new HashSet<String>();
		Set<WebElement>  brandName1 = new HashSet<WebElement>(brandNameList);
		Map<String,String> nameMap	= new LinkedHashMap<String,String>();
		Map<WebElement,WebElement> nameMapEle	= new LinkedHashMap<WebElement,WebElement>();
		
		System.out.println("\n"+"Total  brands on page: "+brandNameList.size());
		
		System.out.println("\n"+"**********Printing Brnad names from list***************"+ "\n");
		for (WebElement element : brandNameList) {
			brandName.add(element.getText());		
			System.out.println(element.getText());
		}
		System.out.println("\n"+"Total Unique brands: "+brandName.size());	
	
		List<WebElement> bagName = driver.findElements(By.xpath("//div[@class='nameCls']"));		
		System.out.println("\n"+"===========Combined Output through list ==================="+ "\n");
		for(int i=0; i<bagName.size();i++) {
		System.out.println("******" + brandNameList.get(i).getText()+ "----->" +bagName.get(i).getText() );
		nameMap.put(brandNameList.get(i).getText(),bagName.get(i).getText());
		nameMapEle.put(brandNameList.get(i),bagName.get(i));	
		}
		
		System.out.println("\n"+"BrandNames from set "+"\n"+brandName + "\n");
		System.out.println("Output from Map in the format Brandname=Itemname " + "\n");
		System.out.println(nameMap + "\n");
		
		System.out.println("\n"+"Total Brand Names added through List string: "+brandNameList.size()+ "\n");
		System.out.println("Total Brand Names added through Map string: "+nameMap.size() + "\n");
		System.out.println("Total Brand Names added through Map WebElement: "+nameMapEle.size() + "\n");
		System.out.println("Total Brand Names added through set string: "+brandName.size() + "\n");
		//System.out.println(brandName1 + "\n");
		System.out.println("Total Brand Names added through set  through Webelement: "+brandName1.size() + "\n");
		System.out.println( "\n"+"=============Output displayed through Map==========="+ "\n");
		
		Set<Entry<WebElement, WebElement>> entrySet = nameMapEle.entrySet();
		for (Entry<WebElement, WebElement> entry : entrySet) {
			System.out.println(entry.getKey().getText()+"--->"+entry.getValue().getText());
		}
			
	}

	public void printName(WebDriver driver) {
		// TODO Auto-generated method stub
		
		List<WebElement> bagName = driver.findElements(By.xpath("//div[@class='nameCls']"));
		
		System.out.println("\n"+"No of Bags available on page "+bagName.size()+ "\n");
		
		System.out.println("\n"+"**********Printing Bag names from list***************"+ "\n");
		
		for (WebElement bagNametxt : bagName) {
			System.out.println(bagNametxt.getText());
		}
		
		
	}

}
