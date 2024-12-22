package webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextClick {

	public static void main(String[] args) {
		
		/*
		 Reason to perform testing on context click.
		 
		 1. Testing Context Menus - Many web applications use context menus (custom right-click menus) to provide additional options.
		 							like "Copy", "Paste", "Delete", etc.
		 
		 2. Verifying Browser Behavior - In some cases, the right-click might need to be disabled.
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/context_menu");
		
		WebElement element = driver.findElement(By.cssSelector("div[id='hot-spot']"));
		
		//context click or right click
		Actions a = new Actions(driver);
		a.contextClick(element).build().perform();
		
		//Accepting alerts for the right dialogue box to appear
		driver.switchTo().alert().accept();
		
		driver.close();
		
		

	}

}
