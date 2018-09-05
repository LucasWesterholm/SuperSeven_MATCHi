package matchiDemoSecondSprint.testLanguage.svenska;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import matchiDemoSecondSprint.MatchiBaseline;
import matchiDemoSecondSprint.functions.MatchiBookAndPay;
import matchiDemoSecondSprint.functions.MatchiPayBySwish;
import matchiDemoSecondSprint.functions.MatchiSearchLogIn;
import matchiDemoSecondSprint.functions.MatchiSearchVenue;


public class MatchiTestSvenska {
	String browser = "Chrome";
	/**
	 * Login test with correct credentials and check if logged in
	 */
	@Test
	public void LogInTestSv() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("SVENSKA");
		MatchiSearchLogIn.logInPositiveCheck("Mjuk Varutestare");
		msb.quitSelenium();
		}
		
	/**
	 * Login test with false credentials and check error message
	 * 
	 */
	@Test
	public void LogInNegativeTestSv() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.selectLanguage("SVENSKA");
		MatchiSearchLogIn.logInNegative();
		assertTrue(MatchiSearchLogIn.logInNegativeCheck("Felaktigt användarnamn eller lösenord"));
		msb.quitSelenium();
	}
	
	/**
	 * Book for one session and unBooking via menu Boka pay by new CC
	 * 
	 */
	@Test
	public void BookOneSessionViaBokaSv() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("SVENSKA");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Inomhus");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-09-10");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenue();
		MatchiBookAndPay.chooseCourtTime("2", "13");
		MatchiBookAndPay.enterCCdetails("2223000048410010", "MjukVarutestare", "737");
		MatchiBookAndPay.assertBooking("Tack för din bokning!");
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
	
	/**
	 * Book for one session and unBooking via menu Boka pay by saved CC
	 * 
	 */
	@Test
	public void BookOneSessionWithSavedCaViaBokaSv() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("SVENSKA");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Utomhus");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-09-10");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenue();
		MatchiBookAndPay.chooseCourtTime("2", "15");
		MatchiBookAndPay.assertBookingDay("10/9");
		MatchiBookAndPay.assertBookingTime("16.00-17.00");
		MatchiBookAndPay.payWithSavedCard();
		MatchiBookAndPay.assertBooking("Tack för din bokning!");
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
		/**
	 * Book and pay for one session with false CVC via menu Boka pay by new CC
	 * 
	 */
	@Test
	public void BookOneSessionViaBokaFalseCVCSv() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("SVENSKA");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Inomhus");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-09-10");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenue();
		MatchiBookAndPay.chooseCourtTime("2", "15");
		MatchiBookAndPay.enterCCdetails("2223000048410010", "MjukVarutestare", "373");
		MatchiBookAndPay.assertBooking("Ett problem uppstod!");
		msb.quitSelenium();
	}
	
	/**
	 * Book and pay for multiple session and unBooking them via menu Boka pay by CC
	 * 
	 */ 
	@Test
	public void BookMultipleSessionsViaBokaSv() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("SVENSKA");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Utomhus");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-09-10");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenue();
		MatchiBookAndPay.pickMultCourtTime();
		MatchiBookAndPay.chooseCourtTime("2", "11");
		MatchiBookAndPay.chooseCourtTime("2", "12");
		MatchiBookAndPay.chooseCourtTime("3", "13");
		MatchiBookAndPay.confirmMultCourtTime();
		MatchiBookAndPay.assertBookingDay("10/9");
		MatchiBookAndPay.assertBookingTime("17.00-18.00");
		MatchiBookAndPay.assertBooking("Tack för din bokning!");
		MatchiBookAndPay.unBook();
		MatchiBookAndPay.unBookAgain();
		MatchiBookAndPay.unBookAgain();
		msb.quitSelenium();
	}
		/**
	 * Book via menu Venues pay by new CC
	 * 
	 */	
	@Test
	public void BookOneSessionViaVenuesSv() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("SVENSKA");
		MatchiSearchVenue.pageVenues();
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSearchButton();
		MatchiSearchVenue.chooseVenue();
		MatchiSearchVenue.selectSportViaVenues("Badminton");
		MatchiBookAndPay.chooseCourtTime("2", "12");
		MatchiBookAndPay.enterCCdetails("2223000048410010", "MjukVarutestare", "737");
		MatchiBookAndPay.assertBooking("Tack för din bokning!");
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
			
	/**
	 * Search and book, county & courts via menu Venues pay by Swish
	 * 
	 */
//	@Test
	public void SearchCountyCourtViaVenuesSv() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("SVENSKA");
		MatchiSearchVenue.pageVenues();
		MatchiSearchVenue.searchCityVenue("Stenungsund");
		msb.clickSearchButton();
		MatchiSearchVenue.chooseVenue();
		MatchiSearchVenue.selectSportViaVenues("Utomhus");
		MatchiBookAndPay.chooseCourtTime("2", "11");
		msb.delay(500);
		MatchiPayBySwish.payBySwish();
		MatchiPayBySwish.writeMobileNumber("0046123456789");
	//	MatchiBookAndPay.unBook();
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
		msb.selectLanguage("SVENSKA");
		MatchiSearchVenue.searchSportViaMyProfile();
		MatchiSearchVenue.selectSportViaMyProfile("Tennis");
		MatchiSearchVenue.selectDayViaMyPage("2018-09-12");
		MatchiSearchVenue.searchCityVenue("Stenungsund");
		msb.clickSmashButtonOnMyProfile();
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenue();
		MatchiBookAndPay.chooseCourtTime("2", "12");
		MatchiBookAndPay.payWithSavedCard();
		MatchiBookAndPay.assertBooking("Tack för din bokning!");
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}

//	@Test
	public void testOrder1() {LogInTestSv();LogInNegativeTestSv();}
//	@Test
	public void testOrder2() {BookOneSessionViaBokaSv();BookOneSessionWithSavedCaViaBokaSv();
	BookOneSessionViaBokaFalseCVCSv();BookMultipleSessionsViaBokaSv();}
//	@Test
	public void testOrder3() {BookOneSessionViaVenuesSv();SearchCountyCourtViaVenuesSv();BookOneSessionViaMyPageSv();	}
}
