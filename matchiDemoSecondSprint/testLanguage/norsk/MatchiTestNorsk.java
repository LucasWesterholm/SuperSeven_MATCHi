package matchiDemoSecondSprint.testLanguage.norsk;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import matchiDemoSecondSprint.MatchiBaseline;
import matchiDemoSecondSprint.functions.MatchiBookAndPay;
import matchiDemoSecondSprint.functions.MatchiPayBySwish;
import matchiDemoSecondSprint.functions.MatchiSearchLogIn;
import matchiDemoSecondSprint.functions.MatchiSearchVenue;

public class MatchiTestNorsk {
	String browser = "Firefox";
	/**
	 * Login test with correct credentials and check if logged in
	 * 
	 */
	@Test
	public void LogInTestNo() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("NORSK");
		MatchiSearchLogIn.logInPositiveCheck("Mjuk Varutestare");
		msb.selectLanguage("SVENSKA");
		msb.quitSelenium();
		}

	/**
	 * Login test with false credentials and check error message
	 * 
	 */
	@Test
	public void LogInNegativeTestNo() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.selectLanguage("NORSK");
		MatchiSearchLogIn.logInNegative();
		assertTrue(MatchiSearchLogIn.logInNegativeCheck("Feilaktig brukernavn eller passord"));
		msb.quitSelenium();
	}
	
	/**
	 * Book for one session and unBooking via menu Boka pay by new CC
	 * 
	 */
	@Test
	public void BookOneSessionViaBokaNo() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("NORSK");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Innendørs");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("10/09/2018");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenue();
		MatchiBookAndPay.chooseCourtTime("2", "12");
		MatchiBookAndPay.enterCCdetails("2223000048410010", "MjukVarutestare", "737");
		MatchiBookAndPay.assertBooking("Takk skal du ha for bookingen din!");
		MatchiBookAndPay.unBook();
		msb.selectLanguage("SVENSKA");
		msb.quitSelenium();
	}
	
	/**
	 * Book for one session and unBooking via menu Boka pay by saved CC
	 * 
	 */
	@Test
	public void BookOneSessionWithSavedCaViaBokaNo() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("NORSK");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Utendørs");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("10/09/2018");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenue();
		MatchiBookAndPay.chooseCourtTime("2", "15");
		MatchiBookAndPay.assertBookingDay("10/9");
		MatchiBookAndPay.assertBookingTime("21.00-22.00");
		MatchiBookAndPay.payWithSavedCard();
		MatchiBookAndPay.assertBooking("Takk skal du ha for bookingen din!");
		MatchiBookAndPay.unBook();
		msb.selectLanguage("SVENSKA");
		msb.quitSelenium();
	}
	
	/**
	 * Book and pay for one session with false CVC via menu Boka pay by new CC
	 * 
	 */
	@Test
	public void BookOneSessionViaBokaFalseCVCNo() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("NORSK");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Innendørs");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("10/09/2018");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenue();
		MatchiBookAndPay.chooseCourtTime("2", "11");
		MatchiBookAndPay.enterCCdetails("2223000048410010", "MjukVarutestare", "373");
		MatchiBookAndPay.assertBooking("Et problem ble oppdaget!");
		MatchiBookAndPay.closePaymentWindow();
		msb.selectLanguage("SVENSKA");
		msb.quitSelenium();
	}
	
	/**
	 * Book and pay for multiple session and unBooking them via menu Boka pay by CC
	 * 
	 */ 
	@Test
	public void BookMultipleSessionsViaBokaNo() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("NORSK");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Utendørs");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("10/09/2018");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenue();
		MatchiBookAndPay.pickMultCourtTime();
		MatchiBookAndPay.chooseCourtTime("2", "8");
		MatchiBookAndPay.chooseCourtTime("2", "10");
		MatchiBookAndPay.chooseCourtTime("3", "9");
		MatchiBookAndPay.confirmMultCourtTime();
		MatchiBookAndPay.assertBookingDay("10/9");
		MatchiBookAndPay.assertBookingTime("16.00-17.00");
		MatchiBookAndPay.assertBooking("Takk skal du ha for bookingen din!");
		MatchiBookAndPay.unBook();
		MatchiBookAndPay.unBookAgain();
		MatchiBookAndPay.unBookAgain();
		msb.selectLanguage("SVENSKA");
		msb.quitSelenium();
	}
	
	/**
	 * Book via menu Venues pay by new CC
	 * 
	 */	
	@Test
	public void BookOneSessionViaVenuesNo() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("NORSK");
		MatchiSearchVenue.pageVenues();
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSearchButton();
		MatchiSearchVenue.chooseVenue();
		MatchiSearchVenue.selectSportViaVenues("Tennis (Utendørs)");
		MatchiBookAndPay.chooseCourtTime("2", "14");
		MatchiBookAndPay.enterCCdetails("2223000048410010", "MjukVarutestare", "737");
		MatchiBookAndPay.assertBooking("Takk skal du ha for bookingen din!");
		MatchiBookAndPay.unBook();
		msb.selectLanguage("SVENSKA");
		msb.quitSelenium();
	}
			
	/**
	 * Search and book, county & courts via menu Venues pay by Swish
	 * 
	 */
//	@Test
	public void SearchCountyCourtViaVenuesNo() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("NORSK");
		MatchiSearchVenue.pageVenues();
		MatchiSearchVenue.searchCityVenue("Stenungsund");
		msb.clickSearchButton();
		MatchiSearchVenue.chooseVenue();
		MatchiSearchVenue.selectSportViaVenues("Tennis");
		MatchiBookAndPay.chooseCourtTime("2", "11");
		msb.delay(500);
		MatchiPayBySwish.payBySwish();
		MatchiPayBySwish.writeMobileNumber("0046123456789");
	//	MatchiBookAndPay.unBook();
	//	msb.selectLanguage("SVENSKA");
		msb.quitSelenium();
	}
		
	/**
	 * Book via MyPage 
	 */
	@Test
	public void BookOneSessionViaMyPageSv() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("NORSK");
		MatchiSearchVenue.searchSportViaMyProfile();
		MatchiSearchVenue.selectSportViaMyProfile("Tennis");
		MatchiSearchVenue.selectDayViaMyPage("2018-09-12");
		MatchiSearchVenue.searchCityVenue("Stenungsund");
		msb.clickSmashButtonOnMyProfile();
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenue();
		MatchiBookAndPay.chooseCourtTime("2", "12");
		MatchiBookAndPay.payWithSavedCard();
		MatchiBookAndPay.assertBooking("Takk skal du ha for bookingen din!");
		MatchiBookAndPay.unBook();
		msb.selectLanguage("SVENSKA");
		msb.quitSelenium();
	}

}
