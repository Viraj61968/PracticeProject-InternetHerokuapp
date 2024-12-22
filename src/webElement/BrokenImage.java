package webElement;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenImage {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		/*
		1.  What are Broken Image in Web Testing ?
		 		Broken image is a link/image that does not show up as a picture, clicking upon which takes the end-user to a defunct picture. 
		 	The user encounters a 404 Error when clicked on the broken image. This error means that there is an issue with the image URL, 
		 	and the image is not loaded properly.
		 	
		 2. Reason to Test it 
		 		a. Broken images on a website hamper the end-user experience, which could negatively impact the growth of the product
		 		b.Images are an essential part of the content marketing strategy. 
		 		
		 3. Reason for Broken Image 
		 		a. Deleted Image file – The HTML code link could be referring to a file that is either wrongly spelled in the code or 
		 								no longer exist on the server.
		 		b. Incorrect Image URL - If a wrong image path or incorrect filename is mentioned in the <src> attribute, 
		 								 it leads to issues in displaying the image.
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/broken_images");
		
		//Validating if the image is broken or not.
		List<WebElement> image = driver.findElements(By.tagName("img"));
		
		for(WebElement images : image) {
			String url = images.getAttribute("src");
			/**
			 1. Also, here is the thing which I notice that is since URL & getAttribute is deprecated then so I tried using 
			 getDOMattribute it was throwing an error but after I've switch it to getAttribute the code was able to execute 
			 
			 2. When a method is marked as deprecated in a programming language (like Java), it means that the method is no longer recommended 
			 for use and may be removed in future versions of the language or library
			 */
			
			 HttpsURLConnection connect = (HttpsURLConnection) new URL(url).openConnection();
			 connect.setRequestMethod("HEAD");
			 connect.connect();
			 
			 int response = connect.getResponseCode();
			 
			 if(response>400) {
				 System.out.println("Image is broken" + " " + url);
			 }			 
		}
		
		
		
		
		
		
		
	}

}
