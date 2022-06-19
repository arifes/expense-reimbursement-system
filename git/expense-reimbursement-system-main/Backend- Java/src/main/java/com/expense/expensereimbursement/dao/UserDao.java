package com.expense.expensereimbursement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expense.expensereimbursement.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {
	List<UserEntity> findByUserRole(String userRole);
	//List<UserEntity> findById(int userId);
	//UserEntity findByRequestId(int requestId);
	UserEntity findByUserId(int userId);

}
