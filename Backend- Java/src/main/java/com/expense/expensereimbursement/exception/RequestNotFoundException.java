package com.expense.expensereimbursement.exception;

public class RequestNotFoundException extends Exception {
	
	int requestId;
	
	public RequestNotFoundException(int requestId) {
		this.requestId = requestId;
	}
	
	@Override
	public String getMessage() {
		return "Request with ID:" + requestId +" not Found!";
	}

}
