package matchiDemoSecondSprint.functions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import matchiDemoSecondSprint.MatchiBaseline;



public class MatchiSearchLogIn extends MatchiBaseline{

	//
	// METHODS FOR TESTING LOGIN
	//
	
	/**
	 * Log in with a negative password
	 */
	public static void logInNegative() {
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
		
	/**
	 * Check for the negative password, grabs the error message and returns the message to an assert
	 * @param negativePassword
	 * @return
	 */
	public static boolean logInNegativeCheck(String negativePassword) {
		WebElement element = webDriver.findElement(By.className("notification-message"));
		String text = element.getText();
		return text.equals(negativePassword);
	}
	
	/**
	 * Check for the positive password, grabs the user name and returns the message to an assert
	 * @param positivePassword
	 * @return
	 */
	public static boolean logInPositiveCheck(String positivePassword) {
		WebElement element = webDriver.findElement(By.className("media-heading"));
		String text = element.getText();
		return text.equals(positivePassword);
		
	}
	public static boolean logInPositiveCheckNew(String positivePassword) {
		WebElement element = webDriver.findElement(By.xpath("/html/body/div[1]/div[3]/section[1]/div/div/div/div[1]/div[1]/div[2]/h4/a"));
		String text = element.getText();
		return text.equals(positivePassword);
		
	}

}