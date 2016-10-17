package globalFunctionality.actions.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	 public static boolean locatePresentElement(WebDriver driver, long seconds, By byWebElementValue)
	 {
	     try
	     {
	         new WebDriverWait(driver, seconds).until(ExpectedConditions.presenceOfElementLocated(byWebElementValue));
	         return true;
	     }
	     catch(Exception e)
	     {
	         return false;
	     }
	 }
	 public static boolean locateVisibleElement(WebDriver driver, long seconds, By byWebElementValue)
	 {
	     try
	     {
	         new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOfElementLocated(byWebElementValue));
	         return true;
	     }
	     catch(Exception e)
	     {
	         return false;
	     }
	 }
	 public static boolean locateClickableElement(WebDriver driver, long seconds, By byWebElementValue){
	     try
	     {
	         new WebDriverWait(driver, seconds).until(ExpectedConditions.elementToBeClickable(byWebElementValue));
	         return true;
	     }
	     catch(Exception e)
	     {
	         return false;
	     }
	  }
	 @SuppressWarnings("deprecation")
	 public static boolean locateTextInElement(WebDriver driver, long seconds, By byWebElementValue, String text){
	     try
	     {
	         new WebDriverWait(driver, seconds).until(ExpectedConditions.textToBePresentInElement(byWebElementValue, text));
	         return true;
	     }
	     catch(Exception e)
	     {
	         return false;
	     }
	  }
	 public static boolean locateValueInElement(WebDriver driver, long seconds, By byWebElementValue, String value){
	     try
	     {
	         new WebDriverWait(driver, seconds).until(ExpectedConditions.textToBePresentInElementValue(byWebElementValue, value));
	         return true;
	     }
	     catch(Exception e)
	     {
	         return false;
	     }
	  }
	 public static boolean locatePresentElements(WebDriver driver, long seconds, By byWebElementValue){
	     try
	     {
	         new WebDriverWait(driver, seconds).until(ExpectedConditions.presenceOfAllElementsLocatedBy(byWebElementValue));
	         return true;
	     }
	     catch(Exception e)
	     {
	         return false;
	     }
	  }
}
