package webApplication.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import globalFunctionality.actions.junit.Assertions;
import globalFunctionality.actions.selenium.Gestures;
import globalFunctionality.actions.selenium.Set;
import globalFunctionality.actions.selenium.Wait;

public class POMIndex {
	 private WebDriver driver;
     public POMIndex(WebDriver driver)
     {
         this.driver = driver;
         PageFactory.initElements(driver, this);
     }

     private final String verifyBtnTeaKettles = "(//a[contains(text(),'Tea Kettles')])[1]";
     private final String verifyBtnCloseEmailCampaign = "//*[@title='Minimize']";
     
     @FindBy(how = How.CLASS_NAME, using = "topnav-cookware ")
     private WebElement btnCookware; 
     @FindBy(how = How.XPATH, using = verifyBtnTeaKettles)
     private WebElement btnTeaKettles;
     @FindBy(how = How.XPATH, using = verifyBtnCloseEmailCampaign)
     private WebElement btnCloseEmailCampaign;
     
     public void navigateToTeaKettlesPage(){
    	 clickCloseEmailCampaign();
    	 hoverOverCookware();
    	 verifyTeaKettlesExists();
    	 selectTeaKettles();
     }
     
     public void clickCloseEmailCampaign(){
    	 boolean isVisible = Wait.locateClickableElement(driver, 8, By.xpath(verifyBtnCloseEmailCampaign));
    	 if(isVisible)
    		 Set.click(btnCloseEmailCampaign);
     }
     public void hoverOverCookware(){
    	 Gestures.hover(btnCookware, driver);
    	 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
     }
     public void selectTeaKettles(){
    	 Set.click(btnTeaKettles);
     }
     public void verifyTeaKettlesExists(){
    	 boolean elementExists = Wait.locateClickableElement(driver, 5, By.xpath(verifyBtnTeaKettles));
    	 Assertions.AssertEqualsTrue(elementExists);
     }
}
