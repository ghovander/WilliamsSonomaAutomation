package webApplication.modules.product;

import java.util.List;
import globalFunctionality.actions.selenium.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import globalFunctionality.actions.selenium.Set;

public class POMProduct {
	 private WebDriver driver;
     public POMProduct(WebDriver driver)
     {
         this.driver = driver;
         PageFactory.initElements(driver, this);
     }
     
     private final String verifyFldQuantity = "qty";
     private final String verifyBtnSwatchColor = "//*[@class='swatchThumb']";
     
     @FindBy(how = How.XPATH, using = "//*[contains(text(),'Add to Cart')]") 
     private WebElement btnAddToCart; 
     @FindBy(how = How.CLASS_NAME, using = verifyFldQuantity) 
     private WebElement fldQuantity; 
     @FindBy(how = How.XPATH, using = verifyBtnSwatchColor) 
     private List<WebElement> btnSwatchColor;
     
     public void addItemToCart(int swatchColorIndex, int itemQuantity){
    	 selectSwatchColor(swatchColorIndex);
    	 enterQuantity(itemQuantity);
    	 clickAddToCart();
     }
     
     public void selectSwatchColor(int index){
    	 if(Wait.locatePresentElements(driver, 2, By.xpath(verifyBtnSwatchColor))){
    		 int elementCount = Get.getCountFromPresentElements(btnSwatchColor);
    		 if(index >= elementCount) index=0;
    		 Set.click(btnSwatchColor, index);
    	 }
     }
     public void enterQuantity(int quantity){
    	 if(Wait.locateVisibleElement(driver, 2, By.className(verifyFldQuantity))){
    		 if(quantity < 1) quantity=1;
    		 Set.type(fldQuantity, Integer.toString(quantity));
    	 }
     }
     public void clickAddToCart(){
    	 Set.click(btnAddToCart);
     }
     
     
}
