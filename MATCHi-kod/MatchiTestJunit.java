package matchi;

import org.junit.Test;

public class MatchiTestJunit {


//Here you can test that Cu can search Venues via the "boka"-page, all fields are tested.
//  	@Test
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
		matchi.searchArea("H�n�");
		matchi.chooseVenue();
		matchi.quitSelenium();
	}

//Here you can test that Cu can search Venues via the "Anl�ggningar"-page, all fields are tested.	
//	@Test
	public void SearchVenueViaVenues() {
		MatchiSearch matchi = new MatchiSearch();
//This is the page that is beeing tested
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		matchi.pageVenues();
//Here you can enter the Venue/City
		matchi.searchArea("H�n�");
		matchi.clickCounty();
//Here you can enter what County		
		matchi.chooseCounty("�cker�");
		matchi.selectCounty();
		matchi.searchAllSports();
//Here you can enter what sport is to be selected
		matchi.chooseSport("Badminton");
		matchi.clickSearchButton();
		matchi.quitSelenium();	
	}
	
//Here you can test that Cu can search Venues via the "My profile"-page, all fields are tested.
//	@Test
	public void SearchVenueViaMyPage() {
		MatchiSearch matchi = new MatchiSearch();
//This is the page that is beeing tested
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		matchi.searchSportMyProfile();
//Here you can enter what sport is to be selected
		matchi.chooseSport("Badminton");
		matchi.chooseDayOnMyPage("2018-08-25");
//Here you can enter the Venue/City
		matchi.searchArea("H�n�");
		matchi.clickSmashButton();
		matchi.quitSelenium();
	}
	
	@Test
	public void SearchMonthDayTime() {
		MatchiSearch matchi = new MatchiSearch();
		matchi.openSite("https://beta1.matchi.se/?lang=sv");
		matchi.logIn();
		matchi.pageBook();
		matchi.searchInOutCourt();
		matchi.chooseInOutCourt("Inomhus");
		matchi.searchSport();
		matchi.chooseSport("Badminton");
		matchi.chooseDayOnBook("2018-08-25");
		matchi.searchArea("H�n�");
		matchi.chooseVenue();
		matchi.chooseTime();
		
//		matchi.quitSelenium();
	}
	
	
}
