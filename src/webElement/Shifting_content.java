package webElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Shifting_content {

	public static void main(String[] args) {
		
		/**
		 What is Shfiting Content ?
		 	Shifting content in web applications refers to the unintended or unexpected movement of content on a webpage as it loads. Shifting 
		 	content happens when elements on a webpage move around due to delays in loading assets like images, fonts, or ads. This can cause user 
		 	frustration and negatively affect the user experience.
		 	
		 Example of shfiting content - 
		 	1. You open a news website to read an article.
		 	2. As the page loads, you try to click on a headline.
		 	3. Suddenly, an ad loads above the headline, causing the content to shift down, and you accidentally click the ad instead.
		 	
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/shifting_content");
		
		
		//Validating if the element is clickable. 
		driver.findElement(By.linkText("Example 1: Menu Element")).click();
		driver.findElement(By.xpath("/html/body//div[@class='example']/p[3]")).findElement(By.linkText("click here")).click();
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Portfolio"))).click();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		//validating if the image is shifted or not by using the coordinates of the images before and after .
		driver.findElement(By.linkText("Example 2: An image")).click();
		Point coordinates = driver.findElement(By.cssSelector(".shift")).getLocation();
		System.out.println("Before Loading Coordinates = "+coordinates);
		System.out.println("-------------------");
		driver.findElement(By.xpath("/html/body//div[@class='example']/p[3]")).findElement(By.linkText("click here")).click();
		Point coordinates2 = driver.findElement(By.cssSelector(".shift")).getLocation();
		System.out.println("Before Loading Coordinates = "+coordinates2);
		
		//validating if the list is also shifted or not.
		driver.findElement(By.linkText("Example 3: List")).click();
		String text = driver.findElement(By.xpath("//div[@class='large-6 columns large-centered']")).getText();
		System.out.println(text);
		driver.navigate().refresh();
		System.out.println("--------------------------------------------------------------");
		System.out.println("---------Same content but the sequence is changed-------------");
		System.out.println("--------------------------------------------------------------");
		String text1 = driver.findElement(By.xpath("//div[@class='large-6 columns large-centered']")).getText();
		System.out.println(text1);
		

	}

}
