package MATCHi3;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class MatchiSearchTest {



	/**
	 * Login test -  Negative
	 */
	//@Test
	public void LogInNegativeTest() {
		MatchiSearch matchi = new MatchiSearch();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logInNegative();
		assertTrue(matchi.logInNegativeCheck("Felaktigt användarnamn eller lösenord"));
		matchi.quitSelenium();
	}

	/**
	 * Login test - Positive
	 */
//	@Test
	public void LogInTest() {
		MatchiSearch matchi = new MatchiSearch();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		assertTrue(matchi.logInPositiveCheck("Mjuk Varutestare"));
		matchi.quitSelenium();

	}

	/**
	 * Here you can test to select month, day and time on your booking via the page "Boka"
	 */
//	@Test
	public void SearchMonthDayTimeViaBook() {
		MatchiSearch matchi = new MatchiSearch();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		matchi.pageBook();
		delay(2000);
		matchi.searchInOutCourt();
		//Here you can enter Inomhus or Utomhus
		matchi.chooseInOutCourt("Inomhus");
		matchi.searchSport();
		//Here you can enter what sport is to be selected
		matchi.chooseSport("Badminton");
		//Here you can enter your desired date in the form "yyyy-mm-dd"
		matchi.chooseDayOnBook("2018-08-25");
		//Here you can enter the Venue/City		
		matchi.searchArea("Hönö");
		matchi.chooseVenue();
		matchi.chooseTime();
		matchi.quitSelenium();
	}


	/**
	 *  Here you can test to select month, day and time on your booking via the page "Min Profil" 
	 */
	//@Test
	public void SearchMonthDayTimeViaMyPage() {
		MatchiSearch matchi = new MatchiSearch();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		matchi.searchSportMyProfile();
		//Here you can enter what sport is to be selected
		matchi.chooseSport("Badminton");
		//Here you can enter your desired date in the form "yyyy-mm-dd"
		matchi.chooseDayOnMyPage("2018-08-25");
		//Here you can enter the Venue/City
		matchi.searchArea("Hönö");
		matchi.clickSmashButton();
		matchi.chooseTime();
		matchi.quitSelenium();
	}

	/**
	 * Here you can test to select month, day and time on your booking via the page "Anläggningar"
	 */
//	@Test
	public void SearchMonthDayTimeViaVenues() {
		MatchiSearch matchi = new MatchiSearch();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		matchi.pageVenues();
		//Here you can enter the Venue/City
		matchi.searchArea("Hönö");
		matchi.clickCounty();
		//Here you can select the county
		matchi.chooseCounty("Öckerö");
		matchi.selectCounty();
		matchi.searchAllSports();
		//Here you can enter what sport is to be selected
		matchi.chooseSport("Badminton");
		matchi.clickSearchButton();
		//Here you can select the displayed result
		matchi.selectVenue("Hönö");
		matchi.chooseTimeInVenues();
		matchi.quitSelenium();	
	}


	/**
	 * Here you can search Venues via the "Boka"-page
	 */
//	@Test
	public void SearchVenueViaBook() {
		MatchiSearch matchi = new MatchiSearch();
		//This is the page that is beeing tested
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		matchi.pageBook();
		matchi.searchInOutCourt();
		//Enter Inomhus or Utomhus
		matchi.chooseInOutCourt("Inomhus");
		matchi.searchSport();
		//Here you can enter what sport is to be selected
		matchi.chooseSport("Badminton");
		//Enter the date you wish to book 
		matchi.chooseDayOnBook("2018-08-25");
		//Here you can enter the Venue/City
		matchi.searchArea("Hönö");
		matchi.chooseVenue();
		matchi.quitSelenium();
	}

	/**
	 * Here you can search Venues via the "Anläggningar"-page	
	 */
//	@Test
	public void SearchVenueViaVenues() {
		MatchiSearch matchi = new MatchiSearch();
		//This is the page that is beeing tested
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		matchi.pageVenues();
		//Here you can enter the Venue/City
		matchi.searchArea("Hönö");
		matchi.clickCounty();
		//Here you can enter what County		
		matchi.chooseCounty("Öckerö");

		//ÄNDRA DENNA SÅ DET INTE ÄR (1)?
		matchi.selectCounty();
		matchi.searchAllSports();
		//Here you can enter what sport is to be selected
		matchi.chooseSport("Badminton");
		matchi.clickSearchButton();
		matchi.quitSelenium();	
	}

	/**
	 * Here you can search Venues via the "Min profil"-page
	 */
//	@Test
	public void SearchVenueViaMyPage() {
		MatchiSearch matchi = new MatchiSearch();
		//This is the page that is beeing tested
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		matchi.searchSportMyProfile();
		//Here you can enter what sport is to be selected
		matchi.chooseSport("Badminton");
		//Here you can enter your desired date in the form "yyyy-mm-dd"
		matchi.chooseDayOnMyPage("2018-08-25");
		//Here you can enter the Venue/City
		matchi.searchArea("Hönö");
		matchi.clickSmashButton();
		matchi.quitSelenium();
	}

	/**
	 * A complete testcase from beginning to end	
	 */
	//@Test
			public void MatchiTest() {
			MatchiSearch matchi = new MatchiSearch();
			matchi.openSite("https://beta1.matchi.se/?lang=sv");
			matchi.logIn();	
		}

			private void delay(int milliseconds)
			{
				try {
					Thread.sleep(milliseconds);
				} catch (InterruptedException e) {
				}
			}


}

