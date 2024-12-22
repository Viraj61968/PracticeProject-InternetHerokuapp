package webElement;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class File_Download {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		/*
		 Testing the File Download functionality is essential for ensuring the seamless and secure operation of a web application
		 
		 1. Performance Testing - Assesses the application's response under high load (e.g., multiple users downloading files simultaneously).
		 
		 */
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("XPATH.pdf")).click();

	}

}
