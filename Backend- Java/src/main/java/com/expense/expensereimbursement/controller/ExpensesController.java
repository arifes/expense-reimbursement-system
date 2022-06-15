package com.expense.expensereimbursement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.expensereimbursement.exception.ApplicationException;
import com.expense.expensereimbursement.pojo.RequestPojo;
import com.expense.expensereimbursement.pojo.UserPojo;
import com.expense.expensereimbursement.service.RequestService;
import com.expense.expensereimbursement.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class ExpensesController {
	
	@Autowired
	RequestService requestService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("requests")
	public List<RequestPojo> getAllRequests() throws ApplicationException {
		return requestService.getAllRequests();
	}
	
	@GetMapping("users")
	public List<UserPojo> getUsers() throws ApplicationException{
		return userService.getUsers();
	}
	
	@GetMapping("requests/{rid}")
	public RequestPojo getARequest(@PathVariable ("rid") int requestId) throws ApplicationException {
		return requestService.getARequest(requestId);
	}

}
