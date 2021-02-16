package org.kapsiki.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kapsiki.modele.CustomerDAO;
import org.kapsiki.modele.CustomerModele;


public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CustomerDAO customersDAO;
	
	public void init() {
		String jdbcURL = "jdbc:mysql://localhost:3306/classicmodels";
        String jdbcUsername = "root";
        String jdbcPassword = "M@neg@rrinch@11";
        
        customersDAO = new CustomerDAO(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
                listCustomers(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    private void listCustomers(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<CustomerModele> listClients = customersDAO.listAllCustomers();
        request.setAttribute("listClients", listClients);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ListCustomers.jsp");
        dispatcher.forward(request, response);
    }

}
