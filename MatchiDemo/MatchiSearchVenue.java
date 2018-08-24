package matchi.matchi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

	
public class MatchiSearchVenue {
	private WebDriver webDriver;

		public MatchiSearchVenue() {
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
		usernameElement.sendKeys("mjukvarutestare3@mailinator.com");			WebElement passwordElement = webDriver.findElement(By.cssSelector("#password"));
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
 * Go to the page "Anl�ggningar"	
 */
	public void pageVenues() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\'navbar-collapse\']/ul[1]/li[2]/a"));
		element.click();
	}
	
/**
 * Search sports via "Boka"
 */
	public void searchSportViaBook() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[2]/div/div/button")); 
		element.click();		
	}
	
/**
 * Search for sports via "Min profil"	
 */
	public void searchSportViaMyProfile() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[1]/div/div/button/span[2]")); 
		element.click();
	}
	
/**
 * Search for all sports via "Anl�ggningar"	
 */
	public void searchAllSportsViaVenues() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[3]/div/button/span[1]")); 
		element.click();
	}
	
/**
 * Select the desired sport 
 * @param string
 */
	public void selectSport(String sport) {
		WebElement element = webDriver.findElement(By.partialLinkText(sport));
		element.click();	
	}

/**
 * Select the date on the "Min profil"-page
 * @param day
 */
	public void selectDayViaMyPage(String day) {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"date\"]"));
		element.click();
		element.sendKeys(Keys.TAB);
		element.clear(); 
		element.sendKeys(day);
	}
	
/**
 * Select the date on the "Boka"-page
 * @param day
 */
	public void selectDayViaBook(String day) {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"showDate\"]"));
		element.click();
		element.sendKeys(Keys.TAB);
		element.clear(); 
		element.sendKeys(day);
	}
	
/**
 * Search the desired City/Venue
 * @param area - this gets the parameter that is entered in the testcases
 */
	public void searchCityVenue(String area) {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"q\"]"));
		element.click();
		element.sendKeys(area);
		element.sendKeys(Keys.ENTER);
	}

/**
 * Click to get up the list of counties	
 */
	public void clickOnCountyViaVenues() {
		WebElement element = webDriver.findElement (By.xpath("//*[@id=\'findFacilityForm\']/div/div[2]/div/button/span[1]"));
		element.click();
	}
	
/**
 * Search desired county	
 * @param county - this gets the parameter that is entered in the testcases
 * "SearchMonthDayTimeViaVenues-test" and "SearchVenueViaVenues-test". 
 */
	public void searchCountyViaVenues(String county) {
		WebElement element = webDriver.findElement (By.xpath("//*[@id=\"findFacilityForm\"]/div/div[2]/div/div/div/input"));
		element.sendKeys(county);
	}
	
/**
 * Select desired county	
 */
	public void selectCountyViaVenues() {
		WebElement element = webDriver.findElement (By.partialLinkText("(1)"));
		element.click();	
	}
	
/**
 * Select displayed result
 */
	public void selectVenueViaBook() {
		WebElement element = webDriver.findElement (By.xpath("//*[@id='findFacilityForm']/div/div[5]/button"));
		element.click();
	}
	
/**
 * Select the Venue-result	
 * @param venue - this gets the parameter that is entered in the testcase "SearchMonthDayTimeViaVenues"
 */
	public void selectVenueViaVenue(String venue) {	
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement element = webDriver.findElement (By.partialLinkText(venue));
		element.click();
	}
	
/**
 * Search in/out court-selection	
 */
	public void searchInOutCourt() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[1]/div/div/button"));
		element.click();
	}
	
/**
 * Select desired in/out court	
 * @param court - this gets the parameter that is entered in the testcases
 */
	public void selectInOutCourt(String court) {
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
	 * ends the session
	 */
	public void quitSelenium() {
		webDriver.quit();
	}

}