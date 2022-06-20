package com.expense.expensereimbursement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.expense.expensereimbursement.dao.UserDao;
import com.expense.expensereimbursement.entity.UserEntity;
import com.expense.expensereimbursement.exception.ApplicationException;
import com.expense.expensereimbursement.pojo.UserPojo;
import com.expense.expensereimbursement.service.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserserviceTest {
	
	@Mock
	UserDao userDao;
	
	@InjectMocks
	UserServiceImpl userService;
	
	private UserPojo expectedUserPojo;
	private UserEntity dummyUserEntity;
	
	@BeforeEach
	public void setup() {
		expectedUserPojo = new UserPojo(1,"john","smith","johnsmith@gmail.com","pass1234","manager");
		dummyUserEntity = new UserEntity(1,"john","smith","johnsmith@gmail.com","pass1234","manager");
		
	}
	
	@DisplayName("JUnit test for getAllUsers method")
    @Test
    public void testGetUsers() throws ApplicationException{
        when(userDao.findAll()).thenReturn(List.of(dummyUserEntity, dummyUserEntity));
   
        List<UserPojo> actualAllUserPojoList = userService.getUsers();

        assertNotNull(actualAllUserPojoList);
        assertEquals(2, actualAllUserPojoList.size());
    }

	@DisplayName("JUnit test for update user method")
    @Test
    public void testUpdateUser() throws ApplicationException{
       when(userDao.save(dummyUserEntity)).thenReturn(dummyUserEntity);

       UserPojo sendUserPojo = new UserPojo(1,"john","smith","johnsmith@gmail.com","pass1234","manager");
       UserPojo actualUserPojo = userService.updateUser(sendUserPojo);

       assertEquals(expectedUserPojo, actualUserPojo);
    }
}
