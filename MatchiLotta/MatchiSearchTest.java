package MatchiLotta;

import org.junit.Test;


public class MatchiSearchTest {
	

	@Test
	public void LogInTest() {
		MatchiSearch matchi = new MatchiSearch();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn("mjukvarutestare@mailinator.com");
	}
	

/*	
	@Test
	public void MatchiTest() {
		MatchiSearch matchi = new MatchiSearch();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.searchSport();
		matchi.chooseSport("Tennis");
		matchi.searchDay();
		matchi.chooseDay("24");
		matchi.searchArea();
		matchi.chooseArea("Göteborg");
		delay(2000);
		matchi.chooseArena("Hönö Tennissällskap");
	}	
*/		
	
	private void delay(int milliseconds)
	{
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
		}
	}

}
