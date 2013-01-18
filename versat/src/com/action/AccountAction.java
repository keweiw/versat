package com.action;

import java.util.ArrayList;


import com.dao.SysuserDao;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Sysuser;
import com.pojo.Transaction;


public class AccountAction extends ActionSupport {
	public Integer userId;
	public ArrayList<Sysuser> users;
	public Sysuser user;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public ArrayList<Sysuser> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<Sysuser> users) {
		this.users = users;
	}

	
	public String customerlist() {
		try {
			this.users = SysuserDao.getInstance().getUsersByType(Sysuser.USER_TYPE_COSTOMER);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (this.users == null) {
			this.users = new ArrayList<Sysuser>();
		}
		return SUCCESS;
	}
	public String employeelist() {
		try {
			this.users = SysuserDao.getInstance().getUsersByType(Sysuser.USER_TYPE_EMPLOYEE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (this.users == null) {
			this.users = new ArrayList<Sysuser>();
		}
	    return SUCCESS;
	
	}
	public String createcustomer() {
		if (!checkRequired(this.user)) {
			return ERROR;
		}
		else {
			
		}
		return SUCCESS;
	}
	
	public String createemployee() {
		
		return SUCCESS;
	}
	
	public String viewaccount() {
	
	    return SUCCESS;
	
	}
	
	private boolean checkRequired(Sysuser u) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
