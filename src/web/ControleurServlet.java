package web;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.ParseInfo;

import metier.IProductMetier;
import metier.Product;
import metier.ProductMetierImpl;

public class ControleurServlet extends HttpServlet {

	private IProductMetier metier;

	@Override
	public void init() throws ServletException {
		metier = new ProductMetierImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ProductModel mProduct = new ProductModel();
		
		
		String action = req.getParameter("action");
		if(action != null) {
			
			if(action.equals("search")) {
				
				mProduct.setKword(req.getParameter("kword"));
				List<Product> products = metier.productsByKeyWord(mProduct.getKword());
				mProduct.setProducts(products);
				
			}
			else if (action.equals("save")) {
				
				Product p = new Product();
				p.setReference(req.getParameter("reference"));
				p.setTitle(req.getParameter("title"));
				p.setPrice(Double.parseDouble(req.getParameter("price")));
				p.setQuantity(Integer.parseInt(req.getParameter("quantity")));
				IProductMetier product = new ProductMetierImpl();
				product.addProduct(p);
				
				List<Product> products = metier.listProducts();
				mProduct.setProducts(products);
				
			}
			else if (action.equals("delete")) {
				
				String ref = req.getParameter("reference");
				IProductMetier p = new ProductMetierImpl();
				p.deleteProduct(ref);
				mProduct.setProducts(p.listProducts());
			}
			else if (action.equals("edit")) {
				
				
			}
		}
		req.setAttribute("modelProduct", mProduct);
		
		req.getRequestDispatcher("viewProduct.jsp").forward(req, resp);
	}

	
	
} 
   