package testPlan.regression.saveCartItem;

import globalFunctionality.initialize.Configurations;

public class Data_SaveCartItem {	
	//Notes: 
	//--- FirefoxBrowser cannot use the Actions class due compatibility issues with the
	//new geckodriver release for the latest version of firefox.
	//--- InternetExplorerBrowser is using the latest driver for IE11 compatibility. To be
	//compatibale, the browser "Enable Protected Mode" settings must be all ON or OFF. In
	//addition, please adjust your zoom level to 100%. Even with these change the driver has
	//difficulty communicating with the browser.
	//--- The parametersForSaveCartItem method is utilized, but Eclipse's real-time error/warnings checks
	//do not know that it that the subclass will consume it during runtime.	
	//--- The following code allows the tester to run the same test method multiple times with different
	//sets of data.
	
	@SuppressWarnings("unused")
	private Object[][] parametersForSaveCartItem() {
		return new Object[][]{
	                 {Configurations.chromeBrowser, 1, 1, 0, 0},
/*	                 {Configurations.firefoxBrowser, 1, 1, 0, 0},*/
/*	                 {Configurations.internetExplorerBrowser, 1, 1, 0, 0}*/
	            };
	}
}
