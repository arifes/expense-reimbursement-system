package com.expense.expensereimbursement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.expense.expensereimbursement.dao.RequestDao;
import com.expense.expensereimbursement.entity.RequestEntity;
import com.expense.expensereimbursement.exception.ApplicationException;
import com.expense.expensereimbursement.pojo.RequestPojo;


public class RequestServiceImpl implements RequestService {
	
	@Autowired
	RequestDao requestDao;

	@Override
	public List<RequestPojo> getAllRequests() throws ApplicationException {
		List<RequestEntity> allRequestsEntity = requestDao.findAll();
		List<RequestPojo> allRequestsPojo = new ArrayList<RequestPojo>();
		for(RequestEntity fetchedRequestEntity: allRequestsEntity) {
		RequestPojo returnRequestPojo = new RequestPojo (fetchedRequestEntity.getRequestId(), fetchedRequestEntity.getUserId(), fetchedRequestEntity.getRequestAmount(),fetchedRequestEntity.getRequestDescription(),fetchedRequestEntity.getRequestStatus(),fetchedRequestEntity.getRequestImageURL(), fetchedRequestEntity.getRequestTime(), fetchedRequestEntity.getResolvedTime());
		  allRequestsPojo.add(returnRequestPojo);
	}return allRequestsPojo;
	}
	@Override
	public RequestPojo addRequest(RequestPojo requestPojo) throws ApplicationException {
		RequestEntity requestEntity = new RequestEntity();
		BeanUtils.copyProperties(requestPojo, requestEntity);
		RequestEntity returnedRequestEntity = requestDao.saveAndFlush(requestEntity);
		requestPojo.setRequestId(returnedRequestEntity.getRequestId());
		return requestPojo;
	}

	@Override
	public List<RequestPojo> getRequestsByEmployee(int userId) throws ApplicationException {
		Optional<RequestEntity> requestEntityOpt = requestDao.findById(userId);
		RequestPojo requestPojo = null;
		if(requestEntityOpt.isPresent()) {
			RequestEntity fetchedRequestEntity = requestEntityOpt.get();
			requestPojo = new RequestPojo(fetchedRequestEntity.getRequestId(), fetchedRequestEntity.getUserId(), fetchedRequestEntity.getRequestAmount(),fetchedRequestEntity.getRequestDescription(),fetchedRequestEntity.getRequestStatus(),fetchedRequestEntity.getRequestImageURL(), fetchedRequestEntity.getRequestTime(), fetchedRequestEntity.getResolvedTime());
		}
			
		return requestPojo;
	}

	@Override
	public boolean updateRequest(int requestId, String choice, String time) throws ApplicationException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RequestPojo getARequest(int requestId) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
