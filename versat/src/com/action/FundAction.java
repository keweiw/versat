package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Sysuser;

public class FundAction extends ActionSupport{
	private String name;
	private String symbol;
	
	public String getName() {
		return name;
	}
	
	public void setName() {
		this.name = name;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol() {
		this.symbol = symbol;
	}
	
	public String creatFund() {
		return SUCCESS;
	}
	
	public String create(){
		name.trim();
		symbol.trim();
		if( name!=null && symbol != null){
			return SUCCESS;
		} else {
			return INPUT;
		}
	}
	
	public String showfund() {
		return SUCCESS;
	}
}
