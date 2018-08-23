import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

	
public class MatchiSearch {
	private WebDriver webDriver;

		public MatchiSearch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\j-g_9\\eclipse-workspace\\Library\\chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		/** testing pull to Git
		 * 
		 */
//method OK	
	public void openSite(String siteUrl) {
		webDriver.get(siteUrl);
		}
	
//method OK		
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
	
//method OK
	public void book() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li[1]/a"));
		element.click();
		}
	
//method OK when go from home page. NOT working from the menu Boka 
	public void chooseSportWithOutLogin(String string) {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"hero\"]/div/div/div[1]/div/form/div/div[1]/div/div/ul/li[2]/a")); 
		element.click();
		}
	
	public void searchSport() {
		WebElement element = webDriver.findElement(By.xpath("//span[@class='filter-option pull-left']"));
		element.click();
	}
	
	
//method OK
	public void chooseSport(String string) {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"hero\"]/div/div/div[1]/div/form/div/div[1]/div/div/ul/li[2]/a")); 
		element.click();
		}
	
//method OK
	public void searchDay() {
		WebElement element = webDriver.findElement(By.id("date"));
		element.click();
	}
	
	//date value 2018-08-31 - need to add functionality for choosing different month than existing

	public void chooseDay(String string) {
		WebElement element = webDriver.findElement(By.cssSelector("#date"));
	//#date
		//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[6]/a"   = 31 aug
		//*[@id="ui-datepicker-div"]/table/tbody/tr[4]/td[3]/a" 	= 21 aug
		element.click();
		element.sendKeys(string);
	}
	/**
	 * MSJ
	 * fills out the desired date
	 * @param string is the date given.
	 */
	public void chooseDate(String string) {
		WebElement element = webDriver.findElement(By.xpath("//input[@id='date']"));
		element.click();
		element.sendKeys(Keys.CONTROL+"a");
		element.sendKeys(string);
	}
	/**
	 *MSJ
	 * once a venue is chosen this method chooses a time.
	 * @param string determine what court vertically with "2" being top choice and 3 the one below and so on. 
	 * @param string2 determines courttime horizontally with "1" being the leftmost time and then ascending in numerical order.
	 */
	public void chooseCourtTime(String string, String string2) {
		WebElement element = webDriver.findElement(By.xpath("//tbody//tr["+string+"]//td[2]//table[1]//tbody[1]//tr[1]//td["+string2+"]"));
		element.click();
	}
	/**
	 * simply confirming confirming after adding the times.
	 */
	public void confirmMultCourtTime() {
		WebElement element = webDriver.findElement(By.xpath("//div[@class='col-sm-5 col-xs-12 no-horizontal-padding text-right']//a[@id='block-book']"));
		element.click();
		delay(2000);
		WebElement element2 = webDriver.findElement(By.xpath("//input[@id='btnSubmit']"));
		element2.click();
	}
	/**
	 * simply clicking the "boka flera" button.
	 */
	public void pickMultCourtTime() {
		WebElement element = webDriver.findElement(By.xpath("//div[@class='col-sm-5 col-xs-12 no-horizontal-padding text-right']//a[@id='block-book-start']"));
		element.click();
	}
	
//method OK
	public void searchArea() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"q\"]"));
		element.click();
		}
	
//method OK	
	public void chooseArea(String string) {
		WebElement element = webDriver.findElement(By.id("q"));
		element.click();
		element.sendKeys();
		element.sendKeys(Keys.ENTER);
	}
	
//method OK	
	public void chooseVenue(String string) {
		WebElement element = webDriver.findElement(By.xpath("//input[@id='q']"));
		element.click();
		element.sendKeys(string);
		WebElement element2 = webDriver.findElement(By.xpath("//button[@name='submit']"));
		element2.click();
		WebElement element3 = webDriver.findElement(By.xpath("//a[@class='text-black weight400']"));
		element3.click();
	}
	/**
	 * Goes through the checkout process and fills out credit card info
	 * @param string -Is the cardnumber
	 * @param string2 -Name of cardholder
	 * @param string3 -fills out the CVC
	 */
	public void payCourtByCard(String string, String string2, String string3) {
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
	/**
	 * checks the page for info, atm it checks the top sentence.
	 * @param expected -expected text when method run like "Tack för din bokning!"
	 * @return -returns true if expected matches what the page says.
	 */
	public boolean assertBooking(String expected) {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"userBookingModal\"]/div[1]/div/div[2]/h1"));
		String text = element.getText();	
		return expected.contains(text);
	}	
	/**
	 * unbooks the time to reset teststate
	 * will rewrite this and unBookAgain to be one and the same
	 */
	public void unBook() {
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
	public void unBookAgain() {
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
	
	public void searchInOutCourt() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[1]/div/div/button"));
		element.click();
	}
	
	public void chooseInOutCourt(String string) {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[1]/div/div/div/ul/li[2]/a/span[1]"));
		element.click();
	}
	
	public void quitSelenium() {
		webDriver.quit();
	}
	
	public void delay(int milliseconds)
	{
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
		}
	}

}
