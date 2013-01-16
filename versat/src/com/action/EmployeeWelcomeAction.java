package com.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Sysuser;

public class EmployeeWelcomeAction extends ActionSupport{
	public static final String SYSUSER = "SYSUSER";
	private Sysuser user;
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

}
