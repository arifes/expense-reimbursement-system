package com.expense.expensereimbursement.service;

import java.util.ArrayList;
import java.util.List;

import com.expense.expensereimbursement.entity.UserEntity;
import com.expense.expensereimbursement.pojo.UserPojo;

public class UserServiceImpl implements UserService {

	@Override
	public List<UserPojo> getUsers() {
		List<UserEntity> allUsersEntity = userDao.findAll();
		List<UserPojo> allUsersPojo = new ArrayList<UserPojo>();
		for(UserEntity fetchedUserEntity: allUsersEntity) {
		UserPojo returnBookPojo = new UserPojo(fetchedUserEntity.getUserId(), fetchedUserEntity.getUserFirstName(), fetchedUserEntity.getUserLastName(), );
		}
		return null;
	}

	@Override
	public UserPojo getUser(String userEmail, String userPswd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPojo editUser(UserPojo userPojo, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
