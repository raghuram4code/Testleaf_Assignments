package Week4.day2.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {
	
	public void resizable(WebDriver driver, String url) {
		// TODO Auto-generated method stub
		driver.get(url);
		System.out.println("Launched URL");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		WebElement frame1 = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame1);
		
		System.out.println("Moved into frame");
		
		WebElement clickElement = driver.findElement(By.xpath("//div[contains(@class,'ui-resizable-handle ui-resizable-se')]"));
		
		Actions builder = new Actions(driver);
		
		
		Point location = clickElement.getLocation();
		int x = location.getX();
		int y = location.getY();
		builder.moveToElement(clickElement).clickAndHold().moveByOffset(x+5, y+5).release().perform();
		System.out.println("Dragged the box by 5 pixles");
		
		driver.switchTo().defaultContent();
		
		
		

	}
	
	public void drag(WebDriver driver, String url) {
		
		driver.get(url);
		System.out.println("Launched URL");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions builder = new Actions(driver);
		
		WebElement dragMeAround = driver.findElement(By.id("draggable"));
			
		Point location = dragMeAround.getLocation();
		int x = location.getX();
		int y = location.getY();
		
		System.out.println("element location "+ location+" "+ x+", " + y);
		
		builder.dragAndDropBy(dragMeAround, 0, y+3).perform();
		System.out.println("Dragged box by 5 pixels");
		
	

	}
	
	public void drop(WebDriver driver, String url) {
		// TODO Auto-generated method stub
		
		driver.get(url);
		System.out.println("Launched URL");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions builder = new Actions(driver);
		
		WebElement dragElement = driver.findElement(By.id("draggable"));
		WebElement dropElement = driver.findElement(By.id("droppable"));
			
		Point locationdrag = dragElement.getLocation();
		int xdrag = locationdrag.getX();
		int ydrag = locationdrag.getY();
		
		Point locationdrop = dropElement.getLocation();
		int xdrop = locationdrag.getX();
		int ydrop = locationdrag.getY();
		
		System.out.println("second element location "+ locationdrop+" "+ xdrop+", " + ydrop);
		
		builder.dragAndDrop(dragElement, dropElement).perform();
		System.out.println("Dragged box and dropped into other box");
		


	}
	
	public void selectable(WebDriver driver, String url) {
		
		driver.get(url);
		System.out.println("Launched URL");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> itemElements = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		
		Actions builder = new Actions(driver);
		
		for(int i=0;i<itemElements.size();i++) {
			if (i%2==0) {
				builder.keyDown(Keys.CONTROL).click(itemElements.get(i)).perform();
			}
			
		}
		System.out.println("Selectd odd items");
	

	}
	
	public void sortable(WebDriver driver, String url) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver.get(url);
		System.out.println("Launched URL");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		Actions builder = new Actions(driver);
				
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
		
		Thread.sleep(3000);
			
		builder.dragAndDropBy(item1, 0, y2).perform();
	}

	public static void main(String[] args) throws InterruptedException {
		
		
		String urlResizable ="https://jqueryui.com/resizable";
		String urlDrag ="http://www.leafground.com/pages/drag.html";
		String urlDrop ="http://www.leafground.com/pages/drop.html";
		String urlSelectable ="http://www.leafground.com/pages/selectable.html";
		String urlSortable ="http://www.leafground.com/pages/sortable.html";
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		Assignment1 objAssignment1 = new Assignment1();
		
		objAssignment1.resizable(driver, urlResizable);
		//Thread.sleep(3000);
		objAssignment1.drag(driver, urlDrag);
		objAssignment1.drop(driver, urlDrop);
		objAssignment1.selectable(driver, urlSelectable);
		objAssignment1.sortable(driver, urlSortable);
		
		driver.close();

	}

}
