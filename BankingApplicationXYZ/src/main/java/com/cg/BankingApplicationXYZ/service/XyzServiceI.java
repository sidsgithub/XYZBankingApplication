package com.cg.BankingApplicationXYZ.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.cg.BankingApplicationXYZ.model.User;
import com.cg.BankingApplicationXYZ.model.Transaction;

@Service("service")
public interface XyzServiceI {
	
	public User findUserById(int uid);
	public void saveUser(User user);
	public boolean existsById(int accntno);
	
	public Transaction findTransactionById(int tid);
	public List<Transaction> findAll();
	public void saveTransaction(Transaction transaction);
	public List<Transaction> updateTransaction(List<Transaction> transactions, Transaction transaction);

}
