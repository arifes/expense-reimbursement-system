package dao;

import java.sql.SQLException;

import pojo.UserPojo;

public interface UserDao {

	UserPojo loginUser (UserPojo userPojo)throws SQLException;
}
