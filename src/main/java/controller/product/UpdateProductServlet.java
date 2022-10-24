package controller.product;

import java.io.IOException;

//import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import dao.ProductDAO;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;   

    public UpdateProductServlet() {
        super();
        productDAO = new ProductDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("pid");
		
		try {
			Product product = productDAO.getProductById(pId);
			
			if(product != null) {
				request.setAttribute("pId", product.getpId());
				request.setAttribute("pName", product.getpName());
				request.setAttribute("pPrice", product.getpPrice());
				
				request.getRequestDispatcher("update.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("pid");
		String pName = request.getParameter("pname");
		String pPrice = request.getParameter("pprice");
		
		try {
			boolean index = productDAO.update(new Product(Integer.parseInt(pId),pName,pPrice));
			if(index) {
				response.sendRedirect("homepage");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
