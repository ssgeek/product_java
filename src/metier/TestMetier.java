package metier;

import java.util.List;

public class TestMetier {

	public static void main(String[] args) {
		
		IProductMetier metier = new ProductMetierImpl();
		/*
		//Testing add product
		metier.addProduct(new Product("REF0001", "AA", 200, 5));
		metier.addProduct(new Product("REF0002", "BB", 120, 3));
		*/
		
		//Testing Listing Products
		List<Product> prods = metier.listProducts();
		for (Product p : prods) {
			System.out.println(p.getTitle());
		}
		System.out.println("******************************");
		List<Product> prods1 = metier.productsByKeyWord("A");
		for (Product p : prods1) {
			System.out.println(p.getTitle());
		}
		System.out.println("******************************");
		try {
			Product prods2 = metier.getProduct("dd");
			System.out.println(prods2.getTitle());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("******************************");
		Product prods3 = metier.getProduct("REF001");
		System.out.println(prods3.getTitle() +"  "+ prods3.getPrice());
		prods3.setPrice(50);
		metier.updateProduct(prods3);
		Product prods4 = metier.getProduct("REF001");
		System.out.println(prods4.getTitle() +"  "+ prods4.getPrice());
		
		System.out.println("**************DELETE TEST****************");
		try {
			Product prods5 = metier.getProduct("REF002");
			
			System.out.println(prods5.getTitle() +"  "+ prods5.getPrice());
			metier.deleteProduct("REF002");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
