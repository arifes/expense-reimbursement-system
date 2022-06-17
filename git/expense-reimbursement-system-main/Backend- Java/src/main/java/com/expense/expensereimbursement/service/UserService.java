package com.expense.expensereimbursement.service;

import java.util.List;

import com.expense.expensereimbursement.exception.ApplicationException;
import com.expense.expensereimbursement.pojo.UserPojo;

public interface UserService {

	List<UserPojo> getUsers() throws ApplicationException;
	
	UserPojo getUser(String userEmail, String userPswd) throws ApplicationException;
	
	public UserPojo editUser(UserPojo userPojo, int userId) throws ApplicationException;
	
	

}
