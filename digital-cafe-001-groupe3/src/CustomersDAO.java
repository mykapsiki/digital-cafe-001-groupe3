/**
 * 
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TOUSSI
 *
 */
public class CustomersDAO {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	public CustomersDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
	 this.jdbcURL = jdbcURL;
	 this.jdbcUsername = jdbcUsername;
	 this.jdbcPassword = jdbcPassword;
	}
	
	protected void connect() throws SQLException {
        /*  chargement du driver jdbc pour mysql  */
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            /* création d'une connexion à la base de données */
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
	protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
        	/* fermeture de la connection */
        	jdbcConnection.close();
        }
    }
    
	
    public List<Customers> listAllClients() throws SQLException{
    	List<Customers> listCustomers = new ArrayList<>();
    	
    	String sql = "SELECT customerNumber, customerName, contactFirstName, contactLastName from customers";
    	
    	connect();
    	
    	Statement statement = jdbcConnection.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	
    	while (resultSet.next()) {
    		int customerNumber = resultSet.getInt("customerNumber");
    		String customerName = resultSet.getString("customerName");
    		String contactFirstName = resultSet.getString("contactFirstName");
    		String contactLastName = resultSet.getString("contactLastName");
    		
    		
    		
    		Customers customers = new Customers(customerNumber, customerName, contactFirstName, contactLastName);
    		listCustomers.add(customers);
    	}
    	
    	resultSet.close();
    	statement.close(); 	
    	
    	disconnect();
    	
    	return listCustomers;
    }
}
