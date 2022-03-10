package week3.Assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface BrowseShoppingSite {
	
	void launchPage(WebDriver driver,String url);
	void searchItem(WebDriver driver,String item);
	void selectCategory(WebDriver driver) throws InterruptedException;
	void getItemText(WebDriver driver) throws InterruptedException;
	void printBrand(WebDriver driver) throws InterruptedException;
	void printName(WebDriver driver);

}
