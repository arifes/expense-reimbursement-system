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
import com.expense.expensereimbursement.pojo.RequestPojo;
import com.expense.expensereimbursement.service.RequestService;


@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200" )
public class RequestsController {
	
	@Autowired
	RequestService requestService;
	
	
	@GetMapping("requests")
	public List<RequestPojo> getAllRequests() throws ApplicationException {
		return requestService.getAllRequests();
	}
	
	@GetMapping("requests/{userId}")
	public List<RequestPojo> getRequestsByEmployee(@PathVariable("userId")int userId) throws ApplicationException {
		return requestService.getRequestsByEmployee(userId);
	}
	@GetMapping("requests/request_status/{status}")
	public List<RequestPojo> getRequestsByStatus(@PathVariable("status")String status) throws ApplicationException{
		return requestService.getRequestsByStatus(status);
		
	}

	@PatchMapping("requests/{requestId}/{status}")
	public RequestPojo updateRequest(@PathVariable("requestId")int requestId, @PathVariable("status")String status) throws ApplicationException{
		return requestService.updateRequest(requestId, status);
	}
	@GetMapping("requests/{rid}")
	public RequestPojo getARequest(@PathVariable ("rid") int requestId) throws ApplicationException {
		return requestService.getARequest(requestId);
	}
	@PutMapping("requests")
	public RequestPojo addRequest(@RequestBody RequestPojo requestPojo) throws ApplicationException {
		return requestService.addRequest(requestPojo);
	}
}
