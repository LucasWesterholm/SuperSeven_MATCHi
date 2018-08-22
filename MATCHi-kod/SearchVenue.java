package matchi;

import org.junit.Test;

public class SearchVenue {

		/**
		 * Here you can search Venues via the "Boka"-page
		 */
		@Test
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
		@Test
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
		@Test
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

}
