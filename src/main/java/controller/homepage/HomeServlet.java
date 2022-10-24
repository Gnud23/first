package controller.homepage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import dao.*;


/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/homepage")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDAO productDAO; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	productDAO = new ProductDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
//		if(session.getAttribute("errorProduct") == null) {
//			session.setAttribute("errorProduct", "");
//		}
		//session.setAttribute("errorProduct", "");
        String name = (String) session.getAttribute("user");
        if(name != null) {
        	try {
    			ArrayList<Product> lstProduct = productDAO.getAllProduct();
    			
    			request.setAttribute("data", lstProduct);
    			request.getRequestDispatcher("homepage.jsp").forward(request, response);
    			
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
        else {
        	RequestDispatcher rd = request.getRequestDispatcher("login");
    		rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String pName = request.getParameter("name-product");
		String pPrice = request.getParameter("price-product");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("errorProduct", "");
		
		if(pName.isEmpty() || pPrice.isEmpty()) {
			System.out.println("Empty");
			session.setAttribute("errorProduct", "<div class=\"alert alert-danger\" role=\"alert\">\r\n"
					+ "			Please enter name and price of product\r\n"
					+ "			</div>");
			
			response.sendRedirect("homepage");
		}
		else {
			session.setAttribute("errorProduct", "");
			Product product = new Product(0, pName, pPrice);
			
			try {
	            if (productDAO.addProduct(product)) {
	            	response.sendRedirect("homepage");
	            } else {
	            	response.sendRedirect("loginfail.html");
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            response.getWriter().write("Error");
	        }
		}
	}

}
