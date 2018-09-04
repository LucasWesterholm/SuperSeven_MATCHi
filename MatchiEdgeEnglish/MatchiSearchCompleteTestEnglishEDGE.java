package MatchiDemoFirstSprint;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MatchiSearchCompleteTestEnglishEDGE {

	/**
	 * Login test with correct credentials and check if logged in
	 * Working in Edge
	 */
	@Test
	public void LogInTestEnglish() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.selectLanguage("ENGLISH");
		msb.logIn();
		MatchiSearchLogIn.logInPositiveCheck("Mjuk Varutestare");
		msb.quitSelenium();
		}
		
	/**
	 * Login test with false credentials and check error message
	 * Working in Edge
	 */
	@Test
	public void LogInNegativeTestEnglish() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.selectLanguage("ENGLISH");
		MatchiSearchLogIn.logInNegative();
		assertTrue(MatchiSearchLogIn.logInNegativeCheck("Incorrect username or password "));
		msb.quitSelenium();
	}
	
	/**
	 * Book for one session and unBooking via menu Boka pay by new CC
	 * Working in Edge
	 */
	@Test
	public void BookOneSessionViaBokaEnglish() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		msb.selectLanguage("ENGLISH");
		MatchiSearchVenue.pageBook();
/*		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Inomhus");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis"); */
		MatchiBookAndPay.chooseDate("2018-09-12");
		MatchiSearchVenue.searchCityVenue("H�n�");
		msb.clickSmashButton();
		msb.delay(2000);
		MatchiSearchVenue.chooseVenueFirstResultEDGE();
		msb.delay(5000);
		MatchiBookAndPay.chooseCourtTime("2", "3");
		msb.delay(5000);
		MatchiBookAndPay.payCourtByCardEnglishEDGE("2223000048410010", "MjukVarutestare", "737");
		MatchiBookAndPay.assertBooking("Thank you for your booking!");
		MatchiBookAndPay.closePaymentWindow();
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
	
	/**
	 * Book for one session and unBooking via menu Boka pay by saved CC
	 * Working in Edge
	 */
	@Test
	public void BookOneSessionWithSavedCaViaBokaEnglish() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		msb.selectLanguage("ENGLISH");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Indoor");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-09-12");
		MatchiSearchVenue.searchCityVenue("H�n� Tenniss�llskap");
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenueFirstResultEDGE();
		MatchiBookAndPay.chooseCourtTime("2", "3");
		msb.delay(2000);
		MatchiBookAndPay.payWithSavedCard();
		MatchiBookAndPay.assertBooking("Thank you for your booking!");
		MatchiBookAndPay.closePaymentWindow();
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
	
	/**
	 * Book and pay for one session with false CVC via menu Boka pay by new CC
	 * Working in Edge
	 */
	@Test
	public void BookOneSessionViaBokaFalseCVCEnglish() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		msb.selectLanguage("ENGLISH");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Indoor");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-09-12");
		MatchiSearchVenue.searchCityVenue("H�n� Tenniss�llskap");
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenueFirstResultEDGE();
		msb.delay(2000);
		MatchiBookAndPay.chooseCourtTime("2", "11");
		msb.delay(2000);
		MatchiBookAndPay.payCourtByCardEnglishEDGE("2223000048410010", "MjukVarutestare", "373");
		MatchiBookAndPay.assertBooking("A problem was detected");
		msb.quitSelenium();
	}
	
	/**
	 * Book and pay for multiple session and unBooking them via menu Boka pay by CC
	 * Working in Edge
	 */
	@Test
	public void BookMultipleSessionsViaBokaEnglish() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		msb.selectLanguage("ENGLISH");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Indoors");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-09-12");
		MatchiSearchVenue.searchCityVenue("H�n� Tenniss�llskap");
		msb.clickSmashButton();
		msb.delay(2000);
		MatchiSearchVenue.chooseVenueFirstResultEDGE();
		MatchiBookAndPay.pickMultCourtTime();
		MatchiBookAndPay.chooseCourtTime("2", "8");
		MatchiBookAndPay.chooseCourtTime("2", "10");
		MatchiBookAndPay.chooseCourtTime("3", "9");
		MatchiBookAndPay.confirmMultCourtTime();
		msb.delay(2000);
		MatchiBookAndPay.assertBooking("Thank you for your booking!");
		MatchiBookAndPay.closePaymentWindow();
		MatchiBookAndPay.unBook();
		msb.delay(3000);
		MatchiBookAndPay.unBook();
		msb.delay(3000);
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
	
	/**
	 * Book via menu Venues pay by new CC
	 * Gets stuck after clicking venues and demands your location.
	 * Works on Carolinas computer
	 */	
	@Test
	public void BookOneSessionViaVenuesEnglish() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		msb.selectLanguage("ENGLISH");
		MatchiSearchVenue.pageVenues();
		MatchiSearchVenue.searchCityVenue("H�n� Tenniss�llskap");
		msb.clickSearchButton();
		MatchiSearchVenue.chooseVenueFirstResultEDGE();
		MatchiBookAndPay.chooseCourtTime("2", "12");
		msb.delay(2000);
		MatchiBookAndPay.payCourtByCardEnglishEDGE("2223000048410010", "MjukVarutestare", "737");
		MatchiBookAndPay.assertBooking("Thank you for your booking!");
		MatchiBookAndPay.closePaymentWindow();
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
		
	/**
	 * Search and book, county & courts via menu Venues pay by Swish
	 * Swish not working, Test works otherwise in Edge
	 */	
	@Test
	public void SearchCountyCourtViaVenuesEnglish() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		msb.selectLanguage("ENGLISH");
		MatchiSearchVenue.pageVenues();
		MatchiSearchVenue.searchCityVenue("Stenungsund");
		msb.clickSearchButton();
		MatchiSearchVenue.chooseVenueFirstResultEDGE();
		msb.delay(2000);
		MatchiBookAndPay.chooseCourtTime("2", "10");
		msb.delay(4000);
		MatchiPayBySwish.payBySwish();
		MatchiPayBySwish.writeMobileNumber("0046123456789");
		MatchiBookAndPay.closePaymentWindow();
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
	
	/**
	 * Search and book sport & courts via Venues pay by new CC
	 * Gets stuck after clicking venues and demands your location.
	 * Works in Carolinas computer, needed to change a bit in the testcase. 
	 */	
	@Test
	public void SearchSportCourtViaVenuesEnglish() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		msb.selectLanguage("ENGLISH");
		MatchiSearchVenue.pageVenues();
		MatchiSearchVenue.searchAllSportsViaVenues();
