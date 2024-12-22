package webElement;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeoLocation {

	public static void main(String[] args) {
		
		/*
		 Geo-location - process of identifying the geographical location of a device or user based on various data sources.
		 
		 Modern web applications often use geolocation APIs to provide location-specific services like:
		 1. Showing nearby stores or restaurants.
		 2. Targeted advertising based on the user’s region.
		 
		 Why do we Test ?
		 Testing geo-location functionality is crucial to ensure the application behaves correctly and delivers accurate results when users 
		 interact with location-based features.
		 
		 1. Validating Location Accuracy - Ensure the application retrieves the correct coordinates (latitude and longitude) and provides 
		 relevant data.
		 
		 2. Check Location Specific Features - Test region-specific offers, pricing, content, or services.
		 
		 3. Handle Permissions -Verify the application handles "Allow" or "Deny" permissions correctly and behavior when the user denies 
		 						access to location.
		 4. Cross-Browser and Device Compatibility - Ensure geolocation works seamlessly on different browsers and devices.
		 5. Geo-location Simulation - Test how the application behaves when accessing locations in different countries or regions without 
		 							  physically being there.
		 
		 */
		
		//If you need to make the chrome browser to just accept the popup for location then use the below syntax of chromeoptions.
		ChromeOptions chrome = new ChromeOptions();
		HashMap<String,Object> chromepref = new HashMap<String,Object>();
		chromepref.put("profile.default_content_setting_values.geolocation", 1); //this is the syntax for access which I've created using ChatGPT.
		chrome.setExperimentalOption("prefs", chromepref);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chrome); //here I've provide the variable which store the setting for access.
		driver.get("https://the-internet.herokuapp.com/geolocation");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.tagName("button")).click();
		String latitude = driver.findElement(By.xpath("//div[@id='lat-value']")).getText();
		String longitude = driver.findElement(By.xpath("//div[@id='long-value']")).getText();
		
		System.out.println("Geo-Location :" + " " +"Latitude = " +latitude + " " + "Longitutde = " +longitude);

	}

}
