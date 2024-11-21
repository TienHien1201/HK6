package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:sqlserver://HIEN\\SQLEXPRESS;databaseName=TEST;TrustServerCertificate=True";
		String username = "sa";
		String password = "123456789";

 	Connection conn = DriverManager.getConnection(url, username, password);
 	return conn;
		}

}
