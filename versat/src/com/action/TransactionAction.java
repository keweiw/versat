package com.action;

import java.util.ArrayList;
import java.util.Map;

import com.dao.FundDao;
import com.dao.TransactionDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Fund;
import com.pojo.Sysuser;
import com.pojo.Transaction;

public class TransactionAction extends ActionSupport {
	public Integer userId;
	public ArrayList<Transaction> transactions;
	public Integer idFund;
	public Fund fund;

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
	
	public String showBuy() {
		if (idFund  != null) {
			try {
				this.fund = FundDao.getInstance().getById(idFund);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		return SUCCESS;
	}
	
	public String showSell() {
		if (idFund  != null) {
			try {
				this.fund = FundDao.getInstance().getById(idFund);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		return SUCCESS;
	}
	
	public String showWithdraw() {
		return SUCCESS;
	}
	
}
