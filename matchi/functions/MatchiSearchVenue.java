package matchi.functions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import matchi.MatchiBaseline;


	
public class MatchiSearchVenue extends MatchiBaseline{

	//
	// METHOD FOR TESTING SEARCHING VENUES
	//
			
/**
 * Go to the page "Boka"
 */	
	public static void pageBook() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li[1]/a"));
		element.click();
	}
	
/**
 * Go to the page "Anläggningar"	
 */
	public static void pageVenues() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\'navbar-collapse\']/ul[1]/li[2]/a"));
		element.click();
	}
	
/**
 * Search sports via "Boka"
 */
	public static void searchSportViaBook() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[2]/div/div/button")); 
		element.click();		
	}
	
/**
 * Book via "Min profil"	
 */
	public static void bookViaMyProfile() {
	//WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[1]/div/div/button/span[2]")); 
		WebElement element = webDriver.findElement(By.className("fa-plus"));
		element.click();
	}
	
	
/**
 * Search for all sports via "Anläggningar"	
 */
	public static void searchAllSportsViaVenues() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[3]/div/button/span[1]")); 
		element.click();
	}
	
	/**
	 * Search for sports via "Min profil"	
	 */		
		public static void searchSportViaMyProfile() {
			WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[1]/div/div/button"));
			element.click();
		}
	
/**
 * Select the desired sport 
 * @param string
 */
	public static void selectSport(String sport) {
		WebElement element = webDriver.findElement(By.partialLinkText(sport));
		element.click();	
	}
	public static void selectSportViaMyProfile(String sport) {
		WebElement element = webDriver.findElement(By.partialLinkText(sport));
		element.click();	
	}
	
	/**
	 * Select the desired sport via Venues
	 * @param string
	 */
		public static void selectSportViaVenues(String sport) {
			WebElement element = webDriver.findElement(By.partialLinkText(sport));
			element.click();	
		}

/**
 * Select the date on the "Min profil"-page
 * @param day
 */
	public static void selectDayViaMyPage(String day) {
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
	public static void selectDayViaBook(String day) {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"showDate\"]"));
		element.click();
		element.sendKeys(Keys.TAB);
		element.clear(); 
		element.sendKeys(day);
	}
	
/**
 * Search the desired City/Venue
 * @param area - this gets the parameter that is entered in the test cases
 */
	public static void searchCityVenue(String area) {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"q\"]"));
		element.click();
		element.sendKeys(area);
		element.sendKeys(Keys.ENTER);
		
	}
	
	/**
	 * Choose desired venue.
	 * @param string  - this gets the parameter that is entered in the test cases
	 */
	public static void chooseVenue(String string) {
		WebElement element = webDriver.findElement (By.partialLinkText(string));
		element.click();
		}

/**
 * Click to get up the list of counties	
 */
	public static void clickOnCountyViaVenues() {
		WebElement element = webDriver.findElement (By.xpath("//*[@id=\'findFacilityForm\']/div/div[2]/div/button/span[1]"));
		element.click();
	}
	
/**
 * Search desired county	
 * @param county - this gets the parameter that is entered in the test cases
 * 
 */
	public static void searchCountyViaVenues(String county) {
		WebElement element = webDriver.findElement (By.xpath("//*[@id=\"findFacilityForm\"]/div/div[2]/div/div/div/input"));
		element.sendKeys(county);
	}
	
/**
 * Select desired county	
 */
	public static void selectCountyViaVenues() {
		WebElement element = webDriver.findElement (By.partialLinkText("(1)"));
		element.click();	
	}
	
/**
 * Select displayed result
 */
	public static void selectVenueViaBook() {
		WebElement element = webDriver.findElement (By.xpath("//*[@id='findFacilityForm']/div/div[5]/button"));
		element.click();
	}
	
/**
 * Select the Venue-result	
 * @param venue - this gets the parameter that is entered in the test case
 */
	
	public static void selectVenueViaVenue(String venue) {	
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement element = webDriver.findElement (By.partialLinkText(venue));
		element.click();
	}
	
	
/**
 * Search in/out court-selection	
 */
	public static void searchInOutCourt() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[1]/div/div/button"));
		element.click();
	}
	
/**
 * Select desired in/out court	
 * @param court - this gets the parameter that is entered in the test cases
 */
	public static void selectInOutCourt(String court) {
	//	WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[1]/div/div/div/ul/li[2]/a/span[1]")); ---- ORGINAL EJ FUNGERANDE
		WebElement element = webDriver.findElement(By.linkText(court));
		element.click();
	}
	

	

}