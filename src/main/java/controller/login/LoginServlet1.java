package controller.login;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

import model.LoginBean;
import dao.LoginDAO;

/**
 * Servlet implementation class LoginServlet1
 */
@WebServlet("/login")
public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO loginDao;

    public void init() {
        loginDao = new LoginDAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	session.setAttribute("messError", "");
    	
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null) {
    		for(Cookie o : cookies) {
        		if(o.getName().equals("usernameC")) {	
        			request.setAttribute("username", o.getValue());
        			System.out.println(o.getValue());
        		}
        		if(o.getName().equals("passwordC")) {
        			request.setAttribute("password", o.getValue());
        		}
        	}
    		if(request.getAttribute("username") == null) {
    			request.setAttribute("username", "");
            	request.setAttribute("password", "");
    		}
    	}
    	
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //String isSaveUsPs = request.getParameter("checksave");
        
        System.out.println("is check: "+request.getParameter("checksave"));
        
        if(username.isEmpty() || password.isEmpty()) {
        	session = request.getSession();
        	
        	request.setAttribute("username", "");
        	request.setAttribute("password", "");
        	
            session.setAttribute("messError", "<div class=\"alert alert-danger\" role=\"alert\">\r\n"
            		+ "  Please enter both username and password!!!\r\n"
            		+ "</div>");
            
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    		rd.forward(request, response);  		
        }
        else {
        	session.setAttribute("messError", "");
			session.setAttribute("errorProduct", "");
        	
        	LoginBean loginBean = new LoginBean();
            loginBean.setUsername(username);
            loginBean.setPassword(password);
             
            try {
                if (loginDao.validate(loginBean)) {
                	//save username and password into cookie if checkbox is check
                	if(request.getParameter("checksave") != null) {
                    	Cookie cookieUsername = new Cookie("usernameC", username);
                        Cookie cookiePassword = new Cookie("passwordC", password);
                        
                        cookieUsername.setMaxAge(60*60*24);
                        cookiePassword.setMaxAge(60*60*24);
                        
                        response.addCookie(cookieUsername);
                        response.addCookie(cookiePassword);
                    }
                	
                    response.sendRedirect("homepage"); 
                } else {
                	response.sendRedirect("loginfail.html");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                response.getWriter().write("Error");
            }
            
            String name = request.getParameter("username");
            session.setAttribute("user", name);
        }  
    }

}
