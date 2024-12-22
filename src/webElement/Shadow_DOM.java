package webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Shadow_DOM {

	public static void main(String[] args) {
		
		/*
		 Shadow DOM - 
		 A common example of Shadow DOM used in everyday web browsing is a video player embedded on a website, where the play, pause, volume 
		 controls, and other UI elements within the player are managed by a separate Shadow DOM, ensuring their styles and functionality don't 
		 clash with the rest of the webpage's design; essentially acting like a self-contained "bubble" within the page
		 Elements like <video> and <input type="range"> use Shadow DOM internally for their implementation.
		 
		 what to test -
		 1. Ensure the Shadow DOM is attached to the element using methods like shadowRoot in JavaScript
		 2. Check whether encapsulated styles are applied correctly and are not overridden by external styles.
		 3. 
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/shadowdom");
		String txt = driver.findElement(By.xpath("//my-paragraph[2]")).getText();
		System.out.println(txt);
		
		
		/**
		 Still pending because I don't know  what to validate it since I can access it directly using xpath and get the message without any error
		 within the shadowDOM.
		 */
		
		
		
		
		

	}

}
