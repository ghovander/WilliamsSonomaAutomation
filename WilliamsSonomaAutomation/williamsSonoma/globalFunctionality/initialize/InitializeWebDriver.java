package globalFunctionality.initialize;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;

import driverScripts.dataProperties.DataProperties;

public class InitializeWebDriver {
	private DataProperties data;
	private int width;
	private int height;
	
	public InitializeWebDriver(DataProperties data){
		setup(data);
	};
	
	public InitializeWebDriver(DataProperties data, int viewportWidth, int viewportHeight){
		setup(data);
		width = viewportWidth;
		height = viewportHeight;		
	}
	
	private void setup(DataProperties data){
		setDataProperties(data);
	}
	
	private void setDataProperties(DataProperties data){
		this.data = data;
	}
	
	public WebDriver startWebDriver(){
		WebDriver driver = null;
		String browser = data.getBrowser();
		switch(browser){
			case Configurations.chromeBrowser:
				System.setProperty("webdriver.chrome.driver", new File(Configurations.chromeDriverFile).getAbsolutePath());
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				driver = new ChromeDriver(options);
                break;
			case Configurations.firefoxBrowser:
				System.setProperty("webdriver.gecko.driver", new File(Configurations.firefoxDriverFile).getAbsolutePath());
				driver = new FirefoxDriver();
                break;	
			case Configurations.internetExplorerBrowser:
				System.setProperty("webdriver.ie.driver", new File(Configurations.internetExplorerFile).getAbsolutePath());
				driver = new InternetExplorerDriver();
				break;
		}
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //There is a bug in the latest release of ChromeDriver.exe which prevents full screen with driver.manage().window().maximize().
        if(width != 0 && height !=0) driver.manage().window().setSize(new Dimension(width, height));
        else if(browser == Configurations.firefoxBrowser || browser == Configurations.internetExplorerBrowser)
        	driver.manage().window().maximize();
		return driver;
	}
	
	public void navigateToURL(WebDriver driver){
		driver.navigate().to(Configurations.url);
	}
}
