package ffMatchi;

import org.junit.jupiter.api.Test;

public class MatchiSearchTest {
	
	/*
	 *The test is booking via login path
	 *choose county
	 *choose venue
	 *pay by new credit card
	 *Cancel booking
	 *logout
	 * 
	 * */
	 

	@Test
	void Matchitestwithlogin() {
		
		MatchiSearch matchisearch = new MatchiSearch();
	   matchisearch.openSite("https://beta1.matchi.se/");
       matchisearch.selectNorsk("NORSK");   
       matchisearch.selectLogin();
       matchisearch.loginInto();
       matchisearch.chooseSport();
	   matchisearch.selectedSport("Tennis");
	   matchisearch.selectedDate("2018-08-30");
	   matchisearch.selectedCity("Göteborg");
       matchisearch.clickonSmash();
       matchisearch.delay(2000);
       matchisearch.chooseInOrOut("Innendørs");
       matchisearch.delay(1000);
       matchisearch.selectArena("Hönö Tennissällskap");
	   matchisearch.chooseCourtTime("2", "15");
	   matchisearch.delay(1000);

	   matchisearch.bookingViaNewCC();
       matchisearch.clickBookButton();
       matchisearch.delay(3000);
       matchisearch.enterCCdetails("2223000048410010","Mjukvarutestare","737");
       matchisearch.delay(3000);

      // matchisearch.enterCCname("Mjukvarutestare");
      // matchisearch.enterCCcvc("737");
       matchisearch.delay(1000);
       matchisearch.closeWindow();
	   matchisearch.delay(1000);
       matchisearch.cancelBooking();
       matchisearch.logout();
      // matchisearch.multipleBookings();
      // matchisearch.bookingViaBookOption();
      matchisearch.quitSelenium();
}
	/**@Test
	void Matchitest**/
	

}
