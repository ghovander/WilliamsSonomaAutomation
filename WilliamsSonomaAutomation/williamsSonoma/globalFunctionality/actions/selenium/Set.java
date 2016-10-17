package globalFunctionality.actions.selenium;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Set {	
	public static void click(WebElement element){
		element.click();
	}
	public static void click(List<WebElement> elements, int index){
		elements.get(index).click();
	}
	public static void type(WebElement element, String value)
    {
       element.clear();
       element.sendKeys(value);
    }
    public static void selectDropDownText(WebElement element, String value)
    {
        new Select(element).selectByVisibleText(value);
    }
    public static void selectDropDownValue(WebElement element, String value)
    {
        new Select(element).selectByValue(value);
    }
    public static void navigateBack(WebDriver driver)
    {
        driver.navigate().back();
    }
    public static void refreshBrowser(WebDriver driver){
    	driver.navigate().refresh();
    }
    public static void quitDriverInstance(WebDriver driver)
    {
    	driver.quit();
    }
}
