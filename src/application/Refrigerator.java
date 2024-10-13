package application;

public class Refrigerator extends Product {
	private String doorDesign;
	private String color;
	private double capacity;
	
	public Refrigerator(int item_num,
			String productName, 
			String doorDesign,
			String color, 
			double capacity,
			int quantity, 
			double price,
			boolean productStatus,
			int warranty) {
		super(item_num, productName, quantity, price);
		this.doorDesign = doorDesign;
		this.color = color;
		this.capacity = capacity;
		super.setStatus(productStatus);
		super.setWarranty(warranty);

	}
	public String getDoorDesign() {
		return doorDesign;
	}
	public String getColor() {
		return color;
	}
	public double getCapacity() {
		return capacity;
	}
	public void setDoorDesign(String design) {
		doorDesign = design;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public double calcStock() {
		return getPrice() * getQty();
	}
	
	@Override
	public String toString() {
		return "Item number: " + getItemNum()
		+ "\nProduct name: " + getName()
		+ "\nDoor design: " + getDoorDesign()
		+ "\nColor: " + getColor()
		+ "\nCapacity (in Litres): " + getCapacity()
		+ "\nQuantity available: " + getQty()
		+ "\nPrice (RM): " + String.format("%.2f", getPrice())
		+ "\nInventory value (RM): " + String.format("%.2f", getTotalInventoryValue())
		+ "\nProduct status: " + getStatus();
	}
}
