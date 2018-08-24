package MatchiDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MatchiSearchPayBySwish {
	
	private WebDriver webDriver;
	
	public MatchiSearchPayBySwish() {
		System.setProperty("webdriver.chrome.driver", "/Users/lotber/automatisering/chromedriver");
		//	System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	//
	// METHOD FOR TESTING PAYMENT BY SWISH
	//
	
	/**
	 * Pay for court by Swish also need method writeMobileNumber() 
	 * 
	 */
	public void payBySwish() {
		WebElement element = webDriver.findElement(By.xpath("//label[@for='swish']"));
		element.click();
		WebElement elementNext = webDriver.findElement(By.className("btn-success"));
		elementNext.click();
		}

	/**
	 * Saving mobileNumber
	 * @param string 
		 */
	public void writeMobileNumber(String string) {	
		WebElement elementNr = webDriver.findElement(By.id("swish.telephoneNumber"));
		elementNr.click();
		elementNr.sendKeys(string);
		WebElement elementNext = webDriver.findElement(By.id("mainSubmit"));
		elementNext.click();
		}


}
