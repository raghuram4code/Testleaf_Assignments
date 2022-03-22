package Week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5 {
	
	public void disappear(WebDriver driver, String url) {
		
		driver.get(url);
		
		if(driver.findElement(By.id("btn")).isDisplayed()) {
			System.out.println("Button is displayed");
		}
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("btn")));
		try {
			driver.findElement(By.id("btn")).click();
			
		}catch(Exception  e){
			
			System.out.println("Button got disappeared. And I confirm that i learnt something new today");
			System.out.println(driver.findElement(By.tagName("strong")).getText());
			
		}

	}
	
	public void appear(WebDriver driver, String url) {
	
		 driver.get(url);
		 String missedBtnTxt="";
		 boolean flag = false;
		
		List<WebElement> findElements = driver.findElements(By.tagName("button"));
		int sizeOfFindElements = findElements.size();
		System.out.println(sizeOfFindElements);
		
		System.out.println("Displayed buttons are:");
		
		for (int i=0;i<sizeOfFindElements;i++) {
			
			String buttonText= findElements.get(i).getText();
			if(buttonText.isEmpty()) {
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("btn")));
				 missedBtnTxt= findElements.get(i).getText();
				 System.out.println(missedBtnTxt);
				 flag =true;
				 
			}
			else {
				System.out.println(buttonText);
			}

		}
		
		if (flag){
		System.out.println("Missed button is appeared and its text is "+missedBtnTxt);
		}
	
	}
	
	public void textChange(WebDriver driver, String url) {
		// TODO Auto-generated method stub
		
		 driver.get(url);
				 
		 String buttonString = driver.findElement(By.id("btn")).getText();
		 System.out.println("Current text of button is "+buttonString );
		 
		 if(!buttonString.contains("Click")) {
			 
			 System.out.println("Waiting for text to change" );
			 
			 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			 wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(By.id("btn"), buttonString)));
			 buttonString = driver.findElement(By.id("btn")).getText();
			 
			 System.out.println("Changed Text of button is "+buttonString );
		 }
		 

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String urlDisapper ="http://www.leafground.com/pages/disapper.html";
		String urlAppear ="http://www.leafground.com/pages/appear.html";
		String urlTextChange="http://www.leafground.com/pages/TextChange.html";
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
		Assignment5 objAssignment5 = new Assignment5();
		
		
		objAssignment5.disappear(driver, urlDisapper);
		File snapshot = driver.getScreenshotAs(OutputType.FILE);
		File image = new File("./snaps/img002.jpg");
		FileUtils.copyFile(snapshot, image);
		
		objAssignment5.appear(driver, urlAppear);
		File snapshot2 = driver.getScreenshotAs(OutputType.FILE);
		File image2 = new File("./snaps/img003.jpg");
		FileUtils.copyFile(snapshot2, image2);
		
		objAssignment5.textChange(driver, urlTextChange);
		File snapshot3 = driver.getScreenshotAs(OutputType.FILE);
		File image3 = new File("./snaps/img004.jpg");
		FileUtils.copyFile(snapshot3, image3);
		
		driver.quit();

	}

}
