package webElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) {
		
		/*
		 MouseHover - 
		 	MouseHover is an action performed on a web element where the mouse pointer is moved over the element without clicking it. 
		 	This action can trigger various events like displaying tooltips, dropdown menus, overlays, or revealing hidden content in 
		 	modern web applications.
		 	
		 	OR
		 	
		 	Hover over the image for additional information
		 	
		 Why to Test ?
		 1. Ensures that the correct elements or information are displayed. And Prevents errors like showing irrelevant or missing data.
		 2. In e-commerce websites, MouseHover is often used to reveal product details, quick-buy options, or comparison data. 
		 	Testing ensures that these features support business goals effectively.
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/hovers");
		Actions a = new Actions(driver);
		List<WebElement> photos = driver.findElements(By.cssSelector(".figure"));
		List<WebElement> imageinfo = driver.findElements(By.cssSelector(".figcaption"));
		for(int i =0;i< photos.size();i++)
		{
			//to hover every elements
			WebElement image = photos.get(i);
			a.moveToElement(image).build().perform();
			
			//imageinfo.size() > i ensures that the index exists in the imageinfo list.
			if(imageinfo.size()>i) 
			{	
				//and before hovering to next element first extract the info and print it out.
				String Text = imageinfo.get(i).getText();
				System.out.println(Text);
				System.out.println("----------");
			}
		}
		

	}

}


/*
 **************************************************************************************************
 if (photos.get(i) == imageinfo.get(i))
 This checks for object reference equality (not content equality) and is almost certainly incorrect. 
 It will always fail unless photos.get(i) and imageinfo.get(i) refer to the exact same object. 
 *************************************************************************************************
 What you probably want is to verify a match or existence of imageinfo for the hovered image.
 
 *************************************************************************************************
 Alternative i.e using only For Loop 
 *************************************************************************************************
 		List<WebElement> photos = driver.findElements(By.cssSelector(".figure"));
		List<WebElement> imageinfo = driver.findElements(By.cssSelector(".figcaption"));

		Actions a = new Actions(driver);
		
		for (int i = 0; i < photos.size(); i++) 
		{
		    WebElement image = photos.get(i);
		    a.moveToElement(image).build().perform(); // Hover over the image
		    
		    ** Wait to ensure the corresponding info appears**
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		    wait.until(ExpectedConditions.visibilityOf(imageinfo.get(i))); ** Ensure the text is visible **
		    
		    ** Now get the text of the corresponding imageinfo **
		    String text = imageinfo.get(i).getText();
		    System.out.println( text);
		    System.out.println("----------");
		}

*/












