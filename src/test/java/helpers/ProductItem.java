package helpers;

public class ProductItem {
	private String itemName;
	private String itemPrice;
	
	public ProductItem(String name, String price) {
		this.itemName = name;
		this.itemPrice = price;
	}
	
	public String getItemName(){ return this.itemName; }
	
	public String getItemPrice(){ return this.itemPrice; }
}
