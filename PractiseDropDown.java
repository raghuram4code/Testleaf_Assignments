package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PractiseDropDown {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		
		WebElement firstDropDown = driver.findElement(By.id("dropdown1"));
		Select dd1 = new Select(firstDropDown);
		dd1.selectByIndex(3);
		
		WebElement secDropDown = driver.findElement(By.name("dropdown2"));
		Select dd2 = new Select(secDropDown);
		dd2.selectByVisibleText("Selenium");
		
		WebElement thrdDropDown = driver.findElement(By.id("dropdown3"));
		Select dd3 = new Select(thrdDropDown);
		dd3.selectByValue("2");
		
		WebElement frthDropDown = driver.findElement(By.className("dropdown"));
		Select dd4 = new Select(frthDropDown);
		dd4.selectByVisibleText("Loadrunner");
		
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/select")).sendKeys("UFT/QTP");
		
//		WebElement secDropDown = driver.findElement(By.id("dropdown1"));
//		Select dd2 = new Select(secDropDown);
//		dd2.selectByVisibleText("Selenium");
//		
		

	}

}
