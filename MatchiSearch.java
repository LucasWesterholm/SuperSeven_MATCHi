import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

	
public class MatchiSearch {
	private WebDriver webDriver;

		public MatchiSearch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\j-g_9\\eclipse-workspace\\Library\\chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		/** testing pull to Git
		 * 
		 */
//method OK	
	public void openSite(String siteUrl) {
		webDriver.get(siteUrl);
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
	public void book() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[1]/li[1]/a"));
		element.click();
		}
	
//method OK when go from home page. NOT working from the menu Boka 
	public void chooseSportWithOutLogin(String string) {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"hero\"]/div/div/div[1]/div/form/div/div[1]/div/div/ul/li[2]/a")); 
		element.click();
		}
	
	public void searchSport() {
		WebElement element = webDriver.findElement(By.xpath("//span[@class='filter-option pull-left']"));
		element.click();
	}
	
	
//method OK
	public void chooseSport(String string) {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"hero\"]/div/div/div[1]/div/form/div/div[1]/div/div/ul/li[2]/a")); 
		element.click();
		}
	
//method OK
	public void searchDay() {
		WebElement element = webDriver.findElement(By.id("date"));
		element.click();
	}
	
	//date value 2018-08-31 - need to add functionality for choosing different month than existing

	public void chooseDay(String string) {
		WebElement element = webDriver.findElement(By.cssSelector("#date"));
	//#date
		//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[6]/a"   = 31 aug
		//*[@id="ui-datepicker-div"]/table/tbody/tr[4]/td[3]/a" 	= 21 aug
		element.click();
		element.sendKeys(string);
	}
	
	public void chooseDate(String string) {
		WebElement element = webDriver.findElement(By.xpath("//input[@id='date']"));
		element.click();
		element.sendKeys(Keys.CONTROL+"a");
		element.sendKeys(string);
	}

//method OK
	public void searchArea() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"q\"]"));
		element.click();
		}
	
//method OK	
	public void chooseArea(String string) {
		WebElement element = webDriver.findElement(By.id("q"));
		element.click();
		element.sendKeys();
		element.sendKeys(Keys.ENTER);
	}
	
//method OK	
	public void chooseVenue(String string) {
		WebElement element = webDriver.findElement(By.xpath("//input[@id='q']"));
		element.click();
		element.sendKeys(string);
		WebElement element2 = webDriver.findElement(By.xpath("//button[@name='submit']"));
		element2.click();
		WebElement element3 = webDriver.findElement(By.xpath("//a[@class='text-black weight400']"));
		element3.click();
	}
	
	
	
	public void searchInOutCourt() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[1]/div/div/button"));
		element.click();
	}
	
	public void chooseInOutCourt(String string) {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[1]/div/div/div/ul/li[2]/a/span[1]"));
		element.click();
	}

	

}
