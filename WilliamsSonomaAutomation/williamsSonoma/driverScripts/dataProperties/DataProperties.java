package driverScripts.dataProperties;

public class DataProperties {
	private String browser;
	private int swatchColorIndex;
	private int itemQuantity;
	private int itemTitleIndex;
	private int stockKeepingUnitIndex;
	
	public String getBrowser(){return this.browser;}
	public void setBrowser(String browser){this.browser = browser;}
	
	public int getSwatchColorIndex(){return this.swatchColorIndex;}
	public void setSwatchColorIndex(int swatchColorIndex){this.swatchColorIndex = swatchColorIndex;}
	
	public int getItemQuantity(){return this.itemQuantity;}
	public void setItemQuantity(int itemQuantity){this.itemQuantity = itemQuantity;}
	
	public int getItemTitleIndex(){return this.itemTitleIndex;}
	public void setItemTitleIndex(int itemTitleIndex){this.itemTitleIndex = itemTitleIndex;}
	
	public int getStockKeepingUnitIndex(){return this.stockKeepingUnitIndex;}
	public void setStockKeepingUnitIndex(int stockKeepingUnitIndex){this.stockKeepingUnitIndex = stockKeepingUnitIndex;}
}
