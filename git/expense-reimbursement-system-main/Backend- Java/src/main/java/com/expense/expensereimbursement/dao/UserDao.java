package com.expense.expensereimbursement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expense.expensereimbursement.entity.RequestEntity;
import com.expense.expensereimbursement.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {
	List<UserEntity> findByUserEmail(String userEmail);
	List<UserEntity> findByUserId(String userPassword);
	//UserEntity findByRequestId(int requestId);
	UserEntity findByUserId(int userId);
	

}
