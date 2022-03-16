package Week4.day1.assignments;

import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClass {
	
	public void draggable(WebDriver driver,String url ) {
		driver.get(url);
		Actions builder = new Actions(driver);
		
		driver.switchTo().frame(0);
		WebElement element = driver.findElement(By.xpath("//div[@id='draggable']"));
		Point location = element.getLocation();
		int x = location.getX();
		int y = location.getY();
		builder.dragAndDropBy(element, x+50, y+75).perform();

	}
	public void droppable(WebDriver driver,String url) {
		driver.get(url);
		Actions builder = new Actions(driver);
		
		driver.switchTo().frame(0);
		WebElement element = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement element2 = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		builder.dragAndDrop(element, element2).perform();

	}
	public void selectable(WebDriver driver,String url) {
		// TODO Auto-generated method stub
		driver.get(url);
		Actions builder = new Actions(driver);
		
		driver.switchTo().frame(0);
		
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		builder.keyDown(Keys.CONTROL).click(item1).click(item2).click(item3).keyUp(Keys.CONTROL).perform();
	}
	
	public void sortable(WebDriver driver,String url) throws InterruptedException {
		driver.get(url);

				
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		Actions builder = new Actions(driver);
		driver.switchTo().frame(0);
		
		//Thread.sleep(3000);
		
		
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		int x1 = item1.getLocation().getX();
		int y1 = item1.getLocation().getY();
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 4']"));
		int x2 = item2.getLocation().getX();
		int y2 = item2.getLocation().getY();
		System.out.println(item1.getText());
		System.out.println(item2.getText());
		
		System.out.println(x1+","+x2+","+y1+","+y2);
		
		//WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		
		//builder.dragAndDropBy(item1,x1+100,y1+100).release().perform();

		//builder.moveByOffset(x2, y2).click(item2).perform();
		
		//builder.dragAndDrop(item1, item2).click().perform();
		
		//builder.moveToElement(item1).clickAndHold().moveByOffset(x2, y2).release().perform();
		
		builder.dragAndDropBy(item1, x2,y2).perform();

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	String url1= "https://jqueryui.com/droppable/";
	String url2= "https://jqueryui.com/draggable/";
	String url3= "https://jqueryui.com/selectable/";
	String url4= "https://jqueryui.com/sortable/";

	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	ActionClass objActionClass = new ActionClass();
	
	//objActionClass.droppable(driver, url1);
	//Thread.sleep(3000);
	//objActionClass.draggable(driver, url2);
	
	//objActionClass.selectable(driver, url3);
	objActionClass.sortable(driver, url4);
	
	}

}
