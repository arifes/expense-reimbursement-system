package com.expense.expensereimbursement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expense.expensereimbursement.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {

}
