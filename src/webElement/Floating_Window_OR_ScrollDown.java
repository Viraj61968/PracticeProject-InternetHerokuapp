package webElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Floating_Window_OR_ScrollDown {

	public static void main(String[] args) {
		
		/*
		 Floating Menu / Window -
		 	Many modern websites use floating menus (also known as sticky or fixed menus). These menus stay visible at the top, bottom, 
		 	or side of the screen while you scroll through the page. They are commonly used for navigation, contact options, 
		 	or important CTAs (Call-To-Actions).
		 
		 Reason to Test Floating Window - 
		 1. Ensure the menu remains visible and functional as the user scrolls through the page.
		 2. Confirm the menu doesn’t obstruct important content or interfere with readability.
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/floating_menu");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		
		/*
		 1. So, my approach to test the element is by first scroll down to half of the page. Then I would use the wait
		 method to validate if the element is click able or not. 
		 2. The reason I've printed out the current URL is because that is the only way to validate it, which you can see in the console
		 that after it has click on the floating window the name of the menu is shown in the URL. like here it is " #home ".
		 */
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,2000)"); //syntax for scroll down & for scroll up you just have to enter the -2000 (-ve) value.
		System.out.println(driver.getCurrentUrl());
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Home"))).click();
		System.out.println(driver.getCurrentUrl());

	}

}
