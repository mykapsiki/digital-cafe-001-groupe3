/**
 * 
 */


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author TOUSSI
 *
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomersDAO customersDAO;
	
	public void init() {
		String jdbcURL = "jdbc:mysql://localhost:3306/classicmodels";
        String jdbcUsername = "root";
        String jdbcPassword = "M@neg@rrinch@11";
        
        customersDAO = new CustomersDAO(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
                listCustomers(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    private void listCustomers(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Customers> listClients = customersDAO.listAllClients();
        request.setAttribute("listClients", listClients);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ListCustomers.jsp");
        dispatcher.forward(request, response);
    }
}
