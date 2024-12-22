package webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames_Nested {

	public static void main(String[] args) {
		
		/*
		 A frame is a part of a web page or browser window which displays content independently and with the ability to load content independently
		 The HTML in a frame may come from a web site distinct from the site providing the enclosing content. 
		 
		 Two Type - 
		 1. Nested Frame: An outdated <frame> element used in a <frameset> (deprecated in HTML5).
		 2. Iframe (Inline Frame): A more modern <iframe> element used to embed content, such as videos, maps, or other web pages.
		 */
		
		//Nest Frame
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.switchTo().frame("frame-bottom");
		String Text = driver.findElement(By.tagName("body")).getText();
		System.out.println(Text);
		
		

	}

}
