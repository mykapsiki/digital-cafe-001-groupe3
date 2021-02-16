import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAO implements CustomerDaoInterface{
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	
	public CustomerDAO(String jdbcURL, String jdbcUsername, String jdbcPassword, Connection jdbcConnection) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
		this.jdbcConnection = jdbcConnection;
	}
	
	@Override
	public void connect() throws SQLException {
		// TODO Auto-generated method stub
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



	@Override
	public void disconnect() throws SQLException {
		// TODO Auto-generated method stub
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
        	/* fermeture de la connection */
        	jdbcConnection.close();
        }
		
	}

	
	public List<CustomerModele> listAllCustomers() throws SQLException{
		List<CustomerModele> listCustomers = new ArrayList<>();
    	
    	String sql = "SELECT customerNumber, customerName, contactFirstName, contactLastName from customers";
    	
    	connect();
    	
    	Statement statement = jdbcConnection.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	
    	while (resultSet.next()) {
    		int customerNumber = resultSet.getInt("customerNumber");
    		String customerName = resultSet.getString("customerName");
    		String contactFirstName = resultSet.getString("contactFirstName");
    		String contactLastName = resultSet.getString("contactLastName");
    		
    		
    		
    		CustomerModele customers = new CustomerModele(customerNumber, customerName, contactFirstName, contactLastName);
    		listCustomers.add(customers);
    	}
    	
    	resultSet.close();
    	statement.close(); 	
    	
    	disconnect();
    	
    	return listCustomers;

	}
	
}