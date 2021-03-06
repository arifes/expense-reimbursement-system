package com.expense.expensereimbursement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expense.expensereimbursement.entity.RequestEntity;

@Repository
public interface RequestDao extends JpaRepository <RequestEntity, Integer> {
	
	List<RequestEntity> findByUserId(int userId);
	
	List<RequestEntity> findByRequestStatus(String status);
	
//	RequestEntity findByRequestId(int requestId);
	
	Optional<RequestEntity> findByRequestId( int requestId);

}
