import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MatchiTests {

	/**
	 * Login test with correct credentials and check if logged in
	 * Working in Edge
	 */
//	@Test
	public void LogInTest() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.selectLanguage("NORSK");
		msb.logIn();
		MatchiLogIn.logInPositiveCheck("Mjuk Varutestare");
		msb.quitSelenium();
		}
		
	/**
	 * Login test with false credentials and check error message
	 * Working in Edge
	 */
//	@Test
	public void LogInNegativeTest() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		MatchiLogIn.logInNegative();
		assertTrue(MatchiLogIn.logInNegativeCheck("Felaktigt användarnamn eller lösenord "));
		msb.quitSelenium();
	}
	
	/**
	 * Book for one session and unBooking via menu Boka pay by new CC
	 * Working in Edge
	 */
//	@Test
	public void BookOneSessionViaBoka() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		msb.selectLanguage("SVENSKA");
		MatchiSearchVenue.pageBook();
/*		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Inomhus");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis"); */
		MatchiBookAndPay.chooseDate("2018-09-12");
		MatchiSearchVenue.searchCityVenue("Hönö");
		msb.clickSmashButton();
		msb.delay(2000);
		MatchiSearchVenue.chooseVenueFirstResult();
		msb.delay(5000);
		MatchiBookAndPay.chooseCourtTime("2", "3");
		msb.delay(10000);
		MatchiBookAndPay.payCourtByCard("2223000048410010", "MjukVarutestare", "737");
		MatchiBookAndPay.assertBooking("Tack för din bokning!");
		MatchiBookAndPay.closePaymentWindow();
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
	
	/**
	 * Book for one session and unBooking via menu Boka pay by saved CC
	 * Working in Edge
	 */
//	@Test
	public void BookOneSessionWithSavedCaViaBoka() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Inomhus");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-09-12");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenueFirstResult();
		MatchiBookAndPay.chooseCourtTime("2", "3");
		msb.delay(2000);
		MatchiBookAndPay.payWithSavedCard();
		MatchiBookAndPay.assertBooking("Tack för din bokning!");
		MatchiBookAndPay.closePaymentWindow();
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
	
	/**
	 * Book and pay for one session with false CVC via menu Boka pay by new CC
	 * Working in Edge
	 */
//	@Test
	public void BookOneSessionViaBokaFalseCVC() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Inomhus");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-09-12");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenueFirstResult();
		msb.delay(2000);
		MatchiBookAndPay.chooseCourtTime("2", "11");
		msb.delay(2000);
		MatchiBookAndPay.payCourtByCard("2223000048410010", "MjukVarutestare", "373");
		MatchiBookAndPay.assertBooking("Ett problem uppstod!");
		msb.quitSelenium();
	}
	
	/**
	 * Book and pay for multiple session and unBooking them via menu Boka pay by CC
	 * Working in Edge
	 */
//	@Test
	public void BookMultipleSessionsViaBoka() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Inomhus");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-09-12");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		msb.delay(2000);
		MatchiSearchVenue.chooseVenueFirstResult();
		MatchiBookAndPay.pickMultCourtTime();
		MatchiBookAndPay.chooseCourtTime("2", "8");
		MatchiBookAndPay.chooseCourtTime("2", "10");
		MatchiBookAndPay.chooseCourtTime("3", "9");
		MatchiBookAndPay.confirmMultCourtTime();
		msb.delay(2000);
		MatchiBookAndPay.assertBooking("Tack för din bokning!");
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
	 */	
//	@Test
	public void BookOneSessionViaVenues() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		msb.selectLanguage("SVENSKA");
		MatchiSearchVenue.pageVenues();
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSearchButton();
		MatchiSearchVenue.chooseVenueFirstResult();
		MatchiBookAndPay.chooseCourtTime("2", "7");
		msb.delay(2000);
		MatchiBookAndPay.payCourtByCard("2223000048410010", "MjukVarutestare", "737");
		MatchiBookAndPay.assertBooking("Tack för din bokning!");
		MatchiBookAndPay.closePaymentWindow();
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
		
	/**
	 * Search and book, county & courts via menu Venues pay by Swish
	 * Swish not working, Test works otherwise. in Edge
	 */	
//	@Test
	public void SearchCountyCourtViaVenues() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		MatchiSearchVenue.pageVenues();
		MatchiSearchVenue.searchCityVenue("Stenungsund");
		msb.clickSearchButton();
		MatchiSearchVenue.chooseVenueFirstResult();
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
	 */	
	@Test
	public void SearchSportCourtViaVenues() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		MatchiSearchVenue.pageVenues();
		MatchiSearchVenue.searchAllSportsViaVenues();
		MatchiSearchVenue.selectSport("Tennis");
		msb.clickSearchButton();	
		MatchiSearchVenue.chooseVenueFirstResult();
		MatchiSearchVenue.selectSportViaVenues("Tennis");
		msb.delay(2000);
		MatchiBookAndPay.chooseCourtTime("2", "8");
		msb.delay(2000);
		MatchiBookAndPay.payCourtByCard("2223000048410010", "MjukVarutestare", "737");
		MatchiBookAndPay.assertBooking("Tack för din bokning!");
		MatchiBookAndPay.closePaymentWindow();
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
	
	/**
	 * Book via MyPage 
	 * Need clarification of test
	 */
//	@Test
	public void BookOneSessionViaMyPage() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		MatchiSearchVenue.BookViaMyProfile();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Inomhus");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-09-12");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		MatchiSearchMonthDayTime.selectTime();
		msb.quitSelenium();
	}

}