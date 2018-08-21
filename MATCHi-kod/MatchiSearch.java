package matchi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

	
public class MatchiSearch {
	private WebDriver webDriver;

		public MatchiSearch() {
		System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		/** testing pull to Git
		 * 
		 */
	
	public void openSite(String siteUrl) {
		webDriver.get(siteUrl);
		}
	
	
	public void logIn() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[2]/li[2]/a"));
		element.click();
		WebElement usernameElement = webDriver.findElement(By.cssSelector("#username"));
		usernameElement.click();
		usernameElement.sendKeys("mjukvarutestare3@mailinator.com");
		WebElement passwordElement = webDriver.findElement(By.cssSelector("#password"));
		passwordElement.click();
		passwordElement.sendKeys("mjukvarutestare");
		passwordElement.sendKeys(Keys.ENTER);
		}
	

	public void pageBook() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li[1]/a"));
		element.click();
		}
	
	public void pageVenues() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\'navbar-collapse\']/ul[1]/li[2]/a"));
		element.click();
	}
	
	public void searchSport() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[2]/div/div/button")); 
		element.click();
	}
	
	public void searchSportMyProfile() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[1]/div/div/button/span[2]")); 
		element.click();
	}
	
	public void searchAllSports() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[3]/div/button/span[1]")); 
		element.click();
	}
	
	public void chooseSport(String string) {
		WebElement element = webDriver.findElement(By.partialLinkText(string));
		element.click();	
	}

	public void searchDay() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id='showDate']"));
		element.click();
	}

	public void chooseDayOnMyPage(String string) {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"date\"]"));
		element.click();
		element.sendKeys(Keys.CONTROL+"a");
		element.sendKeys(string);
	}

	public void chooseDayOnBook(String string) {
			WebElement element = webDriver.findElement(By.xpath("//*[@id=\"showDate\"]"));
			element.click();
			element.sendKeys(Keys.CONTROL+"a");
			element.sendKeys(string);
		}

	public void searchArea(String area) {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"q\"]"));
		element.click();
		element.sendKeys(area);
		element.sendKeys(Keys.ENTER);
	}
	
	public void chooseArea(String string) {
		WebElement element = webDriver.findElement(By.id("q"));
		element.click();
		element.sendKeys();
		element.sendKeys(Keys.ENTER);
	}
	
	public void clickCounty() {
		WebElement element = webDriver.findElement (By.xpath("//*[@id=\'findFacilityForm\']/div/div[2]/div/button/span[1]"));
		element.click();
	}
	
	public void chooseCounty(String county) {
		WebElement element = webDriver.findElement (By.xpath("//*[@id=\"findFacilityForm\"]/div/div[2]/div/div/div/input"));
		element.sendKeys(county);
	}
	
	public void selectCounty() {
		WebElement element = webDriver.findElement (By.partialLinkText("(1)"));
		element.click();	
	}
	
	public void chooseVenue() {
		WebElement element = webDriver.findElement (By.xpath("//*[@id='findFacilityForm']/div/div[5]/button"));
		element.click();
	}
	
	public void selectVenue() {	
		WebElement element = webDriver.findElement (By.xpath("//*[@id=\"facilities-result\"]/div/div[1]/div/div[1]/div[1]/div/div[2]/h3/a"));
		element.click();
	}
	
	public void searchInOutCourt() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[1]/div/div/button"));
		element.click();
	}
	
	public void chooseInOutCourt(String string) {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[1]/div/div/div/ul/li[2]/a/span[1]"));
		element.click();
	}

	public void clickSearchButton() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"submit\"]"));
		element.click();

	}
	
	public void clickSmashButton() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[4]/button"));
		element.click();
	}
	
	public void chooseTime() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"slots_18\"]/ul/li[12]/button"));
		element.click();
	}
		
	public void quitSelenium() {
		webDriver.quit();
	}

}
