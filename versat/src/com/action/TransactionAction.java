package com.action;

import java.util.ArrayList;
import java.util.Map;

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
	public Integer transactionType;
	public ArrayList<Transaction> transactions;
	public Integer idFund;
	public Fund fund;
	public Sysuser user;
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
		Map session = ActionContext.getContext().getSession();
		user = (Sysuser) session.get(LoginAction.SYSUSER);
		this.isSuccess = 1;
		return SUCCESS;
		/*if (oldPassword != null && newPassword != null && confirmPassword != null) {
			oldPassword.trim();
			newPassword.trim();
			confirmPassword.trim();
			if (newPassword.equals("")) {
				this.addActionError("Password can not be empty, or only space!");
				this.isSuccess = -1;
				return ERROR;
			} else if(!newPassword.equals(confirmPassword)){
				this.addActionError("Confirm password is not same as new password!");
				this.isSuccess = -1;
				return ERROR;
			}
			Sysuser changePswUser = null;
			
			try {
				changePswUser =SysuserDao.getInstance().getByUserId(user.getId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(!oldPassword.equals(changePswUser.getPassword())){
				this.addActionError("Current password is Incorrect!");
				this.isSuccess = -1;
				return ERROR;
			}else{
				changePswUser.setPassword(newPassword);
				try {
					SysuserDao.getInstance().update(changePswUser);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.isSuccess = 1;
				return SUCCESS;
			}			
		}
		this.addActionError("Password shouldn't be empty.");
		this.isSuccess = -1;
		return ERROR;*/
	}

	
	public String showDeposit() {
		return SUCCESS;
	}
	
	public String displayByTransactionType() {
		Map session = ActionContext.getContext().getSession();
		if (userId == null || transactionType == null) {
			userId = 0;
		}
		try {
			transactions = TransactionDao.getInstance().displayByOperation(userId, transactionType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	

}
