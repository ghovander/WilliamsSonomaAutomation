package globalFunctionality.actions.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Gestures {
	public static void clickAction(WebElement element, WebDriver driver)
    {
        new Actions(driver).moveToElement(element).click().perform();
    }
    public static void hover(WebElement element, WebDriver driver)
    {
        new Actions(driver).moveToElement(element).perform();
    }
    public static void moveToPointClick(WebElement element, WebDriver driver, int offsetX, int offsetY)
    {
        new Actions(driver).moveToElement(element, offsetX, offsetY).click().build().perform();
    }
}
