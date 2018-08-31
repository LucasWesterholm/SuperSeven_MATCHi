package ffMatchi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MatchiSearch {
	private WebDriver webDriver;

	public MatchiSearch() {
		//System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
		//webDriver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sarada mutnuru\\SeleniumServer\\geckodriver-v0.21.0-win64\\geckodriver.exe");
	  webDriver = new FirefoxDriver();

		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public void openSite(String site) {

		webDriver.get(site);
 }
	public void selectNorsk(String langnorsk)
	{
		WebElement language=webDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[2]/li[1]/a"));
		language.click();
		WebElement norsk=webDriver.findElement(By.linkText(langnorsk));
		norsk.click();
	}
	
	public void selectLogin() {
		WebElement loginbuttonelement=webDriver.findElement(By.linkText("Logg inn"));
		loginbuttonelement.click();
		}
	public void loginInto() {
		
		WebElement userid =webDriver.findElement(By.id("username"));
		userid.click();
		userid.sendKeys("mjukvarutestare3@mailinator.com");
		WebElement passwordelemnet= webDriver.findElement(By.id("password"));
		passwordelemnet.click();
		passwordelemnet.sendKeys("mjukvarutestare");
		WebElement loginbutton= webDriver.findElement(By.xpath("//*[@id=\"loginForm\"]/button"));
		loginbutton.click();
				}
     public void chooseSport() {
		
		WebElement dropdown=webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[1]/div/div/button/span[1]"));
        dropdown.click();
    			
    		
		
	}
	public void selectedSport(String sport) {
		
		WebElement selectsport=webDriver.findElement(By.linkText(sport));
		selectsport.click();
		
	}
	public void selectedDate(String date) {
		WebElement selectdate=webDriver.findElement(By.id("date"));
		selectdate.clear();
		selectdate.click();
		selectdate.sendKeys(date);
	}
	
	
	public void selectedCity(String city) {
		WebElement selectcity=webDriver.findElement(By.name("q"));
		selectcity.clear();
		selectcity.sendKeys(city);
	}
	public void clickonSmash() {
		WebElement searchbtn=webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[4]/button"));
		
		searchbtn.click();
	}
	public void chooseInOrOut(String inorout) {
		WebElement inoutdropdown=webDriver.findElement(By.xpath("//*[@id=\"findFacilityForm\"]/div/div[1]/div/div/button/span[1]"));
		inoutdropdown.click();
	
		WebElement inout =webDriver.findElement(By.linkText(inorout));
		inout.click();
		

	}
	public void selectArena(String arena) {
		WebElement selectedarena=webDriver.findElement(By.partialLinkText(arena));
		selectedarena.click();
	}

	public void chooseTime(String time) {
		WebElement timelist=webDriver.findElement(By.xpath("//*[@id=\"mobile-booking\"]/ul"));
		timelist.sendKeys(time);
		timelist.sendKeys(Keys.ENTER);
		}
		
	public void chooseCourtTime(String venue,String time) {
		WebElement timevenue = webDriver.findElement(By.xpath("//tbody//tr["+venue+"]//td[2]//table[1]//tbody[1]//tr[1]//td["+time+"]"));
		timevenue.click();
	}
	public void bookingViaNewCC() {
		
		WebElement newccoption =webDriver.findElement(By.xpath("//*[@id=\"confirmForm\"]/div[2]/div[3]/div[2]/div[2]/div/label"));
		
		newccoption.click();
}
	
			
			
	public void clickBookButton() {
		WebElement bookbutton=webDriver.findElement(By.id("btnSubmit"));
		bookbutton.click();
	}
	public void enterCCdetails(String cardnumber, String nameofcardholder, String cvcnumber) {
		
		WebElement ccnumber=webDriver.findElement(By.xpath("//*[@id=\"adyen-encrypted-form\"]/div[1]/div/div/div[2]/div[1]/div/input"));
		ccnumber.clear();
		ccnumber.click();
		JavascriptExecutor js= (JavascriptExecutor) webDriver;
		js.executeScript("arguments[1].value = arguments[0]; ", cardnumber, ccnumber); 
		
		
		WebElement name=webDriver.findElement(By.xpath("//*[@id=\"adyen-encrypted-form\"]/div[1]/div/div/div[2]/div[2]/input"));
		name.click();
		name.sendKeys(nameofcardholder);
		
		
		
		WebElement element6 = webDriver.findElement(By.xpath("//option[@value='10']"));
		element6.click();
		WebElement element7 = webDriver.findElement(By.xpath("//option[@value='2020']"));
		element7.click();
		
		WebElement cvcno=webDriver.findElement(By.xpath("//*[@id=\"adyen-encrypted-form\"]/div[1]/div/div/div[2]/div[5]/div/input"));
		cvcno.click();
		cvcno.sendKeys(cvcnumber);
		
		
		WebElement dopayment=webDriver.findElement(By.xpath("//*[@id=\"adyen-encrypted-form\"]/div[2]/input"));
		dopayment.click();
	}
	
/*public void enterCCdetails(String cardnumber) {
	
	
		
		WebElement ccnumber=webDriver.findElement(By.xpath("//*[@id=\"adyen-encrypted-form\"]/div[1]/div/div/div[2]/div[1]/div/input"));
		ccnumber.clear();
		ccnumber.click();
		
		JavascriptExecutor js= (JavascriptExecutor) webDriver;
		js.executeScript("arguments[1].value = arguments[0]; ", cardnumber, ccnumber); 
		
		//ccnumber.sendKeys(cardnumber);
		//ccnumber.sendKeys(String.valueOf(cardnumber));
		//for(int i=0;i<cardnumber.length();i++){
          //  ccnumber.sendKeys(cardnumber.substring(i));
		
        }

	
public void enterCCname(String nameofcardholder){
	
	WebElement name=webDriver.findElement(By.xpath("//*[@id=\"adyen-encrypted-form\"]/div[1]/div/div/div[2]/div[2]/input"));
	name.click();
	name.sendKeys(nameofcardholder);
	
}
public void enterCCcvc(String cvcnumber) {
	
	WebElement cvcno=webDriver.findElement(By.xpath("//*[@id=\"adyen-encrypted-form\"]/div[1]/div/div/div[2]/div[5]/div/input"));
	cvcno.click();
	cvcno.sendKeys(cvcnumber);
	}
	*/
	
	
	public void closeWindow() {
		WebElement closewindow=webDriver.findElement(By.xpath("//*[@id=\"userBookingModal\"]/div[1]/div/div[3]/a"));
		closewindow.click();
	}
	
	public void logout() {
		WebElement mjuk=webDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[2]/li[4]/a"));
		mjuk.click();
		WebElement logout=webDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[2]/li[4]/ul/li[8]/a"));
		logout.click();
		
}
	public void cancelBooking() {
		WebElement cancelbooking=webDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[2]/li[3]/a/i"));
		cancelbooking.click();
		WebElement clickoncancel=webDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul[2]/li[3]/ul/li[1]/a/div/div[2]/h5"));
		clickoncancel.click();
		delay(1000);
		WebElement avbook=webDriver.findElement(By.xpath("//*[@id=\"userBookingModal\"]/div[2]/div/div[3]/a[2]"));
		avbook.click();
		//*[@id="userBookingModal"]/div[2]/div/div[3]/a[2]
		WebElement closewindow=webDriver.findElement(By.xpath("//*[@id=\"cancelCloseBtn\"]"));
		closewindow.click();
	}
	public void multipleBookings() {
		WebElement multibooking=webDriver.findElement(By.id("block-book-start"));
		
		multibooking.click();
		chooseCourtTime("2", "6");
		delay(1000);
		chooseCourtTime("1","8");
		
		
	}
	public void quitSelenium() {
		webDriver.close();
	}

	public void delay(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
		}
	}
}
