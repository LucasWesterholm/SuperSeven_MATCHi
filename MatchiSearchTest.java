import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
public class MatchiSearchTest {
	/**
	 * Test order method created in the bottom
	 */
/*
	@Test
	public void LogInTest() {
		MatchiSearch matchi = new MatchiSearch();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		matchi.book();
		matchi.searchInOutCourt();
		matchi.chooseInOutCourt("Inomhus");
		matchi.searchSport();
		matchi.chooseSport("Badminton");
		
	}
	
	
	@Test
	public void MatchiTest() {
		MatchiSearch matchi = new MatchiSearch();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.searchSport();
		matchi.chooseSportWithOutLogin("Tennis");
		matchi.searchDay();
		matchi.chooseDay("24");
		matchi.searchArea();
		matchi.chooseArea("Göteborg");
		delay(2000);
		matchi.chooseVenue("Hönö Tennissällskap");
	}			
*/

	/**
	 * Books a time with correct card info, and verifies that the booking is successful.
	 * This test need to be run before "BookingMultipleTimes" since the latter needs to use the card info saved from this test.
	 */
	
	@Test
	public void PayByCard() {
		MatchiSearch matchi = new MatchiSearch();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		matchi.chooseDate("2018-08-29");
		matchi.chooseVenue("Hönö Tennissällskap");
		matchi.chooseCourtTime("2", "6");
		delay(2000);
		matchi.payCourtByCard("2223000048410010", "MjukVarutestare", "737");
		assertTrue(matchi.assertBooking("Tack för din bokning!"));
		matchi.unBook();
		matchi.quitSelenium();
	}	
	
	/**
	 * Tries to book a time using a faulty cvc, and verifies that You get an error message.
	 */
	
	@Test
	public void PayByCardWrongCvC() {
		MatchiSearch matchi = new MatchiSearch();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		matchi.chooseDate("2018-08-29");
		matchi.chooseVenue("Hönö Tennissällskap");
		matchi.chooseCourtTime("2", "6");
		delay(2000);
		matchi.payCourtByCard("2223000048410010", "MjukVarutestare", "666");
		assertTrue(matchi.assertBooking("Ett problem upptäcktes"));
		matchi.quitSelenium();
	}	

	/**
	 * unfinished because IMO uneccessary?? change my mind and we will fix it.
	 */
	
/*	
	@Test
	public void PayByCardWrongCardNumber() {
		MatchiSearch matchi = new MatchiSearch();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		matchi.chooseDate("2018-08-29");
		matchi.chooseVenue("Hönö Tennissällskap");
		matchi.chooseCourtTime("2", "6");
		delay(2000);
		matchi.payCourtByCard("2223111148410010", "MjukVarutestare", "737");

	}	
		*/ 
	
	/**
	 * testing to book multiple courts using the "boka flear" option and verifies that booking is successful
	 * although it only checks that the booking is completed and not whether the times are.
	 */
	
	@Test
	public void BookingMultipleTimes() {
		MatchiSearch matchi = new MatchiSearch();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		matchi.chooseDate("2018-08-29");
		matchi.chooseVenue("Hönö Tennissällskap");
		matchi.pickMultCourtTime();
		matchi.chooseCourtTime("2", "6");
		matchi.chooseCourtTime("2", "9");
		matchi.chooseCourtTime("3", "5");
		matchi.chooseCourtTime("3", "10");
		matchi.confirmMultCourtTime();
		assertTrue(matchi.assertBooking("Tack för din bokning!"));
		delay(2000);
		matchi.unBook();
		matchi.unBookAgain();
		matchi.unBookAgain();
		matchi.unBookAgain();
		matchi.quitSelenium(); 
	}		

		
	public void delay(int milliseconds)
	{
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
		}
	}
/*
	@Test
	public void testOrder() {
		logInTest();
		}
*/
}