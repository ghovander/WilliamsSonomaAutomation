package webApplication.modules.shoppingCart;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import junit.framework.*;
import globalFunctionality.actions.junit.Assertions;
import globalFunctionality.actions.selenium.Set;
import globalFunctionality.actions.selenium.Wait;
import globalFunctionality.actions.selenium.Get;

public class POMShoppingCart {
	 private WebDriver driver;
     public POMShoppingCart(WebDriver driver)
     {
         this.driver = driver;
         PageFactory.initElements(driver, this);
     }
     
     private final String verifyBtnSaveForLater = "//a[contains(@name,'moveToSFL')]";
     private final String verifyItemTitle = "//*[@class='cart-table-row-title']";
     private final String verifyStockKeepingUnit = "//*[@class='cart-table-row-sku']";
     private final String verifyBtnMoveToShoppingCart = "//a[contains(@name,'moveFromSFL')]";
     
     @FindBy(how = How.XPATH, using = verifyBtnSaveForLater) 
     private List<WebElement> btnsSaveForLater; 
     @FindBy(how = How.CSS, using = ".save-for-later") 
     private WebElement headerSaveForLater; 
     @FindBy(how = How.XPATH, using = verifyItemTitle) 
     private List<WebElement> btnItemTitle; 
     @FindBy(how = How.XPATH, using = verifyStockKeepingUnit) 
     private List<WebElement> txtStockKeepingUnit;
     @FindBy(how = How.XPATH, using = verifyBtnMoveToShoppingCart) 
     private List<WebElement> btnMoveToShoppingCart;
       
     public void saveItemForLater(int index){
    	 verifySaveForLater();
    	 clickSaveForLater(index);
     }
     
     public void verifySaveForLater(){
    	 boolean elementExists = Wait.locateClickableElement(driver, 5, By.xpath(verifyBtnSaveForLater));
    	 Assertions.AssertEqualsTrue(elementExists);
     }
     public void clickSaveForLater(int index){
    	 Set.click(btnsSaveForLater, index);
     }
     public int getSavedItemsCount(){
    	 String headerText = Get.getText(headerSaveForLater);
    	 String substring1 = headerText.substring(16);
    	 String substring2 = substring1.substring(0,1);
    	 int count = Integer.parseInt(substring2);
    	 return count;
     }
     @SuppressWarnings("deprecation")
	 public void verifySavedItemsCount(int expectedSavedItemsCount){
    	 int actualSavedItemsCount = getSavedItemsCount();
    	 Assert.assertEquals(expectedSavedItemsCount, actualSavedItemsCount);
     }
     public String getItemTitle(int index){
    	 return Get.getTextFromIndex(btnItemTitle, index);
     }
     @SuppressWarnings("deprecation")
	 public void verifyItemTitle(String expectedItemTitle, int index){
    	 String actualItemTitle = Get.getTextFromIndex(btnItemTitle, index);
    	 Assert.assertEquals(expectedItemTitle, actualItemTitle);
     }
     public String getStockKeepingUnit(int index){
    	 return Get.getTextFromIndex(txtStockKeepingUnit, index);
     }
     @SuppressWarnings("deprecation")
	 public void verifyStockKeepingUnit(String expectedStockKeepingUnit, int index){
    	 String actualStockKeepingUnit = Get.getTextFromIndex(txtStockKeepingUnit, index);
    	 Assert.assertEquals(expectedStockKeepingUnit, actualStockKeepingUnit);
     }
     public void verifyMoveToShoppingCart(int index){
    	 boolean elementExists = Wait.locateClickableElement(driver, 3, By.xpath(verifyBtnMoveToShoppingCart));
    	 Assertions.AssertEqualsTrue(elementExists);
     }
}
