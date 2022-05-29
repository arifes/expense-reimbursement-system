package service;

import java.sql.SQLException;

import pojo.UserPojo;

public interface UserService {
	
	UserPojo loginUser (UserPojo userPojo)throws SQLException;

}
