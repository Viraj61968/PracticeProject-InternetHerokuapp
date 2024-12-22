package webElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Enter_Ad {

	public static void main(String[] args) {
		
		/*
		 It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for 
		 something or disable their ad blocker).
		 
		 Why Enter Ads should be Tested.
		 1. Testing ensures the ad appears correctly when intended and does not show up unnecessarily.
		 2. Ensure the ad isn't cut off on smaller screens or overlapping other content.
		 3. Test how the webpage behaves if an entry ad is blocked (e.g., the content should still load properly).
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/entry_ad");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		
		//Close the Ad and check if the add appears again after the refresh.
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".modal-footer"))).click();
		driver.navigate().refresh();

	}

}
