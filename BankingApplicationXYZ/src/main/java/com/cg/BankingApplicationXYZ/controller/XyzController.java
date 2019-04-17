package com.cg.BankingApplicationXYZ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cg.BankingApplicationXYZ.model.Transaction;
import com.cg.BankingApplicationXYZ.model.User;
import com.cg.BankingApplicationXYZ.service.XyzServiceI;


@RestController

@RequestMapping("/xyzcompany")
public class XyzController {
	@Autowired
	private XyzServiceI service;
	static User user;
	
	//to login using account number and password
	@PostMapping("/login")
	public ModelAndView login(@RequestParam Integer accntno,@RequestParam String password) {
		ModelAndView modelandview = new ModelAndView("index");
		if(service.existsById(accntno)) {
			user = service.findUserById(accntno);
			String pass =user.getPassword();
			if( pass.compareTo(password) ==0){
				modelandview = new ModelAndView("options");
				modelandview.addObject("user",user);
			}	
		}
		return modelandview;
	}
	
	//to create account using User name and password
	@PostMapping("/register")
	public ModelAndView register(@RequestParam String uname,@RequestParam String password) {
		user = new User();
		int accntno = (int)(Math.random()*10000+10000000);
		
		if((boolean) service.existsById(accntno)) {
			accntno = (int)(Math.random()*10000+10000000);
		}
		if((boolean)!service.existsById(accntno)) {
			user.setAccntno(accntno);
			user.setPassword(password);
			user.setUname(uname);
			service.saveUser(user);
		}
		ModelAndView modelAndView = new ModelAndView("accnumber");
		modelAndView.addObject("user",user); 
		
		return modelAndView;
	}

	//to show balance of the user being passed..
		//the get mapping is used to pass the user object.
	@GetMapping("/showbalance/{user}")
	public ModelAndView showBalance(@PathVariable User user){
		ModelAndView modelAndView = new ModelAndView("showbalance");
		List<Transaction> transactionList = user.getTransactions();
		//showing empty page on no transaction.
		if(transactionList.isEmpty()) {
			modelAndView = new ModelAndView("showemptybalance");
			modelAndView.addObject(user);
			return modelAndView;
		}
		modelAndView.addObject(transactionList);
		modelAndView.addObject(user);
		return modelAndView;
	}
	
	//to deposit amount and show balance.
		//get mapping is used to pass the user object.
	@GetMapping("/deposit/{user}")
	public ModelAndView deposit(@PathVariable User user){
		ModelAndView modelAndView = new ModelAndView("deposit");
		modelAndView.addObject(user);
		return modelAndView;
	}
		//user is passed and and amount is updated.
	@PostMapping("/deposit")
	public ModelAndView deposit(@RequestParam float amount){
		
		int tid = (int)(Math.random()*100+1000);
		
		List<Transaction> transactions = user.getTransactions();
		Transaction transaction;
		float balance  = 0;
		
		if(transactions.isEmpty()) {
			transaction = new Transaction();
			
		}
		else 
		{
			Transaction lastTransaction = transactions.get(transactions.size()-1);
			balance = lastTransaction.getBalance();
			transaction = new Transaction();
		}
		
		balance = balance +amount;
		transaction.setTid(tid);
		transaction.setTtype("Deposit");
		transaction.setAmount((int)amount);
		transaction.setBalance(balance);
		transaction.setUser(user);
		service.saveTransaction(transaction);
		service.updateTransaction(transactions, transaction);
		
		ModelAndView modelAndView = new ModelAndView("showbalance");
		modelAndView.addObject("transactionList", transactions);
		modelAndView.addObject(user);
		return modelAndView;
	}
	
	//to withdraw amount and show balance.
			//get mapping is used to pass the user object.
		@GetMapping("/withdraw/{user}")
		public ModelAndView withdraw(@PathVariable User user){
			ModelAndView modelAndView = new ModelAndView("withdraw");
			modelAndView.addObject(user);
			return modelAndView;
		}
			//user is passed and and amount is updated.
		@PostMapping("/withdraw")
		public ModelAndView withdraw(@RequestParam float amount){
			
			int tid = (int)(Math.random()*100+1000);
			ModelAndView modelAndView = new ModelAndView("showbalance");
			
			List<Transaction> transactions = user.getTransactions();
			Transaction transaction;
			float balance  = 0;
			
			if(transactions.isEmpty()) {
				transaction = new Transaction();
				
			}
			else 
			{
				Transaction lastTransaction = transactions.get(transactions.size()-1);
				balance = lastTransaction.getBalance();
				transaction = new Transaction();
			}
			
			balance = balance-amount;
			if(balance<0) {
				boolean msg = true;
				modelAndView.addObject("msg",msg);
				modelAndView.addObject("transactionList", transactions);
				modelAndView.addObject(user);
				return modelAndView;
			}
			transaction.setTid(tid);
			transaction.setTtype("Withdraw");
			transaction.setAmount((int)amount);
			transaction.setBalance(balance);
			transaction.setUser(user);
			service.saveTransaction(transaction);
			service.updateTransaction(transactions, transaction);
			
			modelAndView.addObject("transactionList", transactions);
			modelAndView.addObject(user);
			return modelAndView;
		}
		
