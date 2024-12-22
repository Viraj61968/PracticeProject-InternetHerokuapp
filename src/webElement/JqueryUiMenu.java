package webElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryUiMenu {

	public static void main(String[] args) {
		
		/*
		 JQuery UI Menus are a nice UI element from a user perspective, but poses an interesting automation challenge since it requires 
		 mouse operations and synchronization between them. Another 'fun' aspect is that the visibility of elements is actually not in the html 
		 itself, but done magically by JQuery so you cannot trust exactly what the HTML is telling you. A user cannot fire click events at 
		 certain UI elements, but you might -- if you have a big enough hammer to hit it with.
		 
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/jqueryui/menu#");
		
		Actions a = new Actions(driver);
		
		//So to automate you need to perform chain action and that too with a pause of 2 seconds.
		a.moveToElement(driver.findElement(By.id("ui-id-3"))).pause(Duration.ofSeconds(2))
		.moveToElement(driver.findElement(By.id("ui-id-4"))).pause(Duration.ofSeconds(2))
		.moveToElement(driver.findElement(By.id("ui-id-5"))).click().build().perform();
		
		

	}

}
