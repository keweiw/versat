package com.action;

import java.util.ArrayList;


import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Sysuser;
import com.pojo.Transaction;


public class AccountAction extends ActionSupport {
	public Integer userId;
	public ArrayList<Sysuser> users;

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
		return SUCCESS;
	}
	public String employeelist() {
		
	    return SUCCESS;
	
	}
	public String createcustomer() {
		
		return SUCCESS;
	}
	
	public String createemployee() {
		
		return SUCCESS;
	}
	
	public String viewaccount() {
	
	    return SUCCESS;
	
	}
	
	
}
