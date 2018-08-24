package matchi.matchi;

import org.junit.Test;

public class SearchMonthDayTime {
	
	/**
	 * Here you can test to select month, day and time on your booking via the page "Boka"
	 */
	@Test
	public void SearchMonthDayTimeViaBook() {
		MatchiSearchMonthDayTime matchi = new MatchiSearchMonthDayTime();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		matchi.pageBook();
		matchi.searchInOutCourt();
//Here you can enter Inomhus or Utomhus
		matchi.selectInOutCourt("Inomhus");
		matchi.searchSportViaBook();
//Here you can enter what sport is to be selected
		matchi.selectSport("Badminton");
//Here you can enter your desired date in the form "yyyy-mm-dd"
		matchi.selectDayViaBook("2018-08-31");
//Here you can enter the Venue/City		
		matchi.searchCityVenue("H�n�");
		matchi.selectVenueViaBook();
		matchi.selectTime();
		matchi.quitSelenium();
	}

	/**
	 * Here you can test to select month, day and time on your booking via the page "Min Profil" 
	 */
	@Test
	public void SearchMonthDayTimeViaMyPage() {
		MatchiSearchMonthDayTime matchi = new MatchiSearchMonthDayTime();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		matchi.searchSportViaMyProfile();
//Here you can enter what sport is to be selected
		matchi.selectSport("Badminton");
//Here you can enter your desired date in the form "yyyy-mm-dd"
		matchi.selectDayViaMyPage("2018-08-31");
//Here you can enter the Venue/City
		matchi.searchCityVenue("H�n�");
		matchi.clickSmashButton();
		matchi.selectTime();
		matchi.quitSelenium();
	}
	
	/**
	 * Here you can test to select month, day and time on your booking via the page "Anl�ggningar"
	 */
	@Test
	public void SearchMonthDayTimeViaVenues() {
		MatchiSearchMonthDayTime matchi = new MatchiSearchMonthDayTime();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		matchi.pageVenues();
//Here you can enter the Venue/City
		matchi.searchCityVenue("H�n�");
		matchi.clickOnCountyViaVenues();
//Here you can select the county
		matchi.searchCountyViaVenues("�cker�");
		matchi.selectCountyViaVenues();
		matchi.searchAllSportsViaVenues();
//Here you can enter what sport is to be selected
		matchi.selectSport("Badminton");
		matchi.clickSearchButton();
//Here you can select the displayed result
		matchi.selectVenueViaVenue("H�n�");
		matchi.selectTimeInVenues();
		matchi.quitSelenium();	
	}


}
