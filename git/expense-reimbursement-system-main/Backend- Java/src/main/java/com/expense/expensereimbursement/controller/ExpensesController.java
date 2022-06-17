package com.expense.expensereimbursement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.expensereimbursement.entity.UserEntity;
import com.expense.expensereimbursement.exception.ApplicationException;
import com.expense.expensereimbursement.pojo.RequestPojo;
import com.expense.expensereimbursement.pojo.UserPojo;
import com.expense.expensereimbursement.service.RequestService;
import com.expense.expensereimbursement.service.UserService;
import com.expense.expensereimbursement.service.UserServiceImpl;

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
	
	
	@GetMapping("requests/{userId}")
	public List<RequestPojo> getRequestsByEmployee(@PathVariable("userId")int userId) throws ApplicationException {
		return requestService.getRequestsByEmployee(userId);
	}
	@GetMapping("requests/request_status/{status}")
	public List<RequestPojo> getRequestsByStatus(@PathVariable("status")String status) throws ApplicationException{
		return requestService.getRequestsByStatus(status);
		
	}
	@Autowired
	private UserService service;
	@PostMapping("/users/userregistration ")
	public UserEntity registerUser (@RequestBody UserEntity userEntity) throws Exception {
		
	
		String tempUserEmail= userEntity.getUserEmail();
		String tempUserPasssword=userEntity.getUserPassword();
		if (tempUserEmail!= null && !"".equals(tempUserEmail)) {
			UserEntity newUserEntity = service.fetchUserByEmailAndPassword(tempUserEmail, tempUserPasssword);
			if (newUserEntity!= null) {
				throw new Exception ("user with "+tempUserEmail+"  already exist!!");
			}
		}	
		UserEntity newUserEntity = null;
		service.saveUser(userEntity);
		return newUserEntity;
		
	}
/*	
	@GetMapping("requests/{rid}")
	public RequestPojo getARequest(@PathVariable ("rid") int requestId) throws ApplicationException {
		return requestService.getARequest(requestId);
	}
*/
}
