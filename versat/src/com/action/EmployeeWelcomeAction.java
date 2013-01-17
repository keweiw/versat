package com.action;

import java.util.Map;

import com.dao.SysuserDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Sysuser;

public class EmployeeWelcomeAction extends ActionSupport{
	public static final String SYSUSER = "SYSUSER";
	private Sysuser user;
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;
	public void setUser(Sysuser user){
		this.user=user;
	}
	public Sysuser getUser(){
		return user;
	}
	public String welcome(){
		Map session = ActionContext.getContext().getSession();
		user=(Sysuser) session.get(this.SYSUSER);
		return SUCCESS;
	}
	
	public String getoldPassword() {
		return oldPassword;
	}

	public void setoldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getnewPassword() {
		return newPassword;
	}

	public void setnewPassword(String newpassword) {
		this.newPassword = newPassword;
	}

	public String getconfirmPassword() {
		return confirmPassword;
	}

	public void setconfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public String changePassword(){
		Map session = ActionContext.getContext().getSession();
		user = (Sysuser) session.get(LoginAction.SYSUSER);
		if (oldPassword != null && newPassword != null && confirmPassword != null) {
			oldPassword.trim();
			newPassword.trim();
			confirmPassword.trim();
			if(!newPassword.equals(confirmPassword)){
				this.addActionError("Confirm password is not same as new password!");
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
				this.addActionError("Incorrect Oldpassword!");
				return ERROR;
			}else{
				changePswUser.setPassword(oldPassword);
				try {
					SysuserDao.getInstance().update(changePswUser);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return SUCCESS;
			}			
		}
		this.addActionError("Input shouldn't be empty.");
		return ERROR;
	}
}