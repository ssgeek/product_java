package web;

import java.util.ArrayList;
import java.util.List;

import metier.Product;

public class ProductModel {

	private String kword;
	private List<Product> products = new ArrayList<Product>();
	
	public String getKword() {
		return kword;
	}
	public void setKword(String kword) {
		this.kword = kword;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
