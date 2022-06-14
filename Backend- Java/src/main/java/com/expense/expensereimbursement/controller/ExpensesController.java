package com.expense.expensereimbursement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expense.expensereimbursement.pojo.RequestPojo;
import com.expense.expensereimbursement.pojo.UserPojo;
import com.expense.expensereimbursement.service.RequestService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class ExpensesController {
	
	@Autowired
	RequestService requestService;
	
	@GetMapping("requests")
	public List<RequestPojo> getAllRequests(){
		return requestService.getAllRequests();
	}
	
	@GetMapping("users")
	public List<UserPojo> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("users/{rid}")
	public RequestPojo getARequest(@PathVariable ("rid") int requestId) {
		return requestService.getARequest(requestId);
	}

}
