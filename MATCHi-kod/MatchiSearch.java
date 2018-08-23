package matchi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

	
public class MatchiSearch {
	private WebDriver webDriver;

		public MatchiSearch() {
		System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
//Go to the homepage
	public void openSite(String siteUrl) {
		webDriver.get(siteUrl);
	}
	
//Log in to your profile
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
 * Go to the page "Boka"
 */	
	public void pageBook() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li[1]/a"));
		element.click();
	}
	
/**
 * Go to the page "Anläggningar"	
 */
	public void pageVenues() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\'navbar-collapse\']/ul[1]/li[2]/a"));
		element.click();
	}
	
/**
 * Search sports via "Boka"
 */
	public void searchSport() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[2]/div/div/button")); 
		element.click();		
	}
	
/**
 * Search for sports via "Min profil"	
 */
	public void searchSportMyProfile() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[1]/div/div/button/span[2]")); 
		element.click();
	}
	
/**
 * Search for all sports via "Anläggningar"	
 */
	public void searchAllSports() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[3]/div/button/span[1]")); 
		element.click();
	}
	
/**
 * Select the desired sport 
 * @param string
 */
	public void chooseSport(String string) {
		WebElement element = webDriver.findElement(By.partialLinkText(string));
		element.click();	
	}

/**
 * Choose the date on the "Min profil"-page
 * @param string
 */
	public void chooseDayOnMyPage(String string) {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"date\"]"));
		element.click();
		element.sendKeys(Keys.TAB);
		element.clear(); 
		element.sendKeys(string);
	}
	
/**
 * Choose the date on the Boka"-page
 * @param string
 */
	public void chooseDayOnBook(String string) {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"showDate\"]"));
		element.click();
		element.sendKeys(Keys.TAB);
		element.clear(); 
		element.sendKeys(string);
	}
	
/**
 * Search the desired City/Venue
 * @param area - this gets the parameter that is entered in the testcases
 */
	public void searchArea(String area) {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"q\"]"));
		element.click();
		element.sendKeys(area);
		element.sendKeys(Keys.ENTER);
	}

/**
 * Click to get list of county	
 */
	public void clickCounty() {
		WebElement element = webDriver.findElement (By.xpath("//*[@id=\'findFacilityForm\']/div/div[2]/div/button/span[1]"));
		element.click();
	}
	
/**
 * Select desired county	
 * @param county - this gets the parameter that is entered in the testcases
 * "SearchMonthDayTimeViaVenues" and "SearchVenueViaVenues"
 */
	public void chooseCounty(String county) {
		WebElement element = webDriver.findElement (By.xpath("//*[@id=\"findFacilityForm\"]/div/div[2]/div/div/div/input"));
		element.sendKeys(county);
	}
	
/**
 * Click on desired county (Slå ihop denna med ovan?)	
 */
	public void selectCounty() {
		WebElement element = webDriver.findElement (By.partialLinkText("(1)"));
		element.click();	
	}
	
/**
 * Click on displayed result
 */
	public void chooseVenue() {
		WebElement element = webDriver.findElement (By.xpath("//*[@id='findFacilityForm']/div/div[5]/button"));
		element.click();
	}
	
/**
 * Select the desired time on "Anläggningar" (time selected is 18:00)	
 */
	public void chooseTimeInVenues() {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0,500)");
		WebElement element = webDriver.findElement (By.xpath("//*[@id=\"schedule\"]/div/div/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr/td[12]"));
		element.click();
	}
	
/**
 * Click on Venue-result	
 * @param venue - this gets the parameter that is entered in the testcase "SearchMonthDayTimeViaVenues"
 */
	public void selectVenue(String venue) {	
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement element = webDriver.findElement (By.partialLinkText(venue));
		element.click();
	}
	
/**
 * Click on in/out court-selection	
 */
	public void searchInOutCourt() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[1]/div/div/button"));
		element.click();
	}
	
/**
 * Choose desired in/out court	
 * @param string - this gets the parameter that is entered in the testcases
 */
	public void chooseInOutCourt(String string) {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[1]/div/div/div/ul/li[2]/a/span[1]"));
		element.click();
	}
	
/**
 * Click on Search-button
 */
	public void clickSearchButton() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"submit\"]"));
		element.click();
	}
	
/**
 * Click on SMASH-button	
 */
	public void clickSmashButton() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[4]/button"));
		element.click();
	}
	
/**
 * Time is selected	
 */
	public void chooseTime() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"slots_18\"]/ul/li[12]/button"));
		element.click();
	}
		
	/**
	 * ends the session
	 */
	public void quitSelenium() {
		webDriver.quit();
	}

}
