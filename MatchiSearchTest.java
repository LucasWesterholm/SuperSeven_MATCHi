package MatchiLucas;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class MatchiSearchTest {
	
	//US 1 Negative
	@Test
	public void LogInNegativeTest() {
		MatchiSearch matchi = new MatchiSearch();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logInNegative();
		assertTrue(matchi.logInNegativeCheck("Felaktigt användarnamn eller lösenord"));
		matchi.quitSelenium();
	}
	
	//US 1 Positive
	@Test
	public void LogInTest() {
		MatchiSearch matchi = new MatchiSearch();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		assertTrue(matchi.logInPositiveCheck("Mjuk Varutestare"));
		matchi.quitSelenium();
	}
	
	//US 5 Swish
	@Test
	public void SwishTest() {
		MatchiSearch matchi = new MatchiSearch();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		matchi.book();
		matchi.searchInOutCourt();
		matchi.chooseInOutCourt("Inomhus");
		matchi.delay(1000);
		matchi.searchSport();
		matchi.chooseSport("Badminton");
		matchi.searchVenue("Hönö Tennissällskap");
		matchi.chooseVenue("Hönö Tennissällskap");
		matchi.chooseDate("");
		matchi.delay(2000);
		matchi.PayBySwish("");
		matchi.delay(2000);
		matchi.writeNumber("0708758629");
		matchi.quitSelenium();
	}
}