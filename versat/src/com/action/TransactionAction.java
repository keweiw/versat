package com.action;

import java.util.ArrayList;
import java.util.Map;

import com.bu.TransitionDay;
import com.dao.FundDao;
import com.dao.SysuserDao;
import com.dao.TransactionDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Fund;
import com.pojo.Sysuser;
import com.pojo.Transaction;

public class TransactionAction extends ActionSupport {
	public Integer userId;
	public Integer transactionType=-1;
	public ArrayList<Transaction> transactions;
	public Integer idFund;
	public Fund fund;
	public Sysuser user;
	public double amount;
	private int isSuccess;
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String list() {
		userId=this.getUserId();
		
		if (userId == null || transactionType==null) {
			userId = 0;
		}
		try {
			if(transactionType==-1){
				transactions = TransactionDao.getInstance().getListByUserId(userId);
				
			}else {
				System.out.println(userId);
				
				transactions = TransactionDao.getInstance().displayByOperation(userId, transactionType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String listSelf() {
		Map session = ActionContext.getContext().getSession();
		Sysuser user = (Sysuser) session.get(LoginAction.SYSUSER);
		try {
			if(transactionType==-1){
				transactions = TransactionDao.getInstance().getListByUserId(user.getId());
			}else {
				transactions = TransactionDao.getInstance().displayByOperation(user.getId(), transactionType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	public String showDeposit() {
		
		Map session = ActionContext.getContext().getSession();
		try {
			if(userId == null){
				userId = 0;
			} else {
				Sysuser user = SysuserDao.getInstance().getByUserId(userId);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
		
	}
	
	public String showWithdraw() {
		Map session = ActionContext.getContext().getSession();
		Sysuser user = (Sysuser) session.get(LoginAction.SYSUSER);
		return SUCCESS;
		
	}
	
	public String withdraw(){
		Map session = ActionContext.getContext().getSession();
		Sysuser user = (Sysuser) session.get(LoginAction.SYSUSER);
		Transaction t = new Transaction();
		
		long a = (long) (amount*100);
		t.setAmount(a);
		t.setStatus(Transaction.TRANS_STATUS_PENDING);
		t.setTransactionType(Transaction.TRANS_TYPE_WITHDRAW);	
		TransitionDay.getInstance().newTransaction(user.getId(),t);
		
		return SUCCESS;
		
	}
	
	public String deposit(){
		Map session = ActionContext.getContext().getSession();
		try {
			if(userId == null){
				userId = 0;
			} else {
				Sysuser user = SysuserDao.getInstance().getByUserId(userId);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		Transaction t = new Transaction();
		
		long a = (long) (amount*100);
		t.setAmount(a);
		t.setStatus(Transaction.TRANS_STATUS_PENDING);
		t.setTransactionType(Transaction.TRANS_TYPE_DEPOSIT);	
		TransitionDay.getInstance().newTransaction(user.getId(),t);
		
		return SUCCESS;
	}
		
}
	

