package webElement;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindows {

	public static void main(String[] args) {
		
		/*
		 Multiple Window - 	
		 	It refers to refer to scenarios where a single web application or webpage opens additional browser windows or tabs. 
		 	These additional windows or tabs could serve various purposes, such as:
		 		1. For displaying advertisements, login forms, or additional information.
		 		2. Opening links or forms in a new tab
		 		3. Navigating to external websites.
		 		
		 Reason on why to test it .
		 
		 1. Ensure proper functioning of links, buttons, or elements that trigger new windows or tabs.
		 2. Confirm that the new windows enhance user experience rather than confuse or frustrate users.
		 3. Verify that popups and new tabs are not blocked by browser settings or extensions.
		 4. Ensure that opening multiple windows does not degrade performance or create unnecessary load on the browser.
		 
		 Daily - life examples 
		 1. Testing ensures the payment process works seamlessly and users are redirected back to the original site after payment.
		 2. Ensures accurate rendering of cart details and smooth navigation back to the main site.
		 */
		
		
		
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.linkText("Click Here")).click();
		
		//capturing all the open tabs
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> tabs = windows.iterator();
		String parentwindow = tabs.next();
		String childwindow = tabs.next();
		
		//moving to child windows.
		driver.switchTo().window(childwindow);
		String textMsg = driver.findElement(By.tagName("h3")).getText();
		System.out.println(textMsg);
		
		System.out.println("-----------");
		
		//moving back from child to parent window.
		driver.switchTo().window(parentwindow);
		String textMsg1 = driver.findElement(By.tagName("h3")).getText();
		System.out.println(textMsg1);
	}

}


















