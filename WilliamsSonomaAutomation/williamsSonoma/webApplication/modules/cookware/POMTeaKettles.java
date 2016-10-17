package webApplication.modules.cookware;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import globalFunctionality.actions.selenium.Set;
import globalFunctionality.actions.selenium.Wait;

public class POMTeaKettles {
	 private WebDriver driver;
     public POMTeaKettles(WebDriver driver)
     {
         this.driver = driver;
         PageFactory.initElements(driver, this);
     }
     
     private final String verifyBtnStickyClose = "//*[contains(@class,'sticky-close-button') and @title='Close']";
     
     @FindBy(how = How.XPATH, using = "//a[@class='product-name']") 
     private List<WebElement> btnsProductName; 
     @FindBy(how = How.XPATH, using = verifyBtnStickyClose) 
     private WebElement btnStickyClose; 
        
     public void viewProduct(int productIndex){
    	 clickStickyClose();
    	 clickProductName(productIndex);   	 
     }
     
     public void clickStickyClose(){
    	 for(int i=0; i<3; ++i){
    		 boolean isVisible = Wait.locateClickableElement(driver, 5, By.xpath(verifyBtnStickyClose));
    		 if(isVisible){
         		Set.click(btnStickyClose);
     		 	try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    		 }
    		 else break;
    	 }   	 
     }
     public void clickProductName(int index){
    	 Set.click(btnsProductName, index);
     }
}
