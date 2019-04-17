package com.cg.BankingApplicationXYZ.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.BankingApplicationXYZ.dao.XyzDaoTransI;
import com.cg.BankingApplicationXYZ.dao.XyzDaoUserI;
import com.cg.BankingApplicationXYZ.model.Transaction;
import com.cg.BankingApplicationXYZ.model.User;
@Service("service")
public class XyzServiceImpl implements XyzServiceI {
	@Autowired
	private XyzDaoUserI daouser;
	@Autowired
	private XyzDaoTransI daoTrans;
	
	@Override
	public User findUserById(int uid) {
		User user = daouser.findById(uid).get();
		return user;
	}
	@Override
	public void saveUser(User user) {
		int acc = user.getAccntno();
		if(daouser.existsById(acc)) {
			daouser.flush();
		}
		daouser.save(user);
	}
	@Override
	public boolean existsById(int accntno) {
		boolean f = false;
		if(daouser.existsById(accntno))
			f = true;
		return f;
	}
	@Override
	public Transaction findTransactionById(int tid) {
		Transaction transaction = daoTrans.findById(tid).get();
		return transaction;
	}
	@Override
	public List<Transaction> findAll() {
		List<Transaction> transaction = daoTrans.findAll();
		return transaction;
	}
	@Override
	public void saveTransaction(Transaction transaction) {
		daoTrans.save(transaction);
		
	}
	@Override
	public List<Transaction> updateTransaction(List<Transaction> transactions,Transaction transaction) {
		transactions.add(transaction);
		return transactions;
	}

}
