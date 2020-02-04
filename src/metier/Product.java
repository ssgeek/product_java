package metier;

import java.io.Serializable;

public class Product implements Serializable {
	
	private String reference;
	private String title;
	private double price;
	private int quantity;
	
	
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String reference, String title, double price, int quantity) {
		super();
		this.reference = reference;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}
	
	

}
