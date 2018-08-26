package matchiComplete;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MatchiSearchCompleteTest {

//	@Test
	public void LogInTest() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		}
		
//	@Test
	public void LogInNegativeTest() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		MatchiSearchLogIn.logInNegative();
		MatchiSearchLogIn.
		assertTrue(MatchiSearchLogIn.logInNegativeCheck("Felaktigt användarnamn eller lösenord"));
		msb.quitSelenium();
	}
	
	@Test
	public void BookViaBoka() {
		MatchiSearchBaseline msb = new MatchiSearchBaseline();
		msb.openSite("https://beta1.matchi.se/?lang=sv");
		msb.logIn();
		MatchiSearchVenue.pageBook();
		MatchiSearchVenue.searchInOutCourt();
		MatchiSearchVenue.selectInOutCourt("Inomhus");
		MatchiSearchVenue.searchSportViaBook();
		MatchiSearchVenue.selectSport("Tennis");
		MatchiSearchVenue.searchCityVenue("Hönö Tennissällskap");
		msb.clickSmashButton();
		MatchiSearchVenue.selectVenueViaBook();
		
		
	}
	

}