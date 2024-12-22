package webElement;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Static_DropDown {

	public static void main(String[] args) {
		
		/*
		 What are Drop Down 
		 		A drop-down menu (or drop-down list) is a graphical user interface element that displays a list of options when clicked.
		 		
		 There are two type 
		 	1. Static Drop Down -  options in the drop-down are fixed and predefined.
		 	2. Dynamic Drop Down - options are fetched dynamically based on inputs like search bar in Amazon.
		 	
		Where it is used.
			1. Form Input
			2. Filters
			3. Navigation Menus
			4. Settings or Preferences
			5. Dynamic Selections
		
		What to Test
			1. Ensure the drop-down displays correctly and all items are selectable.
			2. Check if the selected option is reflected in the application correctly.
			3. Test the drop-down on different devices and browsers for compatibility.
		 */

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dropdown");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//Select the Drop Down options using " Select " method.
		WebElement Options = driver.findElement(By.id("dropdown"));
		Select s = new Select(Options);
		s.selectByVisibleText("Option 1");
		s.selectByValue("2");
		
		//Select Drop Down using Keys
		Options.click();
		Options.sendKeys(Keys.ARROW_DOWN);
		Options.sendKeys(Keys.ENTER);
		
		
		driver.close();
	}

}
