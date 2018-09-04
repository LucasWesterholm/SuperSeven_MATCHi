package matchiDemoSecondSprint.functions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import matchiDemoSecondSprint.MatchiBaseline;


public class MatchiPayBySwish extends MatchiBaseline{
	

	//
	// METHOD FOR TESTING PAYMENT BY SWISH
	//
	
	/**
	 * Pay for court by Swish also need method writeMobileNumber() 
	 * 
	 */
	public static  void payBySwish() {
		WebElement element = webDriver.findElement(By.xpath("//label[@for='swish']"));
		element.click();
		WebElement elementNext = webDriver.findElement(By.className("btn-success"));
		elementNext.click();
		}

	/**
	 * Saving mobileNumber
	 * @param string 
		 */
	public static void writeMobileNumber(String string) {	
		WebElement elementNr = webDriver.findElement(By.id("swish.telephoneNumber"));
		elementNr.click();
		elementNr.sendKeys(string);
		WebElement elementNext = webDriver.findElement(By.id("mainSubmit"));
		elementNext.click();
		}


}