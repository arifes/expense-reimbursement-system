package com.expense.expensereimbursement.exception;

public class UserNotFoundException extends Exception {

	int userId;
	
	public UserNotFoundException(int userId) {
		this.userId = userId;
	}
	
	@Override
	public String getMessage() {
		return "User with ID:" + userId +" not Found!";
	}


}
