package models;

public class ProductItemModel {
	private String name;
	private String price;
	
	private ProductItemModel(ProductItemBuilder builder) {
		this.name = builder.name;
		this.price = builder.price;
	}

	public String getName(){ return this.name; }
	
	public String getPrice(){ return this.price; }

	@Override
	public String toString(){
		return new StringBuilder("Product: " + this.name)
				.append(", " + this.price).toString();
	}

	public static class ProductItemBuilder{
		private String name;
		private String price;

		public ProductItemBuilder(){ }

		public ProductItemBuilder name(String name) {
			this.name = name;
			return this;
		}

		public ProductItemBuilder price(String price) {
			this.price = price;
			return this;
		}

		public ProductItemModel build(){
			return new ProductItemModel(this);
		}

	}

}
