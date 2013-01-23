package com.action;

import java.text.DecimalFormat;
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
	private int isSuccess = 0;
	public String optionC="";
	public String searchKeyC;
	public String searchKeyE;



	public String customerlist() {
		if(optionC.equals("username")){
			try {
				users = SysuserDao.getInstance().getUsersByUsername(searchKeyC,0);
			} catch (Exception e) {
				e.printStackTrace();
				this.addActionError("Can't find this user!");
				isSuccess = -2;
				return SUCCESS;
			}
			return SUCCESS;
		}
		if(optionC.equals("firstname")){
			try {
				users = SysuserDao.getInstance().getUsersByFirstname(searchKeyC,0);
			} catch (Exception e) {
				e.printStackTrace();
				this.addActionError("Can't find this user!");
				isSuccess = -2;
				return SUCCESS;
			}
			return SUCCESS;
		}
		if(optionC.equals("lastname")){
			try {
				users = SysuserDao.getInstance().getUsersByLastname(searchKeyC,0);
			} catch (Exception e) {
				e.printStackTrace();
				this.addActionError("Can't find this user!");
				isSuccess = -2;
				return SUCCESS;
			}
			return SUCCESS;
		}else{
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
		
	}
	public String employeelist() {
		if(optionC.equals("username")){
			try {
				users = SysuserDao.getInstance().getUsersByUsername(searchKeyE,1);
			} catch (Exception e) {
				e.printStackTrace();
				this.addActionError("Can't find this user!");
				isSuccess = -2;
				return SUCCESS;
			}
			return SUCCESS;
		}
		if(optionC.equals("firstname")){
			try {
				users = SysuserDao.getInstance().getUsersByFirstname(searchKeyE,1);
			} catch (Exception e) {
				e.printStackTrace();
				this.addActionError("Can't find this user!");
				isSuccess = -2;
				return SUCCESS;
			}
			return SUCCESS;
		}
		if(optionC.equals("lastname")){
			try {
				users = SysuserDao.getInstance().getUsersByLastname(searchKeyE,1);
			} catch (Exception e) {
				e.printStackTrace();
				this.addActionError("Can't find this user!");
				isSuccess = -2;
				return SUCCESS;
			}
			return SUCCESS;
		}else{
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
	}

	public String createCustomer() {
		isSuccess = 0;
		if(user != null){	
			if (user.getUsername() != null && user.getFirstname() != null && user.getLastname() != null) {
				user.getUsername().trim();
				user.getFirstname().trim();
				user.getLastname().trim();
				if(!user.getUsername().equals("") && !user.getFirstname().equals("") && !user.getLastname().equals("")){
					if (checkRequired(this.user)) {
						this.addActionError("This username has already exist!");
						isSuccess = -1;
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
					user.setCash((long) (cash*100));
					user.setType(0);
					try {
						SysuserDao.getInstance().create(user);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					isSuccess = 1;
					return SUCCESS;
				}
				this.addActionError("Important information shouldn't be empty!");
				isSuccess = -1;
				return ERROR;
			}
			this.addActionError("Important information shouldn't be empty!");
			isSuccess = -1;
			return ERROR;
		}
		else return ERROR;
	}

	public String createEmployee() {
		isSuccess = 0;
		if(user != null){
			if (user.getUsername() != null && user.getFirstname() != null && user.getLastname() != null) {
				user.getUsername().trim();
				user.getFirstname().trim();
				user.getLastname().trim();
				if(!user.getUsername().equals("") && !user.getFirstname().equals("") && !user.getLastname().equals("")){
					if (checkRequired(this.user)) {
						this.addActionError("This username has already exist!");
						isSuccess = -1;
						return ERROR;
					}
					user.setPassword("111111");
					user.setAddrLine1("");
					user.setAddrLine2("");
					user.setCash(0);
					user.setCity("");
					user.setState("");
					user.setZip("");
					user.setType(1);
					try {
						SysuserDao.getInstance().create(user);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					isSuccess = 1;
					return SUCCESS;
				}
				this.addActionError("Important information shouldn't be empty!");
				isSuccess = -1;
				return ERROR;
			}
			this.addActionError("Important information shouldn't be empty!");
			isSuccess = -1;
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
		System.out.println();
		System.out.println();
		try {
			this.user = SysuserDao.getInstance().getByUserId(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String resetPassword(){
		try {
			this.user = SysuserDao.getInstance().getByUserId(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setPassword("111111");
		try {
			SysuserDao.getInstance().update(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		isSuccess = 2;
		return SUCCESS;
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
	public void setCash(double cash) {
		this.cash = cash;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public void setSearchKeyC(String searchKeyC) {
		this.searchKeyC = searchKeyC;
	}
}
