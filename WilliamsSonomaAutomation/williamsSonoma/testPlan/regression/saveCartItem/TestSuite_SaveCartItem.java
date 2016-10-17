package testPlan.regression.saveCartItem;

import driverScripts.dataProperties.*;
import driverScripts.scripts.Scripts;
import globalFunctionality.actions.selenium.Set;
import globalFunctionality.initialize.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

@RunWith(JUnitParamsRunner.class)
public class TestSuite_SaveCartItem extends Data_SaveCartItem {	
	private DataProperties data;
	private WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.data = new DataProperties();
	}

	@Test
	@Parameters(method = "parametersForSaveCartItem")
	public void saveCartItems(String browser, int swatchColorIndex, int itemQuantity, int itemTitleIndex, int stockKeepingUnitIndex){
		data.setBrowser(browser);
		data.setSwatchColorIndex(swatchColorIndex);
		data.setItemQuantity(itemQuantity);
		data.setItemTitleIndex(itemTitleIndex);
		data.setStockKeepingUnitIndex(stockKeepingUnitIndex);
		InitializeWebDriver initialize = new InitializeWebDriver(data);
		this.driver = initialize.startWebDriver();
		initialize.navigateToURL(driver);
		Scripts.scriptSaveCartItem(driver, data);	
	}
	
	@After
	public void tearDown() throws Exception {
		Set.quitDriverInstance(driver);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
