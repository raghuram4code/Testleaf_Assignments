package Week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assingment4 {
	
	private void playWithTable(WebDriver driver, String url) {
		// TODO Auto-generated method stub
		
		driver.get(url);
		
		WebElement table = driver.findElement(By.id("table_id"));
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int noOfRows= rows.size();
		
		List<WebElement>columns=rows.get(1).findElements(By.tagName("td"));
		
		List<String> progressList= new ArrayList();
		int noOfCol = columns.size();
		System.out.println("No of columns : "+noOfCol +"\n No of Rows : " + noOfRows);
		
		for (int i =1; i<noOfRows; i++) {
			String cellValue=rows.get(i).findElements(By.tagName("td")).get(0).getText();
			//System.out.println(cellValue);
			progressList.add(rows.get(i).findElements(By.tagName("td")).get(1).getText());
			//System.out.println(progressList);
			
			if(cellValue.equals("Learn to interact with Elements")) {
				String progressValue=rows.get(i).findElements(By.tagName("td")).get(1).getText();
				System.out.println("The % of Learn to interact with Elements is: "+progressValue);
								
			}
		}
		
		Collections.sort(progressList);
		String lowestProgress = progressList.get(0);
		
		for (int i =1; i<noOfRows; i++) {
			String cellValue =rows.get(i).findElements(By.tagName("td")).get(1).getText();
					
			if(cellValue.equals(lowestProgress)) {
				String typeText =rows.get(i).findElements(By.tagName("td")).get(0).getText();
				rows.get(i).findElements(By.xpath("//td/input")).get(2).click();
				System.out.println("Successfully Checked checkbox of "+typeText);
								
			}
		}
		
	}
	
	private void sorting(WebDriver driver, String url) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver.get(url);
		
		WebElement table = driver.findElement(By.id("table_id"));
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int noOfRows= rows.size();
		
		List<WebElement>columns=rows.get(1).findElements(By.tagName("td"));
		
		List<String> nameList= new ArrayList();
		List<String> secondNameList= new ArrayList();
		int noOfCol = columns.size();
		
		System.out.println("No of columns : "+noOfCol +"\n No of Rows : " + noOfRows);
		
		for (int i =1; i<noOfRows; i++) {
			nameList.add(rows.get(i).findElements(By.tagName("td")).get(1).getText());
			
			}
		
		Collections.sort(nameList);
		System.out.println(nameList);
		rows.get(0).findElements(By.tagName("th")).get(1).click();
		
		Thread.sleep(3000);
		

		WebElement table1 = driver.findElement(By.id("table_id"));
		
		List<WebElement> rows1 = table.findElements(By.tagName("tr"));
				
		for (int i =1; i<noOfRows; i++) {
			
			secondNameList.add(rows1.get(i).findElements(By.tagName("td")).get(1).getText());
			
			}
		
		System.out.println(secondNameList);
		
		if(secondNameList.equals(nameList)) {
			System.out.println("Table is sorted successfully");
		}
		else {
			System.out.println("Table sorted did not work");
		}
		
	}
	
	

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		

		String urlTable= "http://www.leafground.com/pages/table.html"; 
		String urlSort= "http://www.leafground.com/pages/sorttable.html";
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Assingment4 objAssingment4 = new Assingment4();		
		objAssingment4.playWithTable(driver, urlTable);
		File snapShot1 = driver.getScreenshotAs(OutputType.FILE);
		File img1 = new File("./snaps/img1.jpg");
		FileUtils.copyFile(snapShot1, img1);
		
		objAssingment4.sorting(driver, urlSort);
		File snapShot2 = driver.getScreenshotAs(OutputType.FILE);
		File img2 = new File("./snaps/img2.jpg");
		FileUtils.copyFile(snapShot2, img2);
		
		
		driver.close();


	}

}
