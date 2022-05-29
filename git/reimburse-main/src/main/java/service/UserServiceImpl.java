package service;

import java.sql.SQLException;

import dao.UserDao;
import dao.UserDaoImpl;
import pojo.UserPojo;

public class UserServiceImpl implements UserService {
	
	UserDao userDao;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public UserPojo loginUser(UserPojo userPojo) throws SQLException {
		// TODO Auto-generated method stub
		return userDao.loginUser(userPojo);
	}

}
