package com.expense.expensereimbursement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expense.expensereimbursement.exception.ApplicationException;
import com.expense.expensereimbursement.pojo.UserPojo;
import com.expense.expensereimbursement.service.RequestService;
import com.expense.expensereimbursement.service.UserService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api/")
public class UsersController {

	@Autowired
	UserService userService;
	RequestService requestService;
	
//	public List<UserPojo> userPojo = createList();

	@GetMapping("users")
	public List<UserPojo> getUsers() throws ApplicationException{
		return userService.getUsers();
	}
	
	@PostMapping("users")
	public UserPojo getUserByUserEmailAndUserPassword(@RequestBody UserPojo userPojo ) throws ApplicationException {
		return userService.getUserByUserEmailAndUserPassword(userPojo);
		
	}
	@GetMapping("users/{userId}")
	public UserPojo getUserById(@PathVariable("userId") int userId) throws ApplicationException {
		return userService.getUserById(userId);

	}
	@PostMapping("users/{userId}")
	public UserPojo updateUser(@RequestBody UserPojo userPojo) throws ApplicationException {
		return userService.updateUser(userPojo);
	}
	/*
	

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

	*/
}
