package matchiComplete;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MatchiSearchCompleteTest {

	/**
	 * Login test with correct credentials and check if logged in
	 */
	@Test
	public void LogInTest() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		MatchiSearchLogIn.logInPositiveCheck("Mjuk Varutestare");
		msb.quitSelenium();
		}
		
	/**
	 * Login test with false credentials and check error message
	 */
	@Test
	public void LogInNegativeTest() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		MatchiSearchLogIn.logInNegative();
		assertTrue(MatchiSearchLogIn.logInNegativeCheck("Felaktigt användarnamn eller lösenord"));
		msb.quitSelenium();
	}
	
	/**
	 * Book for one session and unBooking via menu Boka pay by new CC
	 */
	@Test
	public void BookOneSessionViaBoka() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Inomhus");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-08-29");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenue("Hönö Tennissällskap");
		MatchiBookAndPay.chooseCourtTime("2", "3");
		msb.delay(2000);
		MatchiBookAndPay.payCourtByCard("2223000048410010", "MjukVarutestare", "737");
		MatchiBookAndPay.assertBooking("Tack för din bokning!");
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
	
	/**
	 * Book for one session and unBooking via menu Boka pay by saved CC
	 */
	@Test
	public void BookOneSessionWithSavedCaViaBoka() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Inomhus");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-08-29");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenue("Hönö Tennissällskap");
		MatchiBookAndPay.chooseCourtTime("2", "3");
		msb.delay(2000);
		MatchiBookAndPay.payWithSavedCard();
		MatchiBookAndPay.assertBooking("Tack för din bokning!");
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
	
	/**
	 * Book and pay for one session with false CVC via menu Boka pay by new CC
	 */
	@Test
	public void BookOneSessionViaBokaFalseCVC() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Inomhus");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-08-29");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenue("Hönö Tennissällskap");
		MatchiBookAndPay.chooseCourtTime("2", "11");
		msb.delay(2000);
		MatchiBookAndPay.payCourtByCard("2223000048410010", "MjukVarutestare", "373");
		MatchiBookAndPay.assertBooking("Ett problem uppstod!");
		msb.quitSelenium();
	}
	
	/**
	 * Book and pay for multiple session and unBooking them via menu Boka pay by CC
	 */
	@Test
	public void BookMultipleSessionsViaBoka() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Inomhus");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-08-29");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenue("Hönö Tennissällskap");
		MatchiBookAndPay.pickMultCourtTime();
		MatchiBookAndPay.chooseCourtTime("2", "8");
		MatchiBookAndPay.chooseCourtTime("2", "10");
		MatchiBookAndPay.chooseCourtTime("3", "9");
		MatchiBookAndPay.confirmMultCourtTime();
		msb.delay(2000);
		MatchiBookAndPay.assertBooking("Tack för din bokning!");
		MatchiBookAndPay.unBook();
		MatchiBookAndPay.unBookAgain();
		MatchiBookAndPay.unBookAgain();
		msb.quitSelenium();
	}
	
	/**
	 * Book via menu Venues pay by new CC
	 */	
	@Test
	public void BookOneSessionViaVenues() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		MatchiSearchVenue.pageVenues();
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSearchButton();
		MatchiSearchVenue.chooseVenue("Hönö Tennissällskap");
		MatchiSearchVenue.selectSportViaVenues("Badminton");
		msb.delay(1000);
		MatchiBookAndPay.chooseCourtTime("2", "7");
		msb.delay(2000);
		MatchiBookAndPay.payCourtByCard("2223000048410010", "MjukVarutestare", "737");
		MatchiBookAndPay.assertBooking("Tack för din bokning!");
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
		
	/**
	 * Search and book, county & courts via menu Venues pay by Swish
	 */	
	@Test
	public void SearchCountyCourtViaVenues() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		MatchiSearchVenue.pageVenues();
		MatchiSearchVenue.searchCityVenue("Stenungsund");
		msb.clickSearchButton();
		MatchiSearchVenue.chooseVenue("Stenungsunds TK");
		MatchiSearchVenue.selectSportViaVenues("Utomhus");
		msb.delay(2000);
		MatchiBookAndPay.chooseCourtTime("2", "10");
		msb.delay(4000);
		MatchiPayBySwish.payBySwish();
		MatchiPayBySwish.writeMobileNumber("0046123456789");
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
	
	/**
	 * Search and book sport & courts via Venues pay by new CC
	 */	
	@Test
	public void SearchSportCourtViaVenues() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		MatchiSearchVenue.pageVenues();
		MatchiSearchVenue.searchAllSportsViaVenues();
		MatchiSearchVenue.selectSport("Badminton");
		msb.clickSearchButton();	
		MatchiSearchVenue.chooseVenue("Lilla Edets Tennisklubb");
		msb.delay(1000);
		MatchiSearchVenue.selectSportViaVenues("Badminton");
		MatchiBookAndPay.chooseCourtTime("2", "8");
		msb.delay(2000);
		MatchiBookAndPay.payCourtByCard("2223000048410010", "MjukVarutestare", "737");
		MatchiBookAndPay.assertBooking("Tack för din bokning!");
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
	
	/**
	 * Book via MyPage 
	 */
	@Test
	public void BookOneSessionViaMyPage() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		MatchiSearchVenue.BookViaMyProfile();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Inomhus");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-08-29");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		MatchiSearchMonthDayTime.selectTime();
		msb.quitSelenium();
	}

}