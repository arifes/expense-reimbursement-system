package com.expense.expensereimbursement.service;

import java.util.List;

import com.expense.expensereimbursement.exception.ApplicationException;
import com.expense.expensereimbursement.pojo.RequestPojo;

public interface RequestService {

	List<RequestPojo> getAllRequests() throws ApplicationException;
	
	RequestPojo addRequest(RequestPojo requestPojo) throws ApplicationException;
	
	List<RequestPojo> getRequestsByEmployee(int userId) throws ApplicationException;
	
	RequestPojo updateRequest(RequestPojo requestPojo) throws ApplicationException;
	
	RequestPojo getARequest(int requestId) throws ApplicationException;
	
	List<RequestPojo> getRequestsByStatus (String status) throws ApplicationException;

}
