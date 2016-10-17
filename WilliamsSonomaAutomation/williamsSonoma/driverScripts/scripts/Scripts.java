package driverScripts.scripts;

import org.openqa.selenium.WebDriver;

import driverScripts.dataProperties.DataProperties;
import webApplication.modules.POMIndex;
import webApplication.modules.cookware.POMTeaKettles;
import webApplication.modules.product.POMConfirmationLightbox;
import webApplication.modules.product.POMProduct;
import webApplication.modules.shoppingCart.POMShoppingCart;

public class Scripts {
	public static void scriptSaveCartItem(WebDriver driver, DataProperties data){
		POMIndex index = new POMIndex(driver);
		index.navigateToTeaKettlesPage();
		POMTeaKettles teaKettles = new POMTeaKettles(driver);
		teaKettles.viewProduct(0);
		POMProduct product = new POMProduct(driver);
		product.addItemToCart(data.getSwatchColorIndex(), data.getItemQuantity());
		POMConfirmationLightbox confirmationLightbox = new POMConfirmationLightbox(driver);
		confirmationLightbox.NavigateToCheckoutPage();
		POMShoppingCart shoppingCart = new POMShoppingCart(driver);
		String expectedItemTitle = shoppingCart.getItemTitle(data.getItemTitleIndex());
		String expectedStockKeepingUnit = shoppingCart.getStockKeepingUnit(data.getStockKeepingUnitIndex());
		shoppingCart.saveItemForLater(0);
		shoppingCart.verifySavedItemsCount(1);
		shoppingCart.verifyItemTitle(expectedItemTitle, 0);
		shoppingCart.verifyStockKeepingUnit(expectedStockKeepingUnit, 0);
		shoppingCart.verifyMoveToShoppingCart(0);
	}
}
