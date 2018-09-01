package matchiCompleteEdge;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MatchiSearchCompleteTest {

	/**
	 * Login test with correct credentials and check if logged in
	 */
	@Test
	public void LogInTest() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/");
		msb.delay(2000);

	       MatchiSearchBaseline.selectNorsk("NORSK");   

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
		msb.openSite("https://beta1.matchi.se/");
	       MatchiSearchBaseline.selectNorsk("NORSK");   

		MatchiSearchLogIn.logInNegative();
		msb.delay(2000);

		assertTrue(MatchiSearchLogIn.logInNegativeCheck("Feilaktig brukernavn eller passord "));
		msb.delay(2000);

		msb.quitSelenium();
	}
	
	/**
	 * Book for one session and unBooking via menu Boka pay by new CC
	 */
	@Test
	public void BookOneSessionViaBoka() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/");
	       MatchiSearchBaseline.selectNorsk("NORSK");   

		msb.logIn();
		MatchiSearchVenue.pageBook();
		msb.delay(2000);

		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Innendørs");
		msb.delay(2000);

		MatchiSearchVenue.searchSportViaBook();
		msb.delay(2000);

		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-09-09");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap ");
		msb.delay(2000);


		msb.clickSmashButton();
		msb.delay(2000);

		MatchiSearchVenue.chooseVenue("Hönö Tennissällskap");
		msb.delay(2000);

		MatchiBookAndPay.chooseCourtTime("2", "10");
		msb.delay(2000);
		MatchiBookAndPay.payCourtByCard("2223000048410010", "MjukVarutestare", "737");
		msb.delay(2000);

		MatchiBookAndPay.assertBooking("Takk skal du ha for bookingen din!");
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
	
	/**
	 * Book for one session and unBooking via menu Boka pay by saved CC
	 */
	@Test
	public void BookOneSessionWithSavedCaViaBoka() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/");
	       MatchiSearchBaseline.selectNorsk("NORSK");   

		msb.logIn();
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Innendørs");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-09-09");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap ");
		msb.delay(2000);
		msb.clickSmashButton();
		msb.delay(2000);
		MatchiSearchVenue.chooseVenue("Hönö Tennissällskap ");
		msb.delay(2000);
		MatchiBookAndPay.chooseCourtTime("2", "10");
		msb.delay(2000);
		MatchiBookAndPay.payWithSavedCard();
		msb.delay(2000);
		MatchiBookAndPay.assertBooking("Takk skal du ha for bookingen din! ");
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
	
	/**
	 * Book and pay for one session with false CVC via menu Boka pay by new CC
	 */
	@Test
	public void BookOneSessionViaBokaFalseCVC() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/");
	       MatchiSearchBaseline.selectNorsk("NORSK");   

		msb.logIn();
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Inomhus");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-09-09");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap ");
		msb.delay(2000);

		msb.clickSmashButton();
		msb.delay(2000);

		MatchiSearchVenue.chooseVenue("Hönö Tennissällskap");
		msb.delay(2000);

		MatchiBookAndPay.chooseCourtTime("2", "11");
		msb.delay(2000);
		MatchiBookAndPay.payCourtByCard("2223000048410010", "MjukVarutestare", "373");
		MatchiBookAndPay.assertBooking("Et problem ble oppdaget! ");
		msb.quitSelenium();
	}
	
	/**
	 * Book and pay for multiple session and unBooking them via menu Boka pay by CC
	 */
	@Test
	public void BookMultipleSessionsViaBoka() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/");
	    MatchiSearchBaseline.selectNorsk("NORSK");   
		msb.logIn();
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Innendørs");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-09-09");
		msb.delay(2000);
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap ");
		msb.delay(2000);
		msb.clickSmashButton();
		MatchiSearchVenue.chooseVenue("Hönö Tennissällskap ");
		msb.delay(2000);
		MatchiBookAndPay.pickMultCourtTime();
		msb.delay(2000);
		MatchiBookAndPay.chooseCourtTime("2", "8");
		msb.delay(2000);
		MatchiBookAndPay.chooseCourtTime("2", "10");
		MatchiBookAndPay.chooseCourtTime("3", "9");
		MatchiBookAndPay.confirmMultCourtTime();
		msb.delay(2000);
		MatchiBookAndPay.assertBooking("Takk skal du ha for bookingen din! ");
		msb.delay(2000);
		MatchiBookAndPay.unBook();
		msb.delay(2000);
		MatchiBookAndPay.unBookAgain();
		msb.delay(2000);
		MatchiBookAndPay.unBookAgain();
		msb.delay(2000);
		msb.quitSelenium();
	}
	
	/**
	 * Book via menu Venues pay by new CC
	 */	
	@Test
	public void BookOneSessionViaVenues() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/");
	    MatchiSearchBaseline.selectNorsk("NORSK");   
		msb.logIn();
		MatchiSearchVenue.pageVenues();
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap ");
		msb.clickSearchButton();
		msb.delay(2000);
		MatchiSearchVenue.chooseVenue("Hönö Tennissällskap ");
		msb.delay(2000);
		MatchiSearchVenue.selectSportViaVenues("Badminton ");
		msb.delay(1000);
		MatchiBookAndPay.chooseCourtTime("2", "9");
		msb.delay(2000);
		MatchiBookAndPay.payCourtByCard("2223000048410010", "MjukVarutestare", "737");
		msb.delay(2000);
		MatchiBookAndPay.assertBooking("Takk skal du ha for bookingen din! ");
		msb.delay(2000);
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
		
	/**
	 * Search and book, county & courts via menu Venues pay by Swish
	 */	
	@Test
	public void SearchCountyCourtViaVenues() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/");
	    MatchiSearchBaseline.selectNorsk("NORSK");   
		msb.logIn();
		MatchiSearchVenue.pageVenues();
		MatchiSearchVenue.searchCityVenue("Stenungsund ");
		msb.delay(2000);
		msb.clickSearchButton();
		msb.delay(2000);
		MatchiSearchVenue.chooseVenue("Stenungsunds TK");
		msb.delay(2000);
		MatchiSearchVenue.selectSportViaVenues("Utendørs");
		msb.delay(2000);
		MatchiBookAndPay.chooseCourtTime("2", "10");
		msb.delay(2000);
		MatchiPayBySwish.payBySwish();
		msb.delay(2000);
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
		msb.openSite("https://beta1.matchi.se/");
	    MatchiSearchBaseline.selectNorsk("NORSK");   
		msb.logIn();
		MatchiSearchVenue.pageVenues();
		MatchiSearchVenue.searchAllSportsViaVenues();
		MatchiSearchVenue.selectSport("Badminton");
		msb.clickSearchButton();	
		MatchiSearchVenue.chooseVenue("Lilla Edets Tennisklubb ");
		msb.delay(1000);
		MatchiSearchVenue.selectSportViaVenues("Badminton ");
		msb.delay(1000);
		MatchiBookAndPay.chooseCourtTime("2", "8");
		msb.delay(2000);
		MatchiBookAndPay.payCourtByCard("2223000048410010", "MjukVarutestare", "737");
		msb.delay(1000);
		MatchiBookAndPay.assertBooking("Takk skal du ha for bookingen din! ");
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
	
	/**
	 * Book via MyPage 
	 */
	@Test
	public void BookOneSessionViaMyPage() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/");
	    MatchiSearchBaseline.selectNorsk("NORSK");   
		msb.logIn();
		MatchiSearchVenue.BookViaMyProfile();
		msb.delay(2000);
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Innendørs ");
		msb.delay(2000);
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis ");
		msb.delay(2000);
		MatchiBookAndPay.chooseDate("2018-09-09");
		msb.delay(2000);
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap ");
		msb.delay(2000);
		msb.clickSmashButton();
		msb.delay(3000);
		MatchiSearchMonthDayTime.selectTime();
		msb.delay(1000);
		msb.quitSelenium();
	}

}
