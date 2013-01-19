package com.action;

import java.util.ArrayList;


import com.dao.SysuserDao;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Sysuser;
import com.pojo.Transaction;


public class AccountAction extends ActionSupport {
	public Integer userId;
	private ArrayList<Sysuser> users;
	public Sysuser user;
	public double cash;

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
	
	public Sysuser getUser() {
		return user;
	}

	public void setUser(Sysuser user) {
		this.user = user;
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
		if(user != null){	
			if (user.getUsername() != null && user.getFirstname() != null && user.getLastname() != null) {
				System.out.print(user.getLastname());
				user.getUsername().trim();
				user.getFirstname().trim();
				user.getLastname().trim();
				if (checkRequired(this.user)) {
					this.addActionError("This username has already exist!");
					return ERROR;
				}
				if(user.getAddrLine1() != null)
					user.getAddrLine1().trim();
				if(user.getAddrLine2() != null)
					user.getAddrLine2().trim();
				if(user.getCity() != null)
					user.getCity().trim();
				if(user.getState() != null)
					user.getState().trim();
				if(user.getZip() != null)
					user.getZip().trim();
				user.setPassword("111111");
				user.setType(0);
				try {
					SysuserDao.getInstance().create(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return SUCCESS;
			}
			this.addActionError("Important information shouldn't be empty!");
			return ERROR;
		}
		else return ERROR;
	}

	public String createemployee() {
		if(user != null){
			if (user.getUsername() != null && user.getFirstname() != null && user.getLastname() != null) {
				user.getUsername().trim();
				user.getFirstname().trim();
				user.getLastname().trim();
				if (checkRequired(this.user)) {
					this.addActionError("This username has already exist!");
					return ERROR;
				}
				user.setPassword("111111");
				user.setCash((long) (cash*100));
				user.setType(1);
				try {
					SysuserDao.getInstance().create(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return SUCCESS;
			}
			this.addActionError("Important information shouldn't be empty!");
			return ERROR;
		}
		else return ERROR;
	}
	
	private boolean checkRequired(Sysuser u) {
		Sysuser finduser = null;
		try {
			finduser = SysuserDao.getInstance().getByUsername(user.getUsername());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(finduser != null) return true;
		else return false;
	}
	
	public String viewAccount(){			//just take out a user Instance by ID
		try {
			this.user = SysuserDao.getInstance().getByUserId(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
