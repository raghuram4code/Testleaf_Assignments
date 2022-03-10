package week3.Assignments;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver getDriver = new ChromeDriver();
		String url = "https://www.ajio.com/";
		String item = "Bags";
		getDriver.get(url);
		
		ClothShopping objClothShopping = new ClothShopping();
		objClothShopping.launchPage(getDriver, url);
		objClothShopping.searchItem(getDriver, item);
		objClothShopping.selectCategory(getDriver);
		objClothShopping.getItemText(getDriver);
		objClothShopping.printBrand(getDriver);
		objClothShopping.printName(getDriver);
		getDriver.quit();
		

	}

}
