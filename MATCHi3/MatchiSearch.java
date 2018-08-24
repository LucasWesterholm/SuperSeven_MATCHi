package MATCHi3;

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
			System.setProperty("webdriver.chrome.driver", "/Users/lotber/automatisering/chromedriver");
			//	System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
			webDriver = new ChromeDriver();
			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		public void openSite(String siteUrl) {
			webDriver.get(siteUrl);
			}
		
		// 
		//METHODS FOR TESTING LOGIN FUNCTIONALITIES
		//
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
			return text.equals(negativePassword);
		}
		
		/**
		 * Checking message when usage of CORRECT credentials for webpage https://beta1.matchi.se
		 * @param positivePassword
		 * @return
		 */
		public boolean logInPositiveCheck(String positivePassword) {
			WebElement element = webDriver.findElement(By.className("media-heading"));
			String text = element.getText();
			return text.equals(positivePassword);
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

		//
		// METHODS FOR SEARCHING VENUES & MONTH-DAY-TIME FUNCTIONALITIES
		//
		
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
			//	element.sendKeys(Keys.CONTROL+"a");
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
			//	element.sendKeys(Keys.CONTROL+"a");
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
			
			//
			//  METHODS FOR TESTING BOOK PAYMENT BY CREDIT CARD
			//
			
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
		
			//
			// METHOD FOR TESTING BOOKING SEVERAL TIMESLOTS AND/OR COURTS
			// 
			
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
		
		
		public void delay(int milliseconds)
		{
			try {
				Thread.sleep(milliseconds);
			} catch (InterruptedException e) {
			}
		}
			public void quitSelenium() {
				webDriver.quit();
				}
			
	}
