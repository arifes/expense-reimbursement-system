package com.expense.expensereimbursement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public UserPojo getUserByUserEmailAndUserPassword(UserPojo userPojo) throws ApplicationException {
		UserEntity returnedUserEntity = new UserEntity();
		BeanUtils.copyProperties(userPojo, returnedUserEntity);
		String email = returnedUserEntity.getUserEmail();
		String password = returnedUserEntity.getUserPassword();
	
		UserEntity fetchedUserEntity = userDao.findByUserEmailAndUserPassword(email, password);
		UserPojo newUserPojo = null;		
			// copy the entity into the pojo
			//bookPojo = new BookPojo(fetchedBookEntity.getId(), fetchedBookEntity.getBookTitle(), fetchedBookEntity.getBookGenre(), fetchedBookEntity.getBookAuthor(),fetchedBookEntity.getBookCost(), fetchedBookEntity.getBookImage());
			newUserPojo = new UserPojo();
			BeanUtils.copyProperties(fetchedUserEntity, newUserPojo); // nested copying will not take place here
		
		//LOG.info("Exited getABook() in service...");
		return newUserPojo;
	}
	
	@Override
	public UserPojo getUserById(int userId) throws ApplicationException {
		Optional<UserEntity> userEntityOpt = Optional.of(userDao.findByUserId(userId));
		UserPojo userPojo = null;
		if (userEntityOpt.isPresent()) {
			UserEntity fetchedUserEntity = userEntityOpt.get();
			userPojo = new UserPojo();
			BeanUtils.copyProperties(fetchedUserEntity, userPojo);
		}

		return userPojo;
	}



	
	
	@Override
	public UserPojo updateUser(UserPojo userPojo) throws ApplicationException {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userPojo, userEntity);
		UserEntity returnedUserEntity = userDao.save(userEntity);

		return userPojo;
	}



	@Override
	public UserPojo editUser(UserPojo userPojo, int userId) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}


	

}
