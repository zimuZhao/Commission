package cn.hit.commission.po;

public class Products {
	
	private int productsID;
	private String name;
	private double price;
	private int stock;
	private String description;
	private int deleteFlag;
	
	public int getProductsID() {
		return productsID;
	}
	public void setProductsID(int productsID) {
		this.productsID = productsID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
