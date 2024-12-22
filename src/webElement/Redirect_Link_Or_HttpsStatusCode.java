package webElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Redirect_Link_Or_HttpsStatusCode {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		
		/**
		 Redirection - 
		 	1. When a web server wants to redirect a client (like a browser) to another page, it typically sends an HTTP status code in the 
		 	   3xx range 
		 
		 Raw Redirect - A raw redirect status code means the server only sends the redirection status code without providing 
		 				a new destination URL (in the Location header of the HTTP response) or any content in the body.
		 
		 But, Some browsers may not handle such incomplete responses properly. Browsers generally expect:
		 	1. A valid redirection status code (like 301 [moved permanently] or 302[found]).
		 	2. A Location header with a new destination URL to redirect the user.
		 	
		 So, what to test to validate it ?
		 1. Verify that the response from the server includes a redirection status code in the 3xx range
		 2. Confirm that the response includes a Location header, which specifies the new destination URL where the client should be redirected.
		 	The Location header should contain a valid and reachable URL.
		 3. Check that the browser or client is successfully redirected to this URL.
		 */

		
		
		
		
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/redirector");
		
		//capturing the status code. 
		WebElement linkElement = driver.findElement(By.id("redirect"));	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String link = (String) js.executeScript("return arguments[0].href", linkElement); //since getAttribute is deprecated but still working.
		System.out.println(link);
		URI uri = new URI (link); //since URL is deprecated and still working.
		String uriString = uri.toString();
		HttpURLConnection connect = (HttpURLConnection) new URI(uriString).toURL().openConnection();
		connect.setInstanceFollowRedirects(false); // find the explanation below.
		connect.connect();
		int statuscode = connect.getResponseCode();
		 
		
		System.out.println("Redirect link = " + statuscode);
		
		//capturing the URL to check where the redirect link is headed to using the status code received 
		// either it is 302 or 301.
		if(statuscode == HttpURLConnection.HTTP_MOVED_PERM || statuscode == HttpURLConnection.HTTP_MOVED_TEMP) 
		{
			String redirectURL = connect.getHeaderField("Location");
			System.out.println(redirectURL);
		}
		
		
		
		
		
		
		
		
		
		
		
		/**
		 The line connection.setInstanceFollowRedirects(false); in the code is used to stop 
		 the HttpsURLConnection from automatically following redirects.
		 
		 ** What happens without it?
		  		1. Normally, if a server responds with a redirect status code (like 302 or 301), HttpsURLConnection will automatically 
		  		   follow the redirect and go to the new URL specified in the Location header.
		  		2. As a result, you won't see the 302 status code—it will behave as if it directly reached the final URL (e.g., with a 200 OK status).
		  		
		  ** What does this do?
		  		1. By setting setInstanceFollowRedirects(false), you tell HttpsURLConnection to pause at the 302 status code and 
		  		   not automatically follow the redirection.
		  		2. So, this helps you to Check the exact status code (e.g., 302).
		  		3. Read the Location header to find out where the server wants to redirect the client.
		  		
		  ** Don't use [setRequestMethod("HEAD")]
		  		It will only fetch the current URL's response and headers, including the Location header if there is a redirection. 
		  		However, it won’t automatically follow the redirection to give you the final destination URL.
		 */
		
		
		
		
		
		
		
	}

}
