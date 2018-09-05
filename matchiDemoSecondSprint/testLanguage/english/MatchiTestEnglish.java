package matchiDemoSecondSprint.testLanguage.english;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import matchiDemoSecondSprint.MatchiBaseline;
import matchiDemoSecondSprint.functions.MatchiBookAndPay;
import matchiDemoSecondSprint.functions.MatchiPayBySwish;
import matchiDemoSecondSprint.functions.MatchiSearchLogIn;
import matchiDemoSecondSprint.functions.MatchiSearchVenue;


public class MatchiTestEnglish {
	String browser = "Edge";
	/**
	 * Login test with correct credentials and check if logged in
	 * 
	 */
	@Test
	public void LogInTestEn() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("ENGLISH");
		MatchiSearchLogIn.logInPositiveCheck("Mjuk Varutestare");
		msb.selectLanguage("SVENSKA");
		msb.quitSelenium();
		}

		
	/**
	 * Login test with false credentials and check error message
	 * 
	 */
	@Test
	public void LogInNegativeTestEn() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.selectLanguage("ENGLISH");
		MatchiSearchLogIn.logInNegative();
		assertTrue(MatchiSearchLogIn.logInNegativeCheck("Incorrect username or password "));
		msb.quitSelenium();
	}
	/**
	 * Book for one session and unBooking via menu Boka pay by new CC
	 * 
	 */
	@Test
	public void BookOneSessionViaBokaEn() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("ENGLISH");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Indoors ");
		MatchiSearchVenue.searchSportViaBook();
		msb.delay(2000);
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-09-10");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenue();
		MatchiBookAndPay.chooseCourtTime("2", "12");
		MatchiBookAndPay.assertBookingDay("10/9");
		MatchiBookAndPay.assertBookingTime("18.00-19.00");
		MatchiBookAndPay.enterCCdetails("2223000048410010", "MjukVarutestare", "737");
		MatchiBookAndPay.assertBooking("Thank you for your booking!");
		MatchiBookAndPay.unBook();
		msb.selectLanguage("SVENSKA");
		msb.quitSelenium();
	}
	
	
	/**
	 * Book for one session and unBooking via menu Boka pay by saved CC
	 * 
	 */
	@Test
	public void BookOneSessionWithSavedCaViaBokaEn() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("ENGLISH");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Outdoors ");
		MatchiSearchVenue.searchSportViaBook();
		msb.delay(2000);
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-09-10");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenue();
		MatchiBookAndPay.chooseCourtTime("2", "15");
		MatchiBookAndPay.payWithSavedCard();
		MatchiBookAndPay.assertBooking("Thank you for your booking!");
		MatchiBookAndPay.unBook();
		msb.selectLanguage("SVENSKA");
		msb.quitSelenium();
	}
	
	/**
	 * Book and pay for one session with false CVC via menu Boka pay by new CC
	 * 
	 */
	@Test
	public void BookOneSessionViaBokaFalseCVCEn() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("ENGLISH");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Indoors ");
		MatchiSearchVenue.searchSportViaBook();
		msb.delay(2000);
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-09-10");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenue();
		MatchiBookAndPay.chooseCourtTime("2", "11");
		MatchiBookAndPay.enterCCdetails("2223000048410010","MjukVarutestare", "373");
		MatchiBookAndPay.assertBooking("A problem was detected!");
		MatchiBookAndPay.closePaymentWindow();
		msb.selectLanguage("SVENSKA");
		msb.quitSelenium();
	}
	
	/**
	 * Book and pay for multiple session and unBooking them via menu Boka pay by CC
	 * 
	 */ 
	@Test
	public void BookMultipleSessionsViaBokaEn() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("ENGLISH");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Outdoors ");
		MatchiSearchVenue.searchSportViaBook();
		msb.delay(2000);
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-09-10");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenue();
		MatchiBookAndPay.pickMultCourtTime();
		MatchiBookAndPay.chooseCourtTime("2", "8");
		MatchiBookAndPay.chooseCourtTime("2", "10");
		MatchiBookAndPay.chooseCourtTime("3", "9");
		msb.delay(2000);
		MatchiBookAndPay.confirmMultCourtTime();
		msb.delay(2000);
		MatchiBookAndPay.assertBookingDay("10/9");
		MatchiBookAndPay.assertBookingTime("16.00-17.00");
		MatchiBookAndPay.assertBooking("Thank you for your booking!");
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
	public void BookOneSessionViaVenuesEn() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("ENGLISH");
		MatchiSearchVenue.pageVenues();
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSearchButton();
		MatchiSearchVenue.chooseVenue();
		msb.delay(1000);
		MatchiSearchVenue.selectSportViaVenues("Tennis (Outdoors)");
		msb.delay(1000);
		MatchiBookAndPay.chooseCourtTime("2", "15");
		msb.delay(1000);
		MatchiBookAndPay.enterCCdetails("2223000048410010", "MjukVarutestare", "737");
		MatchiBookAndPay.assertBooking("Thank you for your booking!");
		MatchiBookAndPay.unBook();
		msb.selectLanguage("SVENSKA");
		msb.quitSelenium();
	}
	
		
	/**
	 * Search and book, county & courts via menu Venues pay by Swish
	 * 
	 */
//	@Test
	public void SearchCountyCourtViaVenuesEn() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("ENGLISH");
		MatchiSearchVenue.pageVenues();
		MatchiSearchVenue.searchCityVenue("Stenungsund");
		msb.delay(2000);
		msb.clickSearchButton();
		MatchiSearchVenue.chooseVenue();
		msb.delay(500);
		MatchiSearchVenue.selectSportViaVenues("Outdoors ");
		msb.delay(2000);
		MatchiBookAndPay.chooseCourtTime("2", "11");
		msb.delay(500);
		MatchiPayBySwish.payBySwish();
		MatchiPayBySwish.writeMobileNumber("0046123456789");
	//	MatchiBookAndPay.unBook();
		msb.selectLanguage("SVENSKA");
		msb.quitSelenium();
	}
	
	/**
	 * Book via MyPage 
	 */
	@Test
	public void BookOneSessionViaMyPageEn() {
		MatchiBaseline msb = new MatchiBaseline(browser);
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.selectLanguage("ENGLISH");
		MatchiSearchVenue.searchSportViaMyProfile();
		msb.delay(2000);
		MatchiSearchVenue.selectSportViaMyProfile("Tennis");
		MatchiSearchVenue.selectDayViaMyPage("2018-09-12");
		MatchiSearchVenue.searchCityVenue("Stenungsund");
		msb.clickSmashButtonOnMyProfile();
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenue();
		MatchiBookAndPay.chooseCourtTime("2", "12");
		MatchiBookAndPay.payWithSavedCard();
		MatchiBookAndPay.assertBooking("Thank you for your booking!");
		MatchiBookAndPay.unBook();
		msb.selectLanguage("SVENSKA");
		msb.quitSelenium();
	}

}
