package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductMetierImpl implements IProductMetier {

	@Override
	public void addProduct(Product p) {
		Connection con = SingletonConnexion.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement
					("insert into product values (?,?,?,?)");
			ps.setString(1, p.getReference());
			ps.setString(2, p.getTitle());
			ps.setDouble(3, p.getPrice());
			ps.setInt(4, p.getQuantity());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public List<Product> listProducts() {
		List<Product> products = new ArrayList<Product>();
		Connection con = SingletonConnexion.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement
					("SELECT * FROM product");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				Product p = new Product();
				p.setPrice(rs.getDouble("price"));
				p.setReference(rs.getString("reference"));
				p.setQuantity(rs.getInt("quantity"));
				p.setTitle(rs.getString("title"));
				
				products.add(p);
			}
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public List<Product> productsByKeyWord(String kword) {
		List<Product> products = new ArrayList<Product>();
		Connection con = SingletonConnexion.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement
					("SELECT * FROM product where title like ?");
			ps.setString(1, "%"+kword+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				Product p = new Product();
				p.setPrice(rs.getDouble("price"));
				p.setReference(rs.getString("reference"));
				p.setQuantity(rs.getInt("quantity"));
				p.setTitle(rs.getString("title"));
				
				products.add(p);
			}
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public Product getProduct(String ref) {
		Connection con = SingletonConnexion.getConnection();
		Product p = null;
		try {
			PreparedStatement ps = con.prepareStatement
					("SELECT * FROM product where reference = ?");
			ps.setString(1, ref);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				p = new Product();
				p.setPrice(rs.getDouble("price"));
				p.setReference(rs.getString("reference"));
				p.setQuantity(rs.getInt("quantity"));
				p.setTitle(rs.getString("title"));
				
			}
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (p==null) throw new RuntimeException("We don't have a product with this reference");
		return p;
	}

	@Override
	public void updateProduct(Product p) {
		Connection con = SingletonConnexion.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement
					("UPDATE product set title=?, price=?, quantity=? where reference= ?");
			
			ps.setString(1, p.getTitle());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getQuantity());
			ps.setString(4 , p.getReference());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteProduct(String ref) {
		Connection con = SingletonConnexion.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement
					("delete from product where reference=?");

			ps.setString(1 , ref);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
