import org.junit.jupiter.api.Test;

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
		matchi.chooseArea("G�teborg");
		delay(2000);
		matchi.chooseVenue("H�n� Tenniss�llskap");
	}			
*/
	
	@Test
	public void PayByCard() {
		MatchiSearch matchi = new MatchiSearch();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		matchi.chooseDate("2018-08-24");
		matchi.chooseVenue("H�n� Tenniss�llskap");

		
	}	
		
		
		
		private void delay(int milliseconds)
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