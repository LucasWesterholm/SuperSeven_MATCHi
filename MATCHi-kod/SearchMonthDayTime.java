package matchi;

import org.junit.Test;

public class SearchMonthDayTime {
	
	/**
	 * Here you can test to select month, day and time on your booking via the page "Boka"
	 */
	@Test
	public void SearchMonthDayTimeViaBook() {
		MatchiSearch matchi = new MatchiSearch();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		matchi.pageBook();
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
	 * Here you can test to select month, day and time on your booking via the page "Min Profil" 
	 */
//	@Test
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


}
