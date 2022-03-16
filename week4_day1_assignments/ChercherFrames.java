package Week4.day1.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChercherFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url ="https://chercher.tech/practice/frames-example-selenium-webdriver";
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(url);
		//List<WebElement> framesList = driver.findElements(By.tagName("iframe"));
		//System.out.println(framesList.size());
		
		WebElement firstFrame = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(firstFrame);
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Raghuram");;
		driver.switchTo().parentFrame();
		WebElement secondFrame = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(secondFrame);
		WebElement dropdownelement = driver.findElement(By.xpath("//select[@id='animals']"));
		Select dd = new Select(dropdownelement);
		dd.selectByValue("avatar");
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(firstFrame);
		WebElement thirdFrame = driver.findElement(By.id("frame3"));
		driver.switchTo().frame(thirdFrame);
		driver.findElement(By.id("a")).click();
		driver.switchTo().defaultContent();
		driver.quit();
	}

}
