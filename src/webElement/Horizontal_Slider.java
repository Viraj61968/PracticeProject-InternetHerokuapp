package webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Horizontal_Slider {

	public static void main(String[] args) {
		
		/*
		 What is Horizontal Slider - 
		 	A horizontal slider is a UI component that allows users to select a value or adjust settings by sliding a handle along a horizontal 
		 	axis. This is commonly used in web applications for adjusting settings like volume, brightness, or price ranges, where the user can 
		 	drag the slider left or right to choose a value.
		 
		 Reasons it has to be Tested - 
		 1. Ensure the slider moves smoothly within the defined range
		 2. Check if the slider works correctly with different browser types
		 3. Verify the visual design is consistent with the overall UI and works well under different conditions.
		 
		 Real-life examples -
		 1. Sliders are used to allow users to set a minimum and maximum price range for filtering products.
		 2. Adjusting parameters like loan amount, interest rate, or repayment period to see real-time calculations.
		 
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/horizontal_slider");
		
		//Here I'm Ctrl+right Arrow key to move the slider and the reason I've set the loop for 10 is because the slider at 0.5 range. 
		//And that is why I've set the loop to 10.
		
		for(int i=0; i<=10;i++) {
		driver.findElement(By.cssSelector("input[type='range']")).sendKeys(Keys.CONTROL,Keys.ARROW_RIGHT);
		};

	}

}
