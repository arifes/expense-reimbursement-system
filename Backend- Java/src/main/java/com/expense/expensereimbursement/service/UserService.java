package com.expense.expensereimbursement.service;

import java.util.List;

import com.expense.expensereimbursement.exception.ApplicationException;
import com.expense.expensereimbursement.pojo.UserPojo;

public interface UserService {

	List<UserPojo> getUsers() throws ApplicationException;
	
	UserPojo getUserByUserEmailAndUserPassword(UserPojo userPojo) throws ApplicationException;
	
	public UserPojo editUser(UserPojo userPojo, int userId) throws ApplicationException;
	
	UserPojo getUserById(int userId) throws ApplicationException;
	
	public UserPojo UpdateUser(UserPojo userPojo, int userId) throws ApplicationException;

	}


