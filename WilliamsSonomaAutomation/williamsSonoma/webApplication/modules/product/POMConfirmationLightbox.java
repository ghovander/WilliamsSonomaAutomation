package webApplication.modules.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import globalFunctionality.actions.junit.Assertions;
import globalFunctionality.actions.selenium.Set;
import globalFunctionality.actions.selenium.Wait;

public class POMConfirmationLightbox {
	 private WebDriver driver;
     public POMConfirmationLightbox(WebDriver driver)
     {
         this.driver = driver;
         PageFactory.initElements(driver, this);
     }
     
     private final String verifyBtnCheckout = "anchor-btn-checkout";
     
     @FindBy(how = How.ID, using = verifyBtnCheckout) 
     private WebElement btnCheckout; 
       
     public void NavigateToCheckoutPage(){
    	 verifyCheckoutExists();
    	 clickCheckout();
     }
     
     public void verifyCheckoutExists(){
    	 boolean elementExists = Wait.locateClickableElement(driver, 5, By.id(verifyBtnCheckout));
    	 Assertions.AssertEqualsTrue(elementExists);
     }
     public void clickCheckout(){
    	 Set.click(btnCheckout);
     }
}
