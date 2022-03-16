package Week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class numberofFramesLeafGround {
	
	public int checkFramesInPageSource(WebDriver driver) {
		
		String pageSource = driver.getPageSource();
		List<WebElement> frameList = new ArrayList<>();
		if(pageSource.contains("iframe")) {
			frameList = driver.findElements(By.xpath("//iframe"));
			//System.out.println(frameList);
		}
		
		return frameList.size();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url ="http://leafground.com/pages/frame.html";
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get(url);
		
		
		
	numberofFramesLeafGround obj = new numberofFramesLeafGround();
	int frameCount  = obj.checkFramesInPageSource(driver);
	//System.out.println(frameCount);
	
//		System.out.println(frameCount);
//		int tempcount =frameCount;
//		if (frameCount>0) {
//			for ( int nofframe=0; nofframe<frameCount;nofframe++) {
//			int newCount= obj.countFrames(driver.switchTo().frame(nofframe));
//			System.out.println(newCount);
//			tempcount = tempcount+newCount;
//			driver.switchTo().defaultContent();
//			}
//			
//		}
//		System.out.println(tempcount);
		
		List<WebElement> framesList = driver.findElements(By.xpath("//iframe"));
		

		//System.out.println(framesList);
		List <WebElement> finallist = new ArrayList<>(framesList);
		for (int i=0;i<framesList.size();i++) {
			driver.switchTo().frame(i);
			//System.out.println(i);
			String pageSource = driver.getPageSource();
			//System.out.println(pageSource);
			if(pageSource.contains("iframe")) {
				List<WebElement> framelist1 = driver.findElements(By.xpath("//iframe"));
				//System.out.println(framelist1);
				finallist.add(framelist1.get(0));
				driver.switchTo().frame(framelist1.get(0));
				
				 List<WebElement> findElements = driver.findElements(By.xpath("//button"));
				
				if(findElements.size()>0) {
				
				WebElement click1 = driver.findElement(By.xpath("//body/button[@id='Click1']"));
				String beforeClick1 = click1.getText();
				System.out.println("Second Click Me");
				System.out.println(beforeClick1);
				click1.click();
				String afterClick1 = click1.getText();
				System.out.println(afterClick1);
				//Finding out no of frames 
				driver.switchTo().defaultContent();
				
				}
				else
				{
					driver.switchTo().defaultContent();
				}
				
			}
			else {
				
				WebElement click = driver.findElement(By.xpath("//body/button[@id='Click']"));
				String beforeClick = click.getText();
				System.out.println("First Click Me");
				System.out.println(beforeClick);
				click.click();
				String afterClick = click.getText();
				System.out.println(afterClick);
				driver.switchTo().defaultContent();
				
				}
						
	}
		
		System.out.println("Total frames in page "+finallist.size());
		
		List <WebElement> tempList = new ArrayList<>(framesList);
		
		for (WebElement webElement : framesList) {
			driver.switchTo().frame(webElement);
			List<WebElement> framelist1 = driver.findElements(By.xpath("//iframe"));
			//System.out.println(framelist1);
			if(framelist1.size()>0) {
			for (WebElement webElement2 : framelist1) {
					tempList.add(webElement2);
					driver.switchTo().frame(webElement2);
					//driver.findElement(By.id("Click1"));
				}
			}
			driver.switchTo().defaultContent();	
		}
		System.out.println("Total frames in page "+tempList.size());
		
		driver.switchTo().defaultContent();	
		
		driver.quit();
		

	}
	

}
