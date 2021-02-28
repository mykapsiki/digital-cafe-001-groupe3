package org.kapsiki.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<CustomerModele> listClients = customersDAO.listAllCustomers();
            request.setAttribute("listClients", listClients);
            this.getServletContext().getRequestDispatcher("/ListCustomers.jsp").forward(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}
