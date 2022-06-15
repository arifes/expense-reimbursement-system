package com.expense.expensereimbursement.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.expensereimbursement.dao.RequestDao;
import com.expense.expensereimbursement.entity.RequestEntity;
import com.expense.expensereimbursement.exception.ApplicationException;
import com.expense.expensereimbursement.pojo.RequestPojo;

@Service
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
		List<RequestEntity> allRequestsByEmpEntity = requestDao.findByUserId(userId);
		List<RequestPojo> allRequestsByEmpPojo = new ArrayList<RequestPojo>();
		for(RequestEntity fetchedRequestEntity : allRequestsByEmpEntity) {
			RequestPojo returnrequestPojo = new RequestPojo(fetchedRequestEntity.getRequestId(), fetchedRequestEntity.getUserId(), fetchedRequestEntity.getRequestAmount(),fetchedRequestEntity.getRequestDescription(),fetchedRequestEntity.getRequestStatus(),fetchedRequestEntity.getRequestImageURL(), fetchedRequestEntity.getRequestTime(), fetchedRequestEntity.getResolvedTime());
		     allRequestsByEmpPojo.add(returnrequestPojo);
			
		}return allRequestsByEmpPojo;
	}

	@Override
	public boolean updateRequest(int requestId, String choice, String time) throws ApplicationException {
		// copy the pojo into an entity object
		RequestEntity requestEntity = new RequestEntity();
		BeanUtils.copyProperties(requestPojo, RequestPojo);
		// now pass the requestEntity object to spring data jpa to be updated into the table
		RequestEntity returnedRequestEntity = requestDao.save(requestEntity);
		
		return requestPojo;
	}
	}

	@Override
	public RequestPojo getARequest(int requestId) throws ApplicationException {
		Optional<RequestEntity> requestEntityOpt = requestDao.findByEmployee(requestEmployee);
		RequestPojo requestPojo = null;
		if(requestEntityOpt.isPresent()) {
			// take out the entity object which is wrapped into the optional object
			RequestEntity fetchedRequestEntity = requestEntityOpt.get();
			// copy the entity into the pojo
			RequestPojo returnRequestPojo = new RequestPojo (fetchedRequestEntity.getRequestId(), fetchedRequestEntity.getUserId(), fetchedRequestEntity.getRequestAmount(),fetchedRequestEntity.getRequestDescription(),fetchedRequestEntity.getRequestStatus(),fetchedRequestEntity.getRequestImageURL(), fetchedRequestEntity.getRequestTime(), fetchedRequestEntity.getResolvedTime());
			requestPojo = new RequestPojo();
			BeanUtils.copyProperties(fetchedRequestEntity, requestPojo); // nested copying will not take place here
		}
		return requestPojo;
	}
	

}
