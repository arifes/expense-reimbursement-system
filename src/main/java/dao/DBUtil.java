package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	// Connection is declared here because we want to use it 
		// accross methods, also make sure there is only one connection
		// to the DB at any point of time
		static Connection conn = null;
		
		// the static block makes sure that the driver is loaded only once
		// because static blocks are executed only once after the class
		// is loaded in memory 
		static {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		// this method is static so that we can call the method with 
		// the class name
		public static Connection makeConnection()throws SQLException {
			// implemented singleton pattern here
			if (conn == null) {
					conn = DriverManager.getConnection("jdbc:postgresql://expenses.cysm9qyjnsmj.us-east-2.rds.amazonaws.com/postgres", "postgres", "project2");
			}
			return conn;
		}
		
		public static void closeConnection() {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

}
