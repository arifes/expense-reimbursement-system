package com.expense.expensereimbursement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.expensereimbursement.dao.UserDao;
import com.expense.expensereimbursement.entity.UserEntity;
import com.expense.expensereimbursement.exception.ApplicationException;
import com.expense.expensereimbursement.pojo.UserPojo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public List<UserPojo> getUsers() {
		List<UserEntity> allUsersEntity = userDao.findAll();
		List<UserPojo> allUsersPojo = new ArrayList<UserPojo>();
		for(UserEntity fetchedUserEntity: allUsersEntity) {
		UserPojo returnUserPojo = new UserPojo(fetchedUserEntity.getUserId(), fetchedUserEntity.getUserFirstName(), fetchedUserEntity.getUserLastName(),fetchedUserEntity.getUserEmail(), fetchedUserEntity.getUserPassword(),fetchedUserEntity.getUserRole());
								allUsersPojo.add(returnUserPojo);
		}
		return allUsersPojo;
	}


	@Override
	public UserPojo editUser(UserPojo userPojo, int userId) {
				// copy the pojo into an entity object
				UserEntity userEntity = new UserEntity();
				BeanUtils.copyProperties(userPojo, userEntity);
				
				// now pass the bookEntity object to spring data jpa to be updated into the table
				UserEntity returnedUserEntity = userDao.save(userEntity);
				
				return userPojo;
	}


	@Override
	public UserPojo getUser(String userEmail, String userPswd) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}
	@Autowired
	 UserDao newUser;
	
	public UserEntity saveUser (UserEntity userEntity) {
		
		return newUser.save(userEntity);
		
	}
	public UserEntity fetchUserByEmailAndPassword(String userEmail, String userPassword) throws ApplicationException {
		return newUser.findByUserEmailAndPasssword(userEmail,userPassword);
		
		
	}

}
