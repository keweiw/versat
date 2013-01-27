package com.action;

import java.util.ArrayList;
import java.util.Date;
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
	private Integer userId;
	private Integer transactionType = -1;
	private ArrayList<Transaction> transactions;
	private Integer idFund;
	private Fund fund;
	private Sysuser user;
	private Double amount;
	private int isSuccess;


	public Integer getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(Integer transactionType) {
		this.transactionType = transactionType;
	}

	public Integer getIdFund() {
		return idFund;
	}

	public void setIdFund(Integer idFund) {
		this.idFund = idFund;
	}

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public Sysuser getUser() {
		return user;
	}

	public void setUser(Sysuser user) {
		this.user = user;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}

	

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
	//	Map session = ActionContext.getContext().getSession();
	//	userId = this.getUserId();

		if (userId == null || transactionType == null) {
			userId = 0;
		}
		try {
			if (transactionType == -1) {
				transactions = TransactionDao.getInstance().getListByUserId(
						userId);

			} else {
				System.out.println(userId);

				transactions = TransactionDao.getInstance().displayByOperation(
						userId, transactionType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String listSelf() {
		Map session = ActionContext.getContext().getSession();
		Sysuser user = (Sysuser) session.get(LoginAction.SYSUSER);
		this.user = user;
		try {
			if (transactionType == -1) {
				transactions = TransactionDao.getInstance().getListByUserId(user.getId());
			} else {
				transactions = TransactionDao.getInstance().displayByOperation(
						user.getId(), transactionType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String showWithdraw() {
		Map session = ActionContext.getContext().getSession();
		Sysuser user = (Sysuser) session.get(LoginAction.SYSUSER);	
		this.user = user;
		
		isSuccess = 0;
		return SUCCESS;


	}

	public String withdraw() {
		Map session = ActionContext.getContext().getSession();
		user = (Sysuser) session.get(LoginAction.SYSUSER);	
		isSuccess = 0;
		userId= user.getId();
		try {
			user = SysuserDao.getInstance().getByUserId(userId);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(user!=null) {
			if(amount == null||amount == 0){
				this.addActionError("Request amount can not be empty or zero!");
				this.isSuccess = -1;
				return ERROR;
			} else if(amount > user.getCashes()){
				this.addActionError("Request amount can not larger than cash balance!");
				this.isSuccess = -1;
				return ERROR;
			} else {
				Transaction t = new Transaction();
				long a = (long)(amount * 100);
				//Date date = new Date();			
				t.setAmount(a);
				//t.setExecuteDate(date);
				t.setStatus(Transaction.TRANS_STATUS_PENDING);
				t.setTransactionType(Transaction.TRANS_TYPE_WITHDRAW);
				try {
					TransitionDay.getInstance().newTransaction(user.getId(), t);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.isSuccess = 1;
				return SUCCESS;
				
			}
			
		}
		this.addActionError("error!");
		this.isSuccess = -1;
		return ERROR;

	}

	public String showDeposit() {
	//	Map session = ActionContext.getContext().getSession();
		if (userId == null) {
			userId = 0;
		} else {
			try {
				this.user = SysuserDao.getInstance().getByUserId(userId);
			} catch (Exception e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		isSuccess = 0;
		return SUCCESS;
		
	}
	
	
	public String deposit() {
	//	Map session = ActionContext.getContext().getSession();	
		isSuccess = 0;
		
		try {
			if (userId == null) {
				userId = 0;
				isSuccess = -1;
				return ERROR;
			}else {
				user = SysuserDao.getInstance().getByUserId(userId);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if(user!=null) {
			if(amount==null||amount==0){
				this.addActionError("Request amount can not be empty or zero!");
				this.isSuccess = -1;
				return ERROR;
			} else if(amount < 0){
				this.addActionError("Amount can not smaller than zero!");
				this.isSuccess = -1;
				return ERROR;
			} else {
				Transaction t = new Transaction();
				long a = (long)(amount * 100);
				//Date date = new Date();			
				t.setAmount(a);
				//t.setExecuteDate(date);
				t.setStatus(Transaction.TRANS_STATUS_PENDING);
				t.setTransactionType(Transaction.TRANS_TYPE_DEPOSIT);
				try {
					TransitionDay.getInstance().newTransaction(user.getId(), t);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.isSuccess = 1;
				return SUCCESS;
				
			}
			
		}
		this.addActionError("error!");
		this.isSuccess = -1;
		return ERROR;
	}

		

}
