package matchiCompleteChromeW;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class MatchiSearchMonthDayTime extends MatchiSearchBaseline {


	//	
	//METHODS FOR TESTING SEARCHING Month/Day/Time
	//
	
	/**
	 * Select the desired time on "Anläggningar" (time selected is 18:00)	
	 */
	public static void selectTimeInVenues() {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0,500)");
		WebElement element = webDriver.findElement (By.xpath("//*[@id=\"schedule\"]/div/div/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr/td[12]"));
		element.click();
	}

	/**
	 * Time is selected	(time selected is 18:00)
	 */
	public static void selectTime() {
		WebElement element = webDriver.findElement(By.xpath("//*[@id=\"slots_18\"]/ul/li[12]/button"));
		element.click();
	}	

}
