package com.expense.expensereimbursement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.expensereimbursement.dao.UserDao;
import com.expense.expensereimbursement.entity.RequestEntity;
import com.expense.expensereimbursement.entity.UserEntity;
import com.expense.expensereimbursement.exception.ApplicationException;
import com.expense.expensereimbursement.pojo.RequestPojo;
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
	public UserPojo editUser(int userId, String userPassword)throws ApplicationException {
				// copy the pojo into an entity object
				//UserEntity userEntity = new UserEntity();
				//BeanUtils.copyProperties(userPojo, userEntity);
				
				// now pass the bookEntity object to spring data jpa to be updated into the table
				//UserEntity returnedUserEntity = userDao.save(userEntity);
		UserEntity userEntity = userDao.findByUserId(userId);
		userEntity.setUserPassword(userPassword);
		userEntity= userDao.save(userEntity);
		UserPojo userPojo=null;
				
				return userPojo;
	}


	@Override
	public UserPojo getUser(int userId) throws ApplicationException {
		Optional<UserEntity> userEntityOpt = userDao.findById(userId);
		UserPojo userPojo = null;
		if(userEntityOpt.isPresent()) {
			UserEntity fetchUserEntity =userEntityOpt.get();
			userPojo = new UserPojo();
			BeanUtils.copyProperties(fetchUserEntity,userPojo);
			
		}
	
		return userPojo;
	}

}
