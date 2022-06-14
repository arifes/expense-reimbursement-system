package com.expense.expensereimbursement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expense.expensereimbursement.entity.RequestEntity;

@Repository
public interface RequestDao extends JpaRepository <RequestEntity, Integer> {

}
