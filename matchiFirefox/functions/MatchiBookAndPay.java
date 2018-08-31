package matchiFirefox.functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import matchiFirefox.MatchiSearchBaselineFireFox;


	
public class MatchiBookAndPay extends MatchiSearchBaselineFireFox{
	
	//
	// METHOD FOR TESTING BOOKING AND PAY BY CREDIT CARD
	//
	
	
	/**
	 * fills out the desired date
	 * @param string is the date given.
	 */	
	public static void chooseDate(String string) {
			WebElement element = webDriver.findElement(By.id("showDate"));
			element.clear();
			element.click();
			element.sendKeys(string);
		}
	
	/**
	 * once a venue is chosen this method chooses a time.
	 * @param string represent the court (row in a table start with 2) 
	 * @param string2 determines corresponding time (column in a table start with 1)
	 */
	public static void chooseCourtTime(String string, String string2) {
		WebElement element = webDriver.findElement(By.xpath("//tbody//tr["+string+"]//td[2]//table[1]//tbody[1]//tr[1]//td["+string2+"]"));
		element.click();
	}
	
	
	/**
	 * simply confirming confirming after adding the times.
	 */
	public static void confirmMultCourtTime() {
		WebElement element = webDriver.findElement(By.xpath("//div[@class='col-sm-5 col-xs-12 no-horizontal-padding text-right']//a[@id='block-book']"));
		element.click();
		delay(2000);
		WebElement element2 = webDriver.findElement(By.xpath("//input[@id='btnSubmit']"));
		element2.click();
	}
	
	/**
	 * simply clicking the "boka flera" button.
	 */
	public static void pickMultCourtTime() {
		WebElement element = webDriver.findElement(By.xpath("//div[@class='col-sm-5 col-xs-12 no-horizontal-padding text-right']//a[@id='block-book-start']"));
		element.click();
	}
	
	/**
	 * Goes through the checkout process and fills out credit card info
	 * @param string -Is the cardnumber
	 * @param string2 -Name of cardholder
	 * @param string3 -fills out the CVC
	 */
	public static void payCourtByCard(String string, String string2, String string3) {
		WebElement element = webDriver.findElement(By.xpath("//label[@for='CREDIT_CARD']"));
		element.click();
		WebElement element2 = webDriver.findElement(By.xpath("//input[@id='btnSubmit']"));
		element2.click();
		WebElement element3 = webDriver.findElement(By.xpath("//input[@placeholder='Kortnummer']"));
		element3.click();
		element3.sendKeys(string);
		WebElement element4 = webDriver.findElement(By.xpath("//input[@placeholder='För- och efternamn']"));
		element4.click();
		element4.sendKeys(string2);
		WebElement element5 = webDriver.findElement(By.xpath("//input[@placeholder='cvc / cid']"));
		element5.click();
		element5.sendKeys(string3);
		WebElement element6 = webDriver.findElement(By.xpath("//option[@value='10']"));
		element6.click();
		WebElement element7 = webDriver.findElement(By.xpath("//option[@value='2020']"));
		element7.click();
		WebElement element8 = webDriver.findElement(By.xpath("//input[@value='Slutför betalning']"));
		element8.click();	
	}
	
	
	
  
	public static void payWithSavedCard() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"btnSubmit\"]"));
		element.click();
	}
	
	
	
	/**
	 * checks the page for info, atm it checks the top sentence.
	 * @param expected -expected text when method run like "Tack för din bokning!"
	 * @return -returns true if expected matches what the page says.
	 */
	public static boolean assertBooking(String expected) {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"userBookingModal\"]/div[1]/div/div[2]/h1"));
		String text = element.getText();	
		return expected.contains(text);
	}
	
	/**
	 * unbooks the time to reset test state
	 * will rewrite this and unBookAgain to be one and the same
	 */
	public static void unBook() {
		WebElement element = webDriver.findElement(By.xpath("//a[@class='btn btn-success']"));
		element.click();
		WebElement element2 = webDriver.findElement(By.xpath("//span[@class='badge']"));
		element2.click();
		WebElement element3 = webDriver.findElement(By.xpath("//a[@class='userCancelBooking']//div[@class='media-body']"));
		element3.click();
		delay(2000);
		WebElement element4 = webDriver.findElement(By.xpath("//*[@id=\"userBookingModal\"]/div[2]/div/div[3]/a[2]"));
		element4.click();
		WebElement element5 = webDriver.findElement(By.xpath("//button[@id='cancelCloseBtn']"));
		element5.click();
	}
	
	/**
	 * temporary fix to unBook method.
	 */
	public static void unBookAgain() {
		WebElement element2 = webDriver.findElement(By.xpath("//span[@class='badge']"));
		element2.click();
		WebElement element3 = webDriver.findElement(By.xpath("//a[@class='userCancelBooking']//div[@class='media-body']"));
		element3.click();
		delay(2000);
		WebElement element4 = webDriver.findElement(By.xpath("//*[@id=\"userBookingModal\"]/div[2]/div/div[3]/a[2]"));
		element4.click();
		WebElement element5 = webDriver.findElement(By.xpath("//button[@id='cancelCloseBtn']"));
		element5.click();
	}


}

