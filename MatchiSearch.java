package MatchiLucas;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

	
public class MatchiSearch {
	private WebDriver webDriver;

		public MatchiSearch() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		
//method OK	
	public void openSite(String siteUrl) {
		webDriver.get(siteUrl);
		}

//method OK
	public void logInNegative() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[2]/li[2]/a"));
		element.click();
		WebElement usernameElement = webDriver.findElement(By.cssSelector("#username"));
		usernameElement.click();
		usernameElement.sendKeys("mjukvarutestare3@mailinator.com");
		WebElement passwordElement = webDriver.findElement(By.cssSelector("#password"));
		passwordElement.click();
		passwordElement.sendKeys("mjukvarutest");
		passwordElement.sendKeys(Keys.ENTER);
	}
	
//method OK
	public boolean logInNegativeCheck(String negativePassword) {
		WebElement element = webDriver.findElement(By.className("notification-message"));
		String text = element.getText();
		return text.equals(negativePassword);
	}
	
//method OK		
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
	
//method OK
	public boolean logInPositiveCheck(String positivePassword) {
		WebElement element = webDriver.findElement(By.className("media-heading"));
		String text = element.getText();
		return text.equals(positivePassword);
	}

//method OK
		public void book() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li[1]/a"));
		element.click();
		}
		
//method OK
		public void searchSport() {
			WebElement element = webDriver.findElement(By.xpath("//button[@title='Välj sport']//span[@class='caret']")); 
			element.click();
		}
		
//method OK	
		public void chooseSport(String string) {
			WebElement element = webDriver.findElement(By.partialLinkText(string)); 
			element.click();
		}
		
//method OK
		public void searchVenue(String string) {
			WebElement element = webDriver.findElement(By.id("q")); 
			element.click();
			element.sendKeys(string);	
			WebElement smashElement = webDriver.findElement(By.name("submit")); 
			smashElement.click();
		}
		
//method OK
		public void chooseVenue(String string) {
			WebElement element = webDriver.findElement (By.linkText(string));
			element.click();
		}
		
//method OK
		public void chooseDate(String string) {
			WebElement element = webDriver.findElement(By.xpath("//tbody//tr[2]//td[2]//table[1]//tbody[1]//tr[1]//td[16]"));
			element.click();
		}
		
//method OK
		public void PayBySwish(String string) {
			WebElement element = webDriver.findElement(By.xpath("//label[@for='swish']"));
			element.click();
			WebElement elementNext = webDriver.findElement(By.className("btn-success"));
			elementNext.click();
		}
		
//method OK
		public void writeNumber(String string) {
			WebElement elementNr = webDriver.findElement(By.id("swish.telephoneNumber"));
			elementNr.click();
			elementNr.sendKeys(string);
			WebElement elementNext = webDriver.findElement(By.id("mainSubmit"));
			elementNext.click();
		}
	
//method OK	
	public void searchInOutCourt() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[1]/div/div/button"));
		element.click();
		}
	
//method OK	
	public void chooseInOutCourt(String string) {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[1]/div/div/div/ul/li[2]/a/span[1]"));
		element.click();
		}

    public void delay(Integer milliseconds){
	    try {
	        TimeUnit.MILLISECONDS.sleep(milliseconds);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
    }
    public void quitSelenium() {
    	delay(3000);
		webDriver.quit();
	}
    

}