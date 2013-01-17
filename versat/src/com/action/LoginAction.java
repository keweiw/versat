package com.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.SysuserDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Sysuser;

public class LoginAction extends ActionSupport {
	public static final String USER_NAME = "NAMENAME";
	public static final String SYSUSER = "SYSUSER";
	public static final String USER_TYPE = "USERTYPE";
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String index() {
		Map session = ActionContext.getContext().getSession();
		String username = (String) session.get(LoginAction.USER_NAME);
		if (username != null) {
			return INPUT;
		}
		return SUCCESS;
	}

	public String login() {
		Map session = ActionContext.getContext().getSession();
		if (username != null && password != null) {
			username.trim();
			password.trim();
			Sysuser loginUser = null;
			try {
				loginUser = SysuserDao.getInstance().getByUsername(username);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (loginUser != null && loginUser.getPassword().equals(password)) {
				session.put(LoginAction.USER_TYPE, loginUser.getType());
				session.put(LoginAction.SYSUSER, loginUser);
				session.put(LoginAction.USER_NAME, loginUser.getFirstname()
						+ ", " + loginUser.getLastname());
				if (loginUser.getType() == Sysuser.USER_TYPE_COSTOMER) {
					return SUCCESS;
				} else {
					return INPUT;
				}
			}
		}
		this.addActionError("Incorrect Username or Password.");
		return ERROR;
	}
	
	public String logout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.invalidate();
		return SUCCESS;
	}
	
	public String error() {
		return SUCCESS;
	}
	
	public String noauth() {
		return SUCCESS;
	}
}
