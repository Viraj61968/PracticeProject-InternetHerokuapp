package webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame_iframe {

	public static void main(String[] args) throws InterruptedException {
		/*
		 
		  Iframe (Inline Frame): A more modern <iframe> element used to embed content, such as videos, maps, or other web pages.
		 
		 Examples if iframe -
		 1. YouTube - When a website includes a YouTube video. A blog post or news article embedding a tutorial or promotional video from YouTube.
		 2. Google Map - Websites frequently embed interactive maps like A contact us page showing a business's location.
		 
		 Why Frame Tested ?
		 Testing frames is crucial because they can introduce unique challenges in user interactions, rendering, and functionality
		 
		 1. Responsiveness and Rendering - Frames can behave differently on various screen sizes or resolutions. Testing ensures proper 
		 								   alignment, scrolling, and visibility.
		 2. Performance - Loading external content in iframes can affect page performance. Testing ensures the frame does not cause unnecessary 
		 				  delays.
		 3. Functional Testing - Frames often hold interactive elements like forms, videos, or buttons. Testing ensures these elements function 
		 						 correctly within the frame.
		 */
		
		//Single iFrame.
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.switchTo().frame("singleframe");
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Entered the text in TextBox");
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		//iframe with in an iframe.
		driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src='MultipleFrames.html']")));
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src='SingleFrame.html']")));
		driver.findElement(By.tagName("input")).sendKeys("iframe with in an ifram");
	}

}
