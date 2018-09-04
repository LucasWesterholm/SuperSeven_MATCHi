package matchiDemoSecondSprint.testLanguage.norsk;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import matchiDemoSecondSprint.MatchiBaseline;
import matchiDemoSecondSprint.functions.MatchiBookAndPay;
import matchiDemoSecondSprint.functions.MatchiPayBySwish;
import matchiDemoSecondSprint.functions.MatchiSearchLogIn;
import matchiDemoSecondSprint.functions.MatchiSearchVenue;

public class MatchiTestNorsk {

	/**
	 * Login test with correct credentials and check if logged in
	 * 
	 */
	@Test
	public void LogInTestNo() {
		MatchiBaseline msb = new MatchiBaseline();
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
		MatchiBaseline msb = new MatchiBaseline();
		msb.openSite("https://beta1.matchi.se/");
		msb.selectLanguage("NORSK");
		MatchiSearchLogIn.logInNegative();
		msb.delay(2000);
		assertTrue(MatchiSearchLogIn.logInNegativeCheck("Feilaktig brukernavn eller passord "));
		msb.quitSelenium();
	}
	
	/**
	 * Book for one session and unBooking via menu Boka pay by new CC
	 * 
	 */
	@Test
	public void BookOneSessionViaBokaNo() {
		MatchiBaseline msb = new MatchiBaseline();
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("NORSK");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		msb.delay(500);
		MatchiSearchVenue.selectInOutCourt("Innend�rs ");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("10/09/2018");
		MatchiSearchVenue.searchCityVenue("H�n� Tenniss�llskap");
		msb.clickSmashButton();
		msb.delay(2000);
		MatchiSearchVenue.chooseVenue();
		MatchiBookAndPay.chooseCourtTime("2", "12");
		msb.delay(1000);
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
		MatchiBaseline msb = new MatchiBaseline();
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("NORSK");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		msb.delay(1000);
		MatchiSearchVenue.selectInOutCourt("Utend�rs ");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("10/09/2018");
		MatchiSearchVenue.searchCityVenue("H�n� Tenniss�llskap");
		msb.clickSmashButton();
		msb.delay(2000);
		MatchiSearchVenue.chooseVenue();
		msb.delay(2000);
		MatchiBookAndPay.chooseCourtTime("2", "15");
		msb.delay(1000);
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
		MatchiBaseline msb = new MatchiBaseline();
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("NORSK");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Innend�rs ");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("10/09/2018");
		MatchiSearchVenue.searchCityVenue("H�n� Tenniss�llskap");
		msb.clickSmashButton();
		msb.delay(2000);
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
		MatchiBaseline msb = new MatchiBaseline();
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("NORSK");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Utend�rs ");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("10/09/2018");
		MatchiSearchVenue.searchCityVenue("H�n� Tenniss�llskap");
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenue();
		msb.delay(1000);
		MatchiBookAndPay.pickMultCourtTime();
		msb.delay(1000);
		MatchiBookAndPay.chooseCourtTime("2", "8");
		msb.delay(1000);
		MatchiBookAndPay.chooseCourtTime("2", "10");
		msb.delay(2000);
		MatchiBookAndPay.chooseCourtTime("3", "9");
		msb.delay(2000);
		MatchiBookAndPay.confirmMultCourtTime();
		msb.delay(2000);
		MatchiBookAndPay.assertBooking("Takk skal du ha for bookingen din!");
		MatchiBookAndPay.unBook();
		msb.delay(2000);
		MatchiBookAndPay.unBookAgain();
		msb.delay(2000);
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
		MatchiBaseline msb = new MatchiBaseline();
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("NORSK");
		MatchiSearchVenue.pageVenues();
		MatchiSearchVenue.searchCityVenue("H�n� Tenniss�llskap");
		msb.delay(1000);
		msb.clickSearchButton();
		MatchiSearchVenue.chooseVenue();
		msb.delay(1000);
		MatchiSearchVenue.selectSportViaVenues("Tennis (Utend�rs)");
		msb.delay(1000);
		MatchiBookAndPay.chooseCourtTime("2", "14");
		msb.delay(1000);
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
		MatchiBaseline msb = new MatchiBaseline();
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("NORSK");
		MatchiSearchVenue.pageVenues();
		MatchiSearchVenue.searchCityVenue("Stenungsund");
		msb.delay(2000);
		msb.clickSearchButton();
		MatchiSearchVenue.chooseVenue();
		msb.delay(2000);
		MatchiSearchVenue.selectSportViaVenues("Tennis");
		msb.delay(2000);
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
		MatchiBaseline msb = new MatchiBaseline();
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("NORSK");
		MatchiSearchVenue.searchSportViaMyProfile();
		MatchiSearchVenue.selectSportViaMyProfile("Tennis");
		MatchiSearchVenue.selectDayViaMyPage("2018-09-12");
		MatchiSearchVenue.searchCityVenue("Stenungsund");
		msb.clickSmashButtonOnMyProfile();
		msb.clickSmashButton();
		msb.delay(2000);
		MatchiSearchVenue.chooseVenue();
		MatchiBookAndPay.chooseCourtTime("2", "12");
		msb.delay(2000);
		MatchiBookAndPay.payWithSavedCard();
		MatchiBookAndPay.assertBooking("Takk skal du ha for bookingen din!");
		MatchiBookAndPay.unBook();
		msb.selectLanguage("SVENSKA");
		msb.quitSelenium();
	}

}
