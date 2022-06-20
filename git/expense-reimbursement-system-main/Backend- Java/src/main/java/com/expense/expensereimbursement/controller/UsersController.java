package com.expense.expensereimbursement.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
*/
	@GetMapping("users/{userId}")
	public UserPojo getUserById(@PathVariable("userId") int userId) throws ApplicationException {
		return userService.getUserById(userId);

	}

	@PutMapping("users")
	public UserPojo updateUser(@RequestBody UserPojo userPojo)
			throws ApplicationException {
		return userService.UpdateUser(userPojo);
	}
	
}
