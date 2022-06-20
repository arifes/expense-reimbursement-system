package com.expense.expensereimbursement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.expense.expensereimbursement.dao.RequestDao;
import com.expense.expensereimbursement.entity.RequestEntity;
import com.expense.expensereimbursement.exception.ApplicationException;
import com.expense.expensereimbursement.pojo.RequestPojo;
import com.expense.expensereimbursement.service.RequestServiceImpl;

@ExtendWith(MockitoExtension.class)
public class RequestServiceTest {
	
	@Mock
	RequestDao requestDao;
	
	@InjectMocks
	RequestServiceImpl requestService;
	
	private RequestPojo expectedRequestPojo;
	private RequestEntity dummyRequestEntity;
	
	@BeforeEach
	public void setup() {
		expectedRequestPojo = new RequestPojo(1,2, 300.0,"supplies","pending","");
		dummyRequestEntity = new RequestEntity(1,2, 300.0,"supplies","pending","");
		
	}
		
		@DisplayName("JUnit test for getAllRequests method")
		@Test
		public void testGetAllRequests() throws ApplicationException{
			when(requestDao.findAll()).thenReturn(List.of(dummyRequestEntity, dummyRequestEntity));
			
			List<RequestPojo> actualAllRequestsPojoList = requestService.getAllRequests();
			assertNotNull(actualAllRequestsPojoList);
			assertEquals(2, actualAllRequestsPojoList.size());
			}
		
		@DisplayName("JUnit test for getARequest method")
	    @Test
	    public void testGetARequest() throws ApplicationException{
	    	when(requestDao.findById(1)).thenReturn(Optional.of(dummyRequestEntity));
	    	RequestPojo actualRequestPojo = requestService.getARequest(1);
	    	assertEquals(expectedRequestPojo, actualRequestPojo);
	    }
	    
		 @DisplayName("JUnit test for update request method")
		    @Test
		    public void testUpdateRequest() throws ApplicationException{
		       when(requestDao.save(dummyRequestEntity)).thenReturn(dummyRequestEntity);

		       RequestPojo sendRequestPojo = new RequestPojo(1,2, 300.0,"supplies","pending","");
		       RequestPojo actualRequestPojo = requestService.updateRequest(sendRequestPojo);

		       assertEquals(expectedRequestPojo, actualRequestPojo);
		    }

	

}
