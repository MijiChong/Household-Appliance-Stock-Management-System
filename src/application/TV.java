package application;

public class TV extends Product {
	private String screenType;
	private String resolution;
	private int displaySize;
	
	public TV(int item_num,
			String productName,
			String screenType,
			String resolution,
			int displaySize,
			int quantity,
			double price,
			boolean productStatus,
			int warranty) {
		super(item_num, productName, quantity, price);
		this.screenType = screenType;
		this.resolution = resolution;
		this.displaySize = displaySize;
		super.setWarranty(warranty);
		super.setStatus(productStatus);
	}
	
	public String getScreenType() {
		return screenType;
	}
	public String getResolution() {
		return resolution;
	}
	public int getDisplaySize() {
		return displaySize;
	}
	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public void setDisplaySize(int displaySize) {
		this.displaySize = displaySize;
	}
	public double calcStock() {
		return getPrice() * getQty();
	}
	
	@Override
	public String toString() {
		return "Item number: " + getItemNum()
		+ "\nProduct name: " + getName()
		+ "\nScreen type: " + getScreenType()
		+ "\nResolution: " + getResolution()
		+ "\nDisplay Siz (inches): " + getDisplaySize() + "\""
		+ "\nQuantity available: " + getQty()
		+ "\nPrice (RM): " + String.format("%.2f", getPrice())
		+ "\nInventory value (RM): " + String.format("%.2f", getTotalInventoryValue())
		+ "\nProduct status: " + getStatus();
	}
}
