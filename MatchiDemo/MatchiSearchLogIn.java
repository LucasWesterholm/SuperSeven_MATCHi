package MatchiLucas;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class MatchiSearchLogIn {
	private WebDriver webDriver;


	public MatchiSearchLogIn() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	/**
	 * Opens the site Url
	 * @param siteUrl
	 */
	public void openSite(String siteUrl) {
		webDriver.get(siteUrl);
	}
	
	/**
	 * Log in with a negative password
	 */
	public void logInNegative() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[2]/li[2]/a"));
		element.click();
		WebElement usernameElement = webDriver.findElement(By.cssSelector("#username"));
		usernameElement.click();
		usernameElement.sendKeys("mjukvarutestare3@mailinator.com");
		WebElement passwordElement = webDriver.findElement(By.cssSelector("#password"));
		passwordElement.click();
		passwordElement.sendKeys("mjukvarutest");
		passwordElement.sendKeys(Keys.ENTER);
	}
	
	/**
	 * Check for the negative password, grabs the error message and returns the message to an assert
	 * @param negativePassword
	 * @return
	 */
	public boolean logInNegativeCheck(String negativePassword) {
		WebElement element = webDriver.findElement(By.className("notification-message"));
		String text = element.getText();
		return text.equals(negativePassword);
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
	 * Check for the positive password, grabs the user name and returns the message to an assert
	 * @param positivePassword
	 * @return
	 */
	public boolean logInPositiveCheck(String positivePassword) {
		WebElement element = webDriver.findElement(By.className("media-heading"));
		String text = element.getText();
		return text.equals(positivePassword);
	}
	
	
	
    public void delay(Integer milliseconds){
	    try {
	        TimeUnit.MILLISECONDS.sleep(milliseconds);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
    }
    public void quitSelenium() {
    	delay(3000);
		webDriver.quit();
	}
    
}
