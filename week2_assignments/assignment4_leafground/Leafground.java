package week2_assignments.assignment4_leafground;

import java.awt.Button;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafground {
	
	private void editing(WebDriver driver,String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("testmail@gmail.com");
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("Appended Text");
		String chkvalue = driver.findElement(By.xpath("//input[@value='TestLeaf']")).getAttribute("value");
		System.out.println("the value in txtbos is  "+chkvalue);
		driver.findElement(By.xpath("//label[text()='Clear the text']/following-sibling::input")).clear();
		boolean chkenable= driver.findElement(By.xpath("//label[contains(text(),'Confirm')]/following-sibling::input")).isEnabled();
		if (chkenable) {System.out.println("Edit field is enabled");}
		else System.out.println("Edit field is disabled");
		
	
	}
	
	private void buttonMethod(WebDriver driver,String url) {
		driver.get(url);
		driver.manage().window().maximize();
				
		driver.findElement(By.xpath("//button[@id='home']")).click();
		System.out.println(driver.getTitle());
		String pageTitle= driver.getTitle();
		if(driver.getTitle().contains("TestLeaf - Selenium Playground")) { System.out.println("Page navigated to Home page");
		driver.navigate().back();
		}
		
		System.out.print("The position of button is :");
		System.out.println(driver.findElement(By.xpath("//button[@id='position']")).getLocation());
		int buttonX = driver.findElement(By.xpath("//button[@id='position']")).getLocation().getX();
		int buttonY = driver.findElement(By.xpath("//button[@id='position']")).getLocation().getY();
		System.out.println("X position of button is at "+ buttonX+ " and Y Postion is at " +buttonY);
		System.out.print("The color code of the of button is ");
		System.out.println(driver.findElement(By.xpath("//button[@id='color']")).getCssValue("background-color"));
		System.out.print("The Size of button is :");
		System.out.println(driver.findElement(By.xpath("//button[@id='size']")).getSize());
		int buttonWidth = driver.findElement(By.xpath("//button[@id='size']")).getSize().getWidth();
		int buttonHeight = driver.findElement(By.xpath("//button[@id='size']")).getSize().getHeight();
		System.out.println("Width  of button is "+ buttonWidth+ " and Height is " +buttonHeight);
		
	}
	
	private void linkMeth(WebDriver driver,String url) {
		driver.get(url);
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Go to Home Page")).click();
		System.out.println(driver.getTitle());
		if(driver.getTitle().contains("TestLeaf - Selenium Playground")) { System.out.println("Page navigated to Home page");
		driver.navigate().back();
		}
		String targetURL= driver.findElement(By.xpath("//a[contains(text(),'Find')]")).getAttribute("href");
		System.out.println("The link is navigating to below URL");
		System.out.println(targetURL);
		
		String validatURL = driver.findElement(By.xpath("//a[contains(text(),'Verify')]")).getAttribute("href");
		if(validatURL.contains("error")) {System.out.println("Page is broken");}
		else {System.out.println("Page is not broken");}
		 
		List<WebElement> linkElements = driver.findElements(By.xpath("//a[contains(text(),'Home')]"));
		
		System.out.println(linkElements.get(0).getText());
		linkElements.get(1).click();	
		if(driver.getTitle().contains("TestLeaf - Selenium Playground")) { System.out.println("Page navigated to Home page");
		driver.navigate().back();
		}
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("No of links in the page are :"+ allLinks.size());
			
	}
	
	private void imageMethod(WebDriver driver,String url) {
		driver.get(url);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//label[contains(text(),'home')]/following-sibling::img")).click();
		if(driver.getTitle().contains("TestLeaf - Selenium Playground")) { System.out.println("Page navigated to Home page");
		driver.navigate().back();
		}
		
		driver.findElement(By.xpath("//label[contains(text(),'Broken')]/following-sibling::img")).click();
		 if(driver.getTitle().contains("Images")) { System.out.println("Image is broken");}
		 else {
			 { System.out.println("Image is not broken");}
			driver.navigate().back();
			}
//	   driver.findElement(By.xpath("//label[contains(text(),'Keyboard')]/following-sibling::img")).sendKeys( Keys.ENTER);
//	  if(driver.getTitle().contains("TestLeaf - Selenium Playground")) { System.out.println("Page navigated to Home page");
//		driver.navigate().back();
//		}
	  
	   driver.findElement(By.xpath("//label[contains(text(),'Keyboard')]/following-sibling::img")).click();
	  if(driver.getTitle().contains("TestLeaf - Selenium Playground")) { System.out.println("Page navigated to Home page");
		driver.navigate().back();
		}
	  
	  WebElement lastLink= driver.findElement(By.xpath("//label[contains(text(),'Keyboard')]/following-sibling::img"));
	  Actions act = new Actions(driver);
	  act.moveToElement(lastLink).click().build().perform();
	  
	  if(driver.getTitle().contains("TestLeaf - Selenium Playground")) { System.out.println("Page navigated to Home page");
	  
		driver.navigate().back();
		}
	else {System.out.println("Page not navigated");}
	
	}
	
	private void dropdownMethod(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().window().maximize();
		
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
		
		driver.findElement(By.xpath("(//div[@id='contentblock']//select)[5]")).sendKeys("UFT/QTP");
		
		WebElement muldropdown = driver.findElement(By.xpath("(//div[@id='contentblock']//select)[6]"));
		Select dd5 = new Select(muldropdown);
		dd5.selectByVisibleText("Selenium");
		dd5.selectByValue("2");
	}
	
	private void checkBoxMethod(WebDriver driver,String url) {
		driver.get(url);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[text()='Java']/input")).click();
		driver.findElement(By.xpath("//div[text()='VB']/input")).click();
		driver.findElement(By.xpath("//div[text()='SQL']/input")).click();
		driver.findElement(By.xpath("//div[text()='C']/input")).click();
		
		boolean chkvalue= driver.findElement(By.xpath("//div[text()='Selenium']/input")).isSelected();
		if (chkvalue) System.out.println("I confirm that Selenium checkbox is checked");
		else System.out.println("I confirm that Selenium checkbox is not checked");
		
		
		
		List<WebElement> selectChkElements = driver.findElements(By.xpath("//div[contains(text(),'Selected')]/input"));
		
		for (int i=0; i<selectChkElements.size();i++)
		{
			if(selectChkElements.get(i).isSelected())
			selectChkElements.get(i).click();
		}
		
		List<WebElement> optElements = driver.findElements(By.xpath("//div[contains(text(),'Option')]/input"));		
		for (int i=0; i<optElements.size();i++)
		{
			optElements.get(i).click();
		}
		
		System.out.println("Clicked");

	}

	public static void main(String[] args) {
	
		
		    String editurl= "http://leafground.com/pages/Edit.html";
			String buttonurl="http://leafground.com/pages/Button.html";
			String linkurl ="http://leafground.com/pages/Link.html";
			String imageurl="http://leafground.com/pages/Image.html";
			String dropdownUrl= "http://leafground.com/pages/Dropdown.html";
			String chkboxurl="http://leafground.com/pages/checkbox.html";
			
			WebDriverManager.chromedriver().setup();			
			ChromeDriver getDriver = new ChromeDriver();
			getDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(600));
			
			Leafground objLeafground = new Leafground();		
			System.err.println("Edit  page");
			objLeafground.editing(getDriver,editurl);
			System.err.println("Button  page");
			objLeafground.buttonMethod(getDriver, buttonurl);
			System.err.println("Dropdown  page");
			objLeafground.dropdownMethod(getDriver, dropdownUrl);
			System.err.println("chkbox  page");
			objLeafground.checkBoxMethod(getDriver,chkboxurl);
			System.err.println("Link  page");
			objLeafground.linkMeth(getDriver,linkurl);
			System.err.println("Image  page");
			objLeafground.imageMethod(getDriver,imageurl);
			getDriver.quit();
	}
	}

}
