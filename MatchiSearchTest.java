package norwegian;

import org.junit.jupiter.api.Test;

public class MatchiSearchTest {

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
       matchisearch.delay(1000);
       matchisearch.chooseInOrOut("Innendørs");
      
       matchisearch.selectArena("Hönö Tennissällskap");
	   matchisearch.chooseCourtTime("2", "6");
	   matchisearch.delay(1000);
		matchisearch.bookingViaNewCC();
       matchisearch.clickBookButton();
        matchisearch.enterCCdetails("2223000048410010", "MjukVarutestare", "737");

       matchisearch.closeWindow();
       matchisearch.quitSelenium();
}
	/**@Test
	void Matchitest**/
	

}
