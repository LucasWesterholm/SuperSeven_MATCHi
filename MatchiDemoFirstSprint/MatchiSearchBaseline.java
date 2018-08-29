package matchiComplete;

/**
 * Methods used by all other classes
 * @author lotber
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class MatchiSearchBaseline {
	public static WebDriver webDriver;
	
	public MatchiSearchBaseline() {
		System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "/Users/lotber/automatisering/chromedriver");
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		webDriver.manage().window().maximize()
	}

	/**
	 * Opens the site Url
	 * @param siteUrl
	 */
	public void openSite(String siteUrl) {
		webDriver.get(siteUrl);
	}

	/**
	 * Logs in using correct values
	 */
	public void logIn() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[2]/li[2]/a"));
		element.click();
		WebElement usernameElement = webDriver.findElement(By.cssSelector("#username"));
		usernameElement.click();
		usernameElement.sendKeys("mjukvarutestare3@mailinator.com");
		WebElement passwordElement = webDriver.findElement(By.cssSelector("#password"));
		passwordElement.click();
		passwordElement.sendKeys("mjukvarutestare");
		passwordElement.sendKeys(Keys.ENTER);
	}		

	/**
	 * Logout from webpage https://beta1.matchi.se
	 * 
	 */
	public void logOut() {
		WebElement element = webDriver.findElement(By.cssSelector("#navbar-collapse > ul.nav.navbar-nav.navbar-right > li:nth-child(4) > a"));
		element.click();
		WebElement elementNext = webDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[2]/li[4]/ul/li[8]/a"));
		elementNext.click();
	}

	/**
	 * Click on Search-button
	 */
	public  void clickSearchButton() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"submit\"]"));
		element.click();
	}

	/**
	 * Click on SMASH-button	
	 */
	public  void clickSmashButton() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[5]/button"));
		element.click();
	}

	/**
	 * Delay
	 * @param milliseconds
	 */
	public static void delay(Integer milliseconds){
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    }
	
	/**
	 *Quit selenium and Chrome
	 */
	    public void quitSelenium() {
	    	delay(3000);
			webDriver.quit();
		}
}
