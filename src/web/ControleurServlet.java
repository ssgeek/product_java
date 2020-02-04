package web;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		req.getRequestDispatcher("viewProduct.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ProductModel mProduct = new ProductModel();
		mProduct.setKword(req.getParameter("kword"));
		List<Product> products = metier.productsByKeyWord(mProduct.getKword());
		System.out.println(products);
		mProduct.setProducts(products);
		req.setAttribute("modelProduct", mProduct.getProducts());
		req.getRequestDispatcher("viewProduct.jsp").forward(req, resp);
	}

	
	
} 
   