package metier;

import java.util.List;

public interface IProductMetier {
	
	public void addProduct (Product p);
	public List<Product> listProducts ();
	public List<Product> productsByKeyWord (String kword);
	public Product getProduct (String ref);
	public void updateProduct (Product p);
	public void deleteProduct (String ref);

}
