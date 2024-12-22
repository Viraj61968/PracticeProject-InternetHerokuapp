package webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Large_Deep_DOM {

	public static void main(String[] args) {
		
		/*
		 Some pages have very large and deeply nested page layouts, which can trigger odd rendering issues and test performance bottlenecks
		 
		 How to use Absolute and Relative Xpath together to pinpoint to the exact element 
		 
		 1. The XPath you provided (//html/body/div//table[@id='large-table']//tbody/tr/td) works because 
		 	it combines absolute XPath concepts with relative XPath techniques.
		 
		 Explanation - 
		 	A. Absolute Xpath - 
		 			1. An absolute XPath starts at the root node (/html) and follows the exact structure of the DOM step by step. In above xpath,
		 	the portion ' /html/body/div '
		 	
		 	B. Relative Xpath - 
		 			1. The // syntax in XPath means search anywhere in the DOM starting from the current context.
		 			2. So, ' //table[@id='large-table'] ' This searches for a <table> element with id="large-table" anywhere 
		 			   inside the current <div>.
		 	
		 	why does it work ?
		 	1. The // operator makes the XPath more flexible:
		 	2. Instead of requiring a strict step-by-step traversal (as in pure absolute XPath), the // operator 
		 	   allows XPath to "look deeper" into the DOM and find elements regardless of nesting depth.
		 	   
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/large");
		
		//No sibling - Element does not share the same parent with any other element i.e. it is the only child of its parent element
		
		String noSiblingText = driver.findElement(By.id("no-siblings")).getText();
		System.out.println(noSiblingText);
		System.out.println("--------------------");
		
		//Siblings - Two or more elements are siblings if they are on the same level of the DOM hierarchy and have the same parent element.
		String siblingText = driver.findElement(By.xpath("/html/body/div//div[@id='sibling-1.1']//div[@id='sibling-23.2']")).getText();
		System.out.println(siblingText);
		System.out.println("--------------------");
		
		//Table 
		String tableText = driver.findElement(By.xpath("/html/body/div//table[@id='large-table']/tbody/tr[@class='row-29']/td[@class='column-38']"))
							.getText();
		System.out.println(tableText);
		System.out.println("--------------------");

	}

}
