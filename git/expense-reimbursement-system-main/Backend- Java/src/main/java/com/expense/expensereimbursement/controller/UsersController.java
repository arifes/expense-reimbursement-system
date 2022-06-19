package com.expense.expensereimbursement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.expensereimbursement.exception.ApplicationException;
import com.expense.expensereimbursement.pojo.UserPojo;
import com.expense.expensereimbursement.service.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200" )
public class UsersController {

	@Autowired
	UserService userService;
	// commentsssssss
//	public List<UserPojo> userPojo = createList();
	
	@GetMapping("users")
	public List<UserPojo> getUsers() throws ApplicationException{
		return userService.getUsers();
	}
	/*
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
	*/
}
