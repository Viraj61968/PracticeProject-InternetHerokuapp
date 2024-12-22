package webElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Data_Tables {

	public static void main(String[] args) {
		
		
		/*
		 Often times when you see a table it contains data which is sortable -- sometimes with actions that can be taken within each row 
		 (e.g. edit, delete). In other word it is expecting to interact edit or deleted button of each row of the table.
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/tables#delete");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		
		//Extracting data in the table with [ no class or ID ].
		
		String result = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='table1']//tbody//tr[3]"))).getText(); 
		System.out.println(result); ////3rd row.		
		
		//Extracting data in the table with [ with class or ID ].
		
		String result1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='table2']//tbody/tr[2]"))).getText(); 
		System.out.println(result1); ////2nd row

	}

}
