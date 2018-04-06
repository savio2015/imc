package Servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConFactory {

	private static String username = "root";
	private static String password = "pcdl2017";
	private static String dbUrl = "jdbc:mysql://localhost:3306/imc?useSSL=false";
	

	private Connection connection = null;
	private static ConFactory uniqueInstance = null;

	private ConFactory() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
            connection = DriverManager.getConnection(dbUrl, username, password);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ConFactory getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ConFactory();
		}
		return uniqueInstance; 
	}

	public Connection getConnection() {
		return connection;
	}
}
