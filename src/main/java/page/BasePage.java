package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public int generatedRandom (int bounderyNum) {
		Random rand = new Random ();
		int generatedNum = rand.nextInt(bounderyNum);
		return generatedNum;
	}
	
	public void selectFromDropDown(WebElement webElement, String visibleText) {
		Select sel = new Select(webElement);
		sel.selectByVisibleText(visibleText);

	}
	
	public void waitForElelement(WebDriver driver, int timeInSeconds, WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOf(webElement));
		
	}
}
