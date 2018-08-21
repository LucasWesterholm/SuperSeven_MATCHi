package MatchiLotta;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

	
public class MatchiSearch {
	private WebDriver webDriver;

		public MatchiSearch() {
		System.setProperty("webdriver.chrome.driver", "/Users/lotber/automatisering/chromedriver");
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
//method OK	
	public void openSite(String siteUrl) {
		webDriver.get(siteUrl);
		}
	

	/**
	 * Hard coded login credentials for webpage https://beta1.matchi.se
	 * 
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
		 * Hard coded login with WRONG credentials for webpage https://beta1.matchi.se
		 * 
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
		 * Checking message when usage of WRONG credentials for webpage https://beta1.matchi.se
		 * @param negativePassword
		 * @return
		 */
		public boolean logInNegativeCheck(String negativePassword) {
			WebElement element = webDriver.findElement(By.className("notification-message"));
			String text = element.getText();
			return text.contains(negativePassword);
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
	
//method OK
		public void book() {
			WebElement element = webDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li[1]/a"));
			element.click();
			}
		
//method OK		
		public void searchSport() {
			WebElement element = webDriver.findElement(By.xpath("//button[@title='Välj sport']")); 
			element.click();
			}
		
//method OK	
	
		public void chooseSport(String string) {
			WebElement element = webDriver.findElement(By.partialLinkText(string));
			element.click();
			}
		
// method OK -- hard coded date and time		
		public void chooseDayTimeCourt() {
			WebElement element = webDriver.findElement(By.xpath("//*[@id=\"schedule\"]/div/div/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr/td[16]"));
			element.click();
			}


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
		
//method OK
		public void searchDay() {
			WebElement element = webDriver.findElement(By.id("date"));
			element.click();
			}
	
//method OK  === Renamed and change method
		public void searchAreaOrVenue(String string) {
			WebElement element = webDriver.findElement(By.xpath("//*[@id=\"q\"]"));
			element.click();
			element.sendKeys();
			element.sendKeys(Keys.ENTER);
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
			WebElement element = webDriver.findElement (By.linkText(string));
			element.click();
			}
	
//method OK	
		public void searchInOutCourt() {
			WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[1]/div/div/button"));
			element.click();
			}
	
//method OK	
		public void chooseInOutCourt(String string) {
			WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[1]/div/div/div/ul/li[2]/a/span[1]"));
			element.click();
			}

//method OK
		public void quitSelenium() {
			webDriver.quit();
			}
	
//method OK	
		public void closeSelenium() {
			webDriver.close();
			}
	
}
