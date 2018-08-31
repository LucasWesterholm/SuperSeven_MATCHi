package matchiFirefox.testLanguage.svenska;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import matchiFirefox.MatchiSearchBaselineFireFox;
import matchiFirefox.functions.MatchiBookAndPay;
import matchiFirefox.functions.MatchiPayBySwish;
import matchiFirefox.functions.MatchiSearchLogIn;
import matchiFirefox.functions.MatchiSearchMonthDayTime;
import matchiFirefox.functions.MatchiSearchVenue;


public class MatchiFireFoxTestSvenska {

	/**
	 * Login test with correct credentials and check if logged in
	 */
	@Test
	public void LogInTestSv() {
		MatchiSearchBaselineFireFox msb = new MatchiSearchBaselineFireFox();
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.delay(500);
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
		MatchiSearchBaselineFireFox msb = new MatchiSearchBaselineFireFox();
		msb.openSite("https://beta1.matchi.se/");
		msb.selectLanguage("SVENSKA");
		MatchiSearchLogIn.logInNegative();
		msb.delay(1000);
		assertTrue(MatchiSearchLogIn.logInNegativeCheck("Felaktigt användarnamn eller lösenord"));
		msb.quitSelenium();
	}
	
	/**
	 * Book for one session and unBooking via menu Boka pay by new CC
	 * 
	 */
	@Test
	public void BookOneSessionViaBokaSv() {
		MatchiSearchBaselineFireFox msb = new MatchiSearchBaselineFireFox();
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
	//	msb.selectLanguage("SVENSKA");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Inomhus");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-08-31");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		msb.delay(2000);
		MatchiSearchVenue.chooseVenue("Hönö Tennissällskap");
	//	msb.delay(2000);
		MatchiBookAndPay.chooseCourtTime("2", "12");
		//msb.delay(400);
		MatchiBookAndPay.payCourtByCard("'1234567890123456'", "MjukVarutestare", "737");
		//MatchiBookAndPay.payCourtByCard("2223000048410010", "MjukVarutestare", "737");
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
		MatchiSearchBaselineFireFox msb = new MatchiSearchBaselineFireFox();
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.delay(500);
		msb.selectLanguage("SVENSKA");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		msb.delay(1000);
		MatchiSearchVenue.selectInOutCourt("Utomhus");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-08-31");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		msb.delay(2000);
		MatchiSearchVenue.chooseVenue("Hönö Tennissällskap");
		msb.delay(2000);
		MatchiBookAndPay.chooseCourtTime("2", "15");
		msb.delay(500);
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
		MatchiSearchBaselineFireFox msb = new MatchiSearchBaselineFireFox();
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.delay(500);
		msb.selectLanguage("SVENSKA");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Inomhus");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-08-31");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		msb.delay(2000);
		MatchiSearchVenue.chooseVenue("Hönö Tennissällskap");
		MatchiBookAndPay.chooseCourtTime("2", "15");
		msb.delay(2000);
		MatchiBookAndPay.payCourtByCard("'2223000048410010'", "MjukVarutestare", "373");
		MatchiBookAndPay.assertBooking("Ett problem uppstod!");
		msb.quitSelenium();
	}
	
	/**
	 * Book and pay for multiple session and unBooking them via menu Boka pay by CC
	 * 
	 * / 
	@Test
	public void BookMultipleSessionsViaBokaSv() {
		MatchiSearchBaselineFireFox msb = new MatchiSearchBaselineFireFox();
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.delay(500);
		msb.selectLanguage("SVENSKA");
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Utomhus");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-08-31");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		msb.delay(1000);
		MatchiSearchVenue.chooseVenue("Hönö Tennissällskap");
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
		MatchiBookAndPay.assertBooking("Tack för din bokning!");
		MatchiBookAndPay.unBook();
		msb.delay(1000);
		MatchiBookAndPay.unBookAgain();
		msb.delay(1000);
		MatchiBookAndPay.unBookAgain();
		msb.quitSelenium();
	}
		/**
	 * Book via menu Venues pay by new CC
	 * 
	 */	
	@Test
	public void BookOneSessionViaVenuesSv() {
		MatchiSearchBaselineFireFox msb = new MatchiSearchBaselineFireFox();
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.delay(500);
		msb.selectLanguage("SVENSKA");
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
	 * 
	 */
	@Test
	public void SearchCountyCourtViaVenuesSv() {
		MatchiSearchBaselineFireFox msb = new MatchiSearchBaselineFireFox();
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.delay(500);
		msb.selectLanguage("SVENSKA");
		MatchiSearchVenue.pageVenues();
		MatchiSearchVenue.searchCityVenue("Stenungsund");
		msb.delay(2000);
		msb.clickSearchButton();
		MatchiSearchVenue.chooseVenue("Stenungsunds TK");
		MatchiSearchVenue.selectSportViaVenues("Utomhus");
		msb.delay(2000);
		MatchiBookAndPay.chooseCourtTime("2", "11");
		msb.delay(500);
		MatchiPayBySwish.payBySwish();
		MatchiPayBySwish.writeMobileNumber("0046123456789");
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}

	/**
	 * Search and book sport & courts via Venues pay by saved CC
	 * 
	 */	
	@Test
	public void SearchSportCourtViaVenuesSv() {
		MatchiSearchBaselineFireFox msb = new MatchiSearchBaselineFireFox();
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.delay(500);
		msb.selectLanguage("SVENSKA");
		MatchiSearchVenue.pageVenues();
		MatchiSearchVenue.searchAllSportsViaVenues();
		MatchiSearchVenue.selectSport("Badminton");
		msb.clickSearchButton();
		MatchiSearchVenue.clickOnCountyViaVenues();
		MatchiSearchVenue.selectVenueViaVenue("Lilla Edet");
		msb.clickSearchButton();
		MatchiSearchVenue.chooseVenue("Lilla Edets Tennisklubb");
		msb.delay(1000);
		MatchiSearchVenue.selectSportViaVenues("Badminton");
		MatchiBookAndPay.chooseCourtTime("2", "8");
		msb.delay(2000);
		MatchiBookAndPay.assertBooking("Tack för din bokning!");
		MatchiBookAndPay.unBook();
		msb.quitSelenium();
	}
		
	/**
	 * Book via MyPage 
	 */
	@Test
	public void BookOneSessionViaMyPage() {
		MatchiSearchBaselineFireFox msb = new MatchiSearchBaselineFireFox();
		msb.openSite("https://beta1.matchi.se/");
		msb.logIn();
		msb.delay(500);
		msb.selectLanguage("SVENSKA");
		MatchiSearchVenue.BookViaMyProfile();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Inomhus");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiBookAndPay.chooseDate("2018-08-31");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		msb.delay(500);
		MatchiSearchMonthDayTime.selectTime();
		msb.quitSelenium();
	}

}