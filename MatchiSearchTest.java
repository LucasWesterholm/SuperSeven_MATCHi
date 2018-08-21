package MatchiLotta;

import org.junit.Test;


public class MatchiSearchTest {
	

//	@Test
	public void LogInTest() {
		MatchiSearch matchi = new MatchiSearch();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		}
		
// @Test	
	public void LogOutTest() {
		MatchiSearch matchi = new MatchiSearch();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		matchi.logOut();
		matchi.quitSelenium();
		}
	
	@Test
	public void MatchiTest() {
		MatchiSearch matchi = new MatchiSearch();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();		
		matchi.book();
		matchi.searchInOutCourt();
		matchi.chooseInOutCourt("Inomhus");
		delay(1000);
		matchi.searchSport();
		matchi.chooseSport("Badminton");
		matchi.searchAreaOrVenue("Hönö Tennissällskap");
		matchi.chooseVenue("Hönö Tennissällskap");
		matchi.chooseDayTimeCourt();
		delay(2000);
		matchi.payBySwish("");
		delay(5000);
		matchi.writeNumber("0123456789");
		delay(5000);
	//	matchi.logOut();
	//	matchi.quitSelenium();
		}
	
	private void delay(int milliseconds)
	{
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
		}
	}
	
/*	@Test
	public void testOrder1() {
		LogInTest();BookCourtTest();PayCourtTest();LogOutTest();
	}
*/	
		

	
	

}
