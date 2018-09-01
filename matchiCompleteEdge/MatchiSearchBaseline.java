package matchiCompleteEdge;

import java.util.concurrent.TimeUnit;

/**
 * Methods used by all other classes
 * @author lotber
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class MatchiSearchBaseline {
	public static WebDriver webDriver;
	
	public MatchiSearchBaseline() {
		
		System.setProperty("webdriver.edge.driver","C:\\Users\\sarada mutnuru\\SeleniumServer\\MicrosoftWebDriver.exe" );
		webDriver = new EdgeDriver();
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
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
	
	public static void selectNorsk(String langnorsk)
	{
		WebElement language=webDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[2]/li[1]/a"));
		language.click();
		WebElement norsk=webDriver.findElement(By.linkText(langnorsk));
		norsk.click();
	}
	
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
	 * Select language
	 * @param string NORSK, SVENSKA, ENGLISH
	 */
	public void selectLanguage(String string)
	{
		WebElement language=webDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[2]/li[1]/a"));
		language.click();
		WebElement lang=webDriver.findElement(By.linkText(string));
		lang.click();
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