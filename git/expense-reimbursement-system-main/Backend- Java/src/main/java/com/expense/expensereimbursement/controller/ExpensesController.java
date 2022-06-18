package com.expense.expensereimbursement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expense.expensereimbursement.exception.ApplicationException;
import com.expense.expensereimbursement.pojo.RequestPojo;
import com.expense.expensereimbursement.pojo.UserPojo;
import com.expense.expensereimbursement.service.RequestService;
import com.expense.expensereimbursement.service.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class ExpensesController {

	@Autowired
	RequestService requestService;

	@Autowired
	UserService userService;

	public List<UserPojo> userPojo = createList();

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "expensereimbursement/json")
	public List<UserPojo> firstPage() {
		return userPojo;
	}

	public List<UserPojo> createList() {
		List<UserPojo> tempUserPojo = new ArrayList<>();
		return tempUserPojo;
	}

	@PostMapping
	public UserPojo create(@RequestBody UserPojo newUserPojo) {
		userPojo.add(newUserPojo);
		System.out.println(userPojo);
		return newUserPojo;

	}

	@GetMapping("users/{uid}")
	public UserPojo getUser(@PathVariable("uid") int userId) throws ApplicationException {
		return userService.getUser(userId);

	}

	@PatchMapping("users/{userId}/{userpassword}")
	public RequestPojo editUser(@PathVariable("userId") int userId, @PathVariable("userPassword") String userPassword)
			throws ApplicationException {
		return requestService.updateRequest(userId, userPassword);
	}

	@GetMapping("users")
	public List<UserPojo> getUsers() throws ApplicationException {
		return userService.getUsers();
	}

	@GetMapping("requests")
	public List<RequestPojo> getAllRequests() throws ApplicationException {
		return requestService.getAllRequests();
	}

	@GetMapping("requests/{userId}")
	public List<RequestPojo> getRequestsByEmployee(@PathVariable("userId") int userId) throws ApplicationException {
		return requestService.getRequestsByEmployee(userId);
	}

	@GetMapping("requests/request_status/{status}")
	public List<RequestPojo> getRequestsByStatus(@PathVariable("userStatus") String status)
			throws ApplicationException {
		return requestService.getRequestsByStatus(status);

	}

	@PatchMapping("requests/{requestId}/{status}")
	public RequestPojo updateRequest(@PathVariable("requestId") int requestId,
			@PathVariable("UserStatus") String status) throws ApplicationException {
		return requestService.updateRequest(requestId, status);
	}

	@GetMapping("requests/{rid}")
	public RequestPojo getARequest(@PathVariable("rid") int requestId) throws ApplicationException {
		return requestService.getARequest(requestId);
	}

}
