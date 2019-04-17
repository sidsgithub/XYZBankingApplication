package com.cg.BankingApplicationXYZ.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.BankingApplicationXYZ.model.Transaction;

public interface XyzDaoTransI extends JpaRepository<Transaction,Integer>{
	

}
