package dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pojo.UserPojo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class UserDaoImpl implements UserDao{
	
	private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);

	@Override
	public UserPojo loginUser(UserPojo userPojo) throws SQLException {
		logger.info("Entered validateUser() in dao");
		
		Connection conn = DBUtil.makeConnection();
		try {
			
			Statement stmt = conn.createStatement();
			String query  = "SELECT * FROM users WHERE user_email=" + userPojo.getUserId() + " and user_password='" + userPojo.getPassword();
			ResultSet resultSet = stmt.executeQuery(query);
			if(resultSet.next()){
				userPojo.setFirstName(resultSet.getString(2));
				userPojo.setLastName(resultSet.getString(3));
				userPojo.setRole(resultSet.getString(6));
			}
		}catch (SQLException e) {
			
		}
		logger.info("Exited validateUser() in dao. ");
		
		
		return userPojo;
	}
	
	

}