	//to transfer amount and show balance.
		//get mapping is used to pass the user object.
	@GetMapping("/transfer/{user}")
	public ModelAndView transfer(@PathVariable User user){
		ModelAndView modelAndView = new ModelAndView("transfer");
		modelAndView.addObject(user);
		return modelAndView;
	}
	
	//first withdraw from current user then deposit to the account number.
	@PostMapping("/transfer")
	public ModelAndView transfer(@RequestParam float amount,@RequestParam int accntno) {
		//withdraw from the current user
		int tid = (int)(Math.random()*100+1000);
		ModelAndView modelAndView = new ModelAndView("showbalance");
		List<Transaction> transactions = user.getTransactions();
		//if the account number is not present then no transaction will happen and error message is displayed with the previous transactions.
		if(!service.existsById(accntno)) {
			boolean token = true;
			modelAndView.addObject("token",token);
			modelAndView.addObject("transactionList", transactions);
			return modelAndView;
		}
		Transaction transaction;
		float balance  = 0;
		//if the transaction list of current user is empty meaning he has no balance. then new transaction is initiated else the last balance is fetched.
		if(transactions.isEmpty()) {
			transaction = new Transaction();	
		}
		else 
		{
			Transaction lastTransaction = transactions.get(transactions.size()-1);
			balance = lastTransaction.getBalance();
			transaction = new Transaction();
		}
		//now balance is withdrawn from the current user and the transaction is updated to the current transaction.
		balance = balance-amount;
		if(balance<0) {
			boolean msg = true;
			modelAndView.addObject("msg",msg);
			modelAndView.addObject("transactionList", transactions);
			modelAndView.addObject(user);
			return modelAndView;
		}
		transaction.setTid(tid);
		transaction.setTtype("FWithdrawn");
		transaction.setAmount((int)amount);
		transaction.setBalance(balance);
		transaction.setUser(user);
		service.saveTransaction(transaction);
		service.updateTransaction(transactions, transaction);
		//to store the user of the current account.
		User olduser = user;
				
		
		//DEPOSIT-PART
		
		tid = (int)(Math.random()*100+1000);
		
		//getting user from account number passed.
		user = service.findUserById(accntno);
		//transaction list is also fetched for the new user.
		transactions = user.getTransactions();
		//if the new user has no transaction yet then new transaction or else balance from the new user's last balance is fetched.
		if(transactions.isEmpty()) {
			transaction = new Transaction();
			
		}
		else 
		{
			Transaction lastTransaction = transactions.get(transactions.size()-1);
			balance = lastTransaction.getBalance();
			transaction = new Transaction();
		}
		
		balance = balance +amount;
		transaction.setTid(tid);
		transaction.setTtype("FDeposited");
		transaction.setAmount((int)amount);
		transaction.setBalance(balance);
		transaction.setUser(user);
		service.saveTransaction(transaction);
		service.updateTransaction(transactions, transaction);
		
		//now since we need to show the current users transactions 
		user = olduser;
		transactions = user.getTransactions();
		
		modelAndView.addObject("transactionList", transactions);
		modelAndView.addObject(user);
	
		return modelAndView;
	}
	
	@GetMapping("/print/{user}")
	public ModelAndView print(@PathVariable User user){
		ModelAndView modelAndView = new ModelAndView("print");
		List<Transaction> transactionList = user.getTransactions();
		//showing empty page on no transaction.
		if(transactionList.isEmpty()) {
			modelAndView = new ModelAndView("showemptybalance");
			modelAndView.addObject(user);
			return modelAndView;
		}
		modelAndView.addObject(transactionList);
		modelAndView.addObject(user);
		return modelAndView;
	}
	
	
	
	

}
