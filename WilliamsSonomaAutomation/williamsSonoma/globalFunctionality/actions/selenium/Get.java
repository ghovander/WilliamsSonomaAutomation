package globalFunctionality.actions.selenium;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Get {
    public static String getText(WebElement element)
    {
        return element.getText();
    }
    public static String getTextFromIndex(List<WebElement> elements, int index)
    {
        return elements.get(index).getText();
    }
    public static String getValueFromDropDown(WebElement element)
    {
        return element.getAttribute("value");
    }
    public static String getTextFromDropDown(WebElement element)
    {
        return new Select(element).getFirstSelectedOption().getText();
    }
    public static List<WebElement> getListFromDropDown(WebElement element)
    {
        return new Select(element).getOptions();
    }
    public static int getCountFromDropDown(WebElement element)
    {
        return new Select(element).getOptions().size();
    }
    public static int getCountFromPresentElements(List<WebElement> elements){
    	return elements.size();
    }
}
