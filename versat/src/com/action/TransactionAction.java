package com.action;

import java.util.ArrayList;
import java.util.Map;

import com.dao.TransactionDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Sysuser;
import com.pojo.Transaction;

public class TransactionAction extends ActionSupport {
	public Integer userId;
	public ArrayList<Transaction> transactions;

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
		if (userId == null) {
			userId = 0;
		}
		try {
			transactions = TransactionDao.getInstance().getListByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String listSelf() {
		Map session = ActionContext.getContext().getSession();
		Sysuser user = (Sysuser) session.get(LoginAction.SYSUSER);
		try {
			transactions = TransactionDao.getInstance().getListByUserId(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
