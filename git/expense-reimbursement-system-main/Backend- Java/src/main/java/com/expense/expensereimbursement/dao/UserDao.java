package com.expense.expensereimbursement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expense.expensereimbursement.entity.UserEntity;
import com.expense.expensereimbursement.exception.ApplicationException;
import com.expense.expensereimbursement.pojo.UserPojo;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {
	List<UserPojo> getUsers() throws ApplicationException;

	UserEntity getUser(String userEmail, String userPassword) throws ApplicationException;

	//public UserEntity findByUser (int userId);
	public UserEntity editUser(UserEntity userEntity, int userId) throws ApplicationException;

	public UserEntity findByUserEmailAndPasssword(String userEmail, String userPassword) throws ApplicationException ;

}
