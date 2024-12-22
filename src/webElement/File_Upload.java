package webElement;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class File_Upload {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		/*
		 	When a file upload feature is implemented using an <input type="file"> element, .sendKeys() is the most reliable 
		 and platform-independent method.
		 
		 But, for the code below were the upload feature doesn't implement <input> tag, then AutoIt can be used, but only if clicking this 
		 button opens a native OS-level file picker dialog. In this case, Selenium cannot directly interact with the file dialog, making AutoIt 
		 or similar tools (like Robot class) necessary.
		 */
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/upload");
		
		//Upload File using .sendKeys method
		driver.findElement(By.cssSelector("input[id='file-upload']")).sendKeys("C:\\Users\\viraj nalawade\\Downloads\\XPATH (1).pdf");
		driver.findElement(By.cssSelector(".button")).click();
		
		//Upload file using AutoIT.
		//Runtime.getRuntime().exec("C:\\Learn it\\FilledUpload.exe");
		

	}

}