//Not needed		MatchiSearchVenue.selectSport("Badminton");
		MatchiSearchVenue.selectSportViaVenues("Badminton");
//added line below
		MatchiSearchVenue.searchCityVenue("H�n�");
		msb.clickSearchButton();
		MatchiSearchVenue.chooseVenueFirstResultEDGE();
		msb.delay(2000);
		MatchiBookAndPay.chooseCourtTime("2", "12");
		msb.delay(2000);
		MatchiBookAndPay.payCourtByCardEnglishEDGE("2223000048410010", "MjukVarutestare", "737");
		MatchiBookAndPay.assertBooking("Thank you for your booking!");
		MatchiBookAndPay.closePaymentWindow();
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
	
	/**
	 * Book via MyPage 
	 * Working in Edge, was not completly finnised in previous sprint so finnised it
	 */
	@Test
	public void BookOneSessionViaMyPageEnglish() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn(); 
		msb.selectLanguage("ENGLISH");
		MatchiSearchVenue.searchSportViaMyProfile();
		MatchiSearchVenue.selectSportViaMyProfile("Tennis");
		MatchiSearchVenue.selectDayViaMyPage("2018-09-12");
		MatchiSearchVenue.searchCityVenue("H�n� Tenniss�llskap");
		msb.clickSmashButtonOnMyProfile();
		MatchiSearchVenue.chooseVenueFirstResultEDGE();
		msb.delay(2000);
		MatchiBookAndPay.chooseCourtTime("2", "12");
		msb.delay(2000);
		MatchiBookAndPay.payWithSavedCard();
		MatchiBookAndPay.assertBooking("Thank you for your booking!");
		MatchiBookAndPay.closePaymentWindow();
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}

}