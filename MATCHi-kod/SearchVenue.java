package matchi.matchi;

import org.junit.Test;

public class SearchVenue {

		/**
		 * Here you can search Venues via the "Boka"-page
		 */
		@Test
		public void SearchVenueViaBook() {
			MatchiSearchVenue matchi = new MatchiSearchVenue();
//This is the page that is beeing tested
			matchi.openSite("https://beta1.matchi.se/?lang=sv");
			matchi.logIn();
			matchi.pageBook();
			matchi.searchInOutCourt();
//Enter Inomhus or Utomhus
			matchi.selectInOutCourt("Inomhus");
			matchi.searchSportViaBook();
//Here you can enter what sport is to be selected
			matchi.selectSport("Badminton");
//Enter the date you wish to book 
			matchi.selectDayViaBook("2018-08-31");
//Here you can enter the Venue/City
			matchi.searchCityVenue("Hönö");
			matchi.selectVenueViaBook();
			matchi.quitSelenium();
		}

		/**
		 * Here you can search Venues via the "Anläggningar"-page	
		 */
//		@Test
		public void SearchVenueViaVenues() {
			MatchiSearchVenue matchi = new MatchiSearchVenue();
//This is the page that is beeing tested
			matchi.openSite("https://beta1.matchi.se/?lang=sv");
			matchi.logIn();
			matchi.pageVenues();
//Here you can enter the Venue/City
			matchi.searchCityVenue("Hönö");
			matchi.clickOnCountyViaVenues();
//Here you can enter what County		
			matchi.searchCountyViaVenues("Öckerö");
			matchi.selectCountyViaVenues();
			matchi.searchAllSportsViaVenues();
//Here you can enter what sport is to be selected
			matchi.selectSport("Badminton");
			matchi.clickSearchButton();
			matchi.quitSelenium();	
		}
		
		/**
		 * Here you can search Venues via the "Min profil"-page
		 */
//		@Test
		public void SearchVenueViaMyPage() {
			MatchiSearchVenue matchi = new MatchiSearchVenue();
//This is the page that is beeing tested
			matchi.openSite("https://beta1.matchi.se/?lang=sv");
			matchi.logIn();
			matchi.searchSportViaMyProfile();
//Here you can enter what sport is to be selected
			matchi.selectSport("Badminton");
//Here you can enter your desired date in the form "yyyy-mm-dd"
			matchi.selectDayViaMyPage("2018-08-31");
//Here you can enter the Venue/City
			matchi.searchCityVenue("Hönö");
			matchi.clickSmashButton();
			matchi.quitSelenium();
		}

}